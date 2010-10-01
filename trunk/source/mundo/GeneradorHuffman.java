package mundo;

import estructuras.*;
/**
 * Clase que genera los códigos de Huffman
 * @author aleKnaui
 */
public class GeneradorHuffman {
	
	// --------------------------------------------------------------------------------
	// Atributos
	// --------------------------------------------------------------------------------
	
	private String cadena;
	
	private ListaOrdenada<ArbolBinario<Simbolo>> lista;
	
	private ArbolBinario<Simbolo> arbol;
	
	// --------------------------------------------------------------------------------
	// Constructor
	// --------------------------------------------------------------------------------
	
	public GeneradorHuffman( String string ){
		cadena = string;
		lista = new ListaOrdenada<ArbolBinario<Simbolo>>();
		arbol = new ArbolBinario<Simbolo>();
		
		obtenerFrecuencias();
		generarArbol();
	}
	
	// --------------------------------------------------------------------------------
	// Métodos
	// --------------------------------------------------------------------------------
	
	private void obtenerFrecuencias(){
		String cadenaInicial = cadena;
		while( ! cadena.isEmpty() ){
			lista.add( new ArbolBinario<Simbolo>( new Simbolo( cadena.charAt(0), cadena ) ) );
			cadena = cadena.replaceAll(Character.toString(cadena.charAt(0)), "");
		}
		cadena = cadenaInicial;
	}
	
	private void generarArbol(){
		while( lista.size() > 1 ){
			ArbolBinario<Simbolo> a1 = lista.get(0); ArbolBinario<Simbolo> a2 = lista.get(1);
			int suma = a1.darPrimero().darValor().darFrecuencia() + a2.darPrimero().darValor().darFrecuencia();
			lista.remove(0); lista.remove(0);
			ArbolBinario<Simbolo> mezcla = new ArbolBinario<Simbolo>( new Simbolo( suma ) );
			a1.darPrimero().darValor().marcarIzquierda();
			a2.darPrimero().darValor().marcarIzquierda();
			mezcla.insertar( a1 ); mezcla.insertar( a2 );
			lista.add( mezcla );
			/* System.out.println("--------------------------------");
			for( ArbolBinario<Simbolo> a : lista ){
				System.out.println( a.darPrimero().darValor().toString() );
			} */
		}
	}
	
	public static void main( String[] args ){
		new GeneradorHuffman( "Esto es una prueba" );
	}
	
	// --------------------------------------------------------------------------------
	// Métodos
	// --------------------------------------------------------------------------------
	
}
