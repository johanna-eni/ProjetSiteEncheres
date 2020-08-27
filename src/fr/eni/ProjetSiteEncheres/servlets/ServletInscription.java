package fr.eni.ProjetSiteEncheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bll.UtilisateurManager;
import fr.eni.ProjetSiteEncheres.bo.Utilisateur;
import fr.eni.ProjetSiteEncheres.dal.UtilisateurDAO;
import fr.eni.ProjetSiteEncheres.dal.UtilisateurDAOJdbcImpl;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInscription() {
        super();
    }

    //méthode doGet demandant la ressource à la jsp formulaireInscription
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/formulaireInscription.jsp");
		rd.forward(request, response);
	}	
	
	//méthode do post permetant d'envoyer les informations du formulaire à la classe UtilisateurDAOjdbcImpl
	//pour ensuite insérer les données dans la base de donnée.
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtilisateurDAOJdbcImpl utilisateurDAO = new UtilisateurDAOJdbcImpl();
		String pseudo = null;
		String nom = null;
		String prenom = null;
		String email = null;
		String telephone = null;
		String rue = null;
		String code_postal = null;
		String ville = null;
		String mot_de_passe = null;
		String confirmation = null;
		
		pseudo = request.getParameter("pseudo");
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		email = request.getParameter("email");
		telephone = request.getParameter("telephone");
		rue = request.getParameter("rue");
		code_postal = request.getParameter("code_postal");
		ville = request.getParameter("ville");
		mot_de_passe = request.getParameter("mot_de_passe");
		confirmation = request.getParameter("confirmation");
		
		//utilisation du constructeur Utilisateur pour créer un nouveau utilisateur
		Utilisateur utilisateur = new Utilisateur(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,0,0); 

		//vérification du mot de passe puis insertion de l'utilisateur dans utilisateurDAO
		
			try {
				UtilisateurManager utilisateurManager = new UtilisateurManager();
				utilisateurManager.ajouterUtilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, confirmation);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/formulaireInscription.jsp");
				rd.forward(request, response);
			} catch (BusinessException e) {
				System.out.println("erreur");
				e.printStackTrace();
			}
		}

	}


