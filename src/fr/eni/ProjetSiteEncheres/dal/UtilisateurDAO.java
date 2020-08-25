package fr.eni.ProjetSiteEncheres.dal;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bo.Utilisateur;

public interface UtilisateurDAO {
	public void insert(Utilisateur utilisateur) throws BusinessException;
	
	/*public void delete(int noUtilisateur) throws BusinessException;
	public List<ListeUtilisateur> selectAll () throws BusinessException;
	public ListeUtilisateur selectByNoUtilisateur(int noUtilisateur) throws BusinessException;*/
	
}
