package servicios;

import utils.Seguridad;
import modelo.Alumno;
import modelo.Modelo;
import java.sql.Connection;

public class UsuarioService {
	
	private MySQLService mysqlService = MySQLService.getInstance();
	
	public boolean agregarUsuarioDesdeAlumno(Connection connection, Alumno alumno) {
		int resultado = 0;
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO usuarios ");
		query.append("(dni, password)");
		query.append("VALUES( ?, ? )");
		resultado = mysqlService.executeInsert(
			connection, 
			query.toString(), 
			alumno.getDni(),
			Seguridad.encriptarConMD5(alumno.getDni())
		);
		return (resultado > 0);
	}
	
	public boolean validarExistenciaUsuario(int dni, String password) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT * FROM usuarios ");
		query.append("WHERE dni = ? AND password = ?");
		Object resultado = mysqlService.executeSelect(
			Modelo.USUARIOS, 
			query.toString(), 
			dni,
			Seguridad.encriptarConMD5(password)
		);
		return (resultado != null);
	}
}