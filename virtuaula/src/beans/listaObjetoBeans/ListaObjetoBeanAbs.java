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
	 * Inserta un objetoBean en la lista en una posición determinada
	 * (si esta ocupada lo sobreescribe)
	 * @param pos posicion donde insertar el objeto 
	 * @param obj objetoBean a insertar
	 */
	abstract public void insertar (int pos, ObjetoBean obj);
	/**
	 * Accesor del objeto de la posición especificada
	 * @param pos posición a examinar
	 * @return objeto consultado
	 */
	abstract public ObjetoBean dameObjeto(int pos);
	/**
	 * Elimina el objeto de la posición especificada
	 * @param pos posición del objeto a eliminar
	 */
	abstract public void eliminar(int pos);
    
	/**
     * 
     * @return devuelve el tamaño de la lista.
     */
	abstract public int tamanio();
}


