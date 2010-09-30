package Tests;

import Code.Nodo;
import junit.framework.TestCase;

public class TestNodo extends TestCase {

	protected Nodo<String> nodo;
	
	public TestNodo(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		nodo = new Nodo<String>("casa");
	}
	
	public final void testDarValor(){
		assertEquals("casa",nodo.darValor());
	}
	
	public final void testSetHijo(){
		nodo.setHijo("carro");
		assertEquals("carro",nodo.darHijoIzquierdo().darValor());
		nodo.setHijo( "cosa" );
		assertEquals("cosa",nodo.darHijoDerecho().darValor());
		assertEquals(false, nodo.setHijo("carro"));
	}
	
	public final void testIsEmpty(){
		assertEquals(false,nodo.isEmpty());
	}
	
	protected void tearDown() throws Exception {
		nodo = null;
	}

}
