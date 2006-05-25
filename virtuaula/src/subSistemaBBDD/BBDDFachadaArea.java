package subSistemaBBDD;

import subSistemaBBDD.esquemaBBDD.CreadorEsquemaBBDD;
import subSistemaBBDD.esquemaBBDD.EsquemaBBDD;
import subSistemaBBDD.listaObjeto.ListaObjetoBBDD;
import subSistemaBBDD.objetoCriterio.CreadorObjetoCriterio;
import subSistemaBBDD.objetoCriterio.ObjetoCriterio;
import beans.listaObjetoBeans.ListaObjetoBean;

public class BBDDFachadaArea extends BBDDFachada{

	
	
	
	protected BBDDFachadaArea(){
		
	}
	
	
	
	
	/**
	 * Devuelve una lista de todas las areas existentes en el sistema, 
	 * para por ejemplo a la hora de añadir un curso saber que areas están
	 * abiertas para asociarle una al curso
	 * @return, la lista de areas disponibles.
	 */
	public ListaObjetoBean dameAreasDisponible(){
		CreadorObjetoCriterio creadorCriterio=this.creador.getCreadorObjetoCriterio();
		ObjetoCriterio criterioArea = creadorCriterio.crear(creadorCriterio.ObjetoCriterioIsarea);
		CreadorEsquemaBBDD creadorAreas = this.creador.getCreadorEsquema();
		EsquemaBBDD tablaAreas =creadorAreas.crear(creadorAreas.EsqIsarea);
		ListaObjetoBBDD result= this.inicializaTabla(tablaAreas).consultar(criterioArea);
		return ConversorBeanBBDD.convierteListaBBDD(result);
	}
}
