package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import beans.Addresse;
import beans.Annonce;
import beans.Categorie;
import beans.Categories;

import static dao.DAOUtilitaire.initialisationRequetePreparee;
import static dao.DAOUtilitaire.fermeturesSilencieuses;


public class AnnonceDaoImpl implements AnnonceDao{

	
	private DAOFactory daoFactory;
    private static final String SQL_INSERT = "INSERT INTO Annonce (idAnnonce, idCategorie, nomAnnonce, telephone, idAdresse) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM Annonce WHERE idAnnonce = ?";
    private static final String SQL_SELECT_PAR_CATEGORIE = "SELECT SQL_CALC_FOUND_ROWS * FROM Annonce WHERE idCategorie = ?";
    private static final String SQL_SELECT_PAR_ADRESSE = "SELECT SQL_CALC_FOUND_ROWS * FROM Annonce WHERE idAdresse = ?";
    private static final String SQL_MODIFY = "UPDATE Annonce SET nomAnnonce = ?, telephone = ?, idCategorie = ? WHERE idAnnonce = ?  ";
    private static final String SQL_SELECT_PAR_NOM = "SELECT * FROM Annonce WHERE idAnnonce = ?";
    private static final String SQL_GET_NOM_PAR_ID = "SELECT nomCategorie FROM Categorie WHERE idCategorie = ?";

    
    
    
//	idAnnonce
//	idCategorie
//	nomAnnonce
//	telephone
//	idAdresse
	
	
	AnnonceDaoImpl(DAOFactory daoFactory){
		 this.daoFactory = daoFactory;
	}
	
    
	@Override
	public void creer(Annonce annonce) throws DAOException {
		// TODO Auto-generated method stub
		
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        
        
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = (Connection) daoFactory.getConnection();      // (idAnnonce,   nomAnnonce, telephone, idAdresse) VALUES (?, ?, ?, ?, ?)";

            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, annonce.getId(),annonce.getCategory(), annonce.getName(),annonce.getTel(), annonce.getIdAdresse() );
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */   
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
            	annonce.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
		
		
		
	}

	@Override
	public void modifier(long AnnonceId, String name, String tel, long idCat) throws DAOException {
		// TODO Auto-generated method stub
		
		
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = (Connection) daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_MODIFY, false, name,tel,idCat, AnnonceId);
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création de la question, aucune ligne ajoutée dans la table." );
            }

        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
		
		
	}

	@Override
	public void supprimer(long id) throws DAOException {
		// TODO Auto-generated method stub
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = (Connection) daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_ID, true,id );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la suppression du client, aucune ligne supprimée de la table." );
            } else {
              //  user.setId( null );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
	}
	
	
	

	@Override
	public Annonce trouver(Addresse add) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Annonce trouver(Categorie cat) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des utilisateurs (un
	 * ResultSet) et un bean Utilisateur.
	 */
	
//	idAnnonce
//	idCategorie
//	nomAnnonce
//	telephone
//	idAdresse
	
	
	private static Annonce map( ResultSet resultSet ) throws SQLException {
	    Annonce annonce = new Annonce();
	    annonce.setId( resultSet.getLong( "idAnnonce" ) );
	    annonce.setCategory(resultSet.getLong( "idCategorie" ) );
	    annonce.setName(resultSet.getString( "nomAnnonce" ));
	    annonce.setTel(resultSet.getString( "telephone" )); 
	    annonce.setIdAdresse(resultSet.getLong( "idAdresse" ));
	    

	    
	    return annonce;
	}
	
	
	@Override
	 public   String getCategorieName(Long id){
		
		

		
		
		
		
		
		
		
		
		
		
		/////
		Connection connexion = null;
 	    PreparedStatement preparedStatement = null;
 	    ResultSet resultSet = null;
 	    
 	   String name;

       Statement stmt = null;
       
	       
		 String query = "SELECT nomCategorie FROM Categorie WHERE idCategorie ="+ id;
			   try {
		  connexion = (Connection) daoFactory.getConnection();
		   stmt = (Statement) connexion.createStatement();
		  ResultSet rs = stmt.executeQuery(query);
			  
		  while (rs.next()) {
			  
			  name = rs.getString( "nomCategorie" );
			  return name;

		  }
		  rs.close();
		  
		   
		
		} catch (SQLException e) {
		  e.printStackTrace();
		}finally
		{
		  try {
		      if(stmt != null)
		          stmt.close();
		      if(connexion != null)
		    	  connexion.close();
		      } catch (SQLException e) {
		      e.printStackTrace();
		  }
		}
		
		return null;
	}


	@Override
	public List<Annonce> viewAllAnnonce() {
		Connection connexion = null;
 	    PreparedStatement preparedStatement = null;
 	    ResultSet resultSet = null;

 	   List<Annonce> list = new ArrayList<Annonce>();
 	  Annonce cat = null; 

       Statement stmt = null;
       

 	 
       String query = "select SQL_CALC_FOUND_ROWS * from Annonce";
    		   try {
    	  connexion = (Connection) daoFactory.getConnection();
           stmt = (Statement) connexion.createStatement();
          ResultSet rs = stmt.executeQuery(query);
          while (rs.next()) {
        	  cat = map( rs );
        	  
        	  String nameCate = getCategorieName(rs.getLong( "idCategorie" ) );

        	  System.out.println(nameCate);
        	  cat.setNameCategorie(nameCate);
        	  
	          list.add(cat);
          }
          rs.close();
           
          rs = stmt.executeQuery("SELECT FOUND_ROWS()");

      } catch (SQLException e) {
          e.printStackTrace();
      }finally
      {
          try {
              if(stmt != null)
                  stmt.close();
              if(connexion != null)
            	  connexion.close();
              } catch (SQLException e) {
              e.printStackTrace();
          }
      }
 	    
 	    
 	    return list;
	}


	@Override
	public List<Annonce> viewAllAnnonceByCat(long idCat) {
		Connection connexion = null;
 	    PreparedStatement preparedStatement = null;
 	    ResultSet resultSet = null;


 	   List<Annonce> list = new ArrayList<Annonce>();
 	  Annonce cat = null; 

       Statement stmt = null;
       
       System.out.println("Servlet Parcours");

       String query = "select SQL_CALC_FOUND_ROWS * from Annonce WHERE idCategorie ="+ idCat;
      try {
    	  connexion = (Connection) daoFactory.getConnection();
           stmt = (Statement) connexion.createStatement();
          ResultSet rs = stmt.executeQuery(query);
          while (rs.next()) {
	    	  cat = map( rs );
	    	  String nameCate = getCategorieName(rs.getLong( "idCategorie" ) );

        	  System.out.println(nameCate);
        	  cat.setNameCategorie(nameCate);
	    	  
	          list.add(cat);
          }
          rs.close();
          rs = stmt.executeQuery("SELECT FOUND_ROWS()");

      } catch (SQLException e) {
          e.printStackTrace();
      }finally
      {
          try {
              if(stmt != null)
                  stmt.close();
              if(connexion != null)
            	  connexion.close();
              } catch (SQLException e) {
              e.printStackTrace();
          }
      }
 	    
 	    
 	    return list;
	}


	@Override
	public List<Annonce> viewAllAnnonceByAdr(long idAdr) {
		Connection connexion = null;
 	    PreparedStatement preparedStatement = null;
 	    ResultSet resultSet = null;


 	   List<Annonce> list = new ArrayList<Annonce>();
 	  Annonce cat = null; 

       Statement stmt = null;
       
       System.out.println("Servlet Parcours");

       String query = "select SQL_CALC_FOUND_ROWS * from Annonce WHERE idAdresse ="+ idAdr;
      try {
    	  connexion = (Connection) daoFactory.getConnection();
           stmt = (Statement) connexion.createStatement();
          ResultSet rs = stmt.executeQuery(query);
          while (rs.next()) {
	    	  cat = map( rs );
	    	  String nameCate = getCategorieName(rs.getLong( "idCategorie" ) );

        	  System.out.println(nameCate);
        	  cat.setNameCategorie(nameCate);
	          list.add(cat);
          }
          rs.close();
          rs = stmt.executeQuery("SELECT FOUND_ROWS()");

      } catch (SQLException e) {
          e.printStackTrace();
      }finally
      {
          try {
              if(stmt != null)
                  stmt.close();
              if(connexion != null)
            	  connexion.close();
              } catch (SQLException e) {
              e.printStackTrace();
          }
      }
 	    
 	    
 	    return list;
	}


	
	
	@Override
	public Annonce trouver(Integer id_Annonce) throws DAOException {
		 Connection connexion = null;
	 	    PreparedStatement preparedStatement = null;
	 	    ResultSet resultSet = null;
	 	    Annonce annonce = null;

	 	    try {
	 	        /* Récupération d'une connexion depuis la Factory */
	 	        connexion = (Connection) daoFactory.getConnection();
	 	        preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_NOM, false, id_Annonce );
	 	        resultSet = preparedStatement.executeQuery();
	 	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	 	        if ( resultSet.next() ) {
	 	        	// ligne sûrement à décommenter plus tard
	 	        	
	 	            annonce = map( resultSet );
	 	            
	 	            
	 	        }
	 	    } catch ( SQLException e ) {
	 	        throw new DAOException( e );
	 	    } finally {
	 	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	 	    }

	 	    return annonce;
	}


	@Override
	public List<Annonce> viewAllAnnonceByNom(String nomAnn) {
		Connection connexion = null;
 	    PreparedStatement preparedStatement = null;
 	    ResultSet resultSet = null;


 	   List<Annonce> list = new ArrayList<Annonce>();
 	  Annonce cat = null; 

       Statement stmt = null;
       

       String query = "select SQL_CALC_FOUND_ROWS * from Annonce WHERE nomAnnonce REGEXP '"+ nomAnn + "*'";
      try {
    	  connexion = (Connection) daoFactory.getConnection();
           stmt = (Statement) connexion.createStatement();
          ResultSet rs = stmt.executeQuery(query);
          while (rs.next()) {
	    	  cat = map( rs );
	    	  String nameCate = getCategorieName(rs.getLong( "idCategorie" ) );

        	  System.out.println(nameCate);
        	  cat.setNameCategorie(nameCate);
	          list.add(cat);
          }
          rs.close();
          rs = stmt.executeQuery("SELECT FOUND_ROWS()");

      } catch (SQLException e) {
          e.printStackTrace();
      }finally
      {
          try {
              if(stmt != null)
                  stmt.close();
              if(connexion != null)
            	  connexion.close();
              } catch (SQLException e) {
              e.printStackTrace();
          }
      }
 	    
 	    
 	    return list;
	}	
	
}

	
	
	

