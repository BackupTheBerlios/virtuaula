package subSistemaControlador.controlador.ControladorSecretaria.controlEditarAlum;
import beans.ObjetoBean;
import subSistemaControlador.controlador.Controlador;
import subSistemaBBDD.utils.*;
public class ControladorConfEditarAlum extends ControladorEditarAlumno{

	
	public void procesarEvento(){
		
		String claveAlumno= (String)this.getSesion().getAttribute("claveAlumno");
		ObjetoBean alumnoEdicion= (ObjetoBean)(this.getSesion().getAttribute("beanAlumno"));
		alumnoEdicion.cambiaValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI,claveAlumno);
		this.getSesion().setAttribute("beanAlumno",alumnoEdicion);
		if(claveAlumno!=null){
			this.setResuladooperacion("OK");
		}
		else{
			this.setResuladooperacion("ERROR");
		}
	}

	public Controlador clonar(){
		return new ControladorConfEditarAlum();
	}
	
	
}
