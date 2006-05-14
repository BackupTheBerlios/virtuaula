package subSistemaBBDD.objetoBaseDatos;
import subSistemaBBDD.utils.*;
/**
 * 
 * @author Alberto Macho
 *Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
 */
public class IsUsuario extends ObjetoBBDD {
	
	private String DNI;
	private String CONTRASENIA;
	private String PERFIL;

	public IsUsuario()
	{
		this.inicializar();
	}
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public ObjetoBBDD clonar() {
		// TODO Auto-generated method stub
		IsUsuario usuario = new IsUsuario();
		usuario.DNI=this.DNI;
		usuario.CONTRASENIA=this.CONTRASENIA;
		usuario.PERFIL=this.PERFIL;
		//usuario.inicializar();
		return usuario;
	}
	/**
	 * Me devuelve el valor del atriburo de IsUsuario que le indique en 
	 * el parametro campo
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public String dameValor(String campo) {
		// TODO Auto-generated method stub
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
     * Introducimos un campo de la tupla que queremos cambiar y el valor que le
     * queremos asignar y nos lo cambia.
     * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
     */
	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
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
	 * Metodo que inicializa todos los atributos a la cadena vacia
	 * Mirar documentacion de la clase de la que hereda(ObjetoBBDD)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		DNI="";
		CONTRASENIA="";
		PERFIL="";
		
	}

}
