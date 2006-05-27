package subSistemaControlador.gestorSesiones;
import javax.servlet.http.*;

import beans.*;
import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.BBDDFachadaUsuario;
import subSistemaBBDD.utils.Constantes;
/**
 * Controla las sesiones de los usuarios
 * @author Fco Javier Pérez Escrivá
 *
 */public class GestorSesiones {
	/**
	 * Indica si el usuario puede o no entrar en el sistema, siendo así mete los datos necesarios 
	 * en la sesion
	 * @param sesion objeto de la sesion actual
	 * @return true en el caso de que el usuario este validado
	 * false en otro caso.
	 */
	public boolean indicaSiUsuarioIdentificado(HttpSession sesion){
		boolean resultado=false;
		

		Boolean validado=((Boolean)sesion.getAttribute("validado"));
		ObjetoBean usuario=((ObjetoBean)sesion.getAttribute("beanUsuario"));
		if (usuario!=null){
			//venimos de la pag de inicio
			BBDDFachada bbdd=BBDDFachada.getInstance();
			BBDDFachadaUsuario bdfu= (BBDDFachadaUsuario) (bbdd.dameBBDDFachada(Constantes.FachadaUsuario));
			if (bdfu.usuarioValido(usuario)){
				//esta registrado
				validado=Boolean.TRUE;
				//saco su perfilUsuario
				String perfilUsuario=bdfu.damePerfilUsuario(usuario);
				sesion.setAttribute("perfilUsuario",perfilUsuario);
			}
			else{
				//no esta registrado
				validado=Boolean.FALSE;	
			}
	
			//sesion.removeAttribute("beanUsuario");
			sesion.setAttribute("validado",validado);
			resultado=validado.booleanValue();
			
		}
		else{
			//no viene de la pagina de inicio
			if (validado!=null){
				//estoy en otra pagina q no es la de validación
				//permito su navegación si anteriormente ha sido validado
				resultado=validado.booleanValue();
			}
			else{
				//no vengo de la pag de inicio y no me he intentado
				//validar en ningún momento
				resultado=false;
			}
			
		}
		
	
		return resultado;
	}
	
	/**
	 * Proporciona el evento univoco de la pagina
	 * @param req objeto contenedor de la información de la pagina anterior
	 * @return Valor del evento
	 */
	public String dameOperacion(HttpServletRequest req){
		return req.getParameter("evento");
	}
	/**
	 * Propociona el perfil del usuario que ha accedido al sistema
	 * @param sesion objeto de la sesion actual
	 * @return valor solicitado
	 */
	public String damePerfilUsuario(HttpSession sesion){
	
		return ((String)sesion.getAttribute("perfilUsuario"));
	}
}
