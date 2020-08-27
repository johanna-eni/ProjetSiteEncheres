package fr.eni.ProjetSiteEncheres.bll;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bo.Utilisateur;
import fr.eni.ProjetSiteEncheres.dal.DAOFactory;
import fr.eni.ProjetSiteEncheres.dal.UtilisateurDAO;
/**
 * 
 * @author jrigollo2020
 *classe vérifiant les information utilisateur et renvoyant à la dal pour insertion en base
 */
public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		this.utilisateurDAO=DAOFactory.getUtilisateurDAO();
	}
	
	public Utilisateur ajouterUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe, String confirmation) throws BusinessException 
	{
		
		
		Utilisateur utilisateur = null;
		
		try {
			utilisateur = new Utilisateur();
			
			if  (this.validerPseudo(pseudo) && this.validerMotDePasse(mot_de_passe, confirmation)) {
				
				utilisateur.setPseudo(pseudo);
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);
				utilisateur.setEmail(email);
				utilisateur.setTelephone(telephone);
				utilisateur.setRue(rue);
				utilisateur.setCodePostal(code_postal);
				utilisateur.setVille(ville);
				utilisateur.setMotDePasse(mot_de_passe);
				
				this.utilisateurDAO.insert(utilisateur);
			}
			
		}catch (BusinessException e) {
			
			System.out.println("impossible d'insérer l'utilisateur");
		}
		return utilisateur;
	}

		
	
	private boolean validerPseudo(String pseudo) {
		
		//vérification caractères alphanumérique du pseudo
		if(pseudo.matches("\\p{Alnum}")){
			System.out.println("pseudo error");
			return false;
			}
		//vérification de la non existance d'un pseudo doublon
			try {
				if(this.utilisateurDAO.selectByPseudo(pseudo) != null) {
				System.out.println("Pseudo déjà existant en base");
				return false;
				}
			} catch (BusinessException e) {
			}
			return true; 
			
	}

	private boolean validerMotDePasse(String mot_de_passe, String confirmation) {
		if(!mot_de_passe.equals(confirmation)) {
			System.out.println("mdp error");
			return false;
		}
		return true;
	}
	
}
