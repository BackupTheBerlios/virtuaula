package subSistemaControlador.controlador.ControladorSecretaria.controlBajaCur;

import subSistemaControlador.controlador.ControladorSecretaria.ControladorSecretaria;
/**
 * 
 * @author Alberto Macho
 * COntrolador del que heredan todos los controladores
 * para realizar la operacion de dar de baja un curso con lo
 * que supone.
 *
 */
abstract public class ControladorBajaCurso extends ControladorSecretaria {


	/**
	* Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	* tiene que pasar.
	*/
	abstract public void procesarEvento(); 

	
}
