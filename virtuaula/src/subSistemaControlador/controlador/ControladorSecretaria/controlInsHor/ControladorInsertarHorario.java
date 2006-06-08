package subSistemaControlador.controlador.ControladorSecretaria.controlInsHor;



import gestores.GestorHorarios;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaControlador.controlador.Controlador;
/**
 * 
 * Este controlador controla la navegación entre dos paginas
 * en la insercion de un horario. 
 *
 */
public class ControladorInsertarHorario extends ControladorInsertarHorarioAbs{
	/**
	 * metodo que nos modifica el resultado operacion para saber cual sera
	 * la pagina de destino dependiendo del exito de las operaciones realizadas.
	 * Ademas comprueba con el gestor de horarios si este horario que obtenemos de sesion
	 * existe o no y si no existe y los datos son correctos lo inserta con el gestor de horarios
	 */
	public void procesarEvento() 
	{
		GestorHorarios GH = new GestorHorarios();
		ObjetoBean h = (ObjetoBean)this.getSesion().getAttribute("beanHorario");
		CreadorListaObjetoBean c = new CreadorListaObjetoBean();
		CreadorBean cBean = new CreadorBean();
		ListaObjetoBean listaError =  null;
		if (GH.horarioYaExiste(h)){
			listaError =  c.crear();
			String mensaje = "Ya existe un horario con esos datos";
			ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaError.insertar(0, error);
		} else if (h.dameValor("L").equals("null") && h.dameValor("M").equals("null") && h.dameValor("X").equals("null") &&
				h.dameValor("J").equals("null") && h.dameValor("V").equals("null")){
				listaError =  c.crear();
				String mensaje = "No puede dejar todos los campos en blanco";
				ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaError.insertar(0, error);
			
		}
		
		sesion.setAttribute("beanHorario",h);
	    if (listaError!=null)
		{
			this.setResuladooperacion("ERROR");
			this.getSesion().setAttribute("error",listaError);
			
		}
		else if (listaError==null)
		{
			if (GH.insertarHorario(h)){
				this.setResuladooperacion("OK");
				sesion.removeAttribute("error");
			}
			else{
				this.setResuladooperacion("ERROR");
			}
		}
		
		
	}
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		
		return new ControladorInsertarHorario();
	}

}
