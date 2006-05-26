package subSistemaControlador.gestorControlador.gestorControladorRRHH;



import java.util.Hashtable;

import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.Contable.ControladorConContrato;
import subSistemaControlador.controlador.controlConexiones.ControladorLogin;
import subSistemaControlador.controlador.Contable.ControladorConNomina;
import subSistemaControlador.controlador.controlConexiones.ControladorDesconectar;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;
import subSistemaControlador.controlador.ControladorRecHumanos.controlInsertarProfesor.*;


public class GestorControladorRRHH extends GestorControlador{

	/**
	 * tabla que guarda la relación entre una operación y su gestor
	 */
	private Hashtable tablaOperacionGestor;
	
	public GestorControladorRRHH(){
		
		
		tablaOperacionGestor= new Hashtable();
		

	}
	public void inicializa(){
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		
		GestorControlador.tablaOperacionControlador.put("menuPrincipalRRHH",new ControladorLogin());
		GestorControlador.tablaOperacionControlador.put("desconectar",new ControladorDesconectar());
		GestorControlador.tablaOperacionControlador.put("INI_INS_PROF",new ControladorIniInsProf());
		GestorControlador.tablaOperacionControlador.put("INS_PROF",new ControladorInsProf());
		GestorControlador.tablaOperacionControlador.put("CONTRATO",new ControladorPasaPag());
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		if (controladorResultado==null){
			controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
		}
		
		
		return controladorResultado;
	}
}
