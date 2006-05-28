package subSistemaBBDD;

import subSistemaBBDD.esquemaBBDD.CreadorEsquemaBBDD;
import subSistemaBBDD.esquemaBBDD.EsquemaBBDD;
import subSistemaBBDD.listaObjeto.CreadorListaObjetoBBDD;
import subSistemaBBDD.listaObjeto.ListaObjetoBBDD;
import subSistemaBBDD.objetoBaseDatos.CreadorObjetoBBDD;
import subSistemaBBDD.objetoBaseDatos.ObjetoBBDD;
import subSistemaBBDD.objetoCriterio.CreadorObjetoCriterio;
import subSistemaBBDD.objetoCriterio.ObjetoCriterio;
import subSistemaBBDD.utils.Constantes;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * Fachada especializada para operaciones con la tabla horario o
 * con las tablas que la relacionan con otras.
 * 
 * @author JORGE SANCHEZ
 *
 */
public class BBDDFachadaHorario extends BBDDFachada{
	protected BBDDFachadaHorario(){
		
	} 
	
	/**
	 * Dado un profesor devuelve una lista con sus horarios.
	 * @param profesor, el profesor del cual queremos consultar sus horarios
	 * @return una lista con los horarios del profesor.
	 */
	public ListaObjetoBean dameHorariosOcupadosProfesor(ObjetoBean profesor){
		
		try{
			ListaObjetoBean cursosProfesorActual = ((BBDDFachadaCurso)(super.dameBBDDFachada(Constantes.FachadaCurso)))
													.dameCursosActivos(profesor);
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
	public ObjetoBean dameHorarioCurso(ObjetoBean curso){
		CreadorBean creadorBean = new CreadorBean();
		ObjetoBean horarioAula= creadorBean.crear(creadorBean.HorarioHasAula);
		horarioAula.cambiaValor(Constantes.ISHORARIO_HAS_ISAULA_ISCURSO_IDISCURSO,curso.dameValor(Constantes.ID_ISCURSO_IDISCURSO));
		ListaObjetoBean horariosAula=this.consultar(horarioAula);
		ObjetoBean areaCurso = horariosAula.dameObjeto(0);
		ObjetoBean horario = creadorBean.crear(creadorBean.Horario);
		horario.cambiaValor(Constantes.ID_ISHORARIO,areaCurso.dameValor(Constantes.ID_HAS_ISHORARIO_IDISHORARIO));
		return this.consultar(horario).dameObjeto(0);
	}
	
	/**
	 * Devuelve una lista de beans con todos los horarios fijados en el sistema
	 * @return la lista de beans mencionada
	 */
	public ListaObjetoBean dameHorariosDisponibles(){
		CreadorObjetoCriterio creadorCriterio=this.creador.getCreadorObjetoCriterio();
		ObjetoCriterio criterioHorario = creadorCriterio.crear(creadorCriterio.ObjetoCriterioIshorario);
		CreadorEsquemaBBDD creadorHorario = this.creador.getCreadorEsquema();
		EsquemaBBDD tablaHorario =creadorHorario.crear(creadorHorario.EsqIshorario);
		ListaObjetoBBDD result= this.inicializaTabla(tablaHorario).consultar(criterioHorario);
		return ConversorBeanBBDD.convierteListaBBDD(result);
	}
	
	/**
	 * Sirve para saber si dos horarios son compatibles, es decir si no tienen ninguna hora en comun.
	 * @param horario1
	 * @param horario2
	 * @return
	 */
	public boolean horariosCompatibles(ObjetoBean horario1,ObjetoBean horario2){
		String valor1= horario1.dameValor(Constantes.ID_ISHORARIO);
		String valor2= horario1.dameValor(Constantes.HORARIO_LUNES);
		String valor3= horario1.dameValor(Constantes.HORARIO_MARTES);
		String valor4= horario1.dameValor(Constantes.HORARIO_MIERCOLES);
		String valor5= horario1.dameValor(Constantes.HORARIO_JUEVES);
		String valor6= horario1.dameValor(Constantes.HORARIO_VIERNES);
						
		if( (valor1.equals(horario2.dameValor(Constantes.ID_ISHORARIO)) )
			||	((!(valor2==null)&&!valor2.equals("")&& !(horario2.dameValor("L")==null))&& valor2.equals(horario2.dameValor("L")))
			||  ((!(valor3==null)&& !valor3.equals("") && !(horario2.dameValor("M")==null))&& valor3.equals(horario2.dameValor("M")))
			||  ((!(valor4==null)&&!valor4.equals("")&& !(horario2.dameValor("X")==null))&& valor4.equals(horario2.dameValor("X")))
			||	((!(valor5==null)&&!valor5.equals("")&& !(horario2.dameValor("J")==null))&& valor5.equals(horario2.dameValor("J")))
			||	((!(valor6==null)&&!valor6.equals("")&& !(horario2.dameValor("V")==null))&& valor6.equals(horario2.dameValor("V"))))
		   	return false;
		else
			return true;
	}
	
	public ListaObjetoBean dameHorariosOcupadosAula(ObjetoBean aula){
		
		try{
			CreadorListaObjetoBBDD creadorListaBBDD = new CreadorListaObjetoBBDD();
			ListaObjetoBBDD idHorariosOcupadoAula;
			CreadorObjetoBBDD creadorOB= this.creador.getCreadorObjetoBBDD();
			ObjetoBBDD hor = creadorOB.crear(creadorOB.Ishorario);
			
			ObjetoBBDD horarioAula = creadorOB.crear(creadorOB.IshorarioHasIsaula);
			EsquemaBBDD esHorAula = this.crearTablaAdecuada(horarioAula);
			horarioAula.cambiaValor(Constantes.ID_HAS_ISAULA_IDISAULA,aula
																 .dameValor(Constantes.ID_ISAULA));
			
			ObjetoCriterio critHorAula = this.crearObjetoCriterioAdecuado(horarioAula);
			idHorariosOcupadoAula = this.inicializaTabla(esHorAula).consultar(critHorAula);
			//Obtengo todos los horarios en los cuales el aulasExistentes[i] está ocupada y lo meto en horariosOcupados
			ListaObjetoBBDD horariosOcupados= creadorListaBBDD.crear();
			for(int j=0;j<idHorariosOcupadoAula.tamanio();j++){
				hor.cambiaValor(Constantes.ID_ISHORARIO,idHorariosOcupadoAula.dameObjeto(j).dameValor(Constantes.ID_HAS_ISHORARIO_IDISHORARIO));
				ObjetoCriterio critHor = this.crearObjetoCriterioAdecuado(hor);
				horariosOcupados.insertar(horariosOcupados.tamanio(),this.inicializaTabla(this.crearTablaAdecuada(hor)).consultar(critHor).dameObjeto(0));
			}
			return ConversorBeanBBDD.convierteListaBBDD(horariosOcupados);
		}
		catch( Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Nos dice si algun curso utiliza el horario pasado como parámetro
	 * @param horario
	 * @return
	 */
	public boolean horarioUtilizado(ObjetoBean horario){
		boolean utilizada;
		if(horario==null){
			utilizada=true;
		}
		else{
			CreadorObjetoBBDD creadorOB= this.creador.getCreadorObjetoBBDD();
			ObjetoBBDD horarioAula = creadorOB.crear(creadorOB.IshorarioHasIsaula);
			EsquemaBBDD esHorAula = this.crearTablaAdecuada(horarioAula);
			horarioAula.cambiaValor(Constantes.ID_HAS_ISCURSO_IDISCURSO,horario
																 .dameValor(Constantes.ID_ISHORARIO));
			ListaObjetoBBDD listaCursoHorario = this.creador.getCreadorListaObjetoBBDD().crear();
			ObjetoCriterio critHorAula = this.crearObjetoCriterioAdecuado(horarioAula);
			listaCursoHorario= this.inicializaTabla(esHorAula).consultar(critHorAula);
			if(listaCursoHorario.esVacio())
				utilizada=false;
			else{
				utilizada=true;
			}
		}
		return utilizada;
	
	
	}
	
	/*public static void main(String[] args){
		BBDDFachadaHorario mia= new BBDDFachadaHorario();
		ObjetoBean horario= mia.creador.getCreadorBean().crear(mia.creador.getCreadorBean().Horario);
		horario.cambiaValor(Constantes.ID_ISHORARIO,"1");
		System.out.println(mia.horarioUtilizado(horario));
		
	}*/
	
}
