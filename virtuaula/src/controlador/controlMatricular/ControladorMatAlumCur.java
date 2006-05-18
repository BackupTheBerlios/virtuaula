package controlador.controlMatricular;

import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import controlador.Controlador;
/**
 * 
 * @author Alberto Macho 
 *
 */
public class ControladorMatAlumCur extends ControladorMatricular {
/**
 * Este metodo cogera el curso metido en la session y consultara la clase, el profesor
 * , el horario y el precio de ese curso y lo metera en la session para mostrarlo 
 * en la siguiente pagina.
 */
	public void procesarEvento() {
		
	Integer posc = (Integer)this.getSesion().getAttribute("posCurso");
	int poscurso = posc.intValue();
	//si el curso elegido es valido
	if (poscurso!=-1)
	{
		ListaObjetoBean listacur = (ListaObjetoBean)this.getSesion().getAttribute("listacurso");
		ObjetoBean curso=listacur.dameObjeto(poscurso);
		
		
	}
	//si el curso escogido no es valido, es decir, es -1
	else if (poscurso==-1)
	{
		this.setResuladooperacion("ERROR");
		
	}
	}

	public Controlador clonar() {
		return new ControladorMatAlumCur();
	}

}
