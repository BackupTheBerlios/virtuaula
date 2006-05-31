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

	public Controlador clonar() {
		
		return new ControladorLeerAviso();
	}

}
