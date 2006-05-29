package subSistemaBBDD;

import subSistemaBBDD.utils.Constantes;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * Fachada especializada para operaciones con la tabla aviso 
 * o de las tablas que la relacionan con otras.
 * de la base de datos.
 * @author JORGE SANCHEZ
 *
 */
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
			ListaObjetoBean avisosNuevos= this.consultar(avisoBuscado);
			if(avisosNuevos.tamanio()>0){
				ObjetoBean avisoUsu =avisosNuevos.dameObjeto(0);
				avisos.insertar(avisos.tamanio(),avisoUsu);
			}
			
					
		}
		return avisos;
	}

	
	/**
	 * Devuelve una lista de avisos sin leer para el usuario que se pasa por parametro.
	 * @param beanUsuario
	 * @return
	 */
	public ListaObjetoBean dameAvisosNuevosUsuario(ObjetoBean usuario){
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
			ListaObjetoBean avisosNuevos= this.consultar(avisoBuscado);
			if(avisosNuevos.tamanio()>0){
				ObjetoBean avisoUsu =avisosNuevos.dameObjeto(0);
				if(avisoUsu.dameValor(Constantes.AVISOS_ACTIVO)!=null && avisoUsu.dameValor(Constantes.AVISOS_ACTIVO).equals("S"))
					avisos.insertar(avisos.tamanio(),avisoUsu);
			}
			
					
		}
		return avisos;
	}

	
}
