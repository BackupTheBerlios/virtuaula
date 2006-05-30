package subSistemaControlador.controlador.ControladorSecretaria.controlInsHor;



import gestores.GestorHorarios;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaControlador.controlador.Controlador;

public class ControladorInsertarHorario extends ControladorInsertarHorarioAbs{

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

	public Controlador clonar() {
		
		return new ControladorInsertarHorario();
	}

}
