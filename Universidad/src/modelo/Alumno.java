package modelo;

import java.util.ArrayList;

public class Alumno extends Persona {
	private int idAlumno;
	private String legajo;
	private Carrera carrera;
	private ArrayList <Materia> materias;
	
	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	
	public Alumno(String apellido, String nombre, int dni) {
		super(apellido, nombre, dni);
		this.materias = new ArrayList <Materia>();
	}
	
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	
	public String getLegajo() {
		if(this.legajo != null) {
			return this.legajo;
		}else{
			return "Legajo no asignado";
		}
	}
	
	public Carrera getCarrera() {
		return this.carrera;
	}
	
	public String getNombreCarrera() {
		if(this.getCarrera() != null) {
			return this.getCarrera().getNombre();
		}else{
			return "Carrera no asignada";
		}
	}
	
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	public ArrayList <Materia> getMaterias() {
		return this.materias;
	}
	
    @Override
	public boolean equals(Object object) {
	    if (object instanceof Alumno) {
	    	Alumno aux = (Alumno)object;
		    return (super.getDni() == aux.getDni());
	    } else {
	    	return false;
	    }
    }
    
    @Override
	public int hashCode() {
    	return this.getDni();
    }
	
    @Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append("\n");
		result.append("Legajo: ");
		result.append(this.getLegajo());
		result.append("\n");
		result.append("Carrera: ");
		result.append(this.getNombreCarrera());
		return result.toString();
	}
}