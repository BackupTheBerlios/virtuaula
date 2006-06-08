package subSistemaControlador.controlador.ControladorSecretaria.controlMatricular;

import subSistemaControlador.controlador.Controlador;
/**
 * 
 * @author AL
 *Controlador de inicion de la matricula de un curso en el que se 
 *realizan operaciones de limpieza de la session
 */public class ControladorInicioMatricula extends ControladorMatricular{
	 /**
		 * metodo que nos modifica el resultado operacion para saber cual sera
		 * la pagina de destino.
		 * Solo realiza tareas de limpieza de la sesion
		 */
	public void procesarEvento() {
		this.getSesion().removeAttribute("error");
		this.setResuladooperacion("SIG");
		this.getSesion().removeAttribute("beanAlumno");
		
	}
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		
		return new ControladorInicioMatricula();
	}

}
