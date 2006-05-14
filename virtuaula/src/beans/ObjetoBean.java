package beans;
/**
 * Abstracción de un ObjetoBean, encapsulado de los datos que compone la BBDD
 * equivale a una tupla de cualquiera de las tablas de la base de datos
 * Formando parte de dos patrones:
 * 			-Patrón Prototype su rol es de Prototype
 * * @author Alberto Macho
 *
 */

abstract public class ObjetoBean {
		/**
		 * Devuelve una copia del ObjetoBean al que se le envia el mensaje
		 * Patrón Prototype
		 * @return copia, es decir un clon de la propia clase. nos devuelve un ObjetoBean
		 *    
		 */
		abstract public ObjetoBean clonar(); 
		/**
		 * Accesor general de cualquier ObjetoBean
		 * @param campo que se quiere consultar. Estos campos los podemos consultar de la clase constantes
		 * @return valor consultado segun el campo que hemos introducido
		 */
		 abstract public String dameValor (String campo);
		/**
		 * Mutador general de cualquier ObjetoBean
		 * @param campo que queremos modificar
		 * @param valor nuevo para el campo que queremos modificar.El campo lo podemos coger de la clase Constantes
		 */
		 abstract public void cambiaValor (String campo,String valor);
		/**
		 * Realiza una inicialización de todos los atributos del ObjetoBean a vacio ("")
		 *
		 */
		 abstract public void inicializar();
	}


