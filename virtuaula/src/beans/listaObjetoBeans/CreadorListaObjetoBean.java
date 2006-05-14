package beans.listaObjetoBeans;
/**
 * 
 * @author Alberto Macho
 * Es la clase encargada de crear ListaObjetoBean
 * usamos el patron prototype. 
 * Tenemos un atributo static que se genererara una vez, cuando no se haya creado antes,
 * si no se ha creado se genera una nueva a partir de la que se generaran los clones.
 */
public class CreadorListaObjetoBean {
	static private ListaObjetoBean lista;
    /**
     * Constructora de la clase
     *
     */
    public CreadorListaObjetoBean(){    	
    }
	/**
	 * Crea una copia prototípica de la clase listaObjetoBBDD
	 * @return copia
	 */
	public ListaObjetoBean crear(){
		ListaObjetoBean list;
		//solo se crea cuando no ha sido creada anteriormente, si ya ha sido creada
		//se usa la que esta creada para crear porque es un prototipo
		if (lista==null)
		{
			lista = new ListaObjetoBean();
		}
		list=lista.clonar();
		return list;
	}
}
