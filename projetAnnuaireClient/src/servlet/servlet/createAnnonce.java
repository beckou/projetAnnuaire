package servlet;

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

import org.w3c.dom.Document;
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
@WebServlet("/createAnnonce")
public class createAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String VUE              = "/WEB-INF/createAnnonce.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public createAnnonce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nouvelleAnn = (String) request.getParameter("nomAnnonce");
		String cat = (String) request.getParameter("Categorie");

		String rue = (String) request.getParameter("rue");
		String ville = (String) request.getParameter("ville");
		String cp = (String) request.getParameter("cp");
		String telephone = (String) request.getParameter("telephone");

		AnnuaireProxy myProxy = new AnnuaireProxy();

		// Requete le webservice pour ajouter une catégorie
		myProxy.createAdresse(rue,ville,cp);
		String adresse = myProxy.getAdresseByString(rue, ville, cp);

		String adresse_rue = null;
		String adresse_ville = null;
		String adresse_cp = null;

		int adresse_id = 0;
		// Traitement XML de la chaine reçu (une categorie)
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;

		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputSource is = new InputSource();
		
		// A MODIFIER QUAND ON A LA FONCTION !! 
		  is.setCharacterStream(new StringReader(adresse));

		Document doc;
		try {
			doc = db.parse(is);
			System.out.println("teeest " + doc);
			NodeList nList = doc.getElementsByTagName("addresse");
			System.out.println(nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					adresse_id = Integer.parseInt(eElement.getAttribute("idAdresse"));
					adresse_rue = eElement.getAttribute("rue");
					adresse_ville = eElement.getAttribute("ville");
					adresse_cp = eElement.getAttribute("cp");

				}
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String categorie = myProxy.getCategorieByString(cat);


		String category_name = null;
		int category_id = 0;
		// Traitement XML de la chaine reçu (une categorie)
		 dbf = DocumentBuilderFactory.newInstance();
		 db = null;

		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 is = new InputSource();
		
		// A MODIFIER QUAND ON A LA FONCTION !! 
		  is.setCharacterStream(new StringReader(categorie));

		try {
			doc = db.parse(is);
			System.out.println("teeest " + doc);
			NodeList nList = doc.getElementsByTagName("categorie");
			System.out.println(nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					category_id = Integer.parseInt(eElement.getAttribute("id"));
					category_name = eElement.getAttribute("name");

				}
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		myProxy.createAnnonce(nouvelleAnn, category_id, telephone, adresse_id);
		
	//	doGet(request, response);
		
		
	     
  String destinationBlockAccount  ="./gestionAnnonce";
  response.sendRedirect(response.encodeRedirectURL(destinationBlockAccount));
  

	}

}
