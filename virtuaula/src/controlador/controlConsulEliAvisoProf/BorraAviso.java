package controlador.controlConsulEliAvisoProf;

import gestores.GestorAvisos;
import gestores.Profesorado;
import beans.Avisos;
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
		Profesorado GP = new Profesorado();
		ListaObjetoBean lista = (ListaObjetoBean)this.getSesion().getAttribute("listaaviso");
		Integer pos = (Integer)this.getSesion().getAttribute("posAviso");
		int posicion = pos.intValue();
		Avisos aviso = (Avisos)lista.dameObjeto(posicion);
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
				
			}
			// La consulta ha dado error en la base de datos
			else if (listaav == null)
			{
				/*ListaObjetoBean er= new ListaObjetoBean();
				Error err=new Error;
				this.getSesion().setAttribute("error",er);
				*/
				this.setResuladooperacion("ERROR");
			}
				//OJOOOOO!!!!Hay que mirar este error, si se manda a una pagina de error o q??			
			
		}
		//si se ha producido un error al borrar el aviso
		else if (correcto==false)
		{
			
			//this.getSesion().setAttribute("error",lerror);
			this.setResuladooperacion("ERROR");
		}
	}

	public Controlador clonar() {
		
		return new BorraAviso();
	}

}
