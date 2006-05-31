package subSistemaBBDD.objetoCriterio;

import subSistemaBBDD.objetoBaseDatos.*;

/**
 * Abstracci�n de un ObjetoCriterio encapsulado de los datos que compone una
 * lista de campos seleccionados para marcar un criterio de consulta o de selecci�n 
 * y su valor
 * Formando parte de un patron:
 * 			-Patr�n Prototype su rol es de Prototype
 * @author Fco Javier P�rez Escriv�
 *
 */
abstract public class ObjetoCriterio {
	

	/**
	 * Accesor el campo actual
	 * @return nombre del campo actual
	 */
	abstract public String dameCampo();
	/**
	 * Accesor del valor del campo especificado
	 * @param campo campo a consultar
	 * @return valor del campo consultado
	 */
	abstract public String dameValor(String campo);
	/**
	 * N�mero de campos introducidos en el objetoCriterio
	 * @return N�mero de campos introducidos en el objetoCriterio 
	 */
	abstract public int dameNumCampos();
	/**
	 * Pasa el campo actual al siguiente
	 * @return devuelve true si ha podido pasar al siguiete, false en caso contrario
	 * (no quedan m�s campos)
	 */
	abstract public boolean camposig();
	/**
	 * Transforma un ObjetoBBDD en un ObjetoCriterio (eliminando los campos vacios)
	 * @param obj Objeto a transformar
	 * @return ObjetoCriterio resultante de la transformaci�n
	 */
	abstract public ObjetoCriterio convertir (ObjetoBBDD obj);
	/**
	 * Devuelve una copia del ObjetoCriterio al que se le envia el mensaje
	 * Patr�n Prototype
	 * @return copia solitada 
	 */
	abstract public ObjetoCriterio clonar();
	/**
	 * Realiza una inicializaci�n poniendo el n�mero de campos a 0 y creando una estructura inicial vacia.
	 *
	 */
	abstract public void inicializar();
}
