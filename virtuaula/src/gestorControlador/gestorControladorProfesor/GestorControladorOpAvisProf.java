package gestorControlador.gestorControladorProfesor;

import gestorControlador.GestorControlador;

import javax.servlet.http.HttpSession;

import controlador.Controlador;
import controlador.controlConsulEliAvisoProf.BorraAviso;
import controlador.controlConsulEliAvisoProf.ControladorOp_Avis_Prof;
import controlador.controlPasaPag.ControladorPasaPag;
/**
 * 
 * @author Fco Javier Pérez Escrivá  Alberto Macho
 *
 */
public class GestorControladorOpAvisProf extends GestorControladorProfesor{

	
public GestorControladorOpAvisProf(){
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		GestorControlador.tablaOperacionControlador.put("OP_AVIS_PROF",new ControladorOp_Avis_Prof());
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_AVISOS_PROF",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("BORRA_AVISO",new BorraAviso());
		GestorControlador.tablaOperacionControlador.put("OP_AVIS_PROF_OPCIONES",new ControladorPasaPag());
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
	}
}
