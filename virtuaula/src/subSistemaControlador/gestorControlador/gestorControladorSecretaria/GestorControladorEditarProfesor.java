package subSistemaControlador.gestorControlador.gestorControladorSecretaria;

import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.controlador.ControladorSecretaria.controlEditarProf.ControladorEditaProf;
import subSistemaControlador.gestorControlador.GestorControlador;
/**
 * Devuelve los controladores de la edicion de un profesor
 * @author Alberto Macho y Fco Javier Pérez Escrivá
 *
 */
public class GestorControladorEditarProfesor extends GestorControladorSecretaria{

	
	public GestorControladorEditarProfesor(){
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador creadorcont=new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("EDI_CONS_PROF",creadorcont.crear(CreadorControlador.Cons_Prof));
		GestorControlador.tablaOperacionControlador.put("EDI_INI_CONS_PROF",creadorcont.crear(CreadorControlador.ControladorProfAreas));
		GestorControlador.tablaOperacionControlador.put("EDI_MOSTRAR_PROF",creadorcont.crear(CreadorControlador.ControladorMostrarProf));
		GestorControlador.tablaOperacionControlador.put("EDITA_PROF",new ControladorEditaProf());
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
	}
}
