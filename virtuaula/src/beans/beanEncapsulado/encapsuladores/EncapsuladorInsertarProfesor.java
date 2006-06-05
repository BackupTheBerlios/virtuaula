package beans.beanEncapsulado.encapsuladores;


import javax.servlet.http.HttpServletRequest;

import beans.beanEncapsulado.EncapsuladorCompuesto;
import beans.beanEncapsulado.encapsuladores.encapsuladorBean.EncapsuladorBean;

/**
 * Realiza la encapsulacion necesaria desde el formulario de la insercion de un profesor
 * @author Fco Javier P�rez Escriv�
 *
 */
public class EncapsuladorInsertarProfesor  extends EncapsuladorCompuesto{
	/**
	 * Constructor
	 * @param request Objeto de contencion de informacion
	 */
	public EncapsuladorInsertarProfesor(HttpServletRequest request){
		super(request);
		
	}
	/**
	 * Inicializa la lista de encapuladores necesarios para insertar un profesor
	 *
	 */
	protected void inicializarTabla(){
		tablaEncapsuladores.add(0,new EncapsuladorBean("Nomina",request));
		tablaEncapsuladores.add(1,new EncapsuladorBean("Profesor",request));
		tablaEncapsuladores.add(2,new EncapsuladorBean("Contrato",request));
				
	}
	/**
	 * Realiza una encapsulacion compuesta
	 */
	public void encapsular(){
		super.encapsular();
		
	}
}