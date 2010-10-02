package mundo;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import estructuras.*;
/**
 * Clase que genera los códigos de Huffman
 * @author aleKnaui
 */
public class GeneradorHuffman {
	
	// --------------------------------------------------------------------------------
	// Atributos
	// --------------------------------------------------------------------------------
	
	/** La cadena que se quiere codificar */
	private String cadena;
	/** La lista de los diferentes caracteres a codificar */
	private ListaOrdenada<ArbolBinario<Simbolo>> lista;
	/** El arbol del cual se obtiene la codificacion */
	private ArbolBinario<Simbolo> arbol;
	/** Lugar de almacenaje de los códigos generados */
	private HashMap<String, String> codigos;
	
	// --------------------------------------------------------------------------------
	// Constructor
	// --------------------------------------------------------------------------------
	
	/**
	 * Crea el generador y obtiene los códigos de una palabra.
	 * @param string La cadena que se desea codificar.
	 */
	public GeneradorHuffman( String string ){
		cadena = string;
		lista = new ListaOrdenada<ArbolBinario<Simbolo>>();
		arbol = new ArbolBinario<Simbolo>();
		codigos = new HashMap<String, String>();
		
		obtenerFrecuencias();
		generarArbol();
		obtenerCodigos();
		darResultados();
	}
	
	// --------------------------------------------------------------------------------
	// Métodos
	// --------------------------------------------------------------------------------
	
	/**
	 * Obtiene las diferentes frecuencias de cada caracter y genera la lista ordenada.
	 */
	private void obtenerFrecuencias(){
		String cadenaInicial = cadena;
		while( ! cadena.isEmpty() ){
			lista.add( new ArbolBinario<Simbolo>( new Simbolo( Character.toString(cadena.charAt(0)), cadena ) ) );
			cadena = cadena.replaceAll(Character.toString(cadena.charAt(0)), "");
		}
		cadena = cadenaInicial;
		/*for( ArbolBinario<Simbolo> a : lista ){
			System.out.println( a.darPrimero().darValor().toString() );
		}*/
	}
	
	/**
	 * Genera el arbol del cual se obtendrán los códigos.
	 */
	private void generarArbol(){
		while( lista.size() > 1 ){
			
			// Obtiene los dos menores valores
			ArbolBinario<Simbolo> a1 = lista.get(0); ArbolBinario<Simbolo> a2 = lista.get(1);
			
			// Obtiene la suma de sus frecuencias y el valor de comodín y los remueve de la lista.
			int suma = a1.darPrimero().darValor().darFrecuencia() + a2.darPrimero().darValor().darFrecuencia();
			String comodin = (a1.darPrimero().darValor().darSimbolo().replaceAll("¬¬", "")) + "¬¬" + (a2.darPrimero().darValor().darSimbolo().replaceAll("¬¬", ""));
			lista.remove(0); lista.remove(0);
			
			// Los combina en otro arbol. Lo agrega a la lista para que se ordene.
			ArbolBinario<Simbolo> mezcla = new ArbolBinario<Simbolo>( new Simbolo( comodin, suma ) );
			a1.darPrimero().darValor().cambiarModoComparacion('s');
			a2.darPrimero().darValor().cambiarModoComparacion('s');
			mezcla.setLeft( a1 ); mezcla.setRight( a2 );
			lista.add( mezcla );
			
			// Lo imprime para verificarlo.
			/*System.out.println("--------------------------------");
			for( ArbolBinario<Simbolo> a : lista ){
				System.out.println( a.darPrimero().darValor().toString() );
			}*/
		}
		// Almacena el arbol y lo borra de la lista.
		arbol = lista.get(0);
		lista.remove(0);
		arbol.darPrimero().darValor().cambiarModoComparacion('s');
	}
	
	/**
	 * Obtiene los diferentes códigos en base al árbol construído.
	 */
	private void obtenerCodigos(){
		obtenerFrecuencias();
		for( ArbolBinario<Simbolo> a : lista ){
			a.darPrimero().darValor().cambiarModoComparacion('s');
		}
		for( ArbolBinario<Simbolo> a : lista ){
			codigos.put( a.darPrimero().darValor().darSimbolo(), arbol.tracePathTo( a.darPrimero().darValor() ) );
		}
		
	}
	
	/**
	 * Imprime los resultados de la codificación.
	 */
	private void darResultados(){
		System.out.println( "\nCódigo de Huffman para la palabra \"" + cadena + "\":" );
		String cadenaInicial = cadena;
		while( ! cadena.isEmpty() ){
			System.out.println( cadena.charAt(0) + " = " + codigos.get(Character.toString( cadena.charAt(0) )) );
			cadena = cadena.replaceAll(Character.toString(cadena.charAt(0)), "");
		}
		cadena = cadenaInicial;
		System.out.println( "\nLa representación en código de Huffman de esta palabra es:" );
		String huffman = "";
		for( int i = 0; i < cadena.length(); i++ )
			huffman = huffman + codigos.get( Character.toString( cadena.charAt(i) ) ) + " ";
		System.out.println( huffman );
		System.out.println( "El tamaño de esta cadena es " + huffman.replaceAll(" ", "").length() );
		System.out.println( "En codificación estándar, el largo de la cadena sería: " + (int)((Math.log( codigos.values().size() ) / Math.log(2)) * cadena.length()) );
	}
	
	/**
	 * Método principal del programa.
	 * @param args No son necesarios.
	 */
	public static void main( String[] args ){
		Scanner scanner = new Scanner( System.in );
		System.out.print( "Ingrese una palabra para codificar: " );
		new GeneradorHuffman( scanner.nextLine() );
		System.out.print( "\nDesea ingresar una palabra nueva? (Ingrese 's' para indicar que sí): " );
		String respuesta = scanner.nextLine();
		if( respuesta.equalsIgnoreCase("s") ) main( null );
	}
	
}
