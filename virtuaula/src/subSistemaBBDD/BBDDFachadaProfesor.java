package subSistemaBBDD;

import subSistemaBBDD.esquemaBBDD.CreadorEsquemaBBDD;
import subSistemaBBDD.esquemaBBDD.EsquemaBBDD;
import subSistemaBBDD.listaObjeto.ListaObjetoBBDD;
import subSistemaBBDD.objetoBaseDatos.CreadorObjetoBBDD;
import subSistemaBBDD.objetoBaseDatos.ObjetoBBDD;
import subSistemaBBDD.objetoCriterio.CreadorObjetoCriterio;
import subSistemaBBDD.objetoCriterio.ObjetoCriterio;
import subSistemaBBDD.utils.Constantes;
import beans.ObjetoBean;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

public class BBDDFachadaProfesor extends BBDDFachada{
	protected BBDDFachadaProfesor(){
		
	}
	/**
	 * Devuelve una lista de beans con todos los profesores que existen en el sistema
	 * @return la lista de beans mencionada
	 */
	public ListaObjetoBean dameProfesoresDisponibles(){
		CreadorObjetoCriterio creadorCriterio=this.creador.getCreadorObjetoCriterio();
		ObjetoCriterio criterioProfesor = creadorCriterio.crear(creadorCriterio.ObjetoCriterioIsprofesor);
		CreadorEsquemaBBDD creadorProfesor = this.creador.getCreadorEsquema();
		EsquemaBBDD tablaProfesor =creadorProfesor.crear(creadorProfesor.EsqIsprofesor);
		ListaObjetoBBDD result= this.inicializaTabla(tablaProfesor).consultar(criterioProfesor);
		return ConversorBeanBBDD.convierteListaBBDD(result);
	}
	/**
	 * Dado un profesor devuelve una lista con sus horarios.
	 * @param profesor, el profesor del cual queremos consultar sus horarios
	 * @return una lista con los horarios del profesor.
	 */
	public ListaObjetoBean dameHorariosOcupadosProfesor(ObjetoBean profesor){
		
		try{
			ListaObjetoBean cursosProfesorActual = ((BBDDFachadaCurso)(BBDDFachada.dameBBDDFachada(Constantes.FachadaCurso)))
													.dameCursosProfesor(profesor);
			//Para cada curso del profesor actual obtengo el horario en el cual se imparte
			ObjetoBean cursoActual;
			ObjetoBBDD horarioAula;
			ObjetoCriterio critHorarioAula;
			//Aqui tendremos todos los horarios de todos los cursos que da el profesor actual.
			ListaObjetoBBDD horariosOcupadoProfesorActual = this.creador.getCreadorListaObjetoBBDD().crear();
			ObjetoBBDD horarioAulaCurso;
			ObjetoBBDD hor= this.creador.getCreadorObjetoBBDD().crear(this.creador.getCreadorObjetoBBDD().Ishorario);
			ObjetoCriterio critHorario;
			for(int j=0; j<cursosProfesorActual.tamanio();j++){
				cursoActual= cursosProfesorActual.dameObjeto(j);
				horarioAula = this.creador.getCreadorObjetoBBDD().crear(this.creador.getCreadorObjetoBBDD().IshorarioHasIsaula);
				horarioAula.cambiaValor(Constantes.ID_HAS_ISCURSO_IDISCURSO,cursoActual.dameValor(Constantes.ID_ISCURSO_IDISCURSO));
				critHorarioAula = this.crearObjetoCriterioAdecuado(horarioAula);
				horarioAulaCurso= this.inicializaTabla(this.crearTablaAdecuada(horarioAula)).consultar(critHorarioAula).dameObjeto(0);
				hor.cambiaValor(Constantes.ID_ISHORARIO,horarioAulaCurso.dameValor(Constantes.ID_HAS_ISHORARIO_IDISHORARIO));
				critHorario = this.crearObjetoCriterioAdecuado(hor);
				ObjetoBBDD horarioCurso= this.inicializaTabla(this.crearTablaAdecuada(hor)).consultar(critHorario).dameObjeto(0);
				horariosOcupadoProfesorActual.insertar(horariosOcupadoProfesorActual.tamanio(),horarioCurso);					
			}
			return ConversorBeanBBDD.convierteListaBBDD(horariosOcupadoProfesorActual);
		}
		catch( Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Sirve para obtener todas las profesores que están libres en un
	 * horario dado, es decir que no tengan cursos en ese horario.
	 * @param horario, el horario que fija los profesores que estoy buscando
	 * @return una lista de profesores libres en el horario dado.
	 */
	public ListaObjetoBean dameProfesoresLibres(ObjetoBean horario){
		try{
			ListaObjetoBean profesoresDisponibles= this.dameProfesoresDisponibles();
			CreadorListaObjetoBean creadorBean= new CreadorListaObjetoBean();
			ListaObjetoBean profesoresLibres = creadorBean.crear();
			//Para cada profesor obtengo todos los cursos que imparte
			for(int i=0;i<profesoresDisponibles.tamanio();i++){
				ObjetoBean profesorActual=profesoresDisponibles.dameObjeto(i);
				ListaObjetoBean horariosOcupadoProfesorActual= this.dameHorariosOcupadosProfesor(profesorActual);
				boolean libreProf=true;
				for(int j=0;j<horariosOcupadoProfesorActual.tamanio()&& libreProf;j++){
					ObjetoBean horarioActual = horariosOcupadoProfesorActual.dameObjeto(j);
					libreProf= ((BBDDFachadaHorario)(BBDDFachada.dameBBDDFachada(Constantes.FachadaHorario))).horariosCompatibles(horario,horarioActual);
				}
				
				if(libreProf){
					profesoresLibres.insertar(profesoresLibres.tamanio(),profesorActual);
				}
					
			}
			return profesoresLibres;
		}			
		
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Dado un horario y un profesor nos sirve para saber si el profesor en cuestión puede impartir clases en el
	 * horario dado o si por el contrario es horario no es compatible con los que ya tiene.
	 * @param horario
	 * @param profesor
	 * @return true si el profesor esta libre en ese horario, false e.o.c
	 */
	public boolean libreProfesor(ObjetoBean horario,ObjetoBean profesor){
		ListaObjetoBean horariosOcupadoProfesor= this.dameHorariosOcupadosProfesor(profesor);
		boolean libre= true;
		for(int i=0;i<horariosOcupadoProfesor.tamanio() && libre;i++){
			ObjetoBean horario2= horariosOcupadoProfesor.dameObjeto(i);
			if (!((BBDDFachadaHorario)(BBDDFachada.dameBBDDFachada(Constantes.FachadaHorario))).horariosCompatibles(horario,horario2))
				libre=false;
		}
		return libre;
		
		
	}
	
	/**
	 * Este método devuelve todos los profesores que imparten cursos de un area que se 
	 * pasa como parámetro.
	 * @param area, el area que guia la busqueda de profesores
	 * @return una lista de profesores que impartan cursos del area determinada.
	 */
	
	public ListaObjetoBean dameProfesoresDeArea(ObjetoBean area){
		try{
			ObjetoBBDD areaBBDD= ConversorBeanBBDD.convierteBeanABBDD(area);
			CreadorObjetoBBDD creadorProfesor = this.creador.getCreadorObjetoBBDD();
			ObjetoBBDD profesor= creadorProfesor.crear(creadorProfesor.Isprofesor);
			profesor.cambiaValor(Constantes.PROFESOR_ISAREA_IDISAREA,areaBBDD.dameValor(Constantes.ID_ISAREA));
			ObjetoCriterio criterioProfesor = this.crearObjetoCriterioAdecuado(profesor);
			EsquemaBBDD tablaAdecuada= this.crearTablaAdecuada(profesor);
			ListaObjetoBBDD resultConsulta =(ListaObjetoBBDD) this.inicializaTabla(tablaAdecuada).consultar(criterioProfesor);
			return ConversorBeanBBDD.convierteListaBBDD(resultConsulta);
			}
			catch (Exception e){
				e.printStackTrace();
				return null;
			}
		
	}
	
}
