package servicios;

import java.util.ArrayList;
import java.util.Iterator;

import enums.Carreras;

import modelo.Alumno;
import modelo.Modelo;

public class AlumnoService {
	
	private UsuarioService usuarioService;
	
	public AlumnoService() {
		this.usuarioService = new UsuarioService();
	}
	
	private MySQLService mysqlService = MySQLService.getInstance();
	
	public boolean agregarAlumno(Alumno alumno) {
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO alumnos ");
		query.append("(apellidos, nombres, dni, legajo)");
		query.append("VALUES( ?, ?, ?, ? )");
		int idAlumno = mysqlService.executeInsert(
			query.toString(), 
			alumno.getApellido(),
			alumno.getNombre(),
			alumno.getDni(),
			alumno.getLegajo()
		);
		alumno.setIdAlumno(idAlumno);
		if(idAlumno > 0) {
			boolean resultadoUsuario = usuarioService.agregarUsuarioDesdeAlumno(alumno);
			boolean resultadoCarrera = this.agregarAlumnoACarrera(alumno);
			return (idAlumno > 0) && resultadoUsuario && resultadoCarrera;
		}else{
			return false;
		}
	}
	
	private boolean agregarAlumnoACarrera(Alumno alumno) {
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO carrerasxalumno ");
		query.append("(idCarrera, idAlumno)");
		query.append("VALUES( ?, ?)");
		int resultado = mysqlService.executeInsert(
			query.toString(), 
			alumno.getCarrera().getId(),
			alumno.getIdAlumno()
		);
		return (resultado > 0);
	}
	
	@SuppressWarnings("unchecked")
	public Alumno getAlumno(Alumno alumno) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT alumnos.*, carreras.id AS idCarrera, carreras.nombre FROM alumnos ");
		query.append("INNER JOIN carrerasxalumno INNER JOIN carreras ");
		query.append("ON alumnos.id=carrerasxalumno.idAlumno AND carrerasxalumno.idCarrera=carreras.id ");
		query.append("WHERE alumnos.apellidos = ? AND alumnos.nombres = ? AND alumnos.dni = ?");
		ArrayList <Alumno> resultadoAlumno = (ArrayList <Alumno>)mysqlService.executeSelect(
			Modelo.ALUMNOS,
			query.toString(), 
			alumno.getApellido(),
			alumno.getNombre(),
			alumno.getDni()
		);
		Iterator <Alumno> iterator = resultadoAlumno.iterator();
		while(iterator.hasNext()) {
			Alumno aux = iterator.next();
			System.out.println(aux);
			if(aux.getDni() == alumno.getDni()) {
				alumno = aux;
				return alumno;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Alumno> getAlumnosRegistrados() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT alumnos.*, carreras.id AS idCarrera, carreras.nombre FROM alumnos ");
		query.append("INNER JOIN carrerasxalumno INNER JOIN carreras ");
		query.append("ON alumnos.id=carrerasxalumno.idAlumno AND carrerasxalumno.idCarrera=carreras.id");
		Object resultadoAlumno = mysqlService.executeSelect(
			Modelo.ALUMNOS,
			query.toString()
		);
		return (ArrayList<Alumno>)resultadoAlumno;
	}
}