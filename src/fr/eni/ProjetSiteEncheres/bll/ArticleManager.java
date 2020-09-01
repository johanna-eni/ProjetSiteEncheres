package fr.eni.ProjetSiteEncheres.bll;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bo.ArticleVendu;
import fr.eni.ProjetSiteEncheres.bo.Categorie;
import fr.eni.ProjetSiteEncheres.dal.ArticleDAO;
import fr.eni.ProjetSiteEncheres.dal.DAOFactory;

public class ArticleManager {

	private ArticleDAO articleDAO;
	
	
	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}

	
	public int attributionNoCategorie(String nomCategorie) {
		
		//On fait corespondre une catégorie avec un numero de categorie
		switch (nouvelArticle.getCategorie().getLibelle()) {
		case "bricolage":
			articleVendu.getCategorie().setNoCategorie(1);
			break;
		case "jardinage":
			articleVendu.getCategorie().setNoCategorie(2);
			break;
		case "equipement_maison":
			articleVendu.getCategorie().setNoCategorie(3);
			break;
		case "decoration":
			articleVendu.getCategorie().setNoCategorie(4);
			break;
		default:
			System.out.println("Aucune catégorie n'est renseigné");
			break;
		}

	
	

	public ArticleVendu insertArticle(ArticleVendu nouvelArticle) {
		
		try {
			//vérif article est en caractère alphanumérique
			ArticleVendu articleVendu = new ArticleVendu();
			if(nouvelArticle.getNomArticle().matches("\\p{Alnum}")){
				System.out.println("nomArticle non valable");
			}
				else {
					articleVendu.setNomArticle(nouvelArticle.getNomArticle());
					
					articleVendu.setDescription(nouvelArticle.getDescription());
					
					
						
						
						
				}
		
			
			this.articleDAO.insert(nouvelArticle);
		
		catch (BusinessException e) {
			System.out.println("BLL - l'article n'a pas pu etre inséré");
			e.printStackTrace();
		}
		
		
		
	}
	
	
	

