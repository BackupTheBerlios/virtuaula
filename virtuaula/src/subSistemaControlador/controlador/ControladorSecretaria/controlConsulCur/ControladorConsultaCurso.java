package subSistemaControlador.controlador.ControladorSecretaria.controlConsulCur;


import subSistemaControlador.controlador.ControladorSecretaria.ControladorSecretaria;
/**
 * Controlador del que heredan todos los controladores 
 * relacionados con la consulta de un curso
 * @author AL
 *
 */
abstract public class ControladorConsultaCurso extends ControladorSecretaria {


	/**
	* Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	* tiene que pasar. 
	*/
	abstract public void procesarEvento(); 

	
}
