package subSistemaControlador.controlador.ControladorProfesor.controlEnviarAviso;

import gestores.GestorUsuarios;
import gestores.Profesorado;

import java.util.HashMap;

import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorProfesor.ControladorProfesor;
/**
 * 
 * Controla el paso de una pagina a otra ,haciendo ademas operaciones
 *dependiendo del exito pasa a una pagina u otra mostrando erroes o no.
 *En este caso es para consultar a quien puede enviar el aviso el 
 *profesor. Podra mandar avisos a todas las secretarias, al profesorado
 *y a los alumnos de un curso que el imparta
 *
 */
public class IniEnviarAvisoProf extends ControladorProfesor{
	/**
	* Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	* tiene que pasar. Ademas utilizando el Gestor usuarios obtenemos el grupo de usuarios
	* a los que podemos mandar el mensaje. Con el profesorado,obtenemos todos los
	* profesores y los cursos de un profesor en particular.
	*/
	public void procesarEvento() {
	 
		HashMap mapGrupos=new HashMap();
		ObjetoBean usuario=(ObjetoBean)this.getSesion().getAttribute("beanUsuario");
		CreadorBean creador = new CreadorBean();
		ObjetoBean profesor = creador.crear(creador.Profesor);
		profesor.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI,usuario.dameValor(Constantes.ID_ISUSUARIO_DNI));
		GestorUsuarios GU = new GestorUsuarios();
		Profesorado profesorado=new Profesorado();
		
		
		ListaObjetoBean listaSec =GU.dameUsuarios("secretaria");
		ListaObjetoBean listaProf= profesorado.consultaProfesores();
		ListaObjetoBean listaCur = profesorado.consultaCursosProfesor(profesor);
		
		if (!listaSec.esVacio())
		{
			mapGrupos.put("Secretaria",listaSec);
		}
		if (!listaProf.esVacio())
		{
			mapGrupos.put("Profesorado",listaProf);		
		}
		if (!listaCur.esVacio())
		{
			int tam=listaCur.tamanio();
			for (int i=0;i<tam;i++)
			{
				String nomCur=listaCur.dameObjeto(i).dameValor(Constantes.CURSO_NOMBRE);
				ObjetoBean curso = listaCur.dameObjeto(i);
				ListaObjetoBean listaAlum =profesorado.consultaAlumnosDeCurso(curso);
				mapGrupos.put(nomCur,listaAlum);
			}
		}
		if ((!listaSec.esVacio()) || (!listaProf.esVacio()) || (!listaCur.esVacio()))
		{	
			this.setResuladooperacion("OK");
			this.getSesion().setAttribute("listagrupos",mapGrupos);
			this.getSesion().removeAttribute("error");
		}
		else 
		{
			ObjetoBean error = creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA,"No hay usuarios a los que pueda mandar avisos");
			ListaObjetoBean listaerr= new ListaObjetoBean();
			listaerr.insertar(0,error);
			this.getSesion().setAttribute("error",listaerr);
			this.setResuladooperacion("ERROR");
		}
	}
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		
		return new IniEnviarAvisoProf();
	}

}
