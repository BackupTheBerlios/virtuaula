package subSistemaControlador.controlador.ControladorSecretaria.controlConsulHor;

import subSistemaControlador.controlador.Controlador;
import gestores.GestorHorarios;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;


public class ControladorConsHorBor2 extends ControladorConsultaHorario{

	/**
	 * Constructora de la clase.
	 */
	public ControladorConsHorBor2() {
		
	}
	
		public void procesarEvento() {
			ListaObjetoBean	listahorario = new ListaObjetoBean();	
			GestorHorarios gestor = new GestorHorarios();
			listahorario = gestor.consultaHorariosDisponibles();
			
			if ((listahorario!=null)){
				this.getSesion().setAttribute("listahorario",listahorario);				
				Integer posHor= (Integer)this.getSesion().getAttribute("posHor");
				if (posHor != null){
					int posh= posHor.intValue();
					ObjetoBean horario =(ObjetoBean )listahorario.dameObjeto(posh);
					this.getSesion().setAttribute("beanHorario",horario);
					this.setResuladooperacion("OK");
				}
				else{
					this.getSesion().removeAttribute("beanHorario");
					this.setResuladooperacion("ERROR");
				}
				this.getSesion().removeAttribute("posHor");
				
			}
			else if ((listahorario==null)){
				this.setResuladooperacion("ERROR");
			}		
		}
		public Controlador clonar(){
			return new ControladorConsHorBor2();
		}
}
