package gestorControlador.gestorControladorSecretaria;


import gestorControlador.GestorControlador;
import controlador.Controlador;
import controlador.ControladorSecretaria.controlConsulProf.Cons_Prof;
import controlador.ControladorSecretaria.controlConsulProf.ControladorProfAreas;

import javax.servlet.http.HttpSession;
/**
 * 
 * @author Fco Javier Pérez Escrivá
 *
 */
public class GestorControladorConsultaProf extends GestorControladorSecretaria{

	
	public GestorControladorConsultaProf(){
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		GestorControlador.tablaOperacionControlador.put("CONS_PROF",new Cons_Prof());
		GestorControlador.tablaOperacionControlador.put("INI_CONS_PROF",new ControladorProfAreas());
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
	}
}
