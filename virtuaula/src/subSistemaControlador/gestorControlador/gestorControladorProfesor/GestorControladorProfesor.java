package subSistemaControlador.gestorControlador.gestorControladorProfesor;


import java.util.Hashtable;
import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.gestorControlador.GestorControlador;

/**
 * Devuelve los controladores de las sesion de un profesor
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
	/**
	 * Realiza la correspondencia entre una operacion y el gestorControlador que lo recoge
	 */
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
		tablaOperacionGestor.put("PUB_NOTAS",new GestorControladorEditarFicha());

	}
	/**
	 * Devuelve el Controlador adecuado para este perfil y esta operacion
	 */
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador c= new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("menuPrincipalProf",c.crear(CreadorControlador.ControladorLogin));
		GestorControlador.tablaOperacionControlador.put("desconectar",c.crear(CreadorControlador.ControladorDesconectar));
		GestorControlador.tablaOperacionControlador.put("VOLVER_ANTERIOR",c.crear(CreadorControlador.ControladorPasaPag));
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		if (controladorResultado==null){
			controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
		}
		
		
		return controladorResultado;
	}
}
