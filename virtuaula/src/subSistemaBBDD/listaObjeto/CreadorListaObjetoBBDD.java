package subSistemaBBDD.listaObjeto;

/**
 * Clase encargada de la creación de listaObjetoBBDD
 * formando parte del patrón Prototype siendo su rol de client_Prototype
 * @author Fco Javier Pérez Escrivá & Sergio Piqueras Martínez
 */
    public class CreadorListaObjetoBBDD {
    	static private ListaObjetoBBDD lista;
    /**
     * Constructora de la clase
     *
     */
    public CreadorListaObjetoBBDD(){
    	if (lista==null)lista = new ListaObjetoBBDD();
    }
	/**
	 * Crea una copia prototípica de la clase listaObjetoBBDD
	 * @return copia
	 */
	public ListaObjetoBBDD crear(){
		return lista.clonar();
	}
}

