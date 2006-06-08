package subSistemaControlador.controlador.ControladorSecretaria.controlConsulHor;

import subSistemaControlador.controlador.Controlador;
import gestores.GestorHorarios;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

/**
 * 
 * 
 * Este controlador controla la navegación entre dos paginas
 * en la consulta horarios. En este paso obtendremos en horario elegido en la
 * pagina anteriro y lo meteremos en sesion para que lo pueda
 * mostrar en la pagina seguiente
 *
 */
public class ControladorConsHorBor2 extends ControladorConsultaHorario{

	/**
	 * Constructora de la clase.
	 */
	public ControladorConsHorBor2() {
		
	}
	/**
	 * Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	 * tiene que pasar. Ademas utilizando el gestor de horarios consulta los horarios
	 * disponibles en el sistema. Tambien obtenemos el horario elegido en la
	 * pagina anterior y lo metemos en sesion
	 */
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
		/**
		 * @return nos devuelve un controlador de esta clase
		 */
		public Controlador clonar(){
			return new ControladorConsHorBor2();
		}
}
