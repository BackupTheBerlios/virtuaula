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
	/**
	 * metodo que nos modifica el resultado operacion para saber cual sera
	 * la pagina de destino.
	 * Ademas realiza tareas de limpieza de la sesion
	 */
	public void procesarEvento() {
		
		this.setResuladooperacion("SIG");
		this.getSesion().removeAttribute("error");
		this.getSesion().removeAttribute("beanCurso");
	}
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		
		return new ControladorIniInsCur();
	}

}
