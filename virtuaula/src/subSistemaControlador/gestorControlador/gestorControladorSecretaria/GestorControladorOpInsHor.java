package subSistemaControlador.gestorControlador.gestorControladorSecretaria;


import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.gestorControlador.GestorControlador;

/**
 * Devuelve los controladores de la insercion de un horario
 * @author Fco Javier Pérez Escrivá
 *
 */
public class GestorControladorOpInsHor extends GestorControladorSecretaria{

	
public GestorControladorOpInsHor(){
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador creadorcont=new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("INS_HOR2",creadorcont.crear(CreadorControlador.ControladorInsertarHorario));
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		return controladorResultado;
	}
}
