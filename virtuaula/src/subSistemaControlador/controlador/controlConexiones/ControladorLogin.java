package subSistemaControlador.controlador.controlConexiones;

import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorAlumnos.controlConsultaExpAlum.ControladorConExpAlum;
import gestores.GestorAvisos;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.Usuario;
/**
 * Controlador que maneja el login de cualquier tipo de usuario, dejando en
 * el objeto session el numero de mensajes que tiene sin leer 
 * @author JORGE SANCHEZ
 *
 */
public class ControladorLogin extends Controlador{
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

	public Controlador clonar() {
		
		return new ControladorLogin();
	}
}