package subSistemaBBDD;
import subSistemaBBDD.Creadores;
import beans.*;
import subSistemaBBDD.esquemaBBDD.*;
import subSistemaBBDD.objetoBaseDatos.*;
import subSistemaBBDD.objetoCriterio.*;
import beans.listaObjetoBeans.*;
import subSistemaBBDD.listaObjeto.*;
import subSistemaBBDD.utils.*;



/**
 * Se trata de una clase fachada que proporcionará todos las peticiones de los clientes 
 * que necesiten acceder a la Base de Datos de la academia. De esta manera ofrecemos una 
 * interfaz sencilla para el subSistemaBBDD y ocultamos a los clientes los componentes 
 * del subsistema.
 * Se utiliza un patrón de creación Singleton para esta clase, solo necesitamos un 
 * objeto que será el encargado de delegar en los objetos del subsitema 
 * las peticiones de los clientes.
 * 
 * @author JORGE SANCHEZ MUSULIN
 *
 */
public class BBDDFachada {
	/**
	 * 
	 */
	private static BBDDFachada ejemplar = null;
	private Creadores creador;
	private String nombreBD;
	private String usuarioBD;
	private String password;
	private String url;
	
	/**
	 * 
	 *
	 */
	private BBDDFachada(){
		
		
	}
	/**
	 * 
	 * @return
	 */
	public static BBDDFachada getInstance() {
		if ( ejemplar == null ) {
			ejemplar = new BBDDFachada();
			ejemplar.creador = new Creadores();
			ejemplar.nombreBD="prueba";
			ejemplar.usuarioBD="root";
			ejemplar.password="adminwww";
			ejemplar.url="jdbc:mysql://localhost/"+ ejemplar.nombreBD;
		}
		return ejemplar;
	}
	private EsquemaBBDD crearTablaAdecuada(ObjetoBBDD entidadBBDD) throws Exception{
		if (entidadBBDD instanceof IsAlumno){
			EsquemaBBDD tablaAlumno= creador.getCreadorEsquema().crear(creador.getCreadorEsquema().EsqIsalumno);
			return tablaAlumno;
		}
		else if(entidadBBDD instanceof IsArea){
			EsquemaBBDD tablaArea= creador.getCreadorEsquema().crear(creador.getCreadorEsquema().EsqIsarea);
			return tablaArea; 
		}
		else if (entidadBBDD instanceof IsAula){
			EsquemaBBDD tablaAula= creador.getCreadorEsquema().crear(creador.getCreadorEsquema().EsqIsaula);
			return tablaAula;
		}
		else if (entidadBBDD instanceof IsAvisos){
			EsquemaBBDD tablaAviso= creador.getCreadorEsquema().crear(creador.getCreadorEsquema().EsqIsavisos);
			return tablaAviso;
		}
		else if (entidadBBDD instanceof IsAvisos_Has_IsUsuario ){
			EsquemaBBDD tablaAvisoUsuario= creador.getCreadorEsquema().crear(creador.getCreadorEsquema().EsqIsavisosHasIsuario);
			return tablaAvisoUsuario;
		}
		else if (entidadBBDD instanceof IsContrato ){
			EsquemaBBDD tablaContrato= creador.getCreadorEsquema().crear(creador.getCreadorEsquema().EsqIscontrato);
			return tablaContrato;
		}
		else if (entidadBBDD instanceof IsCurso ){
			EsquemaBBDD tablaCurso= creador.getCreadorEsquema().crear(creador.getCreadorEsquema().EsqIscurso);
			return tablaCurso;
		}
		else if (entidadBBDD instanceof IsCurso_Has_IsAlumno ){
			EsquemaBBDD tablaCursoAlumno= creador.getCreadorEsquema().crear(creador.getCreadorEsquema().EsqIscursoHasIsalumno);
			return tablaCursoAlumno;
		}
		else if (entidadBBDD instanceof IsFicha ){
			EsquemaBBDD tablaFicha= creador.getCreadorEsquema().crear(creador.getCreadorEsquema().EsqIsficha);
			return tablaFicha;
		}
		else if (entidadBBDD instanceof IsHorario_Has_IsAula ){
			EsquemaBBDD tablaHorarioAula= creador.getCreadorEsquema().crear(creador.getCreadorEsquema().EsqIshorarioHasIsaula);
			return tablaHorarioAula;
		}
		else if (entidadBBDD instanceof IsHorario ){
			EsquemaBBDD tablaHorario= creador.getCreadorEsquema().crear(creador.getCreadorEsquema().EsqIshorario);
			return tablaHorario;
		}
		else if (entidadBBDD instanceof IsNomina ){
			EsquemaBBDD tablaNomina= creador.getCreadorEsquema().crear(creador.getCreadorEsquema().EsqIsnomina);
			return tablaNomina;
		}
		else if (entidadBBDD instanceof IsProfesor ){
			EsquemaBBDD tablaProfesor= creador.getCreadorEsquema().crear(creador.getCreadorEsquema().EsqIsprofesor);
			return tablaProfesor;
		}
		else if (entidadBBDD instanceof IsUsuario ){
			EsquemaBBDD tablaUsuario= creador.getCreadorEsquema().crear(creador.getCreadorEsquema().EsqIsusuario);
			return tablaUsuario;
		}
		else throw new Exception("fallo en conversión a objetoBBDD");
	
	}
	
	private ObjetoCriterio crearObjetoCriterioAdecuado(ObjetoBBDD entidadBBDD)throws Exception{
		if (entidadBBDD instanceof IsAlumno){
			ObjetoCriterio alumno=creador.getCreadorObjetoCriterio().crear(creador.getCreadorObjetoCriterio().ObjetoCriterioIsalumno); 
			alumno= alumno.convertir(entidadBBDD);
			return alumno;
		}
		else if(entidadBBDD instanceof IsArea){
			ObjetoCriterio area= creador.getCreadorObjetoCriterio().crear(creador.getCreadorObjetoCriterio().ObjetoCriterioIsarea);
			area= area.convertir(entidadBBDD);
			return area; 
		}
		else if (entidadBBDD instanceof IsAula){
			ObjetoCriterio aula= creador.getCreadorObjetoCriterio().crear(creador.getCreadorObjetoCriterio().ObjetoCriterioIsaula);
			aula= aula.convertir(entidadBBDD);
			return aula;
		}
		else if (entidadBBDD instanceof IsAvisos){
			ObjetoCriterio aviso= creador.getCreadorObjetoCriterio().crear(creador.getCreadorObjetoCriterio().ObjetoCriterioIsavisos);
			aviso= aviso.convertir(entidadBBDD);
			return aviso;
		}
		else if (entidadBBDD instanceof IsAvisos_Has_IsUsuario ){
			ObjetoCriterio avisoUsuario= creador.getCreadorObjetoCriterio().crear(creador.getCreadorObjetoCriterio().ObjetoCriterioIsavisosHasIsuario);
			avisoUsuario= avisoUsuario.convertir(entidadBBDD);
			return avisoUsuario;
		}
		else if (entidadBBDD instanceof IsContrato ){
			ObjetoCriterio contrato= creador.getCreadorObjetoCriterio().crear(creador.getCreadorObjetoCriterio().ObjetoCriterioIscontrato);
			contrato= contrato.convertir(entidadBBDD);
			return contrato;
		}
		else if (entidadBBDD instanceof IsCurso ){
			ObjetoCriterio curso= creador.getCreadorObjetoCriterio().crear(creador.getCreadorObjetoCriterio().ObjetoCriterioIscurso);
			curso= curso.convertir(entidadBBDD);
			return curso;
		}
		else if (entidadBBDD instanceof IsCurso_Has_IsAlumno ){
			ObjetoCriterio cursoAlumno= creador.getCreadorObjetoCriterio().crear(creador.getCreadorObjetoCriterio().ObjetoCriterioIscursoHasIsalumno);
			cursoAlumno= cursoAlumno.convertir(entidadBBDD);
			return cursoAlumno;
		}
		else if (entidadBBDD instanceof IsFicha ){
			ObjetoCriterio ficha= creador.getCreadorObjetoCriterio().crear(creador.getCreadorObjetoCriterio().ObjetoCriterioIsuficha);
			ficha= ficha.convertir(entidadBBDD);
			return ficha;
		}
		else if (entidadBBDD instanceof IsHorario_Has_IsAula ){
			ObjetoCriterio horarioAula= creador.getCreadorObjetoCriterio().crear(creador.getCreadorObjetoCriterio().ObjetoCriterioIshorarioHasIsaula);
			horarioAula= horarioAula.convertir(entidadBBDD);
			return horarioAula;
		}
		else if (entidadBBDD instanceof IsHorario ){
			ObjetoCriterio horario= creador.getCreadorObjetoCriterio().crear(creador.getCreadorObjetoCriterio().ObjetoCriterioIshorario);
			horario= horario.convertir(entidadBBDD);
			return horario;
		}
		else if (entidadBBDD instanceof IsNomina ){
			ObjetoCriterio nomina= creador.getCreadorObjetoCriterio().crear(creador.getCreadorObjetoCriterio().ObjetoCriterioIsnomina);
			nomina= nomina.convertir(entidadBBDD);
			return nomina;
		}
		else if (entidadBBDD instanceof IsProfesor ){
			ObjetoCriterio profesor= creador.getCreadorObjetoCriterio().crear(creador.getCreadorObjetoCriterio().ObjetoCriterioIsprofesor);
			profesor= profesor.convertir(entidadBBDD);
			return profesor;
		}
		else if (entidadBBDD instanceof IsUsuario ){
		ObjetoCriterio usuario= creador.getCreadorObjetoCriterio().crear(creador.getCreadorObjetoCriterio().ObjetoCriterioIsusuario);
			usuario= usuario.convertir(entidadBBDD);
			return usuario;
		}
		else throw new Exception("fallo en conversión a objetoCriterio");
		
	}
	
	/**
	 * Nos sirve para inicializar los valores de un EsquemaBBDD con el objetivo de poder
	 * acceder a la base de datos que contiene el EsquemaBBDD, fijando el nombre de la BD, el login, contraseña...
	 * 
	 * @param tabla, la tabla que queremos inicializar
	 * @return la tabla con sus atributos inicializados al valor adecuado para conectar a la BD.
	 */
	private EsquemaBBDD inicializaTabla(EsquemaBBDD tabla){
		tabla.setBd(this.nombreBD);tabla.setLogin(this.usuarioBD);tabla.setPassword(this.password);
		tabla.setUrl(this.url);
		return tabla;
	}
	
	
	public boolean editar (ObjetoBean entidad){
		try{
			ObjetoBBDD entidadBBDD= ConversorBeanBBDD.convierteBeanABBDD(entidad);
			EsquemaBBDD tablaAdecuada= this.crearTablaAdecuada(entidadBBDD);
			ObjetoCriterio entidadCriterio= this.crearObjetoCriterioAdecuado(entidadBBDD);
			boolean result= this.inicializaTabla(tablaAdecuada).editar(entidadCriterio);
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean insertar (ObjetoBean entidad){
		try{		
		ObjetoBBDD entidadBBDD=ConversorBeanBBDD.convierteBeanABBDD(entidad);
		//Creamos una tabla adecuada donde insertar entidadBBDD 
		EsquemaBBDD tablaAdecuada= this.crearTablaAdecuada(entidadBBDD);
		boolean result=this.inicializaTabla(tablaAdecuada).insertar(entidadBBDD);
		return result;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
			
		
	}
	
	public boolean eliminar(ObjetoBean entidad){
		try{
			ObjetoBBDD entidadBBDD= ConversorBeanBBDD.convierteBeanABBDD(entidad);
			EsquemaBBDD tablaAdecuada= this.crearTablaAdecuada(entidadBBDD);
			ObjetoCriterio entidadCriterio= this.crearObjetoCriterioAdecuado(entidadBBDD);
			boolean result = this.inicializaTabla(tablaAdecuada).borrar(entidadCriterio);
			return result;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
			
		
	}
	
	public ListaObjetoBean consultar(ObjetoBean entidad){
		try{
			ObjetoBBDD entidadBBDD= ConversorBeanBBDD.convierteBeanABBDD(entidad);
			EsquemaBBDD tablaAdecuada= this.crearTablaAdecuada(entidadBBDD);
			ObjetoCriterio entidadCriterio= this.crearObjetoCriterioAdecuado(entidadBBDD);
			ListaObjetoBBDD resultBBDD=(ListaObjetoBBDD) this.inicializaTabla(tablaAdecuada).consultar(entidadCriterio);
			ListaObjetoBean resultBean=ConversorBeanBBDD.convierteListaBBDD(resultBBDD);
			return resultBean;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
			
		
	}
	/**
	 * 
	 * Este método sirve para autentificar un usuario que se le pasa 
	 * como parámetro, si el dni del usuario y la contraseña coinciden
	 * con los datos de la base de datos para ese usuario, se devuelve cierto.
	 * @param usuario Debe ser un bean de tipo Usuario. El usuario a comprobar.
	 * 
	 * @return true si el usuario es válido en el sistema,es decir
	 * tiene un ID_ISUSUARIO_DNI y un USUARIO_CONTRASENIA válido  
	 */
	
	public boolean usuarioValido(ObjetoBean usuario){
		try{
			
			ObjetoBBDD entidadBBDD= ConversorBeanBBDD.convierteBeanABBDD(usuario);
			EsquemaBBDD tablaAdecuada= this.crearTablaAdecuada(entidadBBDD);
			ObjetoCriterio entidadCriterio= this.crearObjetoCriterioAdecuado(entidadBBDD);
			if(!entidadCriterio.dameValor(Constantes.ID_ISUSUARIO_DNI).equals("") && 
					!entidadCriterio.dameValor(Constantes.USUARIO_CONTRASENIA).equals("")) {
				ListaObjetoBBDD resultBBDD=(ListaObjetoBBDD) this.inicializaTabla(tablaAdecuada).consultar(entidadCriterio);
				if (!resultBBDD.esVacio())
					return true;
				else{
					System.out.println("Usuario o contraseña no válido");
					return false;
				}
					
			}
			else{
				System.out.println("debe introducir login y contraseñs");
				return false;
				
			}
		}
		catch (Exception e){
			e.printStackTrace();
				return false;
		}
	}
	
	/**
	 * Este método devuelve el perfil asociado a un usuario
	 * @param usuario, el usuario del cual buscar el perfil
	 * @return el perfil del usuario si existe, si no la cadena vacía.
	 */
	
	public String damePerfilUsuario (ObjetoBean usuario){
		try{
			ObjetoBBDD entidadBBDD= ConversorBeanBBDD.convierteBeanABBDD(usuario);
			EsquemaBBDD tablaAdecuada= this.crearTablaAdecuada(entidadBBDD);
			ObjetoCriterio entidadCriterio= this.crearObjetoCriterioAdecuado(entidadBBDD);
			ListaObjetoBBDD resultConsulta =(ListaObjetoBBDD) this.inicializaTabla(tablaAdecuada).consultar(entidadCriterio);
			if(!resultConsulta.esVacio()){
				ObjetoBBDD usuarioBBDD= resultConsulta.dameObjeto(0);
				return usuarioBBDD.dameValor(Constantes.USUARIO_PERFIL);
			}
			else{
				System.out.println("El usuario no existe");
				return "";
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return "";
		}
			
	}
	/**
	 * Devuelve el numero de plazas libre de un curso.
	 * @param curso, el curso a consultar
	 * @return Numero de plazas libres del curso si este existe, -1 en otro caso
	 */
	public int numPlazasEnCurso (ObjetoBean curso){
		try{
			ObjetoBBDD entidadBBDD= ConversorBeanBBDD.convierteBeanABBDD(curso);
			EsquemaBBDD tablaAdecuada= this.crearTablaAdecuada(entidadBBDD);
			ObjetoCriterio entidadCriterio= this.crearObjetoCriterioAdecuado(entidadBBDD);
			ListaObjetoBBDD resultConsulta =(ListaObjetoBBDD) this.inicializaTabla(tablaAdecuada).consultar(entidadCriterio);
			if (resultConsulta.tamaño()==1)
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
		criterioCurso.convertir(curso);
		EsquemaBBDD tablaAdecuada= this.crearTablaAdecuada(curso);
		ListaObjetoBBDD resultConsulta =(ListaObjetoBBDD) this.inicializaTabla(tablaAdecuada).consultar(criterioCurso);
		return ConversorBeanBBDD.convierteListaBBDD(resultConsulta);
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
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
			criterioProfesor.convertir(profesor);
			EsquemaBBDD tablaAdecuada= this.crearTablaAdecuada(profesor);
			ListaObjetoBBDD resultConsulta =(ListaObjetoBBDD) this.inicializaTabla(tablaAdecuada).consultar(criterioProfesor);
			return ConversorBeanBBDD.convierteListaBBDD(resultConsulta);
			}
			catch (Exception e){
				e.printStackTrace();
				return null;
			}
		
	}
	
	
	public ListaObjetoBean dameAulasDisponible(){
		CreadorObjetoCriterio creadorCriterio=this.creador.getCreadorObjetoCriterio();
		ObjetoCriterio criterioAula = creadorCriterio.crear(creadorCriterio.ObjetoCriterioIsaula);
		CreadorEsquemaBBDD creadorAulas = this.creador.getCreadorEsquema();
		EsquemaBBDD tablaAula =creadorAulas.crear(creadorAulas.EsqIsaula);
		ListaObjetoBBDD result= this.inicializaTabla(tablaAula).consultar(criterioAula);
		return ConversorBeanBBDD.convierteListaBBDD(result);
	}
	
	/**
	 * Devuelve una lista de todas las areas existentes en el sistema, 
	 * para por ejemplo a la hora de añadir un curso saber que areas están
	 * abiertas para asociarle una al curso
	 * @return, la lista de areas disponibles.
	 */
	public ListaObjetoBean dameAreasDisponible(){
		CreadorObjetoCriterio creadorCriterio=this.creador.getCreadorObjetoCriterio();
		ObjetoCriterio criterioArea = creadorCriterio.crear(creadorCriterio.ObjetoCriterioIsarea);
		CreadorEsquemaBBDD creadorAreas = this.creador.getCreadorEsquema();
		EsquemaBBDD tablaAreas =creadorAreas.crear(creadorAreas.EsqIsarea);
		ListaObjetoBBDD result= this.inicializaTabla(tablaAreas).consultar(criterioArea);
		return ConversorBeanBBDD.convierteListaBBDD(result);
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
			return (this.inicializaTabla(tablaCursos).consultar(criterioCurso).tamaño() !=0);
			
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}		
	}
	
	/**
	 * Sirve para obtener todas las aulas que están libres en un
	 * horario dado.
	 * @param horario, el horario que fija las aula que estoy buscando
	 * @return una lista de aulas libres en el horario dado.
	 */
	
	
	public ListaObjetoBean dameAulasLibres(ObjetoBean horario){
		try{
			CreadorObjetoBBDD creadorAulaHorario= this.creador.getCreadorObjetoBBDD();			
			ObjetoBBDD aulaHorario = creadorAulaHorario.crear(creadorAulaHorario.IshorarioHasIsaula);
			aulaHorario.cambiaValor(Constantes.ID_HAS_ISHORARIO_IDISHORARIO, horario.dameValor(Constantes.ID_ISHORARIO));
			ObjetoCriterio critAulaHorario = this.creador.getCreadorObjetoCriterio().crear(this.creador.getCreadorObjetoCriterio().ObjetoCriterioIshorarioHasIsaula);
			critAulaHorario.convertir(aulaHorario);
			CreadorEsquemaBBDD creadorTablaAulaHorario = this.creador.getCreadorEsquema();
			EsquemaBBDD tablaAulaHorario= creadorTablaAulaHorario.crear(creadorTablaAulaHorario.EsqIshorarioHasIsaula);
			//Obtengo una lista de Beans HorarioAula con codigo de las aulas que tienen el horario pasado como parametro ocupado.
			ListaObjetoBean aulasOcupadasHorario = ConversorBeanBBDD.convierteListaBBDD(this.inicializaTabla(tablaAulaHorario).consultar(critAulaHorario));
			//Obtengo una lista de todas las aulas que hay en el sistema
			ListaObjetoBean aulasDisponibles =this.dameAulasDisponible();
			ListaObjetoBean aulasLibresHorario= new ListaObjetoBean();
			//Inserto las aula disponibles que no están ocupadas en el horario dado en aulasLibresHorario;
			int index=0;
		
			for (int i=0;i<aulasDisponibles.tamanio();i++){
				boolean condicion=true;
				for (int j=0;j<aulasOcupadasHorario.tamanio()&& condicion;j++){
					String codAula=aulasDisponibles.dameObjeto(i).dameValor(Constantes.ID_ISAULA);
					String codAulaOcupada= aulasOcupadasHorario.dameObjeto(j).dameValor(Constantes.ID_HAS_ISAULA_IDISAULA);
					condicion=!codAulaOcupada.equals(codAula);
				}
				if(condicion){
					aulasLibresHorario.insertar(index,aulasDisponibles.dameObjeto(i));
					index++;
				}	
			}
			return aulasLibresHorario;
			
		}
		catch (Exception e){
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
			//Obtengo una lista de objetos isHorario_has_isAula que me da una lista de ternas
			//(codHorario,codAula,CodCurso) que me relaciona en que aulas se da cada curso y en que horario, fijo como patron de 
			//busqueda el codHorario del horario que me dan como parámetro y asi tendré las aulas y los cursos que tienen ese 
			//horario ocupado.
			CreadorObjetoBBDD creadorObjetoBBDD= this.creador.getCreadorObjetoBBDD();			
			ObjetoBBDD aulaHorario = creadorObjetoBBDD.crear(creadorObjetoBBDD.IshorarioHasIsaula);
			aulaHorario.cambiaValor(Constantes.ID_HAS_ISHORARIO_IDISHORARIO, horario.dameValor(Constantes.ID_ISHORARIO));
			ObjetoCriterio critAulaHorario = this.creador.getCreadorObjetoCriterio().crear(this.creador.getCreadorObjetoCriterio().ObjetoCriterioIshorarioHasIsaula);
			critAulaHorario.convertir(aulaHorario);
			CreadorEsquemaBBDD creadorTablaAulaHorario = this.creador.getCreadorEsquema();
			EsquemaBBDD tablaAulaHorario= creadorTablaAulaHorario.crear(creadorTablaAulaHorario.EsqIshorarioHasIsaula);
			//Obtengo una lista de Beans HorarioAula con codigo de las aulas y codigo de los cursos que tienen el horario pasado como parametro ocupado.
			ListaObjetoBean cursosOcupadosHorario = ConversorBeanBBDD.convierteListaBBDD(this.inicializaTabla(tablaAulaHorario).consultar(critAulaHorario));
			  
			//Obtengo los codigos de los cursos que tienen el horario dado ocupado
			ObjetoBBDD curso= creadorObjetoBBDD.crear(creadorObjetoBBDD.Iscurso);
			//Obtengo para cada curso que se da en el horario dado, el profesor que lo da.
			ListaObjetoBean profesoresOcupados = new ListaObjetoBean();
			ObjetoCriterio criterioCursosOcupados = this.creador.getCreadorObjetoCriterio().crear(this.creador.getCreadorObjetoCriterio().ObjetoCriterioIscurso);
			EsquemaBBDD tablaCursos= creadorTablaAulaHorario.crear(creadorTablaAulaHorario.EsqIscurso);
			for (int i=0;i<cursosOcupadosHorario.tamanio();i++){
				curso.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO,cursosOcupadosHorario.dameObjeto(i).
						dameValor(Constantes.ISHORARIO_HAS_ISAULA_ISCURSO_IDISCURSO ));
				criterioCursosOcupados.inicializar();
				criterioCursosOcupados.convertir(curso);
				//Esta lista solo tendrá un elemento puesto que el criterio de busqueda que fijo es la clave de la tabla.
				ListaObjetoBean cursosOcupados = ConversorBeanBBDD.convierteListaBBDD(this.inicializaTabla(tablaCursos).consultar(criterioCursosOcupados));
				ObjetoBean cursoOcupado = cursosOcupados.dameObjeto(0);						
				ObjetoBBDD profesor = creadorObjetoBBDD.crear(creadorObjetoBBDD.Isprofesor);
				profesor.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI,cursoOcupado.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI));
				ObjetoCriterio critProfesor = this.creador.getCreadorObjetoCriterio().crear(this.creador.getCreadorObjetoCriterio().ObjetoCriterioIsprofesor);
				critProfesor.convertir(profesor);
				EsquemaBBDD tablaprofesor= creadorTablaAulaHorario.crear(creadorTablaAulaHorario.EsqIsprofesor);
				//Esta lista solo tendrá un elemento puesto que el criterio de busqueda que fijo es la clave de la tabla.
				ListaObjetoBean profesoresOcupadosHorario = ConversorBeanBBDD.convierteListaBBDD(this.inicializaTabla(tablaprofesor).consultar(critProfesor));
				ObjetoBean profesorOcupadoHorario = profesoresOcupadosHorario.dameObjeto(0);
				//Meto el profesor ocupado en la lista de profesores ocupados				
				profesoresOcupados.insertar(profesoresOcupados.tamanio(),profesorOcupadoHorario);
			}
//			Obtengo todos los profesores que hay en el sistema
			ListaObjetoBean listaProfesores= this.dameProfesoresDisponibles();
			ListaObjetoBean profesoresLibresHorario= new ListaObjetoBean();
			//Elimino de la lista de profesores en el sistema los que tengan el horario dado ocupado.
			boolean continuar;
			for (int i=0;i<listaProfesores.tamanio();i++){
				continuar=true;
				for(int j=0;j<profesoresOcupados.tamanio() && continuar;j++){
					continuar=!listaProfesores.dameObjeto(i).dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI).
					equals(profesoresOcupados.dameObjeto(j).dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI));
					
				}	
				if(continuar){
					profesoresLibresHorario.insertar(profesoresLibresHorario.tamanio(),listaProfesores.dameObjeto(i));
				}
			}
				
			
			//Busco en isCurso que profesores dan los cursosOcupadosHorario con lo que tendré lo profesores que tienen ese horario ocupado
			return profesoresLibresHorario;
				
		}
		catch (Exception e){
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
		ObjetoCriterio critCursoAlumno = this.creador.getCreadorObjetoCriterio().crear(this.creador.getCreadorObjetoCriterio().ObjetoCriterioIscursoHasIsalumno);
		
		critCursoAlumno.convertir(cursoAlumno);
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
	 * Metodo que sea utiliza cuando un profesor quiere publicar las notas del curso que se pasa como parámetro
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
		return exito;
	}
	
	/**
	 * Dado un profesor y un alumno, devuelve la ficha del alumno para el curso impartido por el profesor.
	 * @param alumno
	 * @param profesor
	 * @return
	 */
	//public ObjetoBean dameFichaAlumno(ObjetoBean alumno, ObjetoBean profesor)
	
	public ObjetoBean dameAreaCurso(ObjetoBean curso){
		CreadorBean creadorBean = new CreadorBean();
		ObjetoBean area= creadorBean.crear(creadorBean.Area);
		area.cambiaValor(Constantes.ID_ISAREA,curso.dameValor(Constantes.CURSO_ISAREA_IDISAREA));
		ListaObjetoBean areasCurso=this.consultar(area);
		ObjetoBean areaCurso = areasCurso.dameObjeto(0);
		System.out.println("salen "+ areasCurso.tamanio());
		return areaCurso;
		
	}
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
	public ObjetoBean dameProfesorCurso(ObjetoBean curso){
		CreadorBean creadorBean = new CreadorBean();
		ObjetoBean profesor= creadorBean.crear(creadorBean.Profesor);
		profesor.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI,curso.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI));
		ListaObjetoBean profesoresCurso=this.consultar(profesor);
		ObjetoBean profesorCurso = profesoresCurso.dameObjeto(0);
		System.out.println("salen "+ profesoresCurso.tamanio());
		return profesorCurso;
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
	 * Devuelve una lista de avisos para el usuario que se pasa por parametro.
	 * @param beanUsuario
	 * @return
	 */
	public ListaObjetoBean dameAvisosUsuario(ObjetoBean usuario){
		CreadorBean creadorBean = new CreadorBean();
		CreadorListaObjetoBean creadorListaBean = new CreadorListaObjetoBean();
		ObjetoBean avisoUsuario= creadorBean.crear(creadorBean.AvisosHasUario);
		avisoUsuario.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,usuario.dameValor(Constantes.ID_ISUSUARIO_DNI));
		ListaObjetoBean avisosUsuario= this.consultar(avisoUsuario);
		//aqui guardaremos los bean avisos correspondientes al usuario
		ListaObjetoBean avisos = creadorListaBean.crear();
		
		for (int i=0;i <avisosUsuario.tamanio();i++){
			ObjetoBean avisoBuscado = creadorBean.crear(creadorBean.Avisos);
			avisoBuscado.cambiaValor(Constantes.ID_ISAVISOS,avisosUsuario.dameObjeto(i).dameValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO));
			ObjetoBean avisoUsu =this.consultar(avisoBuscado).dameObjeto(0);
			avisos.insertar(avisos.tamanio(),avisoUsu);		
		}
		return avisos;
	}
	
	
	//prueba dameAvisosUsuario
	public static void main(String[] args) {
	BBDDFachada mia = BBDDFachada.getInstance();
	CreadorBean creador = new CreadorBean();
	ObjetoBean usuario =creador.crear(creador.Usuario);
	usuario.cambiaValor(Constantes.ID_ISUSUARIO_DNI,"50100000");
	ListaObjetoBean listaAvisos = mia.dameAvisosUsuario(usuario);
	for (int i=0;i<listaAvisos.tamanio();i++){
		System.out.println(listaAvisos.dameObjeto(i).dameValor(Constantes.AVISOS_ASUNTO));
	}
	
	
	
	
	}
	
	//prueba dameHorarioCurso;
	/*public static void main(String[] args) {
		BBDDFachada mia = BBDDFachada.getInstance();
		CreadorBean creador = new CreadorBean();
		ObjetoBean curso =creador.crear(creador.Curso);
		curso.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO,"2");
		ObjetoBean cursos = mia.consultar(curso).dameObjeto(0);
		ObjetoBean aula=mia.dameHorarioCurso(cursos);
		System.out.println(aula.dameValor(Constantes.ID_ISHORARIO));
		
		
		
	}/*
	
	
	/*public static void main(String[] args) {
	BBDDFachada mia = BBDDFachada.getInstance();
	CreadorBean creador = new CreadorBean();
	ObjetoBean curso =creador.crear(creador.Curso);
	curso.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO,"2");
	ObjetoBean cursos = mia.consultar(curso).dameObjeto(0);
	ObjetoBean area=mia.dameAreaCurso(cursos);
	System.out.println(area.dameValor(Constantes.AREA_NOMBRE));
	System.out.println(area.dameValor(Constantes.ID_ISAREA));
	
	
	}*/
	
	
	/*public Vector consultarNotasAlumnos(Bean profesor){
		Vector alumnoNota = new Vector();
		Bean curso
		ListaBeans cursosProfesor= this.consultar()
		
	}*/
	
	//prueba publicarNotas
	/*public static void main(String[] args) {
		BBDDFachada mia = BBDDFachada.getInstance();
		CreadorBean creador = new CreadorBean();
		ObjetoBean curso =creador.crear(creador.Curso);
		curso.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO,"2");
		boolean result = mia.publicarNota(curso);
		System.out.println(result);
		
	}*/
	
	
	//prueba dameCursosActivos
	/*public static void main(String[] args) {
		BBDDFachada mia = BBDDFachada.getInstance();
		CreadorBean creador = new CreadorBean();
		ObjetoBean profesor =creador.crear(creador.Profesor);
		profesor.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI,"50000000");
		ListaObjetoBean listaCursos = mia.dameCursosActivos(profesor);
		for (int i=0;i<listaCursos.tamanio();i++){
			System.out.println(listaCursos.dameObjeto(i).dameValor(Constantes.ALUMNO_NOMBRE));
		}
		
	}*/
	
	//prueba dameAlumnosCurso
	/*public static void main(String[] args) {
		BBDDFachada mia = BBDDFachada.getInstance();
		CreadorBean creador = new CreadorBean();
		ObjetoBean curso =creador.crear(creador.Curso);
		curso.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO,"2");
		ListaObjetoBean listaAlumnos = mia.dameAlumnosCurso(curso);
		for (int i=0;i<listaAlumnos.tamaño();i++){
			System.out.println(listaAlumnos.dameObjeto(i).dameValor(Constantes.ALUMNO_NOMBRE));
		}
		
	}*/
	
	/*Prueba dameAulasLibres
	public static void main(String[] args) {
		BBDDFachada mia = BBDDFachada.getInstance();
		CreadorBean creador = new CreadorBean();
		ObjetoBean horario =creador.crear(creador.Horario);
		horario.cambiaValor(Constantes.ID_ISHORARIO,"100");
		ListaObjetoBean listaprofesLibres = mia.dameProfesoresLibres(horario);
		for (int i=0;i<listaprofesLibres.tamaño();i++)
		System.out.println(listaprofesLibres.dameObjeto(i).dameValor(Constantes.PROFESOR_NOMBRE));
	}*/
	
	/*public static void main(String[] args) {
		BBDDFachada mia = BBDDFachada.getInstance();
		CreadorBean creadorCurso = new CreadorBean();
		ObjetoBean isCurso=creadorCurso.crear(creadorCurso.Curso);
		isCurso.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO,"1400");
		
		
		System.out.println(mia.cursoYaExiste(isCurso));
	}
	public static void main(String[] args) {
		BBDDFachada mia = BBDDFachada.getInstance();
		ListaObjetoBean listaProfesores = mia.dameHorariosDisponibles();
		for (int i=0;i<listaProfesores.tamaño();i++)
		System.out.println(listaProfesores.dameObjeto(i).dameValor(Constantes.ID_ISHORARIO));
	}
	/*
	public static void main(String[] args) {
		BBDDFachada mia = BBDDFachada.getInstance();
		CreadorBean mio= new CreadorBean();
		ObjetoBean area = mio.crear(mio.Area);
		area.cambiaValor(Constantes.ID_ISAREA,"1400");
		//usuario.cambiaValor(Constantes.USUARIO_PERFIL,"putilla");
		ListaObjetoBean listaProfesores = mia.dameProfesoresDeArea(area);
		for (int i=0;i<listaProfesores.tamaño();i++)
		System.out.println(listaProfesores.dameObjeto(i).dameValor(Constantes.PROFESOR_NOMBRE));
		//usuario.cambiaValor(Constantes.USUARIO_PERFIL,"putilla");
		//System.out.print(mia.usuarioValido(usuario));
		//ObjetoBean mioBean = mio.crear(mio.Avisos);
		//mioBean.cambiaValor(Constantes.ID_ISAVISOS,"1400");
		/*ListaObjetoBean listaAlumno = mia.consultar(mioBean);
		if (!listaAlumno.esVacio()){
			ObjetoBean nuevoCambio = listaAlumno.dameObjeto(0);
			nuevoCambio.cambiaValor(Constantes.AVISOS_ASUNTO,"cambiado");
			mia.editar(nuevoCambio);
			System.out.print("hola bola");
		}
		else
		//System.out.println("la lista esta vacia");
		
		System.exit(0);

	}
	/*public static void main(String[] args){
		BBDDFachada mia = BBDDFachada.getInstance();
		CreadorBean mio= new CreadorBean();
		ObjetoBean usuario = mio.crear(mio.Usuario);
		//usuario.cambiaValor(Constantes.ID_ISUSUARIO_DNI,"50000000");
		//usuario.cambiaValor(Constantes.USUARIO_CONTRASENIA,"pssword");
		//usuario.cambiaValor(Constantes.USUARIO_PERFIL,"putilla");
		System.out.println(mia.damePerfilUsuario(usuario));
	}*/
	/*public static void main(String[] args){
	BBDDFachada mia = BBDDFachada.getInstance();
	CreadorBean mio= new CreadorBean();
	ObjetoBean curso = mio.crear(mio.Curso);
	curso.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO,"1400");
	//usuario.cambiaValor(Constantes.USUARIO_CONTRASENIA,"pssword");
	//usuario.cambiaValor(Constantes.USUARIO_PERFIL,"putilla");
	System.out.println(mia.numPlazasEnCurso(curso));
	}*/
	 /*Prueba de consultarCursosProfesor
	public static void main(String[] args){
		BBDDFachada mia = BBDDFachada.getInstance();
		CreadorBean mio= new CreadorBean();
		ObjetoBean profesor = mio.crear(mio.Profesor);
		profesor.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI,"50000000");
		ListaObjetoBean cursosProfe = mia.consultarCursosProfesor(profesor);
		System.out.println(cursosProfe.dameObjeto(0).dameValor(Constantes.CURSO_NOMBRE));
		
		
	}*/
	
	

}
