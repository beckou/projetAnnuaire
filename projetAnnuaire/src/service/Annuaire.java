package service;

import beans.Categorie;
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
	
	public void createCategory(String newCategory){
		// create new categorie
		Categorie categorie = new Categorie();
		categorie.setName(newCategory);
		categorieDAO.creer(categorie);
	}
	
	
	
	
	
}
