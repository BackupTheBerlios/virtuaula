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


	/**
	* Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	* tiene que pasar. 
	*/
	abstract public void procesarEvento(); 

	
}
