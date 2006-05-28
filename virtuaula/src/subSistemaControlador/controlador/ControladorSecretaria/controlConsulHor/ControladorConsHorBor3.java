package subSistemaControlador.controlador.ControladorSecretaria.controlConsulHor;

import subSistemaControlador.controlador.Controlador;
import gestores.GestorCursos;
import gestores.GestorHorarios;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;


public class ControladorConsHorBor3 extends ControladorConsultaHorario{

	/**
	 * Constructora de la clase.
	 */
	public ControladorConsHorBor3() {
		
	}
	
		public void procesarEvento() {
			GestorHorarios gestor = new GestorHorarios();
			ObjetoBean horario =(ObjetoBean ) this.getSesion().getAttribute("beanHorario");	
			if(gestor.eliminaHorario(horario)){
						this.setResuladooperacion("OK");
						System.out.println("elim");
			}
			else{
						this.setResuladooperacion("ERROR");
			}
			this.getSesion().removeAttribute("posHor");
		}
		public Controlador clonar(){
			return new ControladorConsHorBor3();
		}
}
