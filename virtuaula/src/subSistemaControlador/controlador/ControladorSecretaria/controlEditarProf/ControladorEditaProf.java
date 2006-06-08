package subSistemaControlador.controlador.ControladorSecretaria.controlEditarProf;

import gestores.Profesorado;
import subSistemaControlador.controlador.Controlador;
import beans.ObjetoBean;
import beans.listaObjetoBeans.*;
/**
 * Controla el paso de una pagina a otra en la edicion de un profesor. 
 * la operacion que hace es la edicion del profesor con los datos
 * que recoje de sesion. dependiendo del resultado realizara una accion u otra
 * @author AL
 *
 */
public class ControladorEditaProf extends ControladorEditarProf{
/**
 * Metodo que nos modifica el resultado operacion para saber la pagina de destino.
 * Ademas con el profesorado realizamos la edicion de un profesor que le pasamos con
 * los datos cambiados.
 */
	public void procesarEvento() {
		//cojo el beanProfesor de la sesion y edito el profesor
		
		//ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("RdoControlador"));
        //Integer posicionLista =((Integer)sesion.getAttribute("posProf"));
        //int posi=posicionLista.intValue();
      	//ObjetoBean profesor=listaObjetoBean.dameObjeto(posi);
      	ObjetoBean profesor = (ObjetoBean)this.getSesion().getAttribute("beanProfesor");
		Profesorado profesorado = new Profesorado();
		//profesorado.editar(profesor);
		ListaObjetoBean errores= profesorado.editar(profesor);
		if (errores.esVacio()){
			this.setResuladooperacion("OK");
			this.getSesion().setAttribute("beanProfesor",profesor);
			
		}
		else{
			this.setResuladooperacion("ERROR");
			this.getSesion().setAttribute("error",errores);
			
		}
		
		
		
		
	}
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		
		return new ControladorEditaProf();
	}

}
