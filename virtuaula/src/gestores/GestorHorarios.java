package gestores;

import subSistemaBBDD.BBDDFachada;
import beans.CreadorBean;
import beans.Horario;
import beans.listaObjetoBeans.ListaObjetoBean;

public class GestorHorarios {

	public GestorHorarios() {
		super();
	}

	public ListaObjetoBean consultaHorarios() {
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean cBean = new CreadorBean();
		Horario horario = (Horario) cBean.crear(8);
		ListaObjetoBean l = bdf.consultar(horario);
		return l;
	}
}
