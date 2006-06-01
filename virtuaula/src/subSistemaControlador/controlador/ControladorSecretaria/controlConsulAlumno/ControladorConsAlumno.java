package subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno;


import gestores.GestorAlumnos;

import subSistemaControlador.controlador.Controlador;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

/**
 * Controlador intermedio de consultar un alumno por parte de un secretario
 * Se encarga de realizar la consulta propiamente dicha guiándose por el criterio alumno y 
 * curso que el secretario haya introducido.
 * 
 * @author JORGE SANCHEZ
 *
 */
public class ControladorConsAlumno extends ControladorConsultaAlumno {

	
	/**
	 * Este metodo nos modifica el resultado operacion para indicar a la pagina que
	 * tiene que pasar. 
	 */
		public void procesarEvento() {
			ObjetoBean alumno=(ObjetoBean)this.getSesion().getAttribute("beanAlumno");
			GestorAlumnos GA = new GestorAlumnos();
			ListaObjetoBean listaAlumnos;
			ObjetoBean curso=(ObjetoBean)this.getSesion().getAttribute("beanCurso");
			listaAlumnos =GA.consultaAlumnosCumplan(curso,alumno);
						
		
			this.getSesion().setAttribute("listaalumno",listaAlumnos);
			if (listaAlumnos!=null){
				this.getSesion().removeAttribute("beanCurso");
				this.setResuladooperacion("OK");
				
			}	
			else {
				this.getSesion().removeAttribute("beanCurso");
				this.setResuladooperacion("ERROR");
			}		
		}
		public Controlador clonar(){
			return new ControladorConsAlumno();
		}
}
