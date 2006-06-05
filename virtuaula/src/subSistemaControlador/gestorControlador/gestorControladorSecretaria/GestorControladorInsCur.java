package subSistemaControlador.gestorControlador.gestorControladorSecretaria;




import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.gestorControlador.GestorControlador;
/**
 * Devuelve los controladores de la insercion de un curso
 * @author Alberto Macho y Fco Javier Pérez Escrivá
 *
 */
public class GestorControladorInsCur extends GestorControladorSecretaria{
	
	
	/**
	 * Constructor
	 *
	 */
	public GestorControladorInsCur(){}
	/**
	 * Devuelve el Controlador adecuado para este perfil y esta operacion
	 */
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){

		CreadorControlador creadorcont=new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("INS_CUR_HOR",creadorcont.crear(CreadorControlador.ControladorInsCurHor));
		GestorControlador.tablaOperacionControlador.put("INS_CUR_AREA",creadorcont.crear(CreadorControlador.ControladorInsCurArea));
		GestorControlador.tablaOperacionControlador.put("INS_CUR_AULA",creadorcont.crear(CreadorControlador.ControladorInsCurAula));
		GestorControlador.tablaOperacionControlador.put("INS_CUR_PROF",creadorcont.crear(CreadorControlador.ControladorInsCurProf));
	
		GestorControlador.tablaOperacionControlador.put("INS_CUR_CON_PROF",creadorcont.crear(CreadorControlador.ControladorPasaPag));
		GestorControlador.tablaOperacionControlador.put("INSERTA_CURSO",creadorcont.crear(CreadorControlador.ControladorInsertaCurso));
		
		
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
		
		
		
	}
}

