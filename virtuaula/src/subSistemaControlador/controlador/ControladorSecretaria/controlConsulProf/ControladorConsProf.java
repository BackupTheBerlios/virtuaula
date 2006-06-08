package subSistemaControlador.controlador.ControladorSecretaria.controlConsulProf;




import subSistemaControlador.controlador.ControladorSecretaria.ControladorSecretaria;

/**
 * 
 * @author Alberto Macho
 *Controlador del que heredan todos los controladores relacionados
 *con la consulta de un profesor. Controla el acceso de una pagina a otra
 */
abstract public class ControladorConsProf extends ControladorSecretaria {

	
	/**
	 * Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	 * tiene que pasar. 
	 */
	abstract public void procesarEvento();


}

