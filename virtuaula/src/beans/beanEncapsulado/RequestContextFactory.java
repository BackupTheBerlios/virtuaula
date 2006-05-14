package beans.beanEncapsulado;


import javax.servlet.http.HttpServletRequest;

import beans.*;


// Context Object Factory
public class RequestContextFactory {

	public ObjetoBean createRequestContext(HttpServletRequest request){
		ObjetoBean requestContext = null;
		try{
			String tipo = request.getParameter("idBean");
			if (tipo.equals("Profesor")){
				Profesor p = new Profesor(); 
				p.inicializar();
				requestContext = p;
			}
			if (tipo.equals("Usuario")){
				Usuario p = new Usuario(); 
				p.inicializar();
				requestContext = p;
			}
			AutoPopulateRequestContext.populateBean(requestContext,request);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return requestContext;
	}
}
