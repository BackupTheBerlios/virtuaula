package subSistemaBBDD.listaObjeto;

import subSistemaBBDD.objetoBaseDatos.ObjetoBBDD;
/**
 * Lista que puede contener ObjetosBBDD
 * @author Fco Javier Pérez Escrivá
 *
 */
abstract public class ListaObjetoBBDDAbs {
	/**
	 * Dice si la lista esta vacia o no 
	 * @return true en el caso afirmativo false en caso contrario
	 */
	abstract public boolean esVacio();
	/**
	 * Inserta un ObjetoBBDD en la lista en una posición determinada
	 * (si la posición está ocupada, sobreescribe el ObjetoBBDD)
	 * @param pos posicion donde insertar el objeto 
	 * @param obj objetoBBDD a insertar
	 */
	abstract public void insertar (int pos, ObjetoBBDD obj);
	/**
	 * accesor del objeto de la posición especificada
	 * @param pos posición a examinar
	 * @return objeto consultado
	 */
	abstract public ObjetoBBDD dameObjeto(int pos);
	/**
	 * Elimina el objeto de la posición especificada
	 * @param pos posición del objeto a eliminar
	 */
	abstract public void eliminar(int pos);
	/**
	 * Devuelve una copia de la ListaObjetoBBDD al que se le envia el mensaje Patrón Prototype
	 * @return copia
	 */
	abstract public ListaObjetoBBDD clonar();
	/**
	 * Devuelve el número de elementos de la lista
	 * @return numero de elementos en la lista
	 */
	abstract public int tamanio();
}
