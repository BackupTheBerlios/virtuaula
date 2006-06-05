package beans.beanEncapsulado.encapsuladores;
import javax.servlet.http.HttpServletRequest;
import beans.beanEncapsulado.EncapsuladorCompuesto;
import beans.beanEncapsulado.encapsuladores.encapsuladorBean.EncapsuladorBean;
import beans.beanEncapsulado.encapsuladores.EncapsuladorString;
/**
 * Permite encapsular toda la informacion que viene de una pagina
 * de enviar aviso
 * @author Fco Javier P�rez Escriv�
 *
 */
public class EncapsuladorEnviaAviso extends EncapsuladorCompuesto{
	
	/**
	 * Constructor
	 * @param request Objeto contenedor de informacion de la pagina anterior
	 */
	public EncapsuladorEnviaAviso(HttpServletRequest request){
		super(request);
		
	}
	/**
	 * Inicializa la tabla que contiene todos los encapsuladores simples a ejecutar 
	 */
	protected void inicializarTabla(){
		this.tablaEncapsuladores.add(0,new EncapsuladorBean("Avisos",request));
		this.tablaEncapsuladores.add(1,new EncapsuladorString("claveaviso",request));
	}
	/**
	 * Realiza una encapsulaci�n compuesta
	 */
	public void encapsular(){
		super.encapsular();
		
	}
}
