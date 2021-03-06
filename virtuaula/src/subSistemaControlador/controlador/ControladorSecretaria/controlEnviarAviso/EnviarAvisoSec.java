package subSistemaControlador.controlador.ControladorSecretaria.controlEnviarAviso;


import gestores.GestorAvisos;

import java.util.HashMap;

import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;

/**
 * 
 * @author AL
 *Controla el paso de una pagina a otra en el envio de un aviso
 *por parte de la secretaria.
 *Realiza las operaciones pertinentes y pone un resultado de operacio
 *segun el exito o el fracaso.Es el que se encarga de enviar el aviso
 */
public class EnviarAvisoSec extends ControladorAvisoSec{
	/**
	 * metodo que nos modifica el resultado operacion para saber cual sera
	 * la pagina de destino.
	 * Ademas segun el usuriao que hayamos elegido en la pagina anterior
	 * y con la ayuda del GestorAvisos mandamos el aviso
	 * al grupo elegido.
	 */
	public void procesarEvento() {
		ObjetoBean aviso= (ObjetoBean)this.getSesion().getAttribute("beanAvisos");
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
			if (op.equals("Departamento Contable"))
			{//el aviso es para un grupo de contables(usuarios)
				 errores=GA.avisoAGrupo(destino,aviso);
			}
			else if (op.equals("Departamento RRHH"))
			{//el aviso es para un grupo de RRHH(usuarios)
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
				System.out.println("Entra en alumnos");
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
/**
 * nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		
		return new EnviarAvisoSec();
	}

}
