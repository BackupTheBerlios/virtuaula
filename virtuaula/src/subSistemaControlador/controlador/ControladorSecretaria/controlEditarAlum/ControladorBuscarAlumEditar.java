package subSistemaControlador.controlador.ControladorSecretaria.controlEditarAlum;

import gestores.GestorAlumnos;
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno.ControladorConsAlumno;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * 
 * @author JORGE SANCHEZ
 *
 */
public class ControladorBuscarAlumEditar extends ControladorEditarAlumno {

	
	/**
	 * Este metodo nos modifica el resultado operacion para indicar a la pagina que
	 * tiene que pasar. 
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
	
		public Controlador clonar(){
			return new ControladorBuscarAlumEditar();
		}
	
}
