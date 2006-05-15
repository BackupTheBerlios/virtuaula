package controlador.controlEditarFicha;

import gestores.Profesorado;

import javax.servlet.http.HttpSession;

import beans.Curso;
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
		Curso cur = (Curso)lista.dameObjeto(posicion);
		sesion.setAttribute("beanCurso",cur);
		
		ListaObjetoBean listaal = new ListaObjetoBean();
		Profesorado GP = new Profesorado();
		listaal = GP.consultaAlumnosDeCurso(cur);
		
		if (listaal !=null)
		{
			this.setResuladooperacion("OK");
			sesion.setAttribute("listaalumno",listaal);
					
		}
		else if (listaal==null)
		{
			this.setResuladooperacion("ERROR");
		}
		
	}

	public Controlador clonar() {
		return new ListarAlumnosCurso();
	}

}
