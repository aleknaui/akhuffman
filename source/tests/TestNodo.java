package tests;

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
	
	@Override
	protected void tearDown() throws Exception {
		nodo = null;
	}

}
