package fr.eni.ProjetSiteEncheres.dal;

public class DAOFactory {
	
//Créer une méthode qui instancie utilisateurDAOJdbcImp
	public static UtilisateurDAO getUtilisateurDAO() {

		return new UtilisateurDAOJdbcImpl();
	}
}
