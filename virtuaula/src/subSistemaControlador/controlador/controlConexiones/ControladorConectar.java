package subSistemaControlador.controlador.controlConexiones;

import subSistemaControlador.controlador.Controlador;
/**
 * Controlador que nos sirve en la conexion del un 
 * usuario al sistema
 * @author AL
 *
 */
public class ControladorConectar extends ControladorConexiones{

	public void procesarEvento() {
		
			this.setResuladooperacion("SIG");
		
		
	
		
	}

	public Controlador clonar() {
		// TODO Auto-generated method stub
		return new ControladorConectar();
	}

}
