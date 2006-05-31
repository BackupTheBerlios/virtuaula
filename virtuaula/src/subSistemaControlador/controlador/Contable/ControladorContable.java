package subSistemaControlador.controlador.Contable;

import subSistemaControlador.controlador.Controlador;
/**
 * 
 *  * Controla el paso de una pagina a otra devolviendo el resultado OK o ERROR dependiendo
 * del exito de las acciones que tenga q realizar
 *
 */
abstract public class ControladorContable  extends Controlador {



	abstract public void procesarEvento(); 

	
}
