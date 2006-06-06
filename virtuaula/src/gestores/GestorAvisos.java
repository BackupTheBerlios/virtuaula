package gestores;

import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.BBDDFachadaAula;
import subSistemaBBDD.BBDDFachadaAviso;
import subSistemaBBDD.BBDDFachadaHorario;
import subSistemaBBDD.BBDDFachadaProfesor;
import subSistemaBBDD.utils.Constantes;
import beans.Avisos_Has_Usuario;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

/**
 * Realiza las operaciones sobre los avisos
 * 
 * @author Alberto Macho
 * 
 */
public class GestorAvisos {

	public GestorAvisos() {
		super();
	}

	/**
	 * Devuelve una lista de los avisos que tiene un usuario
	 * 
	 * @param beanUsuario
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultaAvisos(ObjetoBean beanUsuario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaAviso bdfa = (BBDDFachadaAviso) (bdf
				.dameBBDDFachada(Constantes.FachadaAviso));
		ListaObjetoBean l = bdfa.dameAvisosUsuario(beanUsuario);
		return l;
	}

	/**
	 * Borra el aviso y la relacion
	 * 
	 * @return boolean true si la operacion tiene exito. false en caso contrario
	 */
	public boolean borraAviso(ObjetoBean beanAviso, ObjetoBean usuavi) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return ((bdf.eliminar(usuavi)) && (bdf.eliminar(beanAviso)));
	}

	/**
	 * Consulta todos los avisos con las caracteristicas del aviso que le
	 * pasamos por parametro y los devuelve en una lista
	 * 
	 * @param aviso
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultarAvisos(ObjetoBean aviso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.consultar(aviso);
		return l;
	}

	/**
	 * Modifica el aviso que existiera en el sistema con el mismo identificador
	 * que el aviso que le pasamos pero cambiando todo lo demas que sea distinto
	 * 
	 * @param aviso
	 * @return boolean true o false dependiendo de si modifica correctamente el
	 *         aviso
	 */
	public boolean editarAviso(ObjetoBean aviso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.editar(aviso);

	}

	/**
	 * Inserta un aviso en el sistema
	 * 
	 * @param aviso
	 * @return boolean true si la operacion tiene exito. false en caso contrario
	 */
	public boolean insertarAviso(ObjetoBean aviso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.insertar(aviso);
	};

	/**
	 * Manda un aviso a un alumno o profesor indicandole que sus datos se han
	 * modificado bien
	 * 
	 * @param alumno
	 * @return boolean true si la operacion tiene exito. false en caso contrario
	 */
	public boolean enviarAvisoModificacionAlumno(ObjetoBean alumProf) {

		CreadorBean creador = new CreadorBean();
		BBDDFachada bdf = BBDDFachada.getInstance();
		ObjetoBean aviso = (ObjetoBean) creador.crear(creador.Avisos);
		GestorHorarios GH = new GestorHorarios();
		aviso.cambiaValor(Constantes.AVISOS_ASUNTO, "mi aviso guay"
				+ alumProf.dameValor(Constantes.ID_ISUSUARIO_DNI));
		aviso.cambiaValor(Constantes.AVISOS_TEXTO,
				"Sus datos han sido modificados correctamente por secretaria");
		aviso.cambiaValor(Constantes.AVISOS_ACTIVO, "S");
		aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO, GH.dameFecha());
		aviso.cambiaValor(Constantes.AVISOS_FECHA_CADUCUDAD, "");
		aviso.cambiaValor(Constantes.ID_ISAVISOS, "1");
		if (!bdf.insertar(aviso)) {
			return false;
		} else {
			//		 

			// Crear objeto bean especifico
			GestorAvisos GA = new GestorAvisos();
			aviso.cambiaValor(Constantes.ID_ISAVISOS, "");
			ListaObjetoBean listaav = GA.consultarAvisos(aviso);
			ObjetoBean aviso2 = listaav.dameObjeto(0);
			aviso2.cambiaValor(Constantes.AVISOS_ASUNTO, "Datos modificados");

			if (GA.editarAviso(aviso2)) {

				Avisos_Has_Usuario ahu = (Avisos_Has_Usuario) creador
						.crear(creador.AvisosHasUario);
				// Relleanar bean

				ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO, aviso2
						.dameValor(Constantes.ID_ISAVISOS));
				ahu
						.cambiaValor(
								Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,
								alumProf
										.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
				// Rellenar tabla intermedia de relacion Avisos-Usuario
				if (!bdf.insertar(ahu)) {

					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Manda un aviso al usuario indicandole que se ha matriculado de un curso
	 * diciendole cual es su profesor, su aula y su horario
	 * 
	 * @param Alumno
	 * @param Curso
	 * @return ListaObjetoBean Contiene los errores detectados
	 */
	public ListaObjetoBean alumnoSinPass(ObjetoBean Alumno, ObjetoBean Curso) {
		ListaObjetoBean liserror = new ListaObjetoBean();
		CreadorBean creador = new CreadorBean();
		BBDDFachada bdf = BBDDFachada.getInstance();
		ObjetoBean aviso = (ObjetoBean) creador.crear(creador.Avisos);
		BBDDFachadaProfesor bdfp = (BBDDFachadaProfesor) bdf
				.dameBBDDFachada(Constantes.FachadaProfesor);
		BBDDFachadaAula bdfa = (BBDDFachadaAula) bdf
				.dameBBDDFachada(Constantes.FachadaAula);
		BBDDFachadaHorario bdfh = (BBDDFachadaHorario) bdf
				.dameBBDDFachada(Constantes.FachadaHorario);
		ObjetoBean prof = bdfp.dameProfesorCurso(Curso);
		ObjetoBean aula = bdfa.dameAulaCurso(Curso);
		ObjetoBean horario = bdfh.dameHorarioCurso(Curso);
		GestorHorarios GH = new GestorHorarios();
		String hor = GH.convertirHorario(horario);
		String nombreaula = aula.dameValor(Constantes.AULA_NOMBRE);
		String nombrecurso = Curso.dameValor(Constantes.CURSO_NOMBRE);
		String nombre = prof.dameValor(Constantes.PROFESOR_NOMBRE);
		String apellido1 = prof.dameValor(Constantes.PROFESOR_APELLIDO1);
		String apellido2 = prof.dameValor(Constantes.PROFESOR_APELLIDO2);

		aviso.cambiaValor(Constantes.AVISOS_ASUNTO, "esteesmiaviso");
		aviso.cambiaValor(Constantes.AVISOS_TEXTO,
				"Se ha matriculado del curso " + nombrecurso + ".\nEl "
						+ "Profesor es " + nombre + " " + apellido1 + " "
						+ apellido2 + ". \nEl aula es " + nombreaula + ". \n"
						+ "El horario es " + hor + ".");
		aviso.cambiaValor(Constantes.AVISOS_ACTIVO, "S");
		aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO, GH.dameFecha());
		aviso.cambiaValor(Constantes.AVISOS_FECHA_CADUCUDAD, "");
		aviso.cambiaValor(Constantes.ID_ISAVISOS, "1");

		if (!bdf.insertar(aviso)) {
			String mensaje = "Error de Base de Datos al crear Aviso";
			ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			int tamaniio = liserror.tamanio();
			liserror.insertar(tamaniio, error);
			return liserror;
		} else {

			// Crear objeto bean especifico
			GestorAvisos GA = new GestorAvisos();
			aviso.cambiaValor(Constantes.ID_ISAVISOS, "");
			ListaObjetoBean listaav = GA.consultarAvisos(aviso);
			ObjetoBean aviso2 = listaav.dameObjeto(0);
			aviso2.cambiaValor(Constantes.AVISOS_ASUNTO,
					"Nuevo curso matriculado");

			if (GA.editarAviso(aviso2)) {
				Avisos_Has_Usuario ahu = (Avisos_Has_Usuario) creador
						.crear(creador.AvisosHasUario);
				// Relleanar bean

				ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO, aviso2
						.dameValor(Constantes.ID_ISAVISOS));
				ahu.cambiaValor(
						Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,
						Alumno.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
				// Rellenar tabla intermedia de relacion Avisos-Usuario
				if (!bdf.insertar(ahu)) {
					String mensaje = "Error de Base de Datos al mandar Aviso";
					ObjetoBean error = (ObjetoBean) creador
							.crear(creador.Error);
					error.cambiaValor(Constantes.CAUSA, mensaje);
					int tamanioo = liserror.tamanio();
					liserror.insertar(tamanioo, error);
					return liserror;
				}
			}
		}
		return liserror;
	}

	/**
	 * Manda un aviso de bienvenida al alumno con su usuario y contraseña
	 * 
	 * @param Alumno
	 * @param Usuario
	 * @return ListaObjetoBean Contiene los errores detectados
	 */
	public ListaObjetoBean passAlumno(ObjetoBean Alumno, ObjetoBean Usuario) {
		ListaObjetoBean liserror = new ListaObjetoBean();
		CreadorBean creador = new CreadorBean();
		BBDDFachada bdf = BBDDFachada.getInstance();
		ObjetoBean aviso = (ObjetoBean) creador.crear(creador.Avisos);
		String password = Usuario.dameValor(Constantes.USUARIO_CONTRASENIA);
		String DNI = Usuario.dameValor(Constantes.ID_ISUSUARIO_DNI);
		String nombre = Alumno.dameValor(Constantes.AREA_NOMBRE);
		String apellido = Alumno.dameValor(Constantes.ALUMNO_APELLIDO1);
		String apellido2 = Alumno.dameValor(Constantes.ALUMNO_APELLIDO2);

		aviso.cambiaValor(Constantes.AVISOS_ASUNTO, "esteesmiaviso");
		aviso.cambiaValor(Constantes.AVISOS_TEXTO, "Bienvenido a Virtuaula "
				+ nombre + " " + apellido + " " + apellido2 + ". \n"
				+ "Te indicamos a continuación tus datos de acceso: \n"
				+ "Usuario: " + DNI + " \n" + "Contraseña: " + password + " ");
		aviso.cambiaValor(Constantes.AVISOS_ACTIVO, "S");
		GestorHorarios GH = new GestorHorarios();
		aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO, GH.dameFecha());
		aviso.cambiaValor(Constantes.AVISOS_FECHA_CADUCUDAD, "");
		aviso.cambiaValor(Constantes.ID_ISAVISOS, "1");

		if (!bdf.insertar(aviso)) {
			String mensaje = "Error de Base de Datos al crear Aviso";
			ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			int tamaniio = liserror.tamanio();
			liserror.insertar(tamaniio, error);
			return liserror;
		} else {
			//		 

			// Crear objeto bean especifico
			GestorAvisos GA = new GestorAvisos();
			aviso.cambiaValor(Constantes.ID_ISAVISOS, "");
			ListaObjetoBean listaav = GA.consultarAvisos(aviso);
			ObjetoBean aviso2 = listaav.dameObjeto(0);
			aviso2.cambiaValor(Constantes.AVISOS_ASUNTO,
					"Bienvenido a Virtuaula");

			if (GA.editarAviso(aviso2)) {

				Avisos_Has_Usuario ahu = (Avisos_Has_Usuario) creador
						.crear(creador.AvisosHasUario);
				// Relleanar bean

				ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO, aviso2
						.dameValor(Constantes.ID_ISAVISOS));
				ahu.cambiaValor(
						Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,
						Alumno.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
				// Rellenar tabla intermedia de relacion Avisos-Usuario
				if (!bdf.insertar(ahu)) {
					String mensaje = "Error de Base de Datos al mandar Aviso";
					ObjetoBean error = (ObjetoBean) creador
							.crear(creador.Error);
					error.cambiaValor(Constantes.CAUSA, mensaje);
					int tamanioo = liserror.tamanio();
					liserror.insertar(tamanioo, error);
					return liserror;
				}
			}
		}
		return liserror;
	}

	/**
	 * Manda un aviso de bienvenida al profesor con su usuario y contraseña
	 * 
	 * @param profesor
	 * @param Usuario
	 * @return ListaObjetoBean Contiene los errores detectados
	 */
	public ListaObjetoBean passProfesor(ObjetoBean profesor, ObjetoBean Usuario) {
		ListaObjetoBean liserror = new ListaObjetoBean();
		CreadorBean creador = new CreadorBean();
		BBDDFachada bdf = BBDDFachada.getInstance();
		ObjetoBean aviso = (ObjetoBean) creador.crear(creador.Avisos);
		String password = Usuario.dameValor(Constantes.USUARIO_CONTRASENIA);
		String DNI = Usuario.dameValor(Constantes.ID_ISUSUARIO_DNI);
		String nombre = profesor.dameValor(Constantes.PROFESOR_NOMBRE);
		String apellido = profesor.dameValor(Constantes.PROFESOR_APELLIDO1);
		String apellido2 = profesor.dameValor(Constantes.PROFESOR_APELLIDO2);

		aviso.cambiaValor(Constantes.AVISOS_ASUNTO, "esteesmiaviso");
		aviso.cambiaValor(Constantes.AVISOS_TEXTO, "Bienvenido a Virtuaula "
				+ nombre + " " + apellido + " " + apellido2 + ". \n"
				+ "Te indicamos a continuación tus datos de acceso: \n"
				+ "Usuario: " + DNI + " \n" + "Contraseña: " + password + " ");
		aviso.cambiaValor(Constantes.AVISOS_ACTIVO, "S");
		GestorHorarios GH = new GestorHorarios();
		aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO, GH.dameFecha());
		aviso.cambiaValor(Constantes.AVISOS_FECHA_CADUCUDAD, "");
		aviso.cambiaValor(Constantes.ID_ISAVISOS, "1");

		if (!bdf.insertar(aviso)) {
			String mensaje = "Error de Base de Datos al crear Aviso";
			ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			int tamaniio = liserror.tamanio();
			liserror.insertar(tamaniio, error);
			return liserror;
		} else {

			// Crear objeto bean especifico
			GestorAvisos GA = new GestorAvisos();
			aviso.cambiaValor(Constantes.ID_ISAVISOS, "");
			ListaObjetoBean listaav = GA.consultarAvisos(aviso);
			ObjetoBean aviso2 = listaav.dameObjeto(0);
			aviso2.cambiaValor(Constantes.AVISOS_ASUNTO,
					"Bienvenido a Virtuaula");

			if (GA.editarAviso(aviso2)) {

				Avisos_Has_Usuario ahu = (Avisos_Has_Usuario) creador
						.crear(creador.AvisosHasUario);
				// Relleanar bean

				ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO, aviso2
						.dameValor(Constantes.ID_ISAVISOS));
				ahu
						.cambiaValor(
								Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,
								profesor
										.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI));
				// Rellenar tabla intermedia de relacion Avisos-Usuario
				if (!bdf.insertar(ahu)) {
					String mensaje = "Error de Base de Datos al mandar Aviso";
					ObjetoBean error = (ObjetoBean) creador
							.crear(creador.Error);
					error.cambiaValor(Constantes.CAUSA, mensaje);
					int tamanioo = liserror.tamanio();
					liserror.insertar(tamanioo, error);
					return liserror;
				}
			}
		}
		return liserror;
	}

	/**
	 * Manda un aviso a todos los contables con informacion sobre la
	 * contratacion de un profesor con la informacion de la nomina y del
	 * contrato
	 * 
	 * @param profesor
	 * @param contrato
	 * @param nomina
	 * @return ListaObjetoBean Contiene los errores detectados
	 * 
	 */
	public ListaObjetoBean avisoContables(ObjetoBean profesor,
			ObjetoBean contrato, ObjetoBean nomina) {
		ListaObjetoBean liserror = new ListaObjetoBean();
		CreadorBean creador = new CreadorBean();
		BBDDFachada bdf = BBDDFachada.getInstance();
		ObjetoBean aviso = (ObjetoBean) creador.crear(creador.Avisos);
		String DNI = profesor.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI);
		String nombre = profesor.dameValor(Constantes.PROFESOR_NOMBRE);
		String apellido = profesor.dameValor(Constantes.PROFESOR_APELLIDO1);
		String apellido2 = profesor.dameValor(Constantes.PROFESOR_APELLIDO2);

		// Creamos el aviso
		aviso.cambiaValor(Constantes.AVISOS_ASUNTO, "esteesmiaviso");
		aviso.cambiaValor(Constantes.AVISOS_TEXTO,
				"Incorporación de personal. \nDatos personales: \nDNI:" + DNI
						+ " " + nombre + " " + apellido + " " + apellido2 + "."
						+ "\nSueldo: "
						+ nomina.dameValor(Constantes.NOMINA_CANTIDAD) + ".\n"
						+ "Cuenta de ingresos: "
						+ nomina.dameValor(Constantes.NOMINA_CUENTA_INGRESOS)
						+ ". \n" + "Tipo de contrato: "
						+ contrato.dameValor(Constantes.CONTRATO_TIPO) + ".");
		aviso.cambiaValor(Constantes.AVISOS_ACTIVO, "S");
		GestorHorarios GH = new GestorHorarios();
		aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO, GH.dameFecha());
		aviso.cambiaValor(Constantes.AVISOS_FECHA_CADUCUDAD, "");
		aviso.cambiaValor(Constantes.ID_ISAVISOS, "1");

		// Consultamos todos los contables que hay en la empresa para mandarles
		// el aviso
		ObjetoBean usuario = creador.crear(creador.Usuario);
		usuario.cambiaValor(Constantes.USUARIO_PERFIL, "contable");
		ListaObjetoBean listacontables = bdf.consultar(usuario);
		int numcontables = listacontables.tamanio();
		// mandamos el aviso a todos los contables del sistema
		for (int i = 0; i < numcontables; i++) {

			if (!bdf.insertar(aviso)) {
				String mensaje = "Error de Base de Datos al crear Aviso";
				ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
				error.cambiaValor(Constantes.CAUSA, mensaje);
				int tamaniio = liserror.tamanio();
				liserror.insertar(tamaniio, error);
				return liserror;
			} else { // si se ha insertado el aviso correctamente

				// Crear objeto bean especifico
				GestorAvisos GA = new GestorAvisos();
				aviso.cambiaValor(Constantes.ID_ISAVISOS, "");
				ListaObjetoBean listaav = GA.consultarAvisos(aviso);
				ObjetoBean aviso2 = listaav.dameObjeto(0);
				aviso2.cambiaValor(Constantes.AVISOS_ASUNTO,
						"Personal contratado");

				if (GA.editarAviso(aviso2)) {

					Avisos_Has_Usuario ahu = (Avisos_Has_Usuario) creador
							.crear(creador.AvisosHasUario);

					// Relleanar bean
					ObjetoBean usuar = listacontables.dameObjeto(i);

					ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO,
							aviso2.dameValor(Constantes.ID_ISAVISOS));
					ahu.cambiaValor(
							Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,
							usuar.dameValor(Constantes.ID_ISUSUARIO_DNI));
					// Rellenar tabla intermedia de relacion Avisos-Usuario
					if (!bdf.insertar(ahu)) {
						String mensaje = "Error de Base de Datos al mandar Aviso";
						ObjetoBean error = (ObjetoBean) creador
								.crear(creador.Error);
						error.cambiaValor(Constantes.CAUSA, mensaje);
						int tamanioo = liserror.tamanio();
						liserror.insertar(tamanioo, error);
						return liserror;
					}
				}
			}// fin else
		}// fin del for

		return liserror;

	}

	/**
	 * Manda un aviso a todos los secretarios con informacion sobre la
	 * contratacion de un profesor con sus datos y los de su area
	 * 
	 * @param profesor
	 * @return ListaObjetoBean Contiene los errores detectados
	 */
	public ListaObjetoBean avisoSecretarios(ObjetoBean profesor) {
		ListaObjetoBean liserror = new ListaObjetoBean();
		CreadorBean creador = new CreadorBean();
		BBDDFachada bdf = BBDDFachada.getInstance();
		// saco los datos del profesor
		ObjetoBean aviso = (ObjetoBean) creador.crear(creador.Avisos);
		String DNI = profesor.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI);
		String nombre = profesor.dameValor(Constantes.PROFESOR_NOMBRE);
		String apellido = profesor.dameValor(Constantes.PROFESOR_APELLIDO1);
		String apellido2 = profesor.dameValor(Constantes.PROFESOR_APELLIDO2);
		// consigo el area del profesor
		String idarea = profesor.dameValor(Constantes.PROFESOR_ISAREA_IDISAREA);
		ObjetoBean area = creador.crear(creador.Area);
		area.cambiaValor(Constantes.ID_ISAREA, idarea);
		GestorAreas gestorAreas = new GestorAreas();
		ListaObjetoBean listarea = gestorAreas.consultaArea(area);
		// como solo me va a devolver un area cojo el primer elemento
		area = listarea.dameObjeto(0);
		// Creamos el aviso
		aviso.cambiaValor(Constantes.AVISOS_ASUNTO, "esteesmiaviso");
		aviso.cambiaValor(Constantes.AVISOS_TEXTO,
				"Incorporación de personal. \nDatos personales: \nDNI:" + DNI
						+ " \nNombre: " + nombre + " " + apellido + " "
						+ apellido2 + "." + "\nTelefono: "
						+ profesor.dameValor(Constantes.PROFESOR_TELEFONO)
						+ "\n" + "Email: "
						+ profesor.dameValor(Constantes.PROFESOR_TELEFONO)
						+ ". \n" + "Area tecnológica:"
						+ area.dameValor(Constantes.AREA_NOMBRE) + ".");
		aviso.cambiaValor(Constantes.AVISOS_ACTIVO, "S");
		GestorHorarios GH = new GestorHorarios();
		aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO, GH.dameFecha());
		aviso.cambiaValor(Constantes.AVISOS_FECHA_CADUCUDAD, "");
		aviso.cambiaValor(Constantes.ID_ISAVISOS, "1");

		// Consultamos todos los contables que hay en la empresa para mandarles
		// el aviso
		ObjetoBean usuario = creador.crear(creador.Usuario);
		usuario.cambiaValor(Constantes.USUARIO_PERFIL, "secretaria");
		ListaObjetoBean listacontables = bdf.consultar(usuario);
		int numsecretarios = listacontables.tamanio();
		// mandamos el aviso a todos los contables del sistema
		for (int i = 0; i < numsecretarios; i++) {

			if (!bdf.insertar(aviso)) {
				String mensaje = "Error de Base de Datos al crear Aviso";
				ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
				error.cambiaValor(Constantes.CAUSA, mensaje);
				int tamaniio = liserror.tamanio();
				liserror.insertar(tamaniio, error);
				return liserror;
			} else { // si se ha insertado el aviso correctamente

				// Crear objeto bean especifico
				GestorAvisos GA = new GestorAvisos();
				aviso.cambiaValor(Constantes.ID_ISAVISOS, "");
				ListaObjetoBean listaav = GA.consultarAvisos(aviso);
				ObjetoBean aviso2 = listaav.dameObjeto(0);
				aviso2.cambiaValor(Constantes.AVISOS_ASUNTO, "Nuevo Profesor");

				if (GA.editarAviso(aviso2)) {

					Avisos_Has_Usuario ahu = (Avisos_Has_Usuario) creador
							.crear(creador.AvisosHasUario);

					// Relleanar bean
					ObjetoBean usuar = listacontables.dameObjeto(i);

					ahu.cambiaValor(Constantes.ID_ISAVISOS_HAS_ISUSUARIO,
							aviso2.dameValor(Constantes.ID_ISAVISOS));
					ahu.cambiaValor(
							Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,
							usuar.dameValor(Constantes.ID_ISUSUARIO_DNI));
					// Rellenar tabla intermedia de relacion Avisos-Usuario
					if (!bdf.insertar(ahu)) {
						String mensaje = "Error de Base de Datos al mandar Aviso";
						ObjetoBean error = (ObjetoBean) creador
								.crear(creador.Error);
						error.cambiaValor(Constantes.CAUSA, mensaje);
						int tamanioo = liserror.tamanio();
						liserror.insertar(tamanioo, error);
						return liserror;
					}
				}
			}// fin else
		}// fin del for

		return liserror;

	}

	/**
	 * Devuelve el numero de avisos sin leer de un usuario
	 * 
	 * @param beanUsuario
	 * @return int
	 */
	public int numeroAvisosNuevos(ObjetoBean beanUsuario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaAviso bdfa = (BBDDFachadaAviso) (bdf
				.dameBBDDFachada(Constantes.FachadaAviso));
		ListaObjetoBean l = bdfa.dameAvisosNuevosUsuario(beanUsuario);

		return l.tamanio();
	}

	/**
	 * Manda un aviso a un grupo de usuarios contenidos en la listaObjetoBean
	 * 
	 * @param grupo
	 *            de usuarios a los que mandamos el mensaje
	 * @param aviso
	 *            que queremos mandar
	 * @return ListaObjetoBean Contiene los errores detectados
	 */
	public ListaObjetoBean avisoAGrupo(ListaObjetoBean grupo, ObjetoBean aviso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean creador = new CreadorBean();
		GestorHorarios GH = new GestorHorarios();
		ListaObjetoBean liserror = new ListaObjetoBean();
		aviso.cambiaValor(Constantes.AVISOS_FECHA_AVISO, GH.dameFecha());
		int numDest = grupo.tamanio();
		String asunto = aviso.dameValor(Constantes.AVISOS_ASUNTO);
		aviso.cambiaValor(Constantes.AVISOS_ACTIVO, "S");
		aviso.cambiaValor(Constantes.AVISOS_ASUNTO, "esteesmiaviso");
		// comprobar que la longitud del texto es menor que 255
		if (aviso.dameValor(Constantes.AVISOS_TEXTO).length() > 250) {
			String mensaje = "La longitud del texto no pede superar los 250 caracteres";
			ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			int tamaniio = liserror.tamanio();
			liserror.insertar(tamaniio, error);

		} else {// la longitud del aviso es la permitirda
			if (numDest > 0) {
				for (int i = 0; i < numDest; i++) {// insertar el aviso y
					// asignarlo al usuario
					// correspondiente
					Integer in = new Integer(i);
					String clav = in.toString();
					aviso.cambiaValor(Constantes.ID_ISAVISOS, clav);
					if (!bdf.insertar(aviso)) {
						String mensaje = "Error de Base de Datos al crear Aviso";
						ObjetoBean error = (ObjetoBean) creador
								.crear(creador.Error);
						error.cambiaValor(Constantes.CAUSA, mensaje);
						int tamaniio = liserror.tamanio();
						liserror.insertar(tamaniio, error);
						// return liserror;
					} else { // si se ha insertado el aviso correctamente

						// Crear objeto bean especifico
						GestorAvisos GA = new GestorAvisos();
						aviso.cambiaValor(Constantes.ID_ISAVISOS, "");
						ListaObjetoBean listaav = GA.consultarAvisos(aviso);
						ObjetoBean aviso2 = listaav.dameObjeto(0);
						aviso2.cambiaValor(Constantes.AVISOS_ASUNTO, asunto);

						if (GA.editarAviso(aviso2)) {

							Avisos_Has_Usuario ahu = (Avisos_Has_Usuario) creador
									.crear(creador.AvisosHasUario);

							// Relleanar bean
							ObjetoBean usuar = grupo.dameObjeto(i);

							ahu.cambiaValor(
									Constantes.ID_ISAVISOS_HAS_ISUSUARIO,
									aviso2.dameValor(Constantes.ID_ISAVISOS));
							ahu
									.cambiaValor(
											Constantes.ID_ISAVISOS_HAS_ISUSUARIO_ISUSUARIO_DNI,
											usuar
													.dameValor(Constantes.ID_ISUSUARIO_DNI));
							// Rellenar tabla intermedia de relacion
							// Avisos-Usuario
							if (!bdf.insertar(ahu)) {
								String mensaje = "Error de Base de Datos al mandar Aviso";
								ObjetoBean error = (ObjetoBean) creador
										.crear(creador.Error);
								error.cambiaValor(Constantes.CAUSA, mensaje);
								int tamanioo = liserror.tamanio();
								liserror.insertar(tamanioo, error);
								// return liserror;
							}
						}
					}// fin else

				}
			}
		}
		return liserror;
	}

}
