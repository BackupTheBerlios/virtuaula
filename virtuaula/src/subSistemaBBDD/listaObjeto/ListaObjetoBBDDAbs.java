package subSistemaBBDD.listaObjeto;

import subSistemaBBDD.objetoBaseDatos.ObjetoBBDD;
/**
 * Lista que puede contener ObjetosBBDD
 * @author Fco Javier P�rez Escriv� & Sergio Piqueras Mart�nez
 */
abstract public class ListaObjetoBBDDAbs {
	/**
	 * Dice si la lista esta vacia o no 
	 * @return true en el caso afirmativo false en caso contrario
	 */
	abstract public boolean esVacio();
	/**
	 * Inserta un objetoBBDD en la lista en una posici�n determinada
	 * (si esta ocupada lo sobreescribe)
	 * @param pos posicion donde insertar el objeto 
	 * @param obj objetoBBDD a insertar
	 */
	abstract public void insertar (int pos, ObjetoBBDD obj);
	/**
	 * Accesor del objeto de la posici�n especificada
	 * @param pos posici�n a examinar
	 * @return objeto consultado
	 */
	abstract public ObjetoBBDD dameObjeto(int pos);
	/**
	 * Elimina el objeto de la posici�n especificada
	 * @param pos posici�n del objeto a eliminar
	 */
	abstract public void eliminar(int pos);
}
