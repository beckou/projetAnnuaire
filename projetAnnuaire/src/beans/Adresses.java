package beans;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "adresses")
@XmlAccessorType(XmlAccessType.FIELD)
public class Adresses {

	@XmlElement(name = "adresse")
private List<Addresse> adresses = null;

	public List<Addresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Addresse> l_Adresse) {
		this.adresses = l_Adresse;
	}
}