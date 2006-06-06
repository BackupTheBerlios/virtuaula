package subSistemaBBDD;
import subSistemaBBDD.esquemaBBDD.*;
import subSistemaBBDD.listaObjeto.*;
import subSistemaBBDD.objetoBaseDatos.*;
import subSistemaBBDD.objetoCriterio.*;

import beans.*;
/**
 * Contenedor de todos lo creadores referentes del SubsistemaBBDD
 * @author Fco Javier P�rez Escriv�
 *
 */public class Creadores {
	/**
	 * Un atributo creador por cada uno de los elementos que forman el subSistemaBBDD
	 */
	private CreadorEsquemaBBDD creadorEsquema;
	private CreadorObjetoBBDD creadorObjetoBBDD;
	private CreadorObjetoCriterio creadorObjetoCriterio;
	private CreadorListaObjetoBBDD creadorListaObjetoBBDD;
	private CreadorBean creadorObjetoBean;
	
	/**
	 * Constructor de la clase que inicializa los atributos.
	 *
	 */
	public Creadores() {
		this.creadorEsquema=new CreadorEsquemaBBDD();
		this.creadorObjetoBBDD= new CreadorObjetoBBDD();
		this.creadorObjetoCriterio= new CreadorObjetoCriterio();
		this.creadorListaObjetoBBDD= new CreadorListaObjetoBBDD();
		this.creadorObjetoBean= new CreadorBean();
	}
	/** 
	 * 
	 * @return un creador de tablas de la base de datos.
	 */
	public CreadorEsquemaBBDD getCreadorEsquema() {
		return creadorEsquema;
		
	}
	/**
	 * 
	 * @param creadorEsquema inicializa el atributos creadorEsquema con el pasado como par�metro
	 */
	public void setCreadorEsquema(CreadorEsquemaBBDD creadorEsquema) {
		this.creadorEsquema = creadorEsquema;
	}
	/**
	 * 
	 * @return un creador de ListaObjetoBBDD
	 */
	public CreadorListaObjetoBBDD getCreadorListaObjetoBBDD() {
		return creadorListaObjetoBBDD;
	}
	
	/**
	 * Inicializa el atributos creadorListaObjetoBBDD con el que se le pasa como par�metro.
	 * @param creadorListaObjetoBBDD con el realiza la inicializaci�n se�alada.
	 */
	public void setCreadorListaObjetoBBDD(
			CreadorListaObjetoBBDD creadorListaObjetoBBDD) {
		this.creadorListaObjetoBBDD = creadorListaObjetoBBDD;
	}
	/**
	 * 
	 * @return un creador de ObjetoBBDD
	 */
	public CreadorObjetoBBDD getCreadorObjetoBBDD() {
		return creadorObjetoBBDD;
	}
	/**
	 * inicializa el atributo creadorObjetoBBDD con el que se le pasa como par�metro.
	 * @param creadorObjetoBBDD par�metro con el que se realiza la inicializaci�n comentada.
	 */
	public void setCreadorObjetoBBDD(CreadorObjetoBBDD creadorObjetoBBDD) {
		this.creadorObjetoBBDD = creadorObjetoBBDD;
	}
	/**
	 * 
	 * @return un creador de ObjetoCriterio
	 */
	public CreadorObjetoCriterio getCreadorObjetoCriterio() {
		return creadorObjetoCriterio;
	}
	/**
	 * 
	 * @return un creador de Bean
	 */
	public CreadorBean getCreadorBean() {
		return this.creadorObjetoBean;
	}
	
	/**
	 * Inicializa el atributo creadorObjetoCriterio con el que se le pasa como par�metro.
	 * @param creadorObjetoCriterio con el cual se realiza la inicializaci�n se�alada.
	 */
	public void setCreadorObjetoCriterio(CreadorObjetoCriterio creadorObjetoCriterio) {
		this.creadorObjetoCriterio = creadorObjetoCriterio;
	}
	
	
}
