package beans;

import subSistemaBBDD.utils.Constantes;

/**
 * 
 * @author Alberto Macho
 *
 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
 */
 
public class Contrato extends ObjetoBean{
	private String ISUSUARIO_DNI;
	private String ISNOMINA_IDISNOMINA;
	private String TIPO;

	public Contrato()
	{
		this.inicializar();		
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public ObjetoBean clonar() {
		// TODO Auto-generated method stub
		Contrato contrato=new Contrato();
		contrato.TIPO=this.TIPO;
		contrato.ISUSUARIO_DNI=this.ISUSUARIO_DNI;
		contrato.ISNOMINA_IDISNOMINA=this.ISNOMINA_IDISNOMINA;
		//contrato.inicializar();
		return contrato;
	}
	
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
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
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
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
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		ISUSUARIO_DNI="";
		ISNOMINA_IDISNOMINA="";
		TIPO="";
		
	}

}
