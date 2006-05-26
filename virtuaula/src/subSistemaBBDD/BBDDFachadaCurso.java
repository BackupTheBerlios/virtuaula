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
 * Fachada especializada para operaciones con la tabla curso
 * de la base de datos.
 * @author JORGE SANCHEZ
 *
 */
public class BBDDFachadaCurso extends BBDDFachada{
	protected BBDDFachadaCurso(){
		
	}
	




	
	
	
	
	/**
	 * Consulta sobre cursos que cumplan que se dan en el aula
	 * pasada como parámetro en el horario dado y que cumplan 
	 * los criterios del curso pasado como parámetro.
	 * 
	 * @param curso
	 * @param aula
	 * @param horario
	 * @return una lista de cursos que cumplen los criterios deseados.
	 */
	public ListaObjetoBean dameCursosCumplan(ObjetoBean curso,ObjetoBean aula,ObjetoBean horario ){
		try{
			//primera hacemos una consulta para ver los cursos que cumplen los criterios del bean curso
			ObjetoBBDD iscurso= ConversorBeanBBDD.convierteBeanABBDD(curso);
			ObjetoCriterio critCurso = this.crearObjetoCriterioAdecuado(iscurso);		
			ListaObjetoBBDD cursosCumplenCurso= this.inicializaTabla(this.crearTablaAdecuada(iscurso)).consultar(critCurso);
			ListaObjetoBBDD cursosResultado= this.creador.getCreadorListaObjetoBBDD().crear();
			ObjetoBBDD cursoActual;
			ObjetoBBDD horCursoAula;
			ObjetoCriterio critHorAulaCurso;
			ListaObjetoBBDD cursosHorAula;
			//	Para cada curso que cumple los criterios establecidos por el bean curso pasado como parámtero, vemos si tambien cumplen
			//	los criterios de aula y horario y si es asi lo incluimos a la lista de cursos que cumplen todos los requisitos.
			for(int i=0;i<cursosCumplenCurso.tamanio();i++){
				cursoActual = cursosCumplenCurso.dameObjeto(i);
				horCursoAula= this.creador.getCreadorObjetoBBDD().crear(this.creador.getCreadorObjetoBBDD().IshorarioHasIsaula);
				horCursoAula.cambiaValor(Constantes.ID_HAS_ISCURSO_IDISCURSO,cursoActual.dameValor(Constantes.ID_ISCURSO_IDISCURSO));
				
				if(aula!=null){
					String idAula=aula.dameValor(Constantes.ID_ISAULA);
					if(idAula!=null)
						horCursoAula.cambiaValor(Constantes.ID_HAS_ISAULA_IDISAULA,idAula);
					else
						horCursoAula.cambiaValor(Constantes.ID_HAS_ISAULA_IDISAULA,"");
				}
				else
					horCursoAula.cambiaValor(Constantes.ID_HAS_ISAULA_IDISAULA,"");
				if(horario!=null){
					String idHorario= horario.dameValor(Constantes.ID_ISHORARIO);
					if (idHorario!=null)
						horCursoAula.cambiaValor(Constantes.ID_HAS_ISHORARIO_IDISHORARIO,idHorario);
					else
						horCursoAula.cambiaValor(Constantes.ID_HAS_ISHORARIO_IDISHORARIO,"");
				}
				else
					horCursoAula.cambiaValor(Constantes.ID_HAS_ISHORARIO_IDISHORARIO,"");	
							
				critHorAulaCurso = this.crearObjetoCriterioAdecuado(horCursoAula);
				cursosHorAula= this.inicializaTabla(this.crearTablaAdecuada(horCursoAula)).consultar(critHorAulaCurso);
				if(!cursosHorAula.esVacio())
						cursosResultado.insertar(cursosResultado.tamanio(),cursoActual);
				
						
			}
		
			return ConversorBeanBBDD.convierteListaBBDD(cursosResultado);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	
	/**
	 * Devuelve todos los cursos activos de la academia.
	 * @return los cursos activos de la academia
	 */
	public ListaObjetoBean dameCursosActivos(){
		CreadorBean creadorBean = new CreadorBean();
		ObjetoBean curso = creadorBean.crear(creadorBean.Curso);
		curso.cambiaValor(Constantes.CURSO_ESTADO, "Activo");
		return this.consultar(curso);
	}
	
	
	/**
	 * Nos sirve para saber si el curso que pasamos como parámetro está ya en el sistema
	 * @return true si el curso ya existe, false en caso contrario
	 * @param curso, el curso del cual queremos saber si existe o no en el sistema.
	 */
	public boolean cursoYaExiste(ObjetoBean curso){
		try{
			ObjetoBBDD isCurso = ConversorBeanBBDD.convierteBeanABBDD(curso);
			EsquemaBBDD tablaCursos = this.crearTablaAdecuada(isCurso);
			CreadorObjetoCriterio creadorCriterio= this.creador.getCreadorObjetoCriterio();
			ObjetoCriterio criterioCurso = creadorCriterio.crear(creadorCriterio.ObjetoCriterioIscurso);
			criterioCurso.convertir(isCurso);
			return (this.inicializaTabla(tablaCursos).consultar(criterioCurso).tamanio() !=0);
			
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}		
	}
	
	
	
	
	/**
	 * No sirve para hallar los cursos que imparte el profesor pasado como parámetro y que tienen estado activo.
	 * @param profesor, el profesor en cuestion.
	 * @return una lista de todos los cursos activos que imparte profesor.
	 */
	public ListaObjetoBean dameCursosActivos(ObjetoBean profesor){
		CreadorObjetoBBDD creadorObjetoBBDD= this.creador.getCreadorObjetoBBDD();			
		ObjetoBBDD curso = creadorObjetoBBDD.crear(creadorObjetoBBDD.Iscurso);
		curso.cambiaValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI, profesor.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI));
		curso.cambiaValor(Constantes.CURSO_ESTADO,"activo");
		ObjetoCriterio critCurso = this.creador.getCreadorObjetoCriterio().crear(this.creador.getCreadorObjetoCriterio().ObjetoCriterioIscurso);
		critCurso.convertir(curso);
		CreadorEsquemaBBDD creadorTablas = this.creador.getCreadorEsquema();
		EsquemaBBDD tablaCurso= creadorTablas.crear(creadorTablas.EsqIscurso);
		ListaObjetoBean cursosActivosProfesor = ConversorBeanBBDD.convierteListaBBDD(this.inicializaTabla(tablaCurso).consultar(critCurso));
		return cursosActivosProfesor;
	}
	
	
	/**
	 * Metodo que se utiliza cuando un profesor quiere publicar las notas del curso que se pasa como parámetro
	 * @param curso, el curso del cual se quieren publicar las notas
	 * @return, true si la publicación tiene exito, false e.o.c
	 */
	
	
	//saco los alumnos del curso en cuestion, saco de la ficha de cada alumno su nota, pongo esa nota en la tabla 
	//cursoAlumno en notaFinal con codCurso y codAlumno.
	public boolean publicarNota(ObjetoBean curso){
		
		//hallo todas las filas de iscurso_has_isalumno cuyo codCurso coincida con el de curso
		CreadorObjetoBBDD creadorObjetoBBDD= this.creador.getCreadorObjetoBBDD();			
		ObjetoBBDD cursoAlumno = creadorObjetoBBDD.crear(creadorObjetoBBDD.IscursoHasIsalumno);
		//hallo todas las filas de iscurso_has_isalumno que tengan CodCurso igual que curso
		cursoAlumno.cambiaValor(Constantes.ID_HAS_ISCURSO_IDISCURSO, curso.dameValor(Constantes.ID_ISCURSO_IDISCURSO));
		ObjetoCriterio critCursoAlumno = this.creador.getCreadorObjetoCriterio().crear(this.creador.getCreadorObjetoCriterio().ObjetoCriterioIscursoHasIsalumno);
		critCursoAlumno.convertir(cursoAlumno);
		CreadorEsquemaBBDD creadorTablas = this.creador.getCreadorEsquema();
		EsquemaBBDD tablaCursoAlumno= creadorTablas.crear(creadorTablas.EsqIscursoHasIsalumno);
		ListaObjetoBean cursoAlumnoFicha = ConversorBeanBBDD.convierteListaBBDD(this.inicializaTabla(tablaCursoAlumno).consultar(critCursoAlumno));
		//para cada fila busco la ficha con codFicha el que aparece en cursoAlumnoFicha,
		//saco la nota_ejercicios y meto su valor en el campo nota_final de cursoAlumnoFicha, luego hago una edición.
		boolean exito=true;
		for (int i=0;i<cursoAlumnoFicha.tamanio();i++){
			ObjetoBBDD ficha = creadorObjetoBBDD.crear(creadorObjetoBBDD.IsFicha);
			ficha.cambiaValor(Constantes.ID_ISFICHA,cursoAlumnoFicha.dameObjeto(i).dameValor(Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA));
			ObjetoCriterio critFicha = this.creador.getCreadorObjetoCriterio().crear(this.creador.getCreadorObjetoCriterio().ObjetoCriterioIsuficha);
			critFicha.convertir(ficha);
			EsquemaBBDD tablaFicha= creadorTablas.crear(creadorTablas.EsqIsficha);
			ListaObjetoBean fichaCurso = ConversorBeanBBDD.convierteListaBBDD(this.inicializaTabla(tablaFicha).consultar(critFicha));
			//solo habrá una ficha en fichaCurso puesto que el criterio de busqueda era la clave de la tabla isficha
			ObjetoBean fichaBean = fichaCurso.dameObjeto(0);
			System.out.println("el valor del campo notasejercicios es "+ fichaBean.dameValor(Constantes.FICHA_NOTAS_EJERCICIOS));
			if(!fichaBean.dameValor(Constantes.FICHA_NOTAS_EJERCICIOS).equals(null)){
				float nota_ejercicios= Float.parseFloat(fichaBean.dameValor(Constantes.FICHA_NOTAS_EJERCICIOS));
				cursoAlumnoFicha.dameObjeto(i).cambiaValor(Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL,Float.toString(nota_ejercicios));
				if(exito)
					exito=this.editar(cursoAlumnoFicha.dameObjeto(i));
			}
			else{
				cursoAlumnoFicha.dameObjeto(i).cambiaValor(Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL,"-1");
				if(exito)
					exito=this.editar(cursoAlumnoFicha.dameObjeto(i));
			}
			
			
			
			
		}
		//Si se han publicado con exito las notas de este curso borramos las fichas correspondientes al curso
		//y tambien liberamos el horario y el aula en el que se impartía el curso.
		if(exito){
			exito=((BBDDFachadaFicha)super.dameBBDDFachada(Constantes.FachadaFicha)).borrarFichasCurso(curso);
			exito= this.liberarHorarioAulaDeCurso(curso);
		}
			 
		
			
		return exito;
	}
	

	/**
	 * Libera el horario y el aula asociados al curso que se pasa como parametro
	 * @param curso
	 * @return
	 */
	public boolean liberarHorarioAulaDeCurso(ObjetoBean curso){
		CreadorBean creadorBean = new CreadorBean();
		ObjetoBean horarioAula= creadorBean.crear(creadorBean.HorarioHasAula);
		horarioAula.cambiaValor(Constantes.ISHORARIO_HAS_ISAULA_ISCURSO_IDISCURSO,curso.dameValor(Constantes.ID_ISCURSO_IDISCURSO));
		ListaObjetoBean horariosAula=this.consultar(horarioAula);
		ObjetoBean horarioCurso = horariosAula.dameObjeto(0);
		return this.eliminar(horarioCurso);
	}
	/**
	 * Devuelve el numero de plazas libres de un curso.
	 * @param curso, el curso a consultar
	 * @return Numero de plazas libres del curso si este existe, -1 en otro caso
	 */
	public int numPlazasEnCurso (ObjetoBean curso){
		try{
			ObjetoBBDD entidadBBDD= ConversorBeanBBDD.convierteBeanABBDD(curso);
			EsquemaBBDD tablaAdecuada= this.crearTablaAdecuada(entidadBBDD);
			ObjetoCriterio entidadCriterio= this.crearObjetoCriterioAdecuado(entidadBBDD);
			ListaObjetoBBDD resultConsulta =(ListaObjetoBBDD) this.inicializaTabla(tablaAdecuada).consultar(entidadCriterio);
			if (resultConsulta.tamanio()==1)
				return Integer.parseInt(resultConsulta.dameObjeto(0).dameValor(Constantes.CURSO_NUMERO_PLAZAS));
			else
				return -1;
			
		}
		catch (Exception e){
			e.printStackTrace();
			return -1;
		}
		
	}
	
	/**
	 * Genera y devuelve el expediente de un curso que se compone de los alumnos
	 * de este curso y de sus notas finales correspondientes.
	 * @param curso, del cual queremos hallar su expediente
	 * @return el expediente del curso deseado.
	 */
	public ListaObjetoBean creaExpediente (ObjetoBean curso){
		try{
		    ObjetoBBDD cursoAlumno= this.creador.getCreadorObjetoBBDD().crear(this.creador.getCreadorObjetoBBDD().IscursoHasIsalumno);
		    cursoAlumno.cambiaValor(Constantes.ID_HAS_ISCURSO_IDISCURSO,curso.dameValor(Constantes.ID_ISCURSO_IDISCURSO));
		    ObjetoCriterio critCurAlumno= this.crearObjetoCriterioAdecuado(cursoAlumno);
		    ListaObjetoBBDD cursosAlumnosFichaNota = this.inicializaTabla(this.crearTablaAdecuada(cursoAlumno)).consultar(critCurAlumno);
		    CreadorListaObjetoBean creadorLB= new CreadorListaObjetoBean();
		    ListaObjetoBean expedientesAlumnos= creadorLB.crear();
		    //Para cada elemento de cursosAlumnosFichaNota hacemos una consulta en la tabla isalumno y cogemos el alumno resultado
			//creamos un objetoBean expedienteAlumno y lo rellenamos con todos los datos del alumno en cuestion y con el campo
		    //nota final que sacamos del cursoAlumnoFichaNota actual
		    ObjetoBBDD alumno= this.creador.getCreadorObjetoBBDD().crear(this.creador.getCreadorObjetoBBDD().Isalumno);
			ObjetoCriterio critAlumno;
			ObjetoBBDD cursoAlumnoFichaNotaActual;
			ObjetoBBDD alumnoActual;
			
			EsquemaBBDD tablaAlumno= this.inicializaTabla(this.crearTablaAdecuada(alumno));
			for(int i=0;i<cursosAlumnosFichaNota.tamanio();i++){
				ObjetoBean expedienteActual=this.creador.getCreadorBean().crear(this.creador.getCreadorBean().ExpedienteAlumno);
				cursoAlumnoFichaNotaActual= cursosAlumnosFichaNota.dameObjeto(i);
				alumno.cambiaValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI,cursoAlumnoFichaNotaActual.dameValor(Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI));
				critAlumno= this.crearObjetoCriterioAdecuado(alumno);
				alumnoActual = tablaAlumno.consultar(critAlumno).dameObjeto(0);
						
				expedienteActual.cambiaValor(Constantes.ID_EXPEDIENTEALUMNO_ISUSUARIO_DNI,alumnoActual.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTEALUMNO_APELLIDO1,alumnoActual.dameValor(Constantes.ALUMNO_APELLIDO1));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTEALUMNO_APELLIDO2,alumnoActual.dameValor(Constantes.ALUMNO_APELLIDO2));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTEALUMNO_DIRECCION,alumnoActual.dameValor(Constantes.ALUMNO_DIRECCION));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTEALUMNO_EMAIL,alumnoActual.dameValor(Constantes.ALUMNO_EMAIL));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTEALUMNO_FECH_NACIMIENTO,alumnoActual.dameValor(Constantes.ALUMNO_FECH_NACIMIENTO));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTEALUMNO_NOMBRE,alumnoActual.dameValor(Constantes.ALUMNO_NOMBRE));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTEALUMNO_NOTAFINAL,cursoAlumnoFichaNotaActual.dameValor(Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTEALUMNO_SEXO,alumnoActual.dameValor(Constantes.ALUMNO_SEXO));
				expedienteActual.cambiaValor(Constantes.EXPEDIENTEALUMNO_TELEFONO,alumnoActual.dameValor(Constantes.ALUMNO_TELEFONO));
				expedientesAlumnos.insertar(expedientesAlumnos.tamanio(),expedienteActual);
			}
			return expedientesAlumnos;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Devuelve una lista de beans con todos los cursos que imparte el profesor pasado como parámetro
	 * @param profesor, profesor del cual queremos consultar sus cursos.
	 * @return una lista de todos los cursos del profesor consultado.
	 */
	public ListaObjetoBean dameCursosProfesor(ObjetoBean profesor){
		try{
		ObjetoBBDD profesorBBDD= ConversorBeanBBDD.convierteBeanABBDD(profesor);
		CreadorObjetoBBDD creadorCurso = this.creador.getCreadorObjetoBBDD();
		ObjetoBBDD curso= creadorCurso.crear(creadorCurso.Iscurso);
		curso.cambiaValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI,profesorBBDD.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI));
		ObjetoCriterio criterioCurso = this.crearObjetoCriterioAdecuado(curso);
		EsquemaBBDD tablaAdecuada= this.crearTablaAdecuada(curso);
		ListaObjetoBBDD resultConsulta =(ListaObjetoBBDD) this.inicializaTabla(tablaAdecuada).consultar(criterioCurso);
		return ConversorBeanBBDD.convierteListaBBDD(resultConsulta);
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	
}
