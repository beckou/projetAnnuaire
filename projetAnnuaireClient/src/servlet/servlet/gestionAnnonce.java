package servlet;

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

import beans.Annonce;
import beans.Categorie;
import service.AnnuaireProxy;

/**
 * Servlet implementation class createCategorie
 */
@WebServlet("/gestionAnnonce")
public class gestionAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String VUE              = "/WEB-INF/gestionAnnonce.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public gestionAnnonce() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupère les champs pouvant avoir été modifiés
		Integer idCat =  Integer.parseInt(request.getParameter("questID"));
		AnnuaireProxy myProxy = new AnnuaireProxy();

		// Requete le webservice pour ajouter une catégorie
		myProxy.delAnnonce(idCat);

		// Récupère toutes les catégories pour les afficher
		doGet(request, response);
}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		
		AnnuaireProxy myProxy = new AnnuaireProxy();

	 // ICI A CHANGER, LA FONCTION POUR LISTER TOUTES LES CATEGORIES
	 	String ListeAnnonces = myProxy.viewAllAnnonce();
		
		
	
		List<Annonce> tabCat = new ArrayList<Annonce>();

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
		
	 	is.setCharacterStream(new StringReader(ListeAnnonces));

		org.w3c.dom.Document doc;
		try {
			doc = db.parse(is);

			
			NodeList nList = doc.getElementsByTagName("annonce");
			System.out.println(nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				
				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					tabCat.add(new Annonce(Integer.parseInt(eElement.getAttribute("id")), eElement.getAttribute("name"),Integer.parseInt(eElement.getAttribute("category")),Integer.parseInt(eElement.getAttribute("idAdresse")),eElement.getAttribute("tel")));

				}

			}

			for (int i =0 ; i < tabCat.size(); i++){
				
				System.out.println("tabcat:"+ tabCat.get(i).getName() +  tabCat.get(i).getId() );

			}
			
			request.setAttribute("listeAnn", tabCat);
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);	

			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}