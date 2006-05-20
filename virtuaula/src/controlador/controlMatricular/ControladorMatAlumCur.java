package controlador.controlMatricular;

import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import controlador.Controlador;
import subSistemaBBDD.utils.Constantes;
import gestores.GestorAlumnos;

/**
 * 
 * @author Alberto Macho 
 *
 */
public class ControladorMatAlumCur extends ControladorMatricular {
/**
 * Este metodo cogera el curso metido en la session y consultara la clase, el profesor
 * , el horario y el precio de ese curso y lo metera en la session para mostrarlo 
 * en la siguiente pagina.
 */
	public void procesarEvento() {
	
	GestorAlumnos GA = new GestorAlumnos();	
	CreadorBean creador = new CreadorBean();	
	Integer posc = (Integer)this.getSesion().getAttribute("posCurso");
	int poscurso = posc.intValue();
	
	//si el curso elegido es valido
	if (poscurso!=-1)
	{
		ListaObjetoBean listacur = (ListaObjetoBean)this.getSesion().getAttribute("listacurso");
		ObjetoBean curso=listacur.dameObjeto(poscurso);
		ObjetoBean aula=GA.consultaAulaCurso(curso);
		ObjetoBean horario=GA.consultaHorarioCurso(curso);
		ObjetoBean profesor=GA.consultaProfesorCurso(curso);
			//no se produce un error en la base de datos.
			if ((aula!=null) && (horario!=null) && (profesor!=null))
			{
				this.setResuladooperacion("OK");
				this.getSesion().removeAttribute("error");
				this.getSesion().setAttribute("beanAula",aula);
				this.getSesion().setAttribute("beanHorario",horario);
				this.getSesion().setAttribute("beanProfesor",profesor);
				this.getSesion().setAttribute("beanCurso",curso);
			}
			//se ha producido un error en la base de datos
			else if ((aula==null) || (horario==null) || (profesor==null))
			{
				this.setResuladooperacion("ERROR");
				ObjetoBean err= creador.crear(creador.Error);
				err.cambiaValor(Constantes.CAUSA,"Se ha producido un error en la base de datos al consultar");
				ListaObjetoBean listae = new ListaObjetoBean();
				listae.insertar(0,err);
				this.getSesion().setAttribute("error",listae);
			}
	}
	//si el curso escogido no es valido, es decir, es -1, debe elegir un curso valido y volver a la pag anteriop
	//mostrando el error.
	else if (poscurso==-1)
	{
		ObjetoBean error = creador.crear(creador.Error);
		error.cambiaValor(Constantes.CAUSA,"Debe elegir un curso valido");
		ListaObjetoBean listaer = new ListaObjetoBean();
		listaer.insertar(0,error);
		this.getSesion().setAttribute("error",listaer);
		this.setResuladooperacion("ERROR");
		
		
	}
	}

	public Controlador clonar() {
		return new ControladorMatAlumCur();
	}

}
