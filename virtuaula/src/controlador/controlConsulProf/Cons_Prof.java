package controlador.controlConsulProf;


import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.BBDDFachada;

public class Cons_Prof extends ControladorConsProf{

	
/**
 * Este metodo nos modifica el resultadooperacion para indicar a la pagina que
 * tiene que pasar. Ademas utilizando el gestor de profesores consulta los profesores con
 * el bean que le pasamos por la session.
 */
	public void procesarEvento() {
		
		
		ListaObjetoBean lista;
		ObjetoBean beanprof = (ObjetoBean)this.getSesion().getAttribute("beanProf");
		//Aqui accederiamos a la base de datos para consultar el profesor y me lo devolveria en
		//beanprof. Luego lo meteriamos en la lista
		//lista=consulta en la base de datos.
		BBDDFachada BD=BBDDFachada.getInstance();
		lista=BD.consultar(beanprof);
		//Si la consulta no ha dado error entonces la lista sera distinta de null
		//entonces resultadooperacion sera OK sino sera ERROR
		this.sesion.setAttribute("RdoControlador",lista);
		if (lista!=null){
			this.setResuladooperacion("OK");
			}
		else{
			this.setResuladooperacion("ERROR");	
		}
	
		this.sesion.removeAttribute("beanProf");
		
	
	}

}
