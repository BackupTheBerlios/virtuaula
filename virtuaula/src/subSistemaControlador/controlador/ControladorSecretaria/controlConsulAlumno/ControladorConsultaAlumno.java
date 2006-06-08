
package subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno;

 
import subSistemaControlador.controlador.ControladorSecretaria.ControladorSecretaria;
/**
 * Se trata del controlador abstracto que implementarán todos los controladores de navegacion 
 * entre paginas en la consulta de un alumno por parte de un secretario. 
 * @author JORGE SANCHEZ
 *
 */
abstract public class ControladorConsultaAlumno extends ControladorSecretaria {


	/**
	 * Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	 * tiene que pasar.
	 */
	abstract public void procesarEvento(); 

	
}
