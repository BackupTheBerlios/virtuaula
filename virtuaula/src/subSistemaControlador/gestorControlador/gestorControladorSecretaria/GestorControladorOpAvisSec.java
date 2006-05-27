package subSistemaControlador.gestorControlador.gestorControladorSecretaria;


import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.BorraAviso;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.ControladorOp_Avis;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;


public class GestorControladorOpAvisSec extends GestorControladorSecretaria{

	
public GestorControladorOpAvisSec(){
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		GestorControlador.tablaOperacionControlador.put("OP_AVIS_SEC",new ControladorOp_Avis());
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_AVISOS_SEC",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("BORRA_AVISO_SEC",new BorraAviso());
		GestorControlador.tablaOperacionControlador.put("VOLVER_ANTERIOR_S",new ControladorPasaPag());
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		return controladorResultado;
	}
}
