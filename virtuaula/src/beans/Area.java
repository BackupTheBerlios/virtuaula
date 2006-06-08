package beans;

import subSistemaBBDD.utils.Constantes;
/**
 * 
 * @author Alberto Macho
 *Nos permitira en capsular los datos de un Area
 *Mirar documentacion de la clase de la que hereda(ObjetoBean)
 */
public class Area extends ObjetoBean{
	private String IDISAREA;
	private String NOMBRE;

	public Area()
	{
		this.inicializar();
	}
	/**
	 * @return ObjetoBean
	 * Nos hace un clon o una copia del prototipo
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public ObjetoBean clonar() {
		// TODO Auto-generated method stub
		Area area=new Area();
		area.IDISAREA=this.IDISAREA;
		area.NOMBRE=this.NOMBRE;
		//area.inicializar();
		return area;
	}
	
	/**
	 * @param campo String que nos dice el campo que queremos que nos devuelva
	 * @return Nos da el valor del campo consultado
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 * 
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		String c="";
	
		if (campo.equals(Constantes.ID_ISAREA))
		{
			c=IDISAREA;
		}
		else if (campo.equals(Constantes.AREA_NOMBRE))
		{
			c=NOMBRE;
		}
		
		
		return c;
	}
/**
 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
 */
	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
		if (campo.equals(Constantes.ID_ISAREA))
		{
			IDISAREA=valor;
		}
		else if (campo.equals(Constantes.AREA_NOMBRE))
		{
			NOMBRE=valor;
		}
		
		
	}
/**
 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
 */
	public void inicializar() {
		// TODO Auto-generated method stub
		IDISAREA="";
		NOMBRE="";
				
	}
}
