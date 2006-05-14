package beans;

import subSistemaBBDD.utils.Constantes;
/**
 * 
 * @author Alberto Macho
 *Mirar documentacion de la clase de la que hereda(ObjetoBean)
 */
public class Aula extends ObjetoBean{

	private String IDISAULA;
	private String NOMBRE;
	private String CAPACIDAD;
	private String LOCALIZACION;
	
	
	public Aula()
	{
		this.inicializar();
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public ObjetoBean clonar() {
		// TODO Auto-generated method stub
		Aula aula=new Aula();
		aula.CAPACIDAD=this.CAPACIDAD;
		aula.NOMBRE=this.NOMBRE;
		aula.LOCALIZACION=this.LOCALIZACION;
		aula.IDISAULA=this.IDISAULA;
		//aula.inicializar();
		return aula;
	}

/**
 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		String c="";
	
		if (campo.equals(Constantes.ID_ISAULA))
		{
			c=IDISAULA;
		}
		else if (campo.equals(Constantes.AULA_NOMBRE))
		{
			c=NOMBRE;
		}
		else if (campo.equals(Constantes.AULA_CAPACIDAD))
		{
			c=CAPACIDAD;
		}
		else if (campo.equals(Constantes.AULA_LOCALIZACION))
		{
			c=LOCALIZACION;
		}
		return c;
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
		if (campo.equals(Constantes.ID_ISAULA))
		{
			IDISAULA=valor;
		}
		else if (campo.equals(Constantes.AULA_NOMBRE))
		{
			NOMBRE=valor;
		}
		else if (campo.equals(Constantes.AULA_CAPACIDAD))
		{
			CAPACIDAD=valor;
		}
		else if (campo.equals(Constantes.AULA_LOCALIZACION))
		{
			LOCALIZACION=valor;
		}
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		IDISAULA="";
		NOMBRE="";
		CAPACIDAD="";
		LOCALIZACION="";
	}


}
