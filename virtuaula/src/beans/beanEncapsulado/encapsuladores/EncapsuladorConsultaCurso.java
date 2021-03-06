package beans.beanEncapsulado.encapsuladores;

import javax.servlet.http.HttpServletRequest;

import beans.beanEncapsulado.EncapsuladorCompuesto;
import beans.beanEncapsulado.encapsuladores.encapsuladorBean.EncapsuladorBean;
/**
 * Encapsula los datos del formulario de consultar curso
 * @author Fco Javier P�rez Escriv�
 *
 */
public class EncapsuladorConsultaCurso extends EncapsuladorCompuesto{
	/**
	 * Constructor
	 * @param request Objeto que contiene tod al informcion de la pagina anterior
	 */
	public EncapsuladorConsultaCurso(HttpServletRequest request){
		super(request);
	}
	/**
	 * Inicializa la lista de encapuladores necesarios para insertar un profesor
	 *
	 */
	protected void inicializarTabla(){
		tablaEncapsuladores.add(0,new EncapsuladorClaveBean("ISAREA_IDISAREA",request));
		tablaEncapsuladores.add(1,new EncapsuladorClaveBean("ISPROFESOR_ISUSUARIO_DNI",request));
		tablaEncapsuladores.add(2,new EncapsuladorPosicionBean("posAula",request));
		tablaEncapsuladores.add(3,new EncapsuladorPosicionBean("posHor",request));
		tablaEncapsuladores.add(4,new EncapsuladorBean("Curso",request));
	}
	/**
	 * Realiza una encapsulacion compuesta
	 */
	public void encapsular(){
		super.encapsular();
		
	}
}
