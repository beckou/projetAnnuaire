package beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Annonce {
	private Long id;
	private String name;
	private long category;
	private Long idAdresse;
	private String tel;
	private String nameAdresse;
	private String nameCategorie;
	
	public Annonce(){
	
		
	
		
	}

	public Annonce(int i, int j, String string2, int k, String string4) {
this.id = (long) i;
this.name = string2;
this.category = j;
this.idAdresse= (long) k;
this.tel = string4;
this.nameCategorie = string2;
}

	public String getName() {
		return name;
	}
	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public long getCategory() {
		return category;
	}
	@XmlAttribute
	public void setCategory(long category) {
		this.category = category;
	}


	public String getTel() {
		return tel;
	}
	@XmlAttribute
	public void setTel(String tel) {
		this.tel = tel;
	}

	public Long getId() {
		return id;
	}
	@XmlAttribute
	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdAdresse() {
		return idAdresse;
	}
	@XmlAttribute
	public void setIdAdresse(Long idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getNameAdresse() {
		return nameAdresse;
	}
	@XmlAttribute
	public void setNameAdresse(String nameAdresse) {
		this.nameAdresse = nameAdresse;
	}

	public String getNameCategorie() {
		return nameCategorie;
	}
	@XmlAttribute
	public void setNameCategorie(String nameCategorie) {
		this.nameCategorie = nameCategorie;
	}
	
}
