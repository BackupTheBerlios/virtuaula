package subSistemaControlador.controlador.ControladorProfesor.controlEnviarAviso;

import gestores.GestorAvisos;

import java.util.HashMap;

import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorProfesor.ControladorProfesor;

public class EnviarAvisoProf extends ControladorProfesor{

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
			else if (op.equals("Profesorado"))
			{//el aviso es para un grupo de profesores			
				
				int tama=destino.tamanio();
				ListaObjetoBean dest = new ListaObjetoBean();
				
				for (int i=0;i<tama;i++)
				{//me creo una lista de usuarios a partir de la lista de profesores
					ObjetoBean usu=creador.crear(creador.Usuario);
					usu.cambiaValor(Constantes.ID_ISUSUARIO_DNI ,destino.dameObjeto(i).dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI));
					dest.insertar(i,usu);
					
				}
				 errores=GA.avisoAGrupo(dest,aviso);
			}
			else
			{//el aviso es para un grupo de alumnos
				int tamanio=destino.tamanio();
				ListaObjetoBean desti = new ListaObjetoBean();
				
				for (int i=0;i<tamanio;i++)
				{//me creo una lista de usuarios a partir de la lista de profesores
					ObjetoBean usu=creador.crear(creador.Usuario);
					usu.cambiaValor(Constantes.ID_ISUSUARIO_DNI ,destino.dameObjeto(i).dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
					desti.insertar(i,usu);
					
				}
				 errores=GA.avisoAGrupo(desti,aviso);
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
		else //no ha seleccionado nada en el combo
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
		
		return new EnviarAvisoProf();
	}

}
