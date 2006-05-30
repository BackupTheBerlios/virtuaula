package subSistemaControlador.controlador.ControladorSecretaria.controlEditarAlum;
import gestores.GestorAlumnos;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaControlador.controlador.Controlador;
import subSistemaBBDD.utils.*;
/**
 * 
 * @author JORGE SANCHEZ
 *
 */
public class ControladorConfEditarAlum extends ControladorEditarAlumno{

	
	public void procesarEvento(){
		
		String claveAlumno= (String)this.getSesion().getAttribute("claveAlumno");
		ObjetoBean alumnoEdicion= (ObjetoBean)(this.getSesion().getAttribute("beanAlumno"));
		alumnoEdicion.cambiaValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI,claveAlumno);
		this.getSesion().setAttribute("beanAlumno",alumnoEdicion);
		GestorAlumnos GA= new GestorAlumnos();
		ListaObjetoBean camposErroneos= GA.comprobar(alumnoEdicion);
		if(claveAlumno!=null && camposErroneos.esVacio()){
			this.setResuladooperacion("OK");
			
		}
		else{
			this.getSesion().setAttribute("error",camposErroneos);
			this.setResuladooperacion("ERROR");
		}
	}

	public Controlador clonar(){
		return new ControladorConfEditarAlum();
	}
	
	
}
