package subSistemaControlador.controlador.ControladorRecHumanos;

import subSistemaControlador.controlador.Controlador;
/**
 * 
 * Controlador del que heredan todos los relacionados con las 
 * operaciones del empleado de recursos humanos
 *
 */
abstract public class ControladorRecHumanos  extends Controlador {


	/**
	* Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	* tiene que pasar. 
	*/
	abstract public void procesarEvento(); 

	
}
