package fr.eni.ProjetSiteEncheres.dal;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bo.Utilisateur;


/**
 * 
 * @author zince
 * interface contenant les méthodes
 */
public interface UtilisateurDAO {
	public void insert(Utilisateur utilisateur) throws BusinessException;
	public void delete(int noUtilisateur) throws BusinessException;
	public Utilisateur selectByPseudo(String pseudo) throws BusinessException;
	public Utilisateur verificationCouplePseudoMdp(String pseudo, String mot_de_passe) throws BusinessException;
	public boolean selectByEmail(String email) throws BusinessException;
	public void modifyUtilisateur(Utilisateur utilisateurModifie) throws BusinessException;
}
