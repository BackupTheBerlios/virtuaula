package controlador.controlConsulProf;

import controlador.Controlador;
import beans.Profesor;
import beans.listaObjetoBeans.ListaObjetoBean;
import gestores.Profesorado;

public class ControladorMostrarProf extends ControladorConsProf{

	public void procesarEvento() {
		Integer posprof= (Integer)this.getSesion().getAttribute("posProf");
		ListaObjetoBean listaprof =(ListaObjetoBean)this.getSesion().getAttribute("RdoControlador");
		int posp= posprof.intValue();
		Profesor prof=(Profesor)listaprof.dameObjeto(posp);
		Profesorado profesorado= new Profesorado();
		ListaObjetoBean listacur=(ListaObjetoBean)profesorado.consultaCursosProfesor(prof);
		
		if (listacur==null)
			//la base de datos ha fallado
		{
			this.setResuladooperacion("ERROR");
		}	
		else if (listacur!=null)
		//la consulta se ha realizado correctamente
		{
			this.setResuladooperacion("OK");
			this.getSesion().setAttribute("listacurso",listacur);
		}
		
		
		
	}

	public Controlador clonar()
	{
		return new ControladorMostrarProf();
	}

}
