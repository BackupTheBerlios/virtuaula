package subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis;

import gestores.GestorAvisos;


import javax.servlet.http.HttpSession;

import beans.CreadorBean;
import beans.ObjetoBean;
import beans.Usuario;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorUsuario.ControladorUsuario;

public class ControladorOp_Avis extends ControladorUsuario{
/**
 * Con el idusuario que cogemos de la session buscamos los avisos de ese usuario
 * y metemos la lista resultante de avisos en la session.
 */
	public void procesarEvento() {
		CreadorBean creador = new CreadorBean();
		ObjetoBean idusu=(ObjetoBean)this.getSesion().getAttribute("beanUsuario");
		GestorAvisos GA = new GestorAvisos();
		ListaObjetoBean lista= GA.consultaAvisos(idusu);
		
		//la consulta se ha realizado correctamente.
		if (lista!=null)
		{
			this.setResuladooperacion("OK");
			sesion.setAttribute("listaaviso",lista);
			//borramos el la lista de error de la session porque ya realizamos la operacion correctamente
			this.getSesion().removeAttribute("error");
		}
		// La consulta ha dado error
		else if (lista == null)
		{
			this.setResuladooperacion("ERROR");
			ListaObjetoBean listaerror= new ListaObjetoBean();
			ObjetoBean error = creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA,"Se ha producido un error en la base de datos");
			listaerror.insertar(0,error);
			this.getSesion().setAttribute("error",listaerror);
		}
		
		
		
		
	}

	public Controlador clonar() {

		return new ControladorOp_Avis();
	}

}
