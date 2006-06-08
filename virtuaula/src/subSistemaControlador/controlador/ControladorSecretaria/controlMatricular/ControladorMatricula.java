package subSistemaControlador.controlador.ControladorSecretaria.controlMatricular;


import gestores.GestorAlumnos;
import sms.SMS;
import beans.ObjetoBean;

import subSistemaControlador.controlador.Controlador;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.*;
/**
 * 
 * @author Alberto Macho
 *Controla el paso concreto de una pagina a otra en la que se realiza realmetne la
 *matriculacion de un alumno. Dependiendo del exito el resultado de la 
 *operacion sera uno u otro.
 */
public class ControladorMatricula extends ControladorMatricular{
	/**
	 * metodo que nos modifica el resultado operacion para saber cual sera
	 * la pagina de destino dependiendo del resultado de las operaciones.
	 * Ademas realiza la matriculación de un alumno con el gestor de Alumnos.
	 * Tambien se le manda un sms al alumno con sus datos de su cuenta para entrar al sistema.
	 */
	public void procesarEvento() {
		
		ObjetoBean alumno=(ObjetoBean)this.getSesion().getAttribute("beanAlumno");
		ObjetoBean curso = (ObjetoBean)this.getSesion().getAttribute("beanCurso");
		GestorAlumnos GA = new GestorAlumnos();
		//CreadorBean creador = new CreadorBean();
		ObjetoBean usuario = (ObjetoBean)this.getSesion().getAttribute("usuario");
		//System.out.println(curso.dameValor(Constantes.CURSO_NOMBRE));
		
		ListaObjetoBean listaerror=GA.marticularAlumno(alumno,curso,usuario);
		//si los datos introducidos son correctos
		
		if (listaerror.esVacio())
		{
			
			this.setResuladooperacion("OK");
			//metemos en sesion el usuario para que en la sig pagina muestre el usuario
			//y la contraseña.
			this.getSesion().setAttribute("usuario",usuario);
			SMS sms= new SMS();
			String mensaje=" Bienvenido a virtuAula "+ alumno.dameValor(Constantes.ALUMNO_NOMBRE) +" Tu login es:"+
			usuario.dameValor(Constantes.ID_ISUSUARIO_DNI)+ " Tu contraseña es:" +usuario.dameValor(Constantes.USUARIO_CONTRASENIA);
			String numero= alumno.dameValor(Constantes.ALUMNO_TELEFONO);
			sms.envia(numero,mensaje);
			
			//borramos la listaeror porque ya lo hacemos correctamente.
			this.getSesion().removeAttribute("error");
		}
		//si los datos introducidos no son correctos
		else if (!listaerror.esVacio())
		{
			this.setResuladooperacion("ERROR");
			this.getSesion().setAttribute("error",listaerror);
		}
		
		}
		
		
		
	
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		return new ControladorMatricula();
	}

}
