package gestores;

import subSistemaBBDD.BBDDFachada;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.Profesor;
import beans.listaObjetoBeans.ListaObjetoBean;

public class Profesorado {
	
	public Profesorado() {
		super();
	}
	
	public ListaObjetoBean consultaProfesores() {	
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean cBean = new CreadorBean();
		Profesor profesor = (Profesor) cBean.crear(11);
		ListaObjetoBean l = bdf.consultar(profesor);
		return l;
	}
	
	public ListaObjetoBean consultaProfesoresPorHorario (ObjetoBean beanHorario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.dameProfesoresLibres(beanHorario);	
		return l;
	}
	
	public ListaObjetoBean consultaAreas() {
		GestorAreas ga = new GestorAreas();
		return ga.consultaAreas();
	}
	
	public ListaObjetoBean consultaprofesor(ObjetoBean beanProfesor) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.consultar(beanProfesor);
		return l;
	}

}
