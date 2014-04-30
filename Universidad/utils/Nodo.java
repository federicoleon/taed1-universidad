package utils;

public class Nodo {
	
	private Object objeto;
	private Nodo siguiente;
	private Nodo anterior;
	
	public Nodo(Object objeto) {
		this.objeto = objeto;
	}
	
	public Object getObjeto() {
		return objeto;
	}
	
	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
	
	public Nodo getSiguiente() {
		return siguiente;
	}
	
	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	
	public Nodo getAnterior() {
		return anterior;
	}
	
	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}
}