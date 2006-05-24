package beans.beanEncapsulado.encapsuladores;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ObjetoBean;
import beans.beanEncapsulado.encapsuladores.encapsuladorBean.RequestContextFactory;
import beans.listaObjetoBeans.ListaObjetoBean;


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

	static public void encapsular(HttpServletRequest request) {

		String tipo = "";
		try {
			tipo = request.getParameter("idBean");
			if ((tipo != null)&& (!tipo.equals(""))) {
				HttpSession sesion = request.getSession(true);
				boolean lista = false;
				if (tipo.equals("consultaCurso")) {
					ListaObjetoBean lx= null;
					ObjetoBean obj = null;
					int pos;
					
					if (!request.getParameter("ISAREA_IDISAREA").equals("")){
						String s = request.getParameter("ISAREA_IDISAREA");
						lx = (ListaObjetoBean) sesion.getAttribute("listaarea");
					
						obj = null;
						for (int i =0; i<lx.tamanio(); i++){
							obj = lx.dameObjeto(i);
							if(s.equals(obj.dameValor("IDISAREA"))){
								sesion.setAttribute("beanArea",obj);
							}
						}	
					}
					else{
						obj = null;
						sesion.setAttribute("beanArea",obj);
					}
					
					if (!request.getParameter("ISPROFESOR_ISUSUARIO_DNI").equals("")){
						String s = request.getParameter("ISPROFESOR_ISUSUARIO_DNI");
						lx = (ListaObjetoBean) sesion.getAttribute("listaprofesor");
					
						obj = null;
						for (int i =0; i<lx.tamanio(); i++){
							obj = lx.dameObjeto(i);
							if(s.equals(obj.dameValor("ISUSUARIO_DNI"))){
								sesion.setAttribute("beanProfesor",obj);
							}
						}	
					}
					else{
						obj = null;
						sesion.setAttribute("beanProfesor",obj);
					}

					if (!request.getParameter("posAula").equals("")){
					pos = Integer.parseInt(request.getParameter("posAula"));
					lx = (ListaObjetoBean) sesion.getAttribute("listaaula");
					obj = lx.dameObjeto(pos);
					sesion.setAttribute("beanAula",obj);
					}
					else{
						obj = null;
						sesion.setAttribute("beanAula",obj);
					}
					
					if (!request.getParameter("posHor").equals("")){
					pos = Integer.parseInt(request.getParameter("posHor"));
					lx = (ListaObjetoBean) sesion.getAttribute("listahorario");
					obj = lx.dameObjeto(pos);
					sesion.setAttribute("beanHorario",obj);
					}
					else{
						obj = null;
						sesion.setAttribute("beanHorario",obj);
					}
					
					tipo = "Curso";
					lista = false;
				}
				
				if (tipo.equals("insertarProfesor")){
					RequestContextFactory test = new RequestContextFactory();					
					
					//rellenar bean nomina
					ObjetoBean result = test.createRequestContext(request,"Nomina");
					String nombreAtributo = "beanNomina";					
					sesion.setAttribute(nombreAtributo, result);				
					
					//rellenar bean profesor
					result = test.createRequestContext(request,"Profesor");
					nombreAtributo = "beanProfesor";					
					sesion.setAttribute(nombreAtributo, result);
					
					//rellenar bean contrato
					result = test.createRequestContext(request,"Contrato");
					nombreAtributo = "beanContrato";					
					sesion.setAttribute(nombreAtributo, result);
					lista = false;
				}
				
				if (tipo.equals("listProf")) {
					int pos = Integer.parseInt(request.getParameter("posProf"));
					sesion.setAttribute("posProf", new Integer(pos));
					lista = true;
				}
				if (tipo.equals("listAlumno")) {
					int pos = Integer.parseInt(request.getParameter("posAlumno"));
					sesion.setAttribute("posAlumno", new Integer(pos));
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
					RequestContextFactory test = new RequestContextFactory();
					ObjetoBean result = test.createRequestContext(request,tipo);
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
