package gestores;

import java.text.SimpleDateFormat;
import java.util.Date;

import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.BBDDFachadaAlumno;
import subSistemaBBDD.BBDDFachadaArea;
import subSistemaBBDD.BBDDFachadaAula;
import subSistemaBBDD.BBDDFachadaCurso;
import subSistemaBBDD.BBDDFachadaHorario;
import subSistemaBBDD.BBDDFachadaProfesor;
import subSistemaBBDD.utils.Constantes;
import beans.Area;
import beans.Aula;
import beans.Avisos;
import beans.Avisos_Has_Usuario;
import beans.CreadorBean;
import beans.Curso;
import beans.Horario;
import beans.Horario_Has_Aula;
import beans.ObjetoBean;
import beans.Profesor;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

/**
 * Se encarga de realizar todas las operaciones necesarias para gestionar los
 * cursos. Se ayudara de otros gestores para realizar dichas operaciones.
 * Tambien se encarga de comprobar que los datos de un curso esten bien
 * introducidos.
 * 
 * @author Albeto Macho
 * 
 */
public class GestorCursos {

	public GestorCursos() {
		super();
	}

	/**
	 * Devuelve una lista de cursos que se corresponda con las caracteristicas
	 * del beancurso
	 * 
	 * @param beanCurso
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultaCurso(ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.consultar(beanCurso);
		return l;
	}

	/**
	 * NDevuelve una lista con los cursos que se correspondan con los parametros
	 * que se pasan
	 * 
	 * @param beanCurso
	 * @param aula
	 * @param horario
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultaCurso(ObjetoBean beanCurso, ObjetoBean aula,
			ObjetoBean horario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaCurso bdfc = (BBDDFachadaCurso) (bdf
				.dameBBDDFachada(Constantes.FachadaCurso));
		ListaObjetoBean l = bdfc.dameCursosCumplan(beanCurso, aula, horario);
		return l;
	}

	/**
	 * Devuelve el area de un curso
	 * 
	 * @param beanCurso
	 * @return Area
	 */
	public Area consultaAreaDeCurso(ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaArea bdfa = (BBDDFachadaArea) (bdf
				.dameBBDDFachada(Constantes.FachadaArea));
		return (Area) bdfa.dameAreaCurso(beanCurso);
	}

	/**
	 * Devuelve el horario de un curso
	 * 
	 * @param beanCurso
	 * @return Horario
	 */
	public Horario consultaHorarioDeCurso(ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaHorario bdfh = (BBDDFachadaHorario) (bdf
				.dameBBDDFachada(Constantes.FachadaHorario));
		return (Horario) bdfh.dameHorarioCurso(beanCurso);
	}

	/**
	 * Devuelve una lista de cursos que tiene un alumno en concreto
	 * 
	 * @param alumno
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultarCursosDeAlumno(ObjetoBean alumno) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaCurso bdfc = (BBDDFachadaCurso) (bdf
				.dameBBDDFachada(Constantes.FachadaCurso));
		return bdfc.dameCursosAlumno(alumno);
	}

	/**
	 * Devuelve una lista de los alumnos de un curso en concreto
	 * 
	 * @param beanCurso
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultaAlumnosDeCurso(ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaAlumno bdfa = (BBDDFachadaAlumno) (bdf
				.dameBBDDFachada(Constantes.FachadaAlumno));
		return bdfa.dameAlumnosCurso(beanCurso);
	}

	/**
	 * Devuelve una lista de los cursos activos
	 * 
	 * @param beanProfesor
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultaCursosActivos(ObjetoBean beanProfesor) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaCurso bdfc = (BBDDFachadaCurso) (bdf
				.dameBBDDFachada(Constantes.FachadaCurso));
		return bdfc.dameCursosActivos(beanProfesor);
	}

	/**
	 * Devuelve el aula de un curso en concreto
	 * 
	 * @param beanCurso
	 * @return Aula
	 */
	public Aula consultaAulaDeCurso(ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaAula bdfa = (BBDDFachadaAula) (bdf
				.dameBBDDFachada(Constantes.FachadaAula));
		return (Aula) bdfa.dameAulaCurso(beanCurso);
	}

	/**
	 * Devuelve el profesor que imparte un curso
	 * 
	 * @param beanCurso
	 * @return Profesor
	 */
	public Profesor consultaProfesorDeCurso(ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaProfesor bdfp = (BBDDFachadaProfesor) (bdf
				.dameBBDDFachada(Constantes.FachadaProfesor));
		return (Profesor) bdfp.dameProfesorCurso(beanCurso);
	}

	/**
	 * Devuelve una lista de todos los profesores
	 * 
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultaProfesores() {
		Profesorado p = new Profesorado();
		return p.consultaProfesores();
	}

	/**
	 * Devuelve una lista de los profesores libres en un horario
	 * 
	 * @param beanHorario
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultaProfesoresPorHorario(ObjetoBean beanHorario) {
		Profesorado p = new Profesorado();
		return p.consultaProfesoresPorHorario(beanHorario);
	}

	/**
	 * Devulve una lista de todas las aulas
	 * 
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultaAulas() {
		GestorAulas ga = new GestorAulas();
		return ga.consultaAulas();
	}

	/**
	 * Devulve una lista de las aulas libres en un horario
	 * 
	 * @param beanHorario
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultaAulasPorHorario(ObjetoBean beanHorario) {
		GestorAulas ga = new GestorAulas();
		return ga.consultaAulasPorHorario(beanHorario);
	}

	/**
	 * Devuelve todos los horarios existentes
	 * 
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultaHorarios() {
		GestorHorarios gh = new GestorHorarios();
		return gh.consultaHorarios();
	}

	/**
	 * Devuelve todas las areas
	 * 
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultaAreas() {
		GestorAreas ga = new GestorAreas();
		return ga.consultaAreas();
	}

	/**
	 * Comprueba los datos basicos del curso
	 * 
	 * @param bean
	 * @return ListaObjetoBean Contiene los errores detectados en los datos
	 */
	public ListaObjetoBean comprobarParcial(ObjetoBean bean) {
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
			bean.cambiaValor(Constantes.CURSO_PRECIO, "0");
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

		int dia1 = 0;
		int dia2 = 0;
		int mes1 = 0;
		int mes2 = 0;
		int annio1 = 0;
		int annio2 = 0;

		if ((!bean.dameValor(Constantes.CURSO_FECHA_INICIO).equals(""))
				&& (!bean.dameValor(Constantes.CURSO_FECHA_FIN).equals(""))) {
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
					&& (!bean.dameValor(Constantes.CURSO_FECHA_INICIO).equals(
							""))) {
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
		return l;

	}

	/**
	 * Comprueba que los datos introducidos sean correctos.
	 * 
	 * @param bean
	 * @return ListaObjetoBean Contiene los errores detectados
	 */

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
			bean.cambiaValor(Constantes.CURSO_PRECIO, "0");
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

		if (bean.dameValor(Constantes.CURSO_ISAREA_IDISAREA).equals("")) {
			mensaje = "El campo área no ha sido rellenado";
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

		if ((!bean.dameValor(Constantes.CURSO_FECHA_INICIO).equals(""))
				&& (!bean.dameValor(Constantes.CURSO_FECHA_FIN).equals(""))) {
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
					&& (!bean.dameValor(Constantes.CURSO_FECHA_INICIO).equals(
							""))) {
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
					mensaje = "El campo número de plazas tiene un valor incorrecto";
					ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					l.insertar(i, error);
					i++;
				}
			} catch (Exception e) {
				// No es número
				mensaje = "El campo número de plazas debe ser numérico";
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

	/**
	 * Devuelve la fecha del sistema
	 * 
	 * @return String
	 */
	public String dameFecha() {
		// cojo la fecha del sistema
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String cadenafecha = formato.format(fecha);
		return cadenafecha;
	}

	/**
	 * Inserta un curso que le pasemos con un aula y un horario
	 * 
	 * @param beanCurso
	 * @param beanAula
	 * @param beanHorario
	 * @return ListaObjetoBean Contiene los errores detectados
	 */

	public ListaObjetoBean insertarCurso(ObjetoBean beanCurso,
			ObjetoBean beanAula, ObjetoBean beanHorario) {

		ListaObjetoBean result = null;
		CreadorBean cBean = new CreadorBean();
		BBDDFachada bdf = BBDDFachada.getInstance();

		// beanCurso.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI)
		GestorAulas gestoraulas = new GestorAulas();
		ListaObjetoBean listaAula = gestoraulas
				.consultaAulasPorHorario(beanHorario);
		// bdf.dameAulasLibres(beanHorario);
		boolean aulLibre = false;
		Aula aul = null;
		String s = beanAula.dameValor(Constantes.ID_ISAULA);
		for (int i = 0; i < listaAula.tamanio(); i++) {
			aul = (Aula) listaAula.dameObjeto(i);
			if (s.equals(aul.dameValor(Constantes.ID_ISAULA))) {
				aulLibre = true;
			}
		}
		Profesorado profesorado = new Profesorado();
		ListaObjetoBean listaProfesor = profesorado
				.consultaProfesoresPorHorario(beanHorario);
		// bdf.dameProfesoresLibres(beanHorario);
		boolean profLibre = false;
		Profesor p = null;
		s = beanCurso.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI);
		for (int i = 0; i < listaProfesor.tamanio(); i++) {
			p = (Profesor) listaProfesor.dameObjeto(i);
			if (s.equals(p.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI))) {
				profLibre = true;
			}
		}

		if (profLibre && aulLibre) {
			result = comprobar(beanCurso);
			beanCurso.cambiaValor(Constantes.CURSO_ESTADO, "Activo");
			beanCurso.cambiaValor(Constantes.CURSO_NUMERO_PLAZAS, beanAula
					.dameValor(Constantes.AULA_CAPACIDAD));

			if (result.esVacio()) {
				beanCurso.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO, "1");
				if (bdf.insertar(beanCurso)) {
					// Crear objeto bean especifico
					Horario_Has_Aula hha = (Horario_Has_Aula) cBean
							.crear(cBean.HorarioHasAula);
					// Relleanr bean
					hha.cambiaValor(Constantes.ID_HAS_ISHORARIO_IDISHORARIO,
							beanHorario.dameValor(Constantes.ID_ISHORARIO));
					hha.cambiaValor(Constantes.ID_HAS_ISAULA_IDISAULA, beanAula
							.dameValor(Constantes.ID_ISAULA));
					beanCurso.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO, "");
					ListaObjetoBean l2 = bdf.consultar(beanCurso);
					Curso c = (Curso) l2.dameObjeto(0);
					hha.cambiaValor(
							Constantes.ISHORARIO_HAS_ISAULA_ISCURSO_IDISCURSO,
							c.dameValor(Constantes.ID_ISCURSO_IDISCURSO));

					// Insertar en tabla intermedia de relacion Horario-Aula
					if (!bdf.insertar(hha)) {
						String mensaje = "Error de Base de Datos al crear relación";
						ObjetoBean error = (ObjetoBean) cBean
								.crear(cBean.Error);
						error.cambiaValor("CAUSA_ERROR", mensaje);
						result.insertar(0, error);
						return result;
					}

					// Transformo el horario en String
					GestorHorarios GH = new GestorHorarios();
					String horario = GH.convertirHorario(beanHorario);
					// Mandar aviso a profesor

					Avisos aviso = (Avisos) cBean.crear(cBean.Avisos);
					aviso.cambiaValor(Constantes.AVISOS_ASUNTO,
							"Nuevo curso a impartir");
					aviso.cambiaValor(Constantes.AVISOS_TEXTO,
							"Le ha sido asignado el curso "
									+ beanCurso
											.dameValor(Constantes.CURSO_NOMBRE)
									+ ". \n"
									+ "Aula donde se impartirá: "
									+ beanAula
											.dameValor(Constantes.AULA_NOMBRE)
									+ ". \n" + "Horario del curso: " + horario
									+ " ");
					aviso.cambiaValor(Constantes.AVISOS_ACTIVO, "S");
					aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO, this
							.dameFecha());
					aviso.cambiaValor(Constantes.AVISOS_FECHA_CADUCUDAD, "");
					aviso.cambiaValor(Constantes.ID_ISAVISOS, "1");
					GestorAvisos gestorAvisos = new GestorAvisos();
					if (!gestorAvisos.insertarAviso(aviso)) {
						// !bdf.insertar(aviso)
						String mensaje = "Error de Base de Datos al crear Aviso";
						ObjetoBean error = (ObjetoBean) cBean
								.crear(cBean.Error);
						error.cambiaValor("CAUSA_ERROR", mensaje);
						result.insertar(0, error);
						return result;
					}
					// Crear objeto bean especifico
					Avisos_Has_Usuario ahu = (Avisos_Has_Usuario) cBean
							.crear(cBean.AvisosHasUario);
					// Relleanr bean
					aviso.cambiaValor(Constantes.ID_ISAVISOS, "");
					ListaObjetoBean l3 = gestorAvisos.consultarAvisos(aviso);
					// bdf.consultar(aviso)
					Avisos a = (Avisos) l3.dameObjeto(0);
					ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO, a
							.dameValor(Constantes.ID_ISAVISOS));
					ahu
							.cambiaValor(
									Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,
									beanCurso
											.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI));
					// Rellenar tabla intermedia de relacion Avisos-Usuario
					if (!bdf.insertar(ahu)) {
						String mensaje = "Error de Base de Datos al mandar Aviso";
						ObjetoBean error = (ObjetoBean) cBean
								.crear(cBean.Error);
						error.cambiaValor("CAUSA_ERROR", mensaje);
						result.insertar(0, error);
						return result;
					}

				} else {
					BBDDFachadaCurso bdfc = (BBDDFachadaCurso) (bdf
							.dameBBDDFachada(Constantes.FachadaCurso));
					if (bdfc.cursoYaExiste(beanCurso)) {
						String mensaje = "El curso introducido ya existe";
						ObjetoBean error = (ObjetoBean) cBean
								.crear(cBean.Error);
						error.cambiaValor("CAUSA_ERROR", mensaje);
						result.insertar(0, error);
						return result;
					} else {
						String mensaje = "Error de Base de Datos";
						ObjetoBean error = (ObjetoBean) cBean
								.crear(cBean.Error);
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

		else {
			CreadorListaObjetoBean c = new CreadorListaObjetoBean();
			result = c.crear();
			String mensaje = "Los datos seleccionados han caducado y ya no son válidos";
			ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			result.insertar(0, error);
			return result;
		}

	}

	/**
	 * Modifica el curso con los nuevos datos
	 * 
	 * @param curso
	 * @return boolean true si la operacion tiene exito. false en caso contrario
	 */
	public boolean editaCurso(ObjetoBean curso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.editar(curso);
	}

	/**
	 * Devuelve una lista de los cursos activos
	 * 
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean dameCursosActivos() {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaCurso bdfc = (BBDDFachadaCurso) (bdf
				.dameBBDDFachada(Constantes.FachadaCurso));
		return bdfc.dameCursosActivos();
	}

	/**
	 * Da de baja un curso, pone la nota de los alumnos a -2 y pasa el curso a
	 * inactivo
	 * 
	 * @param curso
	 * @return boolean true si la operacion tiene exito. false en caso contrario
	 */
	public boolean darBajaCurso(ObjetoBean curso) {
		CreadorBean creador = new CreadorBean();
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaCurso bdfc = (BBDDFachadaCurso) (bdf
				.dameBBDDFachada(Constantes.FachadaCurso));
		Profesorado profesorado = new Profesorado();
		// mando avisos a los alumnos del curso
		ListaObjetoBean listaAlum = profesorado.consultaAlumnosDeCurso(curso);
		ListaObjetoBean listaUsu = new ListaObjetoBean();
		for (int i = 0; i < listaAlum.tamanio(); i++) {
			ObjetoBean usuario = creador.crear(creador.Usuario);
			usuario.cambiaValor(Constantes.ID_ISUSUARIO_DNI, listaAlum
					.dameObjeto(i).dameValor(
							Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
			listaUsu.insertar(i, usuario);
		}
		GestorAvisos GA = new GestorAvisos();
		ObjetoBean aviso = creador.crear(creador.Avisos);
		aviso.cambiaValor(Constantes.AVISOS_ASUNTO, "Curso cancelado");
		aviso.cambiaValor(Constantes.AVISOS_TEXTO, "El curso "
				+ curso.dameValor(Constantes.CURSO_NOMBRE)
				+ " ha sido cancelado");
		GA.avisoAGrupo(listaUsu, aviso);
		// mando aviso al profesor del curso
		ObjetoBean profesor = this.consultaProfesorDeCurso(curso);
		ObjetoBean usuario = creador.crear(creador.Usuario);
		usuario.cambiaValor(Constantes.ID_ISUSUARIO_DNI, profesor
				.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI));
		listaUsu = null;
		listaUsu = new ListaObjetoBean();
		listaUsu.insertar(0, usuario);
		aviso.cambiaValor(Constantes.AVISOS_ASUNTO, "Curso cancelado");
		GA.avisoAGrupo(listaUsu, aviso);

		return bdfc.darBajaCurso(curso);
	}
}
