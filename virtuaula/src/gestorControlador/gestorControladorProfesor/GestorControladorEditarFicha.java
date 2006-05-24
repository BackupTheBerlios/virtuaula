package gestorControlador.gestorControladorProfesor;


import gestorControlador.GestorControlador;

import javax.servlet.http.HttpSession;



import controlador.Controlador;

import controlador.ControladorProfesor.controlEditarFicha.ActualizarFichaAlumno;
import controlador.ControladorProfesor.controlEditarFicha.ControladorMostrarCursoProf;
import controlador.ControladorProfesor.controlEditarFicha.FichaAlumnoProf;
import controlador.ControladorProfesor.controlEditarFicha.ListarAlumnosCurso;
import controlador.ControladorProfesor.controlEditarFicha.PublicarNotas;
/**
 * 
 * @author Fco Javier Pérez Escrivá Alberto Macho
 *
 */
public class GestorControladorEditarFicha extends GestorControladorProfesor{
	
	
	public GestorControladorEditarFicha(){
		
	}
	
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){

		GestorControlador.tablaOperacionControlador.put("OP_MOSTRAR_CURSO_PROF",new ControladorMostrarCursoProf());
		GestorControlador.tablaOperacionControlador.put("ListarAlumnosCurso",new ListarAlumnosCurso());
		GestorControlador.tablaOperacionControlador.put("Ficha_Alumno_Prof",new FichaAlumnoProf());
		GestorControlador.tablaOperacionControlador.put("ActualizarFichaAlumno",new ActualizarFichaAlumno());
		GestorControlador.tablaOperacionControlador.put("PUB_NOTAS",new PublicarNotas());
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
		
	}

}
