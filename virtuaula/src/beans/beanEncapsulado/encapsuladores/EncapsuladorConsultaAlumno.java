package beans.beanEncapsulado.encapsuladores;
import javax.servlet.http.HttpServletRequest;
import beans.beanEncapsulado.EncapsuladorCompuesto;
import beans.beanEncapsulado.encapsuladores.EncapsuladorClaveBean;
import beans.beanEncapsulado.encapsuladores.encapsuladorBean.EncapsuladorBean;

/**
 * Encapsula los datos desde el formulario de consula Alumno
 * @author JORGE SANCHEZ
 *
 */
public class EncapsuladorConsultaAlumno extends EncapsuladorCompuesto {
	/**
	 * Constructor
	 * @param request Objeto contenedor de la informacion de la pagina anterior
	 */
	public EncapsuladorConsultaAlumno(HttpServletRequest request){
		super(request);
	}
	/**
	 * Inicializa la lista de encapuladores necesarios para consultar un alumno
	 *
	 */
	protected void inicializarTabla(){
		
		tablaEncapsuladores.add(0,new EncapsuladorBean("Alumno",request));
		tablaEncapsuladores.add(1,new EncapsuladorClaveBean("ISCURSO_IDISCURSO",request));
		
	
		
	}
	/**
	 * Realiza una encapsulación compuesta
	 */
	public void encapsular(){
		super.encapsular();
		
	}
}

