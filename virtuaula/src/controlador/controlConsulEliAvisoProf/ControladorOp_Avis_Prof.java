package controlador.controlConsulEliAvisoProf;

import gestores.GestorAvisos;
import gestores.Profesorado;

import javax.servlet.http.HttpSession;

import beans.ObjetoBean;
import beans.Usuario;
import controlador.Controlador;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
/**
 * 
 * @author Alberto Macho
 * Esto es un controlador para la cosulta de los avisos del profesor.
 *
 */
public class ControladorOp_Avis_Prof extends Controlador{
/**
 * Con el idusuario que cogemos de la session buscamos los avisos de ese usuario
 * y metemos la lista resultante de avisos en la session.
 */
	public void procesarEvento() {
    
		ObjetoBean beanUsuario = new Usuario();
		HttpSession sesion = this.getSesion();
		//idusuario me tiene que decir Javi si es asi
		String idusu=(String)this.getSesion().getAttribute("idusuario");
		beanUsuario.cambiaValor(Constantes.ID_ISUSUARIO_DNI,idusu);
		//Profesorado GP = new Profesorado();
		GestorAvisos GA = new GestorAvisos();
		ListaObjetoBean lista= GA.consultaAvisos(beanUsuario);
		
		//la consulta se ha realizado correctamente.
		if (lista!=null)
		{
			this.setResuladooperacion("OK");
			sesion.setAttribute("listaaviso",lista);
			
		}
		// La consulta ha dado error
		else if (lista == null)
		{
			this.setResuladooperacion("ERROR");
		}
		
		
		
		
	}

	public Controlador clonar() {

		return new ControladorOp_Avis_Prof();
	}

}
