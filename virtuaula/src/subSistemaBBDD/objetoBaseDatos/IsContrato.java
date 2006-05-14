package subSistemaBBDD.objetoBaseDatos;
import subSistemaBBDD.utils.*;
/**
 * 
 * @author Alberto Macho
 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
 *
 */
public class IsContrato extends ObjetoBBDD{
	
	private String ISUSUARIO_DNI;
	private String ISNOMINA_IDISNOMINA;
	private String TIPO;
	
	public IsContrato()
	{
		this.inicializar();		
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public ObjetoBBDD clonar() {
		// TODO Auto-generated method stub
		IsContrato contrato=new IsContrato();
		contrato.TIPO=this.TIPO;
		contrato.ISUSUARIO_DNI=this.ISUSUARIO_DNI;
		contrato.ISNOMINA_IDISNOMINA=this.ISNOMINA_IDISNOMINA;
		//contrato.inicializar();
		return contrato;
	}
	/**
	 * Me devuelve el valor del atriburo de IsContrato que le indique en 
	 * el parametro campo
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		String c="";
	
		if (campo.equals(Constantes.ID_ISCONTRATO_ISUSUARIO_DNI))
		{
			c=ISUSUARIO_DNI;
		}
		else if (campo.equals(Constantes.CONTRATO_ISNOMINA_IDISNOMINA))
		{
			c=ISNOMINA_IDISNOMINA;
		}
		else if (campo.equals(Constantes.CONTRATO_TIPO))
		{
			c=TIPO;
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
		if (campo.equals(Constantes.ID_ISCONTRATO_ISUSUARIO_DNI))
		{
			ISUSUARIO_DNI=valor;
		}
		else if (campo.equals(Constantes.CONTRATO_ISNOMINA_IDISNOMINA))
		{
			ISNOMINA_IDISNOMINA=valor;
		}
		else if (campo.equals(Constantes.CONTRATO_TIPO))
		{
			TIPO=valor;
		}
		
	}
	/**
	 * Metodo que inicializa todos los atributos a la cadena vacia
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		ISUSUARIO_DNI="";
		ISNOMINA_IDISNOMINA="";
		TIPO="";
		
	}

}
