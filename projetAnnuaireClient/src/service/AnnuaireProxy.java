package service;

public class AnnuaireProxy implements service.Annuaire {
  private String _endpoint = null;
  private service.Annuaire annuaire = null;
  
  public AnnuaireProxy() {
    _initAnnuaireProxy();
  }
  
  public AnnuaireProxy(String endpoint) {
    _endpoint = endpoint;
    _initAnnuaireProxy();
  }
  
  private void _initAnnuaireProxy() {
    try {
      annuaire = (new service.AnnuaireServiceLocator()).getAnnuaire();
      if (annuaire != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)annuaire)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)annuaire)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (annuaire != null)
      ((javax.xml.rpc.Stub)annuaire)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public service.Annuaire getAnnuaire() {
    if (annuaire == null)
      _initAnnuaireProxy();
    return annuaire;
  }
  
  public void createCategory(java.lang.String newCategory) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    annuaire.createCategory(newCategory);
  }
  
  public void delAnnonce(int annonce_id) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    annuaire.delAnnonce(annonce_id);
  }
  
  public java.lang.String getCategorie(int categorie_id) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    return annuaire.getCategorie(categorie_id);
  }
  
  public java.lang.String viewAllCategories() throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    return annuaire.viewAllCategories();
  }
  
  public java.lang.String viewAllAnnonce() throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    return annuaire.viewAllAnnonce();
  }
  
  public java.lang.String viewAllAnnonceByCat(long idCat) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    return annuaire.viewAllAnnonceByCat(idCat);
  }
  
  public java.lang.String viewAllAnnonceByAdr(long idAdr) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    return annuaire.viewAllAnnonceByAdr(idAdr);
  }
  
  public void createAnnonce(java.lang.String nom, int idCat, java.lang.String telephone, long idAdresse) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    annuaire.createAnnonce(nom, idCat, telephone, idAdresse);
  }
  
  public java.lang.String getAdresseByString(java.lang.String rue, java.lang.String ville, java.lang.String cp) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    return annuaire.getAdresseByString(rue, ville, cp);
  }
  
  public void delCategorie(int categorie_id) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    annuaire.delCategorie(categorie_id);
  }
  
  public void modifyCategorie(int categorie_id, java.lang.String nouveau_nom) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    annuaire.modifyCategorie(categorie_id, nouveau_nom);
  }
  
  public java.lang.String getCategorieByString(java.lang.String categorie_id) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    return annuaire.getCategorieByString(categorie_id);
  }
  
  public void createAdresse(java.lang.String rue, java.lang.String ville, java.lang.String cp) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    annuaire.createAdresse(rue, ville, cp);
  }
  
  public int add(int val1, int val2) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    return annuaire.add(val1, val2);
  }
  
  public java.lang.String viewAllAnnonceByNom(java.lang.String nom) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    return annuaire.viewAllAnnonceByNom(nom);
  }
  
  public java.lang.String viewAllAdresse() throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    return annuaire.viewAllAdresse();
  }
  
  
}