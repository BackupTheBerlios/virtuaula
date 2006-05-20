package controlador.controlInsCur;

import gestores.GestorCursos;
import controlador.Controlador;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
/**
 * 
 * @author Alberto Macho
 * 
 *
 */
public class ControladorInsCurAula extends Controlador{

	public void procesarEvento() {
		CreadorBean creador = new CreadorBean();
		Integer pos=(Integer)this.getSesion().getAttribute("posArea");
		int posArea=pos.intValue();
		
		//si escogemos una posicion no valida de la lista
		if (posArea==-1)
		{	
			ObjetoBean error =creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA,"Debe elegir un Area correcta");
			ListaObjetoBean listaError= new ListaObjetoBean();
			listaError.insertar(0,error);
			this.getSesion().setAttribute("error",listaError);
			this.setResuladooperacion("ERROR");
		}
		
		//si ha escogido un area valida
		else if (posArea != -1)
		{
			//Consultamos las aulas existentes con un horario dado.
			GestorCursos GC = new GestorCursos();
			ListaObjetoBean lhor= (ListaObjetoBean)this.getSesion().getAttribute("listahorario");
		
			Integer posh=(Integer)this.getSesion().getAttribute("posHor");
			int poshorario=posh.intValue();
			ObjetoBean hor=(ObjetoBean)lhor.dameObjeto(poshorario);
			ListaObjetoBean listaAulas=GC.consultaAulasPorHorario(hor);
			
			//si no ha fallado la consulta en la base de datos
			if (listaAulas !=null)
			{
				//si la lista no es vacia
				if (!(listaAulas.esVacio()))
						{
							this.setResuladooperacion("OK");
							this.getSesion().setAttribute("listaaula",listaAulas);
							//eliminamos el error para que no aparezca en la proxima pagina
							this.getSesion().removeAttribute("error");
						}
				//si la lista es vacia
				else if (listaAulas.esVacio())
				{
					ObjetoBean error =creador.crear(creador.Error);
					error.cambiaValor(Constantes.CAUSA,"No hay aulas disponibles con este horario,inserte otro horario o inserte otra aula");
					ListaObjetoBean listaerror = new ListaObjetoBean();
					listaerror.insertar(0,error);
					this.getSesion().setAttribute("error",listaerror);
					this.setResuladooperacion("ERROR");
				}
			}
			//si la consulta ha fallado en la base de datos
			else if (listaAulas==null)
			{	
				ObjetoBean error =creador.crear(creador.Error);
				error.cambiaValor(Constantes.CAUSA,"Fallo en la base de datos");
				ListaObjetoBean listaerr = new ListaObjetoBean();
				listaerr.insertar(0,error);
				this.getSesion().setAttribute("error",listaerr);
				this.setResuladooperacion("ERROR");
			}
			
			
		}
		
	}

	public Controlador clonar() {
		
		return new ControladorInsCurAula();
	}

}
