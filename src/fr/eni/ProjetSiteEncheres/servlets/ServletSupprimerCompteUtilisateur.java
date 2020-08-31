package fr.eni.ProjetSiteEncheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.ProjetSiteEncheres.bll.UtilisateurManager;
import fr.eni.ProjetSiteEncheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletSupprimerCompteUtilisateur
 */
@WebServlet("/ServletSupprimerCompteUtilisateur")
public class ServletSupprimerCompteUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSupprimerCompteUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Appel à la bll pour suppression utilisateur
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Utilisateur utilisateurSession = (Utilisateur) session.getAttribute("utilisateurInfo");
		int no_utilisateur = utilisateurSession.getNoUtilisateur();
		System.out.println("Vincent" + no_utilisateur);
		
		try {
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			
			if(utilisateurManager.supprimerUtilisateur(no_utilisateur)) {
				System.out.println("compte supprimé");
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");
				rd.forward(request, response);
			}
			else {
				System.out.println("echec suppression !");
			}
			
		}
		catch(ServletException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
