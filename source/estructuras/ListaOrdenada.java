package estructuras;

import java.util.ArrayList;

/**
 * Clase que implementa una lista que se ordena en base al método compareTo()
 * @author aleKnaui
 * @param <E> Genérico de la 
 */
public class ListaOrdenada<E extends Comparable<E>> extends ArrayList<E>{

	// --------------------------------------------------
	// Métodos
	// --------------------------------------------------
	
	/**
	 * Método que ordena los elementos de la lista utilizando el algoritmo
	 * de inserción obtenido en http://es.wikipedia.org/wiki/Ordenamiento_por_inserci%C3%B3n.
	 */
	public void sort(){
		for( int i = 1; i < size(); i++ ){
			E auxiliar = get(i);
			int j;
			for( j = i-1; j >= 0 && auxiliar.compareTo( get(j) ) < 0; j-- )
				set( j+1, get(j) );
			set(j+1, auxiliar);
		}
	}
	
	/**
	 * Realiza la operación add sin ordenar la lista.
	 * @param e El objeto a agregar.
	 * @return true Si se realizó la operación. false Si no se realizó.
	 */
	public boolean addNonSort( E e ){
		return super.add( e );
	}
	
	/**
	 * Agrega un elemento a la lista y la ordena.
	 * @param e El objeto a agretar.
	 * @return true Si se realizó la operación. false Si no se realizó.
	 * post: El elemento se agregó a la lista y la lista se ha ordenado.
	 */
	public boolean add( E e ){
		boolean ret = super.add( e );
		sort();
		return ret;
	}
}