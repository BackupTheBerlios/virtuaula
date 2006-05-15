package gestorControlador;

import javax.servlet.http.HttpSession;



import controlador.Controlador;
/*
import controlador.controlEditarFicha.ActualizarFichaAlumno;
import controlador.controlEditarFicha.ControladorMostrarCursoProf;
import controlador.controlEditarFicha.FichaAlumnoProf;
import controlador.controlEditarFicha.ListarAlumnosCurso;
*/
import controlador.controlPasaPag.ControladorPasaPag;
/**
 * 
 * @author Alberto Macho
 *
 */
public class GestorControladorEditarFicha extends GestorControladorProfesor{

	public GestorControladorEditarFicha(){
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
/*		
		//GestorControlador.tablaOperacionControlador.put("OP_AVIS_PROF",new ControladorOp_Avis_Prof());
		//GestorControlador.tablaOperacionControlador.put("MOSTRAR_AVISOS_PROF",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("OP_MOSTRAR_CURSO_PROF",new ControladorMostrarCursoProf());
		GestorControlador.tablaOperacionControlador.put("ListarAlumnosCurso",new ListarAlumnosCurso());
		GestorControlador.tablaOperacionControlador.put("Ficha_Alumno_Prof",new FichaAlumnoProf());
		GestorControlador.tablaOperacionControlador.put("ActualizarFichaAlumno",new ActualizarFichaAlumno());
		GestorControlador.tablaOperacionControlador.put("menuPrincipalProf",new ControladorPasaPag());
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
	
		return controladorResultado;
		*/
		return null;
	}

}
