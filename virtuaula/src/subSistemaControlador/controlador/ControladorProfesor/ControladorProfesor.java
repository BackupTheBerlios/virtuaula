package subSistemaControlador.controlador.ControladorProfesor;

import subSistemaControlador.controlador.Controlador;
/**
 * 
 * Controlador del que heredan todos los controladores
 * relacionados con las operaciones de los profesores
 *
 */
abstract public class ControladorProfesor extends Controlador {


	/**
	* Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	* tiene que pasar. 
	*/
	abstract public void procesarEvento(); 

	
}
