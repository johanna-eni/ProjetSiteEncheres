package fr.eni.ProjetSiteEncheres.servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String categorie = request.getParameter("categorie");
		String mise_a_prix = request.getParameter("mise_a_prix");
		
		//récupération des dates
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		LocalDate date_debut_enchere = LocalDate.parse(request.getParameter("date_debut_enchere"), dtf);
		LocalDate date_fin_enchere = LocalDate.parse(request.getParameter("date_fin_enchere"), dtf);
		
		//récupération des infos du retrait
		String retrait_rue = request.getParameter("retrait_rue");
		String retrait_c_p = request.getParameter("retrait_c_p");
		String retrait_ville = request.getParameter("retrait_ville");
	}

}
