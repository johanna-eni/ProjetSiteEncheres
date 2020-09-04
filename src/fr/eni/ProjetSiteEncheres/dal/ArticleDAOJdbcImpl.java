package fr.eni.ProjetSiteEncheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bo.ArticleVendu;

public class ArticleDAOJdbcImpl implements ArticleDAO{

	private static final String INSERT_ARTICLE = "INSERT into ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) values(?,?,?,?,?,?,?)";
	
	
	
	
	@Override
	public boolean insert(ArticleVendu articleVendu) throws BusinessException {
		boolean ok = false;
		try(Connection cnx = ConnectionProvider.getConnection()){
			
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;

					pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
					System.out.println("(ArticleDAOJdbcImpl) no categorie dal : " + articleVendu.getCategorie().getNoCategorie());
					pstmt.setString(1, articleVendu.getNomArticle());
					pstmt.setString(2, articleVendu.getDescription());
					pstmt.setDate(3,  Date.valueOf(articleVendu.getDateDebutEncheres()));
					pstmt.setDate(4, Date.valueOf(articleVendu.getDateFinEncheres()));
					pstmt.setInt(5, articleVendu.getMiseAPrix());
					pstmt.setInt(6, articleVendu.getNoUtilisateur());
					pstmt.setInt(7, articleVendu.getCategorie().getNoCategorie());
					
					
					pstmt.executeUpdate();
					rs = pstmt.getGeneratedKeys();
					
					if(rs.next()) {
						articleVendu.setNoArticle(rs.getInt(1));
					}
					System.out.println(articleVendu);
						rs.close();
						pstmt.close();
						cnx.commit();
						ok = true;
					}
					catch(Exception e) {
						System.out.println("A");
						e.printStackTrace();
						throw e;
					}
				}
			
		
		
		catch (Exception e) {
			System.out.println("(ArticleDAOJdbcImpl) DAL - connection impossible");
			e.printStackTrace();
		}
		return ok;
	}
}
