package subSistemaBBDD;
import subSistemaBBDD.esquemaBBDD.*;
import subSistemaBBDD.listaObjeto.*;
import subSistemaBBDD.objetoBaseDatos.*;
import subSistemaBBDD.objetoCriterio.*;

import beans.*;
/**
 * Contenedor de todos lo creadores referentes del SubsistemaBBDD
 * @author Fco Javier Pérez Escrivá
 *
 */public class Creadores {
	private CreadorEsquemaBBDD creadorEsquema;
	private CreadorObjetoBBDD creadorObjetoBBDD;
	private CreadorObjetoCriterio creadorObjetoCriterio;
	private CreadorListaObjetoBBDD creadorListaObjetoBBDD;
	private CreadorBean creadorObjetoBean;
	
	
	public Creadores() {
		this.creadorEsquema=new CreadorEsquemaBBDD();
		this.creadorObjetoBBDD= new CreadorObjetoBBDD();
		this.creadorObjetoCriterio= new CreadorObjetoCriterio();
		this.creadorListaObjetoBBDD= new CreadorListaObjetoBBDD();
		this.creadorObjetoBean= new CreadorBean();
	}
	public CreadorEsquemaBBDD getCreadorEsquema() {
		return creadorEsquema;
	}
	public void setCreadorEsquema(CreadorEsquemaBBDD creadorEsquema) {
		this.creadorEsquema = creadorEsquema;
	}
	public CreadorListaObjetoBBDD getCreadorListaObjetoBBDD() {
		return creadorListaObjetoBBDD;
	}
	public void setCreadorListaObjetoBBDD(
			CreadorListaObjetoBBDD creadorListaObjetoBBDD) {
		this.creadorListaObjetoBBDD = creadorListaObjetoBBDD;
	}
	public CreadorObjetoBBDD getCreadorObjetoBBDD() {
		return creadorObjetoBBDD;
	}
	public void setCreadorObjetoBBDD(CreadorObjetoBBDD creadorObjetoBBDD) {
		this.creadorObjetoBBDD = creadorObjetoBBDD;
	}
	public CreadorObjetoCriterio getCreadorObjetoCriterio() {
		return creadorObjetoCriterio;
	}
	public CreadorBean getCreadorBean() {
		return this.creadorObjetoBean;
	}
	public void setCreadorObjetoCriterio(CreadorObjetoCriterio creadorObjetoCriterio) {
		this.creadorObjetoCriterio = creadorObjetoCriterio;
	}
	
	
}
