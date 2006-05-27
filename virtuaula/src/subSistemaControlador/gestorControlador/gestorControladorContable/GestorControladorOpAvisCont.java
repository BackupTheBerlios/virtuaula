package subSistemaControlador.gestorControlador.gestorControladorContable;


import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.BorraAviso;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.ControladorOp_Avis_Cont;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.ControladorOp_Avis_Prof;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;


public class GestorControladorOpAvisCont extends GestorControladorContable{

	
public GestorControladorOpAvisCont(){
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		GestorControlador.tablaOperacionControlador.put("OP_AVIS_CONT",new ControladorOp_Avis_Prof());
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_AVISOS_CONT",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("BORRA_AVISO_CONT",new BorraAviso());
		GestorControlador.tablaOperacionControlador.put("VOLVER_ANTERIOR_C",new ControladorPasaPag());
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		return controladorResultado;
	}
}
