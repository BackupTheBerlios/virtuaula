package controlador;


import javax.servlet.http.HttpSession;

abstract public class Controlador {
	
	protected HttpSession sesion;
	protected String resuladooperacion;
	


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