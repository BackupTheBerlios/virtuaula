package subSistemaControlador.controlador.ControladorSecretaria.controlConsulHor;

import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import gestores.GestorHorarios;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * 
 * 
 * Este controlador controla la navegación entre dos paginas
 * en la eliminación de un horario.En este paso consultara si esta siendo 
 * utilizado y si no esta siendo
 * utilizado lo eliminara y si no dara error.
 *
 */

public class ControladorConsHorBor3 extends ControladorConsultaHorario{

	/**
	 * Constructora de la clase.
	 */
	public ControladorConsHorBor3() {
		
	}
	/**
	 * Nos modifica el resultado de operacion entre una pagina y otra dependiendo
	 * del exito de las operaciones que realiza. En este caso con el gestor de horarios
	 * consultamos si el horario esta utilizado o no y si no esta utilizado lo eliminamos.
	 */
		public void procesarEvento() {
			GestorHorarios gestor = new GestorHorarios();
			ObjetoBean horario =(ObjetoBean ) this.getSesion().getAttribute("beanHorario");	
			CreadorBean creador =new CreadorBean();
			ListaObjetoBean listaerror = new ListaObjetoBean();
			ObjetoBean error = creador.crear(creador.Error);
			if (!gestor.horarioUtilizado(horario)){
				if (gestor.eliminaHorario(horario)){
					//libre y borrado
					this.setResuladooperacion("OK");
				}
				else{
					
					error.cambiaValor(Constantes.CAUSA,"Se ha producido un error en la base de datos.");
					listaerror.insertar(0,error);
					this.getSesion().setAttribute("error",listaerror);
					this.setResuladooperacion("ERROR");
				}
			}
			else{
				error.cambiaValor(Constantes.CAUSA,"El horario escogido está asignado, no puede borrarlo hasta que esté deasignado.");
				listaerror.insertar(0,error);
				this.getSesion().setAttribute("error",listaerror);
				this.setResuladooperacion("ERROR");
			}
		
			this.getSesion().removeAttribute("posHor");
		}
		/**
		 * @return nos devuelve un controlador de esta clase
		 */
		public Controlador clonar(){
			return new ControladorConsHorBor3();
		}
}
