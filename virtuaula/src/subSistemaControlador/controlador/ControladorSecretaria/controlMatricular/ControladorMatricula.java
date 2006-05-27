package subSistemaControlador.controlador.ControladorSecretaria.controlMatricular;

import gestores.GestorAlumnos;
import beans.ObjetoBean;
import beans.CreadorBean;
import subSistemaControlador.controlador.Controlador;
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
		CreadorBean creador = new CreadorBean();
		ObjetoBean usuario = (ObjetoBean)this.getSesion().getAttribute("usuario");
		//System.out.println(curso.dameValor(Constantes.CURSO_NOMBRE));
		
		ListaObjetoBean listaerror=GA.marticularAlumno(alumno,curso,usuario);
		//si los datos introducidos son correctos
		if (listaerror.esVacio())
		{
			
			this.setResuladooperacion("OK");
			//metemos en sesion el usuario para que en la sig pagina muestre el usuario
			//y la contraseña.
			this.getSesion().setAttribute("usuario",usuario);
			//borramos la listaeror porque ya lo hacemos correctamente.
			this.getSesion().removeAttribute("error");
		}
		//si los datos introducidos no son correctos
		else if (!listaerror.esVacio())
		{
			this.setResuladooperacion("ERROR");
			this.getSesion().setAttribute("error",listaerror);
		}
		
		}
		
		
		
	

	public Controlador clonar() {
		return new ControladorMatricula();
	}

}
