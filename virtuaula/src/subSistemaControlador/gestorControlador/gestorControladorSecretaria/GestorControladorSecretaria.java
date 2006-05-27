package subSistemaControlador.gestorControlador.gestorControladorSecretaria;


import java.util.Hashtable;
import subSistemaControlador.controlador.controlConexiones.ControladorLogin;
import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulProf.ControladorMostrarProf;
import subSistemaControlador.controlador.ControladorSecretaria.controlInsCur.ControladorIniInsCur;
import subSistemaControlador.controlador.controlConexiones.ControladorDesconectar;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;
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
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		GestorControlador.tablaOperacionControlador.put("menuPrincipalSec",new ControladorLogin());
		GestorControlador.tablaOperacionControlador.put("desconectar",new ControladorDesconectar());
		//consulta profesor
		GestorControlador.tablaOperacionControlador.put("GES_PROF",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("MOSTRAR_PROF",new ControladorMostrarProf());
		//insercion curso generales
		GestorControlador.tablaOperacionControlador.put("GES_CUR",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("INI_INS_CUR",new ControladorIniInsCur());
		GestorControlador.tablaOperacionControlador.put("INS_CUR_CON_PROF",new ControladorPasaPag());
		//consultar curso
		GestorControlador.tablaOperacionControlador.put("GES_CUR",new ControladorPasaPag());
		
		//matricular alumno
		GestorControlador.tablaOperacionControlador.put("GES_ALUM",new ControladorPasaPag());	
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		if (controladorResultado==null){
			controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
		}
		
		
		return controladorResultado;
	}
}
