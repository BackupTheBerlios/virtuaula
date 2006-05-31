package subSistemaControlador.controlador.ControladorProfesor.controlEditarFicha;

import gestores.Profesorado;
import javax.servlet.http.HttpSession;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorProfesor.ControladorProfesor;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * 
 * @author Alberto Macho
 *Controla el paso de una pagina a otra en la consulta de la ficha de un alumno.
 *Dependiendo del exito de las operaciones nos dara un resultado u otro
 */
public class FichaAlumnoProf extends ControladorProfesor{

	public void procesarEvento() {
		//CreadorBean creador = new CreadorBean();
		HttpSession sesion = this.getSesion();
		
		Integer posa = (Integer)sesion.getAttribute("posAlumno");
		int posalum= posa.intValue();
		ListaObjetoBean lista = (ListaObjetoBean)sesion.getAttribute("listaalumno");
		
		ObjetoBean alum = (ObjetoBean)lista.dameObjeto(posalum);
		
		//Buscamos la ficha del alumno.
		Integer poscur=(Integer)this.getSesion().getAttribute("posCurso");
		int poscurso=poscur.intValue();
		ListaObjetoBean listacurso=(ListaObjetoBean)this.getSesion().getAttribute("listacurso");
		ObjetoBean curso = (ObjetoBean)listacurso.dameObjeto(poscurso);
		Profesorado GP = new Profesorado();
		ObjetoBean ficha= GP.consultaFichaDeAlumno(alum,curso);
		//si no falla la consulta en la base de datos
		if (ficha!=null)
		{
			this.setResuladooperacion("OK");
			sesion.setAttribute("beanFicha",ficha);
			this.getSesion().removeAttribute("error");
			
		}
		else if (ficha ==null)
		{
			CreadorBean creador =new CreadorBean();
			ObjetoBean error = creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA,"Se ha producido un error en la base de datos.");
			ListaObjetoBean listaerror = new ListaObjetoBean();
			listaerror.insertar(0,error);
			this.getSesion().setAttribute("error",listaerror);
			this.setResuladooperacion("ERROR");
		}
		
	}

	public Controlador clonar() {
		
		return  new FichaAlumnoProf();
	}

}
