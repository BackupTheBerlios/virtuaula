package gestores;

import subSistemaBBDD.BBDDFachada;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

/**
 * Se encarga de realizar todas las operaciones necesarias para gestionar las
 * nominas y los contratos
 * 
 * @author Alberto Macho
 * 
 */
public class GestorNominasyContratos {
	// 
	/**
	 * Devuelve todas las nominas
	 * 
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultaNominas() {
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean creador = new CreadorBean();
		ObjetoBean nomina = creador.crear(creador.Nomina);
		return bdf.consultar(nomina);

	}

	/**
	 * Inserta la nomina que le pasamos en el sistema
	 * 
	 * @param nomina
	 * @return true o false dependiendo del exito
	 */
	public boolean insertarNomina(ObjetoBean nomina) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.insertar(nomina);

	}

	/**
	 * Inserta un contrato en el sisterma
	 * 
	 * @param contrato
	 * @return true o false dependiendo del exito
	 */
	public boolean insertarContrato(ObjetoBean contrato) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.insertar(contrato);
	}
}
