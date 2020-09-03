package fr.eni.ProjetSiteEncheres.dal;

import fr.eni.ProjetSiteEncheres.BusinessException;

public interface CategorieDAO {

	public int select(String libelle) throws BusinessException;
}
