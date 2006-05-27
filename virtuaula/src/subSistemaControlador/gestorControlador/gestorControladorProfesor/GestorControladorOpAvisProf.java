package subSistemaControlador.gestorControlador.gestorControladorProfesor;


import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorProfesor.controlEnviarAviso.EnviarAvisoProf;
import subSistemaControlador.controlador.ControladorProfesor.controlEnviarAviso.IniEnviarAvisoProf;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.BorraAviso;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.ControladorOp_Avis;
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
		GestorControlador.tablaOperacionControlador.put("OP_AVIS_PROF",new ControladorOp_Avis());
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_AVISOS_PROF",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("BORRA_AVISO",new BorraAviso());
		GestorControlador.tablaOperacionControlador.put("OP_AVIS_PROF_OPCIONES",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("INI_AVI_PROF",new IniEnviarAvisoProf());
		GestorControlador.tablaOperacionControlador.put("ENV_AVI_PROF",new EnviarAvisoProf());
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
	}
}
