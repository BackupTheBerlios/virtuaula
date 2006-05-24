package gestorControlador.gestorControladorSecretaria;

import gestorControlador.GestorControlador;

import javax.servlet.http.HttpSession;

import controlador.Controlador;
import controlador.ControladorSecretaria.controlMatricular.ControladorMatAlum;
import controlador.ControladorSecretaria.controlMatricular.ControladorMatAlumCur;
import controlador.ControladorSecretaria.controlMatricular.ControladorMatricula;
import controlador.controlPasaPag.ControladorPasaPag;
/**
 * 
 * @author Fco Javier Pérez Escrivá
 *
 */
public class GestorControladorMatricularAlumno extends GestorControladorSecretaria{

	

	public GestorControladorMatricularAlumno(){}
	
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		
		GestorControlador.tablaOperacionControlador.put("MAT_ALUM_DOS",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("MAT_ALUM",new ControladorMatAlum());
		GestorControlador.tablaOperacionControlador.put("MATRICULA",new ControladorMatricula());
		GestorControlador.tablaOperacionControlador.put("MAT_ALUM_CUR",new ControladorMatAlumCur());
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
		
		
		
	}
}
