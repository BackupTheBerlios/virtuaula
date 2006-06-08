package subSistemaControlador.controlador.ControladorSecretaria.controlMatricular;

import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.Constantes;
import subSistemaControlador.controlador.Controlador;
import gestores.GestorAlumnos;

/**
 * 
 * @author Alberto Macho 
 * Controla el paso de una pagina a otra.
 * cogera el curso metido en la session y consultara la clase, el profesor, 
 * el horario y el precio de ese curso y lo metera en la session para mostrarlo 
 * en la siguiente pagina.
 */
public class ControladorMatAlumCur extends ControladorMatricular {
/**
 * 
 * metodo que nos modifica el resultado operacion para saber cual sera
 * la pagina de destino dependiendo del resultado de las operaciones.
 * Este metodo cogerá el curso metido en la session y consultara la clase, el profesor,
 * el horario y el precio de ese curso y lo metera en la sesion para mostrarlo 
 * en la siguiente pagina.
 */
	public void procesarEvento() {
	
	GestorAlumnos GA = new GestorAlumnos();	
	CreadorBean creador = new CreadorBean();	
	Integer posc = (Integer)this.getSesion().getAttribute("posCurso");
	int poscurso = posc.intValue();
	
	//si el curso elegido es valido
	if (poscurso!=-1)
	{
		ListaObjetoBean listacur = (ListaObjetoBean)this.getSesion().getAttribute("listacurso");
		ObjetoBean curso=listacur.dameObjeto(poscurso);
		ObjetoBean aula=GA.consultaAulaCurso(curso);
		ObjetoBean horario=GA.consultaHorarioCurso(curso);
		ObjetoBean profesor=GA.consultaProfesorCurso(curso);
			//no se produce un error en la base de datos.
			if ((aula!=null) && (horario!=null) && (profesor!=null))
			{
				//generamos una contrasña y la metemos en session si el alumno no existe
				ObjetoBean alum=(ObjetoBean)this.getSesion().getAttribute("beanAlumno");
				if (!GA.existeAlumno(alum))
				{
					//creo contraseña y para el usuario y este lo meto en sesion
				int pass=GA.generaContrasenia();
				Integer p=new Integer(pass);
				String password =p.toString();
				ObjetoBean usuar=creador.crear(creador.Usuario);
				String dni=alum.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI);
				usuar.cambiaValor(Constantes.ID_ISUSUARIO_DNI,dni);
				usuar.cambiaValor(Constantes.USUARIO_CONTRASENIA,password);
				usuar.cambiaValor(Constantes.USUARIO_PERFIL,"alumno");
				this.getSesion().setAttribute("usuario",usuar);
				}
				
				this.setResuladooperacion("OK");
				this.getSesion().removeAttribute("error");
				this.getSesion().setAttribute("beanAula",aula);
				this.getSesion().setAttribute("beanHorario",horario);
				this.getSesion().setAttribute("beanProfesor",profesor);
				this.getSesion().setAttribute("beanCurso",curso);
			}
			//se ha producido un error en la base de datos
			else if ((aula==null) || (horario==null) || (profesor==null))
			{
				this.setResuladooperacion("ERROR");
				ObjetoBean err= creador.crear(creador.Error);
				err.cambiaValor(Constantes.CAUSA,"Se ha producido un error en la base de datos al consultar");
				ListaObjetoBean listae = new ListaObjetoBean();
				listae.insertar(0,err);
				this.getSesion().setAttribute("error",listae);
			}
	}
	//si el curso escogido no es valido, es decir, es -1, debe elegir un curso valido y volver a la pag anteriop
	//mostrando el error.
	else if (poscurso==-1)
	{
		ObjetoBean error = creador.crear(creador.Error);
		error.cambiaValor(Constantes.CAUSA,"Debe elegir un curso valido");
		ListaObjetoBean listaer = new ListaObjetoBean();
		listaer.insertar(0,error);
		this.getSesion().setAttribute("error",listaer);
		this.setResuladooperacion("ERROR");
		
		
	}
	}
/**
 * @return nos devuelve un controlador de esta clase
 */
	public Controlador clonar() {
		return new ControladorMatAlumCur();
	}

}
