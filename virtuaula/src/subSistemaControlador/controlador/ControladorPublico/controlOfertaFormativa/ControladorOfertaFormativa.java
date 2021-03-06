package subSistemaControlador.controlador.ControladorPublico.controlOfertaFormativa;
import gestores.GestorCursos;
import javax.servlet.http.HttpSession;
import beans.ObjetoBean;
import beans.CreadorBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.*; 
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorPublico.ControladorPublico;
/**
 * 
 * Controla el acceso a la oferta formativa. Realizando las 
 * operaciones correspondiente.
 * Dependiendo del resultado se hara una cosa u otra
 *
 */
public class ControladorOfertaFormativa extends ControladorPublico{
	/**
	* Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	* tiene que pasar. Ademas utilizando el GestorCursos consulta los cursos activos
	* para mostrar la lista de cursos que se imparten en la academia
	*/
	public void procesarEvento() {
		
		CreadorBean creador = new CreadorBean();	
		GestorCursos GC= new GestorCursos();
		HttpSession sesion = this.getSesion();
		
		ObjetoBean prof=creador.crear(creador.Profesor);
		//esto tendria q ser un metodo sin parametros, provisional
		ListaObjetoBean lista=GC.consultaCursosActivos(prof);
	
		if (lista!=null)
		{
			this.setResuladooperacion("OK");
			sesion.setAttribute("listacurso",lista);
			this.getSesion().removeAttribute("error");
		}
		//si falla la base de datos se produce un error y se mete en la sesion
		else if (lista==null)
		{
			ObjetoBean error = creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA,"Se ha producido un error en la base de datos.");
			ListaObjetoBean listaerror = new ListaObjetoBean();
			listaerror.insertar(0,error);
			this.getSesion().setAttribute("error",listaerror);
			this.setResuladooperacion("ERROR");
		}
			
		}
/**
 * @return devuelve un controlador de esta clase
 */
		public Controlador clonar() {
			
			return new ControladorOfertaFormativa();
		}

}
