package beans.beanEncapsulado;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ObjetoBean;


public class BeanEncapsulado extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse rep) {

		encapsular(request);
		try {
			rep.sendRedirect("result.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void encapsular(HttpServletRequest request) {

		String tipo = "";
		try {
			tipo = request.getParameter("idBean");
			if ((tipo != null) && (!tipo.equals(""))) {
				RequestContextFactory test = new RequestContextFactory();
				ObjetoBean result = test.createRequestContext(request);
				HttpSession sesion = request.getSession(true);
				boolean lista = false;
				if (tipo.equals("listProf")) {
					int pos = Integer.parseInt(request.getParameter("posProf"));
					sesion.setAttribute("posProf", new Integer(pos));
					lista = true;
				}
				if (tipo.equals("listArea")) {
					int pos = Integer.parseInt(request.getParameter("posArea"));
					sesion.setAttribute("posArea", new Integer(pos));
					lista = true;
				}
				if (tipo.equals("listHor")) {
					int pos = Integer.parseInt(request.getParameter("posHor"));
					sesion.setAttribute("posHor", new Integer(pos));
					lista = true;
				}
				if (tipo.equals("listAula")) {
					int pos = Integer.parseInt(request.getParameter("posAula"));
					sesion.setAttribute("posAula", new Integer(pos));
					lista = true;
				}
				if (tipo.equals("listAviso")) {
					int pos = Integer.parseInt(request.getParameter("posAviso"));
					sesion.setAttribute("posAviso", new Integer(pos));
					lista = true;
				}
				if (tipo.equals("listCurso")) {
					int pos = Integer.parseInt(request.getParameter("posCurso"));
					sesion.setAttribute("posCurso", new Integer(pos));
					lista = true;
				}
				
				if (!lista){
					String nombreAtributo = "bean" + tipo;
					sesion.setAttribute(nombreAtributo, result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/*	private void testObjetoError(HttpServletRequest request) {
		HttpSession sesion = request.getSession(true);

		// PRUEBA GESTOR CURSOS
		Curso c = (Curso) sesion.getAttribute("bean");
		GestorCursos gc = new GestorCursos();
		ListaObjetoBean lob = new ListaObjetoBean();
		lob = gc.insertarCurso(c);
		if (!lob.esVacio()) {
			sesion.setAttribute("error", lob.dameObjeto(0));
		} else {
			CreadorBean cBean = new CreadorBean();
			String mensaje;
			mensaje = "No se han detectado errores";
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			sesion.setAttribute("error", error);
		}

		// PRUEBA BEAN ERROR
		/*
		 * CreadorBean cBean = new CreadorBean(); String mensaje; mensaje = "El
		 * campo precio no ha sido rellenado"; Error error = (Error)
		 * cBean.crear(14); error.cambiaValor("CAUSA_ERROR", mensaje);
		 * sesion.setAttribute("error", error);
		 *
	}*/

}
