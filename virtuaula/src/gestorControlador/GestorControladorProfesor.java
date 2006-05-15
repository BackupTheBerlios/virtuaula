package gestorControlador;

import java.util.Hashtable;

import javax.servlet.http.HttpSession;

import controlador.Controlador;
import controlador.controlConexiones.ControladorDesconectar;
import controlador.controlPasaPag.ControladorPasaPag;
/**
 * 
 * @author Alberto Macho
 *
 */
public class GestorControladorProfesor extends GestorControlador{

	/**
	 * tabla que guarda la relación entre una operación y su gestor
	 */
	private Hashtable tablaOperacionGestor;
	
	public GestorControladorProfesor(){
		
		//añadimos a la tabla Operacion-Controlador los controladores comunes en secretaria
		
		tablaOperacionGestor= new Hashtable();
	
		

	}
	public void inicializa(){
		tablaOperacionGestor.put("OP_AVIS_PROF",new GestorControladorOpAvisProf());
		tablaOperacionGestor.put("OP_MOSTRAR_CURSO_PROF",new GestorControladorEditarFicha());
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		GestorControlador.tablaOperacionControlador.put("menuPrinPalProf",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("desconectar",new ControladorDesconectar());
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_AVISOS_PROF",new ControladorPasaPag());
		//GestorControlador.tablaOperacionControlador.put("INI_CONS_PROF",new ControladorPasaPag());
		//GestorControlador.tablaOperacionControlador.put("MOSTRAR_PROF",new ControladorPasaPag());
		//GestorControlador.tablaOperacionControlador.put("BORRAR_AVISO",new BorraAviso());
		GestorControlador.tablaOperacionControlador.put("VOLVER_ANTERIOR",new ControladorPasaPag());
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		if (controladorResultado==null){
			controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
		}
		
		
		return controladorResultado;
	}
}
