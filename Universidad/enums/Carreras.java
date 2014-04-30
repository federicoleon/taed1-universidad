package enums;

public enum Carreras {
	
	INGENIERIA_EN_SOFTWARE(1, "Ingenier’a en Software");

	private int id;
	private String nombre;

	private Carreras(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public static Carreras getCarrera(int id) {
		Carreras resultado = null;
		switch(id) {
			case 1:
				resultado = INGENIERIA_EN_SOFTWARE;
			break;
		}
		return resultado;
	}
}