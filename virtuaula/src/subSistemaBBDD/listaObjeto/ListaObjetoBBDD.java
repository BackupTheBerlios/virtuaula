package subSistemaBBDD.listaObjeto;

import java.util.ArrayList;

import subSistemaBBDD.objetoBaseDatos.*;

/**Clase que hereda de la clase abstracta ListaObjetoBBDDAbs. Adapta la clase ArrayList 
 * de java al interfaz ListaObjetoBBDDAbs.
 * @see La Clase 
 * <a href="../listaObjetoBBDD/ArrayList.html">ArrayList</a>
 * @author Fco Javier Pérez Escrivá & Sergio Piqueras Martínez
 */
public class ListaObjetoBBDD extends ListaObjetoBBDDAbs{
	private ArrayList lista;
	/**
	 * Lista que contiene ObjetoBBDD
	 */
	public ListaObjetoBBDD() {
		super();
		lista = new ArrayList();
	}

	/**
	 * Dice si la lista esta vacia o no 
	 * @return true en el caso afirmativo, false en caso contrario
	*/
	public boolean esVacio(){
       return lista.isEmpty();
	}
	/**
	 * Inserta un ObjetoBBDD en la lista en una posición determinada
	 * (si la posición está ocupada, sobreescribe el ObjetoBBDD). El ObjetoBBDD se 
	 * inserta en la posición especificada siempre y cuando en esa posición
	 * haya un ObjetoBBDD (lo sobreescribe) o bien si la posición es la siguiente
	 * a la última posición de un ObjetoBBDD existente en la ListaObjetoBBDD. Si
	 * esto no es así, el ObjetoBBDD no se inserta en la ListaObjetoBBDD.
	 * @param pos posicion donde insertar el objeto 
	 * @param obj objetoBBDD a insertar
	*/
	public void insertar (int pos, ObjetoBBDD obj){
		try{
			if(lista.get(pos)!=null)lista.set(pos,obj);
		}		
		catch(IndexOutOfBoundsException e){
			try{
				lista.add(pos,obj);
			}
			catch(IndexOutOfBoundsException ex){}
		}
	}
	/**
	* Accesor del objeto de la posición especificada. Devuelve un ObjetoBBDD
	* @param pos posición a examinar
	* @return objeto consultado. Si no existe un objeto en la posición especificada, devuelve null.
	*/
    public ObjetoBBDD dameObjeto(int pos){
    	try{
			return (ObjetoBBDD)lista.get(pos);
		}		
		catch(IndexOutOfBoundsException e){return null;}
	}
	/**
	* Elimina el objeto de la posición especificada
	* @param pos posición del objeto a eliminar
	*/
	public void eliminar(int pos){
		try{
		   lista.remove(pos);
		   lista.trimToSize();
		}		
		catch(IndexOutOfBoundsException e){}
	}
	/**
	 * Devuelve una copia de la ListaObjetoBBDD al que se le envia el mensaje Patrón Prototype
	 * @return copia
	 */
    public ListaObjetoBBDD clonar(){
    	ListaObjetoBBDD list = new ListaObjetoBBDD();
    	return list;	
	}
	/**
	 * Devuelve el número de elementos de la lista
	 * @return numero de elementos en la lista
	 */
	public int tamanio(){
		return lista.size();
	}

}
