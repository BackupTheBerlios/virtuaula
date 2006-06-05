package subSistemaControlador.gestorControlador.gestorControladorSecretaria;

import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.gestorControlador.GestorControlador;
/**
 * Devuelve los controladores necesarios para la baja de un curso
 * @author Fco Javier Pérez Escrivá
 *
 */
public class GestorControladorBajaCurso extends GestorControladorSecretaria{
	/**
	 * Constructor
	 *
	 */
	public GestorControladorBajaCurso(){}
	/**
	 * Devuelve el Controlador adecuado para este perfil y esta operacion
	 */
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador creadorcont=new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("GES_CUR",creadorcont.crear(CreadorControlador.ControladorPasaPag));
		GestorControlador.tablaOperacionControlador.put("BAJA_INI_CONS_CUR",creadorcont.crear(CreadorControlador.ControladorBajaIniConsCur));
		GestorControlador.tablaOperacionControlador.put("BAJA_CONS_CUR",creadorcont.crear(CreadorControlador.ControladorBajaConsCur));
		GestorControlador.tablaOperacionControlador.put("BAJA_MOSTRAR_CUR",creadorcont.crear(CreadorControlador.ControladorBajaMostrarCur));
		GestorControlador.tablaOperacionControlador.put("BAJA_DEF_CURSO",creadorcont.crear(CreadorControlador.ControladorBajaDefCurso));
		
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;

	}
}
