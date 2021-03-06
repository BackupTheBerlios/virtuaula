package subSistemaControlador.controlador.ControladorSecretaria.controlInsCur;

import gestores.GestorCursos;
//import beans.Horario;
import beans.listaObjetoBeans.ListaObjetoBean;
import beans.CreadorBean;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import beans.ObjetoBean;
/**
 * 
 * @author Alberto Macho
 *controla el paso de una pagina a otra en la insercion de 
 *un curso nuevo. Ademas consuulta las ares de un curso
 *para que eliga el area que va a tener el curso. DEpendiendo
 *del exito o no de las operaciones devolvera una cosa u otra
 */
public class ControladorInsCurArea extends ControladorInsertarCursoAbs{
/**
 * 
 * metodo que nos modifica el resultado operacion para saber cual sera
 * la pagina de destino segun el exito de las operaciones realizadas
 *
 * Consultamos las areas disponibles con el gestor de cursos y las metemoss en la sesion.
 */
	public void procesarEvento() {
		CreadorBean creador = new CreadorBean();
		Integer posHor=(Integer)this.getSesion().getAttribute("posHor");
		int posHorario=posHor.intValue();
		
		//Si la posicion elegida es -1 creo un error y lo meto en la lista error y la
		//inserto en la session
		if (posHorario== -1 )
		{
			//Error error=new Error();
			ObjetoBean error = creador.crear(creador.Error);
			ListaObjetoBean listaerror= new ListaObjetoBean();
			error.cambiaValor(Constantes.CAUSA,"Tiene que elegir un horario");
			
			int pos=listaerror.tamanio();
			listaerror.insertar(pos,error);
			this.getSesion().setAttribute("error",listaerror);
			this.setResuladooperacion("ERROR");
			
			
			
		}
		//si la posicion es valida
		else if (posHorario != -1)
		{
			//ListaObjetoBean lishor = (ListaObjetoBean)this.getSesion().getAttribute("listahorario");
			//Horario hor=(Horario)lishor.dameObjeto(posHorario);
			GestorCursos GC = new GestorCursos();
			ListaObjetoBean listaAreas = GC.consultaAreas();
			
			// Si la consulta no ha fallado en la base de datos
			if (listaAreas!=null)
			{
				//si la lista es vacia
				if (listaAreas.esVacio())
				{
					ObjetoBean error = creador.crear(creador.Error);
					error.cambiaValor(Constantes.CAUSA,"No hay areas disponibles,debe insertar un area antes de insertar un curso");
					ListaObjetoBean listaError= new ListaObjetoBean();
					listaError.insertar(0,error);
					this.getSesion().setAttribute("error",listaError);
					this.setResuladooperacion("ERROR");
					
				} 
				//si la lista no es vacia
				else if (!(listaAreas.esVacio()))
				{
					this.setResuladooperacion("OK");
					this.getSesion().setAttribute("listaarea",listaAreas);
					//borramos el error para que no se muestre en la sig pagina ya que se
					//habra solucionado.
					this.getSesion().removeAttribute("error");
					
				}
			}
			//Si la consulta en la base de datos ha fallado.
			else if (listaAreas==null)
			{
				ObjetoBean error = creador.crear(creador.Error);
				error.cambiaValor(Constantes.CAUSA,"Fallo en la base de datos");
				ListaObjetoBean listaError= new ListaObjetoBean();
				listaError.insertar(0,error);
				this.getSesion().setAttribute("error",listaError);
				this.setResuladooperacion("ERROR");
			}
		
		
		
		}
	
	}
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		
		return new ControladorInsCurArea();
	}

}
