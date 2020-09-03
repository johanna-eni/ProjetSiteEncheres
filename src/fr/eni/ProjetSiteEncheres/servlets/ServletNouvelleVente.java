package fr.eni.ProjetSiteEncheres.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.ProjetSiteEncheres.BusinessException;
import fr.eni.ProjetSiteEncheres.bll.ArticleManager;
import fr.eni.ProjetSiteEncheres.bll.CategorieManager;
import fr.eni.ProjetSiteEncheres.bo.ArticleVendu;
import fr.eni.ProjetSiteEncheres.bo.Categorie;
import fr.eni.ProjetSiteEncheres.bo.Retrait;
import fr.eni.ProjetSiteEncheres.bo.Utilisateur;
import fr.eni.ProjetSiteEncheres.dal.ArticleDAOJdbcImpl;

/**
 * Servlet implementation class ServletNouvelleVente
 */
@WebServlet("/ServletNouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletNouvelleVente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/nouvelleVente.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArticleDAOJdbcImpl articleDAO = new ArticleDAOJdbcImpl();
		//récupération infos formulaire
		String nom_article = request.getParameter("nom_article");
		String description = request.getParameter("description");
		String libelle = request.getParameter("nom_categorie");
		int mise_a_prix = Integer.parseInt(request.getParameter("mise_a_prix"));
		
		//récupération des dates
		LocalDate date_debut_enchere = null;
		LocalDate date_fin_enchere = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
		try {
			date_debut_enchere = LocalDate.parse(request.getParameter("date_debut_enchere"));
			date_fin_enchere = LocalDate.parse(request.getParameter("date_fin_enchere"));
		System.out.println(date_debut_enchere + "" + date_fin_enchere);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		//récupération des infos du retrait
		String retrait_rue = request.getParameter("retrait_rue");
		String retrait_c_p = request.getParameter("retrait_c_p");
		String retrait_ville = request.getParameter("retrait_ville");
		
		//récupérer la sesssion pour récupérer le numéro d'utilisateur en cours
		HttpSession session = request.getSession();
		Utilisateur utilisateurSession = (Utilisateur) session.getAttribute("utilisateurInfo");
		int no_utilisateur = utilisateurSession.getNoUtilisateur();
		
		Retrait infosRetrait = new Retrait(retrait_rue, retrait_c_p, retrait_ville);
		
		try {
			
			CategorieManager categorieManager = new CategorieManager();
			int no_categorie = categorieManager.recupNoCategorie(libelle);
			
			Categorie infosCategorie = new Categorie(no_categorie, libelle);
			ArticleVendu nouvelArticle = new ArticleVendu(nom_article, description, infosCategorie, mise_a_prix, date_debut_enchere, date_fin_enchere, infosRetrait,no_utilisateur  );
			
			ArticleManager articleManager = new ArticleManager();
			
			if (articleManager.insertArticle(nouvelArticle)) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueilConnexionMonProfil.jsp");
				rd.forward(request, response);
				
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/nouvelleVente.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
