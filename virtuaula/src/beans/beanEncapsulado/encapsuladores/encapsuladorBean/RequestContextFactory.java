package beans.beanEncapsulado.encapsuladores.encapsuladorBean;

import javax.servlet.http.HttpServletRequest;
import beans.ObjetoBean;

/**
 * Context Object Factory
 */
public class RequestContextFactory {
	/**
	 * Realiza el encapsulado segun la igualdad del nombre de los atributos y de los parametros
	 * @param request Objeto contenedor de la informacion de la anterior pagina web
	 * @param tipo tipo de bean
	 * @return Objeto encapsulado
	 */
	public ObjetoBean createRequestContext(HttpServletRequest request, String tipo){
		ObjetoBean requestContext = null;
		try{
			HashBeanEncapsulado hbe = new HashBeanEncapsulado();
			requestContext = hbe.dameBean(tipo);
			AutoPopulateRequestContext.populateBean(requestContext,request);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return requestContext;
	}
}
