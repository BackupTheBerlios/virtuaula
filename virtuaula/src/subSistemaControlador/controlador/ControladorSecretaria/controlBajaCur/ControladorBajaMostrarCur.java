package subSistemaControlador.controlador.ControladorSecretaria.controlBajaCur;

import subSistemaControlador.controlador.Controlador;
import beans.listaObjetoBeans.ListaObjetoBean;
import beans.*;
import gestores.GestorCursos;

/**
 * 
 * @author Alberto Macho
 * Este controlador controla la navegaci�n entre dos paginas
 * en la baja de un curso. En este paso buscar� el profesor, horario, aula y �rea
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
	 * tiene que pasar. Ademas utilizando el gestor de cursos consulta el area, el aula
	 * , el profesor y el horario del curso en concreto
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
		/**
		 * @return nos devuelve un controlador de esta clase
		 */
		public Controlador clonar(){
			return new ControladorBajaMostrarCur();
		}

}
