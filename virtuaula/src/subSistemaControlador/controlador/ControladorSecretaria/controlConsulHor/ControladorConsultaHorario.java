package subSistemaControlador.controlador.ControladorSecretaria.controlConsulHor;


import subSistemaControlador.controlador.ControladorSecretaria.ControladorSecretaria;

abstract public class ControladorConsultaHorario extends ControladorSecretaria {


	/**
	* Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	* tiene que pasar. 
	*/
	abstract public void procesarEvento(); 

	
}
