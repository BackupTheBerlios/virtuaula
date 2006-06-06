package subSistemaBBDD.objetoBaseDatos;
import subSistemaBBDD.utils.*;
/**
 * Esta clase representa un objeto de acceso de datos a una tupla de la tabla de relación 
 * entre un curso y un alumno de nuestra Base de datos.
 *  
 * @author Alberto Macho González
 *
 */
public class IsCurso_Has_IsAlumno extends ObjetoBBDD{
	
	private String ISCURSO_IDISCURSO;
	private String ISALUMNO_ISUSUARIO_DNI;
	private String ISFICHA_IDISFICHA;
	private String NOTA_FINAL;
	/**
	 * Constructor de la clase.Inicializa todos los campos de
	 * la tupla isCursoHasIsAlumno a vacio.
	 */
	public IsCurso_Has_IsAlumno()
	{
		this.inicializar();
	}
	/**
	 * Este metodo lo usamos para hacer copias de otro objetoBBDD que en este caso sera
	 * un objeto de relación entre un curso y un alumno. Se asemeja a lo que podria ser un constructor de copia.
	 */
	public ObjetoBBDD clonar() {
		// TODO Auto-generated method stub
		IsCurso_Has_IsAlumno cural=new IsCurso_Has_IsAlumno();
		cural.ISCURSO_IDISCURSO=this.ISCURSO_IDISCURSO;
		cural.ISALUMNO_ISUSUARIO_DNI=this.ISALUMNO_ISUSUARIO_DNI;
		cural.ISFICHA_IDISFICHA=this.ISFICHA_IDISFICHA;
		cural.NOTA_FINAL=this.NOTA_FINAL;
		//cural.inicializar();
		return cural;
	}
	/**
	 * Me devuelve el valor del atriburo de IsCurso_Has_IsAlumno que le indique en 
	 * el parametro campo
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		String c="";
	
		if (campo.equals(Constantes.ID_HAS_ISCURSO_IDISCURSO))
		{
			c=ISCURSO_IDISCURSO;
		}
		else if (campo.equals(Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI))
		{
			c=ISALUMNO_ISUSUARIO_DNI;
		}
		else if (campo.equals(Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA))
		{
			c=ISFICHA_IDISFICHA;
		}
		else if (campo.equals(Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL))
		{
			c=NOTA_FINAL;
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
		if (campo.equals(Constantes.ID_HAS_ISCURSO_IDISCURSO))
		{
			ISCURSO_IDISCURSO=valor;
		}
		else if (campo.equals(Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI))
		{
			ISALUMNO_ISUSUARIO_DNI=valor;
		}
		else if (campo.equals(Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA))
		{
			ISFICHA_IDISFICHA=valor;
		}
		else if (campo.equals(Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL))
		{
			NOTA_FINAL=valor;
		}
	}
	/**
	 * Metodo que inicializa todos los atributos a la cadena vacia
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		ISCURSO_IDISCURSO="";
		ISALUMNO_ISUSUARIO_DNI="";
		ISFICHA_IDISFICHA="";
		NOTA_FINAL="";
	}

}
