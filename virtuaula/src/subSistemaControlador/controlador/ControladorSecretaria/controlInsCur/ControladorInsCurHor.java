package subSistemaControlador.controlador.ControladorSecretaria.controlInsCur;

import gestores.GestorCursos;
//import beans.Curso;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import beans.CreadorBean;
import beans.ObjetoBean;

/**
 * 
 * @author Alberto Macho
 *Controla el paso de una pagina a otra en la insercion de un 
 *curso, concretamente consulta los horarios disponibles para 
 *mostrarlos
 */
public class ControladorInsCurHor extends ControladorInsertarCursoAbs{
	/**
	 * metodo que nos modifica el resultado operacion para saber cual sera
	 * la pagina de destino dependiendl del exito de las operaciones realizadas.
	 * Ademas con el gestor de cursos consultamos los horarios existentes
	 * y los metemos en sesion para poder mostrarlos en la pagina siguiente.
	 * Tambien se realiza una comprobacion de los datos introducidos con el gtestor
	 * de cursos
	 */
	public void procesarEvento() {
		CreadorBean creador = new CreadorBean();
		//Curso cur =(Curso)this.getSesion().getAttribute("idbean");
		GestorCursos GC = new GestorCursos();
		ListaObjetoBean listaHor=GC.consultaHorarios();
		//Si la consulta no ha fallado en la base de datos
		if (listaHor!=null)
		{
			
			//si la lista generada en la consulta es vacia
			
			if (listaHor.esVacio())
			{
				//generamos un error y lo metemos en una listaerror
				ObjetoBean error=creador.crear(creador.Error);
				error.cambiaValor(Constantes.CAUSA,"No hay horarios disponibles.Debe insertar horarios en el sistema");
				ListaObjetoBean lerror=new ListaObjetoBean();
				int pos=lerror.tamanio();
				lerror.insertar(pos,error);
				this.getSesion().setAttribute("error",lerror);
				this.setResuladooperacion("ERROR");
			}
			
			//si la lista no es vacia
			
			else if(!(listaHor.esVacio()))
			{
			ObjetoBean curso=(ObjetoBean)this.getSesion().getAttribute("beanCurso");
			ListaObjetoBean listae=GC.comprobarParcial(curso);
			if (listae.esVacio())
			{
			this.setResuladooperacion("OK");
			this.getSesion().setAttribute("listahorario",listaHor);
			//borro los posibles errores que se hayan generado antes para que no los muestre
			//en la pagina siguiente, ya que estos se habran resuelto ya.
			this.getSesion().removeAttribute("error");
			}
			else //hay errores en los datos del curso
			{
				this.setResuladooperacion("ERROR");
				this.getSesion().setAttribute("error",listae);
			}
			}
		}
		
		//si la consulta ha fallado en la base de datos
		
		else if (listaHor==null)
		{   
			ObjetoBean error=creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA,"Fallo en la base de datos");
			ListaObjetoBean lerror=new ListaObjetoBean();
			int posi=lerror.tamanio();
			lerror.insertar(posi,error);
			this.getSesion().setAttribute("error",lerror);
			this.setResuladooperacion("ERROR");
		}
	}
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		
		return new ControladorInsCurHor();
	}

}
