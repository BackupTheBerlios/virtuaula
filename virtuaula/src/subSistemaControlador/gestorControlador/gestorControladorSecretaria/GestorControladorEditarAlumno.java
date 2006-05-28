package subSistemaControlador.gestorControlador.gestorControladorSecretaria;

import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.gestorControlador.GestorControlador;
/**
 * 
 * @author JORGE SANCHEZ
 *
 */
public class GestorControladorEditarAlumno extends GestorControladorSecretaria {
	
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador creadorcont=new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("EDITAR_ALUM_INI",creadorcont.crear(CreadorControlador.ControladorPasaPag));
		GestorControlador.tablaOperacionControlador.put("BUSCAR_ALUM_EDITAR",creadorcont.crear(CreadorControlador.ControladorBuscarAlumEditar));
		GestorControlador.tablaOperacionControlador.put("SELEC_EDITAR_ALUMNO",creadorcont.crear(CreadorControlador.ControladorSelecEditarAlum));
		GestorControlador.tablaOperacionControlador.put("CONF_EDITAR_ALUMNO",creadorcont.crear(CreadorControlador.ControladorConfEditarAlum));
		GestorControlador.tablaOperacionControlador.put("FIN_EDITAR_ALUMNO",creadorcont.crear(CreadorControlador.ControladorFinEditarAlum));
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
	}

}
