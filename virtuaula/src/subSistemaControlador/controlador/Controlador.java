package subSistemaControlador.controlador;


import javax.servlet.http.HttpSession;
/**
 * Abstracción de cualquier controlador del sistema
 * desempeña el papel de Prototype en el patron Prototype
 * @author Fco Javier Pérez Escrivá
 *
 */
abstract public class Controlador {
	/**
	 * Objeto de la sesion con la que se trabaja
	 */
	protected HttpSession sesion;
	/**
	 * Resultado de la operación realizada por el controlador
	 */
	protected String resuladooperacion;
	

	/**
	 * Ejecuta la acción que hace el controlador
	 *
	 */
	abstract public void procesarEvento();

	public String getResuladooperacion() {
		return resuladooperacion;
	}

	public void setResuladooperacion(String resuladooperacion) {
		this.resuladooperacion = resuladooperacion;
	}

	public HttpSession getSesion() {
		return sesion;
	}

	public void setSesion(HttpSession sesion) {
		this.sesion = sesion;
	}
	abstract public Controlador clonar();
}