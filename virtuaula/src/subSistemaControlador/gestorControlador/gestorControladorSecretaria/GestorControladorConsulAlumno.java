package subSistemaControlador.gestorControlador.gestorControladorSecretaria;



import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
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
		CreadorControlador c = new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("CONS_ALUM",c.crear(CreadorControlador.ControladorIniConsAlumno));
		GestorControlador.tablaOperacionControlador.put("CONS_ALUM2",c.crear(CreadorControlador.ControladorConsAlumno));
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_ALUM",c.crear(CreadorControlador.ControladorMostrarAlumno));
		
		
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;

		
		//return null;
	}
}

