package gestores;

import subSistemaBBDD.BBDDFachada;
import beans.*;
import beans.listaObjetoBeans.*;
import subSistemaBBDD.utils.Constantes;

public class GestorCursos {

	public GestorCursos() {
		super();
	}

	public ListaObjetoBean consultaCurso(ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.consultar(beanCurso);
		return l;
	}
	public ListaObjetoBean consultaCurso(ObjetoBean beanCurso,ObjetoBean aula,ObjetoBean horario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.dameCursosCumplan(beanCurso,aula,horario);
		return l;
	}
	
	public Area consultaAreaDeCurso(ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return (Area)bdf.dameAreaCurso(beanCurso);
	}
	
	public Horario consultaHorarioDeCurso(ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return (Horario)bdf.dameHorarioCurso(beanCurso);
	}
	
	public ListaObjetoBean consultaAlumnosDeCurso(ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.dameAlumnosCurso(beanCurso);
	}
	
	public ListaObjetoBean consultaCursosActivos(ObjetoBean beanProfesor) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.dameCursosActivos(beanProfesor);
	}
	
	
	public Aula consultaAulaDeCurso(ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return (Aula)bdf.dameAulaCurso(beanCurso);
	}
	
	public Profesor consultaProfesorDeCurso(ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return (Profesor)bdf.dameProfesorCurso(beanCurso);
	}
	
	public ListaObjetoBean consultaProfesores(){
		Profesorado p = new Profesorado();
		return p.consultaProfesores();
	}
	
	public ListaObjetoBean consultaProfesoresPorHorario (ObjetoBean beanHorario) {
		Profesorado p = new Profesorado();
		return p.consultaProfesoresPorHorario(beanHorario);
	}
	
	public ListaObjetoBean consultaAulas() {
		GestorAulas ga = new GestorAulas();
		return ga.consultaAulas();
	}
	
	public ListaObjetoBean consultaAulasPorHorario (ObjetoBean beanHorario) {
		GestorAulas ga = new GestorAulas();
		return ga.consultaAulasPorHorario(beanHorario);
	}
	
	public ListaObjetoBean consultaHorarios() {
		GestorHorarios gh = new GestorHorarios();
		return gh.consultaHorarios();
	}
	
	public ListaObjetoBean consultaAreas() {
		GestorAreas ga = new GestorAreas();
		return ga.consultaAreas();
	}
	
	private ListaObjetoBean comprobar(ObjetoBean bean) {
		CreadorListaObjetoBean c = new CreadorListaObjetoBean();
		CreadorBean cBean = new CreadorBean();
		ListaObjetoBean l = c.crear();
		String mensaje = "";
		int i = 0;

		// comprobar que los campos obligatorios tienen datos

		if (bean.dameValor(Constantes.CURSO_NOMBRE).equals("")) {
			mensaje = "El campo nombre no ha sido rellenado";
			ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			l.insertar(i, error);
			i++;
		}
		if (bean.dameValor(Constantes.CURSO_PRECIO).equals("")) {
			bean.cambiaValor(Constantes.CURSO_PRECIO,"0");
			//mensaje = "El campo precio no ha sido rellenado";
			//ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
			//error.cambiaValor("CAUSA_ERROR", mensaje);
			//l.insertar(i, error);
			//i++;
		}

		if (bean.dameValor(Constantes.CURSO_ISAREA_IDISAREA).equals("")) {
			mensaje = "El campo area no ha sido rellenado";
			ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			l.insertar(i, error);
			i++;
		}

		if (bean.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI)
				.equals("")) {
			mensaje = "El campo dni profesor no ha sido rellenado";
			ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			l.insertar(i, error);
			i++;
		}

		
		int dia1 = 0;
		int dia2 = 0;
		int mes1 = 0;
		int mes2 = 0;
		int annio1 = 0;
		int annio2 = 0;
		
		if ((!bean.dameValor(Constantes.CURSO_FECHA_INICIO).equals("")) && (!bean.dameValor(Constantes.CURSO_FECHA_INICIO).equals(""))) {
		boolean fechasValidas = false;
		String fechaFin = bean.dameValor(Constantes.CURSO_FECHA_FIN);
		String fechaInicio = bean.dameValor(Constantes.CURSO_FECHA_INICIO);
		dia1 = Integer.parseInt(fechaInicio.substring(0, 2));
		mes1 = Integer.parseInt(fechaInicio.substring(3, 5));
		annio1 = Integer.parseInt(fechaInicio.substring(6, 10));
		dia2 = Integer.parseInt(fechaFin.substring(0, 2));
		mes2 = Integer.parseInt(fechaFin.substring(3, 5));
		annio2 = Integer.parseInt(fechaFin.substring(6, 10));
		if (!bean.dameValor(Constantes.CURSO_FECHA_FIN).equals("")
				&& (!bean.dameValor(Constantes.CURSO_FECHA_INICIO).equals(""))) {
			if (annio1 < annio2) {
				fechasValidas = true;
			} else if (annio1 == annio2) {
				if (mes1 < mes2) {
					fechasValidas = true;
				} else if (mes1 == mes2) {
					if (dia1 <= dia2) {
						fechasValidas = true;
					}
				}
			}
		}
		if (!fechasValidas) {
			mensaje = "Los campos fecha inicio y fecha fin entran en conflicto";
			ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			l.insertar(i, error);
			i++;
		}
		}
		// comprobar que los campos numericos no contienen letras
		try {
			int numerico = Integer.parseInt(bean
					.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI));
			if (numerico < 0) {
				mensaje = "El campo DNI tiene un valor incorrecto";
				ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				l.insertar(i, error);
				i++;
			}
		} catch (Exception e) {
			// No es número
			mensaje = "El campo DNI debe ser numérico";
			ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			l.insertar(i, error);
			i++;
		}
		if (!bean.dameValor(Constantes.CURSO_NUMERO_PLAZAS).equals("")) {
			try {
				int numerico = Integer.parseInt(bean
						.dameValor(Constantes.CURSO_NUMERO_PLAZAS));
				if (numerico < 0) {
					mensaje = "El campo numero de plazas tiene un valor incorrecto";
					ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					l.insertar(i, error);
					i++;
				}
			} catch (Exception e) {
				// No es número
				mensaje = "El campo numero de plazas debe ser numérico";
				ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				l.insertar(i, error);
				i++;
			}
		}
		if (!bean.dameValor(Constantes.CURSO_PRECIO).equals("")) {
			try {
				float numerico = Float.parseFloat(bean
						.dameValor(Constantes.CURSO_PRECIO));
				if (numerico < 0) {
					mensaje = "El campo precio tiene un valor incorrecto";
					ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					l.insertar(i, error);
					i++;
				}
			} catch (Exception e) {
				// No es número
				mensaje = "El campo precio debe ser numérico";
				ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				l.insertar(i, error);
				i++;
			}
		}

		return l;
	}

	public ListaObjetoBean insertarCurso(ObjetoBean beanCurso,
			ObjetoBean beanAula, ObjetoBean beanHorario) {
		
		ListaObjetoBean result = null;
		CreadorBean cBean = new CreadorBean();
		BBDDFachada bdf = BBDDFachada.getInstance();
		
		//beanCurso.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI)
		GestorAulas gestoraulas = new GestorAulas();
		ListaObjetoBean listaAula = gestoraulas.consultaAulasPorHorario(beanHorario);
		//bdf.dameAulasLibres(beanHorario);
		boolean aulLibre = false; 
		Aula aul = null;
		String s = beanAula.dameValor(Constantes.ID_ISAULA);
		for (int i = 0; i<listaAula.tamanio(); i++){
			aul = (Aula) listaAula.dameObjeto(i);
			if(s.equals(aul.dameValor(Constantes.ID_ISAULA))){
				aulLibre = true;
			}
		}
		Profesorado profesorado=new Profesorado();
		ListaObjetoBean listaProfesor = profesorado.consultaProfesoresPorHorario(beanHorario);
		//bdf.dameProfesoresLibres(beanHorario);		
		boolean profLibre = false; 
		Profesor p = null;
		s = beanCurso.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI);
		for (int i = 0; i<listaProfesor.tamanio(); i++){
			p = (Profesor) listaProfesor.dameObjeto(i);
			if(s.equals(p.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI))){
				profLibre = true;
			}
		}
		
		if (profLibre && aulLibre){
		result = comprobar(beanCurso);
		beanCurso.cambiaValor(Constantes.CURSO_ESTADO,"Activo");
		beanCurso.cambiaValor(Constantes.CURSO_NUMERO_PLAZAS,beanAula.dameValor(Constantes.AULA_CAPACIDAD));
		
		if (result.esVacio()) {
			beanCurso.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO,"1");
			if (bdf.insertar(beanCurso)) {
				// Crear objeto bean especifico
				Horario_Has_Aula hha = (Horario_Has_Aula) cBean.crear(cBean.HorarioHasAula);
				//Relleanr bean
				hha.cambiaValor(Constantes.ID_HAS_ISHORARIO_IDISHORARIO,beanHorario.dameValor(Constantes.ID_ISHORARIO));
				hha.cambiaValor(Constantes.ID_HAS_ISAULA_IDISAULA,beanAula.dameValor(Constantes.ID_ISAULA));
				beanCurso.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO,"");
				ListaObjetoBean l2 = bdf.consultar(beanCurso);
				Curso c = (Curso) l2.dameObjeto(0);
				hha.cambiaValor(Constantes.ISHORARIO_HAS_ISAULA_ISCURSO_IDISCURSO,c.dameValor(Constantes.ID_ISCURSO_IDISCURSO));
				
				// Insertar en tabla intermedia de relacion Horario-Aula
				if(!bdf.insertar(hha)){
					String mensaje = "Error de Base de Datos al crear relacion";
					ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					result.insertar(0, error);
					return result;
				}
				
				
				// Mandar aviso a profesor
	
				Avisos aviso = (Avisos) cBean.crear(cBean.Avisos);
				aviso.cambiaValor(Constantes.AVISOS_ASUNTO,"Nuevo curso a impartir");
				aviso.cambiaValor(Constantes.AVISOS_TEXTO,"Le ha sido agignado el curso " + beanCurso.dameValor(Constantes.CURSO_NOMBRE));
				aviso.cambiaValor(Constantes.AVISOS_ACTIVO,"S");	
				aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO,"");
				aviso.cambiaValor(Constantes.AVISOS_FECHA_CADUCUDAD,"");
				aviso.cambiaValor(Constantes.ID_ISAVISOS,"1");
				GestorAvisos gestorAvisos= new GestorAvisos();
				if(!gestorAvisos.insertarAviso(aviso)){
					//!bdf.insertar(aviso)
					String mensaje = "Error de Base de Datos al crear Aviso";
					ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					result.insertar(0, error);
					return result;
				}
				// Crear objeto bean especifico
				Avisos_Has_Usuario ahu = (Avisos_Has_Usuario) cBean.crear(cBean.AvisosHasUario);
				//Relleanr bean
				aviso.cambiaValor(Constantes.ID_ISAVISOS,"");
				ListaObjetoBean l3 = gestorAvisos.consultarAvisos(aviso);
				//bdf.consultar(aviso)
				Avisos a  = (Avisos) l3.dameObjeto(0);				
				ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO,a.dameValor(Constantes.ID_ISAVISOS));
				ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,beanCurso.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI));
				// Rellenar tabla intermedia de relacion Avisos-Usuario
				if(!bdf.insertar(ahu)){
					String mensaje = "Error de Base de Datos al mandar Aviso";
					ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					result.insertar(0, error);
					return result;
				}
				
			} else {
				if (bdf.cursoYaExiste(beanCurso)){
					String mensaje = "El curso introducido ya existe";
					ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					result.insertar(0, error);
					return result;
				}else{
					String mensaje = "Error de Base de Datos";
					ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					result.insertar(0, error);
					return result;
				}				
			}
			return null;
		}

		System.out.println("Ok");
		return result;
	}
	
	else{
		CreadorListaObjetoBean c = new CreadorListaObjetoBean();
		result =c.crear();
		String mensaje = "Los datos seleccionados han caducado y ya no son válidos";
		ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
		error.cambiaValor("CAUSA_ERROR", mensaje);
		result.insertar(0, error);
		return result;
	}

}
	public boolean editaCurso(ObjetoBean curso)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.editar(curso);
	}
	public ListaObjetoBean dameCursosActivos()
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.dameCursosActivos();
	}
}
