package tests;

import java.util.ArrayList;

import estructuras.Nodo;
import junit.framework.TestCase;

public class TestNodo extends TestCase {

	/** Nodo en el que se realizarán las pruebas */
	protected Nodo<String> nodo;
	
	/** Crea el test */
	public TestNodo(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		nodo = new Nodo<String>("casa");
	}
	
	/** Prueba de recuperación del valor del nodo. */
	public final void testDarValor(){
		assertEquals("casa",nodo.darValor());
	}
	
	/** Prueba de inserción de objetos. Verifica que diferentes valores se almacenen del lado adecuado. */
	public final void testSetHijo(){
		nodo.setHijo("carro");
		assertEquals("carro",nodo.darHijoIzquierdo().darValor());
		nodo.setHijo( "cosa" );
		assertEquals("cosa",nodo.darHijoDerecho().darValor());
		nodo.setHijo("carro");
		assertEquals("carro",nodo.darHijoIzquierdo().darHijoIzquierdo().darValor());
	}
	
	/**
	 * Prueba de generación de caminos. Agrega varios elementos y comprueba que los caminos hayan sido correctamente representados.
	 */
	public final void testTracePathTo(){
		nodo = new Nodo<String>("f");
		String[] elementos = {"d","h","e","g","l","b","c","z"};
		for( String s : elementos ) nodo.setHijo( s );
		assertEquals( "0", nodo.tracePathTo("d", "") );
		assertEquals( "1", nodo.tracePathTo("h", "") );
		assertEquals( "01", nodo.tracePathTo("e", "") );
		assertEquals( "10", nodo.tracePathTo("g", "") );
		assertEquals( "11", nodo.tracePathTo("l", "") );
		assertEquals( "00", nodo.tracePathTo("b", "") );
		assertEquals( "001", nodo.tracePathTo("c", "") );
		assertEquals( "111", nodo.tracePathTo("z", "") );
	}
	
	@Override
	protected void tearDown() throws Exception {
		nodo = null;
	}

}
