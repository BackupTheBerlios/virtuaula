package subSistemaControlador.controlador.controlConexiones;


import subSistemaControlador.controlador.Controlador;
import gestores.GestorAvisos;
import beans.ObjetoBean;
import beans.Usuario;
/**
 * Controlador que maneja el login y la pagina inicial de cualquier tipo de usuario, dejando en
 * el objeto session el numero de mensajes que tiene sin leer 
 * @author JORGE SANCHEZ
 *
 */
public class ControladorLogin extends Controlador{
	/**
	 * metodo que nos modifica el resultado operacion para saber cual sera
	 * la pagina de destino.
	 * Ademas con el gestor de avisos nos consulta el numero de 
	 * avisos nuevos que tiene este usuario.
	 */
	public void procesarEvento(){
		ObjetoBean usuario = (Usuario)this.getSesion().getAttribute("beanUsuario");
		GestorAvisos GA= new GestorAvisos();
		int numeroAvisos= GA.numeroAvisosNuevos(usuario);
		Integer numAvisos= new Integer(numeroAvisos);		
		this.setResuladooperacion("SIG");
		this.getSesion().removeAttribute("error");
		if (numAvisos.equals(null))
			numAvisos=new Integer(0);
		this.getSesion().setAttribute("numAvisos",numAvisos);
	}
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		
		return new ControladorLogin();
	}
}
