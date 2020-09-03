package fr.eni.ProjetSiteEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.ProjetSiteEncheres.BusinessException;

public class CategorieDAOJdbcImpl implements CategorieDAO {
	
	private static final String SELECT_LIBELLE_INTO_CATEGORIE = "SELECT * FROM CATEGORIES where libelle = ?";

	@Override
	public int select(String libelle) throws BusinessException {
		
		int no_categorie = 0;
		
		try(Connection cnx = ConnectionProvider.getConnection()) 
		{
			try
			{
				PreparedStatement pstmt;
				ResultSet rs;

				pstmt = cnx.prepareStatement(SELECT_LIBELLE_INTO_CATEGORIE, PreparedStatement.RETURN_GENERATED_KEYS);
				
				pstmt.setString(1, libelle);
				pstmt.executeQuery();
				rs = pstmt.getGeneratedKeys();
					
				if (rs.next()) {
					no_categorie = rs.getInt(1);
				}
			}
			catch (SQLException r)
			{
					r.printStackTrace();
			}
		}
		catch (Exception e){
			
		}
		return no_categorie;
	}

}
