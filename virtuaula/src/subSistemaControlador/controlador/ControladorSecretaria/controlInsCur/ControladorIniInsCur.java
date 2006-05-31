package subSistemaControlador.controlador.ControladorSecretaria.controlInsCur;

import subSistemaControlador.controlador.Controlador;
/**
 * 
 * Controla el paso de una pagina a otra en la insercion de un curso nuevo y ademas realiza
 * las operaciones  que tiene que realizar. Las operaciones que realiza este en concreto
 * solo son de limpieza de las session
 * 
 *
 */
public class ControladorIniInsCur extends ControladorInsertarCursoAbs{

	public void procesarEvento() {
		
		this.setResuladooperacion("SIG");
		this.getSesion().removeAttribute("error");
		this.getSesion().removeAttribute("beanCurso");
	}

	public Controlador clonar() {
		
		return new ControladorIniInsCur();
	}

}
