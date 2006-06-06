package subSistemaBBDD.objetoBaseDatos;
import subSistemaBBDD.utils.*;
/**
 * Esta clase representa un objeto de acceso de datos a una tupla de la tabla aula de nuestra Base de datos.
 *  
 * @author Alberto Macho González
 *
 */
public class IsAula extends ObjetoBBDD {

	
	private String IDISAULA;
	private String NOMBRE;
	private String CAPACIDAD;
	private String LOCALIZACION;
	/**
	 * Constructor de la clase.Inicializa todos los campos de
	 * la tupla aula a vacio.
	 */
	public IsAula()
	{
		this.inicializar();
	}
	/**
	 * Este metodo lo usamos para hacer copias de otro objetoBBDD que en este caso sera
	 * un Aula. Se asemeja a lo que podria ser un constructor de copia.
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 * @return Nos devuelve un clon de los atributos de la propia clase. 
	 */
	public ObjetoBBDD clonar() {
		// TODO Auto-generated method stub
		IsAula aula=new IsAula();
		aula.CAPACIDAD=this.CAPACIDAD;
		aula.NOMBRE=this.NOMBRE;
		aula.LOCALIZACION=this.LOCALIZACION;
		aula.IDISAULA=this.IDISAULA;
		//aula.inicializar();
		return aula;
	}
	/**
	 * Me devuelve el valor del atriburo de IsAula que le indique en 
	 * el parametro campo
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 * @param campo pasamos el campo que queremos obtener, este campo se puede obtener de la clase constantes
	 * en la parte correspondiente a IsAula.
	 * @return Nos devuelve un String con el valor del campo requerido.
	 */
	public String dameValor(String campo) {
		
		String c="";
	
		if (campo.equals(Constantes.ID_ISAULA))
		{
			c=IDISAULA;
		}
		else if (campo.equals(Constantes.AULA_NOMBRE))
		{
			c=NOMBRE;
		}
		else if (campo.equals(Constantes.AULA_CAPACIDAD))
		{
			c=CAPACIDAD;
		}
		else if (campo.equals(Constantes.AULA_LOCALIZACION))
		{
			c=LOCALIZACION;
		}
		return c;
	}
	/**
     * Introducimos un campo de la tupla que queremos cambiar y el valor que le
     * queremos asignar y nos lo cambia.
     * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
     * @param campo Le pasamos el campo que queremos cambiar de valor 
     * @param valor el nuevo valor
     */
	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
		if (campo.equals(Constantes.ID_ISAULA))
		{
			IDISAULA=valor;
		}
		else if (campo.equals(Constantes.AULA_NOMBRE))
		{
			NOMBRE=valor;
		}
		else if (campo.equals(Constantes.AULA_CAPACIDAD))
		{
			CAPACIDAD=valor;
		}
		else if (campo.equals(Constantes.AULA_LOCALIZACION))
		{
			LOCALIZACION=valor;
		}
	}
	/**
	 * Metodo que inicializa todos los atributos a la cadena vacia
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		IDISAULA="";
		NOMBRE="";
		CAPACIDAD="";
		LOCALIZACION="";
	}

}
