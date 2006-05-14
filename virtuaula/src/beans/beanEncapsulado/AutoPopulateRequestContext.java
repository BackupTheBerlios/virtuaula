package beans.beanEncapsulado;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

import beans.ObjetoBean;

public class AutoPopulateRequestContext {

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
