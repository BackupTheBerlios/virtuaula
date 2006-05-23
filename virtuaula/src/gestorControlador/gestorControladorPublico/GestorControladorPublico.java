package gestorControlador.gestorControladorPublico;

import gestorControlador.GestorControlador;

import java.util.Hashtable;
import javax.servlet.http.HttpSession;
import controlador.Controlador;
import controlador.controlPasaPag.ControladorPasaPag;
import controlador.controlOfertaFormativa.ControladorOfertaFormativa;;
/**
 * 
 * @author Fco Javier Pérez Escrivá
 *
 */
public class GestorControladorPublico extends GestorControlador{

		/**
		 * tabla que guarda la relación entre una operación y su gestor
		 */
		private Hashtable tablaOperacionGestor;
		
		public GestorControladorPublico(){
			
			//añadimos a la tabla Operacion-Controlador los controladores comunes en secretaria
			
			tablaOperacionGestor= new Hashtable();
		
			

		}
		public void inicializa(){
		
		}
		public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
			GestorControlador.tablaOperacionControlador.put("OFERTA_FORMATIVA",new ControladorOfertaFormativa());
			GestorControlador.tablaOperacionControlador.put("PRINCIPAL_PUBLICO",new ControladorPasaPag());
			GestorControlador.tablaOperacionControlador.put("ZONA_RESTRINGIDA",new ControladorPasaPag());
			Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
			
			
			if (controladorResultado==null){
				controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
			}
			
			
			return controladorResultado;
		}
}
