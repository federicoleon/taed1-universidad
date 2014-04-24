package modelo;

public abstract class Persona {
	private String apellido;
	private String nombre;
	private int dni;
	
	public Persona(String apellido, String nombre, int dni) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDni(dni);
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder("Apellido: ");
		result.append(this.getApellido());
		result.append("\n");
		result.append("Nombre: ");
		result.append(this.getNombre());
		result.append("\n");
		result.append("DNI: ");
		result.append(this.getDni());
		return result.toString();
	}
}