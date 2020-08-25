package fr.eni.ProjetSiteEncheres.dal;

public class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO() {

	return new UtilisateurDAOJdbcImpl();
	}
}
