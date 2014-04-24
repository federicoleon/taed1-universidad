package enums;

public enum EstadoMateria {
	SIN_CURSAR(1),
	CURSANDO(2),
	REGULAR(3),
	PROMOCIONADA(4),
	APROBADA(5),
	LIBRE_POR_NOTA(6),
	LIBRE_POR_FALTAS(7),;
	
	private final int estado;
	
	private EstadoMateria(int estado) {
        this.estado = estado;
    }
	
	public int getEstado() {
		return this.estado;
	}
}