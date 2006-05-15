package beans;

import subSistemaBBDD.utils.Constantes;

public  class Error extends ObjetoBean{
	
	private String CAUSA;
	
	public Error() {
		this.inicializar();
	}
	
	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public ObjetoBean clonar() {
		Error error = new Error();
		error.CAUSA = this.CAUSA;
		//error.inicializar();
		return error;
	}

	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public String dameValor(String campo) {
		String c="";
		if (campo.equals(Constantes.CAUSA))
		{
			c=CAUSA;
		}
		return c;
	}

	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void cambiaValor(String campo, String valor) {
		if (campo.equals(Constantes.CAUSA))
		{
			CAUSA=valor;
		}
		
	}

	/**
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void inicializar() {
		CAUSA = "";
	}

}

