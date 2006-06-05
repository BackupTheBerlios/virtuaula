package beans.beanEncapsulado.encapsuladores;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import beans.beanEncapsulado.Encapsulador;

/**
 * Encapsula un parametro especificado en un String y lo mete en la sesión
 * @author Fco Javier Pérez Escrivá
 *
 */
public class EncapsuladorString extends Encapsulador{
	/**
	 * Relacion entre el nombre del parametro q contiene la cadena y el nombre que
	 * quieres tener el objeto String en la sesion
	 */
	private Hashtable tablaIdString;
	/**
	 * Constructor
	 * @param tipo
	 */
	public EncapsuladorString(String tipo,HttpServletRequest request){
		super(tipo,request);
		tablaIdString=new Hashtable();
		this.inicializarTablaIdListas();
		
		
	}
	/**
	 * Inicializa la tabla que relaciona el nombre del parametro con el nombre que se quiere meter en la sesion
	 *
	 */
	private void inicializarTablaIdListas(){
		this.tablaIdString.put("claveaviso","claveaviso");
		
	}
	/**
	 * Accion de encapsular y meter en sesion
	 */
	public void encapsular (){
		HttpSession sesion=request.getSession();
		String cadena = request.getParameter(tipo);
		String nombreAtribSesion=(String)this.tablaIdString.get(tipo);
		sesion.setAttribute(nombreAtribSesion,cadena);
	}
}
