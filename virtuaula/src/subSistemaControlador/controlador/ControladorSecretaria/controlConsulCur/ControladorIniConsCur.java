package subSistemaControlador.controlador.ControladorSecretaria.controlConsulCur;

import subSistemaControlador.controlador.Controlador;
import gestores.GestorCursos;
import beans.listaObjetoBeans.ListaObjetoBean;

/**
 * 
 * @author Sergio Piqueras Martínez
 * Este controlador controla la navegación entre dos paginas
 * en la consulta de un curso. En este paso consultará las areas, los horarios, 
 * los profesore y las aulas disponibles en el sistema para poder mostrarlas en 
 * la pagina siguiente.
 *
 */
public class ControladorIniConsCur extends ControladorConsultaCurso{

	/**
	 * Constructora de la clase.
	 */
	public ControladorIniConsCur() {
		super();
	}
	/**
	 * Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	 * tiene que pasar. Ademas utilizando el gestor de cursos consulta los profesores,
	 * aulas, areas y horarios y se los pasamos a la session.
	 */
		public void procesarEvento() {
			
			ListaObjetoBean	listaaula = new ListaObjetoBean(),
							listaarea = new ListaObjetoBean(),
							listahorario = new ListaObjetoBean(),
							listaprofesor = new ListaObjetoBean();	
			/*listaarea=this.gestorCursos.consultaArea();
			listaaula=this.gestorCursos.consultaAula();
			listaprofesor=this.gestorCursos.consultaProfesores();
			listahorario=this.gestorCursos.consultaHorarios();*/
			GestorCursos gestor = new GestorCursos();
			listaarea = gestor.consultaAreas();
			listaaula = gestor.consultaAulas();
			listaprofesor = gestor.consultaProfesores();
			listahorario = gestor.consultaHorarios();
			
			if ((listaarea!=null)&&(listaaula!=null)&&(listaprofesor!=null)&&
				(listahorario!=null)){
				this.setResuladooperacion("OK");
				this.getSesion().setAttribute("listaaula",listaaula);
				this.getSesion().setAttribute("listaarea",listaarea);
				this.getSesion().setAttribute("listaprofesor",listaprofesor);
				this.getSesion().setAttribute("listahorario",listahorario);
			}
			else if ((listaarea==null)||(listaaula==null)||(listaprofesor==null)||
					 (listahorario==null)){
				this.setResuladooperacion("ERROR");
			}		
		}
		public Controlador clonar(){
			return new ControladorIniConsCur();
		}
}
