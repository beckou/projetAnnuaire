package beans;

public class Addresse {

	private long idAdresse;
	private String rue;
	private String ville;
	private String cp;
	public Addresse(){
		
	}
	public Addresse(int parseInt, String attribute, String attribute2, String attribute3) {

	this.idAdresse = parseInt;
	this.rue = attribute;
	this.ville= attribute2;
	this.cp = attribute3;
	}
	public Long getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(Long idAdresse) {
		this.idAdresse = idAdresse;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	

}
