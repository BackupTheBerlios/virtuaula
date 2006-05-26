package beans;

import subSistemaBBDD.utils.Constantes;

/**
 * 
 * @author Alberto Macho.
 * Encapsula la relacion de Avisos con Usuario
 * 
 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
 */
 
public class Avisos_Has_Usuario extends ObjetoBean{

	private String ISAVISOS_IDISAVISOS;
	private String ISUSUARIO_DNI;
	private String NUEVO;

	public Avisos_Has_Usuario()
	{
		this.inicializar();
		
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public ObjetoBean clonar() {
		// TODO Auto-generated method stub
		Avisos_Has_Usuario aviusu=new Avisos_Has_Usuario();
		aviusu.ISAVISOS_IDISAVISOS=this.ISAVISOS_IDISAVISOS;
		aviusu.ISUSUARIO_DNI=this.ISUSUARIO_DNI;
		aviusu.NUEVO= this.NUEVO;	
		//aviusu.inicializar();
		return aviusu;
	}
	
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		String c="";
	
		if (campo.equals(Constantes.ID_ISAVISOS_HAS_ISUSUARIO))
		{
			c=ISAVISOS_IDISAVISOS;
		}
		else if (campo.equals(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI))
		{
			c=ISUSUARIO_DNI;
		}
		else if (campo.equals(Constantes.ISAVISOS_HAS_ISUSUARIO_NUEVO))
		{
			c=NUEVO;
		}
		
		return c;
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
		if (campo.equals(Constantes.ID_ISAVISOS_HAS_ISUSUARIO))
		{
			ISAVISOS_IDISAVISOS=valor;
		}
		else if (campo.equals(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI))
		{
			ISUSUARIO_DNI=valor;
		}
		else if (campo.equals(Constantes.ISAVISOS_HAS_ISUSUARIO_NUEVO))
		{
			NUEVO=valor;
		}
		
		
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		ISAVISOS_IDISAVISOS="";
		ISUSUARIO_DNI="";
		NUEVO="";
			
	}

}
