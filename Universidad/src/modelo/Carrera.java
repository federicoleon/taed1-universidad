package modelo;

import java.util.HashMap;
import enums.Carreras;
import enums.MateriasIngenieriaEnSoftware;

public abstract class Carrera {
	private int id;
	private String nombre;
	private HashMap <Integer,Materia> materias;
	
	public Carrera() {
		this.id = 0;
		this.nombre = "No asignada";
		this.materias = new HashMap <Integer,Materia>();
	}
	
	public Carrera(Carreras carrera) {
		this.id = carrera.getId();
		this.nombre = carrera.getNombre();
		this.inicializarMaterias(carrera);
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNombre() {
		if(this.nombre != null) {
			return this.nombre;
		}else{
			return "Nombre de carrera no asignado";
		}
	}
	
	public HashMap<Integer,Materia> getMaterias() {
		if(this.materias == null) {
			this.materias = new HashMap <Integer,Materia>();
		}
		return this.materias;
	}
	
	public HashMap<Integer,Materia> getMaterias(int anioDictado) {
		HashMap<Integer,Materia> result = new HashMap<Integer,Materia>();
		Materia aux = null;
		for(int i=0; i<this.materias.size(); i++) {
			aux = this.materias.get(i+1);
			if(aux.getAnioDictado() == anioDictado) {
				result.put(aux.getId(), aux);
			}
		}
		return result;
	}
	
	public HashMap<Integer,Materia> getMaterias(int anioDictado, int semestreDictado) {
		HashMap<Integer,Materia> result = new HashMap<Integer,Materia>();
		Materia aux = null;
		for(int i=0; i<this.materias.size(); i++) {
			aux = this.materias.get(i+1);
			if(aux.getAnioDictado() == anioDictado && aux.getSemestreDictado() == semestreDictado) {
				result.put(aux.getId(), aux);
			}
		}
		return result;
	}
	
	private void inicializarMaterias(Carreras carrera) {
		switch(carrera.getId()) {
			case 1:
				this.materias = MateriasIngenieriaEnSoftware.getMaterias();
			break;
		}
	}
	
	public String toString() {
		StringBuilder resultado = new StringBuilder();
		resultado.append("ID: ");
		resultado.append(this.getId());
		resultado.append("\n");
		resultado.append("Nombre: ");
		resultado.append(this.getNombre());
		resultado.append("\n");
		resultado.append("Cantidad de materias: ");
		resultado.append(this.getMaterias().size());
		return resultado.toString();
	}
}