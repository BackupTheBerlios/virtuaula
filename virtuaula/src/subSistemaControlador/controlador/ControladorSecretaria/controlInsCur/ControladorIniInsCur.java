package subSistemaControlador.controlador.ControladorSecretaria.controlInsCur;

import subSistemaControlador.controlador.Controlador;

public class ControladorIniInsCur extends Controlador{

	public void procesarEvento() {
		
		this.setResuladooperacion("SIG");
		this.getSesion().removeAttribute("error");
		this.getSesion().removeAttribute("beanCurso");
	}

	public Controlador clonar() {
		
		return new ControladorIniInsCur();
	}

}
