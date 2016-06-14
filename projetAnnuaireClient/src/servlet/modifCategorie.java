package serv;

import java.io.IOException;
import java.io.StringReader;

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

import service.AnnuaireProxy;

/**
 * Servlet implementation class createCategorie
 */
@WebServlet("/modifCategorie")
public class modifCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String VUE              = "/WEB-INF/modifCategorie.jsp";
    public static final String VUE2              = "/WEB-INF/gestionCategorie.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AnnuaireProxy myProxy = new AnnuaireProxy();

		int intIdCat = Integer.parseInt(request.getParameter("questID"));

		// A MODIFIER QUAND ON A LA FONCTION
		 String categorie_XML = myProxy.getCategorie(intIdCat);

		String category_name = null;
		int category_id = 0;
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
		  is.setCharacterStream(new StringReader(categorie_XML));

		Document doc;
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

		// Envoie le nom et l'id à la JSP à la JSP
		request.setAttribute("IdCat", category_id);
		request.setAttribute("NomCat", category_name);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer idCat =  Integer.parseInt(request.getParameter("idCat"));
		String nomCat = request.getParameter("nomCat");
		
		AnnuaireProxy myProxy = new AnnuaireProxy();
		
		myProxy.modifyCategorie(idCat, nomCat);
		
		
		this.getServletContext().getRequestDispatcher(VUE2).forward(request, response);
	}

}
