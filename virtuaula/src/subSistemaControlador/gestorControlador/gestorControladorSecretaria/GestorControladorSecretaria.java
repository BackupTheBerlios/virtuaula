package subSistemaControlador.gestorControlador.gestorControladorSecretaria;


import java.util.Hashtable;
import subSistemaControlador.controlador.controlConexiones.ControladorLogin;
import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno.*;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulProf.ControladorMostrarProf;
import subSistemaControlador.controlador.ControladorSecretaria.controlEditarProf.ControladorEditaProf;
import subSistemaControlador.controlador.ControladorSecretaria.controlInsCur.ControladorIniInsCur;
import subSistemaControlador.controlador.controlConexiones.ControladorDesconectar;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;
import subSistemaControlador.gestorControlador.gestorControladorContable.GestorControladorOpAvisCont;
/**
 * 
 * @author Fco Javier Pérez Escrivá
 *
 */
public class GestorControladorSecretaria extends GestorControlador{
	/**
	 * tabla que guarda la relación entre una operación y su gestor
	 */
	private Hashtable tablaOperacionGestor;
	
	public GestorControladorSecretaria(){
		
		//añadimos a la tabla Operacion-Controlador los controladores comunes en secretaria
		
		tablaOperacionGestor= new Hashtable();
	
		

	}
	public void inicializa(){
		
		//consulta de profesor concretos
		tablaOperacionGestor.put("CONS_PROF",new GestorControladorConsultaProf());
		tablaOperacionGestor.put("INI_CONS_PROF",new GestorControladorConsultaProf());	
		//consulta de curso concretos
		tablaOperacionGestor.put("CONS_CUR",new GestorControladorConsultaCurso());
		tablaOperacionGestor.put("INI_CONS_CUR",new GestorControladorConsultaCurso());
		//edicion de un profesor
		tablaOperacionGestor.put("EDI_CONS_PROF",new GestorControladorEditarProfesor());
		tablaOperacionGestor.put("EDI_INI_CONS_PROF",new GestorControladorEditarProfesor());
		tablaOperacionGestor.put("EDITA_PROF",new GestorControladorEditarProfesor());
		//baja de cursos
		tablaOperacionGestor.put("BAJA_CONS_CUR",new GestorControladorBajaCurso());
		tablaOperacionGestor.put("BAJA_INI_CONS_CUR",new GestorControladorBajaCurso());
		//insercion curso concretos
		tablaOperacionGestor.put("INS_CUR_HOR",new GestorControladorInsCur());
		tablaOperacionGestor.put("INS_CUR_AREA",new GestorControladorInsCur());
		tablaOperacionGestor.put("INS_CUR_AULA",new GestorControladorInsCur());
		tablaOperacionGestor.put("INS_CUR_PROF",new GestorControladorInsCur());
		tablaOperacionGestor.put("INSERTA_CURSO",new GestorControladorInsCur());
		tablaOperacionGestor.put("INS_CUR_CON_PROF",new GestorControladorInsCur());
		//matricular alumno
		tablaOperacionGestor.put("MAT_ALUM_DOS",new GestorControladorMatricularAlumno());
		tablaOperacionGestor.put("MAT_ALUM",new GestorControladorMatricularAlumno());
		tablaOperacionGestor.put("MATRICULA",new GestorControladorMatricularAlumno());
		tablaOperacionGestor.put("MAT_ALUM_CUR",new GestorControladorMatricularAlumno());
		//consultar alumno
		tablaOperacionGestor.put("CONS_ALUM",new GestorControladorConsulAlumno());
		//tablaOperacionGestor.put("CONS_ALUM2",new ControladorConsAlumno());
		tablaOperacionGestor.put("MOSTRAR_ALUM",new GestorControladorConsulAlumno());
		//Avisos
		tablaOperacionGestor.put("OP_AVIS_SEC",new GestorControladorOpAvisSec());
		tablaOperacionGestor.put("MOSTRAR_AVISOS_SEC",new GestorControladorOpAvisSec());
		tablaOperacionGestor.put("BORRA_AVISO_SEC",new GestorControladorOpAvisSec());
		
		tablaOperacionGestor.put("ENV_AVISO_INI_SEC",new GestorControladorOpAvisSec());
		tablaOperacionGestor.put("ENV_AVI_SEC",new GestorControladorOpAvisSec());
		
		
		//Horarios
		tablaOperacionGestor.put("CONS_HOR",new GestorControladorOpConsHor());
		tablaOperacionGestor.put("CONS_HOR_SEL",new GestorControladorOpConsHor());
		//editar un alumno
		tablaOperacionGestor.put("EDITAR_ALUM_INI",new GestorControladorEditarAlumno());
		tablaOperacionGestor.put("BUSCAR_ALUM_EDITAR",new GestorControladorEditarAlumno());
		tablaOperacionGestor.put("SELEC_EDITAR_ALUMNO",new GestorControladorEditarAlumno());
		tablaOperacionGestor.put("CONF_EDITAR_ALUMNO",new GestorControladorEditarAlumno());
		tablaOperacionGestor.put("FIN_EDITAR_ALUMNO",new GestorControladorEditarAlumno());
		
		
	
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		System.out.println("la operacion es " + operacion);
		CreadorControlador c=new CreadorControlador();
		GestorControlador.tablaOperacionControlador.put("menuPrincipalSec",c.crear(CreadorControlador.ControladorLogin));
		GestorControlador.tablaOperacionControlador.put("desconectar",c.crear(CreadorControlador.ControladorDesconectar));
		GestorControlador.tablaOperacionControlador.put("VUELTA_ALUM",c.crear(CreadorControlador.ControladorPasaPag));
		GestorControlador.tablaOperacionControlador.put("VUELTA_ALUM2",c.crear(CreadorControlador.ControladorPasaPag));
		tablaOperacionGestor.put("CONS_ALUM2",new ControladorConsAlumno());
		//consulta profesor
		GestorControlador.tablaOperacionControlador.put("GES_PROF",c.crear(CreadorControlador.ControladorPasaPag));
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_PROF",c.crear(CreadorControlador.ControladorMostrarProf));
		//edicion de profesor
		GestorControlador.tablaOperacionControlador.put("EDI_INI_CONS_PROF",c.crear(CreadorControlador.ControladorProfAreas));
		GestorControlador.tablaOperacionControlador.put("EDITA_PROF",new ControladorEditaProf());
		//insercion curso generales
		GestorControlador.tablaOperacionControlador.put("GES_CUR",c.crear(CreadorControlador.ControladorPasaPag));
		GestorControlador.tablaOperacionControlador.put("INI_INS_CUR",c.crear(CreadorControlador.ControladorIniInsCur));
		GestorControlador.tablaOperacionControlador.put("INS_CUR_CON_PROF",c.crear(CreadorControlador.ControladorPasaPag));
		//consultar curso
		GestorControlador.tablaOperacionControlador.put("GES_CUR",c.crear(CreadorControlador.ControladorPasaPag));
		
		//matricular alumno
		GestorControlador.tablaOperacionControlador.put("GES_ALUM",c.crear(CreadorControlador.ControladorPasaPag));	
		tablaOperacionGestor.put("VOLVER_ANTERIOR_S",c.crear(CreadorControlador.ControladorPasaPag));
		
		//Horarios
		GestorControlador.tablaOperacionControlador.put("OP_MENU_HOR",c.crear(CreadorControlador.ControladorPasaPag));
		GestorControlador.tablaOperacionControlador.put("GES_HOR",c.crear(CreadorControlador.ControladorPasaPag));
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		if (controladorResultado==null){
			controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
		}
		System.out.println("Controladoe que le madno es " + controladorResultado.getClass().getName());
		
		return controladorResultado;
	}
}
