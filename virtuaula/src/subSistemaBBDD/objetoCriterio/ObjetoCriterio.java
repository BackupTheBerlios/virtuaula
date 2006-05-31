package subSistemaBBDD.objetoCriterio;

import subSistemaBBDD.objetoBaseDatos.*;

/**
 * Abstracción de un ObjetoCriterio encapsulado de los datos que compone una
 * lista de campos seleccionados para marcar un criterio de consulta o de selección 
 * y su valor
 * Formando parte de un patron:
 * 			-Patrón Prototype su rol es de Prototype
 * @author Fco Javier Pérez Escrivá
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
	 * Número de campos introducidos en el objetoCriterio
	 * @return Número de campos introducidos en el objetoCriterio 
	 */
	abstract public int dameNumCampos();
	/**
	 * Pasa el campo actual al siguiente
	 * @return devuelve true si ha podido pasar al siguiete, false en caso contrario
	 * (no quedan más campos)
	 */
	abstract public boolean camposig();
	/**
	 * Transforma un ObjetoBBDD en un ObjetoCriterio (eliminando los campos vacios)
	 * @param obj Objeto a transformar
	 * @return ObjetoCriterio resultante de la transformación
	 */
	abstract public ObjetoCriterio convertir (ObjetoBBDD obj);
	/**
	 * Devuelve una copia del ObjetoCriterio al que se le envia el mensaje
	 * Patrón Prototype
	 * @return copia solitada 
	 */
	abstract public ObjetoCriterio clonar();
	/**
	 * Realiza una inicialización poniendo el número de campos a 0 y creando una estructura inicial vacia.
	 *
	 */
	abstract public void inicializar();
}
