package beans.listaObjetoBeans;

import java.util.ArrayList;

import beans.ObjetoBean;


/**
 * 
 * @author Alberto Macho
 * Adapta la clase ListaObjetoBeanAbs a un array de java, con las operaciones
 * que nos interesa.
 */
public class ListaObjetoBean extends ListaObjetoBeanAbs{
	private ArrayList lista;
	/**
	 * Lista que contiene ObjetoBean
	 */
	public ListaObjetoBean() {
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
	 * Inserta un ObjetoBean en la lista en una posici�n determinada
	 * (si la posici�n est� ocupada, sobreescribe el ObjetoBean). El ObjetoBean se 
	 * inserta en la posici�n especificada siempre y cuando en esa posici�n
	 * haya un ObjetoBean (lo sobreescribe) o bien si la posici�n es la siguiente
	 * a la �ltima posici�n de un ObjetoBBDD existente en la ListaObjetoBean. Si
	 * esto no es as�, el ObjetoBean no se inserta en la ListaObjetoBean.
	 * @param pos posicion donde insertar el objeto 
	 * @param obj objetoBean a insertar
	*/
	public void insertar (int pos, ObjetoBean obj){
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
	* Accesor del objeto de la posici�n especificada Devuelve un ObjetoBean
	* @param pos posici�n a examinar
	* @return objeto consultado. Si no existe un objeto en la posici�n especificada, devuelve null.
	*/
    public ObjetoBean dameObjeto(int pos){
    	try{
			return (ObjetoBean)lista.get(pos);
		}		
		catch(IndexOutOfBoundsException e){return null;}
	}
	/**
	* Elimina el objeto de la posici�n especificada
	* @param pos posici�n del objeto a eliminar
	*/
	public void eliminar(int pos){
		try{
		   lista.remove(pos);
		   lista.trimToSize();
		}		
		catch(IndexOutOfBoundsException e){}
	}
	/**
	 * Devuelve una copia de la ListaObjetoBean al que se le envia el mensaje Patr�n Prototype
	 * @return copia
	 */
    public ListaObjetoBean clonar(){
    	ListaObjetoBean list = new ListaObjetoBean();
    	return list;	
	}
    /**
     * 
     * @return devuelve el tama�o de la lista.
     */
    public int tama�o(){
		return lista.size();
	}

}

