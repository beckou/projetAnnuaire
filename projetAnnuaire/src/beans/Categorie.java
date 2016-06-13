package beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Categorie {
	private long Id;
	private String Name;

	
	public  Categorie(Integer Id,String Name){
		this.Id = Id;
		this.Name = Name;
	}	
	
	public Categorie() {
}
	public long getId() {
		return Id;
	}

	public String getName() {
		return Name;
	}
	
	
	@XmlAttribute
	public Categorie setId(long l) {
		this.Id = l;
		return this;
}
	
	@XmlAttribute
	public Categorie setName(String nom) {
		this.Name = nom;
		return this;
}
	
}
