package serv;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import beans.Categorie;
import service.AnnuaireProxy;

/**
 * Servlet implementation class createCategorie
 */
@WebServlet("/firstPageClient2")
public class firstPageClient2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String VUE              = "/WEB-INF/firstPageClient2.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public firstPageClient2() {
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
		
		String TypeRecherche = (String) request.getParameter("rechercheType");
		String ValeurDonnee = (String) request.getParameter("recherche");
		Categorie catt = new Categorie(0,"new");
		AnnuaireProxy myProxy = new AnnuaireProxy();

		// Requete le webservice pour ajouter une catégorie

		if(TypeRecherche == "adresse")
		
			
		if(TypeRecherche == "categorie"){
			String cat = myProxy.getCategorieByString(ValeurDonnee);

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = null;

			try {
				db = dbf.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			InputSource is = new InputSource();
			
			
			// A DECOMENTER DES QUE LA FONCTION EST RAJOUTEE
			
		 	is.setCharacterStream(new StringReader(cat));

			org.w3c.dom.Document doc;
			try {
				doc = db.parse(is);

				
				NodeList nList = doc.getElementsByTagName("categorie");
				System.out.println(nList.getLength());

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);
					
					System.out.println("\nCurrent Element :" + nNode.getNodeName());

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
						System.out.println("Categorie id : " + eElement.getAttribute("id"));
						System.out.println("Categorie id : " + eElement.getAttribute("name"));
					    catt.setId(Integer.parseInt(eElement.getAttribute("id")));
					    catt.setName( eElement.getAttribute("name"));
					}

				}

				// String ListeAnnonce = myProxy.viewAllAnnonceByCategorie(catt.getName());

				
				
				
				
				
				
				this.getServletContext().getRequestDispatcher(VUE).forward(request, response);	

				
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		
		
	
	
	}
		
			
		if(TypeRecherche == "nom")
	
			
			
			
		doGet(request, response);
	}

}

