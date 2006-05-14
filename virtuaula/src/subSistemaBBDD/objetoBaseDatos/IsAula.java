package subSistemaBBDD.objetoBaseDatos;
import subSistemaBBDD.utils.*;
/**
 * 
 * @author Alberto Macho Gonzalez
 *Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
 */
public class IsAula extends ObjetoBBDD {

	
	private String IDISAULA;
	private String NOMBRE;
	private String CAPACIDAD;
	private String LOCALIZACION;
	
	public IsAula()
	{
		this.inicializar();
	}
	/**
	 * Esta clase la usamos para hacer copias de otro objetoBBDD que en este caso sera
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
	 * @param Le pasamos el campo que queremos obtener, este campo se puede obtener de la clase constantes
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
     * @param Le pasamos el campo que queremos cambiar de valor y su nuev valor
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
