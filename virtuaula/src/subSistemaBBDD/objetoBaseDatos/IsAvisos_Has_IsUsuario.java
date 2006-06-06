package subSistemaBBDD.objetoBaseDatos;
import subSistemaBBDD.utils.*;
/**
 * Esta clase representa un objeto de acceso de datos a una tupla de la tabla de relación
 * entre avisos y usuarios de nuestra Base de datos.
 *  
 * @author Alberto Macho González
 *
 */
public class IsAvisos_Has_IsUsuario extends ObjetoBBDD{
	
	private String ISAVISOS_IDISAVISOS;
	private String ISUSUARIO_DNI;
	
	/**
	 * Constructor de la clase.Inicializa todos los campos de
	 * la tupla isAvisosHasIsUsuario a vacio.
	 */
	public IsAvisos_Has_IsUsuario()
	{
		this.inicializar();
		
	}
	/**
	 * Este metodo lo usamos para hacer copias de otro objetoBBDD que en este caso sera
	 * un IsAvisos_Has_IsUsuario. Se asemeja a lo que podria ser un constructor de copia.
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public ObjetoBBDD clonar() {
		// TODO Auto-generated method stub
		IsAvisos_Has_IsUsuario aviusu=new IsAvisos_Has_IsUsuario();
		aviusu.ISAVISOS_IDISAVISOS=this.ISAVISOS_IDISAVISOS;
		aviusu.ISUSUARIO_DNI=this.ISUSUARIO_DNI;
		//aviusu.inicializar();
		return aviusu;
	}
	/**
	 * Me devuelve el valor del atriburo de IsAvisos_Has_IsUsuario que le indique en 
	 * el parametro campo
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		String c="";
	
		if (campo.equals(Constantes.ID_ISAVISOS_HAS_ISUSUARIO))
		{
			c=ISAVISOS_IDISAVISOS;
		}
		else if (campo.equals(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI))
		{
			c=ISUSUARIO_DNI;
		}
		
		
		return c;
	}
	/**
     * Introducimos un campo de la tupla que queremos cambiar y el valor que le
     * queremos asignar y nos lo cambia.
     * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
     */
	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
		if (campo.equals(Constantes.ID_ISAVISOS_HAS_ISUSUARIO))
		{
			ISAVISOS_IDISAVISOS=valor;
		}
		else if (campo.equals(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI))
		{
			ISUSUARIO_DNI=valor;
		}
		
		
	}
	/**
	 * Metodo que inicializa todos los atributos a la cadena vacia
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		ISAVISOS_IDISAVISOS="";
		ISUSUARIO_DNI="";
			
	}

	

}
