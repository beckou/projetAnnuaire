package beans;

public class Annonce {
	private Integer id;
	private String name;
	private Integer category;
	private Integer idAdresse;
	private String tel;
	
	private String nameCategorie;

	
	public Annonce(){
	
		
	
		
	}
	public Annonce(Integer id,String name, Integer category, Integer idAdresse, String tel, String NameCategorie){
	
		this.id = id;
		this.name = name;
		this.category = category;
		this.idAdresse = idAdresse;
		this.tel = tel;
		this.nameCategorie = NameCategorie;
	
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}


	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}
	public String getNameCategorie() {
		return nameCategorie;
	}
	public void setNameCategorie(String nameCategorie) {
		this.nameCategorie = nameCategorie;
	}
	
}
