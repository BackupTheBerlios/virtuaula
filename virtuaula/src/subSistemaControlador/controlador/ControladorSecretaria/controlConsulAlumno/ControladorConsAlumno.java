package subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno;

import gestores.GestorAlumnos;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorSecretaria.ControladorSecretaria;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * Controlador intermedio de consultar un alumno por parte de un secretario
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
			ListaObjetoBean lcurso= (ListaObjetoBean)this.getSesion().getAttribute("listacurso");
			
			int posCurso= ((Integer)this.getSesion().getAttribute("posCurso")).intValue();
			GestorAlumnos GA = new GestorAlumnos();
			ListaObjetoBean listaAlumnos;
			//ObjetoBean curso=(ObjetoBean)this.getSesion().getAttribute("beanCurso");
			
			ObjetoBean curso=(ObjetoBean)lcurso.dameObjeto(posCurso);
			listaAlumnos =GA.consultaAlumnosCumplan(curso,alumno);
			
			
			
			this.getSesion().setAttribute("listaalumno",listaAlumnos);
			if (listaAlumnos!=null){
				//this.getSesion().removeAttribute("beanCurso");
				//this.getSesion().removeAttribute("beanAlumno");
				this.setResuladooperacion("OK");
				
			}	
			else {
				this.setResuladooperacion("ERROR");
			}		
		}
		public Controlador clonar(){
			return new ControladorConsAlumno();
		}
}
