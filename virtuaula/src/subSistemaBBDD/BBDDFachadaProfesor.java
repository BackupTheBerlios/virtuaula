package subSistemaBBDD;

import subSistemaBBDD.esquemaBBDD.CreadorEsquemaBBDD;
import subSistemaBBDD.esquemaBBDD.EsquemaBBDD;
import subSistemaBBDD.listaObjeto.ListaObjetoBBDD;
import subSistemaBBDD.objetoBaseDatos.CreadorObjetoBBDD;
import subSistemaBBDD.objetoBaseDatos.ObjetoBBDD;
import subSistemaBBDD.objetoCriterio.CreadorObjetoCriterio;
import subSistemaBBDD.objetoCriterio.ObjetoCriterio;
import subSistemaBBDD.utils.Constantes;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * Fachada especializada para operaciones con la tabla profesor o
 * con las tablas que la relacionan con otras.
 * 
 * @author JORGE SANCHEZ
 *
 */
public class BBDDFachadaProfesor extends BBDDFachada{
	/**
	 * Creador protegido de la clase, solo lo utilizará su clase padre para crear una instancia de esta clase.
	 *
	 */
	protected BBDDFachadaProfesor(){
		
	}
	/**
	 * Dado un curso devuelve el profesor que imparte este curso.
	 * @param curso del cual queremos saber su profesor asociado.
	 * @return el profesor asociado al curso.
	 */
	public ObjetoBean dameProfesorCurso(ObjetoBean curso){
		CreadorBean creadorBean = new CreadorBean();
		ObjetoBean profesor= creadorBean.crear(creadorBean.Profesor);
		profesor.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI,curso.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI));
		ListaObjetoBean profesoresCurso=this.consultar(profesor);
		ObjetoBean profesorCurso = profesoresCurso.dameObjeto(0);
		System.out.println("salen "+ profesoresCurso.tamanio());
		return profesorCurso;
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
	 * Sirve para obtener todas las profesores que están libres en un
	 * horario dado es decir que no tengan cursos en ese horario.
	 * @param horario el horario que fija los profesores que estoy buscando
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
				ListaObjetoBean horariosOcupadoProfesorActual= 
					((BBDDFachadaHorario)super.dameBBDDFachada(Constantes.FachadaHorario)).dameHorariosOcupadosProfesor(profesorActual);
				boolean libreProf=true;
				for(int j=0;j<horariosOcupadoProfesorActual.tamanio()&& libreProf;j++){
					ObjetoBean horarioActual = horariosOcupadoProfesorActual.dameObjeto(j);
					libreProf= ((BBDDFachadaHorario)(super.dameBBDDFachada(Constantes.FachadaHorario))).horariosCompatibles(horario,horarioActual);
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
		ListaObjetoBean horariosOcupadoProfesor= ((BBDDFachadaHorario)(super.dameBBDDFachada(Constantes.FachadaHorario))).dameHorariosOcupadosProfesor(profesor);
		boolean libre= true;
		for(int i=0;i<horariosOcupadoProfesor.tamanio() && libre;i++){
			ObjetoBean horario2= horariosOcupadoProfesor.dameObjeto(i);
			if (!((BBDDFachadaHorario)(super.dameBBDDFachada(Constantes.FachadaHorario))).horariosCompatibles(horario,horario2))
				libre=false;
		}
		return libre;
		
		
	}
	
	/**
	 * Este método devuelve todos los profesores que imparten cursos de un area que se 
	 * pasa como parámetro.
	 * @param area el area que guia la busqueda de profesores
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
