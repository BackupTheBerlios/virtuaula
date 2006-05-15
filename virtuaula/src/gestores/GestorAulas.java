package gestores;

import subSistemaBBDD.BBDDFachada;
import beans.Aula;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

public class GestorAulas {

	public GestorAulas() {
		super();
	}

	public ListaObjetoBean consultaAulas() {
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean cBean = new CreadorBean();
		Aula aula = (Aula) cBean.crear(2);
		ListaObjetoBean l = bdf.consultar(aula);
		return l;
	}
	
	public ListaObjetoBean consultaAulasPorHorario (ObjetoBean beanHorario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.dameAulasLibres(beanHorario);	
		return l;
	}
	
}
