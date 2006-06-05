package subSistemaControlador.controlador.Contable;

import gestores.Profesorado;
import beans.CreadorBean;
import beans.ObjetoBean;

import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.*;
import subSistemaControlador.controlador.Controlador;
/**
 * Controla el paso de una pagina a otra, en este caso consulta los profesores y los contratos  
 * y los mete en session
 * 
 *
 */
public class ControladorConContrato extends ControladorContable{

	public void procesarEvento() {
		
		CreadorBean creador =new CreadorBean();
		ObjetoBean contrato = creador.crear(creador.Contrato);
		ObjetoBean profesor;
		Profesorado GP = new Profesorado();
		ListaObjetoBean listaprof = GP.consultaProfesores();
		ListaObjetoBean listacont = GP.consultaContratos(contrato);
		boolean encontrado;
		ListaObjetoBean listaprofresult = new ListaObjetoBean();
		
		for (int i =0; i< listacont.tamanio(); i++){
			encontrado = false;
			contrato = listacont.dameObjeto(i);
			int j = 0;
			while(!encontrado && j<listaprof.tamanio()){
				profesor = listaprof.dameObjeto(j);
				if(contrato.dameValor("ISUSUARIO_DNI").equals(profesor.dameValor("ISUSUARIO_DNI"))){				
					encontrado = true;
					listaprofresult.insertar(i,listaprof.dameObjeto(j));
				}
				j++;
			}
		} 
		
		if ((listaprofresult!=null) && (listacont!=null))
		{//no ha fallado la base de datos
			this.setResuladooperacion("OK");
			this.getSesion().removeAttribute("error");
			this.getSesion().setAttribute("listaprofesores",listaprofresult);
			this.getSesion().setAttribute("listacontratos",listacont);
			System.out.println((listaprofresult.tamanio()));
			System.out.println((listacont.tamanio()));
		}
		else if ((listaprof==null) || (listacont==null))
		{
			this.setResuladooperacion("ERROR");
			ObjetoBean error= creador.crear(creador.Error);
		    error.cambiaValor(Constantes.CAUSA,"Fallo en la base de datos al consultar los expedientes");
		    CreadorListaObjetoBean creadorlista =new CreadorListaObjetoBean();
		    ListaObjetoBean listaerror = creadorlista.crear(); 
		    listaerror.insertar(0,error);
		    this.getSesion().setAttribute("error",listaerror);
			
		}
	}

	public Controlador clonar() {
		
		return new ControladorConContrato();
	}

}
