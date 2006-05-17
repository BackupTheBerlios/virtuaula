package controlador.controlInsCur;

import gestores.GestorCursos;
import beans.CreadorBean;
import beans.Horario;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
import controlador.Controlador;
/**
 * 
 * @author Alberto Macho
 *
 */
public class ControladorInsCurProf extends Controlador{

	public void procesarEvento() {
		
		CreadorBean creador = new CreadorBean();
		Integer posAul=(Integer)this.getSesion().getAttribute("posAula");
		int posAula= posAul.intValue();
		
		//si la posicion elegida para un aula no es valida
		if (posAula==-1)
		{
			ObjetoBean error=creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA,"Debe elegir un Aula correcta");
			ListaObjetoBean listaError= new ListaObjetoBean();
			listaError.insertar(0,error);
			this.getSesion().setAttribute("error",listaError);
			this.setResuladooperacion("ERROR");
		}
		
		//Si la posicion elegida es buena.
		else if (posAula!=-1)
		{
			
//			Consultamos los profesores existentes con un horario dado.
			GestorCursos GC = new GestorCursos();
			ListaObjetoBean lhor= (ListaObjetoBean)this.getSesion().getAttribute("listahorario");
			Integer posh=(Integer)this.getSesion().getAttribute("posHor");
			int poshorario=posh.intValue();
			
			ObjetoBean hor=(Horario)lhor.dameObjeto(poshorario);
			ListaObjetoBean listaProf=GC.consultaProfesoresPorHorario(hor);
			
			//si no ha fallado la consulta en la base de datos
			if (listaProf !=null)
			{
				//si la lista no es vacia
				if (!(listaProf.esVacio()))
						{
							this.setResuladooperacion("OK");
							this.getSesion().setAttribute("listaprofesor",listaProf);
							//eliminamos el error para que no aparezca en la proxima pagina
							this.getSesion().removeAttribute("error");
						}
				//si la lista es vacia
				else if (listaProf.esVacio())
				{
					ObjetoBean error=creador.crear(creador.Error);
					error.cambiaValor(Constantes.CAUSA,"No hay Profesores disponibles con este horario,inserte otro horario o inserte otra aula");
					ListaObjetoBean listaerror = new ListaObjetoBean();
					listaerror.insertar(0,error);
					this.getSesion().setAttribute("error",listaerror);
					this.setResuladooperacion("ERROR");
				}
			}
			//si la consulta ha fallado en la base de datos
			else if (listaProf==null)
			{
				ObjetoBean error=creador.crear(creador.Error);
				error.cambiaValor(Constantes.CAUSA,"Fallo en la base de datos");
				ListaObjetoBean listaerr = new ListaObjetoBean();
				listaerr.insertar(0,error);
				this.getSesion().setAttribute("error",listaerr);
				this.setResuladooperacion("ERROR");
			}
			
		}
		
		
	}

	public Controlador clonar() {
		
		return new ControladorInsCurProf();
	}

}
