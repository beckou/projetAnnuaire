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

import beans.Addresse;
import beans.Annonce;
import beans.Categorie;
import service.AnnuaireProxy;

/**
 * Servlet implementation class modifAnnonce
 */
@WebServlet("/modifAnnonce")
public class modifAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String VUE              = "/WEB-INF/modifAnnonce.jsp";
    public static final String VUE2              = "/WEB-INF/gestionAnnonce.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifAnnonce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AnnuaireProxy myProxy = new AnnuaireProxy();
		int intIdAnn = Integer.parseInt(request.getParameter("questID"));

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

			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// A MODIFIER QUAND ON A LA FONCTION
				 String monAnnonce = myProxy.getAnnonce(intIdAnn);

				// Traitement XML de la chaine reçu (une categorie)
				 dbf = DocumentBuilderFactory.newInstance();
				 db = null;
				 Annonce Ann = null;
				try {
					db = dbf.newDocumentBuilder();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 is = new InputSource();
				
				// A MODIFIER QUAND ON A LA FONCTION !! 
				  is.setCharacterStream(new StringReader(monAnnonce));

				try {
					doc = db.parse(is);
					System.out.println("teeest " + doc);
					NodeList nList = doc.getElementsByTagName("annonce");
					System.out.println(nList.getLength());

					for (int temp = 0; temp < nList.getLength(); temp++) {

						Node nNode = nList.item(temp);

						System.out.println("\nCurrent Element :" + nNode.getNodeName());

						if (nNode.getNodeType() == Node.ELEMENT_NODE) {

							Element eElement = (Element) nNode;

							Ann = new Annonce(Integer.parseInt(eElement.getAttribute("id")), eElement.getAttribute("name"),Integer.parseInt(eElement.getAttribute("category")),Integer.parseInt(eElement.getAttribute("idAdresse")),eElement.getAttribute("tel"), eElement.getAttribute("nameCategorie"));

						}
						request.setAttribute("monAnnonce", Ann);

					}
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				 String monAdresse = myProxy.getAdresseByID(Ann.getIdAdresse());

					// Traitement XML de la chaine reçu (une categorie)
					 dbf = DocumentBuilderFactory.newInstance();
					 db = null;
					 Addresse Adr = null;
					try {
						db = dbf.newDocumentBuilder();
					} catch (ParserConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 is = new InputSource();
					
					// A MODIFIER QUAND ON A LA FONCTION !! 
					  is.setCharacterStream(new StringReader(monAdresse));

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

								Adr = new Addresse(Integer.parseInt(eElement.getAttribute("idAdresse")), eElement.getAttribute("rue"),eElement.getAttribute("ville"), eElement.getAttribute("cp"));

							}
							request.setAttribute("monAdresse", Adr);

						}
					} catch (SAXException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnuaireProxy myProxy = new AnnuaireProxy();
		int intIdAnn = Integer.parseInt(request.getParameter("idAnn"));
		String nomAnnonce = (String) request.getParameter("nomAnnonce");
		String telephone = (String) request.getParameter("telephone");
		int idCat = Integer.parseInt(request.getParameter("Categorie"));
		myProxy.modifyAnnonce(intIdAnn, nomAnnonce, telephone,idCat);
		
		int intIdAdr = Integer.parseInt(request.getParameter("idAdr"));
		String rue = (String) request.getParameter("rue");
		String ville = (String) request.getParameter("ville");
		String cp = (String) request.getParameter("cp");

		myProxy.modifyAdresse(intIdAdr, rue, ville, cp);
		
		  String destinationBlockAccount  ="./gestionAnnonce";
	       response.sendRedirect(response.encodeRedirectURL(destinationBlockAccount));

	}

}
