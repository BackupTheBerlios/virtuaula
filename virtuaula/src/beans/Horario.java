package beans;
import subSistemaBBDD.utils.Constantes;
/**
 * @author Alberto Macho
 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
 */
public class Horario extends ObjetoBean{
	private String IDISHORARIO;
	private String L;
	private String M;
	private String X;
 	private String J;
	private String V;

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
		horario.L=this.L;
		horario.M=this.M;
		horario.X=this.X;
		horario.J=this.J;
		horario.V=this.V;
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
			c=L;
		}
		else if (campo.equals(Constantes.HORARIO_MARTES))
		{
			c=M;
		}
		else if (campo.equals(Constantes.HORARIO_MIERCOLES))
		{
			c=X;
		}
		else if (campo.equals(Constantes.HORARIO_JUEVES))
		{
			c=J;
		}
		else if (campo.equals(Constantes.HORARIO_VIERNES))
		{
			c=V;
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
			L=valor;
		}
		else if (campo.equals(Constantes.HORARIO_MARTES))
		{
			M=valor;
		}
		else if (campo.equals(Constantes.HORARIO_MIERCOLES))
		{
			X=valor;
		}
		else if (campo.equals(Constantes.HORARIO_JUEVES))
		{
			J=valor;
		}
		else if (campo.equals(Constantes.HORARIO_VIERNES))
		{
			V=valor;
		}
	}

	
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		IDISHORARIO="";
		L="";
		M="";
		X="";
		J="";
		V="";
		
	}
}
