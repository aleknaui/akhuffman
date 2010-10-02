package mundo;

public class Simbolo implements Comparable<Simbolo>{

	// --------------------------------------------------------------------------------
	// Contantes
	// --------------------------------------------------------------------------------
	
	private final static char COMP_POR_SIMBOLO = 's';
	private final static char COMP_POR_FRECUENCIA = 'f';
	
	// --------------------------------------------------------------------------------
	// Atributos
	// --------------------------------------------------------------------------------
	
	/** Caracter contenido por el objeto. */
	private String simbolo;
	/** Cantidad de veces que el caracter se encuentra en una cadena. */
	private int frecuencia;
	/** Representación de Huffman del caracter. */
	private boolean representacion;
	/** Modo de comparación */
	private char modoComparacion;
	
	// --------------------------------------------------------------------------------
	// Constructor
	// --------------------------------------------------------------------------------
	
	/**
	 * Crea el símbolo con su frecuencia.
	 * @param simb El caracter representado
	 * @param cadena La cadena en la que se contará el caracter
	 * post: El símbolo ha sido creado. La frecuencia es la cantidad de veces que el símbolo se encuentra en la cadena ingresada.
	 */
	public Simbolo( String simb, String cadena ){
		modoComparacion = COMP_POR_FRECUENCIA;
		simbolo = simb;
		frecuencia = contarOcurrencias( cadena, simbolo );
		representacion = false;
	}
	
	/**
	 * Crea un símbolo de 'comodín'. El caracter es '*' y la frecuencia es la suma de las
	 * frecuencias inferiores.
	 * @param suma La suma de las frecuencias inferiores.
	 */
	public Simbolo( String simb, int suma ){
		modoComparacion = COMP_POR_FRECUENCIA;
		simbolo = simb;
		frecuencia = suma;
		representacion = false;
	}
	
	// --------------------------------------------------------------------------------
	// Métodos
	// --------------------------------------------------------------------------------
	
	@Override
	public int compareTo(Simbolo o) {
		if( modoComparacion == COMP_POR_FRECUENCIA )
			return frecuencia - o.frecuencia;
		else{
			if( simbolo.equals( o.simbolo ) ) return 0;
			String left = simbolo.substring(0, simbolo.indexOf("¬¬"));
			if( left.contains( o.simbolo ) ) return 1;
			return -1;
			/*String right = simbolo.substring(simbolo.indexOf('$') + 1);
			if( right.contains( o.simbolo ) ) return -1;*/
		}
	}
	
	@Override
	public boolean equals( Object e ){
		return simbolo == ((Simbolo)e).simbolo;
	}
	
	@Override
	public String toString(){
		return simbolo + " : " + frecuencia;
	}
	
	/**
	 * Retorna el caracter contenido.
	 * @return El caracter representado por el objeto.
	 */
	public String darSimbolo(){
		return simbolo;
	}
	
	/**
	 * Retorna la frecuencia del símbolo.
	 * @return La cantidad de veces que el caracter se encuentra contenido en la cadena especificada al crear el objeto.
	 */
	public int darFrecuencia(){
		return frecuencia;
	}
	
	/**
	 * Marca que el Símbolo se agregó como nodo hijo derecho de un arbol.
	 */
	public void marcarDerecha(){
		representacion = true;
	}
	
	/**
	 * Marca que el Símbolo se agregó como nodo hijo izquierdo de un arbol.
	 */
	public void marcarIzquierda(){
		representacion = false;
	}
	
	/**
	 * Retorna la representación del código de Huffman como un 1 o 0.
	 */
	public String darRepresentacion(){
		return representacion ? "1" : "0";
	}
	
	/**
	 * Cambia el tipo de comparación que se va a hacer.
	 * @param modo 'f' Si se va a comparar por frecuencia. 's' Si se va a comparar por símbolo.
	 */
	public void cambiarModoComparacion( char modo ){
		assert modo == COMP_POR_FRECUENCIA || modo == COMP_POR_SIMBOLO;
		modoComparacion = modo;
	}
	
	/**
	 * Cuenta la cantidad de ocurrencias de un caracter en una cadena
	 * @param s La cadena a analizar
	 * @param c El caracter a contar
	 * @return La cantidad de veces que c está en s.
	 */
	private static int contarOcurrencias( String s, String c )
	{
		int contador = 0;
		while( s.contains(c) ){
			contador++;
			s = s.replaceFirst(c, "");
		}
		return contador;
	}
	
}
