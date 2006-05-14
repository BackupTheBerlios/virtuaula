package controlConexiones;




/**
 * 
 * @author Alberto Macho
 * @Controlador nos sirve cuando el usuario se desconecta.
 */
public class ControladorDesconectar extends ControladorConexiones{

/**
 * Borramos el atributo de la session que nos dice si un usuario esta validado o no
 * y modificando el resultadooperacion se podrá saber a que pagina nos tenemos que dirigir.
 */
	public void procesarEvento() {
		//Borro el atributo que me dice si el usuario esta validado o no
		this.sesion.removeAttribute("validado");
		this.sesion.removeAttribute("perfilUsuario");
		this.setResuladooperacion("SIG");
		
	}

}
