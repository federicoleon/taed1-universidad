package excepciones;

public class ExcepcionStringANumero extends Exception {
	
	private static final long serialVersionUID = -7018426103585951136L;

	public ExcepcionStringANumero() {
		super("El texto ingresado debe ser numérico.");
	}
}