package subSistemaControlador.controlador.Contable;

import subSistemaControlador.controlador.Controlador;
/**
 * 
 * Clase abstracta de las que heredan todas las relacionadas con las
 * operaciones del contable.
 * Controla el paso de una pagina a otra devolviendo el resultado OK o ERROR dependiendo
 * del exito de las acciones que tenga q realizar
 *
 */
abstract public class ControladorContable  extends Controlador {


	/**
	* Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	* tiene que pasar.
	*/
	abstract public void procesarEvento(); 

	
}
