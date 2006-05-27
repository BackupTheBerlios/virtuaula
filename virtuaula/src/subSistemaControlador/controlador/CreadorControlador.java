package subSistemaControlador.controlador;

import java.util.ArrayList;
import subSistemaControlador.controlador.ControladorAlumnos.controlConsultaExpAlum.ControladorConExpAlum;

/**
 * Proporciona un interfaz de creación de cualquier controlador
 * @author Fco Javier Pérez Escrivá
 *
 */
public class CreadorControlador {
	static final public int ControladorConExpAlum=0;
	
	
	private ArrayList tablaControladoresPrototipos;
	
	public CreadorControlador(){
		this.inicializar();
	}
	private void inicializar(){
		
		//introducimos todos los controladores
		tablaControladoresPrototipos.add(0,new ControladorConExpAlum());	
	}
	/**
	 * Crea el controlador especificado
	 * @param tipo constante q especifica el tipo a pasar
	 * @return Instanciacion del controlador solicitado
	 */
	public Controlador crear (int tipo){
		try{
			return ((Controlador)tablaControladoresPrototipos.get(tipo)).clonar();
		}
		catch (Exception e){
			System.out.println("Ha habido un problema en el creador de controladores");
			e.getStackTrace();
			return null;
		}
	}	
		
}