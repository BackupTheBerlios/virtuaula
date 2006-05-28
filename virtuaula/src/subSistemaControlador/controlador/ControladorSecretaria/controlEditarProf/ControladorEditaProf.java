package subSistemaControlador.controlador.ControladorSecretaria.controlEditarProf;

import gestores.Profesorado;
import subSistemaControlador.controlador.Controlador;
import beans.ObjetoBean;
import beans.listaObjetoBeans.*;
public class ControladorEditaProf extends ControladorEditarProf{

	public void procesarEvento() {
		//cojo el beanProfesor de la sesion y edito el profesor
		
		//ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("RdoControlador"));
        //Integer posicionLista =((Integer)sesion.getAttribute("posProf"));
        //int posi=posicionLista.intValue();
      	//ObjetoBean profesor=listaObjetoBean.dameObjeto(posi);
      	ObjetoBean profesor = (ObjetoBean)this.getSesion().getAttribute("beanProfesor");
		Profesorado profesorado = new Profesorado();
		profesorado.editar(profesor);
		this.setResuladooperacion("OK");
		this.getSesion().setAttribute("beanProfesor",profesor);
		
		
	}

	public Controlador clonar() {
		
		return new ControladorEditaProf();
	}

}
