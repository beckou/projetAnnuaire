package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.DAOUtilitaire.initialisationRequetePreparee;
import static dao.DAOUtilitaire.fermeturesSilencieuses;



import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import beans.Addresse;
import beans.Categorie;

public class AdresseDaoImpl implements AdresseDao{

	private DAOFactory daoFactory;
	
	
	AdresseDaoImpl(DAOFactory daoFactory){
		 this.daoFactory = daoFactory;
	}
	
	
    private static final String SQL_INSERT = "INSERT INTO Adresse (idAdresse,  rue, ville, cp) VALUES (?, ?, ?, ?)";
    private static final String SQL_SELECT_PAR_NOMB = "SELECT * FROM Adresse WHERE rue = ? AND ville = ? AND cp = ?";

//	idAdresse
//	rue
//	ville
//	cp
//	
	@Override
	public void creer(Addresse adresse) throws DAOException {
		// TODO Auto-generated method stub
		
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = (Connection) daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, adresse.getIdAdresse(), adresse.getRue(), adresse.getVille(),adresse.getCp() );
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */   
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
                adresse.setIdAdresse( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
		
		
		
		
	}

	
	
	private static Addresse map( ResultSet resultSet ) throws SQLException {
	    Addresse adresse = new Addresse();
	    adresse.setIdAdresse( resultSet.getLong( "idAdresse" ) );
	    adresse.setRue(resultSet.getString( "rue" ));
	    adresse.setVille(resultSet.getString( "ville" )); 
	    adresse.setCp(resultSet.getString( "ville" )); 

	    return adresse;
	}



	@Override
	public Addresse trouverByNom(String rue, String ville, String cp) throws DAOException {
		
	 	 Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Addresse adresse = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = (Connection) daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_NOMB, false, rue, ville, cp );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	// ligne sûrement à décommenter plus tard
	        	
	        	adresse = map( resultSet );
	            
	            
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

	    return adresse;
			}



	@Override
	public List<Addresse> viewAllAdresse() {
		Connection connexion = null;
 	    PreparedStatement preparedStatement = null;
 	    ResultSet resultSet = null;

 	   List<Addresse> list = new ArrayList<Addresse>();
 	  Addresse cat = null; 

       Statement stmt = null;
       

 	 
       String query = "select SQL_CALC_FOUND_ROWS * from Adresse";
    		   try {
    	  connexion = (Connection) daoFactory.getConnection();
           stmt = (Statement) connexion.createStatement();
          ResultSet rs = stmt.executeQuery(query);
          while (rs.next()) {
        	  cat = map( rs );
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

	
	

