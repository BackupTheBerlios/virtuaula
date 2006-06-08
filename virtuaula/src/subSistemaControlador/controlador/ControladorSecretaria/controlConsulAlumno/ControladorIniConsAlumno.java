package subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno;
import subSistemaControlador.controlador.Controlador;
import gestores.GestorCursos;
import beans.listaObjetoBeans.ListaObjetoBean;


/**
 * 
 * @author JORGE SANCHEZ
 * Controla el paso de una pagina a otra al elegir una seretaria la opcion de consultar un alumno.
 * Se encarga de borrar todos los atributos de la sesion que vaya a utilizar el caso de uso
 * de consultar un alumno y de obtener los cursos activos.
 */
public class ControladorIniConsAlumno extends ControladorConsultaAlumno{

	/**
	 * Constructora de la clase.
	 */
	public ControladorIniConsAlumno() {
		super();
	}
	/**
	 * Este metodo nos modifica el resultado operacion para indicar a la pagina que
	 * tiene que pasar. 
	 */
		public void procesarEvento() {
			this.getSesion().removeAttribute("error");
			ListaObjetoBean	listaCursos = new ListaObjetoBean();
			GestorCursos gestor = new GestorCursos();
			listaCursos= gestor.dameCursosActivos();
			this.getSesion().removeAttribute("beanAlumno");
			this.getSesion().removeAttribute("posCurso");
			this.getSesion().removeAttribute("posAula");
			this.getSesion().removeAttribute("posAlumno");
			this.getSesion().removeAttribute("beanAlumno");
			this.getSesion().removeAttribute("beanCurso");
			
			if (listaCursos!=null){
				this.setResuladooperacion("OK");
				this.getSesion().setAttribute("listacurso",listaCursos);
			}	
			else {
				this.setResuladooperacion("ERROR");
			}		
		}
		/**
		 * @return nos devuelve un controlador de esta clase
		 */
		public Controlador clonar(){
			return new ControladorIniConsAlumno();
		}
}

