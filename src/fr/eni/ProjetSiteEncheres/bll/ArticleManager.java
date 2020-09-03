package fr.eni.ProjetSiteEncheres.bll;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bo.ArticleVendu;
import fr.eni.ProjetSiteEncheres.bo.Categorie;
import fr.eni.ProjetSiteEncheres.bo.Retrait;
import fr.eni.ProjetSiteEncheres.dal.ArticleDAO;
import fr.eni.ProjetSiteEncheres.dal.DAOFactory;

public class ArticleManager {

	private ArticleDAO articleDAO;
	
	
	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}

	
	public int attributionNoCategorie(String libelle) {
		
		int noCategorie = 0;
		//On fait corespondre une catégorie avec un numero de categorie
		switch (libelle) {
		case "bricolage":
			noCategorie = 1;
		case "jardinage":
			noCategorie = 2;
		case "equipement_maison":
			noCategorie = 3;
		case "decoration":
			noCategorie = 4;
		}
		
		return noCategorie;
	}
	
	

	public boolean insertArticle(ArticleVendu nouvelArticle) {
		
		boolean ok = false;
		try {
			//vérif article est en caractère alphanumérique
			ArticleVendu articleVendu = new ArticleVendu();
			if(nouvelArticle.getNomArticle().matches("\\p{Alnum}")){
				System.out.println("nomArticle non valable");
				ok = false;
			}
				else {
					System.out.println("nomArticle ok");
					articleVendu.setNomArticle(nouvelArticle.getNomArticle());
					articleVendu.setDescription(nouvelArticle.getDescription());
					
					
					//retourne le no_categorie correspondant au libelle
					int no_categorie = (this.attributionNoCategorie(nouvelArticle.getCategorie().getLibelle()));
					//Création de l'objet Categorie 
					Categorie categorie = new Categorie(no_categorie, nouvelArticle.getCategorie().getLibelle());
					//Inclusion de la categorie à articleVendu
					articleVendu.setCategorie(categorie);
					
					//etatVente à 0 (vente en cours) à 1 (vente fini)
					articleVendu.setEtatVente(0);
					//numero utilisateur
					articleVendu.setNoUtilisateur(nouvelArticle.getNoUtilisateur());
					//prix de vente (mise à prix)
					articleVendu.setMiseAPrix(nouvelArticle.getMiseAPrix());
					//dates début enchère
					articleVendu.setDateDebutEncheres(nouvelArticle.getDateDebutEncheres());
					//date fin enchère
					articleVendu.setDateFinEncheres(nouvelArticle.getDateFinEncheres());	
					//information de retrait
					
					Retrait retrait = new Retrait(nouvelArticle.getRetrait().getRue(),nouvelArticle.getRetrait().getCodePostal(), nouvelArticle.getRetrait().getVille());
					articleVendu.setRetrait(retrait);
					System.out.println(articleVendu);
					
					if (this.articleDAO.insert(nouvelArticle)) {
						ok = true;
					}
					else {
						ok = false;
					}
				}
		}
		catch (BusinessException e) {
			System.out.println("BLL - l'article n'a pas pu etre inséré");
			e.printStackTrace();
		}
		return ok;
	}
}
	

