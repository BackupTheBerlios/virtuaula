package subSistemaControlador.gestorControlador.gestorControladorProfesor;



import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.gestorControlador.GestorControlador;




/**
 * Devuelve los controladores de la consulta de cursos, alumnos, fichas(edicion) y publicar notas
 * @author Fco Javier Pérez Escrivá Alberto Macho
 *
 */
public class GestorControladorEditarFicha extends GestorControladorProfesor{
	
	/**
	 * Constructor
	 */
	public GestorControladorEditarFicha(){
		
	}
	/**
	 * Devuelve el Controlador adecuado para este perfil y esta operacion
	 */
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador c = new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("OP_MOSTRAR_CURSO_PROF",c.crear(CreadorControlador.ControladorMostrarCursoProf));
		GestorControlador.tablaOperacionControlador.put("ListarAlumnosCurso",c.crear(CreadorControlador.ListarAlumnosCurso));
		GestorControlador.tablaOperacionControlador.put("Ficha_Alumno_Prof",c.crear(CreadorControlador.FichaAlumnoProf));
		GestorControlador.tablaOperacionControlador.put("ActualizarFichaAlumno",c.crear(CreadorControlador.ActualizarFichaAlumno));
		GestorControlador.tablaOperacionControlador.put("PUB_NOTAS",c.crear(CreadorControlador.PublicarNotas));
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
		
	}

}
