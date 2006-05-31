package subSistemaControlador.controlador.ControladorPublico;

import subSistemaControlador.controlador.Controlador;
/**
 * 
 * Controlador del que heredan todos los controladores
 * relacionados con los usuarios publicos
 * Controlan el paso de una pagina a otra
 *  
 */
abstract public class ControladorPublico  extends Controlador {



	abstract public void procesarEvento(); 

	
}
