package fr.eni.ProjetSiteEncheres.dal;

import fr.eni.ProjetSiteEncheres.bo.Utilisateur;
import fr.eni.ProjetSiteEncheres.dal.UtilisateurDAOJdbcImpl;

public class Main {

	public static void main(String[] args) {

		UtilisateurDAOJdbcImpl utilisateurDAO = new UtilisateurDAOJdbcImpl();
		Utilisateur george = new Utilisateur("georgeP", "poire", "george", "email", "0674657643", "rue casper", "67567", "thaon", "mdp");
<<<<<<< HEAD
			}
=======
		utilisateurDAO.insert(george);
		
	}
>>>>>>> 3be4e8f74dde7bd4492c70380226b2a1eeb25e26

}
