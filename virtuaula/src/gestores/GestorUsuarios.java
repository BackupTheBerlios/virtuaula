package gestores;

import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.BBDDFachadaUsuario;
import subSistemaBBDD.utils.Constantes;
import beans.listaObjetoBeans.ListaObjetoBean;

/**
 * Realiza las operaciones sobre usuarios
 * @author AL 
 */
public class GestorUsuarios {
	/**
	 * Devuelve los usuarios que se corresponden con un perfil
	 * 
	 * @param perfil
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean dameUsuarios(String perfil) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaUsuario bdfc = (BBDDFachadaUsuario) (bdf
				.dameBBDDFachada(Constantes.FachadaUsuario));
		return bdfc.dameUsuariosPerfil(perfil);

	}

}
