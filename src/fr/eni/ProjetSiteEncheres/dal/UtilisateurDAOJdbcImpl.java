package fr.eni.ProjetSiteEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bo.Utilisateur;

/**
 * 
 * @author zince
 * classe red�finissant les m�thodes UtilisateurDAO
 */
public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

//private static final String SELECT_ALL = "SELECT no_utilisateur, pseudo FROM LISTE";
	private static final String SELECT_BY_NO_UTILISATEUR =	"SELECT * from UTILISATEURS where noUtilisateur = ?";
	private static final String INSERT_UTILISATEUR = "insert into UTILISATEURS(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) values(?,?,?,?,?,?,?,?,?,?,?);";
	private static final String DELETE_UTILISATEUR = "delete from utilisateurs where no_utilisateur = ?" ;
	private static final String SELECT_BY_PSEUDO =	"SELECT * from UTILISATEURS where pseudo = ?";
	private static final String SELECT_BY_EMAIL =	"SELECT * from UTILISATEURS where email = ?";
	private static final String SELECT_ALL_BY_PSEUDO_AND_MDP =	"SELECT * from UTILISATEURS where pseudo = ? AND mot_de_passe = ?";
	private static final String MODIFY_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ? WHERE pseudo = ?";
	
//m�thode insert pour ins�rer un utilisateur en base de donn�e
	@Override
	public void insert(Utilisateur utilisateur) throws BusinessException {
		
		try(Connection cnx = ConnectionProvider.getConnection()) 
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;

					pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
					
//r�cup�ration des donn�es du formulaire
										
					pstmt.setString(1, utilisateur.getPseudo());
					pstmt.setString(2, utilisateur.getNom());
					pstmt.setString(3, utilisateur.getPrenom());
					pstmt.setString(4, utilisateur.getEmail());
					pstmt.setString(5, utilisateur.getTelephone());
					pstmt.setString(6, utilisateur.getRue());
					pstmt.setString(7, utilisateur.getCodePostal());
					pstmt.setString(8, utilisateur.getVille());
					pstmt.setString(9, utilisateur.getMotDePasse());
					pstmt.setInt(10, utilisateur.getCredit());
					pstmt.setInt(11, utilisateur.getAdministrateur());
					
					
					pstmt.executeUpdate();

					rs = pstmt.getGeneratedKeys();
					
//g�n�ration du num�ro utilisateur
			if(rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
				rs.close();
				pstmt.close();
				cnx.commit();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Il y a une erreur.");
		}
	}
	
//M�thode permmettant de supprimer un utilisateur par son no Utilisateur
	@Override
	public void delete(int noUtilisateur) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection()){
			
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;

					pstmt = cnx.prepareStatement(DELETE_UTILISATEUR);
					pstmt.setInt(1, noUtilisateur);
					pstmt.executeQuery();
			} catch (Exception e) {
				System.out.println("impossible de supprimer cet utilisateur");
			}
			
		} catch (Exception  e) {
			System.out.println("connexion impossible");
			e.printStackTrace();
		}	
	}

//sélection d'un utilisateur par son pseudo
	@Override
	public Utilisateur selectByPseudo(String pseudo) throws BusinessException {
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			Utilisateur utilisateur = new Utilisateur();
			PreparedStatement pstmt;
			ResultSet rs;
			
				
			
				pstmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
				pstmt.setString(1, pseudo);
				rs = pstmt.executeQuery();
				
			if (rs.next()) {
				return utilisateur;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//Vérification de la corespondance pseudo-mot de passe. Renvoi toutes les données d'un utilisateur si ok
	@Override
	public Utilisateur verificationCouplePseudoMdp(String pseudo, String motDePasse) throws BusinessException {
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt;
			ResultSet rs;
		
				pstmt = cnx.prepareStatement(SELECT_ALL_BY_PSEUDO_AND_MDP);
				pstmt.setString(1, pseudo);
				pstmt.setString(2, motDePasse);
				rs = pstmt.executeQuery();
				
				int noUtilisateur = 0;
				String nom = null;
				String prenom = null;
				String email = null;
				String telephone = null;
				String rue = null;
				String codePostal = null;
				String ville = null;
				int credit = 0;
				int administrateur = 0;
				
				while (rs.next()) {
					noUtilisateur = rs.getInt("no_utilisateur");
					pseudo = rs.getString("pseudo");
					nom = rs.getString("nom");
					prenom = rs.getString("prenom");
					email = rs.getString("email");
					telephone = rs.getString("telephone");
					rue = rs.getString("rue");
					codePostal = rs.getString("code_postal");
					ville = rs.getString("ville");
					motDePasse = rs.getString("mot_de_passe");
					credit = rs.getInt("credit");
					administrateur = rs.getInt("administrateur");
				}
				
				Utilisateur utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);

				
				System.out.println("ok utilisateur");
				return utilisateur;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("echec select pseudo");
		}
		System.out.println("retourne null");
		return null;
	}

	@Override
	public boolean selectByEmail(String email) throws BusinessException {
		
		boolean exist = false;
		try(Connection cnx = ConnectionProvider.getConnection()){
			Utilisateur utilisateur = new Utilisateur();
			PreparedStatement pstmt;
			ResultSet rs;
			
				pstmt = cnx.prepareStatement(SELECT_BY_EMAIL);
				pstmt.setString(1, email);
				rs = pstmt.executeQuery();
				
			if (rs.next()) {
				exist = true;
			}
			else {
				exist = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exist;
	}

	@Override
	public boolean modifyUtilisateur(Utilisateur utilisateurModifie) throws BusinessException {
		
		boolean modifOk = false;
		try(Connection cnx = ConnectionProvider.getConnection()) 
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;

					pstmt = cnx.prepareStatement(MODIFY_UTILISATEUR);
	
					pstmt.setString(1, utilisateurModifie.getPseudo());
					pstmt.setString(2, utilisateurModifie.getNom());
					pstmt.setString(3, utilisateurModifie.getPrenom());
					pstmt.setString(4, utilisateurModifie.getEmail());
					pstmt.setString(5, utilisateurModifie.getTelephone());
					pstmt.setString(6, utilisateurModifie.getRue());
					pstmt.setString(7, utilisateurModifie.getCodePostal());
					pstmt.setString(8, utilisateurModifie.getVille());
					pstmt.setString(9, utilisateurModifie.getNvxMotDePasse());
					pstmt.setString(10, utilisateurModifie.getPremierPseudo());
					
					pstmt.executeUpdate();
					
					System.out.println("modification réussie");
					modifOk = true;
					
					
		}catch(SQLException e) {
			System.out.println("elements non modifiés");
			e.printStackTrace();
			modifOk = false;
		}
			
	}catch(SQLException e){
		System.out.println("connexion echouée");
	}
		return modifOk;
}
}
	
	
