package subSistemaControlador.controlador.ControladorSecretaria.controlInsCur;


import subSistemaControlador.controlador.ControladorSecretaria.ControladorSecretaria;
/**
 * Controlador del que heredan el resto de los controladores
 * para la accion de insertar un curso. Controla el paso de una
 * pagina a otra
 * 
 *
 */
abstract public class ControladorInsertarCursoAbs extends ControladorSecretaria {

	/**
	 * metodo que nos modifica el resultado operacion para saber cual sera
	 * la pagina de destino
	 */
	abstract public void procesarEvento(); 

	
}