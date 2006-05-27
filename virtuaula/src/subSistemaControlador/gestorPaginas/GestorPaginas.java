/**
 * 
 */
package subSistemaControlador.gestorPaginas;

import java.util.HashMap;


public class GestorPaginas {

	private HashMap mapSecretaria;
	private HashMap mapProfesor;
	private HashMap mapPublico;
	private HashMap mapContable;
	private HashMap mapRRHH;
	private HashMap mapAlumno;
	
	/**
	 * Inicializa los atributos de la clase
	 *
	 */
	public GestorPaginas() {
		mapSecretaria = new HashMap ();
		mapProfesor = new HashMap ();
		mapPublico = new HashMap ();
		mapContable = new HashMap ();
		mapRRHH = new HashMap ();
		mapAlumno = new HashMap ();
	}
	
	
	/**
	 * Retorna la ruta que dependiendo de los parametros introducidos tiene que ir el control.
	 * 
	 * @param tipoUsuario Rol de usuario validado en el sistema
	 * @param operacion Operacion pulsada en el JSP.
	 * @param operacionResultado Resultado de la operacion.
	 * @return Pagina siguiente que se tiene que mostrar.
	 */
	public String damePaginaSig (String tipoUsuario, String operacion, String operacionResultado) {
	
		String paginaSig = "";		
		if (tipoUsuario.equals("secretaria")) {
			paginaSig = (String) this.mapSecretaria.get(operacion.concat(operacionResultado));
		}
		
		if (tipoUsuario.equals("profesor")) {
			paginaSig = (String) this.mapProfesor.get(operacion.concat(operacionResultado));
		}
		
		if (tipoUsuario.equals("publico")) {
			paginaSig = (String) this.mapPublico.get(operacion.concat(operacionResultado));
		}
		
		if (tipoUsuario.equals("contable")) {
			paginaSig = (String) this.mapContable.get(operacion.concat(operacionResultado));
		}
		
		if (tipoUsuario.equals("rrhh")) {
			paginaSig = (String) this.mapRRHH.get(operacion.concat(operacionResultado));
		}
		if (tipoUsuario.equals("alumno")) {
			paginaSig = (String) this.mapAlumno.get(operacion.concat(operacionResultado));
		}
	
		return paginaSig;
		
	}
	
	
	
	/**
	 * Añade una pagina al gestor.
	 * 
	 * @param tipoUsuario Rol de usuario validado en el sistema.
	 * @param operacion Operacion pulsada en el JSP.
	 * @param operacionResultado Resultado de la operación.
	 * @param paginaSig Pagina siguiente que tendrá que mostrar
	 */
	public void agregarPaginas (String tipoUsuario, String operacion, String operacionResultado, String paginaSig) {
		
		if (tipoUsuario.equals("secretaria")) {
			this.mapSecretaria.put(operacion.concat(operacionResultado), paginaSig);
		}
		
		if (tipoUsuario.equals("profesor")) {
			this.mapProfesor.put(operacion.concat(operacionResultado), paginaSig);
		}
		
		if (tipoUsuario.equals("publico")) {
			this.mapPublico.put(operacion.concat(operacionResultado), paginaSig);
		}
		
		if (tipoUsuario.equals("contable")) {
			this.mapContable.put(operacion.concat(operacionResultado), paginaSig);
		}
		
		if (tipoUsuario.equals("rrhh")) {
			this.mapRRHH.put(operacion.concat(operacionResultado), paginaSig);
		}
		if (tipoUsuario.equals("alumno")) {
			this.mapAlumno.put(operacion.concat(operacionResultado), paginaSig);
		}
	}
	/**
	 * Inicializa el redireccionamiento de cada una de las paginas con respecto a las operaciones, operaciones resultado de los controladores
	 * y perfil de usuario.
	 *
	 */
	public void inializarGestorPaginas(){
		//sesion anonima
		agregarPaginas("publico","OFERTA_FORMATIVA","OK","/virtuaula/pages/publico/ofertaFormativa.jsp");
		agregarPaginas("publico","OFERTA_FORMATIVA","ERROR","/virtuaula/pages/publico/errorOfertaFormativa.jsp");
		agregarPaginas("publico","ZONA_RESTRINGIDA","SIG","/virtuaula/pages/controlAcceso/index.jsp");
		agregarPaginas("publico","PRINCIPAL_PUBLICO","SIG","/virtuaula/index.jsp");
		//sesion secretaria
		agregarPaginas("secretaria","LOGAR","SIG","/virtuaula/pages/secretaria/index.jsp");
		agregarPaginas("secretaria","menuPrincipalSec","SIG","/virtuaula/pages/secretaria/index.jsp");
		agregarPaginas("secretaria","desconectar","SIG","/virtuaula/index.jsp");
		//secretaria cosulta profesor
		agregarPaginas("secretaria","CONS_PROF","OK","/virtuaula/pages/secretaria/profesor/consultar/seleccionarProfesor.jsp");
		agregarPaginas("secretaria","CONS_PROF","ERROR","/virtuaula/pages/secretaria/profesor/consultar/errorConsultarProfesor.jsp");
		agregarPaginas("secretaria","GES_PROF","SIG","/virtuaula/pages/secretaria/profesor/index.jsp");
		agregarPaginas("secretaria","INI_CONS_PROF","OK","/virtuaula/pages/secretaria/profesor/consultar/buscarProfesor.jsp");
		agregarPaginas("secretaria","INI_CONS_PROF","ERROR","/virtuaula/pages/secretaria/profesor/consultar/errorConsultarProfesor.jsp");
		agregarPaginas("secretaria","MOSTRAR_PROF","OK","/virtuaula/pages/secretaria/profesor/consultar/informacionProfesor.jsp");
		
		
		//secretaria cosulta curso
		agregarPaginas("secretaria","CONS_CUR","OK","/virtuaula/pages/secretaria/curso/consultar/seleccionarCurso.jsp");
		agregarPaginas("secretaria","CONS_CUR","ERROR","/virtuaula/pages/secretaria/curso/consultar/errorConsultarCurso.jsp");
		agregarPaginas("secretaria","GES_CUR","SIG","/virtuaula/pages/secretaria/curso/index.jsp");
		agregarPaginas("secretaria","INI_CONS_CUR","OK","/virtuaula/pages/secretaria/curso/consultar/buscarCurso.jsp");
		agregarPaginas("secretaria","INI_CONS_CUR","ERROR","/virtuaula/pages/secretaria/curso/consultar/errorConsultarCurso.jsp");
		agregarPaginas("secretaria","MOSTRAR_CUR","OK","/virtuaula/pages/secretaria/curso/consultar/informacionCurso.jsp");
		agregarPaginas("secretaria","MOSTRAR_CUR","ERROR","/virtuaula/pages/secretaria/curso/consultar/informacionCurso.jsp");
		
		//secretaria da de baja un curso
		agregarPaginas("secretaria","BAJA_CONS_CUR","OK","/virtuaula/pages/secretaria/curso/baja/bajaseleccionarCurso.jsp");
		agregarPaginas("secretaria","BAJA_CONS_CUR","ERROR","/virtuaula/pages/secretaria/curso/baja/bajaerrorConsultarCurso.jsp");
		agregarPaginas("secretaria","GES_CUR","SIG","/virtuaula/pages/secretaria/curso/index.jsp");
		agregarPaginas("secretaria","BAJA_INI_CONS_CUR","OK","/virtuaula/pages/secretaria/curso/baja/bajabuscarCurso.jsp");
		agregarPaginas("secretaria","BAJA_INI_CONS_CUR","ERROR","/virtuaula/pages/secretaria/curso/baja/bajaerrorConsultarCurso.jsp");
		agregarPaginas("secretaria","BAJA_MOSTRAR_CUR","OK","/virtuaula/pages/secretaria/curso/baja/bajainformacionCurso.jsp");
		agregarPaginas("secretaria","BAJA_MOSTRAR_CUR","ERROR","/virtuaula/pages/secretaria/curso/baja/bajainformacionCurso.jsp");
		agregarPaginas("secretaria","BAJA_DEF_CURSO","OK","/virtuaula/pages/secretaria/curso/baja/confirmacionBajaCurso.jsp");
		agregarPaginas("secretaria","BAJA_DEF_CURSO","ERROR","/virtuaula/pages/secretaria/curso/baja/bajaerrorConsultarCurso.jsp");
		
		//secretaria matricular alumno
		agregarPaginas("secretaria","GES_ALUM","SIG","/virtuaula/pages/secretaria/alumno/index.jsp");
		agregarPaginas("secretaria","MAT_ALUM_DOS","SIG","/virtuaula/pages/secretaria/alumno/insertar/iniMatricularAlumno.jsp");
		agregarPaginas("secretaria","MAT_ALUM","OK","/virtuaula/pages/secretaria/alumno/insertar/seleccCursoMatricularAlumno.jsp");
		agregarPaginas("secretaria","MAT_ALUM","ERROR","/virtuaula/pages/secretaria/alumno/insertar/iniMatricularAlumno.jsp");
		agregarPaginas("secretaria","MAT_ALUM_CUR","OK","/virtuaula/pages/secretaria/alumno/insertar/insertarAlumno.jsp");
		agregarPaginas("secretaria","MAT_ALUM_CUR","ERROR","/virtuaula/pages/secretaria/alumno/insertar/seleccCursoMatricularAlumno.jsp");
		agregarPaginas("secretaria","MATRICULA","OK","/virtuaula/pages/secretaria/alumno/index.jsp");
		agregarPaginas("secretaria","MATRICULA","ERROR","/virtuaula/pages/secretaria/alumno/insertar/iniMatricularAlumno.jsp");
		
		//secretaria consultar alumno
		agregarPaginas("secretaria","CONS_ALUM","OK","/virtuaula/pages/secretaria/alumno/consultar/buscarAlumno.jsp");
		agregarPaginas("secretaria","CONS_ALUM","ERROR","/virtuaula/pages/secretaria/alumno/consultar/errorConsultarAlumno.jsp");
		agregarPaginas("secretaria","MOSTRAR_ALUM","OK","/virtuaula/pages/secretaria/alumno/consultar/informacionAlumno.jsp");
		agregarPaginas("secretaria","MOSTRAR_ALUM","ERROR","/virtuaula/pages/secretaria/alumno/consultar/errorConsultarAlumno.jsp");
		agregarPaginas("secretaria","CONS_ALUM2","OK","/virtuaula/pages/secretaria/alumno/consultar/seleccionarAlumno.jsp");
		agregarPaginas("secretaria","CONS_ALUM2","ERROR","/virtuaula/pages/secretaria/alumno/consultar/errorConsultarAlumno.jsp");
		agregarPaginas("secretaria","VUELTA_ALUM","SIG","/virtuaula/pages/secretaria/alumno/consultar/buscarAlumno.jsp");
		//secretaria insercion curso
		agregarPaginas("secretaria","GES_CUR","SIG","/virtuaula/pages/secretaria/curso/index.jsp");
		agregarPaginas("secretaria","INI_INS_CUR","SIG","/virtuaula/pages/secretaria/curso/insertar/iniInsertarCurso.jsp");
		agregarPaginas("secretaria","INS_CUR_HOR","OK","/virtuaula/pages/secretaria/curso/insertar/seleccHorarioInsertarCurso.jsp");
		agregarPaginas("secretaria","INS_CUR_HOR","ERROR","/virtuaula/pages/secretaria/curso/insertar/iniInsertarCurso.jsp");
		agregarPaginas("secretaria","INS_CUR_AREA","OK","/virtuaula/pages/secretaria/curso/insertar/seleccAreaInsertarCurso.jsp");
		agregarPaginas("secretaria","INS_CUR_AREA","ERROR","/virtuaula/pages/secretaria/curso/insertar/seleccHorarioInsertarCurso.jsp");
		agregarPaginas("secretaria","INS_CUR_AULA","OK","/virtuaula/pages/secretaria/curso/insertar/seleccAulaInsertarCurso.jsp");
		agregarPaginas("secretaria","INS_CUR_AULA","ERROR","/virtuaula/pages/secretaria/curso/insertar/seleccHorarioInsertarCurso.jsp");
		agregarPaginas("secretaria","INS_CUR_AULA","ERROR2","/virtuaula/pages/secretaria/curso/insertar/seleccAreaInsertarCurso.jsp");
		agregarPaginas("secretaria","INS_CUR_PROF","OK","/virtuaula/pages/secretaria/curso/insertar/seleccProfesorInsertarCurso.jsp");
		agregarPaginas("secretaria","INS_CUR_PROF","ERROR","/virtuaula/pages/secretaria/curso/insertar/seleccAulaInsertarCurso.jsp");
		agregarPaginas("secretaria","INSERTA_CURSO","OK","/virtuaula/pages/secretaria/curso/insertar/insertarCurso.jsp");
		agregarPaginas("secretaria","INSERTA_CURSO","ERROR","/virtuaula/pages/secretaria/curso/insertar/iniInsertarCurso.jsp");
		agregarPaginas("secretaria","INS_CUR_CON_PROF","SIG","/virtuaula/pages/secretaria/curso/index.jsp");
		//sesion profesor
		agregarPaginas("profesor","LOGAR","SIG","/virtuaula/pages/profesor/index.jsp");
		agregarPaginas("profesor","menuPrincipalProf","SIG","/virtuaula/pages/profesor/index.jsp");
		agregarPaginas("profesor","desconectar","SIG","/virtuaula/index.jsp");
		
		//sesion contable
		agregarPaginas("contable","LOGAR","SIG","/virtuaula/pages/contable/index.jsp");
		agregarPaginas("contable","menuPrincipalCont","SIG","/virtuaula/pages/contable/index.jsp");
		agregarPaginas("contable","desconectar","SIG","/virtuaula/index.jsp");
		
		//sesion rrhh
		agregarPaginas("rrhh","LOGAR","SIG","/virtuaula/pages/rrhh/index.jsp");
		agregarPaginas("rrhh","menuPrincipalRRHH","SIG","/virtuaula/pages/rrhh/index.jsp");
		agregarPaginas("rrhh","desconectar","SIG","/virtuaula/index.jsp");
		
		//rrhh inserta profesor
		agregarPaginas("rrhh","INI_INS_PROF","OK","/virtuaula/pages/rrhh/profesor/insertar/iniContratarProfesor.jsp");
		agregarPaginas("rrhh","INI_INS_PROF","ERROR","/virtuaula/pages/rrhh/profesor/insertar/iniContratarProfesor.jsp");
		agregarPaginas("rrhh","INS_PROF","OK","/virtuaula/pages/rrhh/profesor/insertar/ContratarProfesor.jsp");
		agregarPaginas("rrhh","INS_PROF","ERROR","/virtuaula/pages/rrhh/profesor/insertar/iniContratarProfesor.jsp");
		agregarPaginas("rrhh","CONTRATO","SIG","/virtuaula/pages/rrhh/index.jsp");
		
		
		
		//contable consulta nominas
		agregarPaginas("contable","OP_MOSTRAR_NOMINAS","OK","/virtuaula/pages/contable/nomina/verNominas.jsp");
		agregarPaginas("contable","OP_MOSTRAR_NOMINAS","ERROR","/virtuaula/pages/contable/nomina/verNominas.jsp");
		
		//contable consulta contratos
		agregarPaginas("contable","OP_MOSTRAR_CONTRATOS","OK","/virtuaula/pages/contable/contrato/verContratos.jsp");
		agregarPaginas("contable","OP_MOSTRAR_CONTRATOS","ERROR","/virtuaula/pages/contable/contrato/verContratos.jsp");
		
		//contable consulta avisos
		agregarPaginas("contable","OP_AVIS_CONT","OK","/virtuaula/pages/contable/aviso/seleccionarAviso.jsp");
		agregarPaginas("contable","OP_AVIS_CONT","ERROR","/virtuaula/pages/contable/aviso/seleccionarAviso.jsp");
		agregarPaginas("contable","MOSTRAR_AVISOS_CONT","SIG","/virtuaula/pages/contable/aviso/leerAviso.jsp");
		agregarPaginas("contable","VOLVER_ANTERIOR_C","SIG","/virtuaula/pages/contable/aviso/seleccionarAviso.jsp");
		agregarPaginas("contable","BORRA_AVISO_CONT","OK","/virtuaula/pages/contable/aviso/seleccionarAviso.jsp");
		agregarPaginas("contable","BORRA_AVISO_CONT","ERROR","/virtuaula/pages/contable/aviso/seleccionarAviso.jsp");
		
		
		//secretario consulta avisos
		agregarPaginas("secretaria","OP_AVIS_SEC","OK","/virtuaula/pages/secretaria/aviso/seleccionarAviso.jsp");
		agregarPaginas("secretaria","OP_AVIS_SEC","ERROR","/virtuaula/pages/secretaria/aviso/seleccionarAviso.jsp");
		agregarPaginas("secretaria","MOSTRAR_AVISOS_SEC","SIG","/virtuaula/pages/secretaria/aviso/leerAviso.jsp");
		agregarPaginas("secretaria","VOLVER_ANTERIOR_S","SIG","/virtuaula/pages/secretaria/aviso/seleccionarAviso.jsp");
		agregarPaginas("secretaria","BORRA_AVISO_SEC","OK","/virtuaula/pages/secretaria/aviso/seleccionarAviso.jsp");
		agregarPaginas("secretaria","BORRA_AVISO_SEC","ERROR","/virtuaula/pages/secretaria/aviso/seleccionarAviso.jsp"); 
		
		//profesor consulta avisos
		agregarPaginas("profesor","OP_AVIS_PROF","OK","/virtuaula/pages/profesor/aviso/seleccionarAviso.jsp");
		agregarPaginas("profesor","OP_AVIS_PROF","ERROR","/virtuaula/pages/profesor/aviso/seleccionarAviso.jsp");
		agregarPaginas("profesor","MOSTRAR_AVISOS_PROF","SIG","/virtuaula/pages/profesor/aviso/leerAviso.jsp");
		agregarPaginas("profesor","VOLVER_ANTERIOR","SIG","/virtuaula/pages/profesor/aviso/seleccionarAviso.jsp");
		agregarPaginas("profesor","BORRA_AVISO","OK","/virtuaula/pages/profesor/aviso/seleccionarAviso.jsp");
		agregarPaginas("profesor","BORRA_AVISO","ERROR","/virtuaula/pages/profesor/aviso/seleccionarAviso.jsp");

		//profesor EDITAR FICHA
		agregarPaginas("profesor","OP_MOSTRAR_CURSO_PROF","OK","/virtuaula/pages/profesor/curso/seleccionarCurso.jsp");
		agregarPaginas("profesor","OP_MOSTRAR_CURSO_PROF","ERROR","/virtuaula/pages/profesor/curso/seleccionarCurso.jsp");
		agregarPaginas("profesor","ListarAlumnosCurso","OK","/virtuaula/pages/profesor/curso/seleccionarAlumno.jsp");
		agregarPaginas("profesor","ListarAlumnosCurso","ERROR","/virtuaula/pages/profesor/curso/seleccionarCurso.jsp");
		agregarPaginas("profesor","Ficha_Alumno_Prof","OK","/virtuaula/pages/profesor/curso/fichaAlumno.jsp");
		agregarPaginas("profesor","Ficha_Alumno_Prof","ERROR","/virtuaula/pages/profesor/curso/seleccionarAlumno.jsp");
		agregarPaginas("profesor","ActualizarFichaAlumno","OK","/virtuaula/pages/profesor/curso/confirmacion.jsp");
		agregarPaginas("profesor","ActualizarFichaAlumno","ERROR","/virtuaula/pages/profesor/curso/fichaAlumno.jsp");
		agregarPaginas("profesor","PUB_NOTAS","OK","/virtuaula/pages/profesor/curso/confirmacionPublicarNotas.jsp");
		agregarPaginas("profesor","PUB_NOTAS","ERROR","/virtuaula/pages/profesor/curso/seleccionarCurso.jsp");
		//la de menuPrincipalProf esta hecha en consulta avisos
		
		
		
		//sesion alumno
		agregarPaginas("alumno","LOGAR","SIG","/virtuaula/pages/alumno/index.jsp");
		agregarPaginas("alumno","CONS_EXP_ALUM","OK","/virtuaula/pages/alumno/expediente/consultaExpediente.jsp");
		agregarPaginas("alumno","CONS_EXP_ALUM","ERROR","/virtuaula/pages/alumno/expediente/consultaExpediente.jsp");
		agregarPaginas("alumno","AVIS_ALUM","OK","/virtuaula/pages/alumno/aviso/seleccionarAviso.jsp");
		agregarPaginas("alumno","menuPrincipalAlum","SIG","/virtuaula/pages/alumno/index.jsp");
		agregarPaginas("alumno","VOLVER_ANTERIOR","SIG","/virtuaula/pages/alumno/aviso/seleccionarAviso.jsp");
		//--------------------------------------esto no se si es asi
		agregarPaginas("alumno","AVIS_ALUM","ERROR","/virtuaula/pages/alumno/index.jsp");
		agregarPaginas("alumno","LEER_AVIS_ALUM","SIG","/virtuaula/pages/alumno/aviso/leerAviso.jsp");
		//--------------------------------------esto no se si es asi
		
		agregarPaginas("alumno","BOR_ALUM_AVIS","OK","/virtuaula/pages/alumno/aviso/seleccionarAviso.jsp");
		
		//--------------------------------------esto no se si es asi
		agregarPaginas("alumno","BOR_ALUM_AVIS","ERROR","/virtuaula/pages/alumno/index.jsp");
		
		//profesor envia aviso
		agregarPaginas("profesor","INI_AVI_PROF","OK","/virtuaula/pages/profesor/aviso/enviarAviso.jsp");
		agregarPaginas("profesor","INI_AVI_PROF","ERROR","/virtuaula/pages/profesor/aviso/enviarAviso.jsp");
		agregarPaginas("profesor","ENV_AVI_PROF","OK","/virtuaula/pages/profesor/aviso/confirmacionAvisoEnviado.jsp");
		agregarPaginas("profesor","ENV_AVI_PROF","ERROR","/virtuaula/pages/profesor/aviso/enviarAviso.jsp");
	}
}
