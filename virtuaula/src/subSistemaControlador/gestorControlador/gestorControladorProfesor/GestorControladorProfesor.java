package subSistemaControlador.gestorControlador.gestorControladorProfesor;


import java.util.Hashtable;
import subSistemaControlador.controlador.controlConexiones.ControladorLogin;
import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.controlConexiones.ControladorDesconectar;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;

/**
 * 
 * @author Fco Javier P�rez Escriv�  Alberto Macho
 *
 */
public class GestorControladorProfesor extends GestorControlador{

	/**
	 * tabla que guarda la relaci�n entre una operaci�n y su gestor
	 */
	private Hashtable tablaOperacionGestor;
	
	public GestorControladorProfesor(){
		
		//a�adimos a la tabla Operacion-Controlador los controladores comunes en secretaria
		
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
		tablaOperacionGestor.put("PUB_NOTAS",new GestorControladorEditarFicha());

	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		GestorControlador.tablaOperacionControlador.put("menuPrincipalProf",new ControladorLogin());
		GestorControlador.tablaOperacionControlador.put("desconectar",new ControladorDesconectar());
		GestorControlador.tablaOperacionControlador.put("VOLVER_ANTERIOR",new ControladorPasaPag());
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		if (controladorResultado==null){
			controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
		}
		
		
		return controladorResultado;
	}
}
