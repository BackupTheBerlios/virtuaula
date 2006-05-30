package gestores;

import java.util.Random;

import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.BBDDFachadaCurso;
import subSistemaBBDD.BBDDFachadaProfesor;
import subSistemaBBDD.utils.Constantes;
import beans.CreadorBean;
import beans.Error;
import beans.Ficha;
import beans.ObjetoBean;
import beans.Profesor;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * 
 * @author Alberto Macho
 *
 */
public class Profesorado {
	
	public Profesorado() {
		super();
	}
	/**
	 * Consulta todos los profesores
	 * @return
	 */
	public ListaObjetoBean consultaProfesores() {	
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean cBean = new CreadorBean();
		Profesor profesor = (Profesor) cBean.crear(11);
		ListaObjetoBean l = bdf.consultar(profesor);
		return l;
	}
	/**
	 * Consulta todos los profesores que esten libres en un horario
	 * @param beanHorario
	 * @return
	 */
	public ListaObjetoBean consultaProfesoresPorHorario (ObjetoBean beanHorario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaProfesor bdfp= (BBDDFachadaProfesor) (bdf.dameBBDDFachada(Constantes.FachadaProfesor));
		ListaObjetoBean l = bdfp.dameProfesoresLibres(beanHorario);	
		return l;
	}
	/**
	 * Consulta todas las areas
	 * @return
	 */
	public ListaObjetoBean consultaAreas() {
		GestorAreas ga = new GestorAreas();
		return ga.consultaAreas();
	}
	/**
	 * Consulta de un area por un objeto bean area
	 * @param bean
	 * @return
	 */
	public ListaObjetoBean consultaArea(ObjetoBean bean)
	{
		GestorAreas ga = new GestorAreas();
		return ga.consultaArea(bean);
	}
	/**
	 * Consulta un profesor con las caracteristicas de un bean profesor que
	 * le pasamos por parametro
	 * @param beanProfesor
	 * @return
	 */
	public ListaObjetoBean consultaProfesor(ObjetoBean beanProfesor) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.consultar(beanProfesor);
		return l;
	}
	
	/**
	 * Consulta los cursos de un profesor en concreto
	 * @param beanProfesor
	 * @return
	 */
	public ListaObjetoBean consultaCursosProfesor(ObjetoBean beanProfesor) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaCurso bdfc= (BBDDFachadaCurso) (bdf.dameBBDDFachada(Constantes.FachadaCurso));
		ListaObjetoBean l = bdfc.dameCursosProfesor(beanProfesor);
		return l;
	}
	/**
	 * Consulta la ficha de un alumno, nos devuelve una ficha
	 * @param beanAlumno
	 * @param beanCurso
	 * @return
	 */
	public Ficha consultaFichaDeAlumno(ObjetoBean beanAlumno, ObjetoBean beanCurso) {
		GestorFichas gf = new GestorFichas();
		return (Ficha) gf.consultaFichaDeAlumno(beanAlumno, beanCurso);
	}
	/**
	 * Realizamos modificaciones sobre una ficha con las caracteristicas de beanFicha
	 * @param beanFicha
	 * @return
	 */
	public ListaObjetoBean editarFicha(ObjetoBean beanFicha){
		GestorFichas gf = new GestorFichas();
		return gf.editarFicha(beanFicha);
	}
	/**
	 * Nos devueve una lista de los alumnos de un curso que le pasamos por parametro
	 * @param beanCurso
	 * @return
	 */
	public ListaObjetoBean consultaAlumnosDeCurso(ObjetoBean beanCurso) {
		GestorCursos gc = new GestorCursos();
		return gc.consultaAlumnosDeCurso(beanCurso);
	}
	public boolean editar(ObjetoBean profesor)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
//		mandamos aviso al alumno diciendo que sus datos se han modificado
		//primero me creo el aviso
		CreadorBean creador = new CreadorBean();
		ObjetoBean usu = creador.crear(creador.Usuario);
		usu.cambiaValor(Constantes.ID_ISUSUARIO_DNI,profesor.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI));
		ObjetoBean aviso = creador.crear(creador.Avisos);
		aviso.cambiaValor(Constantes.AVISOS_ASUNTO,"Datos personales modificados");
		aviso.cambiaValor(Constantes.AVISOS_TEXTO,"Sus datos personales han sido modificados");
		ListaObjetoBean lista = new ListaObjetoBean();
		lista.insertar(0,usu);
		GestorAvisos gestAvisos = new GestorAvisos();
		gestAvisos.avisoAGrupo(lista,aviso);
		return bdf.editar(profesor);
	}
	/**
	 * Consulta los cursos activos en ese momento
	 * @param beanProfesor
	 * @return
	 */
	public ListaObjetoBean consultaCursosActivos(ObjetoBean beanProfesor) {
		GestorCursos gc = new GestorCursos();
		return gc.consultaCursosActivos(beanProfesor);
	}
	/**
	 * REaliza la publicacion de las notas, borrando las fichas de los alumnos
	 * y pasando el curso a inactivo
	 * @param beanCurso
	 * @return
	 */
	public boolean PublicarNota(ObjetoBean beanCurso){
		BBDDFachada bdf = BBDDFachada.getInstance();
		beanCurso.cambiaValor(Constantes.CURSO_ESTADO,"inactivo");
		bdf.editar(beanCurso);
		CreadorBean creador = new CreadorBean();
		BBDDFachadaCurso bdfc= (BBDDFachadaCurso) (bdf.dameBBDDFachada(Constantes.FachadaCurso));
		ListaObjetoBean listaAlum =this.consultaAlumnosDeCurso(beanCurso);
		ListaObjetoBean listaUsu = new ListaObjetoBean();
		for (int i=0;i<listaAlum.tamanio();i++)
		{
			ObjetoBean usuario=creador.crear(creador.Usuario);
			usuario.cambiaValor(Constantes.ID_ISUSUARIO_DNI,listaAlum.dameObjeto(i).dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
			listaUsu.insertar(i,usuario);
		}
		//me creo el aviso a mandar
		ObjetoBean aviso = creador.crear(creador.Avisos);
		aviso.cambiaValor(Constantes.AVISOS_ASUNTO,"Notas publicadas");
		aviso.cambiaValor(Constantes.AVISOS_TEXTO,"Las notas del curso "+beanCurso.dameValor(Constantes.CURSO_NOMBRE)+" han sido publicadas");
		GestorAvisos gestAvisos = new GestorAvisos();
		gestAvisos.avisoAGrupo(listaUsu,aviso);
		return bdfc.publicarNota(beanCurso);
	}
/**
 * COnsulta los contratos y devulve una lista con los que se correspondan con el contrato
 * que le psasmos
 * @param contrato
 * @return
 */
	public ListaObjetoBean consultaContratos(ObjetoBean contrato)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.consultar(contrato);
	}
	/**
	 * Devuelve una lista de nominas que se correspondan con la que le 
	 * pasamos por parametro
	 * @param nomina
	 * @return
	 */
	public ListaObjetoBean consultaNominas(ObjetoBean nomina)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.consultar(nomina);
	}
	
	/**
	 * Genera y devuelve el expediente de un curso que se compone de los alumnos
	 * de este curso y de sus notas finales correspondientes.
	 * @param curso, del cual queremos hallar su expediente
	 * @return el expediente del curso deseado.
	 */
	public ListaObjetoBean dameExpedienteCurso(ObjetoBean curso)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaCurso bdfc= (BBDDFachadaCurso) (bdf.dameBBDDFachada(Constantes.FachadaCurso));
		return bdfc.creaExpediente(curso);
	}
	/**
	 * Comprueba que los datos del profesor,de su nomina y su contraro sean correctos para insertarlo
	 * @param bean
	 * @return
	 */
	private ListaObjetoBean comprobar(ObjetoBean bean, ObjetoBean nomina,ObjetoBean contrato) {
		CreadorListaObjetoBean c = new CreadorListaObjetoBean();
		CreadorBean cBean = new CreadorBean();
		ListaObjetoBean listaerror = c.crear();
		String mensaje = "";
		int i = 0;
		
		//Se comprueba que los campos obligatorios tienen datos

		//El DNI no debe ser un campo vacío
		if (bean.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI).equals("")){
			mensaje = "El campo DNI no ha sido rellenado";
			ObjetoBean error = (ObjetoBean) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		}
		//El área no debe ser un campo vacío
		else if (bean.dameValor(Constantes.PROFESOR_ISAREA_IDISAREA).equals("")){
			mensaje = "El campo Area no ha sido rellenado";
			ObjetoBean error = (ObjetoBean) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		}
//		El nombre no debe ser un campo vacío
		else if (bean.dameValor(Constantes.PROFESOR_NOMBRE).equals("")){
			mensaje = "El campo Nombre no ha sido rellenado";
			ObjetoBean error = (ObjetoBean) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		}
//		El apellido no debe ser un campo vacío
		else if (bean.dameValor(Constantes.PROFESOR_APELLIDO1).equals("")){
			mensaje = "El campo Apellido1 no ha sido rellenado";
			ObjetoBean error = (ObjetoBean) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		}
//		El apellido no debe ser un campo vacío
		else if (bean.dameValor(Constantes.PROFESOR_APELLIDO2).equals("")){
			mensaje = "El campo Apellido2 no ha sido rellenado";
			ObjetoBean error = (ObjetoBean) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		}

//		El  tipo del contrato no puede ser vacio
		else if (contrato.dameValor(Constantes.CONTRATO_TIPO).equals("")){
			mensaje = "El campo tipo de contrato no ha sido rellenado";
			ObjetoBean error = (ObjetoBean) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		}
//		La cuenta de ingresos de la nomina no puede ser vacio
		else if (nomina.dameValor(Constantes.NOMINA_CUENTA_INGRESOS).equals("")){
			mensaje = "El campo cuenta de ingresos no ha sido rellenado";
			ObjetoBean error = (ObjetoBean) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		}
//		La cuenta de ingresos debe ser un numero
		else if (!nomina.dameValor(Constantes.NOMINA_CUENTA_INGRESOS).equals("")){
		  try {
			int telf = Integer.parseInt(nomina.dameValor(Constantes.NOMINA_CUENTA_INGRESOS));
			if (telf < 0) {
				mensaje = "El campo cuenta tiene un valor incorrecto. Debe ser" +
						  "numerica";
				ObjetoBean error = (ObjetoBean) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			}
		  } 
		  catch (Exception e) {
			// No es número
			mensaje = "El campo cuenta tiene un valor incorrecto. Debe ser " +
					  "numerica";
			ObjetoBean error = (ObjetoBean) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		  }
		}
		
//		El sueldo de la nomina no puede ser vacio
		else if (nomina.dameValor(Constantes.NOMINA_CANTIDAD).equals("")){
			mensaje = "El campo cantidad de ingresos no ha sido rellenado";
			ObjetoBean error = (ObjetoBean) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		}
//		La cantidad de ingresos debe ser un numero
		else if (!nomina.dameValor(Constantes.NOMINA_CANTIDAD).equals("")){
		  try {
			int telf = Integer.parseInt(bean.dameValor(Constantes.NOMINA_CANTIDAD));
			if (telf < 0) {
				mensaje = "El campo cantidad de ingresos tiene un valor incorrecto. Debe ser" +
						  "numerico";
				ObjetoBean error = (ObjetoBean) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			}
		  } 
		  catch (Exception e) {
			// No es número
			mensaje = "El campo cantidad de ingresos tiene un valor incorrecto. Debe ser " +
					  "numerico";
			ObjetoBean error = (ObjetoBean) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		  }
		}
		
		//El telefono debe ser un entero mayor que 0
		else if (!bean.dameValor(Constantes.PROFESOR_TELEFONO).equals("")){
		  try {
			int telf = Integer.parseInt(bean.dameValor(Constantes.PROFESOR_TELEFONO));
			if (telf < 0) {
				mensaje = "El campo Telefono tiene un valor incorrecto. Debe ser un" +
						  "entero mayor que 0";
				ObjetoBean error = (ObjetoBean) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			}
		  } 
		  catch (Exception e) {
			// No es número
			mensaje = "El campo Telefono tiene un valor incorrecto. Debe ser un" +
					  "entero mayor que 0";
			ObjetoBean error = (ObjetoBean) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		  }
		}
		return listaerror;
	}
	/**
	 * Este metodo itroduce un usuario profesor en el sistema y genera la contraseña
	 * para el usuario. Se le manda un aviso al profesor y otro a la secretaria
	 * informando de la accio. Tambien introducira la nomina y el contrato
	 * para el contable.
	 * @param profesor
	 * @param usuario
	 * @param nomina
	 * @param contrato
	 * @return lista de errores
	 */
	public ListaObjetoBean contratarProfesor(ObjetoBean profesor,ObjetoBean usuario,ObjetoBean nomina,ObjetoBean contrato)
	{
	BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean creador=new CreadorBean();
		ListaObjetoBean liserror = this.comprobar(profesor,nomina,contrato);
		if (liserror.esVacio())
		{//no hay errores en los datos del profesor
			//compruebo si el usuario existe
			if (!bdf.insertar(usuario))
			{//genero un error
				ObjetoBean error = creador.crear(creador.Error);
				error.cambiaValor(Constantes.CAUSA,"El usuario ya existe");
				int tamanio=liserror.tamanio();
				liserror.insertar(tamanio,error);
				return liserror;
			}
			else 
			{//el usuario no existe
				//mando un aviso al profesor
				GestorAvisos GA = new GestorAvisos();
				GA.passProfesor(profesor,usuario);
				
				GestorNominasyContratos GNC = new GestorNominasyContratos();
				bdf.insertar(profesor);
				nomina.cambiaValor(Constantes.ID_ISNOMINA,"1");
				if (nomina.dameValor(Constantes.NOMINA_CANTIDAD).equals(""))
				{
					nomina.cambiaValor(Constantes.NOMINA_CANTIDAD,"0");
				}
				GNC.insertarNomina(nomina);
				
				nomina.cambiaValor(Constantes.ID_ISNOMINA,"");
				//sacar isnomina-idisnomina
				ListaObjetoBean lisnom=bdf.consultar(nomina);
				//solo tendremos una nomina con un numero de ingresos y un sueldo
				nomina=lisnom.dameObjeto(0);
				contrato.cambiaValor(Constantes.CONTRATO_ISNOMINA_IDISNOMINA,nomina.dameValor(Constantes.ID_ISNOMINA));
				GNC.insertarContrato(contrato);
				
				//mando los avisos a los secretarios y al contable
				GestorAvisos gestorAvisos = new GestorAvisos();
				gestorAvisos.avisoContables(profesor,contrato,nomina);
				gestorAvisos.avisoSecretarios(profesor);
			}   
		}
		
		return liserror;
	}
	/**
	 * genere una contraseña aleatoria
	 * @return
	 */
	public int generaContrasenia()
	{
		Random rnd = new Random();
		int x;
		int contrasenia=1;
		for (int i=0;i<5;i++)
		{
		x = (int)(rnd.nextDouble() * 10.0);
		contrasenia= contrasenia*10+x;
		}
		return contrasenia;
	}
}


