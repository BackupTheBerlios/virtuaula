package subSistemaBBDD.listaObjeto;

import subSistemaBBDD.objetoBaseDatos.ObjetoBBDD;
/**
 * Lista que puede contener ObjetosBBDD
 * @author Fco Javier P�rez Escriv�
 *
 */
abstract public class ListaObjetoBBDDAbs {
	/**
	 * Dice si la lista esta vacia o no 
	 * @return true en el caso afirmativo false en caso contrario
	 */
	abstract public boolean esVacio();
	/**
	 * Inserta un ObjetoBBDD en la lista en una posici�n determinada
	 * (si la posici�n est� ocupada, sobreescribe el ObjetoBBDD)
	 * @param pos posicion donde insertar el objeto 
	 * @param obj objetoBBDD a insertar
	 */
	abstract public void insertar (int pos, ObjetoBBDD obj);
	/**
	 * accesor del objeto de la posici�n especificada
	 * @param pos posici�n a examinar
	 * @return objeto consultado
	 */
	abstract public ObjetoBBDD dameObjeto(int pos);
	/**
	 * Elimina el objeto de la posici�n especificada
	 * @param pos posici�n del objeto a eliminar
	 */
	abstract public void eliminar(int pos);
	/**
	 * Devuelve una copia de la ListaObjetoBBDD al que se le envia el mensaje Patr�n Prototype
	 * @return copia
	 */
	abstract public ListaObjetoBBDD clonar();
	/**
	 * Devuelve el n�mero de elementos de la lista
	 * @return numero de elementos en la lista
	 */
	abstract public int tamanio();
}
