package subSistemaControlador.controlador.ControladorUsuario;

import subSistemaControlador.controlador.Controlador;
/**
 * Controlador del que heredan todos los controladores
 * que realicen operaciones generales de un usuario
 * Controla el paso de una pagina a otra
 * 
 *
 */abstract public class ControladorUsuario  extends Controlador {


	 /**
		 * metodo que nos modifica el resultado operacion para saber cual sera
		 * la pagina de destino
		 */
	abstract public void procesarEvento(); 

	
}
