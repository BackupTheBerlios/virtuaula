package subSistemaControlador.gestorControlador;


import javax.servlet.http.*;
import subSistemaControlador.controlador.controlConexiones.ControladorLogin;
import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.controlPasaPag.ControladorPasaPag;
import subSistemaControlador.gestorControlador.gestorControladorAlumnos.GestorControladorAlumnos;
import subSistemaControlador.gestorControlador.gestorControladorContable.GestorControladorContable;
import subSistemaControlador.gestorControlador.gestorControladorProfesor.GestorControladorProfesor;
import subSistemaControlador.gestorControlador.gestorControladorPublico.GestorControladorPublico;
import subSistemaControlador.gestorControlador.gestorControladorRRHH.GestorControladorRRHH;
import subSistemaControlador.gestorControlador.gestorControladorSecretaria.GestorControladorSecretaria;

import java.util.Hashtable;
/**
 * Clase que mantiene la tabla relacion entre un perfir de usuario, una operación y un Controlador 
 * encargado de llevarla a cabo
 * @author Fco Javier Pérez Escrivá
 *
 */
public class GestorControlador {
		/**
		 * tabla que guarda la relación entre una operación y el controlador que la realiza
		 */
		protected static Hashtable tablaOperacionControlador;
		/**
		 * tabla que guarda la relación entre un usuario y su gestor
		 */
		private Hashtable tablaUsuarioGestor;
		/**
		 * Constructor
		 *
		 */
		public GestorControlador(){
			if (GestorControlador.tablaOperacionControlador==null){
				GestorControlador.tablaOperacionControlador=new Hashtable();
			}
			tablaUsuarioGestor=new Hashtable();
			GestorControlador.tablaOperacionControlador.put("LOGAR",new ControladorLogin());
			
			
		}
		public void inicializa(){
			GestorControladorSecretaria gestorContSec=new GestorControladorSecretaria();
			GestorControladorProfesor gestorContProf = new GestorControladorProfesor();
			GestorControladorPublico gestorContPublico = new GestorControladorPublico();
			GestorControladorContable gestorContContable = new GestorControladorContable();
			GestorControladorAlumnos gestorContAlumno = new GestorControladorAlumnos();
			GestorControladorRRHH gestorContRRHH = new GestorControladorRRHH();
			gestorContSec.inicializa();
			gestorContProf.inicializa();
			gestorContContable.inicializa();
			gestorContAlumno.inicializa();
			gestorContRRHH.inicializa();
			tablaUsuarioGestor.put("secretaria",gestorContSec);
			tablaUsuarioGestor.put("profesor",gestorContProf);
			tablaUsuarioGestor.put("publico",gestorContPublico);
			tablaUsuarioGestor.put("contable",gestorContContable);
			tablaUsuarioGestor.put("alumno",gestorContAlumno);
			tablaUsuarioGestor.put("rrhh",gestorContRRHH);
		}
		public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
			Controlador controladorResultado;	
			
			
			//consulto la tabla y si no esta pregunto a su gestor
			
			controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
			
			
			if (controladorResultado==null){
				controladorResultado=((GestorControlador)tablaUsuarioGestor.get(perfilUsuario)).dameControlador(perfilUsuario,operacion,sesion);	
			}
			
			controladorResultado.setSesion(sesion);
			return controladorResultado;
		}
}
