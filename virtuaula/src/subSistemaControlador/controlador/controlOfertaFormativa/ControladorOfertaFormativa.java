package subSistemaControlador.controlador.controlOfertaFormativa;
import gestores.GestorCursos;
import javax.servlet.http.HttpSession;
import beans.ObjetoBean;
import beans.CreadorBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.*; 
import subSistemaControlador.controlador.Controlador;
public class ControladorOfertaFormativa extends Controlador{
	
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

		public Controlador clonar() {
			
			return new ControladorOfertaFormativa();
		}

}
