package subSistemaControlador.gestorControlador.gestorControladorAlumnos;


import java.util.Hashtable;
import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;

import subSistemaControlador.gestorControlador.GestorControlador;


/**
 * Devuelve los controladores de las sesion de un alumno
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
	/**
	 * Realiza la correspondencia entre una operacion y el gestorControlador que lo recoge
	 */
	public void inicializa(){}
	/**
	 * Devuelve el Controlador adecuado para este perfil y esta operacion
	 */
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador c = new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("menuPrincipalAlum",c.crear(CreadorControlador.ControladorLogin));
		GestorControlador.tablaOperacionControlador.put("desconectar",c.crear(CreadorControlador.ControladorDesconectar));
		// avisos alumno
		GestorControlador.tablaOperacionControlador.put("AVIS_ALUM",c.crear(CreadorControlador.ControladorOp_Avis));
		GestorControlador.tablaOperacionControlador.put("BOR_ALUM_AVIS",c.crear(CreadorControlador.BorraAviso));
		GestorControlador.tablaOperacionControlador.put("LEER_AVIS_ALUM",c.crear(CreadorControlador.ControladorLeerAviso));
		GestorControlador.tablaOperacionControlador.put("VOLVER_ANTERIOR",c.crear(CreadorControlador.ControladorPasaPag));
		//consulta expediente
		GestorControlador.tablaOperacionControlador.put("CONS_EXP_ALUM",c.crear(CreadorControlador.ControladorConExpAlum));
		
			
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		if (controladorResultado==null){
			controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
		}
		
		
		return controladorResultado;
	}
}
