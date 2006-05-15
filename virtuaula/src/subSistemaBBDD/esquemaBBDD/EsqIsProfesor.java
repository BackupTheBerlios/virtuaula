package subSistemaBBDD.esquemaBBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import subSistemaBBDD.listaObjeto.*;
import subSistemaBBDD.objetoBaseDatos.*;
import subSistemaBBDD.objetoCriterio.*;

import org.apache.log4j.Logger;

import subSistemaBBDD.utils.*;
public class EsqIsProfesor extends EsquemaBBDD {

	//Declaramos el log de la clase
	private static final Logger log = Logger.getLogger(EsqIsProfesor.class);
	
	/**
	 * Insertar el ObjetoBBDD que le pasamos como argumento en la base de datos correspondiente.
	 * 
	 * @return 	True si la inserccion se ha ejecutado correctamente </b>
	 * 			False en caso contrario.
	 * @param   obj ObjetoBBDD 
	 * 
	 */
	public boolean insertar(ObjetoBBDD obj) {
		
		//variables a utilizar
		boolean bResultado = false;
		boolean bResultadoConexion;
		String sQuery = "";
		Statement instruccion = null;
		int numFilas;
				
		bResultadoConexion = super.conectar();
		if (bResultadoConexion  && !obj.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI).equals("")
				 && !obj.dameValor(Constantes.PROFESOR_ISAREA_IDISAREA).equals("")) {
			try {
				instruccion = super.getConexion().createStatement();			
			} catch (SQLException e) {
				log.error(Constantes.ERROR_CONEXION_BBDD);
				log.error(e.getMessage());
			}				
			
			sQuery = "INSERT INTO " + super.getBd()+ "." + Constantes.TABLA_PROFESOR + "(" + Constantes.ID_ISPROFESOR_ISUSUARIO_DNI + "," + Constantes.PROFESOR_ISAREA_IDISAREA + "," + Constantes.PROFESOR_NOMBRE + "," + Constantes.PROFESOR_APELLIDO1 + "," + Constantes.PROFESOR_APELLIDO2 + "," + Constantes.PROFESOR_TELEFONO + "," + Constantes.PROFESOR_EMAIL + ") VALUES('" + obj.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI) + "',"+obj.dameValor(Constantes.PROFESOR_ISAREA_IDISAREA) + ",'" + obj.dameValor(Constantes.PROFESOR_NOMBRE) + "','" + obj.dameValor(Constantes.PROFESOR_APELLIDO1) + "','" + obj.dameValor(Constantes.PROFESOR_APELLIDO2) + "'," + obj.dameValor(Constantes.PROFESOR_TELEFONO) + ",'" + obj.dameValor(Constantes.PROFESOR_EMAIL) + "');";	
	
			try {
				numFilas = instruccion.executeUpdate(sQuery);
				bResultado = (numFilas != 0);
				log.info("Se han insertado " + numFilas + " filas en la tabla " + Constantes.TABLA_PROFESOR);
			} catch (SQLException e) {
				log.error("Error al insertar ObjetoBBDD en " + Constantes.TABLA_PROFESOR);
				log.error(e.getMessage());
				
			}	
		}		
		super.desconectar();
		
		return bResultado;
	}

	
	/**
	 * Borra el ObjetoCriterio que le pasamos como argumento de la base de datos. �ste lo realiza mediante las </b>
	 * condiciones que me vengan el el objeto que pasamos como par�metro.
	 * 
	 * @return 	True si el borrado se ha ejecutado correctamente </b>
	 * 			False en caso contrario o en el caso de que en el objeto que se le pasa como argumento no viene ning�n criterio de b�squeda.
	 * @param   obj ObjetoCriterio.
	 * 
	 */
	public boolean borrar(ObjetoCriterio obj) {
		
		//variables a utilizar
		boolean bResultado = false;
		boolean bResultadoConexion;
		String sQuery = "";
		Statement instruccion = null;
		int numFilas;
		
		if (obj.dameNumCampos() != 0) {
			bResultadoConexion = super.conectar();
			if (bResultadoConexion) {
				try {
					instruccion = super.getConexion().createStatement();			
				} catch (SQLException e) {
					log.error(Constantes.ERROR_CONEXION_BBDD);
					log.error(e.getMessage());
				}				
				
				//Como m�nimo tiene que haber un criterio de b�squeda.
				//Aparte el valor me lo tiene que saber dar del campo que pongo en la condici�n
				sQuery = "DELETE FROM " + super.getBd()+ "." + Constantes.TABLA_PROFESOR + " WHERE "+obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
				
				//pongo las condiciones siguientes que me vengan en el objeto
				if (obj.dameNumCampos() > 1) {
					while (obj.camposig()) {
						sQuery += " AND " + obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
					}				
				}
				
				//cierro la sentencia
				sQuery += ";";
				
				try {
					//ejecuto la query
					numFilas = instruccion.executeUpdate(sQuery);
					bResultado = (numFilas != 0);
					log.info("Se han borrado " + numFilas + " registros de la tabla " + Constantes.TABLA_PROFESOR);
				} catch (SQLException e) {
					log.error("Error al borrar ObjetoBBDD en " + Constantes.TABLA_PROFESOR);
					log.error(e.getMessage());
					
				}	
			}		
			super.desconectar();
		}
		return bResultado;
	}


	/**
	 * Devuelve una ListaObjetoBBDDAbs tras realizar la consulta a la BBDD seg�n los criterios que vengan en el </b>
	 * objeto que me pasan como argumento.
	 * 
	 * @return ListaObjetoBBDDAbs con el resultado de la query. </b>
	 * 			Si el objeto que le pasamos como argumento viene sin criterio de b�squeda la lista se devuelve vac�a.
	 * 
	 * @param obj ObjetoCriterio.
	 * 
	 */
	public ListaObjetoBBDD consultar(ObjetoCriterio obj) {
		
		//variables a utilizar
		CreadorObjetoBBDD creadorObjetoBBDD = new CreadorObjetoBBDD ();
		CreadorListaObjetoBBDD creadorListaObjetoBBDD = new CreadorListaObjetoBBDD();
		ListaObjetoBBDD listaObjetoBBDDAbs = creadorListaObjetoBBDD.crear();
		ResultSet resultSet;
		Statement instruccion = null;
		String sQuery = "";
		boolean bResultadoConexion;
		int posicion = 0;
		Integer iValor;
		bResultadoConexion = super.conectar();
		if (bResultadoConexion) {
			try {
				instruccion = super.getConexion().createStatement();			
			} catch (SQLException e) {
				log.error(Constantes.ERROR_CONEXION_BBDD);
				log.error(e.getMessage());
			}				
			
			sQuery = "SELECT * FROM " + Constantes.TABLA_PROFESOR;
			if (obj.dameNumCampos() > 0){
				sQuery += " WHERE ";
				sQuery += obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
				while (obj.camposig()) {
					sQuery += " AND " + obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
				}	
			}
			//cierro la sentencia
			sQuery += ";";
			
			try {
				//ejecuto la query
				resultSet = (ResultSet) instruccion.executeQuery(sQuery);								
				while (resultSet.next()) {
					ObjetoBBDD objetoBBDD = creadorObjetoBBDD.crear(creadorObjetoBBDD.Isprofesor);
					objetoBBDD.cambiaValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI, resultSet.getString(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI));					
					iValor = new Integer (resultSet.getInt(Constantes.PROFESOR_ISAREA_IDISAREA));
					objetoBBDD.cambiaValor(Constantes.PROFESOR_ISAREA_IDISAREA, iValor.toString());
					objetoBBDD.cambiaValor(Constantes.PROFESOR_NOMBRE, resultSet.getString(Constantes.PROFESOR_NOMBRE));
					objetoBBDD.cambiaValor(Constantes.PROFESOR_APELLIDO1, resultSet.getString(Constantes.PROFESOR_APELLIDO1));
					objetoBBDD.cambiaValor(Constantes.PROFESOR_APELLIDO2, resultSet.getString(Constantes.PROFESOR_APELLIDO2));
					iValor = new Integer (resultSet.getInt(Constantes.PROFESOR_TELEFONO));
					objetoBBDD.cambiaValor(Constantes.PROFESOR_TELEFONO, iValor.toString());
					objetoBBDD.cambiaValor(Constantes.PROFESOR_EMAIL, resultSet.getString(Constantes.PROFESOR_EMAIL));
					listaObjetoBBDDAbs.insertar(posicion++, objetoBBDD);
				}								
				
			} catch (SQLException e) {
				log.error("Error al consultar ObjetoBBDD en " + Constantes.TABLA_PROFESOR);
				log.error(e.getMessage());
				
			}	
		}		
		super.desconectar();					
		return listaObjetoBBDDAbs;
	}
	
//	Las ediciones se realizan sobre entradas obtenidas a traves de una consulta con lo que
	//el objetoCriterio obj siempre tendr� el campo identificador relleno (ID de cada fila de la tabla)
	public boolean editar(ObjetoCriterio obj){
//		variables a utilizar
		boolean bResultado = false;
		boolean bResultadoConexion;
		String sQuery = "";
		Statement instruccion = null;
		int numFilas;
		
		if (obj.dameNumCampos() != 0) {
			bResultadoConexion = super.conectar();
			if (bResultadoConexion) {
				try {
					instruccion = super.getConexion().createStatement();			
				} catch (SQLException e) {
					log.error(Constantes.ERROR_CONEXION_BBDD);
					log.error(e.getMessage());
				}				
				
				//Como m�nimo tiene que haber un criterio de b�squeda.
				//Aparte el valor me lo tiene que saber dar del campo que pongo en la condici�n
				sQuery = "UPDATE " + super.getBd()+ "." + Constantes.TABLA_PROFESOR + 
				" SET "+obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
				
				//pongo las condiciones siguientes que me vengan en el objeto
				if (obj.dameNumCampos() > 1) {
					while (obj.camposig()) {
						sQuery += "," + obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
					}
					sQuery += " where "+Constantes.ID_ISPROFESOR_ISUSUARIO_DNI +"="+obj.dameValor(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI) ; 
				}
				
				//cierro la sentencia
				sQuery += ";";
				
				try {
					//ejecuto la query
					numFilas = instruccion.executeUpdate(sQuery);
					bResultado = (numFilas != 0);
					log.info("Se han actualizado " + numFilas + " registros de la tabla " + Constantes.TABLA_PROFESOR);
				} catch (SQLException e) {
					log.error("Error al editar ObjetoBBDD en " + Constantes.TABLA_PROFESOR);
					log.error(e.getMessage());
					
				}	
			}		
			super.desconectar();
		}
		
		return bResultado;	
		
	}
	
	/**
	 * Crea una copia del objeto.
	 * 
	 * @return EsquemaBBDD
	 */
	public EsquemaBBDD clonar() {
		EsqIsProfesor esqIsProfesor = new EsqIsProfesor ();
		return esqIsProfesor;
	}

}
