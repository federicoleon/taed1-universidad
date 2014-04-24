package servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import carreras.IngenieriaEnSoftware;

import enums.Carreras;

import modelo.Alumno;
import modelo.Carrera;
import modelo.Modelo;
import modelo.Usuario;

public class MySQLService {
	private static final String DB_NAME = "universidad";
	private static final String USER="root";
	private static final String PASSWORD="";
	private static final String SERVIDOR = "jdbc:mysql://localhost/".concat(DB_NAME);
	private static MySQLService instance;
	private Connection conexion;
	 
	public MySQLService() {
		this.connect();
	}
	
	public static MySQLService getInstance() {
		if (MySQLService.instance == null) {
			MySQLService.instance = new MySQLService();
		}
		return instance;
	}
	
	public void connect() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(SERVIDOR, USER, PASSWORD);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexion() {
		return conexion;
	}
	
	public int executeInsert(String query, Object... parameters) {
		Connection connection = getConexion();
		int resultado = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			addParameters(statement, parameters);
			try {
				statement.executeUpdate();
				ResultSet keys = statement.getGeneratedKeys();
				keys.next();  
				resultado = keys.getInt(1);
			} catch(SQLException e) {
				resultado = 0;
			} finally {
				statement.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public Object executeSelect(int expectedInstance, String query, Object... parameters) {
		Object resultado = null;
		switch(expectedInstance) {
			case Modelo.USUARIOS:
				resultado = this.selectUsuarios(query, parameters);
			break;
			
			case Modelo.ALUMNOS:
				resultado = this.selectAlumnos(query, parameters);
			break;
		}
		return resultado;
	}
	
	private ArrayList <Alumno> selectAlumnos(String query, Object... parameters) {
		Connection connection = this.getConexion();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(query);
			addParameters(statement, parameters);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		ArrayList <Alumno> resultado = new ArrayList<Alumno>();
		try {
			resultSet = statement.executeQuery();	
			while(resultSet.next()) {
				Alumno aux = new Alumno(
					resultSet.getString("apellidos"),
					resultSet.getString("nombres"),
					resultSet.getInt("dni")
				);
				aux.setIdAlumno(resultSet.getInt("id"));
				aux.setLegajo(resultSet.getString("legajo"));
				switch(resultSet.getInt("idCarrera")) {
				case 1:
					Carrera carrera = new IngenieriaEnSoftware();
					aux.setCarrera(carrera);
				}
				resultado.add(aux);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}	
				statement.close();
			} catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return resultado;
	}
	
	private Usuario selectUsuarios(String query, Object... parameters) {
		Connection connection = this.getConexion();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(query);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		Usuario resultado = null;
		try {
			this.addParameters(statement, parameters);
			resultSet = statement.executeQuery();	
			if (!resultSet.next()) {
				return null;
			} else {
				resultado = new Usuario();
				resultado.setId(resultSet.getInt("id"));
				resultado.setEmail(resultSet.getString("email"));
				resultado.setPassword(resultSet.getString("password"));
				resultado.setUltimoAcceso(resultSet.getDate("ultimoAcceso"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}	
				statement.close();
			} catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return resultado;
	}
	
	private void addParameters(PreparedStatement statement, Object... parameters) throws SQLException {
		if (parameters != null && parameters.length > 0) {
			for (int index = 0; index < parameters.length; index++) {
				statement.setObject(index + 1, parameters[index]);
			}
		}
	}
}