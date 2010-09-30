package estructuras;

public class Nodo<E extends Comparable<E>> {

	private E valor;
	private Nodo<E> hijoDer;
	private Nodo<E> hijoIzq;
	
	public Nodo(E elemento){
		valor = elemento;
		hijoDer = null;
		hijoIzq = null;
	}
	
	public E darValor(){
		return valor;
	}
	
	public Nodo<E> darHijoDerecho(){
		return hijoDer;
	}
	
	public Nodo<E> darHijoIzquierdo(){
		return hijoIzq;
	}
	
	public boolean setHijo(E hijo){
		if(valor.compareTo(hijo)<0){
			if( darHijoDerecho() != null )
				return hijoDer.setHijo(hijo);
			else{
				hijoDer = new Nodo<E>(hijo);
				return true;
			}
		}
		else if(valor.compareTo(hijo)>0)
		{
			if( darHijoIzquierdo() != null )
				return hijoIzq.setHijo(hijo);
			else{
				hijoIzq = new Nodo<E>(hijo);
				return true;
			}
		}
		else
			return false;
	}
	
	public boolean tieneHijos(){
		return hijoDer == null && hijoIzq == null;
	}
	
	public boolean isEmpty(){
		return valor == null;
	}

}
