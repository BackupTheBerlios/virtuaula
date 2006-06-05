package subSistemaControlador.gestorControlador.gestorControladorSecretaria;


import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.gestorControlador.GestorControlador;

/**
 * Devuelve los controladores de la consulta y borrado de avisos de una secretaria
 * @author Fco Javier Pérez Escrivá
 *
 */
public class GestorControladorOpAvisSec extends GestorControladorSecretaria{

	
public GestorControladorOpAvisSec(){}
	/**
	 * Devuelve el Controlador adecuado para este perfil y esta operacion 
	 */
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
