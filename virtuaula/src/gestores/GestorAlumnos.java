package gestores;

import beans.CreadorBean;
import beans.Error;
import beans.ObjetoBean;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.utils.Constantes;

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
	
/*	public ObjetoBean consultaClaseCurso(ObjetoBean Curso)
	{
		return null;
	}*/
	public ObjetoBean consultaProfesorCurso(ObjetoBean Curso)
	{
		GestorCursos GC = new GestorCursos();
		return GC.consultaProfesorDeCurso(Curso);
		
	}
	public ObjetoBean consultaAulaCurso(ObjetoBean Curso)
	{
		GestorCursos GC = new GestorCursos();
		return GC.consultaAulaDeCurso(Curso);
	
	}
	public ObjetoBean consultaHorarioCurso(ObjetoBean Curso)
	{	
		GestorCursos GC = new GestorCursos();
		return GC.consultaHorarioDeCurso(Curso);
		
	}
	/*public ObjetoBean consultaCurso()
	{
		return null;
	}*/
	public boolean existeAlumno(ObjetoBean Alumno)
	{
		BBDDFachada bd = BBDDFachada.getInstance(); 
		ListaObjetoBean l=bd.consultar(Alumno);
		if (!l.esVacio())
		{
			return true;
		}
		else return false;
	}
	/**
	 * Le meto un beanUsuario y me devolvera un beanUsuario unico, ya que consulto
	 * por el DNI 
	 * @param Usuario
	 * @return
	 */
	public ObjetoBean consultaUsuario(ObjetoBean Usuario)
	{
		BBDDFachada bd = BBDDFachada.getInstance(); 
		ListaObjetoBean l=bd.consultar(Usuario);
		return l.dameObjeto(0);
	
	}
	/**
	 * Me comprueba que los datos introducidos son correctos, es decir, que los
	 * campos obligatorios estan rellenos y si hay alguno numerico que no 
	 * contenga letras
	 * @param bean
	 * @return
	 */
	private ListaObjetoBean comprobar(ObjetoBean bean)
	{
		CreadorListaObjetoBean c = new CreadorListaObjetoBean();
		CreadorBean cBean = new CreadorBean();
		ListaObjetoBean l = c.crear();
		String mensaje = "";
		int i = 0;
		
		//Compruebo que el DNI no se haya dejado vacio
		if (bean.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI).equals("")) {
			mensaje = "El campo DNI no ha sido rellenado,por favor introduzca uno";
			ObjetoBean error = cBean.crear(cBean.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			l.insertar(i, error);
			i++;
		}
		//Compruebo que el Nombre no se haya dejado vacío
		if (bean.dameValor(Constantes.ALUMNO_NOMBRE).equals("")) {
			mensaje = "El campo Nombre no ha sido rellenado,por favor introduzca uno";
			ObjetoBean error = cBean.crear(cBean.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			l.insertar(i, error);
			i++;
		}
		//Compruebo que el campo Apellido1 no se haya dejado en blanco
		if (bean.dameValor(Constantes.ALUMNO_APELLIDO1).equals("")) {
			mensaje = "El campo Apellido1 no ha sido rellenado,por favor introduzca uno";
			ObjetoBean error = cBean.crear(cBean.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			l.insertar(i, error);
			i++;
		}
		//Compruebo que el campo Apellido2 no se haya dejado en blanco
		if (bean.dameValor(Constantes.ALUMNO_APELLIDO2).equals("")) {
			mensaje = "El campo Apellido2 no ha sido rellenado,por favor introduzca uno";
			ObjetoBean error = cBean.crear(cBean.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			l.insertar(i, error);
			i++;
		}
		
		
		return l;
	}
	public ListaObjetoBean marticularAlumno(ObjetoBean Alumno,ObjetoBean Profesor)
	{
		ListaObjetoBean liserror=this.comprobar(Alumno);
		//no hay ningun dato introducido incorrecto.
		if (liserror==null)
		{
			//si el alumno ya existe
			if (this.existeAlumno(Alumno))
			{
				
			}
		}
		//tiene que comprobar que los datos introducidos son correctos
		//Tambien deberia mandar un aviso al usuario para comunicarle su usuario y contraseña.
		return null;
	}
}
