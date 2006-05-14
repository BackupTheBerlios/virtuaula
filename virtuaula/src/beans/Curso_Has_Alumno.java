package beans;
import subSistemaBBDD.utils.Constantes;
/**
 * @author Alberto Macho 
 *
 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
 */
public class Curso_Has_Alumno extends ObjetoBean{
	private String ISCURSO_IDISCURSO;
	private String ISALUMNO_ISUSUARIO_DNI;
	private String ISFICHA_IDISFICHA;
	private String NOTA_FINAL;

	public Curso_Has_Alumno()
	{
		this.inicializar();
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public ObjetoBean clonar() {
		// TODO Auto-generated method stub
		Curso_Has_Alumno cural=new Curso_Has_Alumno();
		cural.ISCURSO_IDISCURSO=this.ISCURSO_IDISCURSO;
		cural.ISALUMNO_ISUSUARIO_DNI=this.ISALUMNO_ISUSUARIO_DNI;
		cural.ISFICHA_IDISFICHA=this.ISFICHA_IDISFICHA;
		cural.NOTA_FINAL=this.NOTA_FINAL;
		//cural.inicializar();
		return cural;
	}
	
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
		String c="";
	
		if (campo.equals(Constantes.ID_HAS_ISCURSO_IDISCURSO))
		{
			c=ISCURSO_IDISCURSO;
		}
		else if (campo.equals(Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI))
		{
			c=ISALUMNO_ISUSUARIO_DNI;
		}
		else if (campo.equals(Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA))
		{
			c=ISFICHA_IDISFICHA;
		}
		else if (campo.equals(Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL))
		{
			c=NOTA_FINAL;
		}
		return c;
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
		if (campo.equals(Constantes.ID_HAS_ISCURSO_IDISCURSO))
		{
			ISCURSO_IDISCURSO=valor;
		}
		else if (campo.equals(Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI))
		{
			ISALUMNO_ISUSUARIO_DNI=valor;
		}
		else if (campo.equals(Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA))
		{
			ISFICHA_IDISFICHA=valor;
		}
		else if (campo.equals(Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL))
		{
			NOTA_FINAL=valor;
		}
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		ISCURSO_IDISCURSO="";
		ISALUMNO_ISUSUARIO_DNI="";
		ISFICHA_IDISFICHA="";
		NOTA_FINAL="";
	}

}
