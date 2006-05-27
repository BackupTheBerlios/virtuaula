package subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno;
import subSistemaControlador.controlador.Controlador;
import gestores.GestorCursos;
import beans.listaObjetoBeans.ListaObjetoBean;
import gestores.GestorCursos;

/**
 * 
 * @author JORGE SANCHEZ
 * Controla el paso de una pagina a otra al elegir una seretaria la opcion de consultar un alumno.
 */
public class ControladorIniConsAlumno extends Controlador{

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
			
			if (listaCursos!=null){
				this.setResuladooperacion("OK");
				this.getSesion().setAttribute("listacurso",listaCursos);
			}	
			else {
				this.setResuladooperacion("ERROR");
			}		
		}
		public Controlador clonar(){
			return new ControladorIniConsAlumno();
		}
}

