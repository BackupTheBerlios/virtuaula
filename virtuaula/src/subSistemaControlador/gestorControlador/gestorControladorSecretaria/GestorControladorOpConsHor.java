package subSistemaControlador.gestorControlador.gestorControladorSecretaria;


import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.gestorControlador.GestorControlador;


public class GestorControladorOpConsHor extends GestorControladorSecretaria{

	
public GestorControladorOpConsHor(){
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		CreadorControlador creadorcont=new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("CONS_HOR",creadorcont.crear(CreadorControlador.ControladorConsultarHorario));
		GestorControlador.tablaOperacionControlador.put("CONS_HOR_SEL",creadorcont.crear(CreadorControlador.ControladorConsultarHorarioSel));
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		return controladorResultado;
	}
}
