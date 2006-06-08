package subSistemaControlador.controlador.ControladorSecretaria.controlEditarAlum;

import subSistemaControlador.controlador.Controlador;

/**
 * 
 * 
 * Este controlador controla la navegación entre dos paginas
 * en la edicion de un alumno. Realmente solo realiza tareas de limpieza
 *
 */
public class ContEditarAlumnoIni extends ControladorEditarAlumno {
	/**
	 * Este metodo nos modifica el resultado operacion para indicar a la pagina que
	 * tiene que pasar. y realiza tareas de limpieza de la sesion
	 */
		public void procesarEvento() {
			this.getSesion().removeAttribute("listaalumno");
			this.getSesion().removeAttribute("beanAlumno");
			this.getSesion().removeAttribute("posAlumno");
			this.getSesion().removeAttribute("claveAlumno");
			this.setResuladooperacion("SIG");
		}
	/**
	 * @return nos devuelve un controlador de esta clase
	 */
		public Controlador clonar(){
			return new ContEditarAlumnoIni();
		}
	
}
