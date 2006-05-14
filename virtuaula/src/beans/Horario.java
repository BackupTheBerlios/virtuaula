package beans;
import subSistemaBBDD.utils.Constantes;
/**
 * @author Alberto Macho
 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
 */
public class Horario extends ObjetoBean{
	private String IDISHORARIO;
	private String LUNES;
	private String MARTES;
	private String MIERCOLES;
 	private String JUEVES;
	private String VIERNES;

	public Horario()
	{
		this.inicializar();
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public ObjetoBean clonar() {
		Horario horario=new Horario();
		horario.IDISHORARIO=this.IDISHORARIO;
		horario.LUNES=this.LUNES;
		horario.MARTES=this.MARTES;
		horario.MIERCOLES=this.MIERCOLES;
		horario.JUEVES=this.JUEVES;
		horario.VIERNES=this.VIERNES;
		//horario.inicializar();
		return horario;
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		String c="";
	
		if (campo.equals(Constantes.ID_ISHORARIO))
		{
			c=IDISHORARIO;
		}
		else if (campo.equals(Constantes.HORARIO_LUNES))
		{
			c=LUNES;
		}
		else if (campo.equals(Constantes.HORARIO_MARTES))
		{
			c=MARTES;
		}
		else if (campo.equals(Constantes.HORARIO_MIERCOLES))
		{
			c=MIERCOLES;
		}
		else if (campo.equals(Constantes.HORARIO_JUEVES))
		{
			c=JUEVES;
		}
		else if (campo.equals(Constantes.HORARIO_VIERNES))
		{
			c=VIERNES;
		}
		return c;
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
		if (campo.equals(Constantes.ID_ISHORARIO))
		{
			IDISHORARIO=valor;
		}
		else if (campo.equals(Constantes.HORARIO_LUNES))
		{
			LUNES=valor;
		}
		else if (campo.equals(Constantes.HORARIO_MARTES))
		{
			MARTES=valor;
		}
		else if (campo.equals(Constantes.HORARIO_MIERCOLES))
		{
			MIERCOLES=valor;
		}
		else if (campo.equals(Constantes.HORARIO_JUEVES))
		{
			JUEVES=valor;
		}
		else if (campo.equals(Constantes.HORARIO_VIERNES))
		{
			VIERNES=valor;
		}
	}

	
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		IDISHORARIO="";
		LUNES="";
		MARTES="";
		MIERCOLES="";
		JUEVES="";
		VIERNES="";
		
	}
}
