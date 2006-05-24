package subSistemaControlador.controlador.controlConexiones;

import subSistemaControlador.controlador.Controlador;

public class ControladorConectar extends ControladorConexiones{

	public void procesarEvento() {
		
			this.setResuladooperacion("SIG");
		
		
	
		
	}

	public Controlador clonar() {
		// TODO Auto-generated method stub
		return new ControladorConectar();
	}

}
