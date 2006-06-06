package subSistemaBBDD.objetoBaseDatos;
import subSistemaBBDD.utils.*;

/**
 * Esta clase representa un objeto de acceso de datos a una tupla de la tabla alumno de nuestra Base de datos.
 *  
 *  * @author Alberto Macho González
 *
 */
public class IsAlumno extends ObjetoBBDD{

	private String ISUSUARIO_DNI;
	private String NOMBRE;
	private String APELLIDO1;
	private String APELLIDO2;
	private String TELEFONO;
	private String EMAIL;
	private String DIRECCION;
	private String FECH_NACIMIENTO;
	private String SEXO;
	
	
	/**
	 * Constructor de la clase.Inicializa todos los campos de
	 * la tupla alumno a vacio.
	 */
	public IsAlumno()
	{
		this.inicializar();
	}
	
	/**
	 * Este metodo lousamos para hacer copias de otro objetoBBDD que en este caso sera
	 * un Alumno. Se asemeja a lo que podria ser un constructor de copia.
	 */
	public ObjetoBBDD clonar() {
		// TODO Auto-generated method stub
		IsAlumno a = new IsAlumno();
		a.NOMBRE=this.NOMBRE;
		a.ISUSUARIO_DNI=this.ISUSUARIO_DNI;
		a.APELLIDO1=this.APELLIDO1;
		a.APELLIDO2=this.APELLIDO2;
		a.DIRECCION=this.DIRECCION;
		a.TELEFONO=this.TELEFONO;
		a.EMAIL=this.EMAIL;
		a.FECH_NACIMIENTO=this.FECH_NACIMIENTO;
		a.SEXO=this.SEXO;
		return a;
		
	}
	
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}

	/**
	 * Me devuelve el valor del atriburo de IsAlumno que le indique en 
	 * el parametro campo
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		
		String c="";
	
		if (campo.equals(Constantes.ID_ISALUMNO_ISUSUARIO_DNI))
		{
			c=ISUSUARIO_DNI;
		}
		else if (campo.equals(Constantes.ALUMNO_NOMBRE))
		{
			c=NOMBRE;
		}
		else if (campo.equals(Constantes.ALUMNO_APELLIDO1))
		{
			c=APELLIDO1;
		}
		else if (campo.equals(Constantes.ALUMNO_APELLIDO2))
		{
			c=APELLIDO2;
		}
		else if (campo.equals(Constantes.ALUMNO_TELEFONO))
		{
			c=TELEFONO;
		}
		else if (campo.equals(Constantes.ALUMNO_EMAIL))
		{
			c=EMAIL;
		}
		else if (campo.equals(Constantes.ALUMNO_DIRECCION))
		{
			c=DIRECCION;
		}
		else if (campo.equals(Constantes.ALUMNO_FECH_NACIMIENTO))
		{
			c=FECH_NACIMIENTO;
		}
		else if (campo.equals(Constantes.ALUMNO_SEXO))
		{
			c=SEXO;
		}
		return c;
	}
    /**
     * Introducimos un campo de la tupla que queremos cambiar y el valor que le
     * queremos asignar y nos lo cambia.
     * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
     */
	public void cambiaValor(String campo, String valor) {
				
		if (campo.equals(Constantes.ID_ISALUMNO_ISUSUARIO_DNI))
		{
			ISUSUARIO_DNI=valor;
		}
		else if (campo.equals(Constantes.ALUMNO_NOMBRE))
		{
			NOMBRE=valor;
		}
		else if (campo.equals(Constantes.ALUMNO_APELLIDO1))
		{
			APELLIDO1=valor;
		}
		else if (campo.equals(Constantes.ALUMNO_APELLIDO2))
		{
			APELLIDO2=valor;
		}
		else if (campo.equals(Constantes.ALUMNO_TELEFONO))
		{
			TELEFONO=valor;
		}
		else if (campo.equals(Constantes.ALUMNO_EMAIL))
		{
			EMAIL=valor;
		}
		else if (campo.equals(Constantes.ALUMNO_DIRECCION))
		{
			DIRECCION=valor;
		}
		else if (campo.equals(Constantes.ALUMNO_FECH_NACIMIENTO))
		{
			FECH_NACIMIENTO=valor;
		}
		else if (campo.equals(Constantes.ALUMNO_SEXO))
		{
			SEXO=valor;
		}
		
		
	}

	/**
	 * Metodo que inicializa todos los atributos a la cadena vacia
	 *
	 */
	public void inicializar() {
		
		ISUSUARIO_DNI="";
		NOMBRE="";
		APELLIDO1="";
		APELLIDO2="";
		TELEFONO="";
		EMAIL="";
		DIRECCION="";
		FECH_NACIMIENTO="";
		SEXO="";
			
	}
	

}
