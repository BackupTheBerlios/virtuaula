package subSistemaControlador.controlador.ControladorProfesor.controlEditarFicha;

import gestores.Profesorado;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorProfesor.ControladorProfesor;
/**
 * 
 * @author Alberto Macho
 * Controla la operacion de publicar las notas, realiza la operacion
 * de publicar las notas de un curso en concreto
 *
 */
public class PublicarNotas extends ControladorProfesor{

/**
* Este metodo nos modifica el resultadooperacion para indicar a la pagina que
* tiene que pasar. Ademas utilizando el profesorado publicamos las notas
* de un curso que hemos obtenido de la sesion
*/

	public void procesarEvento() {
	CreadorBean creador = new CreadorBean();
	Profesorado GP = new Profesorado();	
	ObjetoBean prof = creador.crear(creador.Profesor);
	ObjetoBean idprof = (ObjetoBean)sesion.getAttribute("beanUsuario");
	prof.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI,idprof.dameValor(Constantes.ID_ISUSUARIO_DNI));
	
	
	Integer posc=(Integer)this.getSesion().getAttribute("posCurso");
	int poscurso=posc.intValue();
	ListaObjetoBean listacurso=(ListaObjetoBean)this.getSesion().getAttribute("listacurso");
	ObjetoBean curso=(ObjetoBean)listacurso.dameObjeto(poscurso);
	boolean correcto=GP.PublicarNota(curso);
	
	
	if (correcto==true)
	{
		//ListaObjetoBean lista = GP.consultaCursosActivos(prof);
		ListaObjetoBean lista=GP.dameExpedienteCurso(curso);
	if (lista!=null)
	//la consulta se ha realizado con exito
	{
		this.setResuladooperacion("OK");
		this.getSesion().setAttribute("listaexpedientealumno",lista);
		this.getSesion().removeAttribute("error");
	}
	else if (lista==null)
		//la consulta ha fallado en la base de datos.
	{
		ObjetoBean error = creador.crear(creador.Error);
		error.cambiaValor(Constantes.CAUSA,"Se ha producido un error de base de datos");
		ListaObjetoBean listaerror = new ListaObjetoBean();
		listaerror.insertar(0,error);
		this.getSesion().setAttribute("error",listaerror);
		this.setResuladooperacion("ERROR");
	}
	}
	//no se ha realizado correctamente la operacion
	else if (correcto == false)
	{
		ObjetoBean error = creador.crear(creador.Error);
		error.cambiaValor(Constantes.CAUSA,"No ha sido posible publicar las notas");
		ListaObjetoBean listaerror = new ListaObjetoBean();
		listaerror.insertar(0,error);
		this.getSesion().setAttribute("error",listaerror);
		this.setResuladooperacion("ERROR");
	}
	}
/**
 * @return devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		
		return new PublicarNotas();
	}

}
