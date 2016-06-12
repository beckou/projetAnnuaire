package dao;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;


import java.sql.ResultSet;
import java.sql.SQLException;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dao.DAOFactory;

import dao.DAOException;

import beans.Categorie;

public class CategorieDaoImpl implements CategorieDao{

	
    private static final String SQL_INSERT = "INSERT INTO Categorie (idCategorie, nomCategorie) VALUES (?, ?)";
    private static final String SQL_DELETE_PAR_NOM = "DELETE FROM Categorie WHERE nomCategorie = ?";
    private static final String SQL_MODIFIER_PAR_NOM = "UPDATE Categorie SET nomCategorie = ? WHERE nomCategorie = ?  ";
    private static final String SQL_SELECT_PAR_NOM = "SELECT * FROM Categorie WHERE nomCategorie = ?";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM Categorie WHERE idCategorie = ?";
    private static final String SQL_MODIFIER_PAR_ID = "UPDATE Categorie SET nomCategorie = ? WHERE idCategorie = ?  ";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM Categorie WHERE idCategorie = ?";

	private DAOFactory daoFactory;
 //   private static final String SQL_INSERT = "INSERT INTO Answers (idAnswer,  idQuest, intitule, status) VALUES (?, ?, ?, ?)";


	CategorieDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	
	@Override
	public void creer(Categorie categorie) throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = (Connection) daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true,categorie.getId(),categorie.getName());
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */   
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
                categorie.setId( valeursAutoGenerees.getLong( 1 ) );
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
	public void modifier(String nom,String nouveauNom) throws DAOException {
		// TODO Auto-generated method stub
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = (Connection) daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_MODIFIER_PAR_NOM, true,nouveauNom,nom );
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
	public void supprimer(String nom) throws DAOException {
		// TODO Auto-generated method stub
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = (Connection) daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_NOM, true,nom );
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
	public Categorie trouver(String nomCategorie) throws DAOException {
		// TODO Auto-generated method stub
		
	 	 Connection connexion = null;
 	    PreparedStatement preparedStatement = null;
 	    ResultSet resultSet = null;
 	    Categorie categorie = null;

 	    try {
 	        /* Récupération d'une connexion depuis la Factory */
 	        connexion = (Connection) daoFactory.getConnection();
 	        preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_NOM, false, nomCategorie );
 	        resultSet = preparedStatement.executeQuery();
 	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
 	        if ( resultSet.next() ) {
 	        	// ligne sûrement à décommenter plus tard
 	        	
 	            categorie = map( resultSet );
 	            
 	            
 	        }
 	    } catch ( SQLException e ) {
 	        throw new DAOException( e );
 	    } finally {
 	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
 	    }

 	    return categorie;
		
	}

	
	private static Categorie map( ResultSet resultSet ) throws SQLException {
	    Categorie cat = new Categorie();
	    cat.setId( resultSet.getLong( "idCategorie" ) );
	    cat.setName( resultSet.getString( "nomCategorie" ) );	    
	    return cat;
	}

}
