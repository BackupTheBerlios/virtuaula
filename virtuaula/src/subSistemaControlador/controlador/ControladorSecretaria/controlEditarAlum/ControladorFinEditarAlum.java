

package subSistemaControlador.controlador.ControladorSecretaria.controlEditarAlum;

import subSistemaControlador.controlador.*;
import beans.ObjetoBean;
import gestores.GestorAlumnos;

/**
 * Se encarga de hacer la edicion propiamente dicha del alumno seleccionado por un secretario.
 * @author JORGE SANCHEZ
 *
 */
public class ControladorFinEditarAlum extends ControladorEditarAlumno{

	
	/**
	 * metodo que nos modifica el resultado operacion para saber a que pagina tenemos qu dirigirnos, 
	 * ademas realiza la edicion de un alumno con el gestor de ALumnos.
	 */
	public void procesarEvento(){
		
		ObjetoBean alumnoEdicion= (ObjetoBean)(this.getSesion().getAttribute("beanAlumno"));
		GestorAlumnos GA = new GestorAlumnos();
		boolean exito = GA.editarAlumno(alumnoEdicion);
		
		
		if(exito){
			this.setResuladooperacion("OK");
		}
		else{
			this.setResuladooperacion("ERROR");
		}
		this.getSesion().removeAttribute("claveAlumno");
		this.getSesion().removeAttribute("beanAlumno");
		this.getSesion().removeAttribute("posAlumno");
		this.getSesion().removeAttribute("listAlumno");
	}
	/**
	 * @return nos devuelve un controlador de esta clase
	 */
	public Controlador clonar(){
		return new ControladorFinEditarAlum();
	}
}
