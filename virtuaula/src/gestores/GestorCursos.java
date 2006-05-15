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
	
	public Area consultaAreaDeCurso(ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.dameAreaCurso(beanCurso);
	}
	
	public Horario consultaHorarioDeCurso(ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.dameHorarioCurso(beanCurso);
	}
	
	public Aula consultaAulaDeCurso(ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.dameAulaCurso(beanCurso);
	}
	
	public Profesor consultaProfesorDeCurso(ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.dameProfesorCurso(beanCurso);
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
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			l.insertar(i, error);
			i++;
		}

		if (bean.dameValor(Constantes.CURSO_ISAREA_IDISAREA).equals("")) {
			mensaje = "El campo area no ha sido rellenado";
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			l.insertar(i, error);
			i++;
		}

		if (bean.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI)
				.equals("")) {
			mensaje = "El campo dni profesor no ha sido rellenado";
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			l.insertar(i, error);
			i++;
		}

		/*
		 * if (bean.dameValor(Constantes.TABLA_CURSO).equals("")) { mensaje =
		 * "Campo tabla curso vacia"; Error error = (Error) cBean.crear(14);
		 * error.cambiaValor("CAUSA_ERROR", mensaje); l.insertar(i, error); i++; }
		 */

		if (bean.dameValor(Constantes.ID_ISCURSO_IDISCURSO).equals("")) {
			mensaje = "Campo curso vacio";
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			l.insertar(i, error);
			i++;
		}

		/*
		 * if (bean.dameValor(Constantes.CURSO_PRECIO).equals("")) { mensaje =
		 * "El campo precio no ha sido rellenado"; Error error = (Error)
		 * cBean.crear(14); error.cambiaValor("CAUSA_ERROR", mensaje);
		 * l.insertar(i, error); i++; } if
		 * (bean.dameValor(Constantes.CURSO_ESTADO).equals("")) { mensaje = "El
		 * campo estado no ha sido rellenado"; Error error = (Error)
		 * cBean.crear(14); error.cambiaValor("CAUSA_ERROR", mensaje);
		 * l.insertar(i, error); i++; } if
		 * (bean.dameValor(Constantes.CURSO_NUMERO_PLAZAS).equals("")) { mensaje =
		 * "El campo numero de plazas no ha sido rellenado"; Error error =
		 * (Error) cBean.crear(14); error.cambiaValor("CAUSA_ERROR", mensaje);
		 * l.insertar(i, error); i++; } if
		 * (bean.dameValor(Constantes.CURSO_FECHA_INICIO).equals("")) { mensaje =
		 * "El campo fecha de inicio no ha sido rellenado"; Error error =
		 * (Error) cBean.crear(14); error.cambiaValor("CAUSA_ERROR", mensaje);
		 * l.insertar(i, error); i++; } if
		 * (bean.dameValor(Constantes.CURSO_FECHA_FIN).equals("")) { mensaje =
		 * "El campo fecha de fin no ha sido rellenado"; Error error = (Error)
		 * cBean.crear(14); error.cambiaValor("CAUSA_ERROR", mensaje);
		 * l.insertar(i, error); i++; }
		 */

		// comprobar que la fecha de inicio no supera a la fecha de fin
		// formato de fecha xx/xx/xxxx
		int dia1 = 0;
		int dia2 = 0;
		int mes1 = 0;
		int mes2 = 0;
		int annio1 = 0;
		int annio2 = 0;

		if (!bean.dameValor(Constantes.CURSO_FECHA_INICIO).equals("")) {
			String fechaInicio = bean.dameValor(Constantes.CURSO_FECHA_INICIO);
			try {
				dia1 = Integer.parseInt(fechaInicio.substring(0, 1));
				if ((dia1 < 1) || (dia1 > 31)) {
					mensaje = "Formato de fecha inicio incorrecto";
					Error error = (Error) cBean.crear(14);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					l.insertar(i, error);
					i++;
				}
			} catch (Exception e) {
				// No es número
				mensaje = "Formato de fecha inicio incorrecto";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				l.insertar(i, error);
				i++;
			}
			try {
				mes1 = Integer.parseInt(fechaInicio.substring(3, 4));
				if ((mes1 < 1) || (mes1 > 12)) {
					mensaje = "Formato de fecha inicio incorrecto";
					Error error = (Error) cBean.crear(14);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					l.insertar(i, error);
					i++;
				}
			} catch (Exception e) {
				// No es número
				mensaje = "Formato de fecha inicio incorrecto";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				l.insertar(i, error);
				i++;
			}
			try {
				annio1 = Integer.parseInt(fechaInicio.substring(6, 9));
				if ((annio1 < 0000) || (annio1 > 9999)) {
					mensaje = "Formato de fecha inicio incorrecto";
					Error error = (Error) cBean.crear(14);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					l.insertar(i, error);
					i++;
				}
			} catch (Exception e) {
				// No es número
				mensaje = "Formato de fecha inicio incorrecto";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				l.insertar(i, error);
				i++;
			}
		}
		if (!bean.dameValor(Constantes.CURSO_FECHA_FIN).equals("")) {
			String fechaFin = bean.dameValor(Constantes.CURSO_FECHA_FIN);
			try {
				dia2 = Integer.parseInt(fechaFin.substring(0, 1));
				if ((dia2 < 0) || (dia2 > 31)) {
					mensaje = "Formato de fecha fin incorrecto";
					Error error = (Error) cBean.crear(14);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					l.insertar(i, error);
					i++;
				}
			} catch (Exception e) {
				// No es número
				mensaje = "Formato de fecha fin incorrecto";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				l.insertar(i, error);
				i++;
			}
			try {
				mes2 = Integer.parseInt(fechaFin.substring(3, 4));
				if ((mes2 < 1) || (mes2 > 12)) {
					mensaje = "Formato de fecha inicio incorrecto";
					Error error = (Error) cBean.crear(14);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					l.insertar(i, error);
					i++;
				}
			} catch (Exception e) {
				// No es número
				mensaje = "Formato de fecha inicio incorrecto";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				l.insertar(i, error);
				i++;
			}
			try {
				annio2 = Integer.parseInt(fechaFin.substring(6, 9));
				if ((annio2 < 0000) || (annio2 > 9999)) {
					mensaje = "Formato de fecha inicio incorrecto";
					Error error = (Error) cBean.crear(14);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					l.insertar(i, error);
					i++;
				}
			} catch (Exception e) {
				// No es número
				mensaje = "Formato de fecha inicio incorrecto";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				l.insertar(i, error);
				i++;
			}
		}

		boolean fechasValidas = false;
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
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			l.insertar(i, error);
			i++;
		}
		// comprobar que los campos numericos no contienen letras
		try {
			int numerico = Integer.parseInt(bean
					.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI));
			if (numerico < 0) {
				mensaje = "El campo DNI tiene un valor incorrecto";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				l.insertar(i, error);
				i++;
			}
		} catch (Exception e) {
			// No es número
			mensaje = "El campo DNI debe ser numérico";
			Error error = (Error) cBean.crear(14);
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
					Error error = (Error) cBean.crear(14);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					l.insertar(i, error);
					i++;
				}
			} catch (Exception e) {
				// No es número
				mensaje = "El campo numero de plazas debe ser numérico";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				l.insertar(i, error);
				i++;
			}
		}
		if (!bean.dameValor(Constantes.CURSO_PRECIO).equals("")) {
			try {
				int numerico = Integer.parseInt(bean
						.dameValor(Constantes.CURSO_PRECIO));
				if (numerico < 0) {
					mensaje = "El campo precio tiene un valor incorrecto";
					Error error = (Error) cBean.crear(14);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					l.insertar(i, error);
					i++;
				}
			} catch (Exception e) {
				// No es número
				mensaje = "El campo precio debe ser numérico";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				l.insertar(i, error);
				i++;
			}
		}

		return l;
	}

	public ListaObjetoBean insertarCurso(ObjetoBean beanCurso,
			ObjetoBean beanAula, ObjetoBean beanHorario) {
		
		ListaObjetoBean result = comprobar(beanCurso);
		CreadorBean cBean = new CreadorBean();
		
		if (result.esVacio()) {
			BBDDFachada bdf = BBDDFachada.getInstance();
			if (bdf.insertar(beanCurso)) {
				// Crear objeto bean especifico
				Horario_Has_Aula hha = (Horario_Has_Aula) cBean.crear(9);
				//Relleanr bean
				hha.cambiaValor(Constantes.ID_HAS_ISHORARIO_IDISHORARIO,beanHorario.dameValor(Constantes.ID_ISHORARIO));
				hha.cambiaValor(Constantes.ID_HAS_ISAULA_IDISAULA,beanAula.dameValor(Constantes.ID_ISAULA));
				hha.cambiaValor(Constantes.ISHORARIO_HAS_ISAULA_ISCURSO_IDISCURSO,beanCurso.dameValor(Constantes.ID_ISCURSO_IDISCURSO));
				// Rellenar tabla intermedia de relacion Horario-Aula
				if(!bdf.insertar(hha)){
					String mensaje = "Error de Base de Datos";
					Error error = (Error) cBean.crear(14);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					result.insertar(0, error);
					return result;
				}
			} else {
				if (false){//cursoYaExiste(beanCurso){
					String mensaje = "El curso introducido ya existe";
					Error error = (Error) cBean.crear(14);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					result.insertar(0, error);
					return result;
				}else{
					String mensaje = "Error de Base de Datos";
					Error error = (Error) cBean.crear(14);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					result.insertar(0, error);
					return result;
				}				
			}
			return null;
		}

		return result;
	}

}
