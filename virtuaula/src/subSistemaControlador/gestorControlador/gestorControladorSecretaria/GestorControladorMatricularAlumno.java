package subSistemaControlador.gestorControlador.gestorControladorSecretaria;


import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.controlador.ControladorSecretaria.controlMatricular.ControladorInicioMatricula;
import subSistemaControlador.controlador.ControladorSecretaria.controlMatricular.ControladorMatAlum;
import subSistemaControlador.controlador.ControladorSecretaria.controlMatricular.ControladorMatAlumCur;
import subSistemaControlador.controlador.ControladorSecretaria.controlMatricular.ControladorMatricula;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;

/**
 * Devuelve los controladores para la matriculacion de un alumno
 * @author Fco Javier P�rez Escriv�
 *
 */
public class GestorControladorMatricularAlumno extends GestorControladorSecretaria{

	

	public GestorControladorMatricularAlumno(){}
	
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		
		CreadorControlador creadorcont=new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("MAT_ALUM_DOS",creadorcont.crear(CreadorControlador.ControladorInicioMatricula));
		GestorControlador.tablaOperacionControlador.put("MAT_ALUM",creadorcont.crear(CreadorControlador.ControladorMatAlum));
		GestorControlador.tablaOperacionControlador.put("MATRICULA",creadorcont.crear(CreadorControlador.ControladorMatricula));
		GestorControlador.tablaOperacionControlador.put("'GES_ALUM'",creadorcont.crear(CreadorControlador.ControladorPasaPag));
		GestorControlador.tablaOperacionControlador.put("MAT_ALUM_CUR",new ControladorMatAlumCur());
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
		
		
		
	}
}
