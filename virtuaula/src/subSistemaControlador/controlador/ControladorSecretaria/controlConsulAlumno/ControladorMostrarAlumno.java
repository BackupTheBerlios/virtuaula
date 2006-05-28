package subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno;


import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorSecretaria.ControladorSecretaria;
import beans.listaObjetoBeans.ListaObjetoBean;
import beans.*;
import gestores.GestorCursos;
import gestores.GestorAlumnos;
/**
 * 
 * @author JORGE SANCHEZ
 *
 */
public class ControladorMostrarAlumno extends ControladorConsultaAlumno{
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
			ListaObjetoBean cursos= gestor.consultarCursosDeAlumno(alumno);
			
			
			if(alumno!=null){
				this.getSesion().removeAttribute("beanCurso");
				this.getSesion().setAttribute("listacurso",cursos);
				this.setResuladooperacion("OK");
			}
			else{
				this.setResuladooperacion("ERROR");
			}
		
		}
		public Controlador clonar(){
			return new ControladorMostrarAlumno();
		}

}
