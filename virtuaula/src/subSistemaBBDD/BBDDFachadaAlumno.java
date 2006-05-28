package subSistemaBBDD;

import subSistemaBBDD.esquemaBBDD.CreadorEsquemaBBDD;
import subSistemaBBDD.esquemaBBDD.EsquemaBBDD;
import subSistemaBBDD.listaObjeto.ListaObjetoBBDD;
import subSistemaBBDD.objetoBaseDatos.CreadorObjetoBBDD;
import subSistemaBBDD.objetoBaseDatos.ObjetoBBDD;

import subSistemaBBDD.objetoCriterio.ObjetoCriterio;
import subSistemaBBDD.utils.Constantes;
import beans.*;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * Fachada especializada para operaciones con la tabla alumno
 * de la base de datos.
 *  @author JORGE SANCHEZ
 *
 */
public class BBDDFachadaAlumno extends BBDDFachada {
	
	
	
	protected BBDDFachadaAlumno(){
		
	}
	
	/*public static BBDDFachadaAlumno getInstance() {
		if ( ejemplar == null ) {
			ejemplar = new BBDDFachadaAlumno();
	
		}
		return ejemplar;
	}*/
	
	/**
	 * Crea y devuelve el expediente de un alumno que consiste en todos sus cursos matriculados
	 * y en la nota final que ha sacado en cada uno de ellos.
	 * @param alumno
	 * @return
	 */
	public ListaObjetoBean creaExpedienteAlumno(ObjetoBean alumno){
	    try{
	    	ObjetoBBDD cursoAlumno= this.creador.getCreadorObjetoBBDD().crear(this.creador.getCreadorObjetoBBDD().IscursoHasIsalumno);
	        cursoAlumno.cambiaValor(Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI,alumno.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
	        ObjetoCriterio critCurAlumno= this.crearObjetoCriterioAdecuado(cursoAlumno);
	        ListaObjetoBBDD cursosAlumnosFichaNota = this.inicializaTabla(this.crearTablaAdecuada(cursoAlumno)).consultar(critCurAlumno);
	        CreadorListaObjetoBean creadorLB= new CreadorListaObjetoBean();
	        ListaObjetoBean expedientesCursos= creadorLB.crear();
	        //Para cada elemento de cursosAlumnosFichaNota hacemos una consulta en la tabla isalumno y cogemos el alumno resultado
	        //creamos un objetoBean expedienteAlumno y lo rellenamos con todos los datos del alumno en cuestion y con el campo
	        //nota final que sacamos del cursoAlumnoFichaNota actual
	        ObjetoBBDD curso= this.creador.getCreadorObjetoBBDD().crear(this.creador.getCreadorObjetoBBDD().Iscurso);
	        ObjetoCriterio critCurso;
	        ObjetoBBDD cursoAlumnoFichaNotaActual;
	        ObjetoBBDD cursoActual;
		
		
	        EsquemaBBDD tablaCurso= this.inicializaTabla(this.crearTablaAdecuada(curso));
	        for(int i=0;i<cursosAlumnosFichaNota.tamanio();i++){
	        	ObjetoBean expedienteActual=this.creador.getCreadorBean().crear(this.creador.getCreadorBean().ExpedienteCurso);
	        	cursoAlumnoFichaNotaActual= cursosAlumnosFichaNota.dameObjeto(i);
	        	curso.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO,cursoAlumnoFichaNotaActual.dameValor(Constantes.ID_HAS_ISCURSO_IDISCURSO));
	        	critCurso= this.crearObjetoCriterioAdecuado(curso);
	        	cursoActual = tablaCurso.consultar(critCurso).dameObjeto(0);
					
	        	expedienteActual.cambiaValor(Constantes.ID_EXPEDIENTECURSO_IDISCURSO,cursoActual.dameValor(Constantes.ID_ISCURSO_IDISCURSO));
	        	expedienteActual.cambiaValor(Constantes.EXPEDIENTECURSO_ESTADO,cursoActual.dameValor(Constantes.CURSO_ESTADO));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTECURSO_FECHA_FIN,cursoActual.dameValor(Constantes.CURSO_FECHA_FIN));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTECURSO_FECHA_INICIO,cursoActual.dameValor(Constantes.CURSO_FECHA_INICIO));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTECURSO_ISAREA_IDISAREA,cursoActual.dameValor(Constantes.CURSO_ISAREA_IDISAREA));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTECURSO_ISPROFESOR_ISUSUARIO_DNI,cursoActual.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTECURSO_NOMBRE,cursoActual.dameValor(Constantes.CURSO_NOMBRE));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTECURSO_NOTAFINAL,cursoAlumnoFichaNotaActual.dameValor(Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTECURSO_NUMERO_PLAZAS,cursoActual.dameValor(Constantes.CURSO_NUMERO_PLAZAS));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTECURSO_PRECIO,cursoActual.dameValor(Constantes.CURSO_PRECIO));
				expedientesCursos.insertar(expedientesCursos.tamanio(),expedienteActual);
			}
			return expedientesCursos;
		}
		
	    catch(Exception e){
	    	e.printStackTrace();
	    	return null;
	    }
	}
	
	/**
	 * Dado un curso te devuelve los alumnos que están matriculados en él.
	 * @param curso, curso en cuestión.
	 * @return lista de alumnos matriculados en el curso.
	 */
	
	//busco en la tabla que relaciona cursos y alumnos
	public ListaObjetoBean dameAlumnosCurso(ObjetoBean curso){
		CreadorObjetoBBDD creadorObjetoBBDD= this.creador.getCreadorObjetoBBDD();			
		ObjetoBBDD cursoAlumno = creadorObjetoBBDD.crear(creadorObjetoBBDD.IscursoHasIsalumno);
		cursoAlumno.cambiaValor(Constantes.ID_HAS_ISCURSO_IDISCURSO, curso.dameValor(Constantes.ID_ISCURSO_IDISCURSO));
		ObjetoCriterio critCursoAlumno = this.crearObjetoCriterioAdecuado(cursoAlumno);
		
		CreadorEsquemaBBDD creadorTablas = this.creador.getCreadorEsquema();
		EsquemaBBDD tablaCursoAlumno= creadorTablas.crear(creadorTablas.EsqIscursoHasIsalumno);
		//Obtengo una lista de beans de tipo CursoHasAlumno que me relacionan los id de los alumno que están matriculados en el curso dado.
		ListaObjetoBean alumnosCurso = ConversorBeanBBDD.convierteListaBBDD(this.inicializaTabla(tablaCursoAlumno).consultar(critCursoAlumno));
		//Por cada elemento de alumnosCurso hago una consulta en la tabla isalumno guiada por el idAlumno de alumnosCurso
		ListaObjetoBean resultado= new ListaObjetoBean();
		for (int i=0; i<alumnosCurso.tamanio();i++){
			ObjetoBBDD alumno = creadorObjetoBBDD.crear(creadorObjetoBBDD.Isalumno);
			alumno.cambiaValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI,alumnosCurso.dameObjeto(i).dameValor(Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI));
			ObjetoCriterio critAlumno = this.creador.getCreadorObjetoCriterio().crear(this.creador.getCreadorObjetoCriterio().ObjetoCriterioIsalumno); 
			critAlumno.convertir(alumno);
			EsquemaBBDD tablaAlumno = creadorTablas.crear(creadorTablas.EsqIsalumno);
			ListaObjetoBean alumnoResult = ConversorBeanBBDD.convierteListaBBDD(this.inicializaTabla(tablaAlumno).consultar(critAlumno));
			resultado.insertar(resultado.tamanio(),alumnoResult.dameObjeto(0));		
		}
		return resultado;
	}
	
	/**
	 * Dado un curso y un alumno, devuelve una lista de alumnos que cumplen los criterios establecidos por
	 * estos parámetros.
	 * @param curso
	 * @param alumno
	 * @return
	 */
	public ListaObjetoBean dameAlumnosCumplan(ObjetoBean curso,ObjetoBean alumno){
		
		
		ListaObjetoBBDD alumnosResultado= this.creador.getCreadorListaObjetoBBDD().crear();
		
		
		
		if(curso!=null && alumno!=null){
			ListaObjetoBean alumnosCumplenAlumno= this.consultar(alumno);
			ListaObjetoBean alumnosCumplenCurso=this.dameAlumnosCurso(curso);
			for(int i=0;i<alumnosCumplenAlumno.tamanio();i++){
				ObjetoBean alumnoAlumnoActual= alumnosCumplenAlumno.dameObjeto(i);
				for(int j=0;j<alumnosCumplenCurso.tamanio();j++){
					if(alumnosCumplenCurso.dameObjeto(j).dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI)
								.equals(alumnoAlumnoActual.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI))){
						try{
							alumnosResultado.insertar(alumnosResultado.tamanio(),ConversorBeanBBDD.convierteBeanABBDD(alumnoAlumnoActual));
						}
						catch(Exception e){
							e.printStackTrace();
							return null;
						}	
					}
					
				}
			}
			return ConversorBeanBBDD.convierteListaBBDD(alumnosResultado);
		}
		else if(alumno!=null){
			ListaObjetoBean alumnosCumplenAlumno= this.consultar(alumno);
			return alumnosCumplenAlumno;
		}
		else if(curso!=null){
			ListaObjetoBean alumnosCumplenCurso=this.dameAlumnosCurso(curso);
			return alumnosCumplenCurso;
		}
		else{
			ObjetoBean alumnovacio= this.creador.getCreadorBean().crear(this.creador.getCreadorBean().Alumno);
			return this.consultar(alumnovacio);
		}
		
		
		
		
	}
	
	/*public static void main(String[] args){
		BBDDFachadaAlumno mia= new BBDDFachadaAlumno();
		ObjetoBean curso= mia.creador.getCreadorBean().crear(mia.creador.getCreadorBean().Curso);
		ObjetoBean alumno= mia.creador.getCreadorBean().crear(mia.creador.getCreadorBean().Alumno);
		curso.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO,"9");
		//alumno.cambiaValor()
		//curso.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO,"2");
		System.out.println(mia.dameAlumnosCumplan(null,null).tamanio());
	}*/
	
}
