package controlador.controlInsCur;

//import java.awt.geom.Area;

import gestores.GestorCursos;
import beans.Aula;
import beans.Curso;
import beans.Horario;
import beans.ObjetoBean;
import beans.Profesor;
import beans.Area;
import beans.listaObjetoBeans.ListaObjetoBean;
import controlador.Controlador;
import subSistemaBBDD.utils.Constantes;
/**
 * 
 * @author Alberto Macho
 *
 */
public class ControladorInsertaCurso extends Controlador{

	public void procesarEvento() 
	{
		GestorCursos GC = new GestorCursos();
		ListaObjetoBean listaHor = (ListaObjetoBean)this.getSesion().getAttribute("listahorario");
		ListaObjetoBean listaProf = (ListaObjetoBean)this.getSesion().getAttribute("listaprofesor");
		ListaObjetoBean listaAula = (ListaObjetoBean)this.getSesion().getAttribute("listaaula");
		ListaObjetoBean listaArea = (ListaObjetoBean)this.getSesion().getAttribute("listaarea");
		Integer posProf = (Integer)this.getSesion().getAttribute("posProf");
		Integer posArea = (Integer)this.getSesion().getAttribute("posArea");
		Integer posAula = (Integer)this.getSesion().getAttribute("posAula");
		//Integer posHor = (Integer)this.getSesion().getAttribute("posHor");
		int posProfesor=posProf.intValue();
		int posAre=posArea.intValue();
		int posAul=posAula.intValue();
		//int posHorario=posHor.intValue();
		ObjetoBean prof = (Profesor)listaProf.dameObjeto(posProfesor);
		ObjetoBean area = (Area)listaArea.dameObjeto(posAre);
		ObjetoBean aula = (Aula)listaAula.dameObjeto(posAul);
		ObjetoBean horario= (Horario)listaHor.dameObjeto(posProfesor);
		ObjetoBean cur = (Curso)this.getSesion().getAttribute("beanCurso");
		
		String idarea= (String)area.dameValor(Constantes.ID_ISAREA);
		String idprof = (String)prof.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI);
		cur.cambiaValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI,idprof);
		cur.cambiaValor(Constantes.CURSO_ISAREA_IDISAREA,idarea);
		
		//Al insertar el curso el Gestor Cursos mandaria un aviso al profesor que ha sido
		//seleccionado para impartir el curso.
		
		//consultamos otra vez el curso para obtener todos los datos (codigo curso)
		ListaObjetoBean listaError=(ListaObjetoBean)GC.insertarCurso(cur,aula,horario);
		ObjetoBean curso=(Curso)GC.consultaCurso(cur).dameObjeto(0);
	    sesion.setAttribute("beanCurso",curso);
		//la inserccion ha fallado
		if (listaError!=null)
		{
			this.setResuladooperacion("ERROR");
			this.getSesion().setAttribute("error",listaError);
			
		}
		else if (listaError==null)
		{
			this.setResuladooperacion("OK");
		}
		
		
		
	}

	public Controlador clonar() {
		
		return new ControladorInsertaCurso();
	}

}
