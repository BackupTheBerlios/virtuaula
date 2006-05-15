package controlador.controlEditarFicha;

import gestores.Profesorado;
import beans.Curso;
import beans.Profesor;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
import controlador.Controlador;
/**
 * 
 * @author Alberto Macho
 * Controla la operacion de publicar las notas, consulta la lista de cursos para
 * mostrarla en la sig pagina.
 *
 */
public class PublicarNotas extends Controlador{
/**
 * Consuta la lista de cursos de ese profesor y la mete en la session
 * Si la lista devuelta es null sera un error de la base de datos.
 */
	public void procesarEvento() {
	
	Profesorado GP = new Profesorado();	
	Profesor prof = new Profesor();
	String idprof = (String)sesion.getAttribute("idusuario");
	prof.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI,idprof);
	Integer posc=(Integer)this.getSesion().getAttribute("posCurso");
	int poscurso=posc.intValue();
	ListaObjetoBean listacurso=(ListaObjetoBean)this.getSesion().getAttribute("listacurso");
	Curso curso=(Curso)listacurso.dameObjeto(poscurso);
	boolean correcto=GP.PublicarNota(curso);
	
	
	if (correcto==true)
	{
		ListaObjetoBean lista = GP.consultaCursosActivos(prof);
	if (lista!=null)
	//la consulta se ha realizado con exito
	{
		this.setResuladooperacion("OK");
		this.getSesion().setAttribute("listacurso",lista);
		
	}
	else if (lista==null)
		//la consulta ha fallado en la base de datos.
	{
		this.setResuladooperacion("ERROR");
	}
	}
	else if (correcto == false)
	{
		this.setResuladooperacion("ERROR");
	}
	}

	public Controlador clonar() {
		
		return new PublicarNotas();
	}

}
