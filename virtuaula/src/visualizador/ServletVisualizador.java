package visualizador;
import java.io.*;

import beans.*;
import beans.beanEncapsulado.RequestContextFactory;
import controlador.Controlador;
import gestorSesiones.GestorSesiones;
import gestorPaginas.GestorPaginas;
import gestorControlador.*;
import javax.servlet.http.*;


public class ServletVisualizador extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private GestorSesiones gestorSesiones;
	private GestorControlador gestorControlador;
	private GestorPaginas gestorPaginas;
	public ServletVisualizador() {
		super();
		gestorControlador=new GestorControlador();
		gestorControlador.inicializa();
		gestorSesiones =new GestorSesiones();
		gestorPaginas=new GestorPaginas();
		//GestorPaginas.agregaPagina("alumno","identificacion","menu1","/menu2.jsp");
		
		//GestorControlador.agregaControlador("agregaAlumno", new ControladorAgregaAlumno());
		gestorPaginas.agregarPaginas("secretaria","CONS_PROF","OK","/virtuaula/pages/secretaria/profesor/consultar/seleccionarProfesor.jsp");
		gestorPaginas.agregarPaginas("secretaria","CONS_PROF","ERROR","/virtuaula/pages/secretaria/profesor/consultar/errorConsultarProfesor.jsp");
		
		gestorPaginas.agregarPaginas("secretaria","GES_PROF","SIG","/virtuaula/pages/secretaria/profesor/index.jsp");
		gestorPaginas.agregarPaginas("secretaria","INI_CONS_PROF","SIG","/virtuaula/pages/secretaria/profesor/consultar/buscarProfesor.jsp");
		gestorPaginas.agregarPaginas("secretaria","MOSTRAR_PROF","SIG","/virtuaula/pages/secretaria/profesor/consultar/informacionProfesor.jsp");
		gestorPaginas.agregarPaginas("secretaria","desconectar","SIG","/virtuaula/pages/index.jsp");
		gestorPaginas.agregarPaginas("secretaria","LOGAR","SIG","/virtuaula/pages/secretaria/index.jsp");
		gestorPaginas.agregarPaginas("secretaria","menuPrincipalSec","SIG","/virtuaula/pages/secretaria/index.jsp");
		
		}
	
	public void doPost (HttpServletRequest req, HttpServletResponse rep) throws IOException{
		HttpSession sesion=req.getSession(true);
		this.encapsular(req);
		
	
		if (gestorSesiones.indicaSiUsuarioIdentificado(sesion)){
			//el usuario está validado
			String operacion=gestorSesiones.dameOperacion(req);
			String perfil=gestorSesiones.damePerfilUsuario(sesion);
			Controlador controlador=gestorControlador.dameControlador(perfil,operacion,sesion);
			controlador.procesarEvento();
			String paginaSiguiente=gestorPaginas.damePaginaSig(perfil,operacion,controlador.getResuladooperacion());
			//String paginaSiguiente=gestorPaginas.damePaginaSig(perfil,operacion,"SIG");
			rep.sendRedirect(paginaSiguiente);
		}
		else{
			//el usuario no está validado
			rep.sendRedirect("/virtuaula/pages/controlAcceso/errorindex.jsp");
		}

	}
	public void doGet (HttpServletRequest req, HttpServletResponse rep) throws IOException{
		doPost(req,rep);
		}
	
	
	private void encapsular (HttpServletRequest request){
		
		RequestContextFactory test = new RequestContextFactory();
		ObjetoBean result = test.createRequestContext(request);
		HttpSession sesion=request.getSession(true);
		String tipo = request.getParameter("idBean");
		if (tipo!=null){
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
		}
		
	}
	
}
