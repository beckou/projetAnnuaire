/**
 * Annuaire.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public interface Annuaire extends java.rmi.Remote {
    public void createCategory(java.lang.String newCategory) throws java.rmi.RemoteException;
    public java.lang.String getCategorieByString(java.lang.String categorie_id) throws java.rmi.RemoteException;
    public void delCategorie(int categorie_id) throws java.rmi.RemoteException;
    public void modifyCategorie(int categorie_id, java.lang.String nouveau_nom) throws java.rmi.RemoteException;
    public java.lang.String viewAllCategories() throws java.rmi.RemoteException;
    public java.lang.String getCategorie(int categorie_id) throws java.rmi.RemoteException;
    public int add(int val1, int val2) throws java.rmi.RemoteException;
}
