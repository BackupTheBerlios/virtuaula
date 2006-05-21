package beans;

import subSistemaBBDD.utils.Constantes;

public class beanExpedienteAlumno extends ObjetoBean{
	
	private String IDISCURSO;
	private String ISPROFESOR_ISUSUARIO_DNI;
	private String ISAREA_IDISAREA;
	private String NOMBRE;
	private String NUMERO_PLAZAS;
	private String ESTADO;
	private String FECHA_INICIO;
	private String FECHA_FIN;
	private String PRECIO;
	private String NOTAFINAL;
	
	public beanExpedienteAlumno()
	{
		this.inicializar();
	}
	public ObjetoBean clonar() {
		// TODO Auto-generated method stub
		beanExpedienteAlumno expedienteAlumno = new beanExpedienteAlumno();
		expedienteAlumno.IDISCURSO=this.IDISCURSO;
		expedienteAlumno.ISPROFESOR_ISUSUARIO_DNI=this.ISPROFESOR_ISUSUARIO_DNI;
		expedienteAlumno.ISAREA_IDISAREA=this.ISAREA_IDISAREA;
		expedienteAlumno.NOMBRE=this.NOMBRE;
		expedienteAlumno.NUMERO_PLAZAS=this.NUMERO_PLAZAS;
		expedienteAlumno.ESTADO=this.ESTADO;
		expedienteAlumno.FECHA_INICIO=this.FECHA_INICIO;
		expedienteAlumno.FECHA_FIN=this.FECHA_FIN;
		expedienteAlumno.PRECIO=this.PRECIO;
		expedienteAlumno.NOTAFINAL=this.NOTAFINAL;
		//curso.inicializar();
		return expedienteAlumno;
	}

	public String dameValor(String campo) {
		String c="";
		if (campo.equals(Constantes.ID_ISCURSO_IDISCURSO))
		{
			c=IDISCURSO;
		}
		else if (campo.equals(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI))
		{
			c=ISPROFESOR_ISUSUARIO_DNI;
		}
		else if (campo.equals(Constantes.CURSO_ISAREA_IDISAREA))
		{
			c=ISAREA_IDISAREA;
		}
		else if (campo.equals(Constantes.CURSO_NOMBRE))
		{
			c=NOMBRE;
		}
		else if (campo.equals(Constantes.CURSO_NUMERO_PLAZAS))
		{
			c=NUMERO_PLAZAS;
		}
		else if (campo.equals(Constantes.CURSO_ESTADO))
		{
			c=ESTADO;
		}
		else if (campo.equals(Constantes.CURSO_FECHA_INICIO))
		{
			c=FECHA_INICIO;
		}
		else if (campo.equals(Constantes.CURSO_FECHA_FIN))
		{
			c=FECHA_FIN;
		}
		else if (campo.equals(Constantes.CURSO_PRECIO))
		{
			c=PRECIO;
		}
		else if (campo.equals(Constantes.EXPEDIENTEALUMNO_NOTAFINAL))
		{
			c=NOTAFINAL;
		}
		
		return c;
	}

	public void cambiaValor(String campo, String valor) {
		// TODO Auto-generated method stub
		if (campo.equals(Constantes.ID_ISCURSO_IDISCURSO))
		{
			IDISCURSO=valor;
		}
		else if (campo.equals(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI))
		{
			ISPROFESOR_ISUSUARIO_DNI=valor;
		}
		else if (campo.equals(Constantes.CURSO_ISAREA_IDISAREA))
		{
			ISAREA_IDISAREA=valor;
		}
		else if (campo.equals(Constantes.CURSO_NOMBRE))
		{
			NOMBRE=valor;
		}
		else if (campo.equals(Constantes.CURSO_NUMERO_PLAZAS))
		{
			NUMERO_PLAZAS=valor;
		}
		else if (campo.equals(Constantes.CURSO_ESTADO))
		{
			ESTADO=valor;
		}
		else if (campo.equals(Constantes.CURSO_FECHA_INICIO))
		{
			FECHA_INICIO=valor;
		}
		else if (campo.equals(Constantes.CURSO_FECHA_FIN))
		{
			FECHA_FIN=valor;
		}
		else if (campo.equals(Constantes.CURSO_PRECIO))
		{
			PRECIO=valor;
		}
		else if (campo.equals(Constantes.EXPEDIENTEALUMNO_NOTAFINAL))
		{
			NOTAFINAL=valor;
		}
		
	}

	public void inicializar() {
		
			IDISCURSO="";
			ISPROFESOR_ISUSUARIO_DNI="";
			ISAREA_IDISAREA="";
			NOMBRE="";
			NUMERO_PLAZAS="";
			ESTADO="";
			FECHA_INICIO="";
			FECHA_FIN="";
			PRECIO="";
			NOTAFINAL="";
			
		}
		
	}


