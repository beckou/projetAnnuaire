package beans;


public class Categorie {
	private Integer id;
	private String name;

	public  Categorie(Integer i, String string){
		this.id = i;
		this.name = string;
	}	
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(Integer l) {
		this.id = l;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
