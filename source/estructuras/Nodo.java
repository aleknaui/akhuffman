package estructuras;

/**
 * Clase que representa un nodo en un arbol binario.
 * @author aleKnaui
 * @param <E> Genérico de la clase
 */
public class Nodo<E extends Comparable<E>> {

	// --------------------------------------------------------------------------------
	// Atributos
	// --------------------------------------------------------------------------------
	
	/** Objeto contenido en el nodo. */
	private E valor;
	/** Nodo hijo que se encuentra a la derecha del nodo. */
	private Nodo<E> hijoDer;
	/** Nodo hijo que se encuentra a la izquierda del nodo. */
	private Nodo<E> hijoIzq;
	
	// --------------------------------------------------------------------------------
	// Constructor
	// --------------------------------------------------------------------------------
	
	/**
	 * Crea un nuevo nodo para un arbol binario.
	 * @param elemento El objeto contenido en el nodo
	 * post: Se ha creado un nuevo nodo sin hijos.
	 */
	public Nodo(E elemento){
		valor = elemento;
		hijoDer = null;
		hijoIzq = null;
	}
	
	// --------------------------------------------------------------------------------
	// Métodos
	// --------------------------------------------------------------------------------
	
	/**
	 * Retorna el objeto contenido en el nodo.
	 * @return El objeto contenido en el nodo.
	 */
	public E darValor(){
		return valor;
	}
	
	/**
	 * Retorna un nodo hijo del nodo.
	 * @return El nodo que se encuentra a la derecha.
	 */
	public Nodo<E> darHijoDerecho(){
		return hijoDer;
	}
	
	/**
	 * Retorna un nodo hijo del nodo.
	 * @return El nodo que se encuentra a la izquierda.
	 */
	public Nodo<E> darHijoIzquierdo(){
		return hijoIzq;
	}
	
	/**
	 * Inserta un hijo en el nodo.
	 * @param hijo El objeto que se quiere contener en el nodo.
	 * @return true Si se realizó la inserción. false Si no se realizó la inserción.
	 * post: Si "hijo" es de valor mayor a "valor", se coloca como nodo derecho. Si es de valor menor, se coloca como nodo izquierdo.
	 * Si es de valor igual, no se realiza la inserción. Este método es recursivo, por lo que si ambos nodos están ya ocupados, la
	 * responsabilidad de insertar el nodo se delega a uno de los nodos hijos, dependiendo del valor de "hijo". 
	 */
	public boolean setHijo(E hijo){
		if(valor.compareTo(hijo) < 0){
			if( tieneHijoDer() )
				return hijoDer.setHijo(hijo);
			else{
				hijoDer = new Nodo<E>(hijo);
				return true;
			}
		}
		else if(valor.compareTo(hijo) > 0)
		{
			if( tieneHijoIzq() )
				return hijoIzq.setHijo(hijo);
			else{
				hijoIzq = new Nodo<E>(hijo);
				return true;
			}
		}
		else
			return false;
	}
	
	/**
	 * Método que indica si el nodo tiene un hijo en la derecha.
	 * @return true Si el hijo derecho no es null. false Si lo es.
	 */
	public boolean tieneHijoDer(){
		return hijoDer == null;
	}
	
	/**
	 * Método que indica si el nodo tiene un hijo en la derecha.
	 * @return true Si el hijo derecho no es null. false Si lo es.
	 */
	public boolean tieneHijoIzq(){
		return hijoIzq == null;
	}
	
	/**
	 * Método que indica si el nodo tiene hijos.
	 * @return return true Si tiene hijo derecho o hijo izquierdo. false Si no tiene hijos.
	 */
	public boolean tieneHijos(){
		return tieneHijoDer() || tieneHijoIzq();
	}
	
	/**
	 * Método que retorna la cantidad de hijos que tiene un nodo.
	 * @return La cantidad de hijos que tiene un nodo.
	 */
	public int cantidadHijos(){
		if( !tieneHijos() ) return 0;
		int izq = tieneHijoIzq() ? hijoIzq.cantidadHijos() : 0;
		int der = tieneHijoDer() ? hijoDer.cantidadHijos() : 0;
		return 1 + izq + der;
	}
	
	/**
	 * Método que retorna la altura de la rama del arbol que empieza con este nodo.
	 * @return El largo del camino desde este nodo hasta el nodo más profundo del árbol.
	 */
	public int altura(){
		if( !tieneHijos() ) return 1;
		int izq = tieneHijoIzq() ? hijoIzq.altura() : 0;
		int der = tieneHijoDer() ? hijoDer.altura() : 0;
		return Math.max(izq, der) + 1;
	}
	
	/**
	 * Método que busca un objeto entre este nodo y sus hijos.
	 * @param objeto El objeto a buscar
	 * @return Un objeto tal que objeto.compareTo(valor) == 0. null Si no hay tal objeto.
	 */
	public E buscar( E objeto ){
		if( valor.compareTo( objeto ) == 0 ) return valor;
		else if( valor.compareTo( objeto ) > 0 ){
			if ( ! tieneHijoDer() ) return null;
			else
				return hijoDer.buscar( objeto );
		}
		else{
			if ( ! tieneHijoIzq() ) return null;
			else
				return hijoIzq.buscar( objeto );
		}
	}

}