package subSistemaBBDD.objetoBaseDatos;
import subSistemaBBDD.utils.*;
/**
/**
* Esta clase representa una tupla para insertar el el esquema correspondiente
* en este caso sera una tupla ObjetoBBDD que representa un area.
*  
*  * @author Alberto Macho González
*Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
*/
public class IsArea extends ObjetoBBDD {
	
	private String IDISAREA;
	private String NOMBRE;
	
	public IsArea()
	{
		this.inicializar();
	}
	/**
	 * Esta clase la usamos para hacer copias de otro objetoBBDD que en este caso sera
	 * un Area. Se asemeja a lo que podria ser un constructor de copia.
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 * @return nos devuelve un clon ObjetoBBDD, es decir una copia de la propia clase.
	 */
	public ObjetoBBDD clonar() {
		// TODO Auto-generated method stub
		IsArea area=new IsArea();
		area.IDISAREA=this.IDISAREA;
		area.NOMBRE=this.NOMBRE;
		//area.inicializar();
		return area;
	}

	/**
	 * Me devuelve el valor del atriburo de IsArea que le indique en 
	 * el parametro campo
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 * 
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		String c="";
	
		if (campo.equals(Constantes.ID_ISAREA))
		{
			c=IDISAREA;
		}
		else if (campo.equals(Constantes.AREA_NOMBRE))
		{
			c=NOMBRE;
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
		if (campo.equals(Constantes.ID_ISAREA))
		{
			IDISAREA=valor;
		}
		else if (campo.equals(Constantes.AREA_NOMBRE))
		{
			NOMBRE=valor;
		}
		
		
	}
	/**
	 * Metodo que inicializa todos los atributos a la cadena vacia
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		IDISAREA="";
		NOMBRE="";
				
	}

}
