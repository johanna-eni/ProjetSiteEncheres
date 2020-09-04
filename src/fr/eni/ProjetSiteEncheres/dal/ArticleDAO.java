package fr.eni.ProjetSiteEncheres.dal;

import java.util.Collection;
import java.util.List;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bo.ArticleVendu;
import fr.eni.ProjetSiteEncheres.bo.Retrait;

public interface ArticleDAO {
	public boolean insert(ArticleVendu articleVendu) throws BusinessException;

	public Collection<ArticleVendu> selectArticles(int no_categorie) throws BusinessException;

	public boolean insertRetrait(String rue, String code_postal, String ville, int no_utilisateur) throws BusinessException;

}
