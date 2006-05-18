package gestores;

import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

/**
 * 
 * @author Alberto Macho
 * Se encarga de realizar todas las operaciones necesarias para gestionar los alumnos
 * Se ayudara de otros gestores para realizar dichas operaciones. Tambien se encarga de comprobar
 * que los datos de un alumno esten bien introducidos.
 *
 */
public class GestorAlumnos {
	
	public ListaObjetoBean consultaCursosActivos()
	{
		//TODO falta por hacer
		GestorCursos GC = new GestorCursos();
		return null;
		//return GC.consultaCursosActivos();
	}
	
	public ObjetoBean consultaClaseCurso(ObjetoBean Curso)
	{
		return null;
	}
	public ObjetoBean consultaProfesorCurso(ObjetoBean Curso)
	{
		return null;
	}
	public ObjetoBean consultaAulaCurso(ObjetoBean Curso)
	{
		return null;
	}
	public ObjetoBean consultaHorarioCurso(ObjetoBean Curso)
	{
		return null;
	}
	public ObjetoBean consultaCurso()
	{
		return null;
	}
	public boolean existeAlumno(ObjetoBean Alumno)
	{
		return false;
	}
	public ObjetoBean consultaUsuario(ObjetoBean Usuario)
	{
		return null;
	}
}
