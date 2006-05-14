package subSistemaBBDD.listaObjeto;

/**
 * Clase encargada de la creaci�n de listaObjetoBBDD
 * formando parte del patr�n Prototype siendo su rol de client_Prototype
 * @author Fco Javier P�rez Escriv� & Sergio Piqueras Mart�nez
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
	 * Crea una copia protot�pica de la clase listaObjetoBBDD
	 * @return copia
	 */
	public ListaObjetoBBDD crear(){
		return lista.clonar();
	}
}

