package subSistemaBBDD.objetoBaseDatos;

/**
 * Abstracción de un ObjetoBBDD, encapsulado de los datos que compone la BBDD
 * equivale a una tupla de cualquiera de las tablas de la base de datos
 * Formando parte del patron:
 * 			-Patrón Prototype su rol es de Prototype
 * @author Fco Javier Pérez Escrivá & Alberto Macho
 *
 */
 abstract public class ObjetoBBDD{
		
	/**
	 * Devuelve una copia del ObjetoBBDD al que se le envia el mensaje, es decir un clon.
	 * Patrón Prototype
	 * @return copia de un ObjetoBBDD, es decir un clon de la propia clase.
	 */
	 abstract public ObjetoBBDD clonar();
	/**
	 * Accesor general de cualquier ObjetoBBDD.
	 * @param campo que se quiere consultar.Los campos que se quieren consultar se pueden obtener de
	 * la clase Constantes. Estan separadas por comentarios segun el objeto la que se refiera.  
	 * @return valor del campo consultado
	 */
	 abstract public String dameValor (String campo); 
	/**
	 * Mutador general de cualquier ObjetoBBDD
	 * @param campo a modificar con el valor indicado. Los campos que se quieren modificar se pueden obtener de
	 * la clase Constantes. Estan separadas por comentarios segun el objeto la que se refiera.
	 * 
	 */
	 abstract public void cambiaValor (String campo,String valor);
	/**
	 * Realiza una inicialización de todos los atributos del ObjetoBBDD a vacio ("")
	 *
	 */
	 abstract public void inicializar();
}
