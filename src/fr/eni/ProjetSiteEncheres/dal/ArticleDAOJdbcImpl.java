package fr.eni.ProjetSiteEncheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bo.ArticleVendu;
import fr.eni.ProjetSiteEncheres.bo.Retrait;

public class ArticleDAOJdbcImpl implements ArticleDAO{

	private static final String INSERT_ARTICLE = "INSERT into ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) values(?,?,?,?,?,?,?)";
	private static final String SELECT_ARTICLES_BY_NO_CATEGORIE = "SELECT * FROM ARTICLES_VENDUS where no_categorie = ?";
	private static final String INSERT_RETRAIT = "INSERT into RETRAITS (no_article, rue, code_postal, ville) values (?,?,?,?)";
	
	
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




	@Override
	public Collection<ArticleVendu> selectArticles(int no_categorie) {
		
		Collection<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();
		
		try (Connection cnx = ConnectionProvider.getConnection()){
		
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				
				pstmt = cnx.prepareStatement(SELECT_ARTICLES_BY_NO_CATEGORIE);
				
				pstmt.setInt(1, no_categorie);
				
				rs = pstmt.executeQuery();
				
				ArticleVendu article = null;
				while(rs.next()) {
					article = new ArticleVendu();
				    article.setNoArticle(rs.getInt(1));
				    article.setNomArticle(rs.getString(2));
				    article.setDescription(rs.getString(3));
				    article.setDateDebutEncheres(rs.getDate(4).toLocalDate());
				    article.setDateFinEncheres(rs.getDate(5).toLocalDate());
				    article.setMiseAPrix(rs.getInt(6));
				    article.setPrixVente(rs.getInt(7));
				    article.setNoUtilisateur(rs.getInt(8));
				    
				   listeArticles.add( article );
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return listeArticles;
	}




	@Override
	public boolean insertRetrait(String rue, String code_postal, String ville, int no_utilisateur) throws BusinessException {
		boolean ok = false;
		try(Connection cnx = ConnectionProvider.getConnection()){
			
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;

					pstmt = cnx.prepareStatement(INSERT_RETRAIT);
					pstmt.setInt(1, no_utilisateur);
					pstmt.setString(2, rue);
					pstmt.setString(3, code_postal);
					pstmt.setString(4, ville);
					
					
					pstmt.executeUpdate();
					
						pstmt.close();
						cnx.commit();
						ok = true;
					}
					catch(Exception e) {
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
