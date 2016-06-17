package service;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import beans.Addresse;
import beans.Adresses;
import beans.Annonce;
import beans.Annonces;
import beans.Categorie;
import beans.Categories;
import dao.CategorieDao;
import dao.DAOFactory;
import dao.AdresseDao;
import dao.AnnonceDao;
public class Annuaire {


	DAOFactory dao =DAOFactory.getInstance();
    //AnnonceDao annonceDAO = (AnnonceDao) dao.getAnnonceDao();
    CategorieDao categorieDAO = (CategorieDao) dao.getCategorieDao();
    AdresseDao adresseDAO = (AdresseDao) dao.getAdresseDao();
    AnnonceDao	annonceDAO = (AnnonceDao) dao.getAnnonceDao();
	
	public int add(int val1, int val2){
		// addition
		return (val1+ val2);
		
		
	}
	
	public String getCategorie(int categorie_id) throws JAXBException {

		Categorie categorie = categorieDAO.trouver(categorie_id);

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Categorie.class);
			java.io.StringWriter sw = new StringWriter();

			javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(categorie, sw);

			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";

	}

	public String getCategorieByString(String categorie_id) throws JAXBException {

		Categorie categorie = categorieDAO.trouverByNom(categorie_id);

		if(categorie != null){
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Categorie.class);
			java.io.StringWriter sw = new StringWriter();

			javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(categorie, sw);

			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";
		}else {
			return "false";
		}

	}
	
	public void createAdresse(String rue,String ville,String cp){
		Addresse adresse = new Addresse();
		adresse.setCp(cp);
		adresse.setRue(rue);
		adresse.setVille(ville);
		adresseDAO.creer(adresse);
	}
	
	public String getAdresseByString(String rue,String ville,String cp) throws JAXBException {

		Addresse adresse = adresseDAO.trouverByNom(rue,ville,cp);

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Addresse.class);
			java.io.StringWriter sw = new StringWriter();

			javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(adresse, sw);

			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";

	}
	
	public String getAdresseByID(Integer ID) throws JAXBException {

		Addresse adresse = adresseDAO.trouverById(ID);

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Addresse.class);
			java.io.StringWriter sw = new StringWriter();

			javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(adresse, sw);

			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";

	}

	
	public void createCategory(String newCategory){
		// create new categorie
		Categorie categorie = new Categorie(0,newCategory);
		categorie.setName(newCategory);
		categorieDAO.creer(categorie);
	}


	public void delCategorie(int categorie_id) {
	 categorieDAO.supprimer(categorie_id);
	}

	public void modifyCategorie(int categorie_id,String nouveau_nom) {
		 categorieDAO.modifier(categorie_id, nouveau_nom);
		}
	
	public void modifyAnnonce(int annonce_id,String nouveau_nom,String nouveau_tel, int idCat) {
		 annonceDAO.modifier(annonce_id, nouveau_nom, nouveau_tel, idCat);
		}
	public void modifyAdresse(int adresse_id,String nouveau_rue,String nouveau_ville,String nouveau_cp) {
		 adresseDAO.modifier(adresse_id, nouveau_rue, nouveau_ville,nouveau_cp);
		}
	
	
	public String viewAllCategories() {
		 List<Categorie> l_categories = categorieDAO.viewAllCategorie();

		  Categories Listecategories = new Categories();
		  Listecategories.setCategories(l_categories);
		  System.out.println("ma liste :" + l_categories);
		  
		  for (int i = 0 ; i < l_categories.size(); i++){
			  
			  System.out.println(l_categories.get(i).getId() + l_categories.get(i).getName());
			  
		  }
		  
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Categories.class);
			java.io.StringWriter sw2 = new StringWriter();

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(Listecategories, sw2);
			System.out.println("string XML " + sw2.toString());
			return sw2.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";
}
	
	public String viewAllAnnonce() {
		 List<Annonce> l_Annonce = annonceDAO.viewAllAnnonce();

		  Annonces Listeannonces = new Annonces();
		  Listeannonces.setAnnonces(l_Annonce);
		  System.out.println("ma liste :" + l_Annonce);
		  
		  
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Annonces.class);
			java.io.StringWriter sw2 = new StringWriter();

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(Listeannonces, sw2);
			System.out.println("string XML " + sw2.toString());
			return sw2.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";
}
	public String viewAllAnnonceByCat(long idCat) {
		 List<Annonce> l_Annonce = annonceDAO.viewAllAnnonceByCat(idCat);

		  Annonces Listeannonces = new Annonces();
		  Listeannonces.setAnnonces(l_Annonce);
		  System.out.println("ma liste :" + l_Annonce);
		  
		  
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Annonces.class);
			java.io.StringWriter sw2 = new StringWriter();

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(Listeannonces, sw2);
			System.out.println("string XML " + sw2.toString());
			return sw2.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";
}
	
	public String viewAllAnnonceByAdr(long idAdr) {
		 List<Annonce> l_Annonce = annonceDAO.viewAllAnnonceByAdr(idAdr);

		  Annonces Listeannonces = new Annonces();
		  Listeannonces.setAnnonces(l_Annonce);
		  System.out.println("ma liste :" + l_Annonce);
		  
		  
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Annonces.class);
			java.io.StringWriter sw2 = new StringWriter();

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(Listeannonces, sw2);
			System.out.println("string XML " + sw2.toString());
			return sw2.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";
}
	
	public String viewAllAnnonceByNom(String Nom) {
		 List<Annonce> l_Annonce = annonceDAO.viewAllAnnonceByNom(Nom);

		  Annonces Listeannonces = new Annonces();
		  Listeannonces.setAnnonces(l_Annonce);
		  System.out.println("ma liste :" + l_Annonce);
		  
		  
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Annonces.class);
			java.io.StringWriter sw2 = new StringWriter();

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(Listeannonces, sw2);
			System.out.println("string XML " + sw2.toString());
			return sw2.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";
}
	
	
	
	public void createAnnonce(String nom,Integer idCat,String telephone,Long idAdresse){
		Annonce ann = new Annonce(0,0,"",0,"");
		ann.setCategory(idCat);
		ann.setIdAdresse(idAdresse);
		ann.setName(nom);
		ann.setTel(telephone);
		annonceDAO.creer(ann);
	}
	
	public void delAnnonce(int annonce_id) {
		 annonceDAO.supprimer(annonce_id);
		}
	
	
	public String viewAllAdresse() {
		 List<Addresse> l_Adresse = adresseDAO.viewAllAdresse();

		  Adresses Listeadresses = new Adresses();
		  Listeadresses.setAdresses(l_Adresse);
		  System.out.println("ma liste :" + l_Adresse);
		  
		  
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Adresses.class);
			java.io.StringWriter sw2 = new StringWriter();

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(Listeadresses, sw2);
			System.out.println("string XML " + sw2.toString());
			return sw2.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";
}
	
	public String getAnnonce(int categorie_id) throws JAXBException {

		Annonce annonce =annonceDAO.trouver(categorie_id);

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Annonce.class);
			java.io.StringWriter sw = new StringWriter();

			javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(annonce, sw);

			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";

	}

	
	
}
