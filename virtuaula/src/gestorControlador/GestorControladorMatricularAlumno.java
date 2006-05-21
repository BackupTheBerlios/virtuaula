package gestorControlador;

import javax.servlet.http.HttpSession;

import controlador.Controlador;
import controlador.controlMatricular.ControladorMatAlum;
import controlador.controlMatricular.ControladorMatricula;
import controlador.controlMatricular.ControladorMatAlumCur;
import controlador.controlPasaPag.ControladorPasaPag;
/**
 * 
 * @author Fco Javier Pérez Escrivá
 *
 */
public class GestorControladorMatricularAlumno extends GestorControladorSecretaria{

	

	public GestorControladorMatricularAlumno(){}
	
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		
		GestorControlador.tablaOperacionControlador.put("MAT_ALUM_DOS",new ControladorMatAlum());
		GestorControlador.tablaOperacionControlador.put("MAT_ALUM",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("MATRICULA",new ControladorMatricula());
		GestorControlador.tablaOperacionControlador.put("MAT_ALUM_CUR",new ControladorMatAlumCur());
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
		
		
		
	}
}
