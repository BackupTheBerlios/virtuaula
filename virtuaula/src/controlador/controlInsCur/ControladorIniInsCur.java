package controlador.controlInsCur;

import controlador.Controlador;

public class ControladorIniInsCur extends Controlador{

	public void procesarEvento() {
		
		this.setResuladooperacion("SIG");
		this.getSesion().removeAttribute("error");
	}

	public Controlador clonar() {
		
		return new ControladorIniInsCur();
	}

}
