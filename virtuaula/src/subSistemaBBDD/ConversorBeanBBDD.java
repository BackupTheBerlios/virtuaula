package subSistemaBBDD;
import beans.*;
import beans.listaObjetoBeans.*;
import subSistemaBBDD.objetoBaseDatos.*;
import subSistemaBBDD.listaObjeto.*;
import subSistemaBBDD.utils.*;
/**
 * Clase final que contiene metodos estáticos
 * de conversion entre ObjetoBean y ObjetoBBDD y entre
 * ListaObjetoBean y ListaObjetoBBDD
 * @author JORGE SANCHEZ
 *
 */
public final class ConversorBeanBBDD {
	private ConversorBeanBBDD(){
		
	}
	private static ObjetoBBDD convierteAlumno(ObjetoBean alumno){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		//creo un objeto alumno de la BBDD
		ObjetoBBDD isAlumno = creador.crear(creador.Isalumno);
		//relleno los campos de isAlumno con los de ObjetoBean alumno
		isAlumno.cambiaValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI,alumno.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
		isAlumno.cambiaValor(Constantes.ALUMNO_NOMBRE,alumno.dameValor(Constantes.ALUMNO_NOMBRE));
		isAlumno.cambiaValor(Constantes.ALUMNO_APELLIDO1,alumno.dameValor(Constantes.ALUMNO_APELLIDO1));
		isAlumno.cambiaValor(Constantes.ALUMNO_APELLIDO2,alumno.dameValor(Constantes.ALUMNO_APELLIDO2));
		isAlumno.cambiaValor(Constantes.ALUMNO_TELEFONO,alumno.dameValor(Constantes.ALUMNO_TELEFONO));
		isAlumno.cambiaValor(Constantes.ALUMNO_EMAIL,alumno.dameValor(Constantes.ALUMNO_EMAIL));
		isAlumno.cambiaValor(Constantes.ALUMNO_DIRECCION,alumno.dameValor(Constantes.ALUMNO_DIRECCION));
		isAlumno.cambiaValor(Constantes.ALUMNO_FECH_NACIMIENTO,alumno.dameValor(Constantes.ALUMNO_FECH_NACIMIENTO));
		isAlumno.cambiaValor(Constantes.ALUMNO_SEXO,alumno.dameValor(Constantes.ALUMNO_SEXO));
		return isAlumno;
		
	}
	private static ObjetoBBDD convierteArea(ObjetoBean area){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isArea = creador.crear(creador.Isarea);
		isArea.cambiaValor(Constantes.ID_ISAREA,area.dameValor(Constantes.ID_ISAREA));
		isArea.cambiaValor(Constantes.AREA_NOMBRE,area.dameValor(Constantes.AREA_NOMBRE));
		return isArea;
	}
	private static ObjetoBBDD convierteAula(ObjetoBean aula){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isAula = creador.crear(creador.Isaula);
		isAula.cambiaValor(Constantes.AULA_NOMBRE,aula.dameValor(Constantes.AULA_NOMBRE));
		isAula.cambiaValor(Constantes.AULA_CAPACIDAD,aula.dameValor(Constantes.AULA_CAPACIDAD));
		isAula.cambiaValor(Constantes.ID_ISAULA,aula.dameValor(Constantes.ID_ISAULA));
		isAula.cambiaValor(Constantes.AULA_LOCALIZACION,aula.dameValor(Constantes.AULA_LOCALIZACION));
		return isAula;
	}
	private static ObjetoBBDD convierteAvisosUsuario(ObjetoBean avisoUsuario){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isAvisoUsuario = creador.crear(creador.IsavisosHasIsuario);
		isAvisoUsuario.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO,avisoUsuario.dameValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO));
		isAvisoUsuario.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,avisoUsuario.dameValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI));
		return isAvisoUsuario;
	}
	private static ObjetoBBDD convierteAvisos(ObjetoBean aviso){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isAvisos = creador.crear(creador.Isavisos);
		isAvisos.cambiaValor(Constantes.AVISOS_FECHA_AVISO,aviso.dameValor(Constantes.AVISOS_FECHA_AVISO));
		isAvisos.cambiaValor(Constantes.AVISOS_FECHA_CADUCUDAD,aviso.dameValor(Constantes.AVISOS_FECHA_CADUCUDAD));
		isAvisos.cambiaValor(Constantes.AVISOS_ASUNTO,aviso.dameValor(Constantes.AVISOS_ASUNTO));
		isAvisos.cambiaValor(Constantes.AVISOS_TEXTO,aviso.dameValor(Constantes.AVISOS_TEXTO));
		isAvisos.cambiaValor(Constantes.AVISOS_ACTIVO,aviso.dameValor(Constantes.AVISOS_ACTIVO));
		isAvisos.cambiaValor(Constantes.ID_ISAVISOS,aviso.dameValor(Constantes.ID_ISAVISOS));
		return isAvisos;
	}
	private static ObjetoBBDD convierteContrato(ObjetoBean contrato){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isContrato = creador.crear(creador.Iscontrato);
		isContrato.cambiaValor(Constantes.ID_ISCONTRATO_ISUSUARIO_DNI,contrato.dameValor(Constantes.ID_ISCONTRATO_ISUSUARIO_DNI));
		isContrato.cambiaValor(Constantes.CONTRATO_ISNOMINA_IDISNOMINA,contrato.dameValor(Constantes.CONTRATO_ISNOMINA_IDISNOMINA));
		isContrato.cambiaValor(Constantes.CONTRATO_TIPO,contrato.dameValor(Constantes.CONTRATO_TIPO));
		return isContrato;		
	}
	private static ObjetoBBDD convierteCursoAlumno(ObjetoBean cursoAlumno){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isCursoAlumno = creador.crear(creador.IscursoHasIsalumno);
		isCursoAlumno.cambiaValor(Constantes.ID_HAS_ISCURSO_IDISCURSO,cursoAlumno.dameValor(Constantes.ID_HAS_ISCURSO_IDISCURSO));
		isCursoAlumno.cambiaValor(Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI,cursoAlumno.dameValor(Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI));
		isCursoAlumno.cambiaValor(Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA,cursoAlumno.dameValor(Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA));
		isCursoAlumno.cambiaValor(Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL,cursoAlumno.dameValor(Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL));
		return isCursoAlumno;
	}

	private static ObjetoBBDD convierteCurso(ObjetoBean curso){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isCurso = creador.crear(creador.Iscurso);
		isCurso.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO,curso.dameValor(Constantes.ID_ISCURSO_IDISCURSO));
		isCurso.cambiaValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI,curso.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI));
		isCurso.cambiaValor(Constantes.CURSO_ISAREA_IDISAREA,curso.dameValor(Constantes.CURSO_ISAREA_IDISAREA));
		isCurso.cambiaValor(Constantes.CURSO_NOMBRE,curso.dameValor(Constantes.CURSO_NOMBRE));
		isCurso.cambiaValor(Constantes.CURSO_NUMERO_PLAZAS,curso.dameValor(Constantes.CURSO_NUMERO_PLAZAS));
		isCurso.cambiaValor(Constantes.CURSO_ESTADO	,curso.dameValor(Constantes.CURSO_ESTADO	));
		isCurso.cambiaValor(Constantes.CURSO_FECHA_INICIO,curso.dameValor(Constantes.CURSO_FECHA_INICIO));
		isCurso.cambiaValor(Constantes.CURSO_FECHA_FIN ,curso.dameValor(Constantes.CURSO_FECHA_FIN ));
		isCurso.cambiaValor(Constantes.CURSO_PRECIO,curso.dameValor(Constantes.CURSO_PRECIO));
		return isCurso;
	}
	

	private static ObjetoBBDD convierteFicha(ObjetoBean ficha){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isFicha = creador.crear(creador.IsFicha);
		isFicha.cambiaValor(Constantes.ID_ISFICHA,ficha.dameValor(Constantes.ID_ISFICHA));
		isFicha.cambiaValor(Constantes.FICHA_NOTAS,ficha.dameValor(Constantes.FICHA_NOTAS));
		isFicha.cambiaValor(Constantes.FICHA_ANOTACIONES,ficha.dameValor(Constantes.FICHA_ANOTACIONES));
		isFicha.cambiaValor(Constantes.FICHA_NOTAS_EJERCICIOS,ficha.dameValor(Constantes.FICHA_NOTAS_EJERCICIOS));
		return isFicha;
	}
	private static ObjetoBBDD convierteHorarioAula(ObjetoBean horarioAula){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isHorarioAula = creador.crear(creador.IshorarioHasIsaula);
		isHorarioAula.cambiaValor(Constantes.ID_HAS_ISHORARIO_IDISHORARIO,horarioAula.dameValor(Constantes.ID_HAS_ISHORARIO_IDISHORARIO));
		isHorarioAula.cambiaValor(Constantes.ID_HAS_ISAULA_IDISAULA,horarioAula.dameValor(Constantes.ID_HAS_ISAULA_IDISAULA));
		isHorarioAula.cambiaValor(Constantes.ISHORARIO_HAS_ISAULA_ISCURSO_IDISCURSO,horarioAula.dameValor(Constantes.ISHORARIO_HAS_ISAULA_ISCURSO_IDISCURSO));
		return isHorarioAula;
	}

	
	private static ObjetoBBDD convierteHorario(ObjetoBean horario){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isHorario = creador.crear(creador.Ishorario);
		isHorario.cambiaValor(Constantes.ID_ISHORARIO ,horario.dameValor(Constantes.ID_ISHORARIO ));
		isHorario.cambiaValor(Constantes.HORARIO_LUNES,horario.dameValor(Constantes.HORARIO_LUNES));
		isHorario.cambiaValor(Constantes.HORARIO_MARTES ,horario.dameValor(Constantes.HORARIO_MARTES ));
		isHorario.cambiaValor(Constantes.HORARIO_MIERCOLES,horario.dameValor(Constantes.HORARIO_MIERCOLES));
		isHorario.cambiaValor(Constantes.HORARIO_JUEVES,horario.dameValor(Constantes.HORARIO_JUEVES));
		isHorario.cambiaValor(Constantes.HORARIO_VIERNES,horario.dameValor(Constantes.HORARIO_VIERNES));
		return isHorario;
	}

	private static ObjetoBBDD convierteNomina(ObjetoBean nomina){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isNomina = creador.crear(creador.Isnomina);
		isNomina.cambiaValor(Constantes.ID_ISNOMINA,nomina.dameValor(Constantes.ID_ISNOMINA));
		isNomina.cambiaValor(Constantes.NOMINA_CUENTA_INGRESOS,nomina.dameValor(Constantes.NOMINA_CUENTA_INGRESOS));
		isNomina.cambiaValor(Constantes.NOMINA_CANTIDAD ,nomina.dameValor(Constantes.NOMINA_CANTIDAD ));
		return isNomina;
	}
	
	
	
	private static ObjetoBBDD convierteProfesor(ObjetoBean profesor){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isProfesor = creador.crear(creador.Isprofesor);
		isProfesor.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI ,profesor.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI ));
		isProfesor.cambiaValor(Constantes.PROFESOR_ISAREA_IDISAREA,profesor.dameValor(Constantes.PROFESOR_ISAREA_IDISAREA));
		isProfesor.cambiaValor(Constantes.PROFESOR_NOMBRE,profesor.dameValor(Constantes.PROFESOR_NOMBRE));
		isProfesor.cambiaValor(Constantes.PROFESOR_APELLIDO1,profesor.dameValor(Constantes.PROFESOR_APELLIDO1));
		isProfesor.cambiaValor(Constantes.PROFESOR_APELLIDO2 ,profesor.dameValor(Constantes.PROFESOR_APELLIDO2 ));
		isProfesor.cambiaValor(Constantes.PROFESOR_TELEFONO,profesor.dameValor(Constantes.PROFESOR_TELEFONO));
		isProfesor.cambiaValor(Constantes.PROFESOR_EMAIL,profesor.dameValor(Constantes.PROFESOR_EMAIL));
		return isProfesor;
	}

	
	private static ObjetoBBDD convierteUsuario(ObjetoBean usuario){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isUsuario = creador.crear(creador.Isusuario);
		isUsuario.cambiaValor(Constantes.ID_ISUSUARIO_DNI,usuario.dameValor(Constantes.ID_ISUSUARIO_DNI));
		isUsuario.cambiaValor(Constantes.USUARIO_CONTRASENIA ,usuario.dameValor(Constantes.USUARIO_CONTRASENIA ));
		isUsuario.cambiaValor(Constantes.USUARIO_PERFIL ,usuario.dameValor(Constantes.USUARIO_PERFIL ));
		return isUsuario;
	}
	/**************
	 * ****************************************************
	 * ******************************************************
	 * *******************************************************
	 * *******************************************************
	 * 
	 */
	private static ObjetoBean convierteAlumno(ObjetoBBDD isAlumno){
		CreadorBean creador= new CreadorBean();
		ObjetoBean alumno = creador.crear(creador.Alumno);
		alumno.cambiaValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI,isAlumno.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
		alumno.cambiaValor(Constantes.ALUMNO_APELLIDO1,isAlumno.dameValor(Constantes.ALUMNO_APELLIDO1));
		alumno.cambiaValor(Constantes.ALUMNO_APELLIDO2,isAlumno.dameValor(Constantes.ALUMNO_APELLIDO2));
		alumno.cambiaValor(Constantes.ALUMNO_TELEFONO,isAlumno.dameValor(Constantes.ALUMNO_TELEFONO));
		alumno.cambiaValor(Constantes.ALUMNO_EMAIL,isAlumno.dameValor(Constantes.ALUMNO_EMAIL));
		alumno.cambiaValor(Constantes.ALUMNO_DIRECCION,isAlumno.dameValor(Constantes.ALUMNO_DIRECCION));
		alumno.cambiaValor(Constantes.ALUMNO_NOMBRE,isAlumno.dameValor(Constantes.ALUMNO_NOMBRE));
		alumno.cambiaValor(Constantes.ALUMNO_FECH_NACIMIENTO,isAlumno.dameValor(Constantes.ALUMNO_FECH_NACIMIENTO));
		alumno.cambiaValor(Constantes.ALUMNO_SEXO,isAlumno.dameValor(Constantes.ALUMNO_SEXO));
		return alumno;
		
	}
	private static ObjetoBean convierteArea(ObjetoBBDD isArea){
		CreadorBean creador= new CreadorBean();
		ObjetoBean area = creador.crear(creador.Area);
		area.cambiaValor(Constantes.ID_ISAREA,isArea.dameValor(Constantes.ID_ISAREA));
		area.cambiaValor(Constantes.AREA_NOMBRE,isArea.dameValor(Constantes.AREA_NOMBRE));
		return area;
	}
	private static ObjetoBean convierteAula(ObjetoBBDD isAula){
		CreadorBean creador= new CreadorBean();
		ObjetoBean aula = creador.crear(creador.Aula);
		aula.cambiaValor(Constantes.AULA_NOMBRE,isAula.dameValor(Constantes.AULA_NOMBRE));
		aula.cambiaValor(Constantes.AULA_CAPACIDAD,isAula.dameValor(Constantes.AULA_CAPACIDAD));
		aula.cambiaValor(Constantes.ID_ISAULA,isAula.dameValor(Constantes.ID_ISAULA));
		aula.cambiaValor(Constantes.AULA_LOCALIZACION,isAula.dameValor(Constantes.AULA_LOCALIZACION));
		return aula;
	}
	private static ObjetoBean convierteAvisosUsuario(ObjetoBBDD isAvisoUsuario){
		CreadorBean creador= new CreadorBean();
		ObjetoBean avisoUsuario = creador.crear(creador.AvisosHasUario);
		avisoUsuario.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO,isAvisoUsuario.dameValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO));
		avisoUsuario.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,isAvisoUsuario.dameValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI));
		return avisoUsuario;
	}
	private static ObjetoBean convierteAvisos(ObjetoBBDD isAviso){
		CreadorBean creador= new CreadorBean();
		ObjetoBean avisos = creador.crear(creador.Avisos);
		avisos.cambiaValor(Constantes.AVISOS_FECHA_AVISO,isAviso.dameValor(Constantes.AVISOS_FECHA_AVISO));
		avisos.cambiaValor(Constantes.AVISOS_FECHA_CADUCUDAD,isAviso.dameValor(Constantes.AVISOS_FECHA_CADUCUDAD));
		avisos.cambiaValor(Constantes.AVISOS_ASUNTO,isAviso.dameValor(Constantes.AVISOS_ASUNTO));
		avisos.cambiaValor(Constantes.AVISOS_TEXTO,isAviso.dameValor(Constantes.AVISOS_TEXTO));
		avisos.cambiaValor(Constantes.AVISOS_ACTIVO,isAviso.dameValor(Constantes.AVISOS_ACTIVO));
		avisos.cambiaValor(Constantes.ID_ISAVISOS,isAviso.dameValor(Constantes.ID_ISAVISOS));
		return avisos;
	}
	private static ObjetoBean convierteContrato(ObjetoBBDD isContrato){
		CreadorBean creador= new CreadorBean();
		ObjetoBean contrato = creador.crear(creador.Contrato);
		contrato.cambiaValor(Constantes.ID_ISCONTRATO_ISUSUARIO_DNI,isContrato.dameValor(Constantes.ID_ISCONTRATO_ISUSUARIO_DNI));
		contrato.cambiaValor(Constantes.CONTRATO_ISNOMINA_IDISNOMINA,isContrato.dameValor(Constantes.CONTRATO_ISNOMINA_IDISNOMINA));
		contrato.cambiaValor(Constantes.CONTRATO_TIPO,isContrato.dameValor(Constantes.CONTRATO_TIPO));
		return contrato;		
	}
	private static ObjetoBean convierteCursoAlumno(ObjetoBBDD isCursoAlumno){
		CreadorBean creador= new CreadorBean();
		ObjetoBean cursoAlumno = creador.crear(creador.CursoHasAlumno);
		cursoAlumno.cambiaValor(Constantes.ID_HAS_ISCURSO_IDISCURSO,isCursoAlumno.dameValor(Constantes.ID_HAS_ISCURSO_IDISCURSO));
		cursoAlumno.cambiaValor(Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI,isCursoAlumno.dameValor(Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI));
		cursoAlumno.cambiaValor(Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA,isCursoAlumno.dameValor(Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA));
		cursoAlumno.cambiaValor(Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL,isCursoAlumno.dameValor(Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL));
		return cursoAlumno;
	}

	private static ObjetoBean convierteCurso(ObjetoBBDD isCurso){
		CreadorBean creador= new CreadorBean();
		ObjetoBean curso = creador.crear(creador.Curso);
		curso.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO,isCurso.dameValor(Constantes.ID_ISCURSO_IDISCURSO));
		curso.cambiaValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI,isCurso.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI));
		curso.cambiaValor(Constantes.CURSO_ISAREA_IDISAREA,isCurso.dameValor(Constantes.CURSO_ISAREA_IDISAREA));
		curso.cambiaValor(Constantes.CURSO_NOMBRE,isCurso.dameValor(Constantes.CURSO_NOMBRE));
		curso.cambiaValor(Constantes.CURSO_NUMERO_PLAZAS,isCurso.dameValor(Constantes.CURSO_NUMERO_PLAZAS));
		curso.cambiaValor(Constantes.CURSO_ESTADO	,isCurso.dameValor(Constantes.CURSO_ESTADO	));
		curso.cambiaValor(Constantes.CURSO_FECHA_INICIO,isCurso.dameValor(Constantes.CURSO_FECHA_INICIO));
		curso.cambiaValor(Constantes.CURSO_FECHA_FIN ,isCurso.dameValor(Constantes.CURSO_FECHA_FIN ));
		curso.cambiaValor(Constantes.CURSO_PRECIO,isCurso.dameValor(Constantes.CURSO_PRECIO));
		return curso;
	}
	

	private static ObjetoBean convierteFicha(ObjetoBBDD isFicha){
		CreadorBean creador= new CreadorBean();
		ObjetoBean ficha = creador.crear(creador.Ficha);
		ficha.cambiaValor(Constantes.ID_ISFICHA,isFicha.dameValor(Constantes.ID_ISFICHA));
		ficha.cambiaValor(Constantes.FICHA_NOTAS,isFicha.dameValor(Constantes.FICHA_NOTAS));
		ficha.cambiaValor(Constantes.FICHA_ANOTACIONES,isFicha.dameValor(Constantes.FICHA_ANOTACIONES));
		ficha.cambiaValor(Constantes.FICHA_NOTAS_EJERCICIOS,isFicha.dameValor(Constantes.FICHA_NOTAS_EJERCICIOS));
		return ficha;
	}
	private static ObjetoBean convierteHorarioAula(ObjetoBBDD isHorarioAula){
		CreadorBean creador= new CreadorBean();
		ObjetoBean horarioAula = creador.crear(creador.HorarioHasAula);
		horarioAula.cambiaValor(Constantes.ID_HAS_ISHORARIO_IDISHORARIO,isHorarioAula.dameValor(Constantes.ID_HAS_ISHORARIO_IDISHORARIO));
		horarioAula.cambiaValor(Constantes.ID_HAS_ISAULA_IDISAULA,isHorarioAula.dameValor(Constantes.ID_HAS_ISAULA_IDISAULA));
		horarioAula.cambiaValor(Constantes.ISHORARIO_HAS_ISAULA_ISCURSO_IDISCURSO,isHorarioAula.dameValor(Constantes.ISHORARIO_HAS_ISAULA_ISCURSO_IDISCURSO));
		return horarioAula;
	}

	
	private static ObjetoBean convierteHorario(ObjetoBBDD isHorario){
		CreadorBean creador= new CreadorBean();
		ObjetoBean horario = creador.crear(creador.Horario);
		horario.cambiaValor(Constantes.ID_ISHORARIO ,isHorario.dameValor(Constantes.ID_ISHORARIO ));
		horario.cambiaValor(Constantes.HORARIO_LUNES,isHorario.dameValor(Constantes.HORARIO_LUNES));
		horario.cambiaValor(Constantes.HORARIO_MARTES ,isHorario.dameValor(Constantes.HORARIO_MARTES ));
		horario.cambiaValor(Constantes.HORARIO_MIERCOLES,isHorario.dameValor(Constantes.HORARIO_MIERCOLES));
		horario.cambiaValor(Constantes.HORARIO_JUEVES,isHorario.dameValor(Constantes.HORARIO_JUEVES));
		horario.cambiaValor(Constantes.HORARIO_VIERNES,isHorario.dameValor(Constantes.HORARIO_VIERNES));
		return horario;
	}

	private static ObjetoBean convierteNomina(ObjetoBBDD isNomina){
		CreadorBean creador= new CreadorBean();
		ObjetoBean nomina = creador.crear(creador.Nomina);
		nomina.cambiaValor(Constantes.ID_ISNOMINA,isNomina.dameValor(Constantes.ID_ISNOMINA));
		nomina.cambiaValor(Constantes.NOMINA_CUENTA_INGRESOS,isNomina.dameValor(Constantes.NOMINA_CUENTA_INGRESOS));
		nomina.cambiaValor(Constantes.NOMINA_CANTIDAD ,isNomina.dameValor(Constantes.NOMINA_CANTIDAD ));
		return nomina;
	}
	
	
	
	private static ObjetoBean convierteProfesor(ObjetoBBDD isProfesor){
		CreadorBean creador= new CreadorBean();
		ObjetoBean profesor = creador.crear(creador.Profesor);
		profesor.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI ,isProfesor.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI ));
		profesor.cambiaValor(Constantes.PROFESOR_ISAREA_IDISAREA,isProfesor.dameValor(Constantes.PROFESOR_ISAREA_IDISAREA));
		profesor.cambiaValor(Constantes.PROFESOR_NOMBRE,isProfesor.dameValor(Constantes.PROFESOR_NOMBRE));
		profesor.cambiaValor(Constantes.PROFESOR_APELLIDO1,isProfesor.dameValor(Constantes.PROFESOR_APELLIDO1));
		profesor.cambiaValor(Constantes.PROFESOR_APELLIDO2 ,isProfesor.dameValor(Constantes.PROFESOR_APELLIDO2 ));
		profesor.cambiaValor(Constantes.PROFESOR_TELEFONO,isProfesor.dameValor(Constantes.PROFESOR_TELEFONO));
		profesor.cambiaValor(Constantes.PROFESOR_EMAIL,isProfesor.dameValor(Constantes.PROFESOR_EMAIL));
		return profesor;
	}

	
	private static ObjetoBean convierteUsuario(ObjetoBBDD isUsuario){
		CreadorBean creador= new CreadorBean();
		ObjetoBean usuario = creador.crear(creador.Usuario);
		usuario.cambiaValor(Constantes.ID_ISUSUARIO_DNI,isUsuario.dameValor(Constantes.ID_ISUSUARIO_DNI));
		usuario.cambiaValor(Constantes.USUARIO_CONTRASENIA ,isUsuario.dameValor(Constantes.USUARIO_CONTRASENIA ));
		usuario.cambiaValor(Constantes.USUARIO_PERFIL ,isUsuario.dameValor(Constantes.USUARIO_PERFIL ));
		return usuario;
	}
	
	/**
	 * Convierte un ObjetoBBDD en un objetoBean equivalente,reconocible por los clientes
	 * que solicitan peticiones a la fachada de la base de datos.
	 * @param entidad
	 * @return
	 * @throws Exception
	 */
	public static ObjetoBean convierteBBDDABean(ObjetoBBDD entidad) throws Exception{
		if (entidad instanceof IsAlumno){
			return ConversorBeanBBDD.convierteAlumno(entidad);
		}
		else if(entidad instanceof IsArea){
			return ConversorBeanBBDD.convierteArea(entidad); 
		}
		else if (entidad instanceof IsAula){
			return ConversorBeanBBDD.convierteAula(entidad);
		}
		else if (entidad instanceof IsAvisos){
			return ConversorBeanBBDD.convierteAvisos(entidad);
		}
		else if (entidad instanceof IsAvisos_Has_IsUsuario ){
			return ConversorBeanBBDD.convierteAvisosUsuario(entidad);
		}
		else if (entidad instanceof IsContrato ){
			return ConversorBeanBBDD.convierteContrato(entidad);
		}
		else if (entidad instanceof IsCurso ){
			return ConversorBeanBBDD.convierteCurso(entidad);
		}
		else if (entidad instanceof IsCurso_Has_IsAlumno ){
			return ConversorBeanBBDD.convierteCursoAlumno(entidad);
		}
		else if (entidad instanceof IsFicha ){
			return ConversorBeanBBDD.convierteFicha(entidad);
		}
		else if (entidad instanceof IsHorario_Has_IsAula ){
			return ConversorBeanBBDD.convierteHorarioAula(entidad);
		}
		else if (entidad instanceof IsHorario ){
			return ConversorBeanBBDD.convierteHorario(entidad);
		}
		else if (entidad instanceof IsNomina ){
			return ConversorBeanBBDD.convierteNomina(entidad);
		}
		else if (entidad instanceof IsProfesor ){
			return ConversorBeanBBDD.convierteProfesor(entidad);
		}
		else if (entidad instanceof IsUsuario ){
			return ConversorBeanBBDD.convierteUsuario(entidad);
		}
		else throw new Exception("fallo en conversión a objetoBBDD");
	
	}

	/**
	 * Convierte un objeto Bean en un ObjetoBBDD tratable por las clases en las que
	 * la fachada delega las peticiones recibidas por los cliente
	 * @param entidad
	 * @return 
	 * @throws Exception
	 */
	public static ObjetoBBDD convierteBeanABBDD(ObjetoBean entidad) throws Exception{
		if (entidad instanceof Alumno){
			return ConversorBeanBBDD.convierteAlumno(entidad);
		}
		else if(entidad instanceof Area){
			return ConversorBeanBBDD.convierteArea(entidad); 
		}
		else if (entidad instanceof Aula){
			return ConversorBeanBBDD.convierteAula(entidad);
		}
		else if (entidad instanceof Avisos){
			return ConversorBeanBBDD.convierteAvisos(entidad);
		}
		else if (entidad instanceof Avisos_Has_Usuario ){
			return ConversorBeanBBDD.convierteAvisosUsuario(entidad);
		}
		else if (entidad instanceof Contrato ){
			return ConversorBeanBBDD.convierteContrato(entidad);
		}
		else if (entidad instanceof Curso ){
			return ConversorBeanBBDD.convierteCurso(entidad);
		}
		else if (entidad instanceof Curso_Has_Alumno ){
			return ConversorBeanBBDD.convierteCursoAlumno(entidad);
		}
		else if (entidad instanceof Ficha ){
			return ConversorBeanBBDD.convierteFicha(entidad);
		}
		else if (entidad instanceof Horario_Has_Aula ){
			return ConversorBeanBBDD.convierteHorarioAula(entidad);
		}
		else if (entidad instanceof Horario ){
			return ConversorBeanBBDD.convierteHorario(entidad);
		}
		else if (entidad instanceof Nomina ){
			return ConversorBeanBBDD.convierteNomina(entidad);
		}
		else if (entidad instanceof Profesor ){
			return ConversorBeanBBDD.convierteProfesor(entidad);
		}
		else if (entidad instanceof Usuario ){
			return ConversorBeanBBDD.convierteUsuario(entidad);
		}
		else throw new Exception("fallo en conversión a objetoBBDD");
	
	}
	public static ListaObjetoBean convierteListaBBDD(ListaObjetoBBDD listaBBDD){
		CreadorListaObjetoBean creador = new CreadorListaObjetoBean();
		ListaObjetoBean listaBeans = creador.crear();
		for (int i=0;i<listaBBDD.tamanio();i++){
			try{
				ObjetoBBDD entidadBBDD = listaBBDD.dameObjeto(i);
				listaBeans.insertar(i,ConversorBeanBBDD.convierteBBDDABean(entidadBBDD));
				
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
			
			
		}
		return listaBeans;
	}
	
}


	
	
	
	
	
	
	
	
	
	
	
	