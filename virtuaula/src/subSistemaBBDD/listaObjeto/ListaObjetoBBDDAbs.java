package subSistemaBBDD.listaObjeto;

import subSistemaBBDD.objetoBaseDatos.ObjetoBBDD;
/**
 * Lista que puede contener ObjetosBBDD
 * @author Fco Javier Pérez Escrivá & Sergio Piqueras Martínez
 */
abstract public class ListaObjetoBBDDAbs {
	/**
	 * Dice si la lista esta vacia o no 
	 * @return true en el caso afirmativo false en caso contrario
	 */
	abstract public boolean esVacio();
	/**
	 * Inserta un objetoBBDD en la lista en una posición determinada
	 * (si esta ocupada lo sobreescribe)
	 * @param pos posicion donde insertar el objeto 
	 * @param obj objetoBBDD a insertar
	 */
	abstract public void insertar (int pos, ObjetoBBDD obj);
	/**
	 * Accesor del objeto de la posición especificada
	 * @param pos posición a examinar
	 * @return objeto consultado
	 */
	abstract public ObjetoBBDD dameObjeto(int pos);
	/**
	 * Elimina el objeto de la posición especificada
	 * @param pos posición del objeto a eliminar
	 */
	abstract public void eliminar(int pos);
}
