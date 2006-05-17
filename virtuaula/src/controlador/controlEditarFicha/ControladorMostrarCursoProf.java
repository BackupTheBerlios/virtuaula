package controlador.controlEditarFicha;

import gestores.Profesorado;

import javax.servlet.http.HttpSession;

import beans.CreadorBean;
import beans.ObjetoBean;
import beans.Profesor;
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
	String idprof = (String)sesion.getAttribute("idusuario");
	prof.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI,idprof);
	ListaObjetoBean lista=GP.consultaCursosProfesor(prof);
	if (lista!=null)
	{
		this.setResuladooperacion("OK");
		sesion.setAttribute("listacurso",lista);
	}
	else if (lista==null)
	{
		this.setResuladooperacion("ERROR");
	}
		
	}

	public Controlador clonar() {
		
		return new ControladorMostrarCursoProf();
	}

}
