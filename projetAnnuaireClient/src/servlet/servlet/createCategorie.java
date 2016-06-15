package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AnnuaireProxy;

/**
 * Servlet implementation class createCategorie
 */
@WebServlet("/createCategorie")
public class createCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String VUE              = "/WEB-INF/createCategorie.jsp";
    public static final String VUE2              = "/WEB-INF/gestionCategorie.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public createCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nouvelleCat = (String) request.getParameter("nomCat");
		AnnuaireProxy myProxy = new AnnuaireProxy();

		// Requete le webservice pour ajouter une catégorie
		myProxy.createCategory(nouvelleCat);
		
		     
       String destinationBlockAccount  ="./gestionCategorie";
       response.sendRedirect(response.encodeRedirectURL(destinationBlockAccount));
       


		
		//doGet(request, response);
	}

}
