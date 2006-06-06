package subSistemaBBDD.objetoBaseDatos;
import subSistemaBBDD.utils.*;
/**
 * Esta clase representa un objeto de acceso de datos a una tupla de la tabla curso de nuestra Base de datos.
 *  
 * @author Alberto Macho González
 *
 */
public class IsCurso extends ObjetoBBDD{

	private String IDISCURSO;
	private String ISPROFESOR_ISUSUARIO_DNI;
	private String ISAREA_IDISAREA;
	private String NOMBRE;
	private String NUMERO_PLAZAS;
	private String ESTADO;
	private String FECHA_INICIO;
	private String FECHA_FIN;
	private String PRECIO;
	/**
	 * Constructor de la clase.Inicializa todos los campos de
	 * la tupla curso a vacio.
	 */
	
	public IsCurso()
	{
		this.inicializar();
	}
	/**
	 * Este metodo lo usamos para hacer copias de otro objetoBBDD que en este caso sera
	 * un curso. Se asemeja a lo que podria ser un constructor de copia.
	 */
	public ObjetoBBDD clonar() {
		// TODO Auto-generated method stub
		IsCurso curso = new IsCurso();
		curso.IDISCURSO=this.IDISCURSO;
		curso.ISPROFESOR_ISUSUARIO_DNI=this.ISPROFESOR_ISUSUARIO_DNI;
		curso.ISAREA_IDISAREA=this.ISAREA_IDISAREA;
		curso.NOMBRE=this.NOMBRE;
		curso.NUMERO_PLAZAS=this.NUMERO_PLAZAS;
		curso.ESTADO=this.ESTADO;
		curso.FECHA_INICIO=this.FECHA_INICIO;
		curso.FECHA_FIN=this.FECHA_FIN;
		curso.PRECIO=this.PRECIO;
		//curso.inicializar();
		return curso;
	}
	/**
	 * Nos da el valor de la tupla IsCurso del campo introducido
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */	
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		String c="";
		if (campo.equals(Constantes.ID_ISCURSO_IDISCURSO))
		{
			c=IDISCURSO;
		}
		else if (campo.equals(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI))
		{
			c=ISPROFESOR_ISUSUARIO_DNI;
		}
		else if (campo.equals(Constantes.CURSO_ISAREA_IDISAREA))
		{
			c=ISAREA_IDISAREA;
		}
		else if (campo.equals(Constantes.CURSO_NOMBRE))
		{
			c=NOMBRE;
		}
		else if (campo.equals(Constantes.CURSO_NUMERO_PLAZAS))
		{
			c=NUMERO_PLAZAS;
		}
		else if (campo.equals(Constantes.CURSO_ESTADO))
		{
			c=ESTADO;
		}
		else if (campo.equals(Constantes.CURSO_FECHA_INICIO))
		{
			c=FECHA_INICIO;
		}
		else if (campo.equals(Constantes.CURSO_FECHA_FIN))
		{
			c=FECHA_FIN;
		}
		else if (campo.equals(Constantes.CURSO_PRECIO))
		{
			c=PRECIO;
		}
		/*else if (campo.equals("duracion"))
		{
			c=duracion;
		}*/
		return c;
	}
	/**
     * Introducimos un campo de la tupla que queremos cambiar y el valor que le
     * queremos asignar y nos lo cambia.
     * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
     */
	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
		if (campo.equals(Constantes.ID_ISCURSO_IDISCURSO))
		{
			IDISCURSO=valor;
		}
		else if (campo.equals(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI))
		{
			ISPROFESOR_ISUSUARIO_DNI=valor;
		}
		else if (campo.equals(Constantes.CURSO_ISAREA_IDISAREA))
		{
			ISAREA_IDISAREA=valor;
		}
		else if (campo.equals(Constantes.CURSO_NOMBRE))
		{
			NOMBRE=valor;
		}
		else if (campo.equals(Constantes.CURSO_NUMERO_PLAZAS))
		{
			NUMERO_PLAZAS=valor;
		}
		else if (campo.equals(Constantes.CURSO_ESTADO))
		{
			ESTADO=valor;
		}
		else if (campo.equals(Constantes.CURSO_FECHA_INICIO))
		{
			FECHA_INICIO=valor;
		}
		else if (campo.equals(Constantes.CURSO_FECHA_FIN))
		{
			FECHA_FIN=valor;
		}
		else if (campo.equals(Constantes.CURSO_PRECIO))
		{
			PRECIO=valor;
		}
		/*else if (campo.equals("duracion"))
		{
			c=duracion;
		}*/
		
	}
	/**
	 * Metodo que inicializa todos los atributos a la cadena vacia
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		IDISCURSO="";
		ISPROFESOR_ISUSUARIO_DNI="";
		ISAREA_IDISAREA="";
		NOMBRE="";
		NUMERO_PLAZAS="";
		ESTADO="";
		FECHA_INICIO="";
		FECHA_FIN="";
		PRECIO="";
		//private String duracion="";
		
	}

}
