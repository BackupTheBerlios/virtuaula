package beans.beanEncapsulado;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 * Realiza una encapsulaci�n compuesta de encapsulados sencillos
 * @author Fco Javier P�rez Escriv�
 *
 */
abstract public class EncapsuladorCompuesto extends Encapsulador{
	
	protected ArrayList tablaEncapsuladores;
	
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
	
	public void encapsular(){
		for (int i=0; i<tablaEncapsuladores.size();i++)
			((Encapsulador)tablaEncapsuladores.get(i)).encapsular();
	
	}
}
