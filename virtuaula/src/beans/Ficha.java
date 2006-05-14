package beans;
import subSistemaBBDD.utils.Constantes;
/**
 * @author Alberto Macho
 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
 */
public class Ficha extends ObjetoBean{
//	ESTO CREO QUE HAY QUE CAMBIARLO
	private String IDISFICHA;
	private String NOTAS;
	private String ANOTACIONES;
	private String NOTAS_EJERCICIOS;

	public Ficha()
	{
		this.inicializar();
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public ObjetoBean clonar() {
		// TODO Auto-generated method stub
		Ficha ficha=new Ficha();
		ficha.IDISFICHA=this.IDISFICHA;
		ficha.NOTAS=ficha.NOTAS;
		ficha.ANOTACIONES=this.ANOTACIONES;
		ficha.NOTAS_EJERCICIOS=this.NOTAS_EJERCICIOS;
		//ficha.inicializar();
		return ficha;
	}
	
	
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		String c="";
	
		if (campo.equals(Constantes.ID_ISFICHA))
		{
			c=IDISFICHA;
		}
		else if (campo.equals(Constantes.FICHA_NOTAS))
		{
			c=NOTAS;
		}
		else if (campo.equals(Constantes.FICHA_ANOTACIONES))
		{
			c=ANOTACIONES;
		}
		else if (campo.equals(Constantes.FICHA_NOTAS_EJERCICIOS))
		{
			c=NOTAS_EJERCICIOS;
		}
		return c;
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
		if (campo.equals(Constantes.ID_ISFICHA))
		{
			IDISFICHA=valor;
		}
		else if (campo.equals(Constantes.FICHA_NOTAS))
		{
			NOTAS=valor;
		}
		else if (campo.equals(Constantes.FICHA_ANOTACIONES))
		{
			ANOTACIONES=valor;
		}
		else if (campo.equals(Constantes.FICHA_NOTAS_EJERCICIOS))
		{
			NOTAS_EJERCICIOS=valor;
		}
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		IDISFICHA="";
		NOTAS="";
		ANOTACIONES="";
		NOTAS_EJERCICIOS="";
	}

}
