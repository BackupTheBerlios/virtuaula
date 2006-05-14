package subSistemaBBDD.objetoBaseDatos;
import subSistemaBBDD.utils.*;
/**
 * 
 * @author Alberto Macho
 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
 *
 */
public class IsHorario_Has_IsAula extends ObjetoBBDD{

	private String ISHORARIO_IDISHORARIO;
	private String ISAULA_IDISAULA;
	private String ISCURSO_IDISCURSO;
	
	public IsHorario_Has_IsAula()
	{
		this.inicializar();
	}
	public ObjetoBBDD clonar() {
		// TODO Auto-generated method stub
		IsHorario_Has_IsAula horaul=new IsHorario_Has_IsAula();
		horaul.ISHORARIO_IDISHORARIO=this.ISHORARIO_IDISHORARIO;
		horaul.ISAULA_IDISAULA=this.ISAULA_IDISAULA;
		horaul.ISCURSO_IDISCURSO=this.ISCURSO_IDISCURSO;
		//horaul.inicializar();
		return horaul;
	}
	/**
	 * Me devuelve el valor del atriburo de IsHorario_Has_IsAula que le indique en 
	 * el parametro campo
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		String c="";
	
		if (campo.equals(Constantes.ID_HAS_ISHORARIO_IDISHORARIO))
		{
			c=ISHORARIO_IDISHORARIO;
		}
		else if (campo.equals(Constantes.ID_HAS_ISAULA_IDISAULA))
		{
			c=ISAULA_IDISAULA;
		}
		else if (campo.equals(Constantes.ISHORARIO_HAS_ISAULA_ISCURSO_IDISCURSO))
		{
			c=ISCURSO_IDISCURSO;
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
		if (campo.equals(Constantes.ID_HAS_ISHORARIO_IDISHORARIO))
		{
			ISHORARIO_IDISHORARIO=valor;
		}
		else if (campo.equals(Constantes.ID_HAS_ISAULA_IDISAULA))
		{
			ISAULA_IDISAULA=valor;
		}
		else if (campo.equals(Constantes.ISHORARIO_HAS_ISAULA_ISCURSO_IDISCURSO))
		{
			ISCURSO_IDISCURSO=valor;
		}
		
	}
	/**
	 * Metodo que inicializa todos los atributos a la cadena vacia
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		ISHORARIO_IDISHORARIO="";
		ISAULA_IDISAULA="";
		ISCURSO_IDISCURSO="";
		
	}

	
}
