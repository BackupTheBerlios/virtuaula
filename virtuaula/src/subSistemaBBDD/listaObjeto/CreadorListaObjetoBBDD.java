package subSistemaBBDD.listaObjeto;


/**
 * Clase encargada de la creaci�n de ListaObjetoBBDD
 * formando parte del patr�n Prototype siendo su rol de client_Prototype
 * @author Fco Javier P�rez Escriv� & Sergio Piqueras Mart�nez
 *
 */
    public class CreadorListaObjetoBBDD{
    	private ListaObjetoBBDD listaObjeto;
    /**
     * Constructora de la clase.
     *
     */
    public CreadorListaObjetoBBDD(){
    	super();
    }
	/**
	 * Crea una copia protot�pica de la clase ListaObjetoBBDD
	 * @return copia
	 */
	public ListaObjetoBBDD crear(){
		if(listaObjeto==null)listaObjeto = new ListaObjetoBBDD();  
		return listaObjeto.clonar();
	}
}

