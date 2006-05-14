package subSistemaBBDD.esquemaBBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import subSistemaBBDD.listaObjeto.*;
import subSistemaBBDD.objetoBaseDatos.*;
import subSistemaBBDD.objetoCriterio.*;

import org.apache.log4j.Logger;

import subSistemaBBDD.utils.*;

public class EsqIsHorario extends EsquemaBBDD {
	
	//Declaramos el log de la clase
	private static final Logger log = Logger.getLogger(EsqIsHorario.class);

	public boolean insertar(ObjetoBBDD obj) {
		
		//variables a utilizar
		boolean bResultado = false;
		boolean bResultadoConexion;
		String sQuery = "";
		Statement instruccion = null;
		int numFilas;
				
		bResultadoConexion = super.conectar();
		if (bResultadoConexion) {
			try {
				instruccion = super.getConexion().createStatement();			
			} catch (SQLException e) {
				log.error(Constantes.ERROR_CONEXION_BBDD);
				log.error(e.getMessage());
			}				
			
			sQuery = "INSERT INTO " + super.getBd()+ "." + Constantes.TABLA_HORARIO + "(" + Constantes.HORARIO_LUNES + "," + Constantes.HORARIO_MARTES + "," + Constantes.HORARIO_MIERCOLES + "," + Constantes.HORARIO_JUEVES + "," + Constantes.HORARIO_VIERNES + ") VALUES('" + obj.dameValor(Constantes.HORARIO_LUNES) + "','"+obj.dameValor(Constantes.HORARIO_MARTES) + "','"+obj.dameValor(Constantes.HORARIO_MIERCOLES) + "','"+obj.dameValor(Constantes.HORARIO_JUEVES) + "','"+obj.dameValor(Constantes.HORARIO_VIERNES) + "');";	
	
			try {
				numFilas = instruccion.executeUpdate(sQuery);
				bResultado = (numFilas != 0);
				log.info("Se han insertado " + numFilas + " filas en la tabla " + Constantes.TABLA_HORARIO);
			} catch (SQLException e) {
				log.error("Error al insertar ObjetoBBDD en " + Constantes.TABLA_HORARIO);
				log.error(e.getMessage());
				
			}	
		}		
		super.desconectar();
		
		return bResultado;
	}

	/**
	 * Borra el ObjetoCriterio que le pasamos como argumento de la base de datos. Éste lo realiza mediante las </b>
	 * condiciones que me vengan el el objeto que pasamos como parámetro.
	 * 
	 * @return 	True si el borrado se ha ejecutado correctamente </b>
	 * 			False en caso contrario o en el caso de que en el objeto que se le pasa como argumento no viene ningún criterio de búsqueda.
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
				
				//Como mínimo tiene que haber un criterio de búsqueda.
				//Aparte el valor me lo tiene que saber dar del campo que pongo en la condición
				sQuery = "DELETE FROM " + super.getBd()+ "." + Constantes.TABLA_HORARIO + " WHERE "+obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
				
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
					log.info("Se han borrado " + numFilas + " registros de la tabla " + Constantes.TABLA_HORARIO);
				} catch (SQLException e) {
					log.error("Error al borrar ObjetoBBDD en " + Constantes.TABLA_HORARIO);
					log.error(e.getMessage());
					
				}	
			}		
			super.desconectar();
		}
		return bResultado;

	}

	/**
	 * Devuelve una ListaObjetoBBDDAbs tras realizar la consulta a la BBDD según los criterios que vengan en el </b>
	 * objeto que me pasan como argumento.
	 * 
	 * @return ListaObjetoBBDDAbs con el resultado de la query. </b>
	 * 			Si el objeto que le pasamos como argumento viene sin criterio de búsqueda la lista se devuelve vacía.
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
			
		if (obj.dameNumCampos() != 0) {
			bResultadoConexion = super.conectar();
			if (bResultadoConexion) {
				try {
					instruccion = super.getConexion().createStatement();			
				} catch (SQLException e) {
					log.error(Constantes.ERROR_CONEXION_BBDD);
					log.error(e.getMessage());
				}				
				
				sQuery = "SELECT * FROM " + Constantes.TABLA_HORARIO;
				sQuery += " WHERE ";
				sQuery += obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
				while (obj.camposig()) {
					sQuery += " AND " + obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
				}		
				
				//cierro la sentencia
				sQuery += ";";
				
				try {
					//ejecuto la query
					resultSet = (ResultSet) instruccion.executeQuery(sQuery);								
					while (resultSet.next()) {
						ObjetoBBDD objetoBBDD = creadorObjetoBBDD.crear(creadorObjetoBBDD.Ishorario);
						objetoBBDD.cambiaValor(Constantes.ID_ISHORARIO, resultSet.getString(Constantes.ID_ISHORARIO));
						objetoBBDD.cambiaValor(Constantes.HORARIO_LUNES, resultSet.getString(Constantes.HORARIO_LUNES));
						objetoBBDD.cambiaValor(Constantes.HORARIO_MARTES, resultSet.getString(Constantes.HORARIO_MARTES));
						objetoBBDD.cambiaValor(Constantes.HORARIO_MIERCOLES, resultSet.getString(Constantes.HORARIO_MIERCOLES));
						objetoBBDD.cambiaValor(Constantes.HORARIO_JUEVES, resultSet.getString(Constantes.HORARIO_JUEVES));
						objetoBBDD.cambiaValor(Constantes.HORARIO_VIERNES, resultSet.getString(Constantes.HORARIO_VIERNES));
						listaObjetoBBDDAbs.insertar(posicion++, objetoBBDD);
					}								
					
				} catch (SQLException e) {
					log.error("Error al consultar ObjetoBBDD en " + Constantes.TABLA_HORARIO);
					log.error(e.getMessage());
					
				}	
			}		
			super.desconectar();					
		}
		return listaObjetoBBDDAbs;

	}
	
//	Las ediciones se realizan sobre entradas obtenidas a traves de una consulta con lo que
	//el objetoCriterio obj siempre tendrá el campo identificador relleno (ID de cada fila de la tabla)
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
				
				//Como mínimo tiene que haber un criterio de búsqueda.
				//Aparte el valor me lo tiene que saber dar del campo que pongo en la condición
				sQuery = "UPDATE " + super.getBd()+ "." + Constantes.TABLA_HORARIO+ 
				" SET "+obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
				
				//pongo las condiciones siguientes que me vengan en el objeto
				if (obj.dameNumCampos() > 1) {
					while (obj.camposig()) {
						sQuery += "," + obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
					}
					sQuery += " where "+Constantes.ID_ISHORARIO +"="+obj.dameValor(Constantes.ID_ISHORARIO) ; 
				}
				
				//cierro la sentencia
				sQuery += ";";
				
				try {
					//ejecuto la query
					numFilas = instruccion.executeUpdate(sQuery);
					bResultado = (numFilas != 0);
					log.info("Se han actualizado " + numFilas + " registros de la tabla " + Constantes.TABLA_HORARIO);
				} catch (SQLException e) {
					log.error("Error al editar ObjetoBBDD en " + Constantes.TABLA_HORARIO);
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
		EsqIsHorario esqIsHorario = new EsqIsHorario ();
		return esqIsHorario;
	}

}
