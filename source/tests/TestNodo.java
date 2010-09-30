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

	/** Prepara la clase para realizar pruebas. Instancia el nodo y como objeto le asigna "casa". */
	protected void setUp() throws Exception {
		nodo = new Nodo<String>("casa");
	}
	
	/** Prueba de recuperación del valor del nodo. */
	public final void testDarValor(){
		assertEquals("casa",nodo.darValor());
	}
	
	/**  */
	public final void testSetHijo(){
		nodo.setHijo("carro");
		assertEquals("carro",nodo.darHijoIzquierdo().darValor());
		nodo.setHijo( "cosa" );
		assertEquals("cosa",nodo.darHijoDerecho().darValor());
		assertEquals(false, nodo.setHijo("carro"));
	}
	
	protected void tearDown() throws Exception {
		nodo = null;
	}

}