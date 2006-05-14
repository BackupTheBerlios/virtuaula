package subSistemaBBDD.objetoBaseDatos;
import subSistemaBBDD.utils.*;
/**
 * 
 * @author Alberto Macho
 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
 *
 */
public class IsProfesor extends ObjetoBBDD {

	private String ISUSUARIO_DNI;
	private String ISAREA_IDISAREA; 
	private String NOMBRE;
	private String APELLIDO1;
	private String APELLIDO2;
	private String TELEFONO;
	private String EMAIL;
	
	
	
	public IsProfesor()
	{
		this.inicializar();
	}

	/**
	 * Nos devuelve un clon profesor inicializado
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public ObjetoBBDD clonar() {
		
		IsProfesor a = new IsProfesor();
		a.ISUSUARIO_DNI=this.ISUSUARIO_DNI;
		a.ISAREA_IDISAREA=this.ISAREA_IDISAREA;
		a.NOMBRE=this.NOMBRE;
		a.APELLIDO1=this.APELLIDO1;
		a.APELLIDO2=this.APELLIDO2;
		a.TELEFONO=this.TELEFONO;
		a.EMAIL=this.EMAIL;
		
		return a;
		
		
	}
	/**
	 * Me devuelve el valor del atriburo de IsProfesor que le indique en 
	 * el parametro campo
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public String dameValor(String campo) {
				
		String c="";
		if (campo.equals(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI))
		{
			c=ISUSUARIO_DNI;
		}
		else if (campo.equals(Constantes.PROFESOR_ISAREA_IDISAREA))
		{
			c=ISAREA_IDISAREA;
		}
		else if (campo.equals(Constantes.PROFESOR_NOMBRE))
		{
			c=NOMBRE;
		}
		else if (campo.equals(Constantes.PROFESOR_APELLIDO1))
		{
			c=APELLIDO1;
		}
		else if (campo.equals(Constantes.PROFESOR_APELLIDO2))
		{
			c=APELLIDO2;
		}
		else if (campo.equals(Constantes.PROFESOR_TELEFONO))
		{
			c=TELEFONO;
		}
		else if (campo.equals(Constantes.PROFESOR_EMAIL))
		{
			c=EMAIL;
		}
		
		return c;
		
		
	}
	/**
     * Introducimos un campo de la tupla que queremos cambiar y el valor que le
     * queremos asignar y nos lo cambia.
     * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
     */
	public void cambiaValor(String campo, String valor) {
		
		
		if (campo.equals(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI))
		{
			ISUSUARIO_DNI=valor;
		}
		else if (campo.equals(Constantes.PROFESOR_ISAREA_IDISAREA))
		{
			ISAREA_IDISAREA=valor;
		}
		else if (campo.equals(Constantes.PROFESOR_NOMBRE))
		{
			NOMBRE=valor;
		}
		else if (campo.equals(Constantes.PROFESOR_APELLIDO1))
		{
			APELLIDO1=valor;
		}
		else if (campo.equals(Constantes.PROFESOR_APELLIDO2))
		{
			APELLIDO2=valor;
		}
		else if (campo.equals(Constantes.PROFESOR_TELEFONO))
		{
			TELEFONO=valor;
		}
		else if (campo.equals(Constantes.PROFESOR_EMAIL))
		{
			EMAIL=valor;
		}
	
		
		
	}
	/**
	 * inicaliza todos los atributos a la cadena vacia
	 */
	public void inicializar() {
		
		ISUSUARIO_DNI="";
		ISAREA_IDISAREA=""; 
		NOMBRE="";
		APELLIDO1="";
		APELLIDO2="";
		TELEFONO="";
		EMAIL="";
		
	}

	

}
