package subSistemaBBDD;

import subSistemaBBDD.utils.Constantes;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

public class BBDDFachadaAviso extends BBDDFachada{
	protected BBDDFachadaAviso(){
		
	}
	/**
	 * Devuelve una lista de avisos para el usuario que se pasa por parametro.
	 * @param beanUsuario
	 * @return
	 */
	public ListaObjetoBean dameAvisosUsuario(ObjetoBean usuario){
		CreadorBean creadorBean = new CreadorBean();
		CreadorListaObjetoBean creadorListaBean = new CreadorListaObjetoBean();
		ObjetoBean avisoUsuario= creadorBean.crear(creadorBean.AvisosHasUario);
		avisoUsuario.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,usuario.dameValor(Constantes.ID_ISUSUARIO_DNI));
		ListaObjetoBean avisosUsuario= this.consultar(avisoUsuario);
		//aqui guardaremos los bean avisos correspondientes al usuario
		ListaObjetoBean avisos = creadorListaBean.crear();
		
		for (int i=0;i <avisosUsuario.tamanio();i++){
			ObjetoBean avisoBuscado = creadorBean.crear(creadorBean.Avisos);
			avisoBuscado.cambiaValor(Constantes.ID_ISAVISOS,avisosUsuario.dameObjeto(i).dameValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO));
			ObjetoBean avisoUsu =this.consultar(avisoBuscado).dameObjeto(0);
			avisos.insertar(avisos.tamanio(),avisoUsu);		
		}
		return avisos;
	}
}