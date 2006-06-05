package beans.beanEncapsulado;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 * Realiza una encapsulación compuesta de encapsulados sencillos
 * @author Fco Javier Pérez Escrivá
 *
 */
abstract public class EncapsuladorCompuesto extends Encapsulador{
	
	protected ArrayList tablaEncapsuladores;
	/**
	 * Constructor
	 * @param request Objeto que contiene la informacion de la pagina web anterior
	 */
	public EncapsuladorCompuesto (HttpServletRequest request){
		super("",request);
		tablaEncapsuladores=new ArrayList();
		this.inicializarTabla();
		
	}
	/**
	 * Lista de encapsulados simples
	 *
	 */
	abstract protected void inicializarTabla();
	/**
	 * Realiza una encapsulacion compuesta
	 */
	public void encapsular(){
		for (int i=0; i<tablaEncapsuladores.size();i++)
			((Encapsulador)tablaEncapsuladores.get(i)).encapsular();
	
	}
}
