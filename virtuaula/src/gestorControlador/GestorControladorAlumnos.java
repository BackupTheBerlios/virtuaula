package gestorControlador;

import java.util.Hashtable;

import javax.servlet.http.HttpSession;

import controlador.Controlador;
import controlador.controlConexiones.ControladorDesconectar;
import controlador.controlConsulEliAvisoProf.BorraAviso;
import controlador.controlConsulEliAvisoProf.ControladorOp_Avis_Prof;
import controlador.controlConsultaExpAlum.ControladorConExpAlum;
import controlador.controlPasaPag.ControladorPasaPag;

/**
 * 
 * @author Alberto Macho
 *
 */
public class GestorControladorAlumnos extends GestorControlador{
	/**
	 * tabla que guarda la relación entre una operación y su gestor
	 */
	private Hashtable tablaOperacionGestor;
	
	public GestorControladorAlumnos(){
		
		//añadimos a la tabla Operacion-Controlador los controladores necesarios para alumnos
		
		tablaOperacionGestor= new Hashtable();
	
		

	}
	public void inicializa(){
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		GestorControlador.tablaOperacionControlador.put("menuPrincipalAlum",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("desconectar",new ControladorDesconectar());
		// avisos alumno
		GestorControlador.tablaOperacionControlador.put("AVIS_ALUM",new ControladorOp_Avis_Prof());
		GestorControlador.tablaOperacionControlador.put("BOR_ALUM_AVIS",new BorraAviso());
		GestorControlador.tablaOperacionControlador.put("LEER_AVIS_ALUM",new ControladorPasaPag());
		//consulta expediente
		GestorControlador.tablaOperacionControlador.put("CONS_EXP_ALUM",new ControladorConExpAlum());
		
			
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		if (controladorResultado==null){
			controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
		}
		
		
		return controladorResultado;
	}
}
