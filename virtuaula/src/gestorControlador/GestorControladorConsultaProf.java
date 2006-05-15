package gestorControlador;


import controlador.Controlador;
import controlador.controlConsulProf.Cons_Prof;

import javax.servlet.http.HttpSession;

public class GestorControladorConsultaProf extends GestorControladorSecretaria{

	
	public GestorControladorConsultaProf(){
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		GestorControlador.tablaOperacionControlador.put("CONS_PROF",new Cons_Prof());
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
	}
}
