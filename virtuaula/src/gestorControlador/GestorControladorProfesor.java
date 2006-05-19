package gestorControlador;

import java.util.Hashtable;

import javax.servlet.http.HttpSession;

import controlador.Controlador;
import controlador.controlConexiones.ControladorDesconectar;
import controlador.controlConsulEliAvisoProf.BorraAviso;
import controlador.controlPasaPag.ControladorPasaPag;
/**
 * 
 * @author Fco Javier Pérez Escrivá  Alberto Macho
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
		//		AVISOS
		tablaOperacionGestor.put("OP_AVIS_PROF",new GestorControladorOpAvisProf());
		tablaOperacionGestor.put("MOSTRAR_AVISOS_PROF",new GestorControladorOpAvisProf());
		tablaOperacionGestor.put("BORRA_AVISO",new GestorControladorOpAvisProf());
		tablaOperacionGestor.put("OP_AVIS_PROF_OPCIONES",new GestorControladorOpAvisProf());
		//		FICHAS
		tablaOperacionGestor.put("OP_MOSTRAR_CURSO_PROF",new GestorControladorEditarFicha());
		tablaOperacionGestor.put("ListarAlumnosCurso",new GestorControladorEditarFicha());
		tablaOperacionGestor.put("Ficha_Alumno_Prof",new GestorControladorEditarFicha());
		tablaOperacionGestor.put("ActualizarFichaAlumno",new GestorControladorEditarFicha());


	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		GestorControlador.tablaOperacionControlador.put("menuPrincipalProf",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("desconectar",new ControladorDesconectar());
		GestorControlador.tablaOperacionControlador.put("VOLVER_ANTERIOR",new ControladorPasaPag());
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		if (controladorResultado==null){
			controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
		}
		
		
		return controladorResultado;
	}
}
