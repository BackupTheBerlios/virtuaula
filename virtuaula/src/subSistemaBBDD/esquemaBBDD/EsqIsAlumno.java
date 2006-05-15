package subSistemaBBDD.esquemaBBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import subSistemaBBDD.listaObjeto.*;
import subSistemaBBDD.objetoBaseDatos.*;
import subSistemaBBDD.objetoCriterio.*;

import org.apache.log4j.Logger;

import subSistemaBBDD.utils.*;

public class EsqIsAlumno extends EsquemaBBDD {

	//Declaramos el log de la clase
	private static final Logger log = Logger.getLogger(EsqIsAlumno.class);

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
		if (bResultadoConexion && !obj.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI).equals("")&&
		 !obj.dameValor(Constantes.ALUMNO_NOMBRE).equals("") && !obj.dameValor(Constantes.ALUMNO_APELLIDO1).equals("") 
		 && !obj.dameValor(Constantes.ALUMNO_APELLIDO2).equals("")
		 && !obj.dameValor(Constantes.ALUMNO_TELEFONO).equals("")
		 && !obj.dameValor(Constantes.ALUMNO_EMAIL).equals("")) {
			try {
				instruccion = super.getConexion().createStatement();			
			} catch (SQLException e) {
				log.error(Constantes.ERROR_CONEXION_BBDD);
				log.error(e.getMessage());
			}				
			
			//preparo la sentencia a ejecutar
			sQuery = "INSERT INTO " + super.getBd()+ "." + Constantes.TABLA_ALUMNO + 
			"(" + Constantes.ID_ISALUMNO_ISUSUARIO_DNI + 
			"," + Constantes.ALUMNO_NOMBRE + "," + Constantes.ALUMNO_APELLIDO1 + 
			"," + Constantes.ALUMNO_APELLIDO2 + "," + Constantes.ALUMNO_TELEFONO + "," + 
			Constantes.ALUMNO_EMAIL + "," + Constantes.ALUMNO_DIRECCION + "," + Constantes.ALUMNO_FECH_NACIMIENTO+ "," + 
			Constantes.ALUMNO_SEXO + ") VALUES('" + obj.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI) + "','"+
			obj.dameValor(Constantes.ALUMNO_NOMBRE) + "','" + obj.dameValor(Constantes.ALUMNO_APELLIDO1) + "','" + 
			obj.dameValor(Constantes.ALUMNO_APELLIDO2) + "'," + obj.dameValor(Constantes.ALUMNO_TELEFONO) + ",'" + 
			obj.dameValor(Constantes.ALUMNO_EMAIL) + "','" + obj.dameValor(Constantes.ALUMNO_DIRECCION) + "','" + 
			obj.dameValor(Constantes.ALUMNO_FECH_NACIMIENTO)+ "','" + obj.dameValor(Constantes.ALUMNO_SEXO) + "');";	
	
			try {
				//ejecuto la query
				numFilas = instruccion.executeUpdate(sQuery);
				bResultado = (numFilas != 0);
				log.info("Se han insertado " + numFilas + " filas en la tabla " + Constantes.TABLA_ALUMNO);
			} catch (SQLException e) {
				log.error("Error al insertar ObjetoBBDD en " + Constantes.TABLA_ALUMNO);
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
				sQuery = "DELETE FROM " + super.getBd()+ "." + Constantes.TABLA_ALUMNO + " WHERE "+obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
				
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
					log.info("Se han borrado " + numFilas + " registros de la tabla " + Constantes.TABLA_ALUMNO);
				} catch (SQLException e) {
					log.error("Error al borrar ObjetoBBDD en " + Constantes.TABLA_ALUMNO);
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
		Integer iValor;
		bResultadoConexion = super.conectar();
		if (bResultadoConexion) {
			try {
				instruccion = super.getConexion().createStatement();			
			} catch (SQLException e) {
				log.error(Constantes.ERROR_CONEXION_BBDD);
				log.error(e.getMessage());
			}				
			
			sQuery = "SELECT * FROM " + Constantes.TABLA_ALUMNO;
			if(obj.dameNumCampos()>0){
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
					ObjetoBBDD objetoBBDD = creadorObjetoBBDD.crear(creadorObjetoBBDD.Isalumno);
					objetoBBDD.cambiaValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI , resultSet.getString(Constantes.ID_ISALUMNO_ISUSUARIO_DNI ));
					objetoBBDD.cambiaValor(Constantes.ALUMNO_NOMBRE, resultSet.getString(Constantes.ALUMNO_NOMBRE));
					objetoBBDD.cambiaValor(Constantes.ALUMNO_APELLIDO1 , resultSet.getString(Constantes.ALUMNO_APELLIDO1 ));
					objetoBBDD.cambiaValor(Constantes.ALUMNO_APELLIDO2, resultSet.getString(Constantes.ALUMNO_APELLIDO2));
					iValor = new Integer (resultSet.getInt(Constantes.ALUMNO_TELEFONO));
					objetoBBDD.cambiaValor(Constantes.ALUMNO_TELEFONO , iValor.toString());
					objetoBBDD.cambiaValor(Constantes.ALUMNO_EMAIL, resultSet.getString(Constantes.ALUMNO_EMAIL));
					objetoBBDD.cambiaValor(Constantes.ALUMNO_DIRECCION, resultSet.getString(Constantes.ALUMNO_DIRECCION  ));					
					objetoBBDD.cambiaValor(Constantes.ALUMNO_FECH_NACIMIENTO, resultSet.getString(Constantes.ALUMNO_FECH_NACIMIENTO));
					objetoBBDD.cambiaValor(Constantes.ALUMNO_SEXO, resultSet.getString(Constantes.ALUMNO_SEXO));
					listaObjetoBBDDAbs.insertar(posicion++, objetoBBDD);
				}								
					
			} catch (SQLException e) {
				log.error("Error al consultar ObjetoBBDD en " + Constantes.TABLA_ALUMNO);
				log.error(e.getMessage());
				
			}	
		}		
		super.desconectar();					
	
		return listaObjetoBBDDAbs;
}
	/**
	 * Edita los campos seleccionados de obj en la tabla alumno.
	 * @param obj el ObjetoBBDD a editar.
	 * @return true si la edición se realiza satisfactoriamente, false en caso contrario.
	 */
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
				sQuery = "UPDATE " + super.getBd()+ "." + Constantes.TABLA_ALUMNO + 
				" SET "+obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
				
				//pongo las condiciones siguientes que me vengan en el objeto
				if (obj.dameNumCampos() > 1) {
					while (obj.camposig()) {
						sQuery += "," + obj.dameCampo()+"=" + obj.dameValor(obj.dameCampo());
					}
					sQuery += " where "+Constantes.ID_ISALUMNO_ISUSUARIO_DNI +"="+obj.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI ) ; 
				}
				
				//cierro la sentencia
				sQuery += ";";
				
				try {
					//ejecuto la query
					numFilas = instruccion.executeUpdate(sQuery);
					bResultado = (numFilas != 0);
					log.info("Se han actualizado " + numFilas + " registros de la tabla " + Constantes.TABLA_ALUMNO);
				} catch (SQLException e) {
					log.error("Error al editar ObjetoBBDD en " + Constantes.TABLA_ALUMNO);
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
		EsqIsAlumno esqIsAlumno = new EsqIsAlumno ();
		return esqIsAlumno;
	}
}
