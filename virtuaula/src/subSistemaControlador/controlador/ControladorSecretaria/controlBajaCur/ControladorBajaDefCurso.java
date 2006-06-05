package subSistemaControlador.controlador.ControladorSecretaria.controlBajaCur;
import gestores.GestorCursos;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
/**
 * 
 * @author Alberto Macho
 * Controla la navegacion entre dos paginas.
 * Concretamente este controlador da de baja el curso
 * y devuelve OK o ERROR en el resultado para
 * que pase a una u otra pagina
 *
 */
public class ControladorBajaDefCurso extends ControladorBajaCurso{

	public void procesarEvento() {
		
		Integer poscur= (Integer)this.getSesion().getAttribute("posCurso");
		ListaObjetoBean	listacurso=(ListaObjetoBean)this.getSesion().getAttribute("listacurso");
		int posc= poscur.intValue();
		ObjetoBean curso=(ObjetoBean)listacurso.dameObjeto(posc);
		GestorCursos GC = new GestorCursos();
		boolean exito =GC.darBajaCurso(curso);
		if (exito==true)
		{//operacion realizada correctamente
			this.setResuladooperacion("OK");
			this.getSesion().removeAttribute("error");
		}
		else if (exito==false)
		{//operacion fallida
			this.setResuladooperacion("ERROR");
			//generar error
			CreadorBean creador = new CreadorBean();
			ObjetoBean error = creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA,"Error al dar de baja el curso");
			ListaObjetoBean listaerr= new ListaObjetoBean();
			listaerr.insertar(0,error);
			this.getSesion().setAttribute("error",listaerr);
		}
		
	}

	public Controlador clonar() {
		
		return new ControladorBajaDefCurso();
	}

}
