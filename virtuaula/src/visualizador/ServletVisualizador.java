package visualizador;
import java.io.*;


import beans.beanEncapsulado.BeanEncapsulado;
import controlador.Controlador;
import gestorSesiones.GestorSesiones;
import gestorPaginas.GestorPaginas;
import gestorControlador.*;
import javax.servlet.http.*;

/**
 * 
 * @author Fco Javier Pérez Escrivá 
 *
 */
public class ServletVisualizador extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private GestorSesiones gestorSesiones;
	private GestorControlador gestorControlador;
	private GestorPaginas gestorPaginas;
	public ServletVisualizador() {
		super();
		gestorControlador=new GestorControlador();
		gestorControlador.inicializa();
		gestorSesiones =new GestorSesiones();
		gestorPaginas=new GestorPaginas();
		//sesion anonima
		gestorPaginas.agregarPaginas("publico","OFERTA_FORMATIVA","OK","/virtuaula/pages/publico/ofertaFormativa.jsp");
		gestorPaginas.agregarPaginas("publico","OFERTA_FORMATIVA","ERROR","/virtuaula/pages/publico/errorOfertaFormativa.jsp");
		gestorPaginas.agregarPaginas("publico","ZONA_RESTRINGIDA","SIG","/virtuaula/pages/controlAcceso/index.jsp");
		gestorPaginas.agregarPaginas("publico","PRINCIPAL_PUBLICO","SIG","/virtuaula/index.jsp");
		//sesion secretaria
		gestorPaginas.agregarPaginas("secretaria","LOGAR","SIG","/virtuaula/pages/secretaria/index.jsp");
		gestorPaginas.agregarPaginas("secretaria","menuPrincipalSec","SIG","/virtuaula/pages/secretaria/index.jsp");
		gestorPaginas.agregarPaginas("secretaria","desconectar","SIG","/virtuaula/index.jsp");
		//secretaria cosulta profesor
		gestorPaginas.agregarPaginas("secretaria","CONS_PROF","OK","/virtuaula/pages/secretaria/profesor/consultar/seleccionarProfesor.jsp");
		gestorPaginas.agregarPaginas("secretaria","CONS_PROF","ERROR","/virtuaula/pages/secretaria/profesor/consultar/errorConsultarProfesor.jsp");
		gestorPaginas.agregarPaginas("secretaria","GES_PROF","SIG","/virtuaula/pages/secretaria/profesor/index.jsp");
		gestorPaginas.agregarPaginas("secretaria","INI_CONS_PROF","OK","/virtuaula/pages/secretaria/profesor/consultar/buscarProfesor.jsp");
		gestorPaginas.agregarPaginas("secretaria","INI_CONS_PROF","ERROR","/virtuaula/pages/secretaria/profesor/consultar/errorConsultarProfesor.jsp");
		gestorPaginas.agregarPaginas("secretaria","MOSTRAR_PROF","OK","/virtuaula/pages/secretaria/profesor/consultar/informacionProfesor.jsp");
		
		
		//secretaria cosulta curso
		gestorPaginas.agregarPaginas("secretaria","CONS_CUR","OK","/virtuaula/pages/secretaria/curso/consultar/seleccionarCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","CONS_CUR","ERROR","/virtuaula/pages/secretaria/curso/consultar/errorConsultarCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","GES_CUR","SIG","/virtuaula/pages/secretaria/curso/index.jsp");
		gestorPaginas.agregarPaginas("secretaria","INI_CONS_CUR","OK","/virtuaula/pages/secretaria/curso/consultar/buscarCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","INI_CONS_CUR","ERROR","/virtuaula/pages/secretaria/curso/consultar/errorConsultarCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","MOSTRAR_CUR","OK","/virtuaula/pages/secretaria/curso/consultar/informacionCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","MOSTRAR_CUR","ERROR","/virtuaula/pages/secretaria/curso/consultar/informacionCurso.jsp");
	
		//secretaria insercion curso
		gestorPaginas.agregarPaginas("secretaria","GES_CUR","SIG","/virtuaula/pages/secretaria/curso/index.jsp");
		gestorPaginas.agregarPaginas("secretaria","INI_INS_CUR","SIG","/virtuaula/pages/secretaria/curso/insertar/iniInsertarCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","INS_CUR_HOR","OK","/virtuaula/pages/secretaria/curso/insertar/seleccHorarioInsertarCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","INS_CUR_HOR","ERROR","/virtuaula/pages/secretaria/curso/insertar/iniInsertarCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","INS_CUR_AREA","OK","/virtuaula/pages/secretaria/curso/insertar/seleccAreaInsertarCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","INS_CUR_AREA","ERROR","/virtuaula/pages/secretaria/curso/insertar/seleccHorarioInsertarCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","INS_CUR_AULA","OK","/virtuaula/pages/secretaria/curso/insertar/seleccAulaInsertarCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","INS_CUR_AULA","ERROR","/virtuaula/pages/secretaria/curso/insertar/seleccHorarioInsertarCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","INS_CUR_AULA","ERROR2","/virtuaula/pages/secretaria/curso/insertar/seleccAreaInsertarCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","INS_CUR_PROF","OK","/virtuaula/pages/secretaria/curso/insertar/seleccProfesorInsertarCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","INS_CUR_PROF","ERROR","/virtuaula/pages/secretaria/curso/insertar/seleccAulaInsertarCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","INSERTA_CURSO","OK","/virtuaula/pages/secretaria/curso/insertar/insertarCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","INSERTA_CURSO","ERROR","/virtuaula/pages/secretaria/curso/insertar/iniInsertarCurso.jsp");
		gestorPaginas.agregarPaginas("secretaria","INS_CUR_CON_PROF","SIG","/virtuaula/pages/secretaria/curso/index.jsp");
		//sesion profesor
		gestorPaginas.agregarPaginas("profesor","LOGAR","SIG","/virtuaula/pages/profesor/index.jsp");
		gestorPaginas.agregarPaginas("profesor","menuPrincipalProf","SIG","/virtuaula/pages/profesor/index.jsp");
		gestorPaginas.agregarPaginas("profesor","desconectar","SIG","/virtuaula/index.jsp");
		//profesor consulta avisos
		gestorPaginas.agregarPaginas("profesor","OP_AVIS_PROF","OK","/virtuaula/pages/profesor/aviso/seleccionarAviso.jsp");
		gestorPaginas.agregarPaginas("profesor","OP_AVIS_PROF","ERROR","/virtuaula/pages/profesor/aviso/seleccionarAviso.jsp");
		gestorPaginas.agregarPaginas("profesor","MOSTRAR_AVISOS_PROF","SIG","/virtuaula/pages/profesor/aviso/leerAviso.jsp");
		gestorPaginas.agregarPaginas("profesor","VOLVER_ANTERIOR","SIG","/virtuaula/pages/profesor/aviso/seleccionarAviso.jsp");
		gestorPaginas.agregarPaginas("profesor","BORRA_AVISO","OK","/virtuaula/pages/profesor/aviso/seleccionarAviso.jsp");
		gestorPaginas.agregarPaginas("profesor","BORRA_AVISO","ERROR","/virtuaula/pages/profesor/aviso/seleccionarAviso.jsp");

		//profesor EDITAR FICHA
		gestorPaginas.agregarPaginas("profesor","OP_MOSTRAR_CURSO_PROF","OK","/virtuaula/pages/profesor/curso/seleccionarCurso.jsp");
		gestorPaginas.agregarPaginas("profesor","OP_MOSTRAR_CURSO_PROF","ERROR","/virtuaula/pages/profesor/curso/seleccionarCurso.jsp");
		gestorPaginas.agregarPaginas("profesor","ListarAlumnosCurso","OK","/virtuaula/pages/profesor/curso/seleccionarAlumno.jsp");
		gestorPaginas.agregarPaginas("profesor","ListarAlumnosCurso","ERROR","/virtuaula/pages/profesor/curso/seleccionarCurso.jsp");
		gestorPaginas.agregarPaginas("profesor","Ficha_Alumno_Prof","OK","/virtuaula/pages/profesor/curso/fichaAlumno.jsp");
		gestorPaginas.agregarPaginas("profesor","Ficha_Alumno_Prof","ERROR","/virtuaula/pages/profesor/curso/seleccionarAlumno.jsp");
		gestorPaginas.agregarPaginas("profesor","ActualizarFichaAlumno","OK","/virtuaula/pages/profesor/curso/confirmacion.jsp");
		gestorPaginas.agregarPaginas("profesor","ActualizarFichaAlumno","ERROR","/virtuaula/pages/profesor/curso/fichaAlumno.jsp");
		gestorPaginas.agregarPaginas("profesor","PUB_NOTAS","OK","/virtuaula/pages/profesor/curso/confirmacionPublicarNotas.jsp");
		gestorPaginas.agregarPaginas("profesor","PUB_NOTAS","ERROR","/virtuaula/pages/profesor/curso/seleccionarCurso.jsp");
		//la de menuPrincipalProf esta hecha en consulta avisos
		
		//matricular alumno
		gestorPaginas.agregarPaginas("secretaria","GES_ALUM","SIG","/virtuaula/pages/secretaria/alumno/index.jsp");
		gestorPaginas.agregarPaginas("secretaria","MAT_ALUM_DOS","OK","/virtuaula/pages/secretaria/alumno/insertar/iniMatricularAlumno.jsp");
		gestorPaginas.agregarPaginas("secretaria","MAT_ALUM_DOS","ERROR","/virtuaula/pages/secretaria/alumno/insertar/iniMatricularAlumno.jsp");
		gestorPaginas.agregarPaginas("secretaria","MAT_ALUM","SIG","/virtuaula/pages/secretaria/alumno/insertar/seleccCursoMatricularAlumno.jsp");
		gestorPaginas.agregarPaginas("secretaria","MAT_ALUM_CUR","OK","/virtuaula/pages/secretaria/alumno/insertar/insertarAlumno.jsp");
		gestorPaginas.agregarPaginas("secretaria","MAT_ALUM_CUR","ERROR","/virtuaula/pages/secretaria/alumno/insertar/seleccCursoMatricularAlumno.jsp");
		gestorPaginas.agregarPaginas("secretaria","MATRICULA","OK","/virtuaula/pages/secretaria/alumno/index.jsp");
		gestorPaginas.agregarPaginas("secretaria","MATRICULA","ERROR","/virtuaula/pages/secretaria/alumno/insertar/insertarAlumno.jsp");
		


		}
	
	public void doPost (HttpServletRequest req, HttpServletResponse rep) throws IOException{
		HttpSession sesion=req.getSession(true);
		BeanEncapsulado.encapsular(req);
		System.out.println("paso por el servlet");
		if (gestorSesiones.indicaSiUsuarioIdentificado(sesion)){
			//el usuario está validado
			
			String operacion=gestorSesiones.dameOperacion(req);
			String perfil=gestorSesiones.damePerfilUsuario(sesion);
			Controlador controlador=gestorControlador.dameControlador(perfil,operacion,sesion);
			controlador.procesarEvento();
			String paginaSiguiente=gestorPaginas.damePaginaSig(perfil,operacion,controlador.getResuladooperacion());
			rep.sendRedirect(paginaSiguiente);
		}
		else{
			//el usuario no está validado
			rep.sendRedirect("/virtuaula/pages/controlAcceso/errorindex.jsp");
		}

	}
	public void doGet (HttpServletRequest req, HttpServletResponse rep) throws IOException{
		doPost(req,rep);
		}
	

}
