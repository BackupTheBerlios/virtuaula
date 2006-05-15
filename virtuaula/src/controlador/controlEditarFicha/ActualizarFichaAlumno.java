package controlador.controlEditarFicha;

import gestores.Profesorado;
import beans.Ficha;
import beans.listaObjetoBeans.ListaObjetoBean;
import controlador.Controlador;
/**
 * 
 * @author Alberto Macho
 *
 */
public class ActualizarFichaAlumno extends Controlador{
/**
 * Actualiza la ficha del alumno con los datos que le han pasado del alumno cogiendolos
 * de la sesion.
 */
	public void procesarEvento() {
		
		Ficha ficha=(Ficha)this.getSesion().getAttribute("beanFicha");
		Profesorado GP = new Profesorado();
		ListaObjetoBean lerror= GP.editarFicha(ficha);
		if (lerror==null)
		{
			this.setResuladooperacion("OK");
		}
		else if (lerror!=null)
		{
			this.setResuladooperacion("ERROR");
			this.sesion.setAttribute("error",lerror);
		}
	
	}

	public Controlador clonar() {
		
		return new ActualizarFichaAlumno();
	}

}
