package gestorControlador;



import javax.servlet.http.HttpSession;
import controlador.Controlador;
import controlador.controlInsCur.ControladorInsCurArea;
import controlador.controlInsCur.ControladorInsCurAula;
import controlador.controlInsCur.ControladorInsCurHor;
import controlador.controlInsCur.ControladorInsCurProf;
import controlador.controlInsCur.ControladorInsertaCurso;
import controlador.controlPasaPag.ControladorPasaPag;
/**
 * 
 * @author Alberto Macho
 *
 */
public class GestorControladorInsCur extends GestorControladorSecretaria{
	
	
	
	public GestorControladorInsCur(){}
	
	public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
		//GestorControlador.tablaOperacionControlador.put("menuPrincipalSec",new ControladorPasaPag());
		//GestorControlador.tablaOperacionControlador.put("desconectar",new ControladorDesconectar());
		GestorControlador.tablaOperacionControlador.put("INS_CUR_HOR",new ControladorInsCurHor());
		GestorControlador.tablaOperacionControlador.put("INS_CUR_AREA",new ControladorInsCurArea());
		GestorControlador.tablaOperacionControlador.put("INS_CUR_AULA",new ControladorInsCurAula());
		GestorControlador.tablaOperacionControlador.put("INS_CUR_PROF",new ControladorInsCurProf());
		//GestorControlador.tablaOperacionControlador.put("INS_CUR_AREA",new ControladorInsCurArea());
		GestorControlador.tablaOperacionControlador.put("INS_CUR_CON_PROF",new ControladorPasaPag());
		GestorControlador.tablaOperacionControlador.put("INSERTA_CURSO",new ControladorInsertaCurso());
		
		
		
		
Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
		
		return controladorResultado;
		
		
		
	}
}

