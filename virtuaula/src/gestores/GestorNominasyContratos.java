package gestores;

import subSistemaBBDD.BBDDFachada;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.listaObjetoBeans.*;
public class GestorNominasyContratos {
// me devuelve todas las nominas
	public ListaObjetoBean consultaNominas()
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean creador = new CreadorBean();
		ObjetoBean nomina = creador.crear(creador.Nomina);
		return bdf.consultar(nomina);
		
	}
	public boolean insertarNomina(ObjetoBean nomina)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.insertar(nomina);
		
	}
	
	public boolean insertarContrato(ObjetoBean contrato)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.insertar(contrato);
	}
}
