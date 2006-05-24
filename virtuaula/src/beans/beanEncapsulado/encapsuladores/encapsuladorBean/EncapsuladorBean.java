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
	
	public EncapsuladorBean(String tipo,HttpServletRequest request){
		super(tipo,request);
	}
	
	public void encapsular(){
		HttpSession sesion=request.getSession();
		RequestContextFactory test = new RequestContextFactory();
		ObjetoBean result = test.createRequestContext(request,tipo);
		String nombreAtributo = "bean" + tipo;					
		sesion.setAttribute(nombreAtributo, result);
	}
}
