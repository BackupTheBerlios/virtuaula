package subSistemaControlador.gestorControlador.gestorControladorContable;


import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.BorraAviso;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.ControladorOp_Avis;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;
import subSistemaControlador.controlador.CreadorControlador;


public class GestorControladorOpAvisCont extends GestorControladorContable{

	
public GestorControladorOpAvisCont(){
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador c= new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("OP_AVIS_CONT",c.crear(CreadorControlador.ControladorOp_Avis));
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_AVISOS_CONT",c.crear(CreadorControlador.ControladorLeerAviso));
		GestorControlador.tablaOperacionControlador.put("BORRA_AVISO_CONT",c.crear(CreadorControlador.BorraAviso));
		GestorControlador.tablaOperacionControlador.put("VOLVER_ANTERIOR_C",c.crear(CreadorControlador.ControladorPasaPag));	
		GestorControlador.tablaOperacionControlador.put("INI_AVI_CONT",c.crear(CreadorControlador.IniEnviarAvisoContable));
		GestorControlador.tablaOperacionControlador.put("ENV_AVI_CONT",c.crear(CreadorControlador.EnviarAvisoContable));
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		return controladorResultado;
	}
}
