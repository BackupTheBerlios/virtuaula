package gestores;


import subSistemaBBDD.BBDDFachada;
import beans.Area;
import beans.CreadorBean;
import beans.listaObjetoBeans.ListaObjetoBean;

public class GestorAreas {

	public GestorAreas() {
		super();
	}
	
	public ListaObjetoBean consultaAreas() {
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean cBean = new CreadorBean();
		Area area = (Area) cBean.crear(1);
		ListaObjetoBean l = bdf.consultar(area);
		return l;
	}

}
