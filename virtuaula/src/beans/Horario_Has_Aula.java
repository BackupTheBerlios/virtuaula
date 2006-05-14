package beans;
import subSistemaBBDD.utils.Constantes;
/**
 * @author Alberto Macho
 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
 */
public class Horario_Has_Aula extends ObjetoBean{
	private String ISHORARIO_IDISHORARIO;
	private String ISAULA_IDISAULA;
	private String ISCURSO_IDISCURSO;

	public Horario_Has_Aula()
	{
		this.inicializar();
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public ObjetoBean clonar() {
		// TODO Auto-generated method stub
		Horario_Has_Aula horaul=new Horario_Has_Aula();
		horaul.ISHORARIO_IDISHORARIO=this.ISHORARIO_IDISHORARIO;
		horaul.ISAULA_IDISAULA=this.ISAULA_IDISAULA;
		horaul.ISCURSO_IDISCURSO=this.ISCURSO_IDISCURSO;
		//horaul.inicializar();
		return horaul;
	}
	
	
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		String c="";
	
		if (campo.equals(Constantes.ID_HAS_ISHORARIO_IDISHORARIO))
		{
			c=ISHORARIO_IDISHORARIO;
		}
		else if (campo.equals(Constantes.ID_HAS_ISAULA_IDISAULA))
		{
			c=ISAULA_IDISAULA;
		}
		else if (campo.equals(Constantes.ISHORARIO_HAS_ISAULA_ISCURSO_IDISCURSO))
		{
			c=ISCURSO_IDISCURSO;
		}
		
		return c;
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
		if (campo.equals(Constantes.ID_HAS_ISHORARIO_IDISHORARIO))
		{
			ISHORARIO_IDISHORARIO=valor;
		}
		else if (campo.equals(Constantes.ID_HAS_ISAULA_IDISAULA))
		{
			ISAULA_IDISAULA=valor;
		}
		else if (campo.equals(Constantes.ISHORARIO_HAS_ISAULA_ISCURSO_IDISCURSO))
		{
			ISCURSO_IDISCURSO=valor;
		}
		
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		ISHORARIO_IDISHORARIO="";
		ISAULA_IDISAULA="";
		ISCURSO_IDISCURSO="";
		
	}

}
