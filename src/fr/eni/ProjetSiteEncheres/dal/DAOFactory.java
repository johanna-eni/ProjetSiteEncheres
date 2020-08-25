package fr.eni.ProjetSiteEncheres.dal;

public class DAOFactory {
	
	public static UtilisateurDAO getListeUtilisateurDAO() {

	return new UtilisateurDAOJdbcImpl();
	}
}
