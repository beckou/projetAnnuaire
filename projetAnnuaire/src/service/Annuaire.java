package service;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import beans.Categorie;
import beans.Categories;
import dao.CategorieDao;
import dao.DAOFactory;

public class Annuaire {


	DAOFactory dao =DAOFactory.getInstance();
    //AnnonceDao annonceDAO = (AnnonceDao) dao.getAnnonceDao();
    CategorieDao categorieDAO = (CategorieDao) dao.getCategorieDao();

	
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
	
	
	
	
}
