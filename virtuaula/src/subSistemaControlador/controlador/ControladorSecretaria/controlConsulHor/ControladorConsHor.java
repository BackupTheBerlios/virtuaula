package subSistemaControlador.controlador.ControladorSecretaria.controlConsulHor;

import subSistemaControlador.controlador.Controlador;
import gestores.GestorCursos;
import beans.listaObjetoBeans.ListaObjetoBean;


public class ControladorConsHor extends ControladorConsultaHorario{

	/**
	 * Constructora de la clase.
	 */
	public ControladorConsHor() {
		
	}
	
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
		public Controlador clonar(){
			return new ControladorConsHor();
		}
}
