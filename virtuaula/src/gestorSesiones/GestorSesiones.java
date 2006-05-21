package gestorSesiones;
import javax.servlet.http.*;

import beans.*;
//import subSistemaBBDD.beans.*;
import subSistemaBBDD.BBDDFachada;
public class GestorSesiones {
	
	public boolean indicaSiUsuarioIdentificado(HttpSession sesion){
		boolean resultado=false;
		

		Boolean validado=((Boolean)sesion.getAttribute("validado"));
		ObjetoBean usuario=((ObjetoBean)sesion.getAttribute("beanUsuario"));
		System.out.println("el usuario"+usuario.dameValor("DNI"));
		if (usuario!=null){
			//venimos de la pag de inicio
			BBDDFachada bbdd=BBDDFachada.getInstance();
			if (bbdd.usuarioValido(usuario)){
				//esta registrado
				validado=Boolean.TRUE;
				//saco su perfilUsuario
				String perfilUsuario=bbdd.damePerfilUsuario(usuario);
				System.out.println("perfil del usuario"+perfilUsuario);
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
