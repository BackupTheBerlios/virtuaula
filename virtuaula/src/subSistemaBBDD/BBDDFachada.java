package subSistemaBBDD;
import subSistemaBBDD.Creadores;
import beans.*;
import java.util.Hashtable;
import subSistemaBBDD.esquemaBBDD.*;
import subSistemaBBDD.objetoBaseDatos.*;
import subSistemaBBDD.objetoCriterio.*;
import beans.listaObjetoBeans.*;
import subSistemaBBDD.listaObjeto.*;
import subSistemaBBDD.utils.Constantes;



/**
 * Se trata de una clase fachada que contendrá los métodos mas basicos de consulta
 * de tablas de nuestra base de datos. Esta clase será extendida por otras fachadas 
 * que realizaran consultas más especializadas y que proporcionarán en conjunto todos las peticiones de los clientes 
 * que necesiten acceder a la Base de Datos de la academia. De esta manera ofrecemos una 
 * interfaz sencilla para el subSistemaBBDD y ocultamos a los clientes los componentes 
 * del subsistema.
 * Se utiliza un patrón de creación Singleton para esta clase, y además utilizamos una tabla hash para
 * crear exactamente una sola instancia de cada clase que hereda de esta.
 * 
 * @author JORGE SANCHEZ MUSULIN
 *
 */
public class BBDDFachada {
	/**
	 * Instancia única de la clase
	 */
	private static BBDDFachada ejemplar = null;
	/**
	 * Tabla que guarda una instancia de cada una de las fachadas que extienden esta clase
	 */
	private static Hashtable singletons= new Hashtable();
	/**
	 * Tabla que asocia a cada tipo de ObjetoBBDD un número y que nos será útil para la creación
	 * de distintas instancias de objetos de este tipo. 
	 */
	private Hashtable entidadesBD= new Hashtable();
	/**
	 * creador que sirve para la creación de diferentes objetos propios del subSistemaBBDD 
	 */
	protected Creadores creador;
	/**
	 * Datos de configuración para acceder a nuestra BD
	 */
	private String nombreBD;
	private String usuarioBD;
	private String password;
	private String url;
	
/**
 * Constructor de la clase,se inicializan los atributos de conexión a nuestra base de datos.
 * También se rellena la tabla entidadesBD con los objetosBBDD presentes en nuestra BD.
 * Es protegido para que solo pueda ser utilizado por los hijos de esta clase.(patron singleton)
 */
	protected BBDDFachada(){
		this.creador = new Creadores();
		this.nombreBD="prueba";
		this.usuarioBD="root";
		this.password="adminwww";
		this.url="jdbc:mysql://localhost/"+ this.nombreBD;
		this.inicializaEntidadesBD();
		try{
	
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		
	}
	/**
	 * Inicialización de la tabla entidadesBD
	 *
	 */
	private void inicializaEntidadesBD(){
		entidadesBD.put(Constantes.objetoAlumno,new Integer(0));
		entidadesBD.put(Constantes.objetoArea,new Integer(1));
		entidadesBD.put(Constantes.objetoAula,new Integer(2));
		entidadesBD.put(Constantes.objetoAviso,new Integer(3));
		entidadesBD.put(Constantes.objetoAvisoUsuario,new Integer(4));
		entidadesBD.put(Constantes.objetoContrato,new Integer(5));
		entidadesBD.put(Constantes.objetoCurso,new Integer(6));
		entidadesBD.put(Constantes.objetoCursoAlumno,new Integer(7));
		entidadesBD.put(Constantes.objetoHorario,new Integer(8));
		entidadesBD.put(Constantes.objetoHorarioAula,new Integer(9));
		entidadesBD.put(Constantes.objetoNomina,new Integer(10));		
		entidadesBD.put(Constantes.objetoProfesor,new Integer(11));
		entidadesBD.put(Constantes.objetoUsuario,new Integer(12));
		entidadesBD.put(Constantes.objetoFicha,new Integer(13));
		
	}
	/**
	 * Este método sirve para añadir una instancia única de una de las fachadas que extienden la clase BBDDFachada
	 * a la tabla de singletons .
	 * @param nombre  nombre de la clase de la cual se quiere crear una instancia en la tabla singletons
	 * @param instanciaSubClase objeto de la clase que se incluirá en la tabla y que será único.
	 * @throws Exception se lanza si ya existe una instancia de la clase en la tabla de singletons, con esto aseguramos
	 * que solo habrá una instancia de cada una de las fachadas.
	 */
	private static void registraSingleton(String nombre,BBDDFachada instanciaSubClase)throws Exception{
		if((singletons.get(nombre)==null))
			singletons.put(nombre,instanciaSubClase);
			
		else{
			throw new Exception("Ya existe una instancia de la clase"+ instanciaSubClase.getClass());
		}
	}
	
	/**
	 * Devuelve la instancia unica de la fachada que se asocia al nombre pasado como parámetro.
	 * @param nombre  nombre de la fachada de la cual queremos obtener la instancia única.
	 * @return un objeto de la fachada adecuada.
	 */
	public BBDDFachada dameBBDDFachada(String nombre){
		return (BBDDFachada)singletons.get(nombre);
	}
	/**
	 * Devuelve la única instancia de la clase BBDDFachada además registra en la tabla
	 * de singletons un objeto de cada clase Fachada que hereda de esta.
	 * @return  un objeto de la clase BBDDFachada que es único.
	 */
	
	public static BBDDFachada getInstance() {
		if ( ejemplar == null ) {
			ejemplar = new BBDDFachada();
			try{
				BBDDFachada.registraSingleton(Constantes.FachadaAlumno,new BBDDFachadaAlumno());
				BBDDFachada.registraSingleton(Constantes.FachadaArea,new BBDDFachadaArea());
				BBDDFachada.registraSingleton(Constantes.FachadaAula,new BBDDFachadaAula());
				BBDDFachada.registraSingleton(Constantes.FachadaAviso,new BBDDFachadaAviso());
				BBDDFachada.registraSingleton(Constantes.FachadaCurso,new BBDDFachadaCurso());
				BBDDFachada.registraSingleton(Constantes.FachadaFicha,new BBDDFachadaFicha());
				BBDDFachada.registraSingleton(Constantes.FachadaHorario,new BBDDFachadaHorario());
				BBDDFachada.registraSingleton(Constantes.FachadaProfesor,new BBDDFachadaProfesor());
				BBDDFachada.registraSingleton(Constantes.FachadaUsuario,new BBDDFachadaUsuario());
				
			}
			catch(Exception e){
				e.printStackTrace();
				e.getMessage();
				
			}
		}
		return ejemplar;
	}
	
	/**
	 * Crea un objeto de la clase EsquemaBBDD adecuado según el tipo ObjetoBBDD que le pasamos como parámetro.
	 * @param entidadBBDD  objeto según el cual se identifica que tipo de EsquemaBBDD devolvemos.
	 * @return la tabla adecuada para utilizar con el ObjetoBBDD
	 */
	protected EsquemaBBDD crearTablaAdecuada(ObjetoBBDD entidadBBDD){
		EsquemaBBDD esquemaAdecuado= creador.getCreadorEsquema().crear
		( ((Integer) this.entidadesBD.get(entidadBBDD.getClass().getName())).intValue());
		
		return esquemaAdecuado;
	
	
	}
	/**
	 * Crea un objeto de la clase ObjetoCriterio adecuado según el tipo ObjetoBBDD que le pasamos como parámetro.
	 * @param entidadBBDD  objeto según el cual se identifica que tipo de ObjetoBBDD devolvemos.
	 * @return un objeto de la clase ObjetoCriterio adecuado a entidadBBDD.
	 */
	protected ObjetoCriterio crearObjetoCriterioAdecuado(ObjetoBBDD entidadBBDD){
		
		
		ObjetoCriterio criterioAdecuado =creador.getCreadorObjetoCriterio().crear
								( ((Integer) this.entidadesBD.get(entidadBBDD.getClass().getName())).intValue());
		criterioAdecuado.convertir(entidadBBDD);
		return criterioAdecuado;
		
		
	}
	
	/**
	 * Nos sirve para inicializar los valores de un EsquemaBBDD con el objetivo de poder
	 * acceder a la base de datos que contiene el EsquemaBBDD, fijando el nombre de la BD, el login, contraseña...
	 * 
	 * @param tabla la tabla que queremos inicializar
	 * @return la tabla con sus atributos inicializados al valor adecuado para conectar a la BD.
	 */
	protected EsquemaBBDD inicializaTabla(EsquemaBBDD tabla){
		tabla.setBd(this.nombreBD);tabla.setLogin(this.usuarioBD);tabla.setPassword(this.password);
		tabla.setUrl(this.url);
		return tabla;
	}
	
	/**
	 * Se trata de un método de edición/modificacion standard para cualquier tupla de cualquier tabla de nuestra Base de datos.
	 * @param entidad la tupla a editar con los datos ya modificados
	 * @return true si la edicion tiene exito, false e.o.c
	 */
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
	/**
	 * Se trata de un método de inserción standard para cualquier tupla de cualquier tabla de nuestra Base de datos.
	 * @param entidad la tupla a insertar en la tabla correspondiente.
	 * @return true si la inserción tiene exito, false e.o.c
	 */
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
	/**
	 * Se trata de un método de eliminación standard para cualquier tupla de cualquier tabla de nuestra Base de datos.
	 * @param entidad  la tupla a eliminar en la tabla correspondiente.
	 * @return true si la eliminación tiene exito, false e.o.c
	 */
	
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
	/**
	 * Se trata de un método de consulta standard para cualquier tupla de cualquier tabla de nuestra Base de datos.
	 * @param entidad  la tupla que contiene alguno de los datos sobre los cuales queremos efectuar la consulta.
	 * @return true si la consulta tiene exito, false e.o.c
	 */
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
	
}