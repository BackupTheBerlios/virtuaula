package beans.beanEncapsulado.encapsuladores;

import javax.servlet.http.HttpServletRequest;

import beans.beanEncapsulado.EncapsuladorCompuesto;
import beans.beanEncapsulado.encapsuladores.encapsuladorBean.EncapsuladorBean;

public class EncapsuladorConsultaCurso extends EncapsuladorCompuesto{

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
	public void encapsular(){
		super.encapsular();
		
	}
}
