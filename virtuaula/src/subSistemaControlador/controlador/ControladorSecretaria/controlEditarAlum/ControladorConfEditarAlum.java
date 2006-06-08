package subSistemaControlador.controlador.ControladorSecretaria.controlEditarAlum;
import gestores.GestorAlumnos;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaControlador.controlador.Controlador;
import subSistemaBBDD.utils.*;
/**
 * Se encarga de hacer una comprobacion sobre las datos editados de un alumno por parte 
 * de un secretario para asegurar que estos tienen el formato correcto.
 * @author JORGE SANCHEZ
 *
 */
public class ControladorConfEditarAlum extends ControladorEditarAlumno{

	/**
	 * Metodo que modifica el resultado operacion para indicar a que pagina tenemos que ir 
	 * y ademas con el gestor de Alumnos comprueba que los datos que se van a editar tienen
	 * el formato adecuado
	 */
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
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar(){
		return new ControladorConfEditarAlum();
	}
	
	
}
