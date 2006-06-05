package beans.beanEncapsulado.encapsuladores;

import beans.beanEncapsulado.Encapsulador;

/**
 * Encapsulador que no encapsula (para paginas que no hace falta 
 * encapsular nada)
 * @author Fco Javier Pérez Escrivá
 *
 */
public class EncapsuladorVacio extends Encapsulador{
	/**
	 * Contructor
	 *
	 */
	public EncapsuladorVacio(){
		super("",null);
	}
	/**
	 *No realiza ninguna accion
	 */
	public void encapsular(){}
}
