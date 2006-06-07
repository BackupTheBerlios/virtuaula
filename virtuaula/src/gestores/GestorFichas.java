package gestores;

import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.BBDDFachadaFicha;
import subSistemaBBDD.utils.Constantes;
import beans.CreadorBean;
import beans.Error;
import beans.Ficha;
import beans.ObjetoBean;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

/**
 * Realiza las operaciones sobre las Fichas
 * 
 * @author AL
 * 
 */
public class GestorFichas {

	public GestorFichas() {
		super();
	}

	/**
	 * Devuelve la ficha de un alumno en el curso
	 * 
	 * @param beanAlumno
	 * @param beanCurso
	 * @return Ficha
	 */
	public Ficha consultaFichaDeAlumno(ObjetoBean beanAlumno,
			ObjetoBean beanCurso) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaFicha bdff = (BBDDFachadaFicha) (bdf
				.dameBBDDFachada(Constantes.FachadaFicha));
		return (Ficha) bdff.dameFichaAlumnoCurso(beanAlumno, beanCurso);
	}

	/**
	 * Modifica la ficha de un alumno
	 * 
	 * @param beanFicha
	 * @return ListaObjetoBean Contiene posibles errores que se pueden producir
	 */
	public ListaObjetoBean editarFicha(ObjetoBean beanFicha) {
		ListaObjetoBean result = comprobar(beanFicha);
		CreadorBean cBean = new CreadorBean();
		if (result.esVacio()) {
			BBDDFachada bdf = BBDDFachada.getInstance();
			if (!bdf.editar(beanFicha)) {
				String mensaje = "Error de Base de Datos";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				result.insertar(0, error);
				return result;
			} else
				return null;
		}
		return result;

	}

	/**
	 * Modifica la ficha
	 * 
	 * @param beanFicha
	 * @return boolean true o false dependiendo del exito de la operacion
	 */
	public boolean cambiaFicha(ObjetoBean beanFicha) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.editar(beanFicha);
	}

	/**
	 * Elimina la ficha del sistema
	 * 
	 * @param ficha
	 * @return true o false dependiendo del exito de la operacion
	 */
	public boolean eliminarFicha(ObjetoBean ficha) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.eliminar(ficha);
	}

	/**
	 * Inserta una ficha en el sistema
	 * 
	 * @param ficha
	 * @return true o false dependiendo del exito de la operacion
	 */
	public boolean insertarFicha(ObjetoBean ficha) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.insertar(ficha);

	}

	/**
	 * Devuelve una lista de fichas que se corresponden con las caracteristicas
	 * de la ficha que le pasamos por parametro
	 * 
	 * @param ficha
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultarFicha(ObjetoBean ficha) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.consultar(ficha);
	}

	/**
	 * Comprueba si los datos de la ficha son correctos
	 * 
	 * @param bean
	 * @return ListaObjetoBean una lista de errores posibles
	 */
	private ListaObjetoBean comprobar(ObjetoBean bean) {
		CreadorListaObjetoBean c = new CreadorListaObjetoBean();
		CreadorBean cBean = new CreadorBean();
		ListaObjetoBean l = c.crear();
		String mensaje = "";
		int i = 0;

		// comprobar que los campos numericos no contienen letras
		if (!bean.dameValor(Constantes.FICHA_NOTAS_EJERCICIOS).equals("")) {
			try {
				Integer.parseInt(bean
						.dameValor(Constantes.FICHA_NOTAS_EJERCICIOS));
			} catch (Exception e) {
				// No es número
				mensaje = "El campo notas de ejercicios debe ser numérico";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				l.insertar(i, error);
				i++;
			}
		}
		return l;
	}

}
