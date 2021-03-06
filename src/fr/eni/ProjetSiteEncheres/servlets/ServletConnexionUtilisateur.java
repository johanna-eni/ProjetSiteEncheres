package fr.eni.ProjetSiteEncheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.apache.catalina.connector.Request;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bll.UtilisateurManager;
import fr.eni.ProjetSiteEncheres.bo.Utilisateur;
import fr.eni.ProjetSiteEncheres.dal.UtilisateurDAOJdbcImpl;

/**
 * Servlet implementation class ServletMonProfil
 */
@WebServlet("/ServletConnexionUtilisateur")
public class ServletConnexionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
/**
* @see HttpServlet#HttpServlet()
*/
    public ServletConnexionUtilisateur() {
        super();
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/connexionUtilisateur.jsp");
		rd.forward(request, response);
//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtilisateurDAOJdbcImpl utilisateurDAO = new UtilisateurDAOJdbcImpl();
		String pseudo = null;
		String mot_de_passe = null;

		pseudo = request.getParameter("pseudo");
		mot_de_passe = request.getParameter("mot_de_passe");

//utilisation du constructeur Utilisateur pour chercher un utilisateur dans la base de donnée
//Utilisateur utilisateur = new Utilisateur(pseudo,mot_de_passe); 

//vérification du mot de passe dans la base de donnée par rapport au pseudo 
		try {
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			Utilisateur utilisateurInfo = utilisateurManager.verifPseudoMotDePasse(pseudo, mot_de_passe);
			
			if (utilisateurInfo != null) {
				HttpSession session = request.getSession();
				
				session.setAttribute("pseudo", pseudo);
				session.setAttribute("utilisateurInfo", utilisateurInfo);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueilConnexionMonProfil.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/connexionUtilisateur.jsp");
				rd.forward(request, response);
			}
			
		}
		catch (ServletException e) {
			System.out.println("erreur de la servlet");
			e.printStackTrace();
		}
	}
}
