package subSistemaBBDD.objetoBaseDatos;
import subSistemaBBDD.utils.*;
/**
 * Esta clase representa un objeto de acceso de datos a una tupla de la tabla avisos de nuestra Base de datos.
 *  
 * @author Alberto Macho González
 *
 */
public class IsAvisos extends ObjetoBBDD{
	
	private String IDISAVISOS;
	private String FECHA_AVISO;
	private String FECHA_CADUCIDAD;
	private String ASUNTO;
	private String TEXTO;
	private String ACTIVO;
	/**
	 * Constructor de la clase.Inicializa todos los campos de
	 * la tupla aviso a vacio.
	 */
	public IsAvisos()
	{
		this.inicializar();
	}
	/**
	 * Este metodo lo usamos para hacer copias de otro objetoBBDD que en este caso sera
	 * un Aviso. Se asemeja a lo que podria ser un constructor de copia.
	 */
	public ObjetoBBDD clonar() {
		// TODO Auto-generated method stub
		IsAvisos aviso = new IsAvisos();
		aviso.IDISAVISOS=this.IDISAVISOS;
		aviso.FECHA_AVISO=this.FECHA_AVISO;
		aviso.FECHA_CADUCIDAD=this.FECHA_CADUCIDAD;
		aviso.ASUNTO=this.ASUNTO;
		aviso.TEXTO=this.TEXTO;
		aviso.ACTIVO=this.ACTIVO;
		
		//aviso.inicializar();
		return aviso;
		
		
	}
	/**
	 * Me devuelve el valor del atriburo de IsAvisos que le indique en 
	 * el parametro campo
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
				
		String c="";
		if (campo.equals(Constantes.ID_ISAVISOS))
		{
			c=IDISAVISOS;
		}
		else if (campo.equals(Constantes.AVISOS_FECHA_AVISO))
		{
			c=FECHA_AVISO;
		}
		else if (campo.equals(Constantes.AVISOS_FECHA_CADUCUDAD))
		{
			c=FECHA_CADUCIDAD;
		}
		else if (campo.equals(Constantes.AVISOS_ASUNTO))
		{
			c=ASUNTO;
		}
		else if (campo.equals(Constantes.AVISOS_TEXTO))
		{
			c=TEXTO;
		}
		else if (campo.equals(Constantes.AVISOS_ACTIVO))
		{
			c=ACTIVO;
		}
		
		
		return c;
		
		
	}
	/**
	 * Nos cambia el valor del campo que nosotros eligamos
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
		
		if (campo.equals(Constantes.ID_ISAVISOS))
		{
			IDISAVISOS=valor;
		}
		else if (campo.equals(Constantes.AVISOS_FECHA_AVISO))
		{
			FECHA_AVISO=valor;
		}
		else if (campo.equals(Constantes.AVISOS_FECHA_CADUCUDAD))
		{
			FECHA_CADUCIDAD=valor;
		}
		else if (campo.equals(Constantes.AVISOS_ASUNTO))
		{
			ASUNTO=valor;
		}
		else if (campo.equals(Constantes.AVISOS_TEXTO))
		{
			TEXTO=valor;
		}
		else if (campo.equals(Constantes.AVISOS_ACTIVO))
		{
			ACTIVO=valor;
		}
		
	
		
	}
	/**
	 * inicaliza todos los atributos a la cadena vacia
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		IDISAVISOS="";
		FECHA_AVISO=""; 
		FECHA_CADUCIDAD="";
		ASUNTO="";
		TEXTO="";
		ACTIVO="";
		
	}

}
