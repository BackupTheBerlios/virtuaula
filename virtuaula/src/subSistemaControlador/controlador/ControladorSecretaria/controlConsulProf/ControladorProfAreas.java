package subSistemaControlador.controlador.ControladorSecretaria.controlConsulProf;

import subSistemaControlador.controlador.Controlador;
import gestores.Profesorado;


import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * 
 * @author Alberto Macho
 *Controla el paso de una pagina a otra en la consulta de un profesor
 *cuando tenemos que sacar las areas disponibles.
 */
public class ControladorProfAreas extends ControladorConsProf{

	/**
	 * Consulta las areas disponibles en el sistema para meterlas en la session 
	 */
	public void procesarEvento() 
	{
		ListaObjetoBean lista = new ListaObjetoBean();
		
		Profesorado profesorado = new Profesorado();
		lista=profesorado.consultaAreas();
		this.getSesion().setAttribute("listaarea",lista);
		if (lista!=null)
		{
			this.setResuladooperacion("OK");
			
		}
		else if (lista == null)
		{
			this.setResuladooperacion("ERROR");
		}
		this.getSesion().removeAttribute("bean");
		
	}

	public Controlador clonar() {
		return new ControladorProfAreas();
	}

}
