package gestores;

import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.utils.Constantes;
import beans.CreadorBean;
import beans.Error;
import beans.Ficha;
import beans.ObjetoBean;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

public class GestorFichas {

	public GestorFichas() {
		super();
	}

	public Ficha consultaFichaDeAlumno(ObjetoBean beanAlumno,ObjetoBean beanCurso) {	
		BBDDFachada bdf = BBDDFachada.getInstance();	
		return  (Ficha) bdf.dameFichaAlumnoCurso(beanAlumno, beanCurso);
	}
	
	public ListaObjetoBean editarFicha(ObjetoBean beanFicha){
		ListaObjetoBean result = comprobar(beanFicha);
		CreadorBean cBean = new CreadorBean();
		if (result.esVacio()) {
			BBDDFachada bdf = BBDDFachada.getInstance();
			if(!bdf.editar(beanFicha)){
				String mensaje = "Error de Base de Datos";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				result.insertar(0, error);
				return result;
			}
			else return null;
		}
		return result;
	}
	
	public boolean insertarFicha(ObjetoBean ficha)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.insertar(ficha);
		
	}
	public ListaObjetoBean consultarFicha(ObjetoBean ficha)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.consultar(ficha);
	}
	
	private ListaObjetoBean comprobar(ObjetoBean bean) {
		CreadorListaObjetoBean c = new CreadorListaObjetoBean();
		CreadorBean cBean = new CreadorBean();
		ListaObjetoBean l = c.crear();
		String mensaje = "";
		int i = 0;

		// comprobar que los campos numericos no contienen letras
		if (!bean.dameValor(Constantes.FICHA_NOTAS_EJERCICIOS).equals("")) {
			try {
				int numerico = Integer.parseInt(bean
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
		if (!bean.dameValor(Constantes.FICHA_NOTAS).equals("")) {
			try {
				int numerico = Integer.parseInt(bean
						.dameValor(Constantes.FICHA_NOTAS));
			} catch (Exception e) {
				// No es número
				mensaje = "El campo NOTAS debe ser numérico";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				l.insertar(i, error);
				i++;
			}
		}

		return l;
	}

}
