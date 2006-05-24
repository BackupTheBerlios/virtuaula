package subSistemaControlador.controlador.controlPasaPag;


import subSistemaControlador.controlador.Controlador;
/**
 * 
 * @author Alberto Macho
 *Este controlador lo unico que hace es cambiarnos el resultadooperacion para 
 *que en el gestor de paginas sepamos la pagina siguiente.
 */
public class ControladorPasaPag extends Controlador{

	
	/**
	 * Nos modifica el atributo resultadooperacion para que se pueda saber a traves del
	 * gestor de paginas cual sera la pagina siguiente
	 */
	public void procesarEvento() {
		
		this.setResuladooperacion("SIG");
		
	}

	public Controlador clonar() {
		// TODO Auto-generated method stub
		return new ControladorPasaPag();
	}
}
