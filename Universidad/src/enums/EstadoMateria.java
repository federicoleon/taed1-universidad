package enums;

public enum EstadoMateria {
	SIN_CURSAR(1, "Sin cursar"),
	CURSANDO(2, "Cursando"),
	REGULAR(3, "Regular"),
	PROMOCIONADA(4, "Promocionada"),
	APROBADA(5, "Aprobada"),
	LIBRE_POR_NOTA(6, "Libre por nota"),
	LIBRE_POR_FALTAS(7, "Libre por faltas");
	
	private final int estado;
	private final String nombreEstado;
	
	private EstadoMateria(int estado, String nombreEstado) {
        this.estado = estado;
        this.nombreEstado = nombreEstado;
    }
	
	public int getEstado() {
		return this.estado;
	}
	
	public String getNombreEstado() {
		return this.nombreEstado;
	}
	
	public static String getNombreEstado(int idEstado) {
		switch(idEstado) {
			case 1:
				return EstadoMateria.SIN_CURSAR.getNombreEstado();
			case 2:
				return EstadoMateria.CURSANDO.getNombreEstado();
			case 3:
				return EstadoMateria.REGULAR.getNombreEstado();
			case 4:
				return EstadoMateria.PROMOCIONADA.getNombreEstado();
			case 5:
				return EstadoMateria.APROBADA.getNombreEstado();
			case 6:
				return EstadoMateria.LIBRE_POR_NOTA.getNombreEstado();
			case 7:
				return EstadoMateria.LIBRE_POR_FALTAS.getNombreEstado();
			default:
				return EstadoMateria.SIN_CURSAR.getNombreEstado();
		}
	}
}