package gestores;

import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.BBDDFachadaUsuario;
import subSistemaBBDD.utils.Constantes;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * 
 * @author AL
 *Realiza las operaciones sobre usuarios
 */
public class GestorUsuarios {
	/**
	 * de devuelve los usuarios que se corresponden con un perfil
	 * @param perfil
	 * @return
	 */
	public ListaObjetoBean dameUsuarios(String perfil)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaUsuario bdfc= (BBDDFachadaUsuario) (bdf.dameBBDDFachada(Constantes.FachadaUsuario));
		return bdfc.dameUsuariosPerfil(perfil);
		 
	}

}
