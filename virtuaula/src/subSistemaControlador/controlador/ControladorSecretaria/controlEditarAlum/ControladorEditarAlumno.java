
package subSistemaControlador.controlador.ControladorSecretaria.controlEditarAlum;


import subSistemaControlador.controlador.ControladorSecretaria.ControladorSecretaria;
/**
 * Controlador abstracto que implementarán todos los controladores que intervienen en
 * la edicion de un alumno por parte de un secretario de la academia.
 * @author JORGE SANCHEZ
 *
 */
abstract public class ControladorEditarAlumno extends ControladorSecretaria {


/**
 * metodo para modificar el resultado operacion y saber a que pagina
 * tenemos que ir
 */
	abstract public void procesarEvento(); 

	
}
