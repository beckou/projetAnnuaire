package beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Addresse {

	private Long idAdresse;
	private String rue;
	private String ville;
	private String cp;
	
	public Addresse(){
		
	}
	
	public Addresse(Long Id,String rue,String ville,String cp){
		this.idAdresse =  Id;
		this.rue = rue;
		this.ville = ville;
		this.cp = cp;
	}
	public Long getIdAdresse() {
		return idAdresse;
	}
	@XmlAttribute
	public void setIdAdresse(Long idAdresse) {
		this.idAdresse = idAdresse;
	}
	public String getRue() {
		return rue;
	}
	@XmlAttribute
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	@XmlAttribute
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCp() {
		return cp;
	}
	@XmlAttribute
	public void setCp(String cp) {
		this.cp = cp;
	}
	

}
