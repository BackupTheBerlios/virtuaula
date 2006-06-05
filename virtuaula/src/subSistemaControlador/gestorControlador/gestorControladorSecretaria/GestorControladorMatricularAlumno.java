package subSistemaControlador.gestorControlador.gestorControladorSecretaria;


import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.controlador.ControladorSecretaria.controlMatricular.ControladorMatAlumCur;

import subSistemaControlador.gestorControlador.GestorControlador;

/**
 * Devuelve los controladores para la matriculacion de un alumno
 * @author Fco Javier Pérez Escrivá
 *
 */
public class GestorControladorMatricularAlumno extends GestorControladorSecretaria{

	
	/**
	 * Constructor
	 *
	 */
	public GestorControladorMatricularAlumno(){}
	/**
	 * Devuelve el Controlador adecuado para este perfil y esta operacion
	 */
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
