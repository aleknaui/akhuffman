package tests;
import estructuras.ArbolBinario;
import estructuras.Nodo;
import junit.framework.TestCase;

public class ArbolBinarioTest extends TestCase {

	/** Arbol en el que se realizarán las pruebas */
	protected ArbolBinario<Integer> arbol;
	
	/** Crea el test */
	public ArbolBinarioTest(String name) {
		super(name);
	}
	
	/**
	 * Prueba el algoritmo para determinar la altura del arbol
	 * creando un arbol de altura 3 e invocando el método.
	 */
	public void testAltura(){
		assertEquals( 0, arbol.altura() );
		arbol.insertar( 5 );
		arbol.insertar( 4 );
		arbol.insertar( 6 );
		arbol.insertar( 1 );
		arbol.insertar( 3 );
		arbol.insertar( 8 );
		arbol.insertar( 2 );
		arbol.insertar( 0 );
		arbol.insertar( 10 );
		assertEquals( 5, arbol.altura() );
	}
	
	/**
	 * Test para el algoritmo de búsqueda en el arbol.
	 * Busca un elemento en un arbol vacío, lo que debería retornar null.
	 * Luego inserta elementos en el árbol y busca uno de ellos. Esto debería retornar
	 * ese mismo elemento. 
	 */
	public void testBuscar(){
		assertEquals( null, arbol.buscar( 18 ) );
		arbol.insertar( 5 );
		arbol.insertar( 4 );
		arbol.insertar( 6 );
		arbol.insertar( 1 );
		arbol.insertar( 3 );
		arbol.insertar( 8 );
		arbol.insertar( 2 );
		arbol.insertar( 0 );
		arbol.insertar( 10 );
		assertEquals( (Integer) 3, (Integer) arbol.buscar( 3 ) );
	}
	
	/**
	 * Verifica el método isEmpty() sobre un arbol vacío y uno con objetos.
	 */
	public void testIsEmpty(){
		assertEquals( true, arbol.isEmpty() );
		arbol.insertar( 5 );
		arbol.insertar( 4 );
		arbol.insertar( 6 );
		arbol.insertar( 1 );
		arbol.insertar( 3 );
		arbol.insertar( 8 );
		arbol.insertar( 2 );
		arbol.insertar( 0 );
		arbol.insertar( 10 );
		assertEquals( false, arbol.isEmpty() );
	}
	
	/**
	 * Verifica el método size() sobre un arbol vacío y uno con objetos.
	 */
	public void testSize(){
		assertEquals( 0, arbol.size() );
		arbol.insertar( 5 );
		arbol.insertar( 4 );
		arbol.insertar( 6 );
		arbol.insertar( 1 );
		arbol.insertar( 3 );
		arbol.insertar( 8 );
		arbol.insertar( 2 );
		arbol.insertar( 0 );
		arbol.insertar( 10 );
		assertEquals( 9, arbol.size() );
	}

	@Override
	protected void setUp() throws Exception {
		arbol = new ArbolBinario<Integer>();
	}
	
	@Override
		protected void tearDown() throws Exception {
		arbol = null;
	}

}
