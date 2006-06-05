package subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno;


import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import beans.*;
import gestores.GestorAlumnos;

/**
 * Se encarga de obtener los datos del alumno consultado y proporcionar en la variable 
 * listexp la informacion de su expediente.
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
			//GestorCursos gestor = new GestorCursos();
			//ListaObjetoBean cursos= gestor.consultarCursosDeAlumno(alumno);
			GestorAlumnos GA = new GestorAlumnos();
			ListaObjetoBean listaexp=GA.creaExpedienteAlumno(alumno);
						
			
			if(alumno!=null){
				this.getSesion().removeAttribute("beanCurso");
				//this.getSesion().setAttribute("listacurso",cursos);
				this.getSesion().setAttribute("listaexp",listaexp);
				this.setResuladooperacion("OK");
			}
			else{
				CreadorBean creador =new CreadorBean();
				ObjetoBean error= creador.crear(creador.Error);
				error.cambiaValor(Constantes.CAUSA,"Fallo en la base de datos al consultar el alumno");
			    CreadorListaObjetoBean creadorlista =new CreadorListaObjetoBean();
			    ListaObjetoBean listaerror = creadorlista.crear(); 
			    listaerror.insertar(0,error);
			    this.getSesion().setAttribute("error",listaerror);
				this.setResuladooperacion("ERROR");
			}
		
		}
		public Controlador clonar(){
			return new ControladorMostrarAlumno();
		}

}
