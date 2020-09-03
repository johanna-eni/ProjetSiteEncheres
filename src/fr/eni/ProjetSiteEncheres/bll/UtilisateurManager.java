package fr.eni.ProjetSiteEncheres.bll;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bo.Utilisateur;
import fr.eni.ProjetSiteEncheres.dal.DAOFactory;
import fr.eni.ProjetSiteEncheres.dal.UtilisateurDAO;
/**
 * 
 *  @author jrigollo2020 et VincentGenouel
 *classe vï¿½rifiant les information utilisateur et renvoyant ï¿½ la dal pour insertion en base
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
			
//vÃ©rif pseudo(caractÃ¨re alphanumÃ©rique et non existance en base) et mot de passe
			if (this.validerPseudo(pseudo) && this.valdierEmail(email) && this.validerMotDePasse(mot_de_passe, confirmation)) {
				
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
			else {
				utilisateur= null;
				System.out.println("info inccorecte");
			}
			
		}catch (BusinessException e) {
			System.out.println("impossible d'insï¿½rer l'utilisateur");
		}
		return utilisateur;
	}

		

	private boolean valdierEmail(String email) {

		boolean ok = false;
		//vÃ©rification de la non existance d'un email doublon
		try {
			if(this.utilisateurDAO.selectByEmail(email)) {
			System.out.println("Email déja existant en base");
			ok = false;
			}
			else {
				ok = true;
			}
		}
		catch (BusinessException e) {
		}
		return ok; 
		}

	private boolean validerPseudo(String pseudo) {
		
//vÃ©rification caractÃ¨re alphanumÃ©rique du pseudo
		
		boolean ok = false;
		if(pseudo.matches("\\p{Alnum}")){
			System.out.println("pseudo error");
			ok =false;
		}
		
//vÃ©rification de la non existance d'un pseudo doublon
		
			try {
				if(this.utilisateurDAO.selectByPseudo(pseudo) != null) {
				System.out.println("Pseudo déja existant en base");
				ok = false;
				}
				else {
					ok = true;
				}
			}
			catch (BusinessException e) {
			}
			return ok; 
	}

	private boolean validerMotDePasse(String mot_de_passe, String confirmation) {
		if(!mot_de_passe.equals(confirmation)) {
			System.out.println("mdp error");
			return false;
		}
		return true;
	}

//vÃ©rification que le pseudo existe en base et que le mot de passe y correspond et retourne un utilisateur
	public Utilisateur verifPseudoMotDePasse(String pseudo, String mot_de_passe) {
		Utilisateur utilisateur = new Utilisateur();
		
		try {
			if (this.utilisateurDAO.selectByPseudo(pseudo) != null) {
				
				if (this.utilisateurDAO.verificationCouplePseudoMdp(pseudo, mot_de_passe) != null) {
					utilisateur = this.utilisateurDAO.verificationCouplePseudoMdp(pseudo, mot_de_passe);
				}
				else {
					System.out.println("vÃ©rif no OK (manager)");
					utilisateur = null;
				}
			}
			else {
				utilisateur = null;
				System.out.println("pseudo inhextitant");
			}
		}
		catch (BusinessException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	public Utilisateur modifierUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe_actuel, String confirmation,
			String nvxMotDePasse, String premierPseudo) 
	{
		Utilisateur utilisateurModifie = new Utilisateur();
		boolean ok = false;
		try {
		System.out.println("vérif BLL" + nvxMotDePasse);	
		
		if(this.verifPseudoMotDePasse(premierPseudo, mot_de_passe_actuel) != null) {
			
			if(this.validerPseudo(pseudo) && this.valdierEmail(email) && this.validerMotDePasse(nvxMotDePasse, confirmation)) 
			{
				utilisateurModifie.setPremierPseudo(premierPseudo);
				utilisateurModifie.setPseudo(pseudo);
				utilisateurModifie.setPrenom(prenom);
				utilisateurModifie.setNom(nom);
				utilisateurModifie.setEmail(email);
				utilisateurModifie.setTelephone(telephone);
				utilisateurModifie.setRue(rue);
				utilisateurModifie.setCodePostal(code_postal);
				utilisateurModifie.setVille(ville);
				utilisateurModifie.setNvxMotDePasse(nvxMotDePasse);
			
				if(this.utilisateurDAO.modifyUtilisateur(utilisateurModifie) != null) {
					System.out.println("BLL OK");
					utilisateurModifie.setMotDePasse(nvxMotDePasse);
					ok = true;
				}
			
			}
			else {
				System.out.println("no ok");
				ok = false;
			}
		}
		}
		catch(BusinessException e) {
			
		}
		return utilisateurModifie;
	}

	public boolean supprimerUtilisateur(int no_utilisateur) {
		
		boolean ok = false;
		if(no_utilisateur >0) {
			try {
				if(this.utilisateurDAO.delete(no_utilisateur)) {
					System.out.println(no_utilisateur);
					ok = true;
				}
			}
			catch(BusinessException e) {
				e.printStackTrace();
			}
		}
		return ok;
	}
}
