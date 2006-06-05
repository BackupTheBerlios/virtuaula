package subSistemaControlador.gestorControlador.gestorControladorSecretaria;



import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.gestorControlador.GestorControlador;
/**
 * Devuelve los controladores para la consulta de un curso
 * @author Alberto Macho y Fco Javier Pérez Escrivá
 *
 */
public class GestorControladorConsultaCurso extends GestorControladorSecretaria{
	
	/**
	 * Constructor
	 *
	 */
	public GestorControladorConsultaCurso(){}
	/**
	 * Devuelve el Controlador adecuado para este perfil y esta operacion
	 */
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador creadorcont=new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("GES_CUR",creadorcont.crear(CreadorControlador.ControladorPasaPag));
		GestorControlador.tablaOperacionControlador.put("INI_CONS_CUR",creadorcont.crear(CreadorControlador.ControladorIniConsCur));
		GestorControlador.tablaOperacionControlador.put("CONS_CUR",creadorcont.crear(CreadorControlador.ControladorConsCur));
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_CUR",creadorcont.crear(CreadorControlador.ControladorMostrarCur));
		
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;

		
		//return null;
	}
}
