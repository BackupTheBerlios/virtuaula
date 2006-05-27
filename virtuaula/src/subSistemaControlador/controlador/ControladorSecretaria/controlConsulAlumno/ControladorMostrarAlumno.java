package subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno;

import subSistemaControlador.controlador.Controlador;
import beans.listaObjetoBeans.ListaObjetoBean;
import beans.*;
import gestores.GestorCursos;
/**
 * 
 * @author JORGE SANCHEZ
 *
 */
public class ControladorMostrarAlumno extends Controlador{
	/**
	 * Constructora de la clase.
	 */
	public ControladorMostrarAlumno() {
		super();
	}
	/**
	 * Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	 * tiene que pasar. 
	 */
		public void procesarEvento() {
			
			Integer posAlum= (Integer)this.getSesion().getAttribute("posAlumno");
			
			ListaObjetoBean	listaAlumno=(ListaObjetoBean)this.getSesion().getAttribute("listaalumno");

			int posa= posAlum.intValue();
			ObjetoBean alumno=(ObjetoBean)listaAlumno.dameObjeto(posa);
			GestorCursos gestor = new GestorCursos();
			ListaObjetoBean listaCursosAlumno= gestor.consultarCursosDeAlumno(alumno);
			
			if(alumno!=null){
				this.getSesion().removeAttribute("listaalumno");
				this.getSesion().removeAttribute("posAlumno");
				this.getSesion().setAttribute("listacurso",listaCursosAlumno);
				this.getSesion().setAttribute("beanAlumno",alumno);
				this.setResuladooperacion("OK");
			}
			else{
				this.getSesion().removeAttribute("listaalumno");
				this.getSesion().removeAttribute("posAlumno");
				this.setResuladooperacion("ERROR");
			}
		
		}
		public Controlador clonar(){
			return new ControladorMostrarAlumno();
		}

}
