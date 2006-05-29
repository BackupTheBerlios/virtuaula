package subSistemaControlador.controlador.ControladorAlumnos.controlConsultaExpAlum;
import gestores.GestorAlumnos;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.Usuario;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.*;
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorAlumnos.ControladorAlumnos;
public class ControladorConExpAlum extends ControladorAlumnos{

	public void procesarEvento() {
		
		ObjetoBean usuario = (Usuario)this.getSesion().getAttribute("beanUsuario");
		CreadorBean creador =new CreadorBean();
		ObjetoBean alumno = creador.crear(creador.Alumno);
		alumno.cambiaValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI,usuario.dameValor(Constantes.ID_ISUSUARIO_DNI));
		GestorAlumnos GA = new GestorAlumnos();
		ListaObjetoBean listaexp=GA.creaExpedienteAlumno(alumno);
		
		
		if (listaexp!=null)
		{//no ha fallado la base de datos
			this.setResuladooperacion("OK");
			this.getSesion().removeAttribute("error");
			this.getSesion().setAttribute("listaexpedientealumno",listaexp);
			ListaObjetoBean listaA=GA.consultaAlumnos(alumno);
			//Como solo encontrara un alumno por ese DNI lo cojo de la pos cero
			ObjetoBean alum = listaA.dameObjeto(0);
			this.getSesion().setAttribute("beanAlumno",alum);
		}
		else if (listaexp==null)
		{
			this.setResuladooperacion("ERROR");
			 ObjetoBean error= creador.crear(creador.Error);
		    error.cambiaValor(Constantes.CAUSA,"Fallo en la base de datos al consultar los expedientes");
		    CreadorListaObjetoBean creadorlista =new CreadorListaObjetoBean();
		    ListaObjetoBean listaerror = creadorlista.crear(); 
		    listaerror.insertar(0,error);
		    this.getSesion().setAttribute("error",listaerror);
			
		}
		
	}

	public Controlador clonar() {
		
		return new ControladorConExpAlum();
	}

}
