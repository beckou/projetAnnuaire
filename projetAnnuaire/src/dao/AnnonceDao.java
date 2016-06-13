package dao;

import beans.Addresse;
import beans.Annonce;
import beans.Categorie;


public interface AnnonceDao {

	  
	void creer( Annonce annonce ) throws DAOException;
  
	void modifier (Long AnnonceId,String name, String tel ) throws DAOException;
	
	void supprimer ( Long id) throws DAOException;
	
	Annonce trouver( Addresse add ) throws DAOException;

	Annonce trouver( Categorie cat ) throws DAOException;

	
	
}
