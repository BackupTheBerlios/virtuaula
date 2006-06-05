package subSistemaControlador.gestorControlador.gestorControladorSecretaria;

import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.gestorControlador.GestorControlador;
/**
 * Devuelve los controladores para realizar la edicion de los datos de un alumno
 * @author JORGE SANCHEZ
 *
 */
public class GestorControladorEditarAlumno extends GestorControladorSecretaria {
	/**
	 * Devuelve el Controlador adecuado para este perfil y esta operacion
	 */
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador creadorcont=new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("EDITAR_ALUM_INI",creadorcont.crear(CreadorControlador.ContEditarAlumnoIni));
		GestorControlador.tablaOperacionControlador.put("BUSCAR_ALUM_EDITAR",creadorcont.crear(CreadorControlador.ControladorBuscarAlumEditar));
		GestorControlador.tablaOperacionControlador.put("SELEC_EDITAR_ALUMNO",creadorcont.crear(CreadorControlador.ControladorSelecEditarAlum));
		GestorControlador.tablaOperacionControlador.put("CONF_EDITAR_ALUMNO",creadorcont.crear(CreadorControlador.ControladorConfEditarAlum));
		GestorControlador.tablaOperacionControlador.put("FIN_EDITAR_ALUMNO",creadorcont.crear(CreadorControlador.ControladorFinEditarAlum));
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
	}

}
