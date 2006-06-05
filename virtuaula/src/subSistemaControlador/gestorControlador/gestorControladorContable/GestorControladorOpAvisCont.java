package subSistemaControlador.gestorControlador.gestorControladorContable;


import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.gestorControlador.GestorControlador;
import subSistemaControlador.controlador.CreadorControlador;


public class GestorControladorOpAvisCont extends GestorControladorContable{

/**
 * Clase que devuelve los controladores de la operacion de ver los avisos del contable
 *
 */
public GestorControladorOpAvisCont(){}
	/**
	 * Devuelve el Controlador adecuado para este perfil y esta operacion
	 */
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
