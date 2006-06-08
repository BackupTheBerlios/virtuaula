package subSistemaControlador.controlador.ControladorSecretaria.controlMatricular;


import subSistemaControlador.controlador.ControladorSecretaria.ControladorSecretaria;
/**
 * 
 * @author Alberto Macho
 *Controlador del que herdan el resto de controladores
 *para la operacion de matricular un alumno
 */
abstract public class ControladorMatricular extends ControladorSecretaria {


	/**
	 * metodo que nos modifica el resultado operacion para saber cual sera
	 * la pagina de destino
	 */
	abstract public void procesarEvento(); 

	
}
