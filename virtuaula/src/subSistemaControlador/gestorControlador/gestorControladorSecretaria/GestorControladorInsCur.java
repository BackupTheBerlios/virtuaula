package subSistemaControlador.gestorControlador.gestorControladorSecretaria;




import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.ControladorSecretaria.controlInsCur.ControladorInsCurArea;
import subSistemaControlador.controlador.ControladorSecretaria.controlInsCur.ControladorInsCurAula;
import subSistemaControlador.controlador.ControladorSecretaria.controlInsCur.ControladorInsCurHor;
import subSistemaControlador.controlador.ControladorSecretaria.controlInsCur.ControladorInsCurProf;
import subSistemaControlador.controlador.ControladorSecretaria.controlInsCur.ControladorInsertaCurso;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.GestorControlador;
/**
 * 
 * @author Alberto Macho y Fco Javier Pérez Escrivá
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

