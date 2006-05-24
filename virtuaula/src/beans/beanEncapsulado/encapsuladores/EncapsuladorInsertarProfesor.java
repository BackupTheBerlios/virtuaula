package beans.beanEncapsulado.encapsuladores;


import javax.servlet.http.HttpServletRequest;

import beans.beanEncapsulado.EncapsuladorCompuesto;
import beans.beanEncapsulado.encapsuladores.encapsuladorBean.EncapsuladorBean;


public class EncapsuladorInsertarProfesor  extends EncapsuladorCompuesto{
	
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
	public void encapsular(){
		super.encapsular();
		
	}
}