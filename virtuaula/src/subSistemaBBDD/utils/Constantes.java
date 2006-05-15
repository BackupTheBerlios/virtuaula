package subSistemaBBDD.utils;

public class Constantes {

	//ERRORES GENERICOS
	public static final String ERROR_CONEXION_BBDD = "Error al conectar con la Base de Datos";
	public static final String ERROR_DESCONEXION_BBDD = "Se ha produciodo un error al desconectar de la BBDD";
	
	//ISAREA
	public static final String TABLA_AREA = "isarea";
	public static final String ID_ISAREA = "IDISAREA";
	public static final String AREA_NOMBRE = "NOMBRE";
	
	//ISAULA
	public static final String TABLA_AULA = "isaula";
	public static final String ID_ISAULA = "IDISAULA";
	public static final String AULA_NOMBRE = "NOMBRE";
	public static final String AULA_CAPACIDAD = "CAPACIDAD";
	public static final String AULA_LOCALIZACION = "LOCALIZACION";
	
	//ISAVISO
	public static final String TABLA_AVISOS = "isavisos";
	public static final String ID_ISAVISOS = "IDISAVISOS";
	public static final String AVISOS_FECHA_AVISO = "FECHA_AVISO";
	public static final String AVISOS_FECHA_CADUCUDAD = "FECHA_CADUCIDAD";
	public static final String AVISOS_ASUNTO = "ASUNTO";
	public static final String AVISOS_TEXTO = "TEXTO";
	public static final String AVISOS_ACTIVO = "ACTIVO";
	
	//ISNOMINA
	public static final String TABLA_NOMINA = "isnomina";
	public static final String ID_ISNOMINA = "IDISNOMINA";
	public static final String NOMINA_CUENTA_INGRESOS = "CUENTA_INGRESOS";
	public static final String NOMINA_CANTIDAD = "CANTIDAD";
	
	//ISHORARIO
	public static final String TABLA_HORARIO = "ishorario";
	public static final String ID_ISHORARIO = "IDISHORARIO";
	public static final String HORARIO_LUNES = "LUNES";
	public static final String HORARIO_MARTES = "MARTES";
	public static final String HORARIO_MIERCOLES = "MIERCOLES";
	public static final String HORARIO_JUEVES = "JUEVES";
	public static final String HORARIO_VIERNES = "VIERNES";
	
	//ISFICHA
	public static final String TABLA_FICHA = "isficha";
	public static final String ID_ISFICHA = "IDISFICHA";
	public static final String FICHA_NOTAS = "NOTAS";
	public static final String FICHA_ANOTACIONES = "ANOTACIONES";
	public static final String FICHA_NOTAS_EJERCICIOS = "NOTAS_EJERCICIOS";
		
	//ISUSUARIO
	public static final String TABLA_USUARIO = "isusuario";
	public static final String ID_ISUSUARIO_DNI = "DNI";
	public static final String USUARIO_CONTRASENIA = "CONTRASENIA";
	public static final String USUARIO_PERFIL = "PERFIL";
	
	//ISCONTRATO
	public static final String TABLA_CONTRATO = "iscontrato";
	public static final String ID_ISCONTRATO_ISUSUARIO_DNI = "ISUSUARIO_DNI";
	public static final String CONTRATO_ISNOMINA_IDISNOMINA = "ISNOMINA_IDISNOMINA";
	public static final String CONTRATO_TIPO = "TIPO";
	
	//ISPROFESOR
	public static final String TABLA_PROFESOR = "isprofesor";
	public static final String ID_ISPROFESOR_ISUSUARIO_DNI = "ISUSUARIO_DNI";
	public static final String PROFESOR_ISAREA_IDISAREA = "ISAREA_IDISAREA";
	public static final String PROFESOR_NOMBRE = "NOMBRE";
	public static final String PROFESOR_APELLIDO1 = "APELLIDO1";
	public static final String PROFESOR_APELLIDO2 = "APELLIDO2";
	public static final String PROFESOR_TELEFONO = "TELEFONO";
	public static final String PROFESOR_EMAIL = "EMAIL";
	
	//ISALUMNO
	public static final String TABLA_ALUMNO = "isalumno";
	public static final String ID_ISALUMNO_ISUSUARIO_DNI = "ISUSUARIO_DNI";
	public static final String ALUMNO_NOMBRE = "NOMBRE";
	public static final String ALUMNO_APELLIDO1 = "APELLIDO1";
	public static final String ALUMNO_APELLIDO2 = "APELLIDO2";
	public static final String ALUMNO_TELEFONO = "TELEFONO";
	public static final String ALUMNO_EMAIL = "EMAIL";
	public static final String ALUMNO_DIRECCION = "DIRECCION";
	public static final String ALUMNO_FECH_NACIMIENTO = "FECH_NACIMIENTO";
	public static final String ALUMNO_SEXO = "SEXO";
	
	//ISCURSO
	public static final String TABLA_CURSO = "iscurso";
	public static final String ID_ISCURSO_IDISCURSO = "IDISCURSO";
	public static final String CURSO_ISPROFESOR_ISUSUARIO_DNI = "ISPROFESOR_ISUSUARIO_DNI";
	public static final String CURSO_ISAREA_IDISAREA = "ISAREA_IDISAREA";
	public static final String CURSO_NOMBRE = "NOMBRE";
	public static final String CURSO_NUMERO_PLAZAS = "NUMERO_PLAZAS";
	public static final String CURSO_ESTADO	= "ESTADO";
	public static final String CURSO_FECHA_INICIO = "FECHA_INICIO";
	public static final String CURSO_FECHA_FIN = "FECHA_FIN";
	public static final String CURSO_PRECIO = "PRECIO";
		
	//ISAVISOS_HAS_ISUSUARIO
	public static final String TABLA_ISAVISOS_HAS_ISUSUARIO = "isavisos_has_isusuario";
	public static final String ID_ISAVISOS_HAS_ISUSUARIO = "ISAVISOS_IDISAVISOS";
	public static final String ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI = "ISUSUARIO_DNI";	
	
	//ISCURSO_HAS_ISALUMNO
	public static final String TABLA_ISCURSO_HAS_ISALUMNO = "iscurso_has_isalumno";
	public static final String ID_HAS_ISCURSO_IDISCURSO = "ISCURSO_IDISCURSO";
	public static final String ID_HAS_ISALUMNO_ISUSUARIO_DNI = "ISALUMNO_ISUSUARIO_DNI";
	public static final String ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA = "ISFICHA_IDISFICHA";
	public static final String ISCURSO_HAS_ISALUMNO_NOTA_FINAL = "NOTA_FINAL";
	
	//ISHORARIO_HAS_ISAULA
	public static final String TABLA_ISHORARIO_HAS_ISAULA = "ishorario_has_isaula";
	public static final String ID_HAS_ISHORARIO_IDISHORARIO = "ISHORARIO_IDISHORARIO";
	public static final String ID_HAS_ISAULA_IDISAULA = "ISAULA_IDISAULA";
	public static final String ISHORARIO_HAS_ISAULA_ISCURSO_IDISCURSO = "ISCURSO_IDISCURSO";


	//ISERROR
	public static final String CAUSA = "CAUSA_ERROR";
}
