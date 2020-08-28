package fr.eni.ProjetSiteEncheres.bll;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bo.Utilisateur;
import fr.eni.ProjetSiteEncheres.dal.DAOFactory;
import fr.eni.ProjetSiteEncheres.dal.UtilisateurDAO;
/**
 * 
 *  @author jrigollo2020 et VincentGenouel
 *classe v�rifiant les information utilisateur et renvoyant � la dal pour insertion en base
 */
public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
//ajout d'un utilisateur (appel DAL pour insertion en base).
	public Utilisateur ajouterUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe, String confirmation) throws BusinessException 
	{
		
		Utilisateur utilisateur = null;

		try {
			utilisateur = new Utilisateur();
			
//vérif pseudo(caractère alphanumérique et non existance en base) et mot de passe
			if (this.validerPseudo(pseudo) && this.validerMotDePasse(mot_de_passe, confirmation)) {
				
				utilisateur.setPseudo(pseudo);
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);
				utilisateur.setEmail(email);
				utilisateur.setTelephone(telephone);
				utilisateur.setRue(rue);
				utilisateur.setCodePostal(code_postal);
				utilisateur.setVille(ville);
				utilisateur.setMotDePasse(mot_de_passe);
				
//tentative d'insertion en base
				this.utilisateurDAO.insert(utilisateur);
			}
			
		}catch (BusinessException e) {
			System.out.println("impossible d'ins�rer l'utilisateur");
		}
		return utilisateur;
	}

		

	private boolean validerPseudo(String pseudo) {
		
//vérification caractère alphanumérique du pseudo
		if(pseudo.matches("\\p{Alnum}")){
			System.out.println("pseudo error");
			return false;
			}
//vérification de la non existance d'un pseudo doublon
			try {
				if(this.utilisateurDAO.selectByPseudo(pseudo) != null) {
				System.out.println("Pseudo d�j� existant en base");
				return false;
				}
			}
			catch (BusinessException e) {
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

//vérification que le pseudo existe en base et que le mot de passe y correspond et retourne un utilisateur
	public Utilisateur verifPseudoMotDePasse(String pseudo, String mot_de_passe) {
		Utilisateur utilisateur = new Utilisateur();
		
		try {
			if (this.utilisateurDAO.verificationCouplePseudoMdp(pseudo, mot_de_passe) != null) {
				utilisateur = this.utilisateurDAO.verificationCouplePseudoMdp(pseudo, mot_de_passe);
				System.out.println("vérif ok (manager)");
				return utilisateur;
			}
			else {
				System.out.println("vérif no OK (manager)");
				return null;
			}
		}
		catch (BusinessException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
}
