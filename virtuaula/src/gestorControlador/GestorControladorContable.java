package gestorControlador;

import java.util.Hashtable;

import javax.servlet.http.HttpSession;

import controlador.Controlador;
import controlador.controlConexiones.ControladorDesconectar;
import controlador.controlConsultaContrato.ControladorConContrato;
import controlador.controlConsultaNomina.ControladorConNomina;
import controlador.controlPasaPag.ControladorPasaPag;

public class GestorControladorContable extends GestorControlador{

	/**
	 * tabla que guarda la relación entre una operación y su gestor
	 */
	private Hashtable tablaOperacionGestor;
	
	public GestorControladorContable(){
		
		//añadimos a la tabla Operacion-Controlador los controladores comunes en secretaria
		
		tablaOperacionGestor= new Hashtable();
		GestorControlador.tablaOperacionControlador.put("OP_MOSTRAR_CONTRATOS",new ControladorConContrato());
		

	}
	public void inicializa(){
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		
		GestorControlador.tablaOperacionControlador.put("menuPrincipalCont",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("desconectar",new ControladorDesconectar());
		GestorControlador.tablaOperacionControlador.put("OP_MOSTRAR_NOMINAS",new ControladorConNomina());
		GestorControlador.tablaOperacionControlador.put("OP_MOSTRAR_CONTRATOS",new ControladorConContrato());
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		if (controladorResultado==null){
			controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
		}
		
		
		return controladorResultado;
	}
}
