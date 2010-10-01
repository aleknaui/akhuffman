package tests;

import junit.framework.TestCase;
import estructuras.ListaOrdenada;

public class ListaOrdenadaTest extends TestCase {

	/** Lista en la que se realizarán las pruebas */
	protected ListaOrdenada<Integer> lista;
	
	/** Crea el test */
	public ListaOrdenadaTest(String name) {
		super(name);
	}
	
	/**
	 * Prueba el algoritmo de ordenamiento. Ingresa una lista desordenada, ejecuta el
	 * método sort() y verifica que los elementos estén ordenados.
	 */
	public void testSort(){
		int[] desordenados = { 5, 3, 7, 1, 0, 8, 4, 2, 9, 6 };
		for( int i : desordenados ) lista.add( i );
		lista.sort();
		for( int i = 0; i < lista.size(); i++ ){
			assertEquals( (Integer)i, (Integer)lista.get(i) );
		}
	}

	@Override
	protected void setUp() throws Exception {
		lista = new ListaOrdenada<Integer>();
	}
	
	@Override
		protected void tearDown() throws Exception {
		lista = null;
	}

}
