package fr.eni.ProjetSiteEncheres.bll;

import java.util.Collection;
import java.util.List;

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



	public boolean insertArticle(ArticleVendu nouvelArticle) {
		
		boolean ok = false;
		try {
			//vérif article est en caractère alphanumérique
			ArticleVendu articleVendu = new ArticleVendu();
			if(nouvelArticle.getNomArticle().matches("\\p{Alnum}")){
				System.out.println("(ArticleManager) nomArticle non valable");
				ok = false;
			}
				else {
					articleVendu.setNomArticle(nouvelArticle.getNomArticle());
					articleVendu.setDescription(nouvelArticle.getDescription());
					
					
					//Création de l'objet Categorie
					//Inclusion de la categorie à articleVendu
					articleVendu.setCategorie(nouvelArticle.getCategorie());
					
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
					//information de retrait;
					Retrait retrait = new Retrait(nouvelArticle.getRetrait().getRue(),nouvelArticle.getRetrait().getCodePostal(), nouvelArticle.getRetrait().getVille());
					articleVendu.setRetrait(retrait);
					System.out.println("(ArticleManager) no_categorie avant insert en base :" + articleVendu.getCategorie().getNoCategorie());
					System.out.println(articleVendu);
					
					if (this.articleDAO.insert(nouvelArticle)) {
						ok = true;
					}
					else {
						System.out.println("(ArticleManager) l'article n'a pas pu etre inséré");
						ok = false;
					}
				}
		}
		catch (BusinessException e) {
			e.printStackTrace();
		}
		return ok;
	}



	public Collection<ArticleVendu> selectArticles(int no_categorie) throws BusinessException {
		Collection<ArticleVendu> listeArticlesChoisis = null;
		if(no_categorie != 0) {
			listeArticlesChoisis = this.articleDAO.selectArticles(no_categorie);
		}
		return listeArticlesChoisis;
		
		
	}



	public boolean insertRetrait(String retrait_rue, String retrait_c_p, String retrait_ville, int no_utilisateur){
		boolean ok = false;
		try {
			if(this.articleDAO.insertRetrait(retrait_rue, retrait_c_p, retrait_ville, no_utilisateur)) {
				ok = true;
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok;
	}
}
	

