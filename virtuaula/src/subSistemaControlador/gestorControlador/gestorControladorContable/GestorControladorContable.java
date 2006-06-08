package subSistemaControlador.gestorControlador.gestorControladorContable;


import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.controlador.Contable.ControladorConContrato;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;

/**
 * Devuelve los controladores de las sesion de un contable
 * @author AL
 *
 */
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
	/**
	 * Realiza la correspondencia entre una operacion y el gestorControlador que lo recoge
	 */
	public void inicializa(){
//		AVISOS
		tablaOperacionGestor.put("OP_AVIS_CONT",new GestorControladorOpAvisCont());
		tablaOperacionGestor.put("MOSTRAR_AVISOS_CONT",new GestorControladorOpAvisCont());
		tablaOperacionGestor.put("BORRA_AVISO_CONT",new GestorControladorOpAvisCont());
		tablaOperacionGestor.put("INI_AVI_CONT",new GestorControladorOpAvisCont());
		tablaOperacionGestor.put("ENV_AVI_CONT",new GestorControladorOpAvisCont());
	}
	/**
	 * Devuelve el Controlador adecuado para este perfil y esta operacion
	 */
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador c = new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("menuPrincipalCont",c.crear(CreadorControlador.ControladorLogin));
		GestorControlador.tablaOperacionControlador.put("desconectar",c.crear(CreadorControlador.ControladorDesconectar));
		GestorControlador.tablaOperacionControlador.put("OP_MOSTRAR_NOMINAS",c.crear(CreadorControlador.ControladorConNomina));
		GestorControlador.tablaOperacionControlador.put("OP_MOSTRAR_CONTRATOS",c.crear(CreadorControlador.ControladorConContrato));
		tablaOperacionGestor.put("VOLVER_ANTERIOR_C",new ControladorPasaPag());
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		if (controladorResultado==null){
			controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
		}
		
		
		return controladorResultado;
	}
}
