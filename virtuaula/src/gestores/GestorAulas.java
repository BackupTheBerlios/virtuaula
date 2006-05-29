package gestores;

import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.BBDDFachadaAula;
import subSistemaBBDD.utils.Constantes;
import beans.Aula;
import beans.CreadorBean;
import beans.Error;
import beans.ObjetoBean;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
/**
 * Se encarga de realizar las operaciones sobre las Aulas
 * @author AL
 *
 */
public class GestorAulas {

	public GestorAulas() {
		super();
	}
/**
 * 
 * @return Me devulve una lista con todas las aulas existentes
 */
	public ListaObjetoBean consultaAulas() {
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean cBean = new CreadorBean();
		Aula aula = (Aula) cBean.crear(2);
		ListaObjetoBean l = bdf.consultar(aula);
		return l;
	}
	/**
	 * 
	 * @param beanHorario
	 * @return me devuelve las aulas que estan libres en el horario que le pasamos
	 */
	public ListaObjetoBean consultaAulasPorHorario (ObjetoBean beanHorario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaAula bdfa= (BBDDFachadaAula)(bdf.dameBBDDFachada(Constantes.FachadaAula));
		ListaObjetoBean l = bdfa.dameAulasLibres(beanHorario);	
		return l;
	}
	/**
	 * Hace una comparacion del aula que le pasamos por parametro
	 * @param bean
	 * @return lista de errores
 	 */
	private ListaObjetoBean comprobar(ObjetoBean bean) {
		CreadorListaObjetoBean c = new CreadorListaObjetoBean();
		CreadorBean cBean = new CreadorBean();
		ListaObjetoBean listaerror = c.crear();
		String mensaje = "";
		int i = 0;
		

		//La capacidad debe ser un entero mayor que 0
		if (!bean.dameValor(Constantes.AULA_CAPACIDAD).equals("")){
			try {
				int cap = Integer.parseInt(bean.dameValor(Constantes.AULA_CAPACIDAD));
				if (cap < 0) {
					mensaje = "El campo Capacidad tiene un valor incorrecto. " +
							  "Debe ser un entero mayor que 0";
					Error error = (Error) cBean.crear(14);
					error.cambiaValor("CAUSA_ERROR", mensaje);
					listaerror.insertar(i, error);
					i++;
				}
			  } 
			  catch (Exception e) {
				// No es n�mero
				mensaje = "El campo Capacidad tiene un valor incorrecto. Debe ser un" +
						  "entero mayor que 0";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			  }
		}
		return listaerror;
	}
}
