package visualizador;
import java.io.*;


import beans.beanEncapsulado.Encapsulador;
import beans.beanEncapsulado.GestorEncapsuladores;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.gestorControlador.GestorControlador;
import subSistemaControlador.gestorPaginas.GestorPaginas;
import subSistemaControlador.gestorSesiones.GestorSesiones;

/**
 * Intermediario entre el terminal (navegador) y sistema de controlador de datos.
 * @author Fco Javier Pérez Escrivá 
 *
 */
public class ServletVisualizador extends HttpServlet{

	private static final long serialVersionUID = 1L;
	/**
	 * Entidad que controla el acceso al sistema
	 */
	private GestorSesiones gestorSesiones;
	/**
	 * Entidad que gestiona la relacion entre una operación y el controlador que esta destinado a llevarla a cabo
	 */
	private GestorControlador gestorControlador;
	/**
	 *	Tabla de transición de comportamiento de las paginas con respecto a operaciones, operaciones resultado y perfil de usuario
	 */
	private GestorPaginas gestorPaginas;
	/**
	 * Gestiona qué encapsulador tiene que ejecutarse en cada momento
	 */
	private GestorEncapsuladores gestorEncapsuladores;
	/**
	 * Constructor
	 */
	public ServletVisualizador() {
		super();
		gestorControlador=new GestorControlador();
		gestorControlador.inicializa();
		gestorSesiones =new GestorSesiones();
		gestorPaginas=new GestorPaginas();
		gestorPaginas.inializarGestorPaginas();
		gestorEncapsuladores=new GestorEncapsuladores();
		}
	
	public void doPost (HttpServletRequest req, HttpServletResponse rep) throws IOException{
		HttpSession sesion=req.getSession(true);
		Encapsulador encap=gestorEncapsuladores.dameEncapsulador(req);
		encap.encapsular();
		
		if (gestorSesiones.indicaSiUsuarioIdentificado(sesion)){
			//el usuario está validado
			
			String operacion=gestorSesiones.dameOperacion(req);
			String perfil=gestorSesiones.damePerfilUsuario(sesion);
			Controlador controlador=gestorControlador.dameControlador(perfil,operacion,sesion);
			controlador.procesarEvento();
			String paginaSiguiente=gestorPaginas.damePaginaSig(perfil,operacion,controlador.getResuladooperacion());
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
	

}
