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
	
	private String cadena;
	
	private ListaOrdenada<ArbolBinario<Simbolo>> lista;
	
	private ArbolBinario<Simbolo> arbol;
	
	private HashMap<String, String> codigos;
	
	// --------------------------------------------------------------------------------
	// Constructor
	// --------------------------------------------------------------------------------
	
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
			a1.darPrimero().darValor().marcarIzquierda(); a1.darPrimero().darValor().cambiarModoComparacion('s');
			a2.darPrimero().darValor().marcarDerecha(); a2.darPrimero().darValor().cambiarModoComparacion('s');
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
	
	private void obtenerCodigos(){
		obtenerFrecuencias();
		for( ArbolBinario<Simbolo> a : lista ){
			a.darPrimero().darValor().cambiarModoComparacion('s');
		}
		for( ArbolBinario<Simbolo> a : lista ){
			codigos.put( a.darPrimero().darValor().darSimbolo(), arbol.tracePathTo( a.darPrimero().darValor() ) );
		}
		
	}
	
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
	
	public static void main( String[] args ){
		Scanner scanner = new Scanner( System.in );
		System.out.print( "Ingrese una palabra para codificar: " );
		new GeneradorHuffman( scanner.nextLine() );
		System.out.print( "\nDesea ingresar una palabra nueva? (Ingrese 's' para indicar que sí): " );
		String respuesta = scanner.nextLine();
		if( respuesta.equalsIgnoreCase("s") ) main( null );
	}
	
}
