package beans.beanEncapsulado.encapsuladores;

import beans.beanEncapsulado.Encapsulador;

/**
 * Encapsulador que no encapsula (para paginas que no hace falta 
 * encapsular nada)
 * @author Fco Javier Pérez Escrivá
 *
 */
public class EncapsuladorVacio extends Encapsulador{
	
	public EncapsuladorVacio(){
		super("",null);
	}
	public void encapsular(){}
}
