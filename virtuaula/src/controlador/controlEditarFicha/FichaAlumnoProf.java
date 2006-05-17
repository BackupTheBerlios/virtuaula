package controlador.controlEditarFicha;

import gestores.Profesorado;

import javax.servlet.http.HttpSession;

import beans.Alumno;

import beans.Curso;
import beans.Ficha;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

import controlador.Controlador;
/**
 * 
 * @author Alberto Macho
 *
 */
public class FichaAlumnoProf extends Controlador{

	public void procesarEvento() {
		//CreadorBean creador = new CreadorBean();
		HttpSession sesion = this.getSesion();
		
		Integer posa = (Integer)sesion.getAttribute("posAlumno");
		int posalum= posa.intValue();
		ListaObjetoBean lista = (ListaObjetoBean)sesion.getAttribute("listaalumno");
		
		ObjetoBean alum = (Alumno)lista.dameObjeto(posalum);
		
		//Buscamos la ficha del alumno.
		Integer poscur=(Integer)this.getSesion().getAttribute("posCurso");
		int poscurso=poscur.intValue();
		ListaObjetoBean listacurso=(ListaObjetoBean)this.getSesion().getAttribute("listacurso");
		ObjetoBean curso = (Curso)listacurso.dameObjeto(poscurso);
		Profesorado GP = new Profesorado();
		ObjetoBean ficha= GP.consultaFichaDeAlumno(alum,curso);
		//si no falla la consulta en la base de datos
		if (ficha!=null)
		{
			this.setResuladooperacion("OK");
			sesion.setAttribute("beanFicha",ficha);
			
		}
		else if (ficha ==null)
		{
			this.setResuladooperacion("ERROR");
		}
		
	}

	public Controlador clonar() {
		
		return  new FichaAlumnoProf();
	}

}
