package estructuras;

public class ArbolBinario<E extends Comparable<E>> {
	
	// --------------------------------------------------------------------------------
	// Atributos
	// --------------------------------------------------------------------------------
	
	/** Primer nodo del arbol. */
	private Nodo<E> primero;
	
	// --------------------------------------------------------------------------------
	// Constructor
	// --------------------------------------------------------------------------------
	
	/**
	 * Crea un arbol binario vacío.
	 */
	public ArbolBinario(){
		primero = null;
	}
	
	// --------------------------------------------------------------------------------
	// Métodos
	// --------------------------------------------------------------------------------
	
	/**
	 * Método que inserta un objeto en el arbol binario.
	 */
	public void insertar( E nuevo ){
		if( isEmpty() ) primero = new Nodo<E>(nuevo);
		else primero.setHijo( nuevo );
	}
	
	/**
	 * Método que informa si el arbol se encuentra vacío.
	 * @return true Si el arbol se encuentra vacío. false Si contiene elementos.
	 */
	public boolean isEmpty(){
		return primero == null;
	}
	
	/**
	 * Método que informa el tamaño del arbol.
	 * @return La cantidad de nodos contenidos en el arbol.
	 */
	public int size(){
		if( isEmpty() ) return 0;
		else{
			return primero.cantidadHijos();
		}
	}
	
	/**
	 * Método que informa la altura del arbol.
	 * @return El largo del camino desde la raíz hasta el nodo más profundo del árbol.
	 */
	public int altura(){
		if( isEmpty() ) return 0;
		else
			return primero.altura();
	}

	public E buscar( E objeto ){
		return primero.buscar( objeto );
	}
}