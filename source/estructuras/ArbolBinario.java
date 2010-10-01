package estructuras;

/**
 * Estructura de datos en la cual cada nodo siempre tiene un hijo izquierdo y un hijo derecho.
 * No pueden tener más de dos hijos (de ahí el nombre "binario"). 
 * @author aleKnaui
 */
public class ArbolBinario<E extends Comparable<E>> implements Comparable<ArbolBinario<E>>{
	
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
	
	/**
	 * Crea un arbol binario con un primer nodo que contiene el objeto del parámetro.
	 */
	public ArbolBinario( E objeto ){
		primero = new Nodo<E>( objeto );
	}
	
	/**
	 * Crea un arbol binario con el primero nodo indicado.
	 * @param n El Nodo a colocar de primero.
	 */
	public ArbolBinario( Nodo<E> n ){
		primero = n;
	}
	
	/**
	 * Duplica el arbol binario indicado.
	 * @param a El arbol binario a duplicar.
	 */
	public ArbolBinario( ArbolBinario<E> a ){
		primero = a.primero;
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
	 * Método que inserta un objeto en el arbol binario.
	 */
	public void insertar( ArbolBinario<E> nuevo ){
		if( isEmpty() ) primero = nuevo.darPrimero();
		else primero.setHijo( nuevo.darPrimero() );
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
		else
			return primero.cantidadHijos();
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

	/**
	 * Método que busca un objeto en el arbol.
	 * @param objeto El objeto a buscar
	 * @return Un objeto tal que objeto.compareTo(valor) == 0. null Si no hay tal objeto.
	 */
	public E buscar( E objeto ){
		if( isEmpty() ) return null;
		return primero.buscar( objeto );
	}
	
	/**
	 * Retorna el primer nodo del árbol.
	 * @return La raíz del arbol
	 */
	public Nodo<E> darPrimero(){
		return primero;
	}

	@Override
	public int compareTo(ArbolBinario<E> o) {
		return primero.compareTo( o.primero );
	}

}