package fr.eni.ProjetSiteEncheres.bll;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bo.ArticleVendu;
import fr.eni.ProjetSiteEncheres.dal.ArticleDAO;
import fr.eni.ProjetSiteEncheres.dal.DAOFactory;

public class ArticleManager {

	private ArticleDAO articleDAO;
	
	
	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}


	public void insertArticle(ArticleVendu nouvelArticle) {
		
		try {
			if(nouvelArticle.getCategorie().equals("Jardinage")) {
				nouvelArticle.setNoCategorie(3);
			}
			
			this.articleDAO.insert(nouvelArticle);
		}
		catch (BusinessException e) {
			System.out.println("BLL - l'article n'a pas pu etre inséré");
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	
}
