package subSistemaBBDD.objetoBaseDatos;
import subSistemaBBDD.utils.*;
/**
 * Esta clase representa un objeto de acceso de datos a una tupla de la tabla nomina de nuestra Base de datos.
 *  
 * @author Alberto Macho González
 *
 */
public class IsNomina extends ObjetoBBDD{

	private String IDISNOMINA;
	private String CUENTA_INGRESOS;
	private String CANTIDAD;
	/**
	 * Constructor de la clase.Inicializa todos los campos de
	 * la tupla nomina a vacio.
	 */
	public IsNomina()
	{
		this.inicializar();
	}
	/**
	 * Este metodo lo usamos para hacer copias de otro objetoBBDD que en este caso sera
	 * una nomina. Se asemeja a lo que podria ser un constructor de copia.
	 */
	public ObjetoBBDD clonar() {
		// TODO Auto-generated method stub
		IsNomina nom=new IsNomina();
		nom.IDISNOMINA=this.IDISNOMINA;
		nom.CANTIDAD=this.CANTIDAD;
		nom.CUENTA_INGRESOS=this.CUENTA_INGRESOS;
		//nom.inicializar();
		return nom;
	}
	/**
	 * Me devuelve el valor del atriburo de IsNomina que le indique en 
	 * el parametro campo
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		String c="";
	
		if (campo.equals(Constantes.ID_ISNOMINA))
		{
			c=IDISNOMINA;
		}
		else if (campo.equals(Constantes.NOMINA_CUENTA_INGRESOS))
		{
			c=CUENTA_INGRESOS;
		}
		else if (campo.equals(Constantes.NOMINA_CANTIDAD))
		{
			c=CANTIDAD;
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
		if (campo.equals(Constantes.ID_ISNOMINA))
		{
			IDISNOMINA=valor;
		}
		else if (campo.equals(Constantes.NOMINA_CUENTA_INGRESOS))
		{
			CUENTA_INGRESOS=valor;
		}
		else if (campo.equals(Constantes.NOMINA_CANTIDAD))
		{
			CANTIDAD=valor;
		}
		
	}
	/**
	 * Metodo que inicializa todos los atributos a la cadena vacia
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		IDISNOMINA="";
		CUENTA_INGRESOS="";
		CANTIDAD="";
		
	}

}


