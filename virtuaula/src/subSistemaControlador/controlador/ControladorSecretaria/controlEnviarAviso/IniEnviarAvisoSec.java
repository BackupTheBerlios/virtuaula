package subSistemaControlador.controlador.ControladorSecretaria.controlEnviarAviso;
import gestores.GestorUsuarios;
import gestores.Profesorado;

import java.util.HashMap;

import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
public class IniEnviarAvisoSec extends Controlador{

	public void procesarEvento() {
		HashMap mapGrupos=new HashMap();
		ObjetoBean usuario=(ObjetoBean)this.getSesion().getAttribute("beanUsuario");
		CreadorBean creador = new CreadorBean();
		ObjetoBean profesor = creador.crear(creador.Profesor);
		profesor.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI,usuario.dameValor(Constantes.ID_ISUSUARIO_DNI));
		GestorUsuarios GU = new GestorUsuarios();
		Profesorado profesorado=new Profesorado();
		
		
		ListaObjetoBean listaCont =GU.dameUsuarios("contable");
		ListaObjetoBean listaProf= profesorado.consultaProfesores();
		ListaObjetoBean listaCur = profesorado.consultaCursosProfesor(profesor);
		
		if (!listaCont.esVacio())
		{
			mapGrupos.put("contables",listaCont);
		}
		if (!listaProf.esVacio())
		{
			mapGrupos.put("profesores",listaProf);		
		}
		if (!listaCur.esVacio())
		{
			int tam=listaCur.tamanio();
			for (int i=0;i<tam;i++)
			{
				String nomCur=listaCur.dameObjeto(i).dameValor(Constantes.CURSO_NOMBRE);
				ObjetoBean curso = listaCur.dameObjeto(i);
				ListaObjetoBean listaAlum =profesorado.consultaAlumnosDeCurso(curso);
				mapGrupos.put(nomCur,listaAlum);
			}
		}
		if ((!listaCont.esVacio()) || (!listaProf.esVacio()) || (!listaCur.esVacio()))
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
		
		return new IniEnviarAvisoSec();
	}

}
