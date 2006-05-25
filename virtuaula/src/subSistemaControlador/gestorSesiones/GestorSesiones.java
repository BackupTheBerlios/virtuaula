package subSistemaControlador.gestorSesiones;
import javax.servlet.http.*;

import beans.*;
//import subSistemaBBDD.beans.*;
import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.BBDDFachadaProfesor;
import subSistemaBBDD.BBDDFachadaUsuario;
import subSistemaBBDD.utils.Constantes;
public class GestorSesiones {
	
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
	
	
	public String dameOperacion(HttpServletRequest req){
		return req.getParameter("evento");
	}
	public String damePerfilUsuario(HttpSession sesion){
	
		return ((String)sesion.getAttribute("perfilUsuario"));
	}
}
