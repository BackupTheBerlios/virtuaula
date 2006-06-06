package gestores;

import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.BBDDFachadaAula;
import subSistemaBBDD.utils.Constantes;
import beans.Aula;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

/**
 * Se encarga de realizar las operaciones sobre las Aulas
 * 
 * @author AL
 * 
 */
public class GestorAulas {

	public GestorAulas() {
		super();
	}

	/**
	 * 
	 * @return Me devulve una lista con todas las aulas existentes
	 */
	public ListaObjetoBean consultaAulas() {
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean cBean = new CreadorBean();
		Aula aula = (Aula) cBean.crear(2);
		ListaObjetoBean l = bdf.consultar(aula);
		return l;
	}

	/**
	 * 
	 * @param beanHorario
	 * @return me devuelve las aulas que estan libres en el horario que le
	 *         pasamos
	 */
	public ListaObjetoBean consultaAulasPorHorario(ObjetoBean beanHorario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaAula bdfa = (BBDDFachadaAula) (bdf
				.dameBBDDFachada(Constantes.FachadaAula));
		ListaObjetoBean l = bdfa.dameAulasLibres(beanHorario);
		return l;
	}
}
