package subSistemaControlador.gestorControlador.gestorControladorSecretaria;


import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.BorraAviso;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.ControladorOp_Avis;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;


public class GestorControladorOpAvisSec extends GestorControladorSecretaria{

	
public GestorControladorOpAvisSec(){
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador creadorcont=new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("OP_AVIS_SEC",creadorcont.crear(CreadorControlador.ControladorOp_Avis));
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_AVISOS_SEC",creadorcont.crear(CreadorControlador.ControladorLeerAviso));
		GestorControlador.tablaOperacionControlador.put("BORRA_AVISO_SEC",creadorcont.crear(CreadorControlador.BorraAviso));
		GestorControlador.tablaOperacionControlador.put("VOLVER_ANTERIOR_S",creadorcont.crear(CreadorControlador.ControladorPasaPag));
		GestorControlador.tablaOperacionControlador.put("ENV_AVISO_INI_SEC",creadorcont.crear(CreadorControlador.IniEnviarAvisoSec));
		GestorControlador.tablaOperacionControlador.put("ENV_AVI_SEC",creadorcont.crear(CreadorControlador.EnviarAvisoSec));
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
	}
}
