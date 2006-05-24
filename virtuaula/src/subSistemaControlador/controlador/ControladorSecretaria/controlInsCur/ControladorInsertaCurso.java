package subSistemaControlador.controlador.ControladorSecretaria.controlInsCur;

//import java.awt.geom.Area;

import gestores.GestorCursos;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
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
		Integer posHor = (Integer)this.getSesion().getAttribute("posHor");
		int posProfesor=posProf.intValue();
		int posAre=posArea.intValue();
		int posAul=posAula.intValue();
		int posHorario=posHor.intValue();
		ObjetoBean prof = (ObjetoBean)listaProf.dameObjeto(posProfesor);
		ObjetoBean area = (ObjetoBean)listaArea.dameObjeto(posAre);
		ObjetoBean aula = (ObjetoBean)listaAula.dameObjeto(posAul);
		ObjetoBean horario= (ObjetoBean)listaHor.dameObjeto(posHorario);
		ObjetoBean cur = (ObjetoBean)this.getSesion().getAttribute("beanCurso");
		
		if (cur==null)
		{
			this.setResuladooperacion("ERROR");
			
		}
		else
		{
		String idarea= (String)area.dameValor(Constantes.ID_ISAREA);
		String idprof = (String)prof.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI);
		cur.cambiaValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI,idprof);
		cur.cambiaValor(Constantes.CURSO_ISAREA_IDISAREA,idarea);
		
		//Al insertar el curso el Gestor Cursos mandaria un aviso al profesor que ha sido
		//seleccionado para impartir el curso.
		
		//consultamos otra vez el curso para obtener todos los datos (codigo curso)
		ListaObjetoBean listaError=(ListaObjetoBean)GC.insertarCurso(cur,aula,horario);
		ObjetoBean curso=(ObjetoBean)GC.consultaCurso(cur).dameObjeto(0);
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
			sesion.removeAttribute("error");
		}
		
		}
		
	}

	public Controlador clonar() {
		
		return new ControladorInsertaCurso();
	}

}
