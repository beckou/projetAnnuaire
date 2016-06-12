package dao;

import beans.Categorie;;

public interface CategorieDao {
	  
	void creer( Categorie categorie ) throws DAOException;
    
	void modifier (String nom,String nouveauNom) throws DAOException;
	
	void supprimer (String nom) throws DAOException;
	
	Categorie trouver( String id ) throws DAOException;

}
