package beans.beanEncapsulado.encapsuladores.encapsuladorBean;

import beans.ObjetoBean;
import beans.beanEncapsulado.Encapsulador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Encapsula cualquier Bean.ObjetoBean 
 * @author Fco Javier Pérez Escrivá
 *
 */
public class EncapsuladorBean extends Encapsulador{
	/**
	 * Constructor
	 * @param tipo tipo de bean a encapsular
	 * @param request Objeto contenedor de la informacion de la pagina anterior
	 */
	public EncapsuladorBean(String tipo,HttpServletRequest request){
		super(tipo,request);
	}
	/**
	 * Realiza la accion de encapsular y lo mete en la sesion
	 */
	public void encapsular(){
		HttpSession sesion=request.getSession();
		RequestContextFactory test = new RequestContextFactory();
		ObjetoBean result = test.createRequestContext(request,tipo);
		String nombreAtributo = "bean" + tipo;					
		sesion.setAttribute(nombreAtributo, result);
	}
}
