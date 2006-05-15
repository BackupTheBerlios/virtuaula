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
	 * Inserta un ObjetoBean en la lista en una posición determinada
	 * (si la posición está ocupada, sobreescribe el ObjetoBean). El ObjetoBean se 
	 * inserta en la posición especificada siempre y cuando en esa posición
	 * haya un ObjetoBean (lo sobreescribe) o bien si la posición es la siguiente
	 * a la última posición de un ObjetoBBDD existente en la ListaObjetoBean. Si
	 * esto no es así, el ObjetoBean no se inserta en la ListaObjetoBean.
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
	* Accesor del objeto de la posición especificada Devuelve un ObjetoBean
	* @param pos posición a examinar
	* @return objeto consultado. Si no existe un objeto en la posición especificada, devuelve null.
	*/
    public ObjetoBean dameObjeto(int pos){
    	try{
			return (ObjetoBean)lista.get(pos);
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
	 * Devuelve una copia de la ListaObjetoBean al que se le envia el mensaje Patrón Prototype
	 * @return copia
	 */
    public ListaObjetoBean clonar(){
    	ListaObjetoBean list = new ListaObjetoBean();
    	return list;	
	}
    /**
     * 
     * @return devuelve el tamaño de la lista.
     */
    public int tamaño(){
		return lista.size();
	}

}

