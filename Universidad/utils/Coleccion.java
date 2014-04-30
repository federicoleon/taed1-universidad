package utils;

public abstract class Coleccion {
	private Nodo comienzo;
	private Integer limite;
	private int cantidadElementos;
	private Iterador iterador;
	
	public Nodo getComienzo() {
		return comienzo;
	}
	
	protected Integer getLimite() {
		return limite;
	}
	
	protected void setComienzo(Nodo comienzo) {
		this.comienzo = comienzo;
	}
	
	public Coleccion() {
		this.limite = null;
		this.cantidadElementos = 0;
	}
	
	public Coleccion(int limite) {
		this.limite = limite;
		this.cantidadElementos = 0;
	}
	
	public abstract boolean add(Object objeto);
	public abstract boolean remove();
	
	public int size() {
		return this.cantidadElementos;
	}
	
	public Iterador iterador() {
		this.iterador = new Iterador(this);
		return this.iterador;
	}
	
	protected void aumentarCantidadElementos() {
		this.cantidadElementos ++;
	}
	
	protected void disminuirCantidadElementos() {
		this.cantidadElementos --;
	}
}