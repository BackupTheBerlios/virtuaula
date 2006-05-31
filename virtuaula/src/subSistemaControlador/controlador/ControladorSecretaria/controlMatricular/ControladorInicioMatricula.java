package subSistemaControlador.controlador.ControladorSecretaria.controlMatricular;

import subSistemaControlador.controlador.Controlador;
/**
 * 
 * @author AL
 *Controlador de inicion de la matricula de un curso en el que se 
 *realizan operaciones de limpieza de la session
 */public class ControladorInicioMatricula extends ControladorMatricular{

	public void procesarEvento() {
		this.getSesion().removeAttribute("error");
		this.setResuladooperacion("SIG");
		this.getSesion().removeAttribute("beanAlumno");
		
	}

	public Controlador clonar() {
		
		return new ControladorInicioMatricula();
	}

}
