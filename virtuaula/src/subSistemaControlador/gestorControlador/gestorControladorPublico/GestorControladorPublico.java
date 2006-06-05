package subSistemaControlador.gestorControlador.gestorControladorPublico;


import java.util.Hashtable;
import javax.servlet.http.HttpSession;

import subSistemaControlador.controlador.Controlador;
import subSistemaControlador.controlador.CreadorControlador;
import subSistemaControlador.gestorControlador.GestorControlador;

/**
 * Devuelve los controladores de la zona publica
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
		/**
		 * Realiza la correspondencia entre una operacion y el gestorControlador que la recoge
		 */
		public void inicializa(){}
		/**
		 * Devuelve el Controlador adecuado para este perfil y esta operacion
		 */
		public Controlador dameControlador(String perfilUsuario, String operacion, HttpSession sesion){
			CreadorControlador c= new CreadorControlador();
			GestorControlador.tablaOperacionControlador.put("OFERTA_FORMATIVA",c.crear(CreadorControlador.ControladorOfertaFormativa));
			GestorControlador.tablaOperacionControlador.put("PRINCIPAL_PUBLICO",c.crear(CreadorControlador.ControladorPasaPag));
			GestorControlador.tablaOperacionControlador.put("ZONA_RESTRINGIDA",c.crear(CreadorControlador.ControladorPasaPag));
			Controlador controladorResultado=((Controlador)GestorControlador.tablaOperacionControlador.get(operacion));
			
			
			if (controladorResultado==null){
				controladorResultado=((GestorControlador)tablaOperacionGestor.get(operacion)).dameControlador(perfilUsuario,operacion,sesion);	
			}
			
			
			return controladorResultado;
		}
}
