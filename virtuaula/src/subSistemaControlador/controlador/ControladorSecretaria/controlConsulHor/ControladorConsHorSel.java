package subSistemaControlador.controlador.ControladorSecretaria.controlConsulHor;

import subSistemaControlador.controlador.Controlador;
import gestores.GestorCursos;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;


public class ControladorConsHorSel extends ControladorConsultaHorario{

	/**
	 * Constructora de la clase.
	 */
	public ControladorConsHorSel() {
		
	}
	
		public void procesarEvento() {
			
			ListaObjetoBean	listahorario = new ListaObjetoBean();	
			GestorCursos gestor = new GestorCursos();
			listahorario = gestor.consultaHorarios();
			
			if ((listahorario!=null)){
				this.setResuladooperacion("OK");
				this.getSesion().setAttribute("listahorario",listahorario);				
				Integer posHor= (Integer)this.getSesion().getAttribute("posHor");
				if (posHor != null){
					int posh= posHor.intValue();
					ObjetoBean horario =(ObjetoBean )listahorario.dameObjeto(posh);
					this.getSesion().setAttribute("beanHorario",horario);
				}
			}
			else if ((listahorario==null)){
				this.setResuladooperacion("ERROR");
			}		
		}
		public Controlador clonar(){
			return new ControladorConsHorSel();
		}
}
