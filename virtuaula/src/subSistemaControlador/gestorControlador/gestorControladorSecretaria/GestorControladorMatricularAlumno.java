package subSistemaControlador.gestorControlador.gestorControladorSecretaria;


import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorSecretaria.controlMatricular.ControladorMatAlum;
import subSistemaControlador.controlador.ControladorSecretaria.controlMatricular.ControladorMatAlumCur;
import subSistemaControlador.controlador.ControladorSecretaria.controlMatricular.ControladorMatricula;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;

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
