/**
 * 
 */
package gestorPaginas;

import java.util.HashMap;


public class GestorPaginas {

	private HashMap mapSecretaria;
	private HashMap mapProfesor;
	private HashMap mapPublico;
	private HashMap mapContable;
	
	/**
	 * Inicializa los atributos de la clase
	 *
	 */
	public GestorPaginas() {
		mapSecretaria = new HashMap ();
		mapProfesor = new HashMap ();
		mapPublico = new HashMap ();
		mapContable = new HashMap ();
	}
	
	
	/**
	 * Retorna la ruta que dependiendo de los parametros introducidos tiene que ir el control.
	 * 
	 * @param tipoUsuario Rol de usuario validado en el sistema
	 * @param operacion Operacion pulsada en el JSP.
	 * @param operacionResultado Resultado de la operacion.
	 * @return Pagina siguiente que se tiene que mostrar.
	 */
	public String damePaginaSig (String tipoUsuario, String operacion, String operacionResultado) {
	
		String paginaSig = "";		
		if (tipoUsuario.equals("secretaria")) {
			paginaSig = (String) this.mapSecretaria.get(operacion.concat(operacionResultado));
		}
		
		if (tipoUsuario.equals("profesor")) {
			paginaSig = (String) this.mapProfesor.get(operacion.concat(operacionResultado));
		}
		
		if (tipoUsuario.equals("publico")) {
			paginaSig = (String) this.mapPublico.get(operacion.concat(operacionResultado));
		}
		
		if (tipoUsuario.equals("contable")) {
			paginaSig = (String) this.mapContable.get(operacion.concat(operacionResultado));
		}
		
		return paginaSig;
		
	}
	
	
	
	/**
	 * Añade una pagina al gestor.
	 * 
	 * @param tipoUsuario Rol de usuario validado en el sistema.
	 * @param operacion Operacion pulsada en el JSP.
	 * @param operacionResultado Resultado de la operación.
	 * @param paginaSig Pagina siguiente que tendrá que mostrar
	 */
	public void agregarPaginas (String tipoUsuario, String operacion, String operacionResultado, String paginaSig) {
		
		if (tipoUsuario.equals("secretaria")) {
			this.mapSecretaria.put(operacion.concat(operacionResultado), paginaSig);
		}
		
		if (tipoUsuario.equals("profesor")) {
			this.mapProfesor.put(operacion.concat(operacionResultado), paginaSig);
		}
		
		if (tipoUsuario.equals("publico")) {
			this.mapPublico.put(operacion.concat(operacionResultado), paginaSig);
		}
		
		if (tipoUsuario.equals("contable")) {
			this.mapContable.put(operacion.concat(operacionResultado), paginaSig);
		}
	}
}
