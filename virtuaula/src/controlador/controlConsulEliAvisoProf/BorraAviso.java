package controlador.controlConsulEliAvisoProf;

import gestores.GestorAvisos;


import beans.CreadorBean;
import beans.ObjetoBean;
import beans.Usuario;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
import controlador.Controlador;
/**
 * 
 * @author Alberto Macho
 * Esta clase controla la operacion de borrar un aviso.
 *
 */
public class BorraAviso extends Controlador{

	/**
	 * Borra el aviso seleccionado en una posicion y vuelve a consultar la lista de avisos
	 * de ese profesor
	 * Si todo va bien el resultado de la operacion será OK sino sera ERROR.
	 * 
	 */
	public void procesarEvento() {
		
		CreadorBean creador = new CreadorBean();

		ListaObjetoBean lista = (ListaObjetoBean)this.getSesion().getAttribute("listaaviso");
		Integer pos = (Integer)this.getSesion().getAttribute("posAviso");
		int posicion = pos.intValue();
		ObjetoBean aviso = (ObjetoBean)lista.dameObjeto(posicion);
		GestorAvisos GA = new GestorAvisos();
		boolean correcto=GA.borraAviso(aviso);
	
		// Si no se ha producido ningun error en la eliminacion del aviso
		if (correcto==true)
		{
			String idusu=(String)this.getSesion().getAttribute("idusuario");
			ObjetoBean beanUsuario = new Usuario();
			beanUsuario.cambiaValor(Constantes.ID_ISUSUARIO_DNI,idusu);
			ListaObjetoBean listaav= GA.consultaAvisos(beanUsuario);
			
			//si la nueva consulta no ha fallado en la base de datos
			if (listaav!=null)
			{
				this.setResuladooperacion("OK");
				sesion.setAttribute("listaaviso",listaav);
				//borramos el error porque ya no hay ningun fallo.
				this.getSesion().removeAttribute("error");
				
			}
			// La consulta ha dado error en la base de datos
			else if (listaav == null)
			{
				/*ListaObjetoBean er= new ListaObjetoBean();
				Error err=new Error;
				this.getSesion().setAttribute("error",er);
				*/
				ObjetoBean error = creador.crear(creador.Error);
				error.cambiaValor(Constantes.CAUSA,"Se ha producido un error en la base de datos");
				ListaObjetoBean listaerror = new ListaObjetoBean();
				listaerror.insertar(0,error);
				this.getSesion().setAttribute("error",listaerror);
				this.setResuladooperacion("ERROR");
			}
				//OJOOOOO!!!!Hay que mirar este error, si se manda a una pagina de error o q??			
			
		}
		//si se ha producido un error al borrar el aviso
		else if (correcto==false)
		{
			ObjetoBean error = creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA,"No se ha borrado el aviso,el aviso no existia");
			ListaObjetoBean listaerror = new ListaObjetoBean();
			listaerror.insertar(0,error);
			this.getSesion().setAttribute("error",listaerror);
			this.setResuladooperacion("ERROR");
			//this.getSesion().setAttribute("error",lerror);
			
		}
	}

	public Controlador clonar() {
		
		return new BorraAviso();
	}

}
