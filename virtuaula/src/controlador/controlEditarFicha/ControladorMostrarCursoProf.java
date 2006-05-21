package controlador.controlEditarFicha;

import gestores.Profesorado;

import javax.servlet.http.HttpSession;

import beans.CreadorBean;
import beans.ObjetoBean;

import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.*;
import controlador.Controlador;
/**
 * 
 * @author Alberto Macho
 *
 */
public class ControladorMostrarCursoProf extends Controlador{
/**
 * cogemos el dni del profesor de la session y buscamos con el gestor de profesores
 * todos los cursos que tiene ese profesor. Metemos la lista de cursos en la
 * session.
 */
	public void procesarEvento() {
	
	CreadorBean creador = new CreadorBean();	
	Profesorado GP = new Profesorado();
	HttpSession sesion = this.getSesion();
	ObjetoBean prof=creador.crear(creador.Profesor);
	//Profesor prof = new Profesor();
	//tengo que saber como se llamara el id el profesor;
	ObjetoBean idprof = (ObjetoBean)sesion.getAttribute("beanUsuario");
	prof.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI,idprof.dameValor(Constantes.ID_ISUSUARIO_DNI));
	ListaObjetoBean lista=GP.consultaCursosActivos(prof);
	if (lista!=null)
	{
		this.setResuladooperacion("OK");
		sesion.setAttribute("listacurso",lista);
		this.getSesion().removeAttribute("error");
	}
	//si falla la base de datos se produce un error y se mete en la sesion
	else if (lista==null)
	{
		ObjetoBean error = creador.crear(creador.Error);
		error.cambiaValor(Constantes.CAUSA,"Se ha producido un error en la base de datos.");
		ListaObjetoBean listaerror = new ListaObjetoBean();
		listaerror.insertar(0,error);
		this.getSesion().setAttribute("error",listaerror);
		this.setResuladooperacion("ERROR");
	}
		
	}

	public Controlador clonar() {
		
		return new ControladorMostrarCursoProf();
	}

}
