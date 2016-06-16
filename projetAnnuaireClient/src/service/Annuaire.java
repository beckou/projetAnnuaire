/**
 * Annuaire.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public interface Annuaire extends java.rmi.Remote {
    public int add(int val1, int val2) throws java.rmi.RemoteException;
    public void createCategory(java.lang.String newCategory) throws java.rmi.RemoteException;
    public java.lang.String viewAllAnnonceByCat(long idCat) throws java.rmi.RemoteException;
    public java.lang.String viewAllAnnonceByAdr(long idAdr) throws java.rmi.RemoteException;
    public java.lang.String viewAllAnnonceByNom(java.lang.String nom) throws java.rmi.RemoteException;
    public java.lang.String getCategorieByString(java.lang.String categorie_id) throws java.rmi.RemoteException;
    public java.lang.String getAdresseByString(java.lang.String rue, java.lang.String ville, java.lang.String cp) throws java.rmi.RemoteException;
    public java.lang.String viewAllCategories() throws java.rmi.RemoteException;
    public java.lang.String getCategorie(int categorie_id) throws java.rmi.RemoteException;
    public void createAdresse(java.lang.String rue, java.lang.String ville, java.lang.String cp) throws java.rmi.RemoteException;
    public void delCategorie(int categorie_id) throws java.rmi.RemoteException;
    public void delAnnonce(int annonce_id) throws java.rmi.RemoteException;
    public java.lang.String viewAllAdresse() throws java.rmi.RemoteException;
    public java.lang.String viewAllAnnonce() throws java.rmi.RemoteException;
    public void createAnnonce(java.lang.String nom, int idCat, java.lang.String telephone, long idAdresse) throws java.rmi.RemoteException;
    public void modifyCategorie(int categorie_id, java.lang.String nouveau_nom) throws java.rmi.RemoteException;
}
