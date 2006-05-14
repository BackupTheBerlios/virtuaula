package beans;

import subSistemaBBDD.utils.Constantes;
/**
 * 
 * @author Alberto Macho
 *
 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
 */
 
public class Avisos extends ObjetoBean{
	private String IDISAVISOS;
	private String FECHA_AVISO;
	private String FECHA_CADUCIDAD;
	private String ASUNTO;
	private String TEXTO;
	private String ACTIVO;
	
	public Avisos()
	{
		this.inicializar();
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public ObjetoBean clonar() {
		// TODO Auto-generated method stub
		Avisos aviso = new Avisos();
		aviso.IDISAVISOS=this.IDISAVISOS;
		aviso.FECHA_AVISO=this.FECHA_AVISO;
		aviso.FECHA_CADUCIDAD=this.FECHA_CADUCIDAD;
		aviso.ASUNTO=this.ASUNTO;
		aviso.TEXTO=this.TEXTO;
		aviso.ACTIVO=this.ACTIVO;
		//aviso.inicializar();
		return aviso;
		
		
	}
	
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
				
		String c="";
		if (campo.equals(Constantes.ID_ISAVISOS))
		{
			c=IDISAVISOS;
		}
		else if (campo.equals(Constantes.AVISOS_FECHA_AVISO))
		{
			c=FECHA_AVISO;
		}
		else if (campo.equals(Constantes.AVISOS_FECHA_CADUCUDAD))
		{
			c=FECHA_CADUCIDAD;
		}
		else if (campo.equals(Constantes.AVISOS_ASUNTO))
		{
			c=ASUNTO;
		}
		else if (campo.equals(Constantes.AVISOS_TEXTO))
		{
			c=TEXTO;
		}
		else if (campo.equals(Constantes.AVISOS_ACTIVO))
		{
			c=ACTIVO;
		}
		
		return c;
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
		
		if (campo.equals(Constantes.ID_ISAVISOS))
		{
			IDISAVISOS=valor;
		}
		else if (campo.equals(Constantes.AVISOS_FECHA_AVISO))
		{
			FECHA_AVISO=valor;
		}
		else if (campo.equals(Constantes.AVISOS_FECHA_CADUCUDAD))
		{
			FECHA_CADUCIDAD=valor;
		}
		else if (campo.equals(Constantes.AVISOS_ASUNTO))
		{
			ASUNTO=valor;
		}
		else if (campo.equals(Constantes.AVISOS_TEXTO))
		{
			TEXTO=valor;
		}
		else if (campo.equals(Constantes.AVISOS_ACTIVO))
		{
			ACTIVO=valor;
		}
		
	
		
	}
	/**
	 * inicaliza todos los atributos a la cadena vacia
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		IDISAVISOS="";
		FECHA_AVISO=""; 
		FECHA_CADUCIDAD="";
		ASUNTO="";
		TEXTO="";
		ACTIVO="";
		
	}
}
