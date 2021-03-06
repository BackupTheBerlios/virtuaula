package subSistemaBBDD;

import subSistemaBBDD.esquemaBBDD.CreadorEsquemaBBDD;
import subSistemaBBDD.esquemaBBDD.EsquemaBBDD;
import subSistemaBBDD.listaObjeto.CreadorListaObjetoBBDD;
import subSistemaBBDD.listaObjeto.ListaObjetoBBDD;
import subSistemaBBDD.objetoBaseDatos.CreadorObjetoBBDD;
import subSistemaBBDD.objetoBaseDatos.ObjetoBBDD;
import subSistemaBBDD.objetoCriterio.CreadorObjetoCriterio;
import subSistemaBBDD.objetoCriterio.ObjetoCriterio;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.*;
/**
 * Fachada especializada para operaciones con la tabla aula
 * de la base de datos.
 * @author JORGE SANCHEZ
 *
 */
public class BBDDFachadaAula extends BBDDFachada {
	
	/**
	 * Creador protegido de la clase, solo lo utilizar� su clase padre para crear una instancia de esta clase.
	 *
	 */
	protected BBDDFachadaAula(){
		
	}
	
	
	/**
	 * Sirve para obtener todas las aulas que est�n libres en un
	 * horario dado.
	 * @param horario  el horario que fija las aula que estoy buscando
	 * @return una lista de aulas libres en el horario dado.
	 */
	
	
	public ListaObjetoBean dameAulasLibres(ObjetoBean horario){
		try{
			CreadorObjetoBBDD creadorOB= this.creador.getCreadorObjetoBBDD();			
			ObjetoBBDD aula = creadorOB.crear(creadorOB.Isaula);
			ObjetoCriterio critAula= this.crearObjetoCriterioAdecuado(aula); 
			EsquemaBBDD tablaAula= this.crearTablaAdecuada(aula);
			//Obtengo una lista de todas las aula que hay en la academia.
			ListaObjetoBBDD aulasExistentes = this.inicializaTabla(tablaAula).consultar(critAula);
			//Para cada aula obtengo los horario en los cuales est�n ocupadas
			CreadorListaObjetoBBDD creadorListaBBDD = new CreadorListaObjetoBBDD();
			ListaObjetoBBDD aulasLibresHorario= creadorListaBBDD.crear();
			
			
			for (int i=0; i<aulasExistentes.tamanio();i++){
				ObjetoBean aulaActual = ConversorBeanBBDD.convierteBBDDABean(aulasExistentes.dameObjeto(i));
				ListaObjetoBean horariosOcupados= ((BBDDFachadaHorario)(super.dameBBDDFachada(Constantes.FachadaHorario)))
														.dameHorariosOcupadosAula(aulaActual);
				//Para cada uno de los horarios en los cuales el aula est� ocupado, compruebo si alguna de las horas
				//de este horario coincide con el Bean horario que se me ha pasado como par�metro.
				boolean libre=true;
				for(int j=0;j<horariosOcupados.tamanio() && libre;j++){
					ObjetoBean horarioActual = horariosOcupados.dameObjeto(j);
					libre= ((BBDDFachadaHorario)(super.dameBBDDFachada(Constantes.FachadaHorario))).horariosCompatibles(horario,horarioActual);
				}
				if(libre)
					aulasLibresHorario.insertar(aulasLibresHorario.tamanio(),aulasExistentes.dameObjeto(i));
			}
			return ConversorBeanBBDD.convierteListaBBDD(aulasLibresHorario);
		}	
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	/**
	 * Dado un horario y un aula nos sirve para saber si el aula en cuesti�n est� libre para impartir en ella clases en el
	 * horario dado o si por el contrario es horario no es compatible con los que ya tiene.
	 * @param horario
	 * @param aula
	 * @return true si el aula esta libre en ese horario, false e.o.c
	 */
	public boolean libreAula(ObjetoBean horario,ObjetoBean aula){
		ListaObjetoBean horariosOcupadoAula=((BBDDFachadaHorario)(super.dameBBDDFachada(Constantes.FachadaHorario)))
											.dameHorariosOcupadosAula(aula);
		boolean libre= true;
		for(int i=0;i<horariosOcupadoAula.tamanio() && libre;i++){
			ObjetoBean horario2= horariosOcupadoAula.dameObjeto(i);
			if (!((BBDDFachadaHorario)(super.dameBBDDFachada(Constantes.FachadaHorario))).horariosCompatibles(horario,horario2))
				libre=false;
		}
		return libre;
	}
	
	/**
	 * 
	 * @return una lista de todas las aula que existen en el sistema.
	 */
	public ListaObjetoBean dameAulasDisponible(){
		CreadorObjetoCriterio creadorCriterio=this.creador.getCreadorObjetoCriterio();
		ObjetoCriterio criterioAula = creadorCriterio.crear(creadorCriterio.ObjetoCriterioIsaula);
		CreadorEsquemaBBDD creadorAulas = this.creador.getCreadorEsquema();
		EsquemaBBDD tablaAula =creadorAulas.crear(creadorAulas.EsqIsaula);
		ListaObjetoBBDD result= this.inicializaTabla(tablaAula).consultar(criterioAula);
		return ConversorBeanBBDD.convierteListaBBDD(result);
	}
	
	/**
	 * Nos sirve para hallar el aula en el cual se imparte un curso.
	 * @param curso  del cual queremos hallar su aula asociada
	 * @return  el aula asociada al curso
	 */
	public ObjetoBean dameAulaCurso(ObjetoBean curso){
		CreadorBean creadorBean = new CreadorBean();
		ObjetoBean horarioAula= creadorBean.crear(creadorBean.HorarioHasAula);
		horarioAula.cambiaValor(Constantes.ISHORARIO_HAS_ISAULA_ISCURSO_IDISCURSO,curso.dameValor(Constantes.ID_ISCURSO_IDISCURSO));
		ListaObjetoBean horariosAula=this.consultar(horarioAula);
		ObjetoBean areaCurso = horariosAula.dameObjeto(0);
		ObjetoBean aula = creadorBean.crear(creadorBean.Aula);
		aula.cambiaValor(Constantes.ID_ISAULA,areaCurso.dameValor(Constantes.ID_HAS_ISAULA_IDISAULA));
		return this.consultar(aula).dameObjeto(0);
	}
	
}
