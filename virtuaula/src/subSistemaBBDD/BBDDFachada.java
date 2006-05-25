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
 * Se utiliza un patrón de creación Singleton para esta clase, y además utilizamos una tablas hash para
 * crear exactamente una sola instancia de cada clase que hereda de esta.
 * 
 * @author JORGE SANCHEZ MUSULIN
 *
 */
public class BBDDFachada {
	/**
	 * 
	 */
	private static BBDDFachada ejemplar = null;
	private static Hashtable singletons= new Hashtable();
	private Hashtable entidadesBD= new Hashtable();
	protected Creadores creador;
	private String nombreBD;
	private String usuarioBD;
	private String password;
	private String url;
	
	/**
	 * 
	 *
	 */
	protected BBDDFachada(){
		this.creador = new Creadores();
		this.nombreBD="prueba";
		this.usuarioBD="root";
		this.password="adminwww";
		this.url="jdbc:mysql://localhost/"+ this.nombreBD;
		this.inicializaEntidadesBD();
		
	}
	
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
	
	private static void registraSingleton(String nombre,BBDDFachada instanciaSubClase)throws Exception{
		if((singletons.get(nombre)==null))
			singletons.put(nombre,instanciaSubClase);
			
		else{
			throw new Exception("Ya existe una instancia de la clase"+ instanciaSubClase.getClass());
		}
	}
	
	public BBDDFachada dameBBDDFachada(String nombre){
		return (BBDDFachada)singletons.get(nombre);
	}
	/**
	 * 
	 * @return
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
	
	
	protected EsquemaBBDD crearTablaAdecuada(ObjetoBBDD entidadBBDD){
		EsquemaBBDD esquemaAdecuado= creador.getCreadorEsquema().crear
		( ((Integer) this.entidadesBD.get(entidadBBDD.getClass().getName())).intValue());
		
		return esquemaAdecuado;
	
	
	}
	
	protected ObjetoCriterio crearObjetoCriterioAdecuado(ObjetoBBDD entidadBBDD){
		
		
		ObjetoCriterio criterioAdecuado =creador.getCreadorObjetoCriterio().crear
								( ((Integer) this.entidadesBD.get(entidadBBDD.getClass().getName())).intValue());
		System.out.println("HE ELEGIDO EL CRITERIO " + criterioAdecuado==null);
		criterioAdecuado.convertir(entidadBBDD);
		return criterioAdecuado;
		
		
	}
	
	/**
	 * Nos sirve para inicializar los valores de un EsquemaBBDD con el objetivo de poder
	 * acceder a la base de datos que contiene el EsquemaBBDD, fijando el nombre de la BD, el login, contraseña...
	 * 
	 * @param tabla, la tabla que queremos inicializar
	 * @return la tabla con sus atributos inicializados al valor adecuado para conectar a la BD.
	 */
	protected EsquemaBBDD inicializaTabla(EsquemaBBDD tabla){
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
	
}