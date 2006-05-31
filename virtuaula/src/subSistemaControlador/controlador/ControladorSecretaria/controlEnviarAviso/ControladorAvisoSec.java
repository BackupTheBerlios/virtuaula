package subSistemaControlador.controlador.ControladorSecretaria.controlEnviarAviso;


import subSistemaControlador.controlador.ControladorSecretaria.ControladorSecretaria;
/**
 * Controlador del que heredan todas las clases de enviar aviso
 * por parte de la secretaria.
 * Controla el paso de una pagina a otra. 
 * 
 *
 */
abstract public class ControladorAvisoSec extends ControladorSecretaria {



	abstract public void procesarEvento(); 

	
}
