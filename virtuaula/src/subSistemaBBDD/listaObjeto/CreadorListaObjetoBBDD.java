package subSistemaBBDD.listaObjeto;


/**
 * Clase encargada de la creación de ListaObjetoBBDD
 * formando parte del patrón Prototype siendo su rol de client_Prototype
 * @author Fco Javier Pérez Escrivá & Sergio Piqueras Martínez
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
	 * Crea una copia prototípica de la clase ListaObjetoBBDD
	 * @return copia
	 */
	public ListaObjetoBBDD crear(){
		if(listaObjeto==null)listaObjeto = new ListaObjetoBBDD();  
		return listaObjeto.clonar();
	}
}

