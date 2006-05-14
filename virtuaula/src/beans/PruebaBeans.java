package beans;
 /**
 * 
 * @author AL
 * Esta clase la usaremos para hacer pruebas del paquete beans
 */
public class PruebaBeans {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CreadorBean c= new CreadorBean();
		ObjetoBean obj=c.crear(c.Alumno);
		obj.cambiaValor("ISUSUARIODNI","KKKKKK");
		//System.out.println(obj.dameValor("ISUSUARIODNI"));
		obj.cambiaValor("ISUSUARIODNI","ppppppppp");
		//System.out.println(obj.dameValor("ISUSUARIODNI"));
		obj=c.crear(c.Area);
		obj.cambiaValor("NOMBRE","tecnologia de internet");
		//System.out.println(obj.dameValor("NOMBRE"));
		
	/**
	 * PRUEBA PARA PROFESOR
	 */	
	/*	obj=c.crear(c.Profesor);
			
		obj.cambiaValor("ISAREA_IDISAREA","area java");
		obj.cambiaValor("ISUSUARIO_DNI","50877282");
		obj.cambiaValor("NOMBRE","PEPE");
		obj.cambiaValor("APELLIDO1","Martinez");
		obj.cambiaValor("APELLIDO2","Martin");
		obj.cambiaValor("TELEFONO","555555555");
		obj.cambiaValor("EMAIL","sdfgfsd@hotmail.com");
		
		System.out.println(obj.dameValor("ISAREA_IDISAREA"));
		System.out.println(obj.dameValor("ISUSUARIO_DNI"));
		System.out.println(obj.dameValor("NOMBRE"));
		System.out.println(obj.dameValor("APELLIDO1"));
		System.out.println(obj.dameValor("APELLIDO2"));
		System.out.println(obj.dameValor("TELEFONO"));
		System.out.println(obj.dameValor("EMAIL"));
		
		obj.inicializar();
		System.out.println(obj.dameValor("ISAREA_IDISAREA"));
		System.out.println(obj.dameValor("ISUSUARIO_DNI"));
		System.out.println(obj.dameValor("NOMBRE"));
		System.out.println(obj.dameValor("APELLIDO1"));
		System.out.println(obj.dameValor("APELLIDO2"));
		System.out.println(obj.dameValor("TELEFONO"));
		System.out.println(obj.dameValor("EMAIL"));
		*/
		/**
		 * PRUEBA PARA ALUMNO
		 */
		
		/*obj=c.crear(c.Alumno);
		obj.cambiaValor("ISUSUARIO_DNI","50888888");
		obj.cambiaValor("NOMBRE","juan");
		obj.cambiaValor("APELLIDO1","gonzalez");
		obj.cambiaValor("APELLIDO2","garcia");
		obj.cambiaValor("TELEFONO","666666666");
		obj.cambiaValor("EMAIL","g@hotmail.com");
		obj.cambiaValor("DIRECCION","alcala");
		obj.cambiaValor("FECH_NACIMIENTO","4/09/98");
		obj.cambiaValor("SEXO","varon");
		
		System.out.println(obj.dameValor("ISUSUARIO_DNI"));
		System.out.println(obj.dameValor("NOMBRE"));
		System.out.println(obj.dameValor("APELLIDO1"));
		System.out.println(obj.dameValor("APELLIDO2"));
		System.out.println(obj.dameValor("TELEFONO"));
		System.out.println(obj.dameValor("EMAIL"));
		System.out.println(obj.dameValor("DIRECCION"));
		System.out.println(obj.dameValor("FECH_NACIMIENTO"));
		System.out.println(obj.dameValor("SEXO"));
		
		
		obj.inicializar();
		System.out.println(obj.dameValor("ISUSUARIO_DNI"));
		System.out.println(obj.dameValor("NOMBRE"));
		System.out.println(obj.dameValor("APELLIDO1"));
		System.out.println(obj.dameValor("APELLIDO2"));
		System.out.println(obj.dameValor("TELEFONO"));
		System.out.println(obj.dameValor("EMAIL"));
		System.out.println(obj.dameValor("DIRECCION"));
		System.out.println(obj.dameValor("FECH_NACIMIENTO"));
		System.out.println(obj.dameValor("SEXO"));
	*/
	/**
	 * PRUEBA PARA AREA
	 */
		
		/*obj=c.crear(c.Area);
		obj.cambiaValor("IDISAREA","tomcat");
		obj.cambiaValor("NOMBRE","ignacio");
		
		
		System.out.println(obj.dameValor("IDISAREA"));
		System.out.println(obj.dameValor("NOMBRE"));
		
		
		obj.inicializar();
		System.out.println(obj.dameValor("IDISAREA"));
		System.out.println(obj.dameValor("NOMBRE"));
		*/
		/**
		 * PRUEBA PARA AULA
		 */
		
		/*obj=c.crear(c.Aula);
		obj.cambiaValor("IDISAULA","6515615");
		obj.cambiaValor("NOMBRE","aula1");
		obj.cambiaValor("CAPACIDAD","50");
		obj.cambiaValor("LOCALIZACION","primera planta");
		
		
		System.out.println(obj.dameValor("IDISAULA"));
		System.out.println(obj.dameValor("NOMBRE"));
		System.out.println(obj.dameValor("CAPACIDAD"));
		System.out.println(obj.dameValor("LOCALIZACION"));
	
		
		obj.inicializar();
		System.out.println(obj.dameValor("IDISAULA"));
		System.out.println(obj.dameValor("NOMBRE"));
		System.out.println(obj.dameValor("CAPACIDAD"));
		System.out.println(obj.dameValor("LOCALIZACION"));
	*/
		
		/**
		 * PRUEBA PARA Avisos_Has_Usuario
		 */
		/*
		obj=c.crear(c.AvisosHasUario);
		obj.cambiaValor("ISAVISOS_IDISAVISOS","tomcat");
		obj.cambiaValor("ISUSUARIO_DNI","ignacioo");
		
		
		System.out.println(obj.dameValor("ISAVISOS_IDISAVISOS"));
		System.out.println(obj.dameValor("ISUSUARIO_DNI"));
		
		
		obj.inicializar();
		System.out.println(obj.dameValor("ISAVISOS_IDISAVISOS"));
		System.out.println(obj.dameValor("NOMBRE"));
		*/
		/**
		 * PRUEBA PARA AVISOS
		 */
		/*
		obj=c.crear(c.Avisos);
		obj.cambiaValor("IDISAVISOS","50888888");
		obj.cambiaValor("FECHA_AVISO","20/06/96");
		obj.cambiaValor("FECHA_CADUCIDAD","20/6/98");
		obj.cambiaValor("ASUNTO","averisa");
		obj.cambiaValor("TEXTO","sgfsdgfsdfg");
		obj.cambiaValor("ACTIVO","activo");
		
		
		System.out.println(obj.dameValor("IDISAVISOS"));
		System.out.println(obj.dameValor("FECHA_AVISO"));
		System.out.println(obj.dameValor("FECHA_CADUCIDAD"));
		System.out.println(obj.dameValor("ASUNTO"));
		System.out.println(obj.dameValor("TEXTO"));
		System.out.println(obj.dameValor("ACTIVO"));
		
		
		obj.inicializar();
		System.out.println(obj.dameValor("IDISAVISOS"));
		System.out.println(obj.dameValor("FECHA_AVISO"));
		System.out.println(obj.dameValor("FECHA_CADUCIDAD"));
		System.out.println(obj.dameValor("ASUNTO"));
		System.out.println(obj.dameValor("TEXTO"));
		System.out.println(obj.dameValor("ACTIVO"));
		*/
		/**
		 * PRUEBA PARA CONTRATO
		 */
		/*
		obj=c.crear(c.Contrato);
		obj.cambiaValor("ISUSUARIO_DNI","6515615");
		obj.cambiaValor("ISNOMINA_IDISNOMINA","aula1");
		obj.cambiaValor("TIPO","50");
		
		
		System.out.println(obj.dameValor("ISUSUARIO_DNI"));
		System.out.println(obj.dameValor("ISNOMINA_IDISNOMINA"));
		System.out.println(obj.dameValor("TIPO"));
		
	
		
		obj.inicializar();
		System.out.println(obj.dameValor("ISUSUARIO_DNI"));
		System.out.println(obj.dameValor("ISNOMINA_IDISNOMINA"));
		System.out.println(obj.dameValor("TIPO"));
		*/
		/**
		 * PRUEBA PARA Curso_Has_Alumno
		 */
		/*
		obj=c.crear(c.CursoHasAlumno);
		obj.cambiaValor("ISCURSO_IDISCURSO","6515615");
		obj.cambiaValor("ISALUMNO_ISUSUARIO_DNI","aula1");
		obj.cambiaValor("ISFICHA_IDISFICHA","50");
		obj.cambiaValor("NOTA_FINAL","primera planta");
		
		
		System.out.println(obj.dameValor("ISCURSO_IDISCURSO"));
		System.out.println(obj.dameValor("ISALUMNO_ISUSUARIO_DNI"));
		System.out.println(obj.dameValor("ISFICHA_IDISFICHA"));
		System.out.println(obj.dameValor("NOTA_FINAL"));
	
		
		obj.inicializar();
		System.out.println(obj.dameValor("ISCURSO_IDISCURSO"));
		System.out.println(obj.dameValor("ISALUMNO_ISUSUARIO_DNI"));
		System.out.println(obj.dameValor("ISFICHA_IDISFICHA"));
		System.out.println(obj.dameValor("NOTA_FINAL"));
	*/
		/**
		 * PRUEBA PARA CURSO
		 */
		/*
		obj=c.crear(c.Curso);
		
		obj.cambiaValor("IDISCURSO","area java");
		obj.cambiaValor("ISPROFESOR_ISUSUARIO_DNI","50877282");
		obj.cambiaValor("ISAREA_IDISAREA","PEPE");
		obj.cambiaValor("NOMBRE","Martinez");
		obj.cambiaValor("NUMERO_PLAZAS","Martin");
		obj.cambiaValor("ESTADO","555555555");
		obj.cambiaValor("FECHA_INICIO","sdfgfsd@hotmail.com");
		obj.cambiaValor("FECHA_FIN","sdfgfsd@hotmail.com");
		obj.cambiaValor("PRECIO","sdfgfsd@hotmail.com");
		
		System.out.println(obj.dameValor("IDISCURSO"));
		System.out.println(obj.dameValor("ISPROFESOR_ISUSUARIO_DNI"));
		System.out.println(obj.dameValor("ISAREA_IDISAREA"));
		System.out.println(obj.dameValor("NOMBRE"));
		System.out.println(obj.dameValor("NUMERO_PLAZAS"));
		System.out.println(obj.dameValor("ESTADO"));
		System.out.println(obj.dameValor("FECHA_INICIO"));
		System.out.println(obj.dameValor("FECHA_FIN"));
		System.out.println(obj.dameValor("PRECIO"));
	
		obj.inicializar();
		System.out.println(obj.dameValor("IDISCURSO"));
		System.out.println(obj.dameValor("ISPROFESOR_ISUSUARIO_DNI"));
		System.out.println(obj.dameValor("ISAREA_IDISAREA"));
		System.out.println(obj.dameValor("NOMBRE"));
		System.out.println(obj.dameValor("NUMERO_PLAZAS"));
		System.out.println(obj.dameValor("ESTADO"));
		System.out.println(obj.dameValor("FECHA_INICIO"));
		System.out.println(obj.dameValor("FECHA_FIN"));
		System.out.println(obj.dameValor("PRECIO"));
		*/
	
	/**
	 * PRUEBA PARA FICHA
	 */
		/*
		obj=c.crear(c.Ficha);
		obj.cambiaValor("IDISFICHA","6515615");
		obj.cambiaValor("NOTAS","aula1");
		obj.cambiaValor("ANOTACIONES","500");
		obj.cambiaValor("NOTAS_EJERCICIOS","primera planta");
		
		
		System.out.println(obj.dameValor("IDISFICHA"));
		System.out.println(obj.dameValor("NOTAS"));
		System.out.println(obj.dameValor("ANOTACIONES"));
		System.out.println(obj.dameValor("NOTAS_EJERCICIOS"));
	
		
		obj.inicializar();
		System.out.println(obj.dameValor("IDISFICHA"));
		System.out.println(obj.dameValor("NOTAS"));
		System.out.println(obj.dameValor("ANOTACIONES"));
		System.out.println(obj.dameValor("NOTAS_EJERCICIOS"));
	*/
		/**
		 * PRUEBA PARA HORARIO_HAS_AULA
		 */
		/*
		obj=c.crear(c.HorarioHasAula);
		obj.cambiaValor("ISHORARIO_IDISHORARIO","6515615");
		obj.cambiaValor("ISAULA_IDISAULA","aula1");
		obj.cambiaValor("ISCURSO_IDISCURSO","50");
		
		
		System.out.println(obj.dameValor("ISHORARIO_IDISHORARIO"));
		System.out.println(obj.dameValor("ISAULA_IDISAULA"));
		System.out.println(obj.dameValor("ISCURSO_IDISCURSO"));
		
	
		
		obj.inicializar();
		System.out.println(obj.dameValor("ISHORARIO_IDISHORARIO"));
		System.out.println(obj.dameValor("ISAULA_IDISAULA"));
		System.out.println(obj.dameValor("ISCURSO_IDISCURSO"));
		*/
		
		/**
		 * PRUEBA PARA HORARIO
		 */
		/*
		obj=c.crear(c.Horario);
		obj.cambiaValor("IDISHORARIO","50888888");
		obj.cambiaValor("LUNES","20/06/96");
		obj.cambiaValor("MARTES","20/6/98");
		obj.cambiaValor("MIERCOLES","averisa");
		obj.cambiaValor("JUEVES","sgfsdgfsdfg");
		obj.cambiaValor("VIERNES","activo");
		
		
		System.out.println(obj.dameValor("IDISHORARIO"));
		System.out.println(obj.dameValor("LUNES"));
		System.out.println(obj.dameValor("MARTES"));
		System.out.println(obj.dameValor("MIERCOLES"));
		System.out.println(obj.dameValor("JUEVES"));
		System.out.println(obj.dameValor("VIERNES"));
		
		
		obj.inicializar();
		System.out.println(obj.dameValor("IDISHORARIO"));
		System.out.println(obj.dameValor("LUNES"));
		System.out.println(obj.dameValor("MARTES"));
		System.out.println(obj.dameValor("MIERCOLES"));
		System.out.println(obj.dameValor("JUEVES"));
		System.out.println(obj.dameValor("VIERNES"));
		*/
		/**
		 * PRUEBA PARA NOMINA
		 */
		/*
		obj=c.crear(c.Nomina);
		obj.cambiaValor("IDISNOMINA","6515615");
		obj.cambiaValor("CUENTA_INGRESOS","aulad1");
		obj.cambiaValor("CANTIDAD","50");
		
		
		System.out.println(obj.dameValor("IDISNOMINA"));
		System.out.println(obj.dameValor("CUENTA_INGRESOS"));
		System.out.println(obj.dameValor("CANTIDAD"));
		
	
		
		obj.inicializar();
		System.out.println(obj.dameValor("IDISNOMINA"));
		System.out.println(obj.dameValor("CUENTA_INGRESOS"));
		System.out.println(obj.dameValor("CANTIDAD"));
		*/
		
		/**
		 * PRUEBA PARA USUARIO
		 */
		/*
		obj=c.crear(c.Usuario);
		obj.cambiaValor("DNI","6515615");
		obj.cambiaValor("CONTRASENIA","aula2");
		obj.cambiaValor("PERFIL","506");
		
		
		System.out.println(obj.dameValor("DNI"));
		System.out.println(obj.dameValor("CONTRASENIA"));
		System.out.println(obj.dameValor("PERFIL"));
		
	
		
		obj.inicializar();
		System.out.println(obj.dameValor("DNI"));
		System.out.println(obj.dameValor("CONTRASENIA"));
		System.out.println(obj.dameValor("PERFIL"));
		*/
	}

}
