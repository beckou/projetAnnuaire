package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import static dao.DAOUtilitaire.initialisationRequetePreparee;
import static dao.DAOUtilitaire.fermeturesSilencieuses;



import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import beans.Addresse;

public class AdresseDaoImpl implements AdresseDao{

	private DAOFactory daoFactory;
	
	
	AdresseDaoImpl(DAOFactory daoFactory){
		 this.daoFactory = daoFactory;
	}
	
	
    private static final String SQL_INSERT = "INSERT INTO Adresse (idAdresse,  rue, ville, cp) VALUES (?, ?, ?, ?)";
   
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

	
	
}
