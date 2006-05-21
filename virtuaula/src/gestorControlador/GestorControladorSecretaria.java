package gestorControlador;

import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import controlador.Controlador;
import controlador.controlConexiones.ControladorDesconectar;
import controlador.controlPasaPag.ControladorPasaPag;
import controlador.controlConsulProf.ControladorMostrarProf;
import controlador.controlConsulProf.ControladorProfAreas;
import controlador.controlInsCur.ControladorIniInsCur;

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
		//insercion curso concretos
		tablaOperacionGestor.put("INS_CUR_HOR",new GestorControladorInsCur());
		tablaOperacionGestor.put("INS_CUR_AREA",new GestorControladorInsCur());
		tablaOperacionGestor.put("INS_CUR_AULA",new GestorControladorInsCur());
		tablaOperacionGestor.put("INS_CUR_PROF",new GestorControladorInsCur());
		tablaOperacionGestor.put("INSERTA_CURSO",new GestorControladorInsCur());
		tablaOperacionGestor.put("INS_CUR_CON_PROF",new GestorControladorInsCur());
		
	}
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		GestorControlador.tablaOperacionControlador.put("menuPrincipalSec",new ControladorPasaPag());
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
		//GestorControlador.tablaOperacionControlador.put("MOSTRAR_CUR",new ControladorPasaPag());
		
		
		Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		
		if (controladorResultado==null){
			controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
		}
		
		
		return controladorResultado;
	}
}
