package subSistemaControlador.controlador.ControladorSecretaria.controlConsulProf;

import beans.CreadorBean;
import beans.ObjetoBean;

import beans.listaObjetoBeans.ListaObjetoBean;
import gestores.Profesorado;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
/**
 * Controla el paso de una pagina a otra en la operacion de consuta
 * un profesor y tenemos que tenemos que sacar los cursos que imparte un profesor
 * y el area al que pertenece
 * @author AL
 *
 */
public class ControladorMostrarProf extends ControladorConsProf{
	/**
	 * Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	 * tiene que pasar. Ademas utilizando el profesorado consulta los cursos que tiene un profesor
	 * en concreto y lo mete en sesion. tambien consultamos el area que tiene un profesor.
	 */
	public void procesarEvento() {
		Integer posprof= (Integer)this.getSesion().getAttribute("posProf");
		ListaObjetoBean listaprof =(ListaObjetoBean)this.getSesion().getAttribute("RdoControlador");
		int posp= posprof.intValue();
		ObjetoBean prof=(ObjetoBean)listaprof.dameObjeto(posp);
		Profesorado profesorado= new Profesorado();
		ListaObjetoBean listacur=(ListaObjetoBean)profesorado.consultaCursosProfesor(prof);
		
		//tengo que hacer la consulta del area del profesor
		CreadorBean creador = new CreadorBean();
		ObjetoBean area=creador.crear(creador.Area);
		String idarea=prof.dameValor(Constantes.PROFESOR_ISAREA_IDISAREA);
		area.cambiaValor(Constantes.ID_ISAREA,idarea);
		ListaObjetoBean listaar=profesorado.consultaArea(area);
		
		
		
		if ((listacur==null) || (listaar==null))
			//la base de datos ha fallado
		{
			this.setResuladooperacion("ERROR");
		}	
		else if ((listacur!=null) && (listaar!=null))
		//la consulta se ha realizado correctamente
		{
			//Como solo hay un area con el identificador por el que buscamos
			//en la lista solo tendremos un beanArea en la posicion 0
			ObjetoBean are=(ObjetoBean)listaar.dameObjeto(0);
			this.setResuladooperacion("OK");
			this.getSesion().setAttribute("listacurso",listacur);
			this.getSesion().setAttribute("beanArea",are);
			if(this.getSesion().getAttribute("error")!=null)
				this.getSesion().removeAttribute("error");
		}
		
		
		
	}
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar()
	{
		return new ControladorMostrarProf();
	}

}
