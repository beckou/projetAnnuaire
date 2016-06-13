package dao;

import java.util.List;


import beans.Categorie;;

public interface CategorieDao {
	  
	void creer( Categorie categorie ) throws DAOException;
    
	void modifier (Integer id,String nouveauNom) throws DAOException;
	
	void supprimer (Integer nom) throws DAOException;
	
	Categorie trouver( Integer id ) throws DAOException;

	List<Categorie> viewAllCategorie();

	
}
