package tests;

import junit.framework.TestCase;
import estructuras.ListaOrdenada;
import java.util.Random;

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
		for( int i = 0; i < 100; i++ )
			lista.addNonSort( (int)(Math.random() * 150) );
		//System.out.println( lista.toString() );
		lista.sort();
		for( int i = 1; i < 15; i++ )
			if( lista.get(i) < lista.get(i-1) ) fail();
		//System.out.println( lista.toString() );
		try {
			setUp();
		} catch (Exception e) {}
		for( int i = 0; i < 100; i++ )
			lista.add( (int)(Math.random() * 150) );
		for( int i = 1; i < 15; i++ )
			if( lista.get(i) < lista.get(i-1) ) fail();
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
