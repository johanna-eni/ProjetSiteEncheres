package fr.eni.ProjetSiteEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bo.ArticleVendu;

public class ArticleDAOJdbcImpl implements ArticleDAO{

	private static final String INSERT_ARTICLE = "INSERT into ARTICLES_VENDUS (nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_utilisateur, no_categorie) values (?,?,?,?,?,?,?)";

	@Override
	public void insert(ArticleVendu nouvelArticle) throws BusinessException {
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;

					pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
					
					pstmt.setString(1, nouvelArticle.getNomArticle());
					pstmt.setString(2, nouvelArticle.getDescription());
					pstmt.setDate(3, nouvelArticle.getDateDebutEncheres());
					pstmt.setDate(4, nouvelArticle.getDateFinEncheres());
					pstmt.setInt(5, nouvelArticle.getMiseAPrix());
					pstmt.setInt(6, nouvelArticle.getCategorie().getNoCategorie());
					
					
			}
			catch(SQLException e) {
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("DAL - connection impossible");
			e.printStackTrace();
		}
		
	}

}
