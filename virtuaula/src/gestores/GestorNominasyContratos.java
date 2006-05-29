package gestores;

import subSistemaBBDD.BBDDFachada;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.*;
/**
 * 
 * @author Alberto Macho
 *
 */
public class GestorNominasyContratos {
// 
	/**
	 * me devuelve todas las nominas
	 */
	public ListaObjetoBean consultaNominas()
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean creador = new CreadorBean();
		ObjetoBean nomina = creador.crear(creador.Nomina);
		return bdf.consultar(nomina);
		
	}
	/**
	 * inserta la nomina que le pasamos en el sistema 
	 * @param nomina
	 * @return cierto o falso dependiendo del exito
	 */
	public boolean insertarNomina(ObjetoBean nomina)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.insertar(nomina);
		
	}
	/**
	 * Inserta un contrato en el sisterma
	 * @param contrato
	 * @return cierto o falso dependiendo del exito
	 */
	public boolean insertarContrato(ObjetoBean contrato)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.insertar(contrato);
	}
}
