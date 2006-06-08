package subSistemaControlador.controlador.ControladorSecretaria.controlConsulHor;

import subSistemaControlador.controlador.Controlador;
import gestores.GestorCursos;
import beans.listaObjetoBeans.ListaObjetoBean;

/**
 * 
 * 
 * Este controlador controla la navegación entre dos paginas
 * en la consulta horarios. En este paso consultará todos los horarios existentes 
 * en el sistema y los metera en sesion para poder mostrarlos en 
 * la pagina siguiente
 *
 */
public class ControladorConsHor extends ControladorConsultaHorario{

	/**
	 * Constructora de la clase.
	 */
	public ControladorConsHor() {
		
	}
	/**
	 * Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	 * tiene que pasar. Ademas utilizando el gestor de cursos consulta los horarios
	 * existentes en el sistema.
	 */
		public void procesarEvento() {
			
			ListaObjetoBean	listahorario = new ListaObjetoBean();	
			GestorCursos gestor = new GestorCursos();
			listahorario = gestor.consultaHorarios();
			
			if ((listahorario!=null)){
				this.setResuladooperacion("OK");
				this.getSesion().setAttribute("listahorario",listahorario);
				this.getSesion().setAttribute("beanHorario",null);
			}
			else if ((listahorario==null)){
				this.setResuladooperacion("ERROR");
			}		
		}
		/**
		 * @return nos devuelve un controlador de esta clase
		 */
		public Controlador clonar(){
			return new ControladorConsHor();
		}
}
