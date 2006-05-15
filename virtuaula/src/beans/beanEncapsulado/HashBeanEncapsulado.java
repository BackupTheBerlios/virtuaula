package beans.beanEncapsulado;

import beans.CreadorBean;
import beans.ObjetoBean;
import java.util.Hashtable;

public class HashBeanEncapsulado {

	/**
	 * tabla que guarda la relación entre un identificador de bean y su
	 * constructor
	 */
	protected static Hashtable tabIdConstructor;

	/**
	 * Constructor
	 * 
	 */
	public HashBeanEncapsulado() {
		

		if (tabIdConstructor == null) {
			tabIdConstructor = new Hashtable();
		}
		tabIdConstructor.put("Alumno","0");
		tabIdConstructor.put("Area","1");
		tabIdConstructor.put("Aula", "2");
		tabIdConstructor.put("Avisos", "3");
		tabIdConstructor.put("Avisos_Has_Usuario", "4");
		tabIdConstructor.put("Contrato", "5");
		tabIdConstructor.put("Curso", "6");
		tabIdConstructor.put("Curso_Has_Alumno", "7");
		tabIdConstructor.put("Horario", "8");
		tabIdConstructor.put("Horario_Has_Aula", "9");
		tabIdConstructor.put("Nomina", "10");
		tabIdConstructor.put("Profesor", "11");
		tabIdConstructor.put("Usuario", "12");
		tabIdConstructor.put("Ficha", "13");
		tabIdConstructor.put("Error", "14");
	}

	public ObjetoBean dameBean(String tipo) {
		CreadorBean c = new CreadorBean();
		ObjetoBean result = null;
		int num = Integer.parseInt((String)tabIdConstructor.get(tipo));
		result = (ObjetoBean) c.crear(num);

		return result;
	}
}
