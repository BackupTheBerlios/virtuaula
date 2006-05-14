package subSistemaBBDD.esquemaBBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import subSistemaBBDD.listaObjeto.*;
import subSistemaBBDD.objetoBaseDatos.*;
import subSistemaBBDD.objetoCriterio.*;

import org.apache.log4j.Logger;

import subSistemaBBDD.utils.*;

public class EsqIsCursoHasIsAlumno extends EsquemaBBDD {

	//Declaramos el log de la clase
	private static final Logger log = Logger.getLogger(EsqIsCursoHasIsAlumno.class);
	
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
		if (bResultadoConexion) {
			try {
				instruccion = super.getConexion().createStatement();			
			} catch (SQLException e) {
				log.error(Constantes.ERROR_CONEXION_BBDD);
				log.error(e.getMessage());
			}				
			
			sQuery = "INSERT INTO " + super.getBd()+ "." + Constantes.TABLA_ISCURSO_HAS_ISALUMNO + "(" + Constantes.ID_HAS_ISCURSO_IDISCURSO + "," + Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI + "," + Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA + "," + Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL + ") VALUES(" + obj.dameValor(Constantes.ID_HAS_ISCURSO_IDISCURSO) + ",'"+obj.dameValor(Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI) + "',"+obj.dameValor(Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA) + "," + obj.dameValor(Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL) + ");";	
	
			try {
				numFilas = instruccion.executeUpdate(sQuery);
				bResultado = (numFilas != 0);
				log.info("Se han insertado " + numFilas + " filas en la tabla " + Constantes.TABLA_ISCURSO_HAS_ISALUMNO);
			} catch (SQLException e) {
				log.error("Error al insertar ObjetoBBDD en " + Constantes.TABLA_ISCURSO_HAS_ISALUMNO);
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
				sQuery = "DELETE FROM " + super.getBd()+ "." + Constantes.TABLA_ISCURSO_HAS_ISALUMNO + " WHERE "+obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
				
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
					log.info("Se han borrado " + numFilas + " registros de la tabla " + Constantes.TABLA_ISCURSO_HAS_ISALUMNO);
				} catch (SQLException e) {
					log.error("Error al borrar ObjetoBBDD en " + Constantes.TABLA_ISCURSO_HAS_ISALUMNO);
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
				
				sQuery = "SELECT * FROM " + Constantes.TABLA_ISCURSO_HAS_ISALUMNO;
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
						ObjetoBBDD objetoBBDD = creadorObjetoBBDD.crear(creadorObjetoBBDD.IscursoHasIsalumno);
						objetoBBDD.cambiaValor(Constantes.ID_HAS_ISCURSO_IDISCURSO, resultSet.getString(Constantes.ID_HAS_ISCURSO_IDISCURSO));
						objetoBBDD.cambiaValor(Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI, resultSet.getString(Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI));
						objetoBBDD.cambiaValor(Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA, resultSet.getString(Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA));
						objetoBBDD.cambiaValor(Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL, resultSet.getString(Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL));					
						listaObjetoBBDDAbs.insertar(posicion++, objetoBBDD);
					}								
					
				} catch (SQLException e) {
					log.error("Error al consultar ObjetoBBDD en " + Constantes.TABLA_ISCURSO_HAS_ISALUMNO);
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
				sQuery = "UPDATE " + super.getBd()+ "." + Constantes.TABLA_ISCURSO_HAS_ISALUMNO+ 
				" SET "+obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
				
				//pongo las condiciones siguientes que me vengan en el objeto
				if (obj.dameNumCampos() > 1) {
					while (obj.camposig()) {
						sQuery += "," + obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
					}
					sQuery += " where "+Constantes.ID_HAS_ISCURSO_IDISCURSO+"="+obj.dameValor(Constantes.ID_HAS_ISCURSO_IDISCURSO) ; 
				}
				
				//cierro la sentencia
				sQuery += ";";
				
				try {
					//ejecuto la query
					numFilas = instruccion.executeUpdate(sQuery);
					bResultado = (numFilas != 0);
					log.info("Se han actualizado " + numFilas + " registros de la tabla " + Constantes.TABLA_ISCURSO_HAS_ISALUMNO);
				} catch (SQLException e) {
					log.error("Error al editar ObjetoBBDD en " + Constantes.TABLA_ISCURSO_HAS_ISALUMNO);
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
		EsqIsCursoHasIsAlumno cursoHasIsAlumno = new EsqIsCursoHasIsAlumno ();
		return cursoHasIsAlumno;
	}

}
