package beans;

public class Annonce {
	private Long id;
	private String name;
	private String category;
	private Long idAdresse;
	private String tel;
	
	public Annonce(){
	
		
	
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(Long idAdresse) {
		this.idAdresse = idAdresse;
	}
	
}
