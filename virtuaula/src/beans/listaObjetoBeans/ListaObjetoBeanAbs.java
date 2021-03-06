package beans.listaObjetoBeans;

import beans.ObjetoBean;

/**
 * Lista que puede contener ObjetosBBDD
 * @author Alberto Macho
 *
 */
abstract public class ListaObjetoBeanAbs {
	/**
	 * Dice si la lista esta vacia o no 
	 * @return true en el caso afirmativo false en caso contrario
	 */
	abstract public boolean esVacio();
	/**
	 * Inserta un objetoBean en la lista en una posici�n determinada
	 * (si esta ocupada lo sobreescribe)
	 * @param pos posicion donde insertar el objeto 
	 * @param obj objetoBean a insertar
	 */
	abstract public void insertar (int pos, ObjetoBean obj);
	/**
	 * Accesor del objeto de la posici�n especificada
	 * @param pos posici�n a examinar
	 * @return objeto consultado
	 */
	abstract public ObjetoBean dameObjeto(int pos);
	/**
	 * Elimina el objeto de la posici�n especificada
	 * @param pos posici�n del objeto a eliminar
	 */
	abstract public void eliminar(int pos);
    
	/**
     * 
     * @return devuelve el tama�o de la lista.
     */
	abstract public int tamanio();
}


