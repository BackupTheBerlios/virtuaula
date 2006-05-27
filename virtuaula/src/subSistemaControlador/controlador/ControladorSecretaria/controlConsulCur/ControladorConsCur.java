package subSistemaControlador.controlador.ControladorSecretaria.controlConsulCur;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorSecretaria.ControladorSecretaria;
import beans.listaObjetoBeans.ListaObjetoBean;
import beans.*;
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
public class ControladorConsCur extends ControladorConsultaCurso{

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
			ObjetoBean curso = (ObjetoBean)this.getSesion().getAttribute("beanCurso");
			//ListaObjetoBean	listacurso=this.gestorCursos.consultaCursos(curso);
			GestorCursos gestor = new GestorCursos();
			//TODO consultar por todo curso aula y horario, tengo que coger de session
			//el pos horario el posaula y sacar la lista de aulas y horarios
			//para poder coger el que seleccionamos.
			ObjetoBean aula=(ObjetoBean)this.getSesion().getAttribute("beanAula");
			ObjetoBean horario =(ObjetoBean)this.getSesion().getAttribute("beanHorario");
						
			ListaObjetoBean	listacurso=gestor.consultaCurso(curso,aula,horario);
			this.getSesion().setAttribute("listacurso",listacurso);
			
			if (listacurso!=null)this.setResuladooperacion("OK");
			else if (listacurso==null)this.setResuladooperacion("ERROR");
		}
		public Controlador clonar(){
			return new ControladorConsCur();
		}
}
