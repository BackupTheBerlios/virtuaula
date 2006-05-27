package subSistemaControlador.gestorControlador.gestorControladorSecretaria;



import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.gestorControlador.GestorControlador;
/**
 * 
 * @author Fco Javier Pérez Escrivá
 *
 */
public class GestorControladorConsultaProf extends GestorControladorSecretaria{

	
	public GestorControladorConsultaProf(){
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador creadorcont=new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("CONS_PROF",creadorcont.crear(CreadorControlador.Cons_Prof));
		GestorControlador.tablaOperacionControlador.put("INI_CONS_PROF",creadorcont.crear(CreadorControlador.ControladorProfAreas));
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
	}
}
