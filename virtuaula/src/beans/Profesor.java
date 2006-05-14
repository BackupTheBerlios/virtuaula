package beans;
import subSistemaBBDD.utils.Constantes;
/**
 * @author Alberto Macho
 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
 */
public class Profesor extends ObjetoBean{

	private String ISUSUARIO_DNI;
	private String ISAREA_IDISAREA; 
	private String NOMBRE;
	private String APELLIDO1;
	private String APELLIDO2;
	private String TELEFONO;
	private String EMAIL;
	//private String direccion;
	//private String fechNacimiento;
	//private String sexo;

	public Profesor()
	{
		this.inicializar();
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public ObjetoBean clonar() {
		// TODO Auto-generated method stub
		Profesor a = new Profesor();
		a.ISUSUARIO_DNI=this.ISUSUARIO_DNI;
		a.ISAREA_IDISAREA=this.ISAREA_IDISAREA;
		a.NOMBRE=this.NOMBRE;
		a.APELLIDO1=this.APELLIDO1;
		a.APELLIDO2=this.APELLIDO2;
		a.TELEFONO=this.TELEFONO;
		a.EMAIL=this.EMAIL;
		//a.inicializar();
		return a;
		
		}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
				
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
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
		
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
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		ISUSUARIO_DNI="";
		ISAREA_IDISAREA=""; 
		NOMBRE="";
		APELLIDO1="";
		APELLIDO2="";
		TELEFONO="";
		EMAIL="";
		
	}
}
