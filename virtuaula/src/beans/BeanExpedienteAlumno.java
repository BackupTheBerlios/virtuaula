package beans;

import subSistemaBBDD.utils.Constantes;

public class BeanExpedienteAlumno extends ObjetoBean{
	
	private String ISUSUARIO_DNI;
	private String NOMBRE;
	private String APELLIDO1;
	private String APELLIDO2;
	private String TELEFONO;
	private String EMAIL;
	private String DIRECCION;
	private String FECH_NACIMIENTO;
	private String SEXO;
	private String NOTAFINAL;

	/**
	 * 
	 *Pone todos los atriburos de alumno a ""
	 *
	 */
	public BeanExpedienteAlumno()
	{
		this.inicializar();
	}
	/**
	 * @return ObjetoBean: Es un objeto que encapsula los datos y puede ser de varios tipos.
	 * 	Nos devuelve una copia de this
	 * La usaremos para hacer una copia o clon del atriburo prototipo 
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 * */
	public ObjetoBean clonar() {
		// TODO Auto-generated method stub
		BeanExpedienteAlumno a = new BeanExpedienteAlumno();
		a.NOMBRE=this.NOMBRE;
		a.ISUSUARIO_DNI=this.ISUSUARIO_DNI;
		a.APELLIDO1=this.APELLIDO1;
		a.APELLIDO2=this.APELLIDO2;
		a.DIRECCION=this.DIRECCION;
		a.TELEFONO=this.TELEFONO;
		a.EMAIL=this.EMAIL;
		a.FECH_NACIMIENTO=this.FECH_NACIMIENTO;
		a.SEXO=this.SEXO;
		a.NOTAFINAL=this.NOTAFINAL;
		return a;
		
	}
	
	
	/**
	 * @param campo Le pasamos  un String para saber el campo que queramos que nos devuelva
	 * @return Nos devuelve el valor del campo elegido
	 * Me devuelve el valor del atriburo  que le indique en 
	 * el parametro campo
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	
	public String dameValor(String campo) {
		
		String c="";
		
		if (campo.equals(Constantes.ID_ISALUMNO_ISUSUARIO_DNI))
		{
			c=ISUSUARIO_DNI;
		}
		else if (campo.equals(Constantes.ALUMNO_NOMBRE))
		{
			c=NOMBRE;
		}
		else if (campo.equals(Constantes.ALUMNO_APELLIDO1))
		{
			c=APELLIDO1;
		}
		else if (campo.equals(Constantes.ALUMNO_APELLIDO2))
		{
			c=APELLIDO2;
		}
		else if (campo.equals(Constantes.ALUMNO_TELEFONO))
		{
			c=TELEFONO;
		}
		else if (campo.equals(Constantes.ALUMNO_EMAIL))
		{
			c=EMAIL;
		}
		else if (campo.equals(Constantes.ALUMNO_DIRECCION))
		{
			c=DIRECCION;
		}
		else if (campo.equals(Constantes.ALUMNO_FECH_NACIMIENTO))
		{
			c=FECH_NACIMIENTO;
		}
		else if (campo.equals(Constantes.ALUMNO_SEXO))
		{
			c=SEXO;
		}
		else if (campo.equals(Constantes.EXPEDIENTECURSO_NOTAFINAL))
		{
			c=NOTAFINAL;
		}
		return c;
	}
    /**
     * 
     * @param campo Le pasamos el campo que queremos que nos cambie 
     * @param valor El valor nuevo
     * Introducimos un campo de la tupla que queremos cambiar y el valor que le
     * queremos asignar y nos lo cambia.
     * Mirar documentacion de la clase de la que hereda(ObjetoBean)
     * 
     */
	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
								
		if (campo.equals(Constantes.ID_ISALUMNO_ISUSUARIO_DNI))
		{
			ISUSUARIO_DNI=valor;
		}
		else if (campo.equals(Constantes.ALUMNO_NOMBRE))
		{
			NOMBRE=valor;
		}
		else if (campo.equals(Constantes.ALUMNO_APELLIDO1))
		{
			APELLIDO1=valor;
		}
		else if (campo.equals(Constantes.ALUMNO_APELLIDO2))
		{
			APELLIDO2=valor;
		}
		else if (campo.equals(Constantes.ALUMNO_TELEFONO))
		{
			TELEFONO=valor;
		}
		else if (campo.equals(Constantes.ALUMNO_EMAIL))
		{
			EMAIL=valor;
		}
		else if (campo.equals(Constantes.ALUMNO_DIRECCION))
		{
			DIRECCION=valor;
		}
		else if (campo.equals(Constantes.ALUMNO_FECH_NACIMIENTO))
		{
			FECH_NACIMIENTO=valor;
		}
		else if (campo.equals(Constantes.ALUMNO_SEXO))
		{
			SEXO=valor;
		}
		else if (campo.equals(Constantes.EXPEDIENTECURSO_NOTAFINAL))
		{
			NOTAFINAL=valor;
		}
		
		
	}

	/**
	 * Metodo que inicializa todos los atributos a la cadena vacia
	 * Mirar documentacion de la clase de la que hereda(ObjetoBean)
	 */
	public void inicializar() {
		// TODO Auto-generated method stub
		ISUSUARIO_DNI="";
		NOMBRE="";
		APELLIDO1="";
		APELLIDO2="";
		TELEFONO="";
		EMAIL="";
		DIRECCION="";
		FECH_NACIMIENTO="";
		SEXO="";
		NOTAFINAL="";
			
	}
		
	}


