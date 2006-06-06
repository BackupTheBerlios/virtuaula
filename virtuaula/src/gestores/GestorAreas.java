package gestores;

import subSistemaBBDD.BBDDFachada;
import beans.Area;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

/**
 * 
 * @author Alberto Macho
 *
 */
/**
 * Se encarga de las operaciones sobre los contenedores de datos Area
 */
public class GestorAreas {

	public GestorAreas() {
		super();
	}

	/**
	 * 
	 * @return Me devuelve una lista de areas que existen en el sistema
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultaAreas() {
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean cBean = new CreadorBean();
		Area area = (Area) cBean.crear(1);
		ListaObjetoBean l = bdf.consultar(area);
		return l;
	}

	/**
	 * Me devuelve una lista de areas que cumplen las caracteristicas del area
	 * que le paso por parametro
	 * 
	 * @param bean
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultaArea(ObjetoBean bean) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.consultar(bean);
	}

}
