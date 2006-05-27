package beans.beanEncapsulado.encapsuladores;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.ObjetoBean;
import beans.beanEncapsulado.Encapsulador;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * Encapsula en un objetoBean el contenido de una lista de objetosBean
 * de la posici�n especificada
 * especificada
 * @author Fco Javier P�rez Escriv�
 *
 */
public class EncapsuladorPosicionBean extends Encapsulador {
	
	private Hashtable tablaIdListas;
	private Hashtable tablaIdBeans;
	/**
	 * Constructor
	 * @param tipo
	 */
	public EncapsuladorPosicionBean(String tipo,HttpServletRequest request){
		super(tipo,request);
		tablaIdListas=new Hashtable();
		tablaIdBeans=new Hashtable();
		this.inicializarTablaIdListas();
		this.inicializarTablaIdBeans();
		
	}
	/**
	 * Asocia cada tipo de pos, con la lista que ese espera recoger esa posici�n
	 *
	 */
	private void inicializarTablaIdListas(){
		tablaIdListas.put("posAula","listaaula");
		tablaIdListas.put("posHor","listahorario");
		tablaIdListas.put("posCurso","listacurso");
		
		
	}
	/**
	 * Tabla de los identificadores con los que queremos introducir en la
	 * sesion de los beans que estan en las posiciones indicadas
	 *
	 */
	private void inicializarTablaIdBeans(){
		tablaIdBeans.put("posAula","beanAula");
		tablaIdBeans.put("posHor","beanHorario");
		tablaIdBeans.put("posCurso","beanCurso");
		
	}
	
	/**
	 * Recolecta y mete en sesi�n el bean (con identificador especificado en la tablaIdBean)
	 * de la posici�n que esta en sesion (especificada en el tipo) de la lista que esta
	 * en sesi�n (especificada en la tablaIdListas), si no est� especificada la posici�n no 
	 * mete nada en sesi�n
	 */
	public void encapsular(){
		HttpSession sesion=request.getSession();
		ListaObjetoBean lx;
		ObjetoBean obj;
		if (!request.getParameter(tipo).equals("")){
			int pos = Integer.parseInt(request.getParameter(tipo));
			lx = (ListaObjetoBean) sesion.getAttribute((String)tablaIdListas.get(tipo));
			obj = lx.dameObjeto(pos);
			sesion.setAttribute((String)tablaIdBeans.get(tipo),obj);
		}
		else{
			obj = null;
			sesion.setAttribute((String)tablaIdBeans.get(tipo),obj);
		}
	
	}
}
