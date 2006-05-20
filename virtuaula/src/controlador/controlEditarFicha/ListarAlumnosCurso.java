package controlador.controlEditarFicha;

import gestores.Profesorado;
import javax.servlet.http.HttpSession;
import subSistemaBBDD.utils.Constantes;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import controlador.Controlador;
/**
 * 
 * @author Alberto Macho
 *
 */
public class ListarAlumnosCurso extends Controlador{

	public void procesarEvento() {
		
		HttpSession sesion = this.getSesion();
		Integer pos = (Integer)sesion.getAttribute("posCurso");
		int posicion = pos.intValue();
		ListaObjetoBean lista=(ListaObjetoBean) sesion.getAttribute("listacurso");
		ObjetoBean cur = (ObjetoBean)lista.dameObjeto(posicion);
		sesion.setAttribute("beanCurso",cur);
		
		ListaObjetoBean listaal = new ListaObjetoBean();
		Profesorado GP = new Profesorado();
		listaal = GP.consultaAlumnosDeCurso(cur);
		
		if (listaal !=null)
		{
			this.setResuladooperacion("OK");
			sesion.setAttribute("listaalumno",listaal);
			this.getSesion().removeAttribute("error");
					
		}
		else if (listaal==null)
		{   
			CreadorBean creador=new CreadorBean();
			ObjetoBean error = creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA,"Se ha producido un error de base de datos");
			ListaObjetoBean listaerror = new ListaObjetoBean();
			listaerror.insertar(0,error);
			this.getSesion().setAttribute("error",listaerror);
			this.setResuladooperacion("ERROR");
		}
		
	}

	public Controlador clonar() {
		return new ListarAlumnosCurso();
	}

}
