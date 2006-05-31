package subSistemaControlador.gestorControlador.gestorControladorRRHH;

import java.util.Hashtable;
import javax.servlet.http.HttpSession;
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.gestorControlador.GestorControlador;

/**
 * Devuelve los controladores de la sesion de un personal de RRHH
 * @author Javi
 *
 */
public class GestorControladorRRHH extends GestorControlador{
	/**
	 * tabla que guarda la relación entre una operación y su gestor
	 */
	private Hashtable tablaOperacionGestor;
	
	public GestorControladorRRHH(){
		
		//añadimos a la tabla Operacion-Controlador los controladores necesarios para alumnos
		
		tablaOperacionGestor= new Hashtable();
	
		

	}
	public void inicializa(){
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador c = new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("menuPrincipalRRHH",c.crear(CreadorControlador.ControladorLogin));
		GestorControlador.tablaOperacionControlador.put("desconectar",c.crear(CreadorControlador.ControladorDesconectar));
		GestorControlador.tablaOperacionControlador.put("INI_INS_PROF",c.crear(CreadorControlador.ControladorIniInsProf));
		GestorControlador.tablaOperacionControlador.put("INS_PROF",c.crear(CreadorControlador.ControladorInsProf));
		GestorControlador.tablaOperacionControlador.put("CONTRATO",c.crear(CreadorControlador.ControladorPasaPag));
		//avisos rrhh
		GestorControlador.tablaOperacionControlador.put("AVIS_RRHH",c.crear(CreadorControlador.ControladorOp_Avis));
		GestorControlador.tablaOperacionControlador.put("BOR_RRHH_AVIS",c.crear(CreadorControlador.BorraAviso));
		GestorControlador.tablaOperacionControlador.put("LEER_AVIS_RRHH",c.crear(CreadorControlador.ControladorLeerAviso));
		GestorControlador.tablaOperacionControlador.put("VOLVER_ANTERIOR",c.crear(CreadorControlador.ControladorPasaPag));	
			
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		if (controladorResultado==null){
			controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
		}
		
		
		return controladorResultado;
	}
}
