package gestores;

import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.utils.Constantes;
import beans.CreadorBean;
import beans.Error;
import beans.ObjetoBean;
import beans.Profesor;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

public class Profesorado {
	
	public Profesorado() {
		super();
	}
	
	public ListaObjetoBean consultaProfesores() {	
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean cBean = new CreadorBean();
		Profesor profesor = (Profesor) cBean.crear(11);
		ListaObjetoBean l = bdf.consultar(profesor);
		return l;
	}
	
	public ListaObjetoBean consultaProfesoresPorHorario (ObjetoBean beanHorario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.dameProfesoresLibres(beanHorario);	
		return l;
	}
	
	public ListaObjetoBean consultaAreas() {
		GestorAreas ga = new GestorAreas();
		return ga.consultaAreas();
	}
	
	public ListaObjetoBean consultaProfesor(ObjetoBean beanProfesor) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.consultar(beanProfesor);
		return l;
	}
	
	public ListaObjetoBean consultaCursosProfesor(ObjetoBean beanProfesor) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.dameCursosProfesor(beanProfesor);
		return l;
	}
	
	public ListaObjetoBean consultaFichaDeAlumno(ObjetoBean beanAlumno) {
		GestorFichas gf = new GestorFichas();
		return gf.consultaFichaDeAlumno(beanAlumno);
	}
	
	public boolean editarFicha(ObjetoBean beanFicha){
		GestorFichas gf = new GestorFichas();
		return gf.editarFicha(beanFicha);
	}
	
	public ListaObjetoBean consultaAlumnosDeCurso(ObjetoBean beanCurso) {
		GestorCursos gc = new GestorCursos();
		return gc.consultaAlumnosDeCurso(beanCurso);
	}
	
	public ListaObjetoBean consultaCursosActivos(ObjetoBean beanProfesor) {
		GestorCursos gc = new GestorCursos();
		return gc.consultaCursosActivos(beanProfesor);
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
