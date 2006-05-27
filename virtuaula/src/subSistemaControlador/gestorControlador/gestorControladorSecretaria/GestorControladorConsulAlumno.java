package subSistemaControlador.gestorControlador.gestorControladorSecretaria;



import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno.ControladorIniConsAlumno;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno.ControladorConsAlumno;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno.ControladorMostrarAlumno;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;
/**
 * 
 * @author JORGE SANCHEZ MUSULIN
 *
 */
public class GestorControladorConsulAlumno extends GestorControladorSecretaria{
	
	
	public GestorControladorConsulAlumno(){}
	
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		GestorControlador.tablaOperacionControlador.put("CONS_ALUM",new ControladorIniConsAlumno());
		GestorControlador.tablaOperacionControlador.put("CONS_ALUM2",new ControladorConsAlumno());
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_ALUM",new ControladorMostrarAlumno());
		
		
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;

		
		//return null;
	}
}

