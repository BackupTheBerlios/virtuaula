package subSistemaControlador.controlador.ControladorAlumnos;

import subSistemaControlador.controlador.Controlador;
/**
 * 
 *  * Controla el paso de una pagina a otra devolviendo el resultado OK o ERROR dependiendo
 * del exito de las acciones que tenga q realizar
 * Es la clase de la que heredan todos los controladores que tiene que ver con las operaciones
 * sobre alumnos
 *
 */
abstract public class ControladorAlumnos extends Controlador {



	abstract public void procesarEvento(); 

	
}
