package subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno;

import gestores.GestorAlumnos;

import subSistemaControlador.controlador.Controlador;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * Controlador intermedio de consultar un alumno por parte de un secretario
 * @author JORGE SANCHEZ
 *
 */
public class ControladorConsAlumno extends Controlador {

	
	/**
	 * Este metodo nos modifica el resultado operacion para indicar a la pagina que
	 * tiene que pasar. 
	 */
		public void procesarEvento() {

			ObjetoBean alumno=(ObjetoBean)this.getSesion().getAttribute("beanAlumno");
			GestorAlumnos GA = new GestorAlumnos();
			
			//Realmente hay que hacer la consulta por el curso y el alumno.
			ListaObjetoBean listaAlumnos =GA.consultaAlumnos(alumno);
			
			if (listaAlumnos!=null){
				this.setResuladooperacion("OK");
				this.getSesion().setAttribute("listaAlumno",listaAlumnos);
			}	
			else {
				this.setResuladooperacion("ERROR");
			}		
		}
		public Controlador clonar(){
			return new ControladorIniConsAlumno();
		}
}
