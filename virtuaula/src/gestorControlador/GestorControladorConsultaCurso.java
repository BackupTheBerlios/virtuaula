package gestorControlador;

import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import controlador.Controlador;
import controlador.controlConexiones.ControladorDesconectar;
import controlador.controlConsulCur.ControladorConsCur;
import controlador.controlConsulCur.ControladorIniConsCur;
import controlador.controlConsulCur.ControladorMostrarCur;
import controlador.controlPasaPag.ControladorPasaPag;
/**
 * 
 * @author Alberto Macho
 *
 */
public class GestorControladorConsultaCurso extends GestorControladorSecretaria{
	
	
	public GestorControladorConsultaCurso(){}
	
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		//GestorControlador.tablaOperacionControlador.put("menuPrincipalSec",new ControladorPasaPag());
		//GestorControlador.tablaOperacionControlador.put("desconectar",new ControladorDesconectar());
		
		GestorControlador.tablaOperacionControlador.put("GES_CUR",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("INI_CONS_CUR",new ControladorIniConsCur());
		GestorControlador.tablaOperacionControlador.put("CONS_CUR",new ControladorConsCur());
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_CUR",new ControladorMostrarCur());
		
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;

		
		//return null;
	}
}
