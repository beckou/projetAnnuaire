package serv;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.xml.internal.txw2.Document;

import beans.Categorie;
import service.AnnuaireProxy;

/**
 * Servlet implementation class createCategorie
 */
@WebServlet("/gestionCategorie")
public class gestionCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String VUE              = "/WEB-INF/gestionCategorie.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public gestionCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupère les champs pouvant avoir été modifiés
		Integer idCat =  Integer.parseInt(request.getParameter("questID"));
		AnnuaireProxy myProxy = new AnnuaireProxy();

		// Requete le webservice pour ajouter une catégorie
		myProxy.delCategorie(idCat);

		// Récupère toutes les catégories pour les afficher
		doGet(request, response);
}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		
		AnnuaireProxy myProxy = new AnnuaireProxy();

	 // ICI A CHANGER, LA FONCTION POUR LISTER TOUTES LES CATEGORIES
	 	String ListeCategories = myProxy.viewAllCategories();
		
		
	
		List<Categorie> tabCat = new ArrayList<Categorie>();

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
		
	 	is.setCharacterStream(new StringReader(ListeCategories));

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
					tabCat.add(new Categorie(Integer.parseInt(eElement.getAttribute("id")), eElement.getAttribute("name")));

				}

			}

			for (int i =0 ; i < tabCat.size(); i++){
				
				System.out.println("tabcat:"+ tabCat.get(i).getName() +  tabCat.get(i).getId() );

			}
			
			request.setAttribute("listeCat", tabCat);
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);	

			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}