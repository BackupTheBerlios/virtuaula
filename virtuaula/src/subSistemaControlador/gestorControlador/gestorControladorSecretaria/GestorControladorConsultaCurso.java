package subSistemaControlador.gestorControlador.gestorControladorSecretaria;



import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulCur.ControladorConsCur;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulCur.ControladorIniConsCur;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulCur.ControladorMostrarCur;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;
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
