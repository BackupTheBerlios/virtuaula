package subSistemaControlador.controlador.ControladorSecretaria.controlConsulProf;


import subSistemaControlador.controlador.Controlador;
import gestores.Profesorado;
import beans.listaObjetoBeans.ListaObjetoBean;

import beans.ObjetoBean;
/**
 * 
 * @author Alberto Macho
 * Este controlador controla la navegación entre dos paginas
 * en la consulta de un profesor. Consulta los profesores con las
 * caracteristicas que le pasamos en un beanProfesor
 *
 */
public class Cons_Prof extends ControladorConsProf{

	
/**
 * Este metodo nos modifica el resultadooperacion para indicar a la pagina que
 * tiene que pasar. Ademas utilizando el gestor de profesores consulta los profesores con
 * el bean que le pasamos por la session.
 */
	public void procesarEvento() {
		
		Profesorado profesorado = new Profesorado();
		ListaObjetoBean lista;
		//=clis.crear();
		//beanProf pasara a llamarse bean
		ObjetoBean beanprof = (ObjetoBean)this.getSesion().getAttribute("beanProfesor");
		//Aqui accederiamos a la base de datos para consultar el profesor y me lo devolveria en
		//beanprof. Luego lo meteriamos en la lista
		//lista=consulta en la base de datos.
		//BBDDFachada BD=BBDDFachada.getInstance();
		
		lista=profesorado.consultaProfesor(beanprof);
		//ListaObjetoBean listacur=BD.consultarCursosProfesor(beanprof);
		//ListaObjetoBean listacur=profesorado.consultarCursosProfesor(beanprof);
		//Si la consulta no ha dado error entonces la lista sera distinta de null
		//entonces resultadooperacion sera OK sino sera ERROR
		this.sesion.setAttribute("RdoControlador",lista);
		//this.sesion.setAttribute("cursosprofesor",listacur);
		//if (!lista.esVacio())
		if ((lista!=null) ){  //|| (listacur!=null)
			this.setResuladooperacion("OK");
			}
		else if ((lista==null) )// || (listacur==null)
		{
			this.setResuladooperacion("ERROR");	
		}
			
			
		this.sesion.removeAttribute("beanProf");
		
	
	}
	/**
	 * @return nos devuelve un controlador de esta clase
	 */
	public Controlador clonar()
	{
		return new Cons_Prof();
	}

}

