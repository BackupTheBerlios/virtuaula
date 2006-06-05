package beans.beanEncapsulado.encapsuladores;


import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.ObjetoBean;
import beans.beanEncapsulado.Encapsulador;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * Mete en sesion un ObjetoBean que tiene un valor clave y en una lista especificados ambos
 * @author Fco Javier Pérez Escrivá
 *
 */
public class EncapsuladorClaveBean extends Encapsulador{

	private Hashtable tablaIdListas;
	private Hashtable tablaIdBeans;
	private Hashtable tablaIdClaveBase;
	/**
	 * Constructor
	 * @param tipo clase de enscapsulacion claveBean se desea ejecutar
	 * @param request objeto contenedor de la informacion de la pagina anterior
	 */
	public EncapsuladorClaveBean(String tipo,HttpServletRequest request){
		super(tipo,request);
		this.tablaIdListas=new Hashtable();
		this.tablaIdBeans=new Hashtable();
		this.tablaIdClaveBase=new Hashtable();
		this.inicializarTablaIdListas();
		this.inicializarTablaIdBeans();
		this.inicializarTablaIdClaveBase();
	}
	
	
	/**
	 * Asocia cada tipo de clave, con la lista que de la que se va a recoger 
	 *
	 */
	private void inicializarTablaIdListas(){
		tablaIdListas.put("ISPROFESOR_ISUSUARIO_DNI","listaprofesor");
		tablaIdListas.put("ISAREA_IDISAREA","listaarea");
		tablaIdListas.put("ISCURSO_IDISCURSO","listacurso");
		
	}
	/**
	 * Tabla de los identificadores con los que queremos introducir en la
	 * sesion de los beans que tienen las claves indicadas
	 *
	 */
	private void inicializarTablaIdBeans(){
		tablaIdBeans.put("ISPROFESOR_ISUSUARIO_DNI","beanProfesor");
		tablaIdBeans.put("ISAREA_IDISAREA","beanArea");
		tablaIdBeans.put("ISCURSO_IDISCURSO","beanCurso");
	}
	/**
	 *	Tabla de correspondencia de la clave, con el identificador clave
	 *	de la tabla base
	 *
	 */
	private void inicializarTablaIdClaveBase(){
		tablaIdClaveBase.put("ISPROFESOR_ISUSUARIO_DNI","ISUSUARIO_DNI");
		tablaIdClaveBase.put("ISAREA_IDISAREA","IDISAREA");
		tablaIdClaveBase.put("ISCURSO_IDISCURSO","IDISCURSO");
	}
	/**
	 * Realiza la accion de encapsular y de insercion en la sesion
	 */
	public void encapsular(){
		HttpSession sesion=request.getSession();
		ListaObjetoBean lx;
		ObjetoBean obj;
		if (!request.getParameter(tipo).equals("")){
			//cogemos el valor de la clave
			String s = request.getParameter(tipo);
			//cogemos la lista
			lx = (ListaObjetoBean) sesion.getAttribute((String)this.tablaIdListas.get(tipo));
			obj = null;
			//recorremos la lista en busca del objeto que tenga la clave igual
			for (int j =0; j<lx.tamanio(); j++){
				obj = lx.dameObjeto(j);
				if(s.equals(obj.dameValor((String)this.tablaIdClaveBase.get(tipo)))){
					//lo introducimos en la sesión con el identificador especificado
					sesion.setAttribute((String)this.tablaIdBeans.get(tipo),obj);
				}
			}	
		}
		else{
			//si no esta especificada la clave no metemos nada en sesión
			obj = null;
			sesion.setAttribute((String)this.tablaIdBeans.get(tipo),obj);
		}
			
			
		
	}
}
