package subSistemaControlador.gestorControlador.gestorControladorSecretaria;

import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorSecretaria.controlBajaCur.ControladorBajaConsCur;
import subSistemaControlador.controlador.ControladorSecretaria.controlBajaCur.ControladorBajaDefCurso;
import subSistemaControlador.controlador.ControladorSecretaria.controlBajaCur.ControladorBajaIniConsCur;
import subSistemaControlador.controlador.ControladorSecretaria.controlBajaCur.ControladorBajaMostrarCur;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;

public class GestorControladorBajaCurso extends GestorControladorSecretaria{
	public GestorControladorBajaCurso(){}
	
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		GestorControlador.tablaOperacionControlador.put("GES_CUR",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("BAJA_INI_CONS_CUR",new ControladorBajaIniConsCur());
		GestorControlador.tablaOperacionControlador.put("BAJA_CONS_CUR",new ControladorBajaConsCur());
		GestorControlador.tablaOperacionControlador.put("BAJA_MOSTRAR_CUR",new ControladorBajaMostrarCur());
		GestorControlador.tablaOperacionControlador.put("BAJA_DEF_CURSO",new ControladorBajaDefCurso());
		
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;

		
		//return null;
	}
}
