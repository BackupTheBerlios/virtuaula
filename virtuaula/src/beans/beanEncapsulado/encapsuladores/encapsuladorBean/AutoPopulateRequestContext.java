package beans.beanEncapsulado.encapsuladores.encapsuladorBean;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import beans.ObjetoBean;
/**
 * Patron que permite rellenar siguiendo la igualdad entre los nombres de los parametros y los nombres de los atributos
 * @author Diego Cardiel
 *
 */
public class AutoPopulateRequestContext {
	/**
	 * Realiza la encapsulacion por medio de esa semejanza
	 * @param bean Objeto en el que se quiere encapsular
	 * @param request contenedor que contiene los parametros que se quieren encapsular
	 */
	public static void populateBean(ObjetoBean bean, HttpServletRequest request) {

		Enumeration enume = request.getParameterNames();
		while (enume.hasMoreElements()) {
			String parameterName = (String) enume.nextElement();
			String values[] = request.getParameterValues(parameterName);
			try {
				if (values.length == 1) {
					bean.cambiaValor(parameterName, values[0]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
