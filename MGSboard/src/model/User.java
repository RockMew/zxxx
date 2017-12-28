package model;

public class User {
	private String name;
	private String password;
	private String administrator;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private long id;
	
	
	public String getAdministrator() {
		return administrator;
	}
	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
