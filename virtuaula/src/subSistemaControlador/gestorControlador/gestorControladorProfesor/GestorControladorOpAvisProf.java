package subSistemaControlador.gestorControlador.gestorControladorProfesor;


import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.BorraAviso;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.ControladorOp_Avis_Prof;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;

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
