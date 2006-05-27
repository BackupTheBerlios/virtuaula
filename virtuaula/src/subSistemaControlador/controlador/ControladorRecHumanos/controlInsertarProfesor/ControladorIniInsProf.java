package subSistemaControlador.controlador.ControladorRecHumanos.controlInsertarProfesor;
import gestores.Profesorado;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorRecHumanos.ControladorRecHumanos;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

public class ControladorIniInsProf extends ControladorRecHumanos{

	public void procesarEvento() {
//		consultamos las areas disponibles en la academis y las metemos en sesion
		Profesorado profesorado = new Profesorado();
		ListaObjetoBean listaareas=profesorado.consultaAreas();
		//borramos el bean profesor de la sesion por las anteriores veces, 
		//ya que vamos a empezar de nuevo
		sesion.removeAttribute("beanProfesor");
		
		if (listaareas!=null)
		{//si no ha fallado la base de datos
			this.setResuladooperacion("OK");
			this.getSesion().removeAttribute("error");
			this.getSesion().setAttribute("listaarea",listaareas);
			
		}
		else if(listaareas==null)
		{//la base de datos ha fallado, entonces genero error
			this.setResuladooperacion("ERROR");
			CreadorBean creador = new CreadorBean();
		    ObjetoBean error= creador.crear(creador.Error);
		    error.cambiaValor(Constantes.CAUSA,"Fallo en la base de datos al consultar areas");
		    CreadorListaObjetoBean creadorlista =new CreadorListaObjetoBean();
		    ListaObjetoBean listaerror = creadorlista.crear(); 
		    listaerror.insertar(0,error);
		    this.getSesion().setAttribute("error",listaerror);
			
		}
	}

	public Controlador clonar() {
		
		return new ControladorIniInsProf();
	}
	
	

}
