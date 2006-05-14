package gestorControlador;

import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import controlPasaPag.ControladorPasaPag;
import controlConexiones.ControladorDesconectar;
import controlador.Controlador;

public class GestorControladorSecretaria extends GestorControlador{
	/**
	 * tabla que guarda la relación entre una operación y su gestor
	 */
	private Hashtable tablaOperacionGestor;
	
	public GestorControladorSecretaria(){
		
		//añadimos a la tabla Operacion-Controlador los controladores comunes en secretaria
		
		tablaOperacionGestor= new Hashtable();
	
		

	}
	public void inicializa(){
		tablaOperacionGestor.put("CONS_PROF",new GestorControladorConsultaProf());
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		GestorControlador.tablaOperacionControlador.put("menuPrincipalSec",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("desconectar",new ControladorDesconectar());
		GestorControlador.tablaOperacionControlador.put("GES_PROF",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("INI_CONS_PROF",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_PROF",new ControladorPasaPag());
		
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		if (controladorResultado==null){
			controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
		}
		
		
		return controladorResultado;
	}
}
