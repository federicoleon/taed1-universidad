package utils;

public class Cola extends Coleccion {

	@Override
	public boolean add(Object objeto) {
		if( getLimite() == null || (getLimite() != null && getLimite().intValue() < size()) ) {
			if( this.getComienzo() == null ) {
				Nodo nodo = new Nodo(objeto);
				setComienzo(nodo);
			}else {
				Nodo nodo = new Nodo(objeto);
				Nodo aux = getComienzo();
				while(aux.getSiguiente() != null) {
					aux = aux.getSiguiente();
				}
				aux.setSiguiente(nodo);
			}
			aumentarCantidadElementos();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean remove() {
		if(getComienzo() != null) {
			setComienzo(getComienzo().getSiguiente());
			disminuirCantidadElementos();
			return true;
		}else{
			return false;
		}
	}
}