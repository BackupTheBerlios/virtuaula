package subSistemaControlador.gestorControlador.gestorControladorSecretaria;

import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.gestorControlador.GestorControlador;
/**
 * Devuelve los controladores necesarios para la consulta de un alumno
 * @author JORGE SANCHEZ MUSULIN
 *
 */
public class GestorControladorConsulAlumno extends GestorControladorSecretaria{
	
	/**
	 * Constructor
	 *
	 */
	public GestorControladorConsulAlumno(){}
	/**
	 * Devuelve el Controlador adecuado para este perfil y esta operacion
	 */
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador c = new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("CONS_ALUM",c.crear(CreadorControlador.ControladorIniConsAlumno));
		GestorControlador.tablaOperacionControlador.put("CONS_ALUM2",c.crear(CreadorControlador.ControladorConsAlumno));
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_ALUM",c.crear(CreadorControlador.ControladorMostrarAlumno));
		
		
		
		System.out.println("operacion " + operacion);
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;

		
		//return null;
	}
}

