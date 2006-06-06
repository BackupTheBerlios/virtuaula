package subSistemaBBDD;

import subSistemaBBDD.esquemaBBDD.CreadorEsquemaBBDD;
import subSistemaBBDD.esquemaBBDD.EsquemaBBDD;
import subSistemaBBDD.listaObjeto.ListaObjetoBBDD;
import subSistemaBBDD.objetoCriterio.CreadorObjetoCriterio;
import subSistemaBBDD.objetoCriterio.ObjetoCriterio;
import subSistemaBBDD.utils.Constantes;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * Fachada especializada para operaciones con la tabla area
 * de la base de datos.
 * @author JORGE SANCHEZ
 *
 */
public class BBDDFachadaArea extends BBDDFachada{

	
	/**
	 * Creador protegido de la clase, solo lo utilizará su clase padre para crear una instancia de esta clase.
	 *
	 */
	
	protected BBDDFachadaArea(){
		
	}
	
	/**
	 * 
	 * @param curso  curso del cual se quiere hallar su area asociada.
	 * @return un ObjetoBean area asociado al curso.
	 */
	
	public ObjetoBean dameAreaCurso(ObjetoBean curso){
		CreadorBean creadorBean = new CreadorBean();
		ObjetoBean area= creadorBean.crear(creadorBean.Area);
		area.cambiaValor(Constantes.ID_ISAREA,curso.dameValor(Constantes.CURSO_ISAREA_IDISAREA));
		ListaObjetoBean areasCurso=this.consultar(area);
		ObjetoBean areaCurso = areasCurso.dameObjeto(0);
		return areaCurso;
		
	}
	/**
	 * Devuelve una lista de todas las areas existentes en el sistema, 
	 * para por ejemplo a la hora de añadir un curso saber que areas están
	 * abiertas para asociarle una al curso
	 * @return  la lista de areas disponibles.
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
