package dao;

import java.util.List;

import beans.Addresse;
import beans.Categorie;

public interface AdresseDao {

	void creer( Addresse adresse ) throws DAOException;	
	
	Addresse trouverByNom(String rue,String ville,String cp) throws DAOException;	
	List<Addresse> viewAllAdresse();

	

}