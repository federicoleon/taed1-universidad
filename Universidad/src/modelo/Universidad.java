package modelo;

import java.util.ArrayList;
import servicios.AlumnoService;
import carreras.IngenieriaEnSoftware;
import enums.Carreras;

public class Universidad {
	private AlumnoService alumnoService;
	private ArrayList <Alumno> alumnos;
	private ArrayList <Carrera> carreras;
	
	public Universidad() {
		this.alumnoService = new AlumnoService();
		this.alumnos = new ArrayList<Alumno>();
		this.carreras = new ArrayList<Carrera>();
		this.cargarCarrerasDisponibles();
		this.cargarAlumnosRegistrados();
	}
	
	private void cargarCarrerasDisponibles() {
		Carrera ingenieriaEnSoftware = new IngenieriaEnSoftware();
		this.carreras.add(ingenieriaEnSoftware);
	}
	
	private void cargarAlumnosRegistrados() {
		this.alumnos = alumnoService.getAlumnosRegistrados();
	}
	
	public ArrayList <Alumno> getAlumnos() {
		return this.alumnos;
	}
	
	public Alumno agregarAlumno(Alumno alumno) {
		if(this.alumnoService.agregarAlumno(alumno)) {
			this.alumnos.add(alumno);
			return alumno;
		}else{
			return null;
		}
	}
	
	public int getCantidadAlumnos() {
		return this.alumnos.size();
	}
	
	public ArrayList <Carrera> getCarreras() {
		return this.carreras;
	}
	
	public Carreras[] getListadoCarreras() {
		return Carreras.values();
	}
}