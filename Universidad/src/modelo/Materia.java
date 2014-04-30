package modelo;

import enums.EstadoMateria;

public class Materia {
	private int id;
	private String nombre;
	private int anioDictado;
	private int semestreDictado;
	private int estado;
	
	public Materia(int id, String nombre, int anioDictado, int semestreDictado) {
		this.id = id;
		this.nombre = nombre;
		this.anioDictado = anioDictado;
		this.semestreDictado = semestreDictado;
		this.estado = EstadoMateria.SIN_CURSAR.getEstado();
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getAnioDictado() {
		return anioDictado;
	}
	
	public void setAnioDictado(int anioDictado) {
		this.anioDictado = anioDictado;
	}
	
	public int getSemestreDictado() {
		return semestreDictado;
	}
	
	public void setSemestreDictado(int semestreDictado) {
		this.semestreDictado = semestreDictado;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
    @Override
    public boolean equals(Object object) {
	    if (object instanceof Materia) {
		    Materia aux = (Materia)object;
		    return (this.getId() == aux.getId());
	    } else {
	    	return false;
	    }
    }
    
    @Override
    public int hashCode() {
    	return this.getNombre().hashCode();
    }
    
    public String toString() {
    	StringBuilder result = new StringBuilder("\n");
    	result.append("ID:"); 
    	result.append(this.getId());
    	result.append("\n");
    	result.append("Nombre: ");
    	result.append(this.getNombre());
    	result.append("\n");
    	result.append("A–o de dictado: ");
    	result.append(this.getAnioDictado());
    	result.append("\n");
    	result.append("Semestre de dictado: ");
    	result.append(this.getSemestreDictado());
    	return result.toString();
    }
}