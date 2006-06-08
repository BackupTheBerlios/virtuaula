package subSistemaControlador.controlador.ControladorSecretaria.controlMatricular;

import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import gestores.GestorAlumnos;
/**
 * 
 * @author Alberto Macho
 *Controlador que nos permite pasar de la pagina donde seleccionamos matricular alumno
 *a la primera pagina para introducir los datos del alumno.
 */
public class ControladorMatAlum extends ControladorMatricular{
/**
 * 
 * metodo que nos modifica el resultado operacion para saber cual sera
 * la pagina de destino dependiendo del resultado de las operaciones.
 *
 * Esta funcion tiene que consultar los cursos activos de la base de datos
 * para meterlos en la session y que se puedan mostrar en la siguiente pagina
 */
	public void procesarEvento() 
	{
		CreadorBean creador = new CreadorBean();
		GestorAlumnos GA = new GestorAlumnos();
		ListaObjetoBean listacursos = GA.consultaCursosActivos();
		ObjetoBean alumno=(ObjetoBean)this.getSesion().getAttribute("beanAlumno");
		ListaObjetoBean listae = GA.comprobar(alumno);
		
		//si no se produce error en la base de datos
		if (listacursos!=null)
		{
			//si no hay ningun curso activo
			if (listacursos.esVacio())
			{
				this.setResuladooperacion("ERROR");
				ObjetoBean error = creador.crear(creador.Error);
				error.cambiaValor(Constantes.CAUSA,"No hay ningun curso disponible, cree un curso para hacer la matricula");
				ListaObjetoBean listaerror = new ListaObjetoBean();
				listaerror.insertar(0,error);
				this.getSesion().setAttribute("error",listaerror);
				
			}
			//si hay algun curso activo
			else if (!listacursos.esVacio())
			{
				
				if (!listae.esVacio())
				{// si los datos no estan bien
					this.setResuladooperacion("ERROR");
					this.getSesion().setAttribute("error",listae);
				}
				else{
				this.setResuladooperacion("OK");
				this.getSesion().removeAttribute("error");
				this.getSesion().setAttribute("listacurso",listacursos);
				}	
			}
			

		}
		
		//si se produce un error en la base de datos.
		else if (listacursos==null)
		{
			this.setResuladooperacion("ERROR");
			ObjetoBean error = creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA,"Se ha producido un error en la base de datos");
			ListaObjetoBean listaer = new ListaObjetoBean();
			listaer.insertar(0,error);
			this.getSesion().setAttribute("error",listaer);
		}
	}
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		return new ControladorMatAlum();
	}
	

}
