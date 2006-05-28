

package subSistemaControlador.controlador.ControladorSecretaria.controlEditarAlum;

import subSistemaControlador.controlador.*;
import beans.ObjetoBean;
import gestores.GestorAlumnos;
import subSistemaBBDD.utils.*;
public class ControladorFinEditarAlum extends ControladorEditarAlumno{

	
	
	public void procesarEvento(){
		
		ObjetoBean alumnoEdicion= (ObjetoBean)(this.getSesion().getAttribute("beanAlumno"));
		GestorAlumnos GA = new GestorAlumnos();
		boolean exito = GA.editarAlumno(alumnoEdicion);
		if(exito){
			this.setResuladooperacion("OK");
		}
		else{
			this.setResuladooperacion("ERROR");
		}
		this.getSesion().removeAttribute("claveAlumno");
		this.getSesion().removeAttribute("beanAlumno");
		this.getSesion().removeAttribute("posAlumno");
		this.getSesion().removeAttribute("listAlumno");
	}
	
	public Controlador clonar(){
		return new ControladorFinEditarAlum();
	}
}
