package subSistemaBBDD.objetoBaseDatos;
import subSistemaBBDD.utils.*;
/**
 * Esta clase representa un objeto de acceso de datos a una tupla de la tabla horario de nuestra Base de datos.
 *  
 * @author Alberto Macho González
 *
 */
public class IsHorario extends ObjetoBBDD{

	private String IDISHORARIO;
	private String LUNES;
	private String MARTES;
	private String MIERCOLES;
 	private String JUEVES;
	private String VIERNES;

	/**
	 * Constructor de la clase.Inicializa todos los campos de
	 * la tupla horario a vacio.
	 */
	public IsHorario()
	{
		this.inicializar();
	}
	/**
	 * Este metodo lo usamos para hacer copias de otro objetoBBDD que en este caso sera
	 * un horario. Se asemeja a lo que podria ser un constructor de copia.
	 */
	public ObjetoBBDD clonar() {
		// TODO Auto-generated method stub
		
		IsHorario horario=new IsHorario();
		horario.IDISHORARIO=this.IDISHORARIO;
		horario.LUNES=this.LUNES;
		horario.MARTES=this.MARTES;
		horario.MIERCOLES=this.MIERCOLES;
		horario.JUEVES=this.JUEVES;
		horario.VIERNES=this.VIERNES;
		//horario.inicializar();
		return horario;
	}
	/**
	 * Me devuelve el valor del atriburo de IsHorario que le indique en 
	 * el parametro campo
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		String c="";
	
		if (campo.equals(Constantes.ID_ISHORARIO))
		{
			c=IDISHORARIO;
		}
		else if (campo.equals(Constantes.HORARIO_LUNES))
		{
			c=LUNES;
		}
		else if (campo.equals(Constantes.HORARIO_MARTES))
		{
			c=MARTES;
		}
		else if (campo.equals(Constantes.HORARIO_MIERCOLES))
		{
			c=MIERCOLES;
		}
		else if (campo.equals(Constantes.HORARIO_JUEVES))
		{
			c=JUEVES;
		}
		else if (campo.equals(Constantes.HORARIO_VIERNES))
		{
			c=VIERNES;
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
		if (campo.equals(Constantes.ID_ISHORARIO))
		{
			IDISHORARIO=valor;
		}
		else if (campo.equals(Constantes.HORARIO_LUNES))
		{
			LUNES=valor;
		}
		else if (campo.equals(Constantes.HORARIO_MARTES))
		{
			MARTES=valor;
		}
		else if (campo.equals(Constantes.HORARIO_MIERCOLES))
		{
			MIERCOLES=valor;
		}
		else if (campo.equals(Constantes.HORARIO_JUEVES))
		{
			JUEVES=valor;
		}
		else if (campo.equals(Constantes.HORARIO_VIERNES))
		{
			VIERNES=valor;
		}
	}
	/**
	 * Metodo que inicializa todos los atributos a la cadena vacia
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		IDISHORARIO="";
		LUNES="";
		MARTES="";
		MIERCOLES="";
		JUEVES="";
		VIERNES="";
		
	}

}
