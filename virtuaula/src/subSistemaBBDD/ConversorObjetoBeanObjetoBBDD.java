package subSistemaBBDD;
import beans.*;
import subSistemaBBDD.objetoBaseDatos.*;
public final class ConversorObjetoBeanObjetoBBDD {
	private ConversorObjetoBeanObjetoBBDD(){
		
	}
	private static ObjetoBBDD convierteAlumno(ObjetoBean alumno){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		//creo un objeto alumno de la BBDD
		ObjetoBBDD isAlumno = creador.crear(creador.Isalumno);
		//relleno los campos de isAlumno con los de ObjetoBean alumno
		isAlumno.cambiaValor("ISUSUARIODNI",alumno.dameValor("ISUSUARIODNI"));
		isAlumno.cambiaValor("APELLIDO1",alumno.dameValor("APELLIDO1"));
		isAlumno.cambiaValor("APELLIDO2",alumno.dameValor("APELLIDO2"));
		isAlumno.cambiaValor("TELEFONO",alumno.dameValor("TELEFONO"));
		isAlumno.cambiaValor("EMAIL",alumno.dameValor("EMAIL"));
		isAlumno.cambiaValor("DIRECCION",alumno.dameValor("DIRECCION"));
		isAlumno.cambiaValor("FECHNACIMIENTO",alumno.dameValor("FECHNACIMIENTO"));
		isAlumno.cambiaValor("SEXO",alumno.dameValor("SEXO"));
		return isAlumno;
		
	}
	private static ObjetoBBDD convierteArea(ObjetoBean area){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isArea = creador.crear(creador.Isarea);
		isArea.cambiaValor("IDISAREA",area.dameValor("IDISAREA"));
		isArea.cambiaValor("NOMBRE",area.dameValor("NOMBRE"));
		return isArea;
	}
	private static ObjetoBBDD convierteAula(ObjetoBean aula){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isAula = creador.crear(creador.Isaula);
		isAula.cambiaValor("NOMBRE",aula.dameValor("NOMBRE"));
		isAula.cambiaValor("CAPACIDAD",aula.dameValor("CAPACIDAD"));
		isAula.cambiaValor("IDISAULA",aula.dameValor("IDISAULA"));
		isAula.cambiaValor("LOCALIZACION",aula.dameValor("LOCALIZACION"));
		return isAula;
	}
	private static ObjetoBBDD convierteIsAvisos_Has_IsUsuario(ObjetoBean avisoUsuario){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isAvisoUsuario = creador.crear(creador.IsavisosHasIsuario);
		isAvisoUsuario.cambiaValor("ISAVISOS_IDISAVISOS",avisoUsuario.dameValor("ISAVISOS_IDISAVISOS"));
		isAvisoUsuario.cambiaValor("ISUSUARIO_DNI",avisoUsuario.dameValor("ISUSUARIO_DNI"));
		return isAvisoUsuario;
	}
	private static ObjetoBBDD convierteIsAvisos(ObjetoBean aviso){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isAvisos = creador.crear(creador.Isavisos);
		isAvisos.cambiaValor("FECHA_AVISO",aviso.dameValor("FECHA_AVISO"));
		isAvisos.cambiaValor("FECHA_CADUCIDAD",aviso.dameValor("FECHA_CADUCIDAD"));
		isAvisos.cambiaValor("ASUNTO",aviso.dameValor("ASUNTO"));
		isAvisos.cambiaValor("TEXTO",aviso.dameValor("TEXTO"));
		isAvisos.cambiaValor("ACTIVO",aviso.dameValor("ACTIVO"));
		isAvisos.cambiaValor("IDISAVISOS",aviso.dameValor("IDISAVISOS"));
		return isAvisos;
	}
	private static ObjetoBBDD convierteIsContrato(ObjetoBean contrato){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isContrato = creador.crear(creador.Iscontrato);
		isContrato.cambiaValor("ISUSUARIO_DNI",contrato.dameValor("ISUSUARIO_DNI"));
		isContrato.cambiaValor("ISNOMINA_IDISNOMINA",contrato.dameValor("ISNOMINA_IDISNOMINA"));
		isContrato.cambiaValor("TIPO",contrato.dameValor("TIPO"));
		return isContrato;		
	}
	private static ObjetoBBDD convierteIsCursoAlumno(ObjetoBean cursoAlumno){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isCursoAlumno = creador.crear(creador.IscursoHasIsalumno);
		isCursoAlumno.cambiaValor("ISCURSO_IDISCURSO",cursoAlumno.dameValor("ISCURSO_IDISCURSO"));
		isCursoAlumno.cambiaValor("ISALUMNO_ISUSUARIO_DNI",cursoAlumno.dameValor("ISALUMNO_ISUSUARIO_DNI"));
		isCursoAlumno.cambiaValor("ISFICHA_IDISFICHA",cursoAlumno.dameValor("ISFICHA_IDISFICHA"));
		isCursoAlumno.cambiaValor("NOTA_FINAL",cursoAlumno.dameValor("NOTA_FINAL"));
		return isCursoAlumno;
	}
	private static ObjetoBBDD convierteIsCurso(ObjetoBean curso){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isCurso = creador.crear(creador.IscursoHasIsalumno);
		isCurso.cambiaValor("IDISCURSO",curso.dameValor("IDISCURSO"));
		isCurso.cambiaValor("ISPROFESOR_ISUSUARIO_DNI",curso.dameValor("ISPROFESOR_ISUSUARIO_DNI"));
		isCurso.cambiaValor("ISAREA_IDISAREA",curso.dameValor("ISAREA_IDISAREA"));
		isCurso.cambiaValor("NOMBRE",curso.dameValor("NOMBRE"));
		isCurso.cambiaValor("NUMERO_PLAZAS",curso.dameValor("NUMERO_PLAZAS"));
		isCurso.cambiaValor("ESTADO",curso.dameValor("ESTADO"));
		isCurso.cambiaValor("FECHA_INICIO",curso.dameValor("FECHA_INICIO"));
		isCurso.cambiaValor("FECHA_FIN",curso.dameValor("FECHA_FIN"));
		isCurso.cambiaValor("PRECIO",curso.dameValor("PRECIO"));
		return isCurso;
	}
	
	private static ObjetoBBDD convierteIsFicha(ObjetoBean ficha){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isFicha = creador.crear(creador.IscursoHasIsalumno);
		isFicha.cambiaValor("IDISFICHA",ficha.dameValor("IDISFICHA"));
		isFicha.cambiaValor("NOTAS",ficha.dameValor("NOTAS"));
		isFicha.cambiaValor("ANOTACIONES",ficha.dameValor("ANOTACIONES"));
		isFicha.cambiaValor("NOTAS_EJERCICIOS",ficha.dameValor("NOTAS_EJERCICIOS"));
		return isFicha;
	}
	private static ObjetoBBDD convierteIsHorarioAula(ObjetoBean horarioAula){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isHorarioAula = creador.crear(creador.IscursoHasIsalumno);
		isHorarioAula.cambiaValor("ISHORARIO_IDISHORARIO",horarioAula.dameValor("ISHORARIO_IDISHORARIO"));
		isHorarioAula.cambiaValor("ISAULA_IDISAULA",horarioAula.dameValor("ISAULA_IDISAULA"));
		isHorarioAula.cambiaValor("ISCURSO_IDISCURSO",horarioAula.dameValor("ISCURSO_IDISCURSO"));
		return isHorarioAula;
	}
	
	private static ObjetoBBDD convierteIsHorario(ObjetoBean horario){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isHorario = creador.crear(creador.IscursoHasIsalumno);
		isHorario.cambiaValor("IDISHORARIO",horario.dameValor("IDISHORARIO"));
		isHorario.cambiaValor("LUNES",horario.dameValor("LUNES"));
		isHorario.cambiaValor("MARTES",horario.dameValor("MARTES"));
		isHorario.cambiaValor("MIERCOLES",horario.dameValor("MIERCOLES"));
		isHorario.cambiaValor("JUEVES",horario.dameValor("JUEVES"));
		isHorario.cambiaValor("VIERNES",horario.dameValor("VIERNES"));
		return isHorario;
	}
	
	private static ObjetoBBDD convierteIsNomina(ObjetoBean nomina){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isNomina = creador.crear(creador.IscursoHasIsalumno);
		isNomina.cambiaValor("IDISNOMINA",nomina.dameValor("IDISNOMINA"));
		isNomina.cambiaValor("CUENTA_INGRESOS",nomina.dameValor("CUENTA_INGRESOS"));
		isNomina.cambiaValor("CANTIDAD",nomina.dameValor("CANTIDAD"));
		return isNomina;
	}
	
	private static ObjetoBBDD convierteIsProfesor(ObjetoBean profesor){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isProfesor = creador.crear(creador.IscursoHasIsalumno);
		isProfesor.cambiaValor("ISUSUARIODNI",profesor.dameValor("ISUSUARIODNI"));
		isProfesor.cambiaValor("NOMBRE",profesor.dameValor("NOMBRE"));
		isProfesor.cambiaValor("APELLIDO1",profesor.dameValor("APELLIDO1"));
		isProfesor.cambiaValor("APELLIDO2",profesor.dameValor("APELLIDO2"));
		isProfesor.cambiaValor("TELEFONO",profesor.dameValor("TELEFONO"));
		isProfesor.cambiaValor("EMAIL",profesor.dameValor("EMAIL"));
		return isProfesor;
	}
	
	private static ObjetoBBDD convierteIsUsuario(ObjetoBean usuario){
		CreadorObjetoBBDD creador= new CreadorObjetoBBDD();
		ObjetoBBDD isUsuario = creador.crear(creador.IscursoHasIsalumno);
		isUsuario.cambiaValor("DNI",usuario.dameValor("DNI"));
		isUsuario.cambiaValor("CONTRASENIA",usuario.dameValor("CONTRASENIA"));
		isUsuario.cambiaValor("PERFIL",usuario.dameValor("PERFIL"));
		return isUsuario;
	}
	
	
	
	public static ObjetoBBDD convierte(ObjetoBean entidad) throws Exception{
		if (entidad instanceof Alumno){
			return ConversorObjetoBeanObjetoBBDD.convierteAlumno(entidad);
		}
		else if(entidad instanceof Area){
			return ConversorObjetoBeanObjetoBBDD.convierteArea(entidad); 
		}
		else if (entidad instanceof Aula){
			return ConversorObjetoBeanObjetoBBDD.convierteAula(entidad);
		}
		else if (entidad instanceof Avisos){
			return ConversorObjetoBeanObjetoBBDD.convierteIsAvisos(entidad);
		}
		else if (entidad instanceof Avisos_Has_Usuario ){
			return ConversorObjetoBeanObjetoBBDD.convierteIsAvisos_Has_IsUsuario(entidad);
		}
		else if (entidad instanceof Contrato ){
			return ConversorObjetoBeanObjetoBBDD.convierteIsContrato(entidad);
		}
		else if (entidad instanceof Curso ){
			return ConversorObjetoBeanObjetoBBDD.convierteIsCurso(entidad);
		}
		else if (entidad instanceof Curso_Has_Alumno ){
			return ConversorObjetoBeanObjetoBBDD.convierteIsCursoAlumno(entidad);
		}
		else if (entidad instanceof Ficha ){
			return ConversorObjetoBeanObjetoBBDD.convierteIsFicha(entidad);
		}
		else if (entidad instanceof Horario_Has_Aula ){
			return ConversorObjetoBeanObjetoBBDD.convierteIsHorarioAula(entidad);
		}
		else if (entidad instanceof Horario ){
			return ConversorObjetoBeanObjetoBBDD.convierteIsHorario(entidad);
		}
		else if (entidad instanceof Nomina ){
			return ConversorObjetoBeanObjetoBBDD.convierteIsNomina(entidad);
		}
		else if (entidad instanceof Profesor ){
			return ConversorObjetoBeanObjetoBBDD.convierteIsProfesor(entidad);
		}
		else if (entidad instanceof Usuario ){
			return ConversorObjetoBeanObjetoBBDD.convierteIsUsuario(entidad);
		}
		else throw new Exception("fallo en conversión a objetoBBDD");
	
	}
	
}

