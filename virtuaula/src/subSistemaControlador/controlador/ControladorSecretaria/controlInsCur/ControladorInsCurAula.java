package subSistemaControlador.controlador.ControladorSecretaria.controlInsCur;

import gestores.GestorCursos;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
/**
 * 
 * @author Alberto Macho
 * 
 *Controla el paso de una pagina a otra en la insercion de 
 *un curso, en concreto  consulta las aulas disponilbes
 *para impartir el curso y mostrarlas en la siguiente pagina
 */
public class ControladorInsCurAula extends ControladorInsertarCursoAbs{
	/**
	 * metodo que nos modifica el resultado operacion para saber cual sera
	 * la pagina de destino dependiendo del resultado de las operaciondes realizadas.
	 * Ademas consultamos las aulas disponibles en un horario libre y la metemos en 
	 * sesion para poder mostrarlas en la siguiente pagina. 
	 */
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
			this.setResuladooperacion("ERROR2");
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
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		
		return new ControladorInsCurAula();
	}

}
