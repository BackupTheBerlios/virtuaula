package subSistemaControlador.controlador.ControladorSecretaria.controlConsulHor;

import subSistemaControlador.controlador.Controlador;
import gestores.GestorCursos;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

/**
 * 
 * 
 * Este controlador controla la navegación entre dos paginas
 * en la consulta horarios. Obtendremos el horario seleccionado
 * en la pagina anterior
 *
 */
public class ControladorConsHorSel extends ControladorConsultaHorario{

	/**
	 * Constructora de la clase.
	 */
	public ControladorConsHorSel() {
		
	}
	/**
	 * Este metodo nos modifica el resultado operacion para saber a que pagina tiene que 
	 * dirigirse luego
	 * Obtiene el horario seleccionado en la pagina anterior y lo mete en sesion
	 */
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
				else{
					this.getSesion().removeAttribute("beanHorario");
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
			return new ControladorConsHorSel();
		}
}
