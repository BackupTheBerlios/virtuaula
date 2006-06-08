package subSistemaControlador.controlador.Contable;
import gestores.GestorUsuarios;


import java.util.HashMap;

import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
/**
 *  * Controla el paso de una pagina a otra devolviendo el resultado OK o ERROR dependiendo
 * del exito de las acciones que tenga q realizar
 * 
 *
 */
public class IniEnviarAvisoContable extends ControladorContable{
	/**
	 * Este metodo nos modifica el resultadooperacion para indicar a la pagina que
	 * tiene que pasar. Ademas utilizando el Gestor de usuarios obtenemos los usuarios
	 * con un determindao perfil para meterlos en session y poder mandar avisos
	 * a estos grupos en el siguiente controlador.
	 */
	
	public void procesarEvento() {
		HashMap mapGrupos=new HashMap();
		ObjetoBean usuario=(ObjetoBean)this.getSesion().getAttribute("beanUsuario");
		CreadorBean creador = new CreadorBean();
		ObjetoBean profesor = creador.crear(creador.Profesor);
		profesor.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI,usuario.dameValor(Constantes.ID_ISUSUARIO_DNI));
		GestorUsuarios GU = new GestorUsuarios();
			
		ListaObjetoBean listaSec =GU.dameUsuarios("secretaria");
		ListaObjetoBean listaRRHH = GU.dameUsuarios("rrhh");
		
		
		if (!listaSec.esVacio())
		{
			mapGrupos.put("Secretaria",listaSec);
		}
		if (!listaSec.esVacio())
		{
			mapGrupos.put("Departamento RRHH",listaRRHH);
		}
		
		if ((!listaSec.esVacio()))
		{	
			this.setResuladooperacion("OK");
			this.getSesion().setAttribute("listagrupos",mapGrupos);
			this.getSesion().removeAttribute("error");
		}
		else 
		{
			ObjetoBean error = creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA,"No hay usuarios a los que pueda mandar avisos");
			ListaObjetoBean listaerr= new ListaObjetoBean();
			listaerr.insertar(0,error);
			this.getSesion().setAttribute("error",listaerr);
			this.setResuladooperacion("ERROR");
		}	
		
	}
/**
 * @return nos devuelve un controlador de esta clase.
 */
	public Controlador clonar() {
		
		return new IniEnviarAvisoContable();
	}

}
