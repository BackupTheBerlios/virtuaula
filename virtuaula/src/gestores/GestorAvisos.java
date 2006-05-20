package gestores;

import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.utils.Constantes;
import beans.CreadorBean;
import beans.Error;
import beans.ObjetoBean;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

public class GestorAvisos {

	public GestorAvisos() {
		super();
	}

	public ListaObjetoBean consultaAvisos(ObjetoBean beanUsuario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		ListaObjetoBean l = bdf.dameAvisosUsuario(beanUsuario);
		return l;
	}
	/**
	 * me borra el aviso y la relacion
	 */
	public boolean borraAviso(ObjetoBean beanAviso,ObjetoBean usuavi){
		BBDDFachada bdf = BBDDFachada.getInstance();
    	return   ((bdf.eliminar(usuavi)) && (bdf.eliminar(beanAviso)) );
	}
	
	private ListaObjetoBean comprobar(ObjetoBean bean) {
		CreadorListaObjetoBean c = new CreadorListaObjetoBean();
		CreadorBean cBean = new CreadorBean();
		ListaObjetoBean listaerror = c.crear();
		String mensaje = "";
		int i = 0;	
	    int dia1 = 0, dia2 = 0, mes1 = 0, mes2 = 0, annio1 = 0, annio2 = 0;

        if (!bean.dameValor(Constantes.AVISOS_FECHA_AVISO).equals("")) {
		   String fechaInicio = bean.dameValor(Constantes.AVISOS_FECHA_AVISO);
		   try {
			 dia1 = Integer.parseInt(fechaInicio.substring(0, 1));
			 if ((dia1 < 1) || (dia1 > 31)) {
				mensaje = "Formato de fecha aviso incorrecto. Debe ser un entero" +
						  "entre 1 y 31";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			 }
		   } catch (Exception e) {
			 // No es número
			 mensaje = "Formato de fecha aviso incorrecto. Debe ser un entero" +
					   "entre 1 y 31";
			 Error error = (Error) cBean.crear(14);
			 error.cambiaValor("CAUSA_ERROR", mensaje);
			 listaerror.insertar(i, error);
			 i++;
		   }
		   try {
			  mes1 = Integer.parseInt(fechaInicio.substring(3, 4));
			  if ((mes1 < 1) || (mes1 > 12)) {
				 mensaje = "Formato de fecha aviso incorrecto. Debe ser un entero" +
				           "entre 1 y 12";
				 Error error = (Error) cBean.crear(14);
				 error.cambiaValor("CAUSA_ERROR", mensaje);
				 listaerror.insertar(i, error);
				 i++;
			  }
		   } catch (Exception e) {
			// No es número
			 mensaje = "Formato de fecha aviso incorrecto. Debe ser un entero" +
	                   "entre 1 y 12";
			 Error error = (Error) cBean.crear(14);
			 error.cambiaValor("CAUSA_ERROR", mensaje);
			 listaerror.insertar(i, error);
			 i++;
		  }
		  try {
			annio1 = Integer.parseInt(fechaInicio.substring(6, 9));
			if ((annio1 < 0000) || (annio1 > 9999)) {
				mensaje = "Formato de fecha aviso incorrecto. Debe ser un entero de" +
						  "4 dígitos";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			}
		  } catch (Exception e) {
			// No es número
			mensaje = "Formato de fecha aviso incorrecto. Debe ser un entero de" +
			          "4 dígitos";
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		  }
	    }
        if (!bean.dameValor(Constantes.AVISOS_FECHA_CADUCUDAD).equals("")) {
		  String fechaFin = bean.dameValor(Constantes.AVISOS_FECHA_CADUCUDAD);
		  try {
			dia2 = Integer.parseInt(fechaFin.substring(0, 1));
			if ((dia2 < 1) || (dia2 > 31)) {
				mensaje = "Formato de fecha caducidad incorrecto. Debe ser un entero" +
				          "entre 1 y 31";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			}
		  } catch (Exception e) {
			// No es número
			mensaje = "Formato de fecha caducidad incorrecto. Debe ser un entero" +
			          "entre 1 y 31";
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		  }
		  try {
			mes2 = Integer.parseInt(fechaFin.substring(3, 4));
			if ((mes2 < 1) || (mes2 > 12)) {
				mensaje = "Formato de fecha caducidad incorrecto. Debe ser un entero" +
				          "entre 1 y 12";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			}
		  } catch (Exception e) {
			// No es número
			mensaje = "Formato de fecha caducidad incorrecto. Debe ser un entero" +
	                  "entre 1 y 12";
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		  }
		  try {
			annio2 = Integer.parseInt(fechaFin.substring(6, 9));
			if ((annio2 < 0000) || (annio2 > 9999)) {
				mensaje = "Formato de fecha caducidad incorrecto. Debe ser un entero de" +
		          		  "4 dígitos";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			}
		  } catch (Exception e) {
			// No es número
			mensaje = "Formato de fecha caducidad incorrecto. Debe ser un entero de" +
					  "4 dígitos";
			Error error = (Error) cBean.crear(14);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			listaerror.insertar(i, error);
			i++;
		  }
		  boolean fechasValidas = false;
		  if (!bean.dameValor(Constantes.AVISOS_FECHA_CADUCUDAD).equals("")
					&& (!bean.dameValor(Constantes.AVISOS_FECHA_CADUCUDAD).equals(""))) {
				if (annio1 < annio2){
					fechasValidas = true;
				}
				else if (annio1 == annio2){
					if (mes1 < mes2){
						fechasValidas = true;
					} 
					else if (mes1 == mes2){
						if (dia1 <= dia2){
							fechasValidas = true;
						}
					}
				}
			}
			if (!fechasValidas) {
				mensaje = "Los campos fecha aviso y fecha caducidad entran en " +
						  "conflicto. Asegúrese que la fecha de caducidad del aviso " +
						  "es posterior a la de inicio";
				Error error = (Error) cBean.crear(14);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				listaerror.insertar(i, error);
				i++;
			}
        }
        return listaerror;
	}
}
