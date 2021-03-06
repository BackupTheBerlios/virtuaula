package beans.beanEncapsulado.encapsuladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.beanEncapsulado.Encapsulador;

import java.util.Hashtable;

/**
 * Encapsula en un Integer con un nombre determinado en la sesion dependiendo de la lista que sea (tipo) y lo mete
 * en la sesi�n
 * @author Fco Javier P�rez Escriv� y Diego Cardiel Freire
 *
 */
public class EncapsuladorListas extends Encapsulador{
	static private Hashtable tablaIdentificadores;
	public EncapsuladorListas(String tipo,HttpServletRequest request){
		super(tipo,request);
		tablaIdentificadores=new Hashtable();
		this.inicializarTabla();
		
	}
	/**
	 * Inializa los tipos de listas posibles y su correspondencia con el indentificador introducido
	 *
	 */
	private void inicializarTabla(){
		tablaIdentificadores.put("listProf","posProf");
		tablaIdentificadores.put("listAlumno","posAlumno");
		tablaIdentificadores.put("listArea","posArea");
		tablaIdentificadores.put("listHor","posHor");
		tablaIdentificadores.put("listAula","posAula");
		tablaIdentificadores.put("listAviso","posAviso");
		tablaIdentificadores.put("listCurso","posCurso");
		
	}
	/**
	 * Realiza la accion de Encapsular y meter en sesion
	 */
	public void encapsular(){
		HttpSession sesion=request.getSession();
		if (!request.getParameter((String)tablaIdentificadores.get(this.tipo)).equals("")){
			int pos = Integer.parseInt(request.getParameter((String)tablaIdentificadores.get(this.tipo)));
			sesion.setAttribute((String)tablaIdentificadores.get(this.tipo), new Integer(pos));
		}
		
	}
}