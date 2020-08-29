package fr.eni.ProjetSiteEncheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bll.UtilisateurManager;
import fr.eni.ProjetSiteEncheres.bo.Utilisateur;
import fr.eni.ProjetSiteEncheres.dal.UtilisateurDAOJdbcImpl;

/**
 * Servlet implementation class ServletModifierMonProfil
 */
@WebServlet("/ServletModifierMonProfil")
public class ServletModifierMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
/**
* @see HttpServlet#HttpServlet()
*/
    public ServletModifierMonProfil() {
        super();
    }

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/monProfil.jsp");
		rd.forward(request, response);
	}

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
		String nvxMotDePasse = null;
		Utilisateur utilisateurSession; 
		String premierPseudo = null;
		
		//Récupération des données du formulaire
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
		nvxMotDePasse = request.getParameter("nvx_mot_de_passe");
		
		//Récupération des données de la session
		HttpSession session = request.getSession();
		utilisateurSession = (Utilisateur) session.getAttribute("utilisateurInfo");
		//Récupération du noUtilisateur stocké dans la session
		premierPseudo = utilisateurSession.getPseudo();
		
		Utilisateur modifUtilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, confirmation, nvxMotDePasse, premierPseudo);

		System.out.println(utilisateurSession.getPseudo());
		
	
		
		try {
			boolean ok = false;
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			if(utilisateurManager.modifierUtilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, confirmation, nvxMotDePasse, premierPseudo)) {
				System.out.println("information modifiées avec succès");
				
				
				
				
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/monProfil.jsp");
				rd.forward(request, response);
			}
			else {
				System.out.println("info non modifiées");
			}
			
		}
		catch(BusinessException e){
			
		e.printStackTrace();
	
	}
}
}
