package fr.eni.ProjetSiteEncheres.bll;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.dal.CategorieDAO;
import fr.eni.ProjetSiteEncheres.dal.DAOFactory;

public class CategorieManager {

	private CategorieDAO categorieDAO;
	
	public CategorieManager() {
		this.categorieDAO = DAOFactory.getCategorieDAO();
	}

	public int recupNoCategorie(String libelle) {
		int no_categorie = 1;
		try {
			no_categorie = this.categorieDAO.select(libelle);
		}
		catch (BusinessException e) {
			e.printStackTrace();
		}
		return no_categorie;
	}
}
