package beans.beanEncapsulado;

import javax.servlet.http.HttpServletRequest;
import beans.ObjetoBean;

// Context Object Factory
public class RequestContextFactory {

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
