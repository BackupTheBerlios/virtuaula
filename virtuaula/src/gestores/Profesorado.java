package gestores;

import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.utils.Constantes;
import beans.CreadorBean;
import beans.Error;
import beans.Ficha;
import beans.ObjetoBean;
import beans.Profesor;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

public class Profesorado {
	
	public Profesorado() {
		super();
	}
	/**
	 * Consulta todos los profesores
	 * @return
	 */
	public ListaObjetoBean consultaProfesores() {	
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean cBean = new CreadorBean();
		Profesor profesor = (Profesor) cBean.crear(11);
		ListaObjetoBean l = bdf.consultar(profesor);
		return l;
	}
	/**
	 * Consulta todos los profesores que esten libres en un horario
	 * @param beanHorario
	 * @return
	 */
	public ListaObjetoBean consultaProfesoresPorHorario (ObjetoBean beanHorario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.dameProfesoresLibres(beanHorario);	
		return l;
	}
	/**
	 * Consulta todas las areas
	 * @return
	 */
	public ListaObjetoBean consultaAreas() {
		GestorAreas ga = new GestorAreas();
		return ga.consultaAreas();
	}
	/**
	 * Consulta de un area por un objeto bean area
	 * @param bean
	 * @return
	 */
	public ListaObjetoBean consultaArea(ObjetoBean bean)
	{
		GestorAreas ga = new GestorAreas();
		return ga.consultaArea(bean);
	}
	/**
	 * Consulta un profesor con las caracteristicas de un bean profesor que
	 * le pasamos por parametro
	 * @param beanProfesor
	 * @return
	 */
	public ListaObjetoBean consultaProfesor(ObjetoBean beanProfesor) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.consultar(beanProfesor);
		return l;
	}
	
	/**
	 * Consulta los cursos de un profesor en concreto
	 * @param beanProfesor
	 * @return
	 */
	public ListaObjetoBean consultaCursosProfesor(ObjetoBean beanProfesor) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.dameCursosProfesor(beanProfesor);
		return l;
	}
	/**
	 * Consulta la ficha de un alumno, nos devuelve una ficha
	 * @param beanAlumno
	 * @param beanCurso
	 * @return
	 */
	public Ficha consultaFichaDeAlumno(ObjetoBean beanAlumno, ObjetoBean beanCurso) {
		GestorFichas gf = new GestorFichas();
		return (Ficha) gf.consultaFichaDeAlumno(beanAlumno, beanCurso);
	}
	/**
	 * Realizamos modificaciones sobre una ficha con las caracteristicas de beanFicha
	 * @param beanFicha
	 * @return
	 */
	public ListaObjetoBean editarFicha(ObjetoBean beanFicha){
		GestorFichas gf = new GestorFichas();
		return gf.editarFicha(beanFicha);
	}
	/**
	 * Nos devueve una lista de los alumnos de un curso que le pasamos por parametro
	 * @param beanCurso
	 * @return
	 */
	public ListaObjetoBean consultaAlumnosDeCurso(ObjetoBean beanCurso) {
		GestorCursos gc = new GestorCursos();
		return gc.consultaAlumnosDeCurso(beanCurso);
	}
	/**
	 * Consulta los cursos activos en ese momento
	 * @param beanProfesor
	 * @return
	 */
	public ListaObjetoBean consultaCursosActivos(ObjetoBean beanProfesor) {
		GestorCursos gc = new GestorCursos();
		return gc.consultaCursosActivos(beanProfesor);
	}
	/**
	 * REaliza la publicacion de las notas, borrando las fichas de los alumnos
	 * y pasando el curso a inactivo
	 * @param beanCurso
	 * @return
	 */
	public boolean PublicarNota(ObjetoBean beanCurso){
		BBDDFachada bdf = BBDDFachada.getInstance();
		beanCurso.cambiaValor(Constantes.CURSO_ESTADO,"inactivo");
		bdf.editar(beanCurso);
		return bdf.publicarNota(beanCurso);
	}

	public ListaObjetoBean dameExpedienteCurso(ObjetoBean curso)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.creaExpediente(curso);
	}
	
	private ListaObjetoBean comprobar(ObjetoBean bean) {
		CreadorListaObjetoBean c = new CreadorListaObjetoBean();
		CreadorBean cBean = new CreadorBean();
		ListaObjetoBean listaerror = c.crear();
		String mensaje = "";
		int i = 0;
		
		//Se comprueba que los campos obligatorios tienen datos

		//El DNI no debe ser un campo vacío
		if (bean.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI).equals("")){
			mensaje = "El campo DNI no ha sido rellenado";
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		}
		//El área no debe ser un campo vacío
		else if (bean.dameValor(Constantes.PROFESOR_ISAREA_IDISAREA).equals("")){
			mensaje = "El campo Area no ha sido rellenado";
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		}
		//El telefono debe ser un entero mayor que 0
		else if (!bean.dameValor(Constantes.PROFESOR_TELEFONO).equals("")){
		  try {
			int telf = Integer.parseInt(bean.dameValor(Constantes.PROFESOR_TELEFONO));
			if (telf < 0) {
				mensaje = "El campo Telefono tiene un valor incorrecto. Debe ser un" +
						  "entero mayor que 0";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			}
		  } 
		  catch (Exception e) {
			// No es número
			mensaje = "El campo Telefono tiene un valor incorrecto. Debe ser un" +
					  "entero mayor que 0";
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		  }
		}
		return listaerror;
	}
}
