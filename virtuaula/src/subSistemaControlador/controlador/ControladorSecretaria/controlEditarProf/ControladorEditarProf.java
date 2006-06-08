package subSistemaControlador.controlador.ControladorSecretaria.controlEditarProf;

import subSistemaControlador.controlador.ControladorSecretaria.ControladorSecretaria;
/**
 * Controlador del que heredan los controladores para
 * editar un profesor.Controla el paso de una pagina a otra
 * en la edicion de un profesor
 * @author AL
 *
 */
abstract public class ControladorEditarProf extends ControladorSecretaria{
/**
 * metodo que nos modifica el resultado operacion para saber cual sera
 * la pagina de destino
 */
	abstract public void procesarEvento();
}
