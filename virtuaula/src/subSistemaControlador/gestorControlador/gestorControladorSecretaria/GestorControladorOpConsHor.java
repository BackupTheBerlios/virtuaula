package subSistemaControlador.gestorControlador.gestorControladorSecretaria;


import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.gestorControlador.GestorControlador;

/**
 * Devuelve los controladores de la consulta de un horario
 * @author Fco Javier Pérez Escrivá
 *
 */
public class GestorControladorOpConsHor extends GestorControladorSecretaria{

	
public GestorControladorOpConsHor(){}
	/**
	 * Devuelve el Controlador adecuado para este perfil y esta operacion
	 */
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador creadorcont=new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("CONS_HOR",creadorcont.crear(CreadorControlador.ControladorConsultarHorario));
		GestorControlador.tablaOperacionControlador.put("CONS_HOR_SEL",creadorcont.crear(CreadorControlador.ControladorConsultarHorarioSel));
		GestorControlador.tablaOperacionControlador.put("ELIM_HOR_PAS1",creadorcont.crear(CreadorControlador.ControladorConsultarHorarioBor));
		GestorControlador.tablaOperacionControlador.put("ELIM_HOR_PAS2",creadorcont.crear(CreadorControlador.ControladorConsultarHorarioBor2));
		GestorControlador.tablaOperacionControlador.put("ELIM_HOR_PAS3",creadorcont.crear(CreadorControlador.ControladorConsultarHorarioBor3));
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		return controladorResultado;
	}
}
