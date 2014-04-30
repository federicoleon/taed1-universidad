package modelo;

import java.util.ArrayList;
import enums.Carreras;
import enums.MateriasIngenieriaEnSoftware;

public abstract class Carrera {
	private int id;
	private String nombre;
	private ArrayList <Materia> materias;
	
	public Carrera() {
		this.id = 0;
		this.nombre = "No asignada";
		this.materias = new ArrayList <Materia>();
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
	
	public ArrayList<Materia> getMaterias() {
		if(this.materias == null) {
			this.materias = new ArrayList <Materia>();
		}
		return this.materias;
	}
	
	public ArrayList<Materia> getMaterias(int anioDictado) {
		ArrayList<Materia> result = new ArrayList<Materia>();
		Materia aux = null;
		for(int i=0; i<this.materias.size(); i++) {
			aux = this.materias.get(i+1);
			if(aux.getAnioDictado() == anioDictado) {
				result.add(aux);
			}
		}
		return result;
	}
	
	public ArrayList<Materia> getMaterias(int anioDictado, int semestreDictado) {
		ArrayList<Materia> result = new ArrayList<Materia>();
		Materia aux = null;
		for(int i=0; i<this.materias.size(); i++) {
			aux = this.materias.get(i+1);
			if(aux.getAnioDictado() == anioDictado && aux.getSemestreDictado() == semestreDictado) {
				result.add(aux);
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