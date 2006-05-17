package controlador.controlConsulCur;

import beans.listaObjetoBeans.ListaObjetoBean;
import beans.*;
import controlador.Controlador;
import gestores.GestorCursos;

/**
 * 
 * @author Sergio Piqueras Martínez
 * Este controlador controla la navegación entre dos paginas
 * en la consulta de un curso. En este paso consultará los cursos que cumplen las
 * características de los datos introducidos en la página anterior para poder 
 * mostrarlos en la pagina siguiente.
 *
 */
public class ControladorConsCur extends Controlador{

	/**
	 * Constructora de la clase.
	 */
	public ControladorConsCur() {
		super();
	}
	/**
	 * Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	 * tiene que pasar. Ademas utilizando el gestor de cursos consulta los cursos con
	 * el bean que le pasamos por la session.
	 */
		public void procesarEvento() {
			ObjetoBean curso = (Curso)this.getSesion().getAttribute("beancurso");
			//ListaObjetoBean	listacurso=this.gestorCursos.consultaCursos(curso);
			GestorCursos gestor = new GestorCursos();
			ListaObjetoBean	listacurso=gestor.consultaCurso(curso);
			this.getSesion().setAttribute("listacurso",listacurso);
			
			if (listacurso!=null)this.setResuladooperacion("OK");
			else if (listacurso==null)this.setResuladooperacion("ERROR");
		}
		public Controlador clonar(){
			return new ControladorConsCur();
		}
}
