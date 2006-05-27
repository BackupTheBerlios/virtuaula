package gestores;

import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.BBDDFachadaAviso;
import subSistemaBBDD.BBDDFachadaProfesor;
import subSistemaBBDD.BBDDFachadaAula;
import subSistemaBBDD.BBDDFachadaHorario;
import subSistemaBBDD.utils.Constantes;
import beans.Avisos_Has_Usuario;
import beans.CreadorBean;
import beans.Error;
import beans.ObjetoBean;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorAvisos {

	public GestorAvisos() {
		super();
	}

	public ListaObjetoBean consultaAvisos(ObjetoBean beanUsuario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaAviso bdfa = (BBDDFachadaAviso)(bdf.dameBBDDFachada(Constantes.FachadaAviso));
		ListaObjetoBean l = bdfa.dameAvisosUsuario(beanUsuario);
		return l;
	}
	/**
	 * me borra el aviso y la relacion 
	 */
	public boolean borraAviso(ObjetoBean beanAviso,ObjetoBean usuavi){
		BBDDFachada bdf = BBDDFachada.getInstance();
    	return   ((bdf.eliminar(usuavi)) && (bdf.eliminar(beanAviso)) );
	}
	public ListaObjetoBean consultarAvisos(ObjetoBean aviso)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l= bdf.consultar(aviso);
		return l;
	}
	public boolean editarAviso(ObjetoBean aviso)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.editar(aviso);
		
	}
	/**
	 * inserta un aviso en el sistema
	 * @param aviso
	 * @return
	 */
	public boolean insertarAviso(ObjetoBean aviso)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.insertar(aviso);
	};

	
	/**
	 * manda un aviso al usuario indicandole que se ha matriculado de un curso
	 * diciendole cual es su profesor, su aula y su horario
	 * @param Alumno
	 * @param Curso
	 * @return
	 */
	public ListaObjetoBean alumnoSinPass(ObjetoBean Alumno,ObjetoBean Curso)
	{	
		ListaObjetoBean liserror=new ListaObjetoBean();
		//liserror=null;
		CreadorBean creador = new CreadorBean();
		BBDDFachada bdf = BBDDFachada.getInstance();	
		ObjetoBean aviso = (ObjetoBean) creador.crear(creador.Avisos);
		BBDDFachadaProfesor bdfp=(BBDDFachadaProfesor) bdf.dameBBDDFachada(Constantes.FachadaProfesor);
		BBDDFachadaAula bdfa=(BBDDFachadaAula) bdf.dameBBDDFachada(Constantes.FachadaAula);
		BBDDFachadaHorario bdfh=(BBDDFachadaHorario) bdf.dameBBDDFachada(Constantes.FachadaHorario);
		ObjetoBean prof=bdfp.dameProfesorCurso(Curso);
		ObjetoBean aula=bdfa.dameAulaCurso(Curso);
		ObjetoBean horario=bdfh.dameHorarioCurso(Curso);
		GestorHorarios GH=new GestorHorarios();
		String hor=GH.convertirHorario(horario);
		String nombreaula= aula.dameValor(Constantes.AULA_NOMBRE);
		String nombrecurso= Curso.dameValor(Constantes.CURSO_NOMBRE);
		String nombre=prof.dameValor(Constantes.PROFESOR_NOMBRE);
		String apellido1= prof.dameValor(Constantes.PROFESOR_APELLIDO1);
		String apellido2= prof.dameValor(Constantes.PROFESOR_APELLIDO2);
		
				
		aviso.cambiaValor(Constantes.AVISOS_ASUNTO,"esteesmiaviso");
		aviso.cambiaValor(Constantes.AVISOS_TEXTO,"Se ha matriculado del  curso " + nombrecurso + "\n El" +
				"Profesor es " + nombre +" "+apellido1+ " "+ apellido2+ ". \n El aula es "+ nombreaula +". \n " +
						" El horario es "+ hor +"." );
		aviso.cambiaValor(Constantes.AVISOS_ACTIVO,"S");
		aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO,GH.dameFecha());
		aviso.cambiaValor(Constantes.AVISOS_FECHA_CADUCUDAD,"");
		aviso.cambiaValor(Constantes.ID_ISAVISOS,"1");
		
		if(!bdf.insertar(aviso)){
			String mensaje = "Error de Base de Datos al crear Aviso";
			ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			int tamaniio=liserror.tamanio();
			liserror.insertar(tamaniio,error);
			return liserror;
		}else
		{
//		 
			
			//Crear objeto bean especifico
			GestorAvisos GA=new GestorAvisos();
			aviso.cambiaValor(Constantes.ID_ISAVISOS,"");
			ListaObjetoBean listaav= GA.consultarAvisos(aviso);
			ObjetoBean aviso2 = listaav.dameObjeto(0);
			aviso2.cambiaValor(Constantes.AVISOS_ASUNTO,"Nuevo curso matriculado");
			
			if (GA.editarAviso(aviso2))
			{
			Avisos_Has_Usuario ahu = (Avisos_Has_Usuario) creador.crear(creador.AvisosHasUario);
			//Relleanar bean
										
			ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO,aviso2.dameValor(Constantes.ID_ISAVISOS));
			ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,Alumno.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
			// Rellenar tabla intermedia de relacion Avisos-Usuario
			if(!bdf.insertar(ahu)){
				String mensaje = "Error de Base de Datos al mandar Aviso";
				ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
				error.cambiaValor(Constantes.CAUSA, mensaje);
				int tamanioo=liserror.tamanio();
				liserror.insertar(tamanioo,error);
				return liserror;
			}
	    }
		}
		return liserror;
	}
	
	/**
	 * Manda un aviso de bienvenida al alumno con su usuario y contraseña
	 * @param Alumno
	 * @param Usuario
	 * @return
	 */
	public ListaObjetoBean passAlumno(ObjetoBean Alumno,ObjetoBean Usuario)
	{	
		ListaObjetoBean liserror=new ListaObjetoBean();
		//liserror=null;
		CreadorBean creador = new CreadorBean();
		BBDDFachada bdf = BBDDFachada.getInstance();	
		ObjetoBean aviso = (ObjetoBean) creador.crear(creador.Avisos);
		String password=Usuario.dameValor(Constantes.USUARIO_CONTRASENIA);
		String DNI = Usuario.dameValor(Constantes.ID_ISUSUARIO_DNI);
		String nombre= Alumno.dameValor(Constantes.AREA_NOMBRE);
		String apellido=Alumno.dameValor(Constantes.ALUMNO_APELLIDO1);
		String apellido2=Alumno.dameValor(Constantes.ALUMNO_APELLIDO2);
		
		
		aviso.cambiaValor(Constantes.AVISOS_ASUNTO,"esteesmiaviso");
		aviso.cambiaValor(Constantes.AVISOS_TEXTO,"Bienvenido a Virtuaula "+nombre+" "+apellido+" "+apellido2+". \n " +
				"Te indicamos a continuacion tus datos de acceso: \n" +
				"Usuario: "+DNI+" \n " +
				"Contraseña: "+password+" " );
		aviso.cambiaValor(Constantes.AVISOS_ACTIVO,"S");
		GestorHorarios GH =new GestorHorarios();
		aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO,GH.dameFecha());
		aviso.cambiaValor(Constantes.AVISOS_FECHA_CADUCUDAD,"");
		aviso.cambiaValor(Constantes.ID_ISAVISOS,"1");
		
		if(!bdf.insertar(aviso)){
			String mensaje = "Error de Base de Datos al crear Aviso";
			ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			int tamaniio=liserror.tamanio();
			liserror.insertar(tamaniio,error);
			return liserror;
		}else
		{
//		 
			
			//Crear objeto bean especifico
			GestorAvisos GA=new GestorAvisos();
			aviso.cambiaValor(Constantes.ID_ISAVISOS,"");
			ListaObjetoBean listaav= GA.consultarAvisos(aviso);
			ObjetoBean aviso2 = listaav.dameObjeto(0);
			aviso2.cambiaValor(Constantes.AVISOS_ASUNTO,"Bienvenido a Virtuaula");
			
			if (GA.editarAviso(aviso2))
			{
				
			Avisos_Has_Usuario ahu = (Avisos_Has_Usuario) creador.crear(creador.AvisosHasUario);
			//Relleanar bean
										
			ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO,aviso2.dameValor(Constantes.ID_ISAVISOS));
			ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,Alumno.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
			// Rellenar tabla intermedia de relacion Avisos-Usuario
			if(!bdf.insertar(ahu)){
				String mensaje = "Error de Base de Datos al mandar Aviso";
				ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
				error.cambiaValor(Constantes.CAUSA, mensaje);
				int tamanioo=liserror.tamanio();
				liserror.insertar(tamanioo,error);
				return liserror;
			}
	    }
		}
		return liserror;
	}
	
	
	
	private ListaObjetoBean comprobar(ObjetoBean bean) {
		CreadorListaObjetoBean c = new CreadorListaObjetoBean();
		CreadorBean cBean = new CreadorBean();
		ListaObjetoBean listaerror = c.crear();
		String mensaje = "";
		int i = 0;	
	    int dia1 = 0, dia2 = 0, mes1 = 0, mes2 = 0, annio1 = 0, annio2 = 0;

        if (!bean.dameValor(Constantes.AVISOS_FECHA_AVISO).equals("")) {
		   String fechaInicio = bean.dameValor(Constantes.AVISOS_FECHA_AVISO);
		   try {
			 dia1 = Integer.parseInt(fechaInicio.substring(0, 1));
			 if ((dia1 < 1) || (dia1 > 31)) {
				mensaje = "Formato de fecha aviso incorrecto. Debe ser un entero" +
						  "entre 1 y 31";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			 }
		   } catch (Exception e) {
			 // No es número
			 mensaje = "Formato de fecha aviso incorrecto. Debe ser un entero" +
					   "entre 1 y 31";
			 Error error = (Error) cBean.crear(14);
			 error.cambiaValor("CAUSA_ERROR", mensaje);
			 listaerror.insertar(i, error);
			 i++;
		   }
		   try {
			  mes1 = Integer.parseInt(fechaInicio.substring(3, 4));
			  if ((mes1 < 1) || (mes1 > 12)) {
				 mensaje = "Formato de fecha aviso incorrecto. Debe ser un entero" +
				           "entre 1 y 12";
				 Error error = (Error) cBean.crear(14);
				 error.cambiaValor("CAUSA_ERROR", mensaje);
				 listaerror.insertar(i, error);
				 i++;
			  }
		   } catch (Exception e) {
			// No es número
			 mensaje = "Formato de fecha aviso incorrecto. Debe ser un entero" +
	                   "entre 1 y 12";
			 Error error = (Error) cBean.crear(14);
			 error.cambiaValor("CAUSA_ERROR", mensaje);
			 listaerror.insertar(i, error);
			 i++;
		  }
		  try {
			annio1 = Integer.parseInt(fechaInicio.substring(6, 9));
			if ((annio1 < 0000) || (annio1 > 9999)) {
				mensaje = "Formato de fecha aviso incorrecto. Debe ser un entero de" +
						  "4 dígitos";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			}
		  } catch (Exception e) {
			// No es número
			mensaje = "Formato de fecha aviso incorrecto. Debe ser un entero de" +
			          "4 dígitos";
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		  }
	    }
        if (!bean.dameValor(Constantes.AVISOS_FECHA_CADUCUDAD).equals("")) {
		  String fechaFin = bean.dameValor(Constantes.AVISOS_FECHA_CADUCUDAD);
		  try {
			dia2 = Integer.parseInt(fechaFin.substring(0, 1));
			if ((dia2 < 1) || (dia2 > 31)) {
				mensaje = "Formato de fecha caducidad incorrecto. Debe ser un entero" +
				          "entre 1 y 31";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			}
		  } catch (Exception e) {
			// No es número
			mensaje = "Formato de fecha caducidad incorrecto. Debe ser un entero" +
			          "entre 1 y 31";
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		  }
		  try {
			mes2 = Integer.parseInt(fechaFin.substring(3, 4));
			if ((mes2 < 1) || (mes2 > 12)) {
				mensaje = "Formato de fecha caducidad incorrecto. Debe ser un entero" +
				          "entre 1 y 12";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			}
		  } catch (Exception e) {
			// No es número
			mensaje = "Formato de fecha caducidad incorrecto. Debe ser un entero" +
	                  "entre 1 y 12";
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		  }
		  try {
			annio2 = Integer.parseInt(fechaFin.substring(6, 9));
			if ((annio2 < 0000) || (annio2 > 9999)) {
				mensaje = "Formato de fecha caducidad incorrecto. Debe ser un entero de" +
		          		  "4 dígitos";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			}
		  } catch (Exception e) {
			// No es número
			mensaje = "Formato de fecha caducidad incorrecto. Debe ser un entero de" +
					  "4 dígitos";
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		  }
		  boolean fechasValidas = false;
		  if (!bean.dameValor(Constantes.AVISOS_FECHA_CADUCUDAD).equals("")
					&& (!bean.dameValor(Constantes.AVISOS_FECHA_CADUCUDAD).equals(""))) {
				if (annio1 < annio2){
					fechasValidas = true;
				}
				else if (annio1 == annio2){
					if (mes1 < mes2){
						fechasValidas = true;
					} 
					else if (mes1 == mes2){
						if (dia1 <= dia2){
							fechasValidas = true;
						}
					}
				}
			}
			if (!fechasValidas) {
				mensaje = "Los campos fecha aviso y fecha caducidad entran en " +
						  "conflicto. Asegúrese que la fecha de caducidad del aviso " +
						  "es posterior a la de inicio";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			}
        }
        return listaerror;
	}
	/**
	 * Manda un aviso de bienvenida al profesor con su usuario y contraseña
	 * @param profesor
	 * @param Usuario
	 * @return
	 */
	public ListaObjetoBean passProfesor(ObjetoBean profesor,ObjetoBean Usuario)
	{	
		ListaObjetoBean liserror=new ListaObjetoBean();
		//liserror=null;
		CreadorBean creador = new CreadorBean();
		BBDDFachada bdf = BBDDFachada.getInstance();	
		ObjetoBean aviso = (ObjetoBean) creador.crear(creador.Avisos);
		String password=Usuario.dameValor(Constantes.USUARIO_CONTRASENIA);
		String DNI = Usuario.dameValor(Constantes.ID_ISUSUARIO_DNI);
		String nombre= profesor.dameValor(Constantes.PROFESOR_NOMBRE);
		String apellido=profesor.dameValor(Constantes.PROFESOR_APELLIDO1);
		String apellido2=profesor.dameValor(Constantes.PROFESOR_APELLIDO2);
		
		//Date fecha = new Date();
		
		aviso.cambiaValor(Constantes.AVISOS_ASUNTO,"esteesmiaviso");
		aviso.cambiaValor(Constantes.AVISOS_TEXTO,"Bienvenido a Virtuaula "+nombre+" "+apellido+" "+apellido2+". \n " +
				"Te indicamos a continuacion tus datos de acceso: \n" +
				"Usuario: "+DNI+" \n " +
				"Contraseña: "+password+" " );
		aviso.cambiaValor(Constantes.AVISOS_ACTIVO,"S");
		GestorHorarios GH =new GestorHorarios();
		aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO,GH.dameFecha());
		aviso.cambiaValor(Constantes.AVISOS_FECHA_CADUCUDAD,"");
		aviso.cambiaValor(Constantes.ID_ISAVISOS,"1");
		
		if(!bdf.insertar(aviso)){
			String mensaje = "Error de Base de Datos al crear Aviso";
			ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			int tamaniio=liserror.tamanio();
			liserror.insertar(tamaniio,error);
			return liserror;
		}else
		{
//		 
			
			//Crear objeto bean especifico
			GestorAvisos GA=new GestorAvisos();
			aviso.cambiaValor(Constantes.ID_ISAVISOS,"");
			ListaObjetoBean listaav= GA.consultarAvisos(aviso);
			ObjetoBean aviso2 = listaav.dameObjeto(0);
			aviso2.cambiaValor(Constantes.AVISOS_ASUNTO,"Bienvenido a Virtuaula");
			
			if (GA.editarAviso(aviso2))
			{
				
			Avisos_Has_Usuario ahu = (Avisos_Has_Usuario) creador.crear(creador.AvisosHasUario);
			//Relleanar bean
										
			ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO,aviso2.dameValor(Constantes.ID_ISAVISOS));
			ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,profesor.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI));
			// Rellenar tabla intermedia de relacion Avisos-Usuario
			if(!bdf.insertar(ahu)){
				String mensaje = "Error de Base de Datos al mandar Aviso";
				ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
				error.cambiaValor(Constantes.CAUSA, mensaje);
				int tamanioo=liserror.tamanio();
				liserror.insertar(tamanioo,error);
				return liserror;
			}
	    }
		}
		return liserror;
	}
	/**
	 * Me manda un aviso a todos los contables con informacion sobre la contratacion de
	 * un profesor con la informacion de la nomina y del contrato
	 *
	 */
	public ListaObjetoBean avisoContables(ObjetoBean profesor,ObjetoBean contrato,ObjetoBean nomina)
	{
		ListaObjetoBean liserror=new ListaObjetoBean();
		CreadorBean creador = new CreadorBean();
		BBDDFachada bdf = BBDDFachada.getInstance();	
		ObjetoBean aviso = (ObjetoBean) creador.crear(creador.Avisos);
		String DNI = profesor.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI);
		String nombre= profesor.dameValor(Constantes.PROFESOR_NOMBRE);
		String apellido=profesor.dameValor(Constantes.PROFESOR_APELLIDO1);
		String apellido2=profesor.dameValor(Constantes.PROFESOR_APELLIDO2);
		
		//Creamos el aviso		
		aviso.cambiaValor(Constantes.AVISOS_ASUNTO,"esteesmiaviso");
		aviso.cambiaValor(Constantes.AVISOS_TEXTO,"Incorporacion de personal. \n Datos personales: \n DNI:"+DNI+" " +nombre+" "+apellido+" "+apellido2+"." +
				"\n Sueldo: "+nomina.dameValor(Constantes.NOMINA_CANTIDAD)+".\n" +
				"Cuenta de ingresos: "+nomina.dameValor(Constantes.NOMINA_CUENTA_INGRESOS)+". \n" +
				"Tipo de contrato: "+contrato.dameValor(Constantes.CONTRATO_TIPO)+".");
		aviso.cambiaValor(Constantes.AVISOS_ACTIVO,"S");
		GestorHorarios GH =new GestorHorarios();
		aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO,GH.dameFecha());
		aviso.cambiaValor(Constantes.AVISOS_FECHA_CADUCUDAD,"");
		aviso.cambiaValor(Constantes.ID_ISAVISOS,"1");
		
		//Consultamos todos los contables que hay en la empresa para mandarles el aviso
		ObjetoBean usuario=creador.crear(creador.Usuario);
		usuario.cambiaValor(Constantes.USUARIO_PERFIL,"contable");
		ListaObjetoBean listacontables=bdf.consultar(usuario);
		int numcontables=listacontables.tamanio();
		//mandamos el aviso a todos los contables del sistema
		for (int i=0;i<numcontables;i++)
		{
			
			if(!bdf.insertar(aviso))
			{
				String mensaje = "Error de Base de Datos al crear Aviso";
				ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
				error.cambiaValor(Constantes.CAUSA, mensaje);
				int tamaniio=liserror.tamanio();
				liserror.insertar(tamaniio,error);
				return liserror;
			}
			else
			{	//si se ha insertado el aviso correctamente
				
				//Crear objeto bean especifico
				GestorAvisos GA=new GestorAvisos();
				aviso.cambiaValor(Constantes.ID_ISAVISOS,"");
				ListaObjetoBean listaav= GA.consultarAvisos(aviso);
				ObjetoBean aviso2 = listaav.dameObjeto(0);
				aviso2.cambiaValor(Constantes.AVISOS_ASUNTO,"Personal contratado");
				
				if (GA.editarAviso(aviso2))
				{
						
					Avisos_Has_Usuario ahu = (Avisos_Has_Usuario) creador.crear(creador.AvisosHasUario);
					
					//Relleanar bean
					ObjetoBean usuar = listacontables.dameObjeto(i);
									
					ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO,aviso2.dameValor(Constantes.ID_ISAVISOS));
					ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,usuar.dameValor(Constantes.ID_ISUSUARIO_DNI));
					// Rellenar tabla intermedia de relacion Avisos-Usuario
					if(!bdf.insertar(ahu))
					{
						String mensaje = "Error de Base de Datos al mandar Aviso";
						ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
						error.cambiaValor(Constantes.CAUSA, mensaje);
						int tamanioo=liserror.tamanio();
						liserror.insertar(tamanioo,error);
						return liserror;
					}
				}
			}//fin else
		}//fin del for
		
		return liserror;
		
	}
	/**
	 * Me manda un aviso a todos los secretariso con informacion sobre la contratacion
	 * de un profesor con sus datos y los de su area
	 */ 
	public ListaObjetoBean avisoSecretarios(ObjetoBean profesor)
	{
		ListaObjetoBean liserror=new ListaObjetoBean();
		CreadorBean creador = new CreadorBean();
		BBDDFachada bdf = BBDDFachada.getInstance();	
		//saco los datos del profesor
		ObjetoBean aviso = (ObjetoBean) creador.crear(creador.Avisos);
		String DNI = profesor.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI);
		String nombre= profesor.dameValor(Constantes.PROFESOR_NOMBRE);
		String apellido=profesor.dameValor(Constantes.PROFESOR_APELLIDO1);
		String apellido2=profesor.dameValor(Constantes.PROFESOR_APELLIDO2);
		//consigo el area del profesor
		String idarea=profesor.dameValor(Constantes.PROFESOR_ISAREA_IDISAREA);
		ObjetoBean area=creador.crear(creador.Area);
		area.cambiaValor(Constantes.ID_ISAREA,idarea);
		GestorAreas gestorAreas = new GestorAreas();
		ListaObjetoBean listarea=gestorAreas.consultaArea(area);
		//como solo me va a devolver un area cojo el primer elemento
		area=listarea.dameObjeto(0);
		//Creamos el aviso		
		aviso.cambiaValor(Constantes.AVISOS_ASUNTO,"esteesmiaviso");
		aviso.cambiaValor(Constantes.AVISOS_TEXTO,"Incorporacion de personal. \n Datos personales: \n DNI:"+DNI+" \n Nombre: " +nombre+" "+apellido+" "+apellido2+"." +
		"\n Telefono: "+profesor.dameValor(Constantes.PROFESOR_TELEFONO)+"\n " +
		"Email: "+profesor.dameValor(Constantes.PROFESOR_TELEFONO)+". \n" +
		"Area tecnológica:"+area.dameValor(Constantes.AREA_NOMBRE)+".");
		aviso.cambiaValor(Constantes.AVISOS_ACTIVO,"S");
		GestorHorarios GH =new GestorHorarios();
		aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO,GH.dameFecha());
		aviso.cambiaValor(Constantes.AVISOS_FECHA_CADUCUDAD,"");
		aviso.cambiaValor(Constantes.ID_ISAVISOS,"1");
		
		//Consultamos todos los contables que hay en la empresa para mandarles el aviso
		ObjetoBean usuario=creador.crear(creador.Usuario);
		usuario.cambiaValor(Constantes.USUARIO_PERFIL,"secretaria");
		ListaObjetoBean listacontables=bdf.consultar(usuario);
		int numsecretarios=listacontables.tamanio();
		//mandamos el aviso a todos los contables del sistema
		for (int i=0;i<numsecretarios;i++)
		{
			
			if(!bdf.insertar(aviso))
			{
				String mensaje = "Error de Base de Datos al crear Aviso";
				ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
				error.cambiaValor(Constantes.CAUSA, mensaje);
				int tamaniio=liserror.tamanio();
				liserror.insertar(tamaniio,error);
				return liserror;
			}
			else
			{	//si se ha insertado el aviso correctamente
				
				//Crear objeto bean especifico
				GestorAvisos GA=new GestorAvisos();
				aviso.cambiaValor(Constantes.ID_ISAVISOS,"");
				ListaObjetoBean listaav= GA.consultarAvisos(aviso);
				ObjetoBean aviso2 = listaav.dameObjeto(0);
				aviso2.cambiaValor(Constantes.AVISOS_ASUNTO,"Nuevo Profesor");
				
				if (GA.editarAviso(aviso2))
				{
						
					Avisos_Has_Usuario ahu = (Avisos_Has_Usuario) creador.crear(creador.AvisosHasUario);
					
					//Relleanar bean
					ObjetoBean usuar = listacontables.dameObjeto(i);
									
					ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO,aviso2.dameValor(Constantes.ID_ISAVISOS));
					ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,usuar.dameValor(Constantes.ID_ISUSUARIO_DNI));
					// Rellenar tabla intermedia de relacion Avisos-Usuario
					if(!bdf.insertar(ahu))
					{
						String mensaje = "Error de Base de Datos al mandar Aviso";
						ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
						error.cambiaValor(Constantes.CAUSA, mensaje);
						int tamanioo=liserror.tamanio();
						liserror.insertar(tamanioo,error);
						return liserror;
					}
				}
			}//fin else
		}//fin del for
		
		return liserror;
		
	}
	/**
	 * Devuelve el numero de avisos sin leer de un usuario 
	 */
	public int numeroAvisosNuevos(ObjetoBean beanUsuario){
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaAviso bdfa = (BBDDFachadaAviso)(bdf.dameBBDDFachada(Constantes.FachadaAviso));
		ListaObjetoBean l = bdfa.dameAvisosUsuario(beanUsuario);
		return l.tamanio();
	}

	/**
	 * Manda un aviso a un grupo de usuarios contenidos en la listaObjetoBean
	 * @param grupo de usuarios a los que mandamos el mensaje
	 * @param aviso que queremos mandar
	 * @return
	 */
	public ListaObjetoBean avisoAGrupo(ListaObjetoBean grupo,ObjetoBean aviso)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean creador = new CreadorBean();
		GestorHorarios GH = new GestorHorarios();
		ListaObjetoBean liserror=new ListaObjetoBean();
		aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO,GH.dameFecha());
		int numDest= grupo.tamanio();
		String asunto = aviso.dameValor(Constantes.AVISOS_ASUNTO);
		aviso.cambiaValor(Constantes.AVISOS_ASUNTO,"esteesmiaviso");
		for (int i = 0; i<numDest;i++)
		{//insertar el aviso y asignarlo al usuario correspondiente
			

			if(!bdf.insertar(aviso))
			{
				String mensaje = "Error de Base de Datos al crear Aviso";
				ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
				error.cambiaValor(Constantes.CAUSA, mensaje);
				int tamaniio=liserror.tamanio();
				liserror.insertar(tamaniio,error);
				return liserror;
			}
			else
			{	//si se ha insertado el aviso correctamente
				
				//Crear objeto bean especifico
				GestorAvisos GA=new GestorAvisos();
				aviso.cambiaValor(Constantes.ID_ISAVISOS,"");
				ListaObjetoBean listaav= GA.consultarAvisos(aviso);
				ObjetoBean aviso2 = listaav.dameObjeto(0);
				aviso2.cambiaValor(Constantes.AVISOS_ASUNTO,asunto);
				
				if (GA.editarAviso(aviso2))
				{
						
					Avisos_Has_Usuario ahu = (Avisos_Has_Usuario) creador.crear(creador.AvisosHasUario);
					
					//Relleanar bean
					ObjetoBean usuar = grupo.dameObjeto(i);
									
					ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO,aviso2.dameValor(Constantes.ID_ISAVISOS));
					ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,usuar.dameValor(Constantes.ID_ISUSUARIO_DNI));
					// Rellenar tabla intermedia de relacion Avisos-Usuario
					if(!bdf.insertar(ahu))
					{
						String mensaje = "Error de Base de Datos al mandar Aviso";
						ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
						error.cambiaValor(Constantes.CAUSA, mensaje);
						int tamanioo=liserror.tamanio();
						liserror.insertar(tamanioo,error);
						return liserror;
					}
				}
			}//fin else
			
			
		}
		return liserror;
	}
		
}
