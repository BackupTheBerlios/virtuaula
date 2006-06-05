package subSistemaControlador.controlador.ControladorSecretaria.controlConsulHor;

import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import gestores.GestorHorarios;
import beans.CreadorBean;
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
		public Controlador clonar(){
			return new ControladorConsHorBor3();
		}
}
