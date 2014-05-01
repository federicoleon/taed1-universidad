package servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.Alumno;
import modelo.Modelo;

public class AlumnoService {
	
	private UsuarioService usuarioService;
	
	public AlumnoService() {
		this.usuarioService = new UsuarioService();
	}
	
	private MySQLService mysqlService = MySQLService.getInstance();
	
	public boolean agregarAlumno(Alumno alumno) {
		Connection connection = mysqlService.getConexion();
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO alumnos ");
		query.append("(apellidos, nombres, dni, legajo)");
		query.append("VALUES( ?, ?, ?, ? )");
		int idAlumno = mysqlService.executeInsert(
			connection,
			query.toString(), 
			alumno.getApellido(),
			alumno.getNombre(),
			alumno.getDni(),
			alumno.getLegajo()
		);
		alumno.setIdAlumno(idAlumno);
		if(idAlumno > 0) {
			boolean resultadoUsuario = usuarioService.agregarUsuarioDesdeAlumno(connection, alumno);
			boolean resultadoCarrera = this.agregarAlumnoACarrera(connection, alumno);
			try {
				if ((idAlumno > 0) && resultadoUsuario && resultadoCarrera) {
					connection.commit();
					connection.close();
					return true;
				}else{
					connection.rollback();
					connection.close();
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}else{
			try {
				connection.rollback();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	}
	
	private boolean agregarAlumnoACarrera(Connection connection, Alumno alumno) {
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO carrerasxalumno ");
		query.append("(idCarrera, idAlumno)");
		query.append("VALUES( ?, ?)");
		int resultado = mysqlService.executeInsert(
			connection,
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