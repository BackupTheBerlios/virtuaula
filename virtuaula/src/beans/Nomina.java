package beans;
import subSistemaBBDD.utils.Constantes;
/**
 * @author Alberto Macho
 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
 */
public class Nomina extends ObjetoBean{
	private String IDISNOMINA;
	private String CUENTA_INGRESOS;
	private String CANTIDAD;
	
	public Nomina()
	{
		this.inicializar();
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public ObjetoBean clonar() {
		// TODO Auto-generated method stub
		Nomina nom=new Nomina();
		nom.IDISNOMINA=this.IDISNOMINA;
		nom.CANTIDAD=this.CANTIDAD;
		nom.CUENTA_INGRESOS=this.CUENTA_INGRESOS;
		//nom.inicializar();
		return nom;
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		String c="";
	
		if (campo.equals(Constantes.ID_ISNOMINA))
		{
			c=IDISNOMINA;
		}
		else if (campo.equals(Constantes.NOMINA_CUENTA_INGRESOS))
		{
			c=CUENTA_INGRESOS;
		}
		else if (campo.equals(Constantes.NOMINA_CANTIDAD))
		{
			c=CANTIDAD;
		}
		
		return c;
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
		if (campo.equals(Constantes.ID_ISNOMINA))
		{
			IDISNOMINA=valor;
		}
		else if (campo.equals(Constantes.NOMINA_CUENTA_INGRESOS))
		{
			CUENTA_INGRESOS=valor;
		}
		else if (campo.equals(Constantes.NOMINA_CANTIDAD))
		{
			CANTIDAD=valor;
		}
		
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		IDISNOMINA="";
		CUENTA_INGRESOS="";
		CANTIDAD="";
		
	}
}
