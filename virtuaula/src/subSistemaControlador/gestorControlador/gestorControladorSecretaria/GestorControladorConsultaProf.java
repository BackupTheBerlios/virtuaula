package subSistemaControlador.gestorControlador.gestorControladorSecretaria;



import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulProf.Cons_Prof;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulProf.ControladorProfAreas;
import subSistemaControlador.gestorControlador.GestorControlador;
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
