package subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis;

import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorUsuario.ControladorUsuario;
import beans.listaObjetoBeans.*;
import beans.ObjetoBean;
import gestores.GestorAvisos;;
/**
 * Controal el paso de una pagina a otra en la operacion
 * de leer un aviso en concreto
 * @author AL
 *
 */public class ControladorLeerAviso extends ControladorUsuario{
	 /**
		 * metodo que nos modifica el resultado operacion para saber cual sera
		 * la pagina de destino dependiendo del resultado de las operaciones.
		 * Ademas obtiene la lista de avisos y la posicion del aviso selecionado 
		 * en la pagina anterior  y lo marca como leido 
		 */
	public void procesarEvento() {
		
		ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("listaaviso"));
        Integer posicionAviso = ((Integer)sesion.getAttribute("posAviso"));
      	ObjetoBean aviso = null;
      	
        if (listaObjetoBean != null && !listaObjetoBean.esVacio() && posicionAviso != null){
        	if (posicionAviso.intValue() <= listaObjetoBean.tamanio()) {
        		aviso =  listaObjetoBean.dameObjeto(posicionAviso.intValue()); 
        		aviso.cambiaValor(Constantes.AVISOS_ACTIVO,"N");
        		GestorAvisos GA = new GestorAvisos();
        		GA.editarAviso(aviso);
        	}}
        this.setResuladooperacion("SIG");
		
	}
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		
		return new ControladorLeerAviso();
	}

}
