package subSistemaControlador.controlador.ControladorSecretaria.controlEnviarAviso;
import gestores.GestorCursos;
import gestores.GestorUsuarios;
import gestores.Profesorado;

import java.util.HashMap;

import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;

/**
 * 
 * @author AL
 *Controla el paso de una pagina a otra en el envio de un aviso
 *por parte de la secretaria.
 *Realiza las operaciones pertinentes y pone un resultado de operacio
 *segun el exito o el fracaso.
 */
public class IniEnviarAvisoSec extends ControladorAvisoSec{
	/**
	 * metodo que nos modifica el resultado operacion para saber cual sera
	 * la pagina de destino.
	 * Ademas se encarga de meter en una tabla los grupos a los que podemos mandar avisos.
	 * Esto lo hacemos con ayuda del Gestor de usuarios, el profesorado, el gestor de cursos
	 */
	public void procesarEvento() {
		HashMap mapGrupos=new HashMap();
		ObjetoBean usuario=(ObjetoBean)this.getSesion().getAttribute("beanUsuario");
		CreadorBean creador = new CreadorBean();
		ObjetoBean profesor = creador.crear(creador.Profesor);
		profesor.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI,usuario.dameValor(Constantes.ID_ISUSUARIO_DNI));
		GestorUsuarios GU = new GestorUsuarios();
		Profesorado profesorado=new Profesorado();
		
		GestorCursos GC = new GestorCursos();
		ListaObjetoBean listaCont =GU.dameUsuarios("contable");
		ListaObjetoBean listaRRHH = GU.dameUsuarios("rrhh");
		ListaObjetoBean listaProf= profesorado.consultaProfesores();
		ListaObjetoBean listaCur = GC.dameCursosActivos();
		
		if (!listaRRHH.esVacio())
		{
			mapGrupos.put("Departamento RRHH",listaRRHH);
		}
		if (!listaCont.esVacio())
		{
			mapGrupos.put("Departamento Contable",listaCont);
		}
		if (!listaProf.esVacio())
		{
			mapGrupos.put("Profesorado",listaProf);		
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
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		
		return new IniEnviarAvisoSec();
	}

}
