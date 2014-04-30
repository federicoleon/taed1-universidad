package utils;

public class Iterador {
	
	private Coleccion coleccion;
	private Nodo actual;
	private boolean esPrimero;
	
	protected Iterador(Coleccion coleccion) {
		this.coleccion = coleccion;
		this.esPrimero = true;
		this.actual = this.coleccion.getComienzo();
	}
	
	public boolean hasNext() {
		return (this.actual.getSiguiente() != null);
	}
	
	public Object next() {
		Object aux = null;
		if(this.actual.getSiguiente() != null) {
			if(esPrimero) {
				esPrimero = false;
				aux = this.actual.getObjeto();
			}else{
				aux = this.actual.getSiguiente().getObjeto();
				this.actual = this.actual.getSiguiente();
			}
		}
		return aux;
	}
}