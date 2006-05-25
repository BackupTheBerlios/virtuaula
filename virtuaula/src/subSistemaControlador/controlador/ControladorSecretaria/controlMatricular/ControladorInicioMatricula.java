package subSistemaControlador.controlador.ControladorSecretaria.controlMatricular;

import subSistemaControlador.controlador.Controlador;

public class ControladorInicioMatricula extends Controlador{

	public void procesarEvento() {
		this.getSesion().removeAttribute("error");
		this.setResuladooperacion("SIG");
		
	}

	public Controlador clonar() {
		
		return new ControladorInicioMatricula();
	}

}
