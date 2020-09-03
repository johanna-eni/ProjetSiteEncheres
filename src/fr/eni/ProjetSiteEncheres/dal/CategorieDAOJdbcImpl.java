package fr.eni.ProjetSiteEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.ProjetSiteEncheres.BusinessException;

public class CategorieDAOJdbcImpl implements CategorieDAO {
	
	private static final String SELECT_LIBELLE_INTO_CATEGORIE = "SELECT no_categorie from CATEGORIES where libelle = ?";

	@Override
	public int select(String libelle) throws BusinessException {
		
		int no_categorie = 0;
		
		try(Connection cnx = ConnectionProvider.getConnection()) 
		{
			try
			{
				PreparedStatement pstmt;
				ResultSet rs;

					pstmt = cnx.prepareStatement(SELECT_LIBELLE_INTO_CATEGORIE);
					
					pstmt.setString(1, libelle);
					rs = pstmt.executeQuery();
					
					if (rs.next()) {
						return no_categorie;
					}
					
			}
			catch (SQLException r)
			{
					r.printStackTrace();
			}
		}
		catch (Exception e){
			
		}
		return 0;
	}

}
