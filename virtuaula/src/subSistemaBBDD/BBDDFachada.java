package subSistemaBBDD;
import beans.*;
import beans.listaObjetoBeans.*;
import subSistemaBBDD.Creadores;
import subSistemaBBDD.esquemaBBDD.*;
import subSistemaBBDD.objetoBaseDatos.*;
import subSistemaBBDD.objetoCriterio.*;
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
 * @author JORGE SANCHEZ
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
	public ListaObjetoBean consultarCursosProfesor(ObjetoBean profesor){
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
	/*public Vector consultarNotasAlumnos(Bean profesor){
		Vector alumnoNota = new Vector();
		Bean curso
		ListaBeans cursosProfesor= this.consultar()
		
	}*/
	
	/*public static void main(String[] args) {
		BBDDFachada mia = BBDDFachada.getInstance();
		CreadorBean mio= new CreadorBean();
		/*ObjetoBean usuario = mio.crear(mio.Usuario);
		usuario.cambiaValor(Constantes.ID_ISUSUARIO_DNI,"50000000");
		usuario.cambiaValor(Constantes.USUARIO_CONTRASENIA,"password");
		usuario.cambiaValor(Constantes.USUARIO_PERFIL,"putilla");
		System.out.print(mia.usuarioValido(usuario));
		ObjetoBean mioBean = mio.crear(mio.Avisos);
		mioBean.cambiaValor(Constantes.ID_ISAVISOS,"1400");
		ListaObjetoBean listaAlumno = mia.consultar(mioBean);
		if (!listaAlumno.esVacio()){
			ObjetoBean nuevoCambio = listaAlumno.dameObjeto(0);
			nuevoCambio.cambiaValor(Constantes.AVISOS_ASUNTO,"cambiado");
			mia.editar(nuevoCambio);
			System.out.print("hola bola");
		}
		else
			System.out.println("la lista esta vacia");
		
		System.exit(0);

	}	*/
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
	 //Prueba de consultarCursosProfesor
	public static void main(String[] args){
		BBDDFachada mia = BBDDFachada.getInstance();
		CreadorBean mio= new CreadorBean();
		ObjetoBean profesor = mio.crear(mio.Profesor);
		profesor.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI,"50000000");
		ListaObjetoBean cursosProfe = mia.consultarCursosProfesor(profesor);
		System.out.println(cursosProfe.dameObjeto(0).dameValor(Constantes.CURSO_NOMBRE));
		
		
	}
	
	

}
