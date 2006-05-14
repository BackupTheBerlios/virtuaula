package beans;
import subSistemaBBDD.utils.Constantes;
/**
 * 
 * @author Alberto Macho
 * 
 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
 */
 
 
public class Usuario extends ObjetoBean{
	private String DNI;
	private String CONTRASENIA;
	private String PERFIL;

	public Usuario()
	{
		this.inicializar();
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public ObjetoBean clonar() {
		
		Usuario usuario = new Usuario();
		usuario.DNI=this.DNI;
		usuario.CONTRASENIA=this.CONTRASENIA;
		usuario.PERFIL=this.PERFIL;
		
		return usuario;
	}
	
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public String dameValor(String campo) {
		
		String c="";
	
		if (campo.equals(Constantes.ID_ISUSUARIO_DNI))
		{
			c=DNI;
		}
		else if (campo.equals(Constantes.USUARIO_CONTRASENIA))
		{
			c=CONTRASENIA;
		}
		else if (campo.equals(Constantes.USUARIO_PERFIL))
		{
			c=PERFIL;
		}
		
		return c;
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void cambiaValor(String campo, String valor) {
	
		if (campo.equals(Constantes.ID_ISUSUARIO_DNI))
		{
			DNI=valor;
		}
		else if (campo.equals(Constantes.USUARIO_CONTRASENIA))
		{
			CONTRASENIA=valor;
		}
		else if (campo.equals(Constantes.USUARIO_PERFIL))
		{
			PERFIL=valor;
		}
		
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void inicializar() {
		DNI="";
		CONTRASENIA="";
		PERFIL="";
		
	}

}
