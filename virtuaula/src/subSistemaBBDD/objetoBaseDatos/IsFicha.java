package subSistemaBBDD.objetoBaseDatos;
import subSistemaBBDD.utils.*;
/**
 * 
 * @author Alberto Macho
 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
 *
 */
public class IsFicha extends ObjetoBBDD {

	
	//ESTO CREO QUE HAY QUE CAMBIARLO
	private String IDISFICHA;
	private String NOTAS;
	private String ANOTACIONES;
	private String NOTAS_EJERCICIOS;
	
	public IsFicha()
	{
		this.inicializar();
	}
	public ObjetoBBDD clonar() {
		// TODO Auto-generated method stub
		IsFicha ficha=new IsFicha();
		ficha.IDISFICHA=this.IDISFICHA;
		ficha.NOTAS=ficha.NOTAS;
		ficha.ANOTACIONES=this.ANOTACIONES;
		ficha.NOTAS_EJERCICIOS=this.NOTAS_EJERCICIOS;
		//ficha.inicializar();
		return ficha;
	}
	/**
	 * Me devuelve el valor del atriburo de IsFicha que le indique en 
	 * el parametro campo
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
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
     * Introducimos un campo de la tupla que queremos cambiar y el valor que le
     * queremos asignar y nos lo cambia.
     * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
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
	 * Metodo que inicializa todos los atributos a la cadena vacia
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		IDISFICHA="";
		NOTAS="";
		ANOTACIONES="";
		NOTAS_EJERCICIOS="";
	}

}
