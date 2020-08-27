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
		
		this.validerMotDePasse(mot_de_passe, confirmation);
		this.validerPseudo(pseudo);
		
		try{
			utilisateur = new Utilisateur();
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
		catch(BusinessException e)
		{
			System.out.println("error insert");
		}
		return utilisateur;
	}

	private void validerPseudo(String pseudo) {
		if(pseudo.matches("\\p{Alnum}")){
			System.out.println("pseudo error");;
		}
		
	}

	private void validerMotDePasse(String mot_de_passe, String confirmation) {
		if(!mot_de_passe.equals(confirmation)) {
			System.out.println("mdp error");;
		}
		
	}
	
}
