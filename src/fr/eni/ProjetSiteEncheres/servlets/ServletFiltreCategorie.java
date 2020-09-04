package fr.eni.ProjetSiteEncheres.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ProjetSiteEncheres.bll.ArticleManager;
import fr.eni.ProjetSiteEncheres.bll.CategorieManager;
import fr.eni.ProjetSiteEncheres.bo.ArticleVendu;
import fr.eni.ProjetSiteEncheres.dal.ArticleDAOJdbcImpl;

/**
 * Servlet implementation class ServletFiltreCategorie
 */
@WebServlet("/ServletFiltreCategorie")
public class ServletFiltreCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFiltreCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategorieManager categorieManager = new CategorieManager();
		
		String categorie = request.getParameter("categorie");
		int no_categorie = categorieManager.recupNoCategorie(categorie);
		
		ArticleManager articleManager = new ArticleManager();
		
		try {
			Collection<ArticleVendu> listeArticlesChoisis = articleManager.selectArticles(no_categorie);
			 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
