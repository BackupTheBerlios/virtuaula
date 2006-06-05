package subSistemaControlador.gestorControlador.gestorControladorProfesor;


import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.gestorControlador.GestorControlador;

/**
 * Devuelve los controladores de la consulta y borrado de avisos de un profesor
 * @author Fco Javier Pérez Escrivá  Alberto Macho
 *
 */
public class GestorControladorOpAvisProf extends GestorControladorProfesor{

	/**
	 * Constructor
	 *
	 */
	public GestorControladorOpAvisProf(){}
	/**
	 * Devuelve el Controlador adecuado para este perfil y esta operacion
	 */
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador c = new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("OP_AVIS_PROF",c.crear(CreadorControlador.ControladorOp_Avis));
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_AVISOS_PROF",c.crear(CreadorControlador.ControladorLeerAviso));
		GestorControlador.tablaOperacionControlador.put("BORRA_AVISO",c.crear(CreadorControlador.BorraAviso));
		GestorControlador.tablaOperacionControlador.put("OP_AVIS_PROF_OPCIONES",c.crear(CreadorControlador.ControladorPasaPag));
		GestorControlador.tablaOperacionControlador.put("INI_AVI_PROF",c.crear(CreadorControlador.IniEnviarAvisoProf));
		GestorControlador.tablaOperacionControlador.put("ENV_AVI_PROF",c.crear(CreadorControlador.EnviarAvisoProf));
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
	}
}
