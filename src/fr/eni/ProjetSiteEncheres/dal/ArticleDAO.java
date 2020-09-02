package fr.eni.ProjetSiteEncheres.dal;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bo.ArticleVendu;

public interface ArticleDAO {
	public boolean insert(ArticleVendu articleVendu) throws BusinessException;
}
