package subSistemaControlador.controlador.ControladorSecretaria.controlInsHor;


import subSistemaControlador.controlador.ControladorSecretaria.ControladorSecretaria;

abstract public class ControladorInsertarHorarioAbs extends ControladorSecretaria {

	/**
	 * metodo que nos modifica el resultado operacion para saber cual sera
	 * la pagina de destino
	 */
	abstract public void procesarEvento(); 

	
}