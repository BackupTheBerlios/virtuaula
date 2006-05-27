package subSistemaControlador.gestorControlador.gestorControladorAlumnos;


import java.util.Hashtable;
import subSistemaControlador.controlador.controlConexiones.ControladorLogin;
import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorAlumnos.controlConsultaExpAlum.ControladorConExpAlum;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.BorraAviso;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.ControladorOp_Avis;
import subSistemaControlador.controlador.controlConexiones.ControladorDesconectar;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;


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
		GestorControlador.tablaOperacionControlador.put("menuPrincipalAlum",new ControladorLogin());
		GestorControlador.tablaOperacionControlador.put("desconectar",new ControladorDesconectar());
		// avisos alumno
		GestorControlador.tablaOperacionControlador.put("AVIS_ALUM",new ControladorOp_Avis());
		GestorControlador.tablaOperacionControlador.put("BOR_ALUM_AVIS",new BorraAviso());
		GestorControlador.tablaOperacionControlador.put("LEER_AVIS_ALUM",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("VOLVER_ANTERIOR",new ControladorPasaPag());
		//consulta expediente
		GestorControlador.tablaOperacionControlador.put("CONS_EXP_ALUM",new ControladorConExpAlum());
		
			
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		if (controladorResultado==null){
			controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
		}
		
		
		return controladorResultado;
	}
}
