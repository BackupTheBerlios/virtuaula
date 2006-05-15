package subSistemaBBDD.esquemaBBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import subSistemaBBDD.listaObjeto.*;
import subSistemaBBDD.objetoBaseDatos.*;
import subSistemaBBDD.objetoCriterio.*;

import org.apache.log4j.Logger;

import subSistemaBBDD.utils.*;
public class EsqIsCurso extends EsquemaBBDD {

	//Declaramos el log de la clase
	private static final Logger log = Logger.getLogger(EsqIsCurso.class);
	
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
			
		//conecto con con la base de datos
		bResultadoConexion = super.conectar();
		if (bResultadoConexion && !obj.dameValor(Constantes.ID_ISCURSO_IDISCURSO).equals("")
				&& !obj.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI).equals("")				
				&& !obj.dameValor(Constantes.CURSO_ISAREA_IDISAREA).equals("")) {
			try {
				instruccion = super.getConexion().createStatement();			
			} catch (SQLException e) {
				log.error(Constantes.ERROR_CONEXION_BBDD);
				log.error(e.getMessage());
			}				
			
			//preparo la sentencia a ejecutar
			sQuery = "INSERT INTO " + super.getBd()+ "." + Constantes.TABLA_CURSO + "(" + Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI + "," + Constantes.CURSO_ISAREA_IDISAREA + "," + Constantes.CURSO_NOMBRE + "," + Constantes.CURSO_NUMERO_PLAZAS + "," + Constantes.CURSO_ESTADO + "," + Constantes.CURSO_FECHA_INICIO + "," + Constantes.CURSO_FECHA_FIN+ "," + Constantes.CURSO_PRECIO + ") VALUES('" + obj.dameValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI) + "',"+obj.dameValor(Constantes.CURSO_ISAREA_IDISAREA) + ",'" + obj.dameValor(Constantes.CURSO_NOMBRE) + "'," + obj.dameValor(Constantes.CURSO_NUMERO_PLAZAS) + ",'" + obj.dameValor(Constantes.CURSO_ESTADO) + "','" + obj.dameValor(Constantes.CURSO_FECHA_INICIO) + "','" + obj.dameValor(Constantes.CURSO_FECHA_FIN) + "'," + obj.dameValor(Constantes.CURSO_PRECIO) + ");";	
	
			try {
				//ejecuto la query
				numFilas = instruccion.executeUpdate(sQuery);
				bResultado = (numFilas != 0);
				log.info("Se han insertado " + numFilas + " filas en la tabla " + Constantes.TABLA_CURSO);
			} catch (SQLException e) {
				log.error("Error al insertar ObjetoBBDD en " + Constantes.TABLA_CURSO);
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
				sQuery = "DELETE FROM " + super.getBd()+ "." + Constantes.TABLA_CURSO + " WHERE "+obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
				
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
					log.info("Se han borrado " + numFilas + " registros de la tabla " + Constantes.TABLA_CURSO);
				} catch (SQLException e) {
					log.error("Error al borrar ObjetoBBDD en " + Constantes.TABLA_CURSO);
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
		Float fValor;
		bResultadoConexion = super.conectar();
		if (bResultadoConexion) {
			try {
				instruccion = super.getConexion().createStatement();			
			} catch (SQLException e) {
				log.error(Constantes.ERROR_CONEXION_BBDD);
				log.error(e.getMessage());
			}				
			
			sQuery = "SELECT * FROM " + Constantes.TABLA_CURSO;
			if (obj.dameNumCampos() > 0) {
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
					ObjetoBBDD objetoBBDD = creadorObjetoBBDD.crear(creadorObjetoBBDD.Iscurso);
					objetoBBDD.cambiaValor(Constantes.ID_ISCURSO_IDISCURSO , resultSet.getString(Constantes.ID_ISCURSO_IDISCURSO));
					objetoBBDD.cambiaValor(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI, resultSet.getString(Constantes.CURSO_ISPROFESOR_ISUSUARIO_DNI));
					objetoBBDD.cambiaValor(Constantes.CURSO_ISAREA_IDISAREA , resultSet.getString(Constantes.CURSO_ISAREA_IDISAREA));
					objetoBBDD.cambiaValor(Constantes.CURSO_NOMBRE, resultSet.getString(Constantes.CURSO_NOMBRE));
					objetoBBDD.cambiaValor(Constantes.CURSO_NUMERO_PLAZAS , resultSet.getString(Constantes.CURSO_NUMERO_PLAZAS));
					objetoBBDD.cambiaValor(Constantes.CURSO_ESTADO, resultSet.getString(Constantes.CURSO_ESTADO));
					objetoBBDD.cambiaValor(Constantes.CURSO_FECHA_INICIO, resultSet.getString(Constantes.CURSO_FECHA_INICIO));
					objetoBBDD.cambiaValor(Constantes.CURSO_FECHA_FIN, resultSet.getString(Constantes.CURSO_FECHA_FIN));
					fValor = new Float (resultSet.getFloat(Constantes.CURSO_PRECIO));
					objetoBBDD.cambiaValor(Constantes.CURSO_PRECIO, fValor.toString());
					listaObjetoBBDDAbs.insertar(posicion++, objetoBBDD);
				}								
				
				} catch (SQLException e) {
				log.error("Error al consultar ObjetoBBDD en " + Constantes.TABLA_CURSO);
				log.error(e.getMessage());
				
			}	
		}		
		super.desconectar();					
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
				sQuery = "UPDATE " + super.getBd()+ "." + Constantes.TABLA_CURSO + 
				" SET "+obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
				
				//pongo las condiciones siguientes que me vengan en el objeto
				if (obj.dameNumCampos() > 1) {
					while (obj.camposig()) {
						sQuery += "," + obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
					}
					sQuery += " where "+Constantes.ID_ISCURSO_IDISCURSO +"="+obj.dameValor(Constantes.ID_ISCURSO_IDISCURSO) ; 
				}
				
				//cierro la sentencia
				sQuery += ";";
				
				try {
					//ejecuto la query
					numFilas = instruccion.executeUpdate(sQuery);
					bResultado = (numFilas != 0);
					log.info("Se han actualizado " + numFilas + " registros de la tabla " + Constantes.TABLA_CURSO);
				} catch (SQLException e) {
					log.error("Error al editar ObjetoBBDD en " + Constantes.TABLA_CURSO);
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
		EsqIsCurso esqIsCurso = new EsqIsCurso ();
		return esqIsCurso;
	}

}
