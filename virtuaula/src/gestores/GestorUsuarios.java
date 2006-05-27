package gestores;

import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.BBDDFachadaUsuario;
import subSistemaBBDD.utils.Constantes;
import beans.listaObjetoBeans.ListaObjetoBean;

public class GestorUsuarios {
	
	public ListaObjetoBean dameUsuarios(String perfil)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaUsuario bdfc= (BBDDFachadaUsuario) (bdf.dameBBDDFachada(Constantes.FachadaUsuario));
		return bdfc.dameUsuariosPerfil(perfil);
		 
	}

}
