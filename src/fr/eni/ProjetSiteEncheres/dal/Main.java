package fr.eni.ProjetSiteEncheres.dal;

import fr.eni.ProjetSiteEncheres.bo.Utilisateur;
import fr.eni.ProjetSiteEncheres.dal.UtilisateurDAOJdbcImpl;

public class Main {

	public static void main(String[] args) {

		UtilisateurDAOJdbcImpl utilisateurDAO = new UtilisateurDAOJdbcImpl();
		Utilisateur george = new Utilisateur("georgeP", "poire", "george", "email", "0674657643", "rue casper", "67567", "thaon", "mdp");
		utilisateurDAO.insert(george);
		
	}

}
