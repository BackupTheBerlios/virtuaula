package gestorControlador.gestorControladorSecretaria;


import gestorControlador.GestorControlador;

import javax.servlet.http.HttpSession;
import controlador.Controlador;
import controlador.ControladorSecretaria.controlConsulCur.ControladorConsCur;
import controlador.ControladorSecretaria.controlConsulCur.ControladorIniConsCur;
import controlador.ControladorSecretaria.controlConsulCur.ControladorMostrarCur;
import controlador.controlPasaPag.ControladorPasaPag;
/**
 * 
 * @author Alberto Macho y Fco Javier Pérez Escrivá
 *
 */
public class GestorControladorConsultaCurso extends GestorControladorSecretaria{
	
	
	public GestorControladorConsultaCurso(){}
	
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		GestorControlador.tablaOperacionControlador.put("GES_CUR",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("INI_CONS_CUR",new ControladorIniConsCur());
		GestorControlador.tablaOperacionControlador.put("CONS_CUR",new ControladorConsCur());
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_CUR",new ControladorMostrarCur());
		
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;

		
		//return null;
	}
}
