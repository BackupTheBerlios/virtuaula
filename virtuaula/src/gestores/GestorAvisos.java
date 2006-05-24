package gestores;

import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.utils.Constantes;
import beans.Avisos_Has_Usuario;
import beans.CreadorBean;
import beans.Error;
import beans.ObjetoBean;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import java.util.Date;

public class GestorAvisos {

	public GestorAvisos() {
		super();
	}

	public ListaObjetoBean consultaAvisos(ObjetoBean beanUsuario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.dameAvisosUsuario(beanUsuario);
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
	public boolean insertarAviso(ObjetoBean aviso)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.insertar(aviso);
	};
	
	public ListaObjetoBean alumnoSinPass(ObjetoBean Alumno,ObjetoBean Curso)
	{	
		ListaObjetoBean liserror=new ListaObjetoBean();
		//liserror=null;
		CreadorBean creador = new CreadorBean();
		BBDDFachada bdf = BBDDFachada.getInstance();	
		ObjetoBean aviso = (ObjetoBean) creador.crear(creador.Avisos);
		ObjetoBean prof=bdf.dameProfesorCurso(Curso);
		ObjetoBean aula=bdf.dameAulaCurso(Curso);
		ObjetoBean horario=bdf.dameHorarioCurso(Curso);
		String hor=this.convertirHorario(horario);
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
		aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO,"");
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
		aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO,"");
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
			System.out.println(listaav.tamanio());
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
		aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO,"");
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
			System.out.println(listaav.tamanio());
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
	
	
	private String convertirHorario(ObjetoBean horario)
	{
		String lunes = horario.dameValor(Constantes.HORARIO_LUNES);
		String martes = horario.dameValor(Constantes.HORARIO_MARTES);
		String miercoles = horario.dameValor(Constantes.HORARIO_MIERCOLES);
		String jueves = horario.dameValor(Constantes.HORARIO_JUEVES);
		String viernes = horario.dameValor(Constantes.HORARIO_VIERNES);
		String resul="";
		if (lunes!=null)
		{
			resul=resul+"L";
			resul=resul+lunes;
			resul=resul+"-";
		}
		if (martes!=null)
		{
			resul=resul+"M";
			resul=resul+martes;
			resul=resul+"-";
		}
		if (miercoles!=null)
		{
			resul=resul+"X";
			resul=resul+miercoles;
			resul=resul+"-";
		}
		if (jueves!=null)
		{
			resul=resul+"J";
			resul=resul+jueves;
			resul=resul+"-";
		}
		if (viernes!=null)
		{
			resul=resul+"V";
			resul=resul+viernes;
			resul=resul+"-";
		}
		return resul;
	}
}
