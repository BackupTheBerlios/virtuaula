package subSistemaControlador.controlador.Contable;
import gestores.GestorUsuarios;
import gestores.Profesorado;

import java.util.HashMap;

import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
public class IniEnviarAvisoContable extends ControladorContable{

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

	public Controlador clonar() {
		
		return new IniEnviarAvisoContable();
	}

}
