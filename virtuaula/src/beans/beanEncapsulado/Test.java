package beans.beanEncapsulado;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ObjetoBean;

public class Test extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost (HttpServletRequest request, HttpServletResponse rep){		
		
		RequestContextFactory test = new RequestContextFactory();
		ObjetoBean result = test.createRequestContext(request);
		HttpSession sesion=request.getSession(true);
		String tipo = request.getParameter("idBean");
		if (tipo.equals("Usuario")){
			sesion.setAttribute("beanUsuario",result);
		}
		
		if (tipo.equals("Profesor")){
			sesion.setAttribute("beanProf",result);
		} 
		if (tipo.equals("listProf")){
			int pos = Integer.parseInt(request.getParameter("posProf"));
			sesion.setAttribute("posProf", new Integer(pos) );
		}
		try {
			rep.sendRedirect("result.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
