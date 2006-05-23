package gestorControlador;
import controlador.Controlador;
import controlador.controlPasaPag.ControladorPasaPag;

import gestorControlador.gestorControladorAlumnos.GestorControladorAlumnos;
import gestorControlador.gestorControladorContable.GestorControladorContable;
import gestorControlador.gestorControladorProfesor.GestorControladorProfesor;
import gestorControlador.gestorControladorPublico.GestorControladorPublico;
import gestorControlador.gestorControladorSecretaria.GestorControladorSecretaria;

import javax.servlet.http.*;
import java.util.Hashtable;
/**
 * Clase que mantiene la tabla relacion entre un perfir de usuario, una operaci�n y un Controlador 
 * encargado de llevarla a cabo
 * @author Fco Javier P�rez Escriv�
 *
 */
public class GestorControlador {
		/**
		 * tabla que guarda la relaci�n entre una operaci�n y el controlador que la realiza
		 */
		protected static Hashtable tablaOperacionControlador;
		/**
		 * tabla que guarda la relaci�n entre un usuario y su gestor
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
			GestorControlador.tablaOperacionControlador.put("LOGAR",new ControladorPasaPag());		
			
			tablaUsuarioGestor=new Hashtable();
			
			
		}
		public void inicializa(){
			GestorControladorSecretaria gestorContSec=new GestorControladorSecretaria();
			GestorControladorProfesor gestorContProf = new GestorControladorProfesor();
			GestorControladorPublico gestorContPublico = new GestorControladorPublico();
			GestorControladorContable gestorContContable = new GestorControladorContable();
			GestorControladorAlumnos gestorContAlumno = new GestorControladorAlumnos();
			gestorContSec.inicializa();
			gestorContProf.inicializa();
			gestorContContable.inicializa();
			gestorContAlumno.inicializa();
			tablaUsuarioGestor.put("secretaria",gestorContSec);
			tablaUsuarioGestor.put("profesor",gestorContProf);
			tablaUsuarioGestor.put("publico",gestorContPublico);
			tablaUsuarioGestor.put("contable",gestorContContable);
			tablaUsuarioGestor.put("alumno",gestorContAlumno);
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
