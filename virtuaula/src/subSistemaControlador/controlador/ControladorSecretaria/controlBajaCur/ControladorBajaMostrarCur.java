package subSistemaControlador.controlador.ControladorSecretaria.controlBajaCur;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorSecretaria.ControladorSecretaria;
import beans.listaObjetoBeans.ListaObjetoBean;
import beans.*;
import gestores.GestorCursos;

/**
 * 
 * @author Sergio Piqueras Martínez
 * Este controlador controla la navegación entre dos paginas
 * en la consulta de un curso. En este paso buscará el profesor, horario, aula y área
 * que tiene el curso seleccionado y los pasa a la session.
 *
 */
public class ControladorBajaMostrarCur extends ControladorBajaCurso{

	/**
	 * Constructora de la clase.
	 */
	public ControladorBajaMostrarCur() {
		super();
	}
	/**
	 * Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	 * tiene que pasar. Ademas utilizando el gestor de cursos consulta los cursos con
	 * el bean que le pasamos por la session.
	 */
		public void procesarEvento() {
			
			Integer poscur= (Integer)this.getSesion().getAttribute("posCurso");
			ListaObjetoBean	listacurso=(ListaObjetoBean)this.getSesion().getAttribute("listacurso");
			int posc= poscur.intValue();
			ObjetoBean curso=(ObjetoBean)listacurso.dameObjeto(posc);
			GestorCursos gestor = new GestorCursos();
			ObjetoBean area=gestor.consultaAreaDeCurso(curso);
			ObjetoBean aula=gestor.consultaAulaDeCurso(curso);
			ObjetoBean profesor=gestor.consultaProfesorDeCurso(curso);
			ObjetoBean horario=gestor.consultaHorarioDeCurso(curso);
			
			if ((area!=null) && (aula!=null) && (profesor!=null) && (horario!=null))
			{
			this.getSesion().setAttribute("beanAula",aula);
			this.getSesion().setAttribute("beanArea",area);
			this.getSesion().setAttribute("beanProfesor",profesor);
			this.getSesion().setAttribute("beanHorario",horario);
			this.setResuladooperacion("OK");
			}
			else if ((area==null) || (aula==null) || (profesor==null) || (horario==null))
			{
				this.setResuladooperacion("ERROR");
			}
			}
		public Controlador clonar(){
			return new ControladorBajaMostrarCur();
		}

}
