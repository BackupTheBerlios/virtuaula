package subSistemaControlador.controlador.ControladorSecretaria.controlEditarAlum;

import gestores.GestorAlumnos;
import subSistemaControlador.controlador.Controlador;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * Se encarga de obtener los alumnos que coinciden con el criterio de busqueda 
 * seleccionado por un secretario a la hora de editar un alumno.
 * @author JORGE SANCHEZ
 *
 */
public class ControladorBuscarAlumEditar extends ControladorEditarAlumno {

	
	/**
	 * Este metodo nos modifica el resultado operacion para indicar a la pagina que
	 * tiene que pasar.  Ademas con el Gestor de alumnos consulta los alumnos con caracteristicas
	 * que le pasamos en un beanAlumno
	 */
		public void procesarEvento() {
			ObjetoBean alumno=(ObjetoBean)this.getSesion().getAttribute("beanAlumno");
			GestorAlumnos GA = new GestorAlumnos();
			ListaObjetoBean listaAlumnos;
			listaAlumnos =GA.consultaAlumnos(alumno);
						
		
			this.getSesion().setAttribute("listaalumno",listaAlumnos);
			if (listaAlumnos!=null){
				this.setResuladooperacion("OK");
				
			}	
			else {
				this.setResuladooperacion("ERROR");
			}		
		}
	/**
	 * @return nos devuelve un controlador de esta clase
	 */
		public Controlador clonar(){
			return new ControladorBuscarAlumEditar();
		}
	
}
