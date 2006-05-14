package subSistemaBBDD.listaObjeto;

import java.util.ArrayList;

import subSistemaBBDD.objetoBaseDatos.*;

/**Clase que hereda de la clase abstracta ListaObjetoBBDDAbs.Adapta la clase ArrayList 
 * de java al interfaz ListaObjetoBBDDAbs.
 * @see La Clase 
 * <a href="../listaObjetoBBDD/ArrayList.html">ArrayList</a>
 * @author Fco Javier Pérez Escrivá & Sergio Piqueras Martínez
 */
public class ListaObjetoBBDD extends ListaObjetoBBDDAbs{
	private ArrayList lista;
	/**
	 * Lista que contiene ObjetosBBDD
	 */
	public ListaObjetoBBDD() {
		super();
		lista = new ArrayList(10);
	}

	/**
	 * Dice si la lista esta vacia o no 
	 * @return true en el caso afirmativo, false en caso contrario
	*/
	public boolean esVacio(){
       return lista.isEmpty();
	}
	/**
	 * Inserta un objetoBBDD en la lista en una posición determinada
	 * (si esta ocupada lo sobreescribe)
	 * @param pos posicion donde insertar el objeto 
	 * @param obj objetoBBDD a insertar
	*/
	public void insertar (int pos, ObjetoBBDD obj){
		try{
			if(lista.get(pos)!=null)lista.set(pos,obj);
		}		
		catch(IndexOutOfBoundsException e){lista.add(pos,obj);}
	}
	/**
	* Accesor del objeto de la posición especificada
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
		}		
		catch(IndexOutOfBoundsException e){}
	}
	/**
	 * Devuelve el número de elementos de la lista
	 * @return numero de elementos en la lista
	 */
	public int tamaño(){
		return lista.size();
	}
	/**
	 * Devuelve una copia del objetoBBDD al que se le envia el mensaje Patrón Prototype
	 * @return copia
	 */
    public ListaObjetoBBDD clonar(){
    	ListaObjetoBBDD list = new ListaObjetoBBDD();
    	return list;	
	}

}

