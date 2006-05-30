package beans.beanEncapsulado;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import beans.beanEncapsulado.encapsuladores.EncapsuladorPosicionBean;
import beans.beanEncapsulado.encapsuladores.EncapsuladorConsultaCurso;
import beans.beanEncapsulado.encapsuladores.EncapsuladorInsertarProfesor;
import beans.beanEncapsulado.encapsuladores.EncapsuladorListas;
import beans.beanEncapsulado.encapsuladores.EncapsuladorVacio;
import beans.beanEncapsulado.encapsuladores.EncapsuladorConsultaAlumno;
import beans.beanEncapsulado.encapsuladores.encapsuladorBean.EncapsuladorBean;
import beans.beanEncapsulado.encapsuladores.*;

import java.util.Hashtable;
/**
 * Proporciona el encapsulador adecuado
 * @author Fco Javier Pérez Escrivá
 *
 */
public class GestorEncapsuladores {
	private Hashtable tablaEncapsuladores;
	
	public GestorEncapsuladores(){
		tablaEncapsuladores=new Hashtable();
	}
	public Encapsulador dameEncapsulador(HttpServletRequest req){
		String tipo = "";
		Encapsulador encapResultado=null;
		
		try {
			tipo = req.getParameter("idBean");
			if ((tipo != null)&& (!tipo.equals(""))){
				this.inicializar(req);
				encapResultado=(Encapsulador)tablaEncapsuladores.get(tipo);
			}
			else{
				encapResultado=new EncapsuladorVacio();
			}
			if(encapResultado==null)
				throw new Exception();
		}
		catch (Exception e){
			System.out.println("Ha habido un fallo proporcionando el encapsulador");
			e.printStackTrace();
			encapResultado=new EncapsuladorVacio();
		}
		return encapResultado;
	}
	
	public void inicializar(HttpServletRequest req){
		tablaEncapsuladores.put("listCurso",new EncapsuladorListas("listCurso",req));
		tablaEncapsuladores.put("listAviso",new EncapsuladorListas("listAviso",req));
		tablaEncapsuladores.put("listAula",new EncapsuladorListas("listAula",req));
		tablaEncapsuladores.put("listHor",new EncapsuladorListas("listHor",req));
		tablaEncapsuladores.put("listArea",new EncapsuladorListas("listArea",req));
		tablaEncapsuladores.put("listAlumno",new EncapsuladorListas("listAlumno",req));
		tablaEncapsuladores.put("listProf",new EncapsuladorListas("listProf",req));
		tablaEncapsuladores.put("insertarProfesor",new EncapsuladorInsertarProfesor(req));
		tablaEncapsuladores.put("consultaCurso",new EncapsuladorConsultaCurso(req));
		tablaEncapsuladores.put("consultarAlumno",new EncapsuladorConsultaAlumno(req));
		tablaEncapsuladores.put("posAlumno",new EncapsuladorPosicionBean("posAlumno",req));
		tablaEncapsuladores.put("Alumno",new EncapsuladorBean("Alumno",req));
		tablaEncapsuladores.put("Area",new EncapsuladorBean("Area",req));
		tablaEncapsuladores.put("Aula",new EncapsuladorBean("Aula",req));
		tablaEncapsuladores.put("Avisos",new EncapsuladorBean("Avisos",req));
		tablaEncapsuladores.put("Avisos_Has_Usuario",new EncapsuladorBean("Avisos_Has_Usuario",req));
		tablaEncapsuladores.put("Contrato",new EncapsuladorBean("Contrato",req));
		tablaEncapsuladores.put("Curso",new EncapsuladorBean("Curso",req));
		tablaEncapsuladores.put("Curso_Has_Alumno",new EncapsuladorBean("Curso_Has_Alumno",req));
		tablaEncapsuladores.put("Horario",new EncapsuladorBean("Horario",req));
		tablaEncapsuladores.put("Horario_Has_Aula",new EncapsuladorBean("Horario_Has_Aula",req));
		tablaEncapsuladores.put("Nomina",new EncapsuladorBean("Nomina",req));
		tablaEncapsuladores.put("Profesor",new EncapsuladorBean("Profesor",req));
		tablaEncapsuladores.put("Usuario",new EncapsuladorBean("Usuario",req));
		tablaEncapsuladores.put("vacio",new EncapsuladorVacio());
		tablaEncapsuladores.put("Ficha",new EncapsuladorBean("Ficha",req));
		tablaEncapsuladores.put("Error",new EncapsuladorBean("Error",req));
		tablaEncapsuladores.put("enviaaviso",new EncapsuladorEnviaAviso(req));
		

		
	}
	
}
