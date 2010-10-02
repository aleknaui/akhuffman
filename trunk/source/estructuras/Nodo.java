package estructuras;

/**
 * Clase que representa un nodo en un arbol binario.
 * @author aleKnaui, bakedInTime
 * @param <E> Genérico de la clase
 */
public class Nodo<E extends Comparable<E>> implements Comparable<Nodo<E>>{

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
	 * Si es de valor igual se prueba colocar directamente a la izquierda. Si ya hay un nodo en la izquierda, se prueba en la derecha.
	 * Si ambos están llenos, se inserta en la rama con menor cantidad de nodos. Si ambas ramas tienen igual cantidad de nodos, se
	 * inserta en la rama izquierda. Este método es recursivo, por lo que si ambos nodos están ya ocupados, la responsabilidad de
	 * insertar el nodo se delega a uno de los nodos hijos, dependiendo del valor de "hijo". 
	 */
	public void setHijo(E hijo){
		if(valor.compareTo(hijo) < 0){
			if( tieneHijoDer() )
				hijoDer.setHijo(hijo);
			else{
				hijoDer = new Nodo<E>(hijo);
			}
		}
		else if(valor.compareTo(hijo) > 0)
		{
			if( tieneHijoIzq() )
				hijoIzq.setHijo(hijo);
			else{
				hijoIzq = new Nodo<E>(hijo);
			}
		}
		else{
			if( ! tieneHijoIzq() )
				hijoIzq = new Nodo<E>(hijo);
			else if( ! tieneHijoDer() )
				hijoDer = new Nodo<E>(hijo);
			else{
				if( hijoIzq.cantidadHijos() > hijoDer.cantidadHijos() )
					hijoDer.setHijo(hijo);
				else
					hijoIzq.setHijo(hijo);
			}
		}
	}
	
	/**
	 * Inserta un hijo en el nodo.
	 * @param hijo El objeto que se quiere contener en el nodo.
	 * @return true Si se realizó la inserción. false Si no se realizó la inserción.
	 * post: Si "hijo" es de valor mayor a "valor", se coloca como nodo derecho. Si es de valor menor, se coloca como nodo izquierdo.
	 * Si es de valor igual se prueba colocar directamente a la izquierda. Si ya hay un nodo en la izquierda, se prueba en la derecha.
	 * Si ambos están llenos, se inserta en la rama con menor cantidad de nodos. Si ambas ramas tienen igual cantidad de nodos, se
	 * inserta en la rama izquierda. Este método es recursivo, por lo que si ambos nodos están ya ocupados, la responsabilidad de
	 * insertar el nodo se delega a uno de los nodos hijos, dependiendo del valor de "hijo". 
	 */
	public void setHijo(Nodo<E> hijo){
		if(compareTo(hijo) < 0){
			if( tieneHijoDer() )
				hijoDer.setHijo(hijo);
			else{
				hijoDer = hijo;
			}
		}
		else if(compareTo(hijo) > 0)
		{
			if( tieneHijoIzq() )
				hijoIzq.setHijo(hijo);
			else{
				hijoIzq = hijo;
			}
		}
		else{
			if( ! tieneHijoIzq() )
				hijoIzq = hijo;
			else if( ! tieneHijoDer() )
				hijoDer = hijo;
			else{
				if( hijoIzq.cantidadHijos() > hijoDer.cantidadHijos() )
					hijoDer.setHijo(hijo);
				else
					hijoIzq.setHijo(hijo);
			}
		}
	}
	
	/**
	 * Método que indica si el nodo tiene un hijo en la derecha.
	 * @return true Si el hijo derecho no es null. false Si lo es.
	 */
	public boolean tieneHijoDer(){
		return hijoDer != null;
	}
	
	/**
	 * Método que indica si el nodo tiene un hijo en la derecha.
	 * @return true Si el hijo derecho no es null. false Si lo es.
	 */
	public boolean tieneHijoIzq(){
		return hijoIzq != null;
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
		if( !tieneHijos() ) return 1;
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
		else if( valor.compareTo( objeto ) < 0 ){
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

	@Override
	public int compareTo(Nodo<E> o) {
		return valor.compareTo(o.valor);
	}
	
	public String tracePathTo( E objeto, String prev ){
		if( valor.compareTo( objeto ) == 0 ) return prev;
		else if( valor.compareTo( objeto ) < 0 ){
			if ( ! tieneHijoDer() ) return "";
			else{
				prev = prev + "1";
				return hijoDer.tracePathTo( objeto, prev );
			}
		}
		else{
			if ( ! tieneHijoIzq() ) return "";
			else{
				prev = prev + "0";
				return hijoIzq.tracePathTo( objeto, prev );
			}
		}
	}

	public void setLeft( Nodo<E> n ){
		hijoIzq = n;
	}
	
	public void setRight( Nodo<E> n ){
		hijoDer = n;
	}
}