package subSistemaControlador.controlador.ControladorRecHumanos.controlInsertarProfesor;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorRecHumanos.ControladorRecHumanos;
import gestores.Profesorado;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * 
 * @author Alberto Macho
 *Controlador que controla la navegacion entre dos paginas de
 *insertar un profesor y que realiza la accion de insertar profesor
 */
public class ControladorInsProf extends ControladorRecHumanos{
/**
 * Procesa la informacion necesaria de la sesion y realiza
 * la insercion del profesor usando el profesorado, dependiende del resultado, 
 * pondra en el resultadooperacion OK o ERROR para indicar a la pagina que tiene
 * que ir.
 */
	public void procesarEvento() {
		
		//Comprobar que los datos sean correctos y insertar el profesor
		//Primero cogo de la sesion todo lo que necesito
		CreadorBean creador = new CreadorBean();
		
		Profesorado profesorado = new Profesorado();
		ObjetoBean profesor=(ObjetoBean)this.getSesion().getAttribute("beanProfesor");
		ObjetoBean Nomina = (ObjetoBean)this.getSesion().getAttribute("beanNomina");
		ObjetoBean Contrato= (ObjetoBean)this.getSesion().getAttribute("beanContrato");
		//genero la contraseña
		int pass=profesorado.generaContrasenia();
		Integer p=new Integer(pass);
		String password =p.toString();
		ObjetoBean usuar=creador.crear(creador.Usuario);
		String dni=profesor.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI);
		usuar.cambiaValor(Constantes.ID_ISUSUARIO_DNI,dni);
		usuar.cambiaValor(Constantes.USUARIO_CONTRASENIA,password);
		usuar.cambiaValor(Constantes.USUARIO_PERFIL,"profesor");
		this.getSesion().setAttribute("usuario",usuar);
		
		ListaObjetoBean listaerrores= profesorado.contratarProfesor(profesor,usuar,Nomina,Contrato);
		
		if (listaerrores.esVacio())
		{//si hay errores
			this.setResuladooperacion("OK");
			this.getSesion().removeAttribute("error");
			
		}
		if (!listaerrores.esVacio())
		{//hay errores
			this.setResuladooperacion("ERROR");
			this.getSesion().setAttribute("error",listaerrores);
		}
		
		
	}
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		
		return new ControladorInsProf();
	}

}
