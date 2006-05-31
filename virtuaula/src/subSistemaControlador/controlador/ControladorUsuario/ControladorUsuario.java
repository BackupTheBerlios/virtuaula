package subSistemaControlador.controlador.ControladorUsuario;

import subSistemaControlador.controlador.Controlador;
/**
 * Controlador del que heredan todos los controladores
 * que realicen operaciones generales de un usuario
 * Controla el paso de una pagina a otra
 * 
 *
 */abstract public class ControladorUsuario  extends Controlador {



	abstract public void procesarEvento(); 

	
}
