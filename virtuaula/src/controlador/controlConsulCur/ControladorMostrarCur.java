package controlador.controlConsulCur;

import beans.listaObjetoBeans.ListaObjetoBean;
import beans.*;
import controlador.Controlador;
import gestores.GestorCursos;

/**
 * 
 * @author Sergio Piqueras Martínez
 * Este controlador controla la navegación entre dos paginas
 * en la consulta de un curso. En este paso buscará el profesor, horario, aula y área
 * que tiene el curso seleccionado y los pasa a la session.
 *
 */
public class ControladorMostrarCur extends Controlador{

	/**
	 * Constructora de la clase.
	 */
	public ControladorMostrarCur() {
		super();
	}
	/**
	 * Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	 * tiene que pasar. Ademas utilizando el gestor de cursos consulta los cursos con
	 * el bean que le pasamos por la session.
	 */
		public void procesarEvento() {
			ListaObjetoBean	listacurso=(ListaObjetoBean)this.getSesion().getAttribute("listacurso");
			Curso curso=(Curso)listacurso.dameObjeto(Integer.valueOf((String)this.sesion.getAttribute("posCurso")).intValue());
			GestorCursos gestor = new GestorCursos();
			Area area=gestor.consultaAreaDeCurso(curso);
			Aula aula=gestor.consultaAulaDeCurso(curso);
			Profesor profesor=gestor.consultaProfesorDeCurso(curso);
			Horario horario=gestor.consultaHorarioDeCurso(curso);
			
			if ((area!=null) && (aula!=null) && (profesor!=null) && (horario!=null))
			{
			this.getSesion().setAttribute("beanaula",aula);
			this.getSesion().setAttribute("beanarea",area);
			this.getSesion().setAttribute("beanprofesor",profesor);
			this.getSesion().setAttribute("beanhorario",horario);
			this.setResuladooperacion("OK");
			}
			else if ((area==null) || (aula==null) || (profesor==null) || (horario==null))
			{
				this.setResuladooperacion("ERROR");
			}
			}
		public Controlador clonar(){
			return new ControladorMostrarCur();
		}

}
