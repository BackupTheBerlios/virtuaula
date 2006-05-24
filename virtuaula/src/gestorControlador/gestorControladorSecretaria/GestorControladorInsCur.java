package gestorControlador.gestorControladorSecretaria;



import gestorControlador.GestorControlador;

import javax.servlet.http.HttpSession;
import controlador.Controlador;
import controlador.ControladorSecretaria.controlInsCur.ControladorInsCurArea;
import controlador.ControladorSecretaria.controlInsCur.ControladorInsCurAula;
import controlador.ControladorSecretaria.controlInsCur.ControladorInsCurHor;
import controlador.ControladorSecretaria.controlInsCur.ControladorInsCurProf;
import controlador.ControladorSecretaria.controlInsCur.ControladorInsertaCurso;
import controlador.controlPasaPag.ControladorPasaPag;
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

