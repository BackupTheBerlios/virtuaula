package gestores;

import subSistemaBBDD.BBDDFachada;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

public class GestorAvisos {

	public GestorAvisos() {
		super();
	}

	public ListaObjetoBean consultaAvisos(ObjetoBean beanUsuario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.dameAvisosUsuario(beanUsuario);
		return l;
	}
	
	public boolean borraAviso(ObjetoBean beanAviso){
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.eliminar(beanAviso);
	}
}
