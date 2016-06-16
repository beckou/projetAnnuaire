package dao;

import java.util.List;

import beans.Addresse;
import beans.Annonce;
import beans.Categorie;


public interface AnnonceDao {

	  
	void creer( Annonce annonce ) throws DAOException;
  
	void modifier (long AnnonceId,String name, String tel ) throws DAOException;
	
	void supprimer ( long id) throws DAOException;
	
	Annonce trouver( Addresse add ) throws DAOException;

	Annonce trouver( Categorie cat ) throws DAOException;

	Annonce trouver( Integer id_Annonce ) throws DAOException;

	public   String getCategorieName(Long id);
	
	List<Annonce> viewAllAnnonce();

	List<Annonce> viewAllAnnonceByCat(long idCat);

	List<Annonce> viewAllAnnonceByAdr(long idAdr);

	
	List<Annonce> viewAllAnnonceByNom(String nomAnn);

}
