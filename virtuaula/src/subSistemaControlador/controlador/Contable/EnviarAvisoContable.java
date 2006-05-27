package subSistemaControlador.controlador.Contable;
import gestores.GestorAvisos;

import java.util.HashMap;

import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
public class EnviarAvisoContable extends ControladorContable{

	public void procesarEvento() {
		
		ObjetoBean aviso= (ObjetoBean)this.getSesion().getAttribute("beanAviso");
		HashMap listaGrupos=(HashMap)this.getSesion().getAttribute("listagrupos");
		//Esto no esta definido todavia
		String op = (String)this.getSesion().getAttribute("claveaviso");
		//Integer pos = (Integer)this.getSesion().getAttribute("posCombo");
		//int posi = pos.intValue();
		ListaObjetoBean destino = (ListaObjetoBean)listaGrupos.get(op);
		GestorAvisos GA= new GestorAvisos();
		CreadorBean creador = new CreadorBean();
		ListaObjetoBean errores= new ListaObjetoBean();
		if (!op.equals(""))
		{
			if (op.equals("Secretaria"))
			{//el aviso es para un grupo de secretarios(usuarios)
				 errores=GA.avisoAGrupo(destino,aviso);
			}
						
			if (!errores.esVacio())
			{//tenemos errores al enviar el aviso
				this.setResuladooperacion("ERROR");
				this.getSesion().setAttribute("error",errores);
			}
			else
			{//todo ha funcionado bien
				this.setResuladooperacion("OK");
				this.getSesion().removeAttribute("error");
				
			}
		}
		else //la pos es -1, es decir no hay ninguno elegido
		{
			ObjetoBean error = creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA,"Debe elegir algun destinatario");
			ListaObjetoBean listaerr= new ListaObjetoBean();
			listaerr.insertar(0,error);
			this.getSesion().setAttribute("error",listaerr);
			this.setResuladooperacion("ERROR");
			
		}
		
	}

	public Controlador clonar() {
		
		return new EnviarAvisoContable();
	}

}
