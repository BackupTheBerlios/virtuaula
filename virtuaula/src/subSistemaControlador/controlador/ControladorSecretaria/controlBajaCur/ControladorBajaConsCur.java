package subSistemaControlador.controlador.ControladorSecretaria.controlBajaCur;

import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import beans.listaObjetoBeans.ListaObjetoBean;
import beans.*;
import gestores.GestorCursos;

/**
 * 
 * @author Alberto Macho
 * Este controlador controla la navegación entre dos paginas
 * en la consulta de un curso. En este paso consultará los cursos que cumplen las
 * características de los datos introducidos en la página anterior para poder 
 * mostrarlos en la pagina siguiente.
 *
 */
public class ControladorBajaConsCur extends ControladorBajaCurso{

	/**
	 * Constructora de la clase.
	 */
	public ControladorBajaConsCur() {
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
			curso.cambiaValor(Constantes.CURSO_ESTADO,"activo");			
			ListaObjetoBean	listacurso=gestor.consultaCurso(curso,aula,horario);
			this.getSesion().setAttribute("listacurso",listacurso);
			
			if (listacurso!=null)this.setResuladooperacion("OK");
			else if (listacurso==null)this.setResuladooperacion("ERROR");
		}
		public Controlador clonar(){
			return new ControladorBajaConsCur();
		}
}
