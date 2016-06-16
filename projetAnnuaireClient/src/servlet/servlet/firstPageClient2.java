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

			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	 	String ListeAnnonces = myProxy.viewAllAnnonce();


		List<Annonce> tabAnn = new ArrayList<Annonce>();

		 dbf = DocumentBuilderFactory.newInstance();
		 db = null;

		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 is = new InputSource();
		
		
		// A DECOMENTER DES QUE LA FONCTION EST RAJOUTEE
		
	 	is.setCharacterStream(new StringReader(ListeAnnonces));

		try {
			doc = db.parse(is);

			
			NodeList nList = doc.getElementsByTagName("annonce");
			System.out.println(nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				
				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					tabAnn.add(new Annonce(Integer.parseInt(eElement.getAttribute("id")), eElement.getAttribute("name"),Integer.parseInt(eElement.getAttribute("category")),Integer.parseInt(eElement.getAttribute("idAdresse")),eElement.getAttribute("tel"), eElement.getAttribute("nameCategorie")));

				}

			}

			for (int i =0 ; i < tabAnn.size(); i++){
				
				System.out.println("tabcat:"+ tabAnn.get(i).getName() +  tabAnn.get(i).getId() );

			}
			
			request.setAttribute("listeAnn", tabAnn);

			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	 	String ListeAdresses = myProxy.viewAllAdresse();


		List<Addresse> tabAdr = new ArrayList<Addresse>();

		 dbf = DocumentBuilderFactory.newInstance();
		 db = null;

		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 is = new InputSource();
		
		
		// A DECOMENTER DES QUE LA FONCTION EST RAJOUTEE
		
	 	is.setCharacterStream(new StringReader(ListeAdresses));

		try {
			doc = db.parse(is);

			
			NodeList nList = doc.getElementsByTagName("adresse");
			System.out.println(nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				
				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					tabAdr.add(new Addresse(Integer.parseInt(eElement.getAttribute("idAdresse")), eElement.getAttribute("rue"),eElement.getAttribute("ville"),eElement.getAttribute("cp")));

				}

			}

			
			request.setAttribute("listeAdr", tabAdr);

			
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
		// TODO Auto-generated method stub
		
		String TypeRecherche = (String) request.getParameter("rechercheType");
		AnnuaireProxy myProxy = new AnnuaireProxy();
		
		String button = (String) request.getParameter("b1");
		System.out.println("TROUVE button : "+ button);

		if(button.equals("chercher2")){
			
		
			if(TypeRecherche.equals("nom")){
				String nom = (String) request.getParameter("annonce");
				System.out.println("nom : " +nom );
			 	String ListeAnnoncesNom = myProxy.viewAllAnnonceByNom(nom);
			 	
				List<Annonce> tabCat = new ArrayList<Annonce>();

			
				
				if (!ListeAnnoncesNom.isEmpty()){
					
					
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
					
				 	is.setCharacterStream(new StringReader(ListeAnnoncesNom));

					org.w3c.dom.Document doc;
					try {
						doc = db.parse(is);

						
						NodeList nList = doc.getElementsByTagName("annonce");

						for (int temp = 0; temp < nList.getLength(); temp++) {

							Node nNode = nList.item(temp);
							
							System.out.println("\nCurrent Element :" + nNode.getNodeName());

							if (nNode.getNodeType() == Node.ELEMENT_NODE) {

								Element eElement = (Element) nNode;
								tabCat.add(new Annonce(Integer.parseInt(eElement.getAttribute("id")), eElement.getAttribute("name"),Integer.parseInt(eElement.getAttribute("category")),Integer.parseInt(eElement.getAttribute("idAdresse")),eElement.getAttribute("tel"), eElement.getAttribute("nameCategorie")));


							}

						}
						System.out.println("TROUVE TAB : "+ tabCat);

						request.setAttribute("listeAnn", tabCat);
						this.getServletContext().getRequestDispatcher(VUE).forward(request, response);	

						
					} catch (SAXException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					
					
				}
					
					
					
					
				}
				
				
				
			 	
			}
			
			
		}else{

		// Requete le webservice pour ajouter une catégorie
		System.out.println("TROUVE TAB : "+ TypeRecherche);

		if(TypeRecherche.equals("nom")){
			String nom = (String) request.getParameter("Nom");
			System.out.println("nom : " +nom );
		 	String ListeAnnoncesNom = myProxy.viewAllAnnonceByNom(nom);


			
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
			
		 	is.setCharacterStream(new StringReader(ListeAnnoncesNom));

			org.w3c.dom.Document doc;
			try {
				doc = db.parse(is);

				
				NodeList nList = doc.getElementsByTagName("annonce");

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);
					
					System.out.println("\nCurrent Element :" + nNode.getNodeName());

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
						tabCat.add(new Annonce(Integer.parseInt(eElement.getAttribute("id")), eElement.getAttribute("name"),Integer.parseInt(eElement.getAttribute("category")),Integer.parseInt(eElement.getAttribute("idAdresse")),eElement.getAttribute("tel"), eElement.getAttribute("nameCategorie")));


					}

				}
				System.out.println("TROUVE TAB : "+ tabCat);

				request.setAttribute("listeAnn", tabCat);
				this.getServletContext().getRequestDispatcher(VUE).forward(request, response);	

				
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			
			
		}
		}
			
		if(TypeRecherche.equals("categorie")){

			Categorie catt = new Categorie(0,"new");
			String ValeurDonnee = (String) request.getParameter("Categorie");
			

			String cat = myProxy.getCategorieByString(ValeurDonnee);
			System.out.println("TROUVE TAB : "+ ValeurDonnee);


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

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);
					
					System.out.println("\nCurrent Element :" + nNode.getNodeName());

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
					    catt.setId(Integer.parseInt(eElement.getAttribute("id")));
					    catt.setName( eElement.getAttribute("name"));
					}

				}

				// String ListeAnnonce = myProxy.viewAllAnnonceByCategorie(catt.getName());

				
				
				
				
				
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		 	String ListeAnnonces = myProxy.viewAllAnnonceByCat(catt.getId());


			
			List<Annonce> tabCat = new ArrayList<Annonce>();

			 dbf = DocumentBuilderFactory.newInstance();
			 db = null;

			try {
				db = dbf.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 is = new InputSource();
			
			
			// A DECOMENTER DES QUE LA FONCTION EST RAJOUTEE
			
		 	is.setCharacterStream(new StringReader(ListeAnnonces));

			try {
				doc = db.parse(is);

				
				NodeList nList = doc.getElementsByTagName("annonce");
				System.out.println(nList.getLength());

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);
					
					System.out.println("\nCurrent Element :" + nNode.getNodeName());

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
						tabCat.add(new Annonce(Integer.parseInt(eElement.getAttribute("id")), eElement.getAttribute("name"),Integer.parseInt(eElement.getAttribute("category")),Integer.parseInt(eElement.getAttribute("idAdresse")),eElement.getAttribute("tel"), eElement.getAttribute("nameCategorie")));

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
	
	
		
			
		if(TypeRecherche.equals("adresse")){
			Integer idAdr = Integer.parseInt(request.getParameter("Adresse"));
			System.out.println("nom : " +idAdr );
		 	String ListeAnnoncesNom = myProxy.viewAllAnnonceByAdr(idAdr);


			
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
			
		 	is.setCharacterStream(new StringReader(ListeAnnoncesNom));

			org.w3c.dom.Document doc;
			try {
				doc = db.parse(is);

				
				NodeList nList = doc.getElementsByTagName("annonce");

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);
					
					System.out.println("\nCurrent Element :" + nNode.getNodeName());

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
						tabCat.add(new Annonce(Integer.parseInt(eElement.getAttribute("id")), eElement.getAttribute("name"),Integer.parseInt(eElement.getAttribute("category")),Integer.parseInt(eElement.getAttribute("idAdresse")),eElement.getAttribute("tel"), eElement.getAttribute("nameCategorie")));


					}

				}
				System.out.println("TROUVE TAB : "+ tabCat);

				request.setAttribute("listeAnn", tabCat);
				this.getServletContext().getRequestDispatcher(VUE).forward(request, response);	

				
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			
			
		}
			
		}
			
		}	
			
	}

}

