package subSistemaBBDD.esquemaBBDD;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;


import subSistemaBBDD.listaObjeto.*;
import subSistemaBBDD.objetoBaseDatos.*;
import subSistemaBBDD.objetoCriterio.*;

import org.apache.log4j.Logger;

import subSistemaBBDD.utils.*;

/**
 * Abstracción de una tabla de la BBDD dando el servicion de conexion 
 * y desconexión con una BBDD especificada
 * Forma parte de dos patrones:
 * 			-Patrón Prototype su rol es de Prototype
 * 			-Patrón Composite su rol es de Component
 * @author Fco Javier Pérez Escrivá
 *
 */
abstract public class EsquemaBBDD {
	
	//Declaramos el log de la clase
	private static final Logger log = Logger.getLogger(EsquemaBBDD.class);
	
	
	/**
	 * Nombre de la base de datos con la que conectar
	 */
	private String bd; 
	/**
	 * Usuario con el que se accede a la base de datos
	 */
	private String login; 
	/**
	 * Contraseña con el que se accede a la base de datos
	 */
	private String password; 
	/**
	 * Dirección url donde se encuentra situado el servidor de la BBDD
	 */
	private String url;
	/**
	 * Objeto auxiliar para realizar la conexión
	 */
	private Connection conexion;
	
	public String getBd() {
		return bd;
	}
	public void setBd(String bd) {
		this.bd = bd;
	}
	public Connection getConexion() {
		return conexion;
	}
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * Realiza la conexion con la base de datos
	 * En el caso de fallo realizará un fichero .log donde mirar la excepcion sql
	 * que produjo el fallo
	 * @return true en caso de que consiga conectar false en caso contrario
	 */
	protected boolean conectar(){
	      try 
	      {
	     //conectamos con la bd
	        Class.forName("com.mysql.jdbc.Driver").newInstance(); 
	        conexion = DriverManager.getConnection(getUrl(),getLogin(),getPassword());
	        return true;
	     } 
	      catch(SQLException ex) 
	      {
	    	  log.error(Constantes.ERROR_CONEXION_BBDD);
	    	  log.error(ex.getMessage());	    	  
	    	  return false;
	      } 
	      catch(ClassNotFoundException ex) 
	      {
	    	  log.error(Constantes.ERROR_CONEXION_BBDD);
	    	  log.error(ex.getMessage());	    	  
	    	  return false; 
	      }
	      catch (InstantiationException ex){
	    	  log.error(Constantes.ERROR_CONEXION_BBDD);
	    	  log.error(ex.getMessage());	    	  	    	  
	    	  return false;
	      }
	      catch (IllegalAccessException ex){
	    	  log.error(Constantes.ERROR_CONEXION_BBDD);
	    	  log.error(ex.getMessage());	    	  
	    	  return false;
	      }
	}
	/**
	 * Realiza la desconexion con la base de datos
	 * En el caso de fallo realizará un fichero .log donde mirar la excepcion sql
	 * que produjo el fallo
	 * @return true en caso de que consiga desconectar false en caso contrario
	 */
	protected boolean desconectar(){
		
		 try 
	      {
			conexion.close();
	        return true;
	      } 
	      catch(SQLException ex) 
	      {
	    	  log.error(Constantes.ERROR_DESCONEXION_BBDD);
	    	  log.error(ex.getMessage());	    	  	    	  
	    	  return false;
	      } 
	}
	/**
	 * Realiza una inserción del ObjetoBBDD en su tabla/esquema correspondiente
	 * Si es una tabla/esquema de relación y no se encuentra laentrada a insertar
	 * en la tabla Base no realizara la inserción
	 * 
 	 * En el caso de fallo realizará un fichero .log donde mirar la excepcion sql
	 * que produjo el fallo 
	 * @param obj ObjetoBBDD a insertar en su tabla correspondiente
	 * @return true si ha conseguido la inserción false en caso contrario
	 */
	abstract public boolean insertar(ObjetoBBDD obj);
	/**
	 * Realiza un borrado total de las tuplas que cumplan el criterio en su tabla
	 * En el caso de tabla base realizara el borrado de todas las tablas que la referencien
	 * En el caso de fallo realizará un fichero .log donde mirar la excepcion sql
	 * que produjo el fallo 
	 * @param obj criterio de borrado
	 * @returntrue si ha conseguido el borrado false en caso contrario
	 */
	abstract public boolean borrar(ObjetoCriterio obj);
	/**
	 * consulta en la tabla correspondiente bajo el criterio especificado
	 * @param obj criterio de consulta
	 * @return lista de objetosBBDD que encajan con el criterio
	 */
	abstract public ListaObjetoBBDD consultar(ObjetoCriterio obj);
	/**
	 * Edita los campos seleccionados de obj en la tabla correspondiente.
	 * @param obj el ObjetoBBDD a editar.
	 * @return true si la edición se realiza satisfactoriamente, false en caso contrario.
	 */
	abstract public boolean editar(ObjetoCriterio obj);
	/**
	 * Devuelve una copia del EsquemaBBDD al que se le envia el mensaje
	 * Patrón Prototype
	 * @return copia solitada 
	 */
	abstract public EsquemaBBDD clonar();
}
