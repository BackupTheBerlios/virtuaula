package subSistemaControlador.controlador.controlConexiones;

import subSistemaControlador.controlador.Controlador;




/**
 * 
 * @author Alberto Macho
 * nos sirve cuando el usuario se desconecta.
 */
public class ControladorDesconectar extends ControladorConexiones{

/**
 * metodo que nos modifica el resultado operacion para saber cual sera
 * la pagina de destino.
 * Borramos el atributo de la session que nos dice si un usuario esta validado o no
 * y modificando el resultadooperacion se podrá saber a que pagina nos tenemos que dirigir.
 */
	public void procesarEvento() {
		//Borro el atributo que me dice si el usuario esta validado o no
		this.sesion.removeAttribute("validado");
		this.sesion.removeAttribute("perfilUsuario");
		this.sesion.removeAttribute("beanUsuario");
		this.setResuladooperacion("SIG");
		this.getSesion().removeAttribute("error");
	}
/**
 * @return nos devuelve un controlador de esta clase.
 */
public Controlador clonar() {
	// TODO Auto-generated method stub
	return new ControladorDesconectar();
}

}
