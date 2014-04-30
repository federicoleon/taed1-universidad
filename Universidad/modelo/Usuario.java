package modelo;

import java.util.Date;

public class Usuario {
	private int id;
	private String email;
	private String password;
	private Date ultimoAcceso;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}
	
	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}
}