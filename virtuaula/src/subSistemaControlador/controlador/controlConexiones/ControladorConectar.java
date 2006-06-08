package subSistemaControlador.controlador.controlConexiones;

import subSistemaControlador.controlador.Controlador;
/**
 * Controlador que nos sirve en la conexion del un 
 * usuario al sistema
 * @author AL
 *
 */
public class ControladorConectar extends ControladorConexiones{
	/**
	 * metodo que nos modifica el resultado operacion para saber cual sera
	 * la pagina de destino
	 */
	public void procesarEvento() {
		
			this.setResuladooperacion("SIG");
		
		
	
		
	}
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		// TODO Auto-generated method stub
		return new ControladorConectar();
	}

}
