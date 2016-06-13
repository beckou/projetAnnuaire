package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import beans.Addresse;
import beans.Annonce;
import beans.Categorie;

import static dao.DAOUtilitaire.initialisationRequetePreparee;
import static dao.DAOUtilitaire.fermeturesSilencieuses;


public class AnnonceDaoImpl implements AnnonceDao{

	
	private DAOFactory daoFactory;
    private static final String SQL_INSERT = "INSERT INTO Annonce (idAnnonce, nomAnnonce, telephone, idAdresse) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM Annonce WHERE idAnnonce = ?";
    private static final String SQL_SELECT_PAR_CATEGORIE = "SELECT * FROM Annonce WHERE idCategorie = ?";
    private static final String SQL_SELECT_PAR_ADRESSE = "SELECT * FROM Annonce WHERE idAdresse = ?";
    private static final String SQL_MODIFY = "UPDATE Annonce SET nomAnnonce = ? telephone = ? WHERE idAnnonce = ?  ";
    
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

            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, annonce.getId(), annonce.getName(),annonce.getTel(), annonce.getIdAdresse() );
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
	public void modifier(Long AnnonceId, String name, String tel) throws DAOException {
		// TODO Auto-generated method stub
		
		
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = (Connection) daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_MODIFY, false, name,tel, AnnonceId);
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
	public void supprimer(Long id) throws DAOException {
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
	    annonce.setName(resultSet.getString( "nomAnnonce" ));
	    annonce.setTel(resultSet.getString( "telephone" )); 

	    return annonce;
	}

	
	
	
}
