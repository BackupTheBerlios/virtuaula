package subSistemaControlador.controlador.ControladorSecretaria.controlEditarAlum;


import beans.ObjetoBean;
import subSistemaBBDD.utils.*;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaControlador.controlador.*;

/**
 * Se encarga de obtener el alumno que el secretario quiere editar despues de una consulta y de
 * que el secretario haya seleccionado de una lista el alumno a editar. 
 * @author JORGE SANCHEZ
 *
 */
public class ControladorSelecEditarAlum extends ControladorEditarAlumno {
	
	public Controlador clonar(){
		return new ControladorSelecEditarAlum();
	}
	
	public void procesarEvento(){
		Integer posAlum= (Integer)this.getSesion().getAttribute("posAlumno");
		
		ListaObjetoBean	listaAlumno=(ListaObjetoBean)this.getSesion().getAttribute("listaalumno");

		int posa= posAlum.intValue();
		ObjetoBean alumno=(ObjetoBean)listaAlumno.dameObjeto(posa);
		String claveAlumno= alumno.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI);
		this.getSesion().setAttribute("claveAlumno",claveAlumno);
		this.getSesion().setAttribute("beanAlumno",alumno);
		if(alumno!=null){
			if(this.getSesion()!=null)
				this.getSesion().removeAttribute("error");
			this.setResuladooperacion("OK");
		}
		else{
			this.setResuladooperacion("ERROR");
		}
		this.getSesion().removeAttribute("posAlumno");
	}
	
}
