package subSistemaControlador.controlador.ControladorProfesor.controlEditarFicha;

import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorProfesor.ControladorProfesor;
import gestores.Profesorado;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * 
 * @author Alberto Macho
 *Controlador necesario para llevar el control entre las paginas
 *de la actualizacion de la ficha de un alumno.
 */
public class ActualizarFichaAlumno extends ControladorProfesor{
/**
 * Actualiza la ficha del alumno con los datos que le han pasado del alumno cogiendolos
 * de la sesion.
 */
	public void procesarEvento() {
		
		ObjetoBean ficha=(ObjetoBean)this.getSesion().getAttribute("beanFicha");
		Profesorado GP = new Profesorado();
		System.out.println("el id de la ficha "+ ficha.dameValor("IDISFICHA"));
		ListaObjetoBean lerror= GP.editarFicha(ficha);
		if (lerror==null)
		{
			this.setResuladooperacion("OK");
			this.getSesion().removeAttribute("error");
		}
		else if (lerror!=null)
		{	
			CreadorBean creador = new CreadorBean();
			ObjetoBean error = creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA,"Se ha producido un error en la base de datos");
			ListaObjetoBean listaerror = new ListaObjetoBean();
			listaerror.insertar(0,error);
			this.getSesion().setAttribute("error",listaerror);
			this.setResuladooperacion("ERROR");
			this.sesion.setAttribute("error",lerror);
		}
	
	}

	public Controlador clonar() {
		
		return new ActualizarFichaAlumno();
	}

}
