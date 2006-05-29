package subSistemaControlador.controlador.ControladorSecretaria.controlEditarAlum;

import subSistemaControlador.controlador.Controlador;


public class ContEditarAlumnoIni extends ControladorEditarAlumno {
	/**
	 * Este metodo nos modifica el resultado operacion para indicar a la pagina que
	 * tiene que pasar. 
	 */
		public void procesarEvento() {
			this.getSesion().removeAttribute("listaalumno");
			this.getSesion().removeAttribute("beanAlumno");
			this.getSesion().removeAttribute("posAlumno");
			this.getSesion().removeAttribute("claveAlumno");
			this.setResuladooperacion("SIG");
		}
	
		public Controlador clonar(){
			return new ContEditarAlumnoIni();
		}
	
}
