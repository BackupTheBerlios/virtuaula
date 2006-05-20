package controlador.controlMatricular;

import gestores.GestorAlumnos;
import controlador.Controlador;
import beans.ObjetoBean;
import beans.CreadorBean;
import subSistemaBBDD.utils.Constantes;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * 
 * @author Alberto Macho
 *
 */
public class ControladorMatricula extends ControladorMatricular{

	public void procesarEvento() {
		
		ObjetoBean alumno=(ObjetoBean)this.getSesion().getAttribute("beanAlumno");
		ObjetoBean curso = (ObjetoBean)this.getSesion().getAttribute("beanCurso");
		GestorAlumnos GA = new GestorAlumnos();
		ListaObjetoBean listaerror=GA.marticularAlumno(alumno,curso);
		//si los datos introducidos son correctos
		if (listaerror==null)
		{
			this.setResuladooperacion("OK");
			//borramos la listaeror porque ya lo hacemos correctamente.
			this.getSesion().removeAttribute("error");
		}
		//si los datos introducidos no son correctos
		else if (listaerror!=null)
		{
			this.setResuladooperacion("ERROR");
			this.getSesion().setAttribute("error",listaerror);
		}
		
		}
		
		
		
	

	public Controlador clonar() {
		return new ControladorMatricula();
	}

}
