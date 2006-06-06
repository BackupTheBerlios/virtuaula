package gestores;

import java.text.SimpleDateFormat;
import java.util.Date;

import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.BBDDFachadaHorario;
import subSistemaBBDD.utils.Constantes;
import beans.CreadorBean;
import beans.Horario;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

/**
 * 
 * Realiza operaciones sobre los horarios
 * 
 * @author AL
 */
public class GestorHorarios {

	public GestorHorarios() {
		super();
	}

	/**
	 * Inserta un horario en el sistema
	 * 
	 * @param horario
	 * @return boolean true si la operacion tiene exito. false en caso contrario
	 */
	public boolean insertarHorario(ObjetoBean horario) {
		horario.cambiaValor(Constantes.ID_ISHORARIO, "1");
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaHorario bdfh = (BBDDFachadaHorario) bdf
				.dameBBDDFachada(Constantes.FachadaHorario);
		return bdfh.insertar(horario);
	}

	/**
	 * Nos dice si algun curso utiliza el horario pasado como parámetro
	 * 
	 * @param horario
	 * @return boolean
	 */
	public boolean horarioUtilizado(ObjetoBean horario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaHorario bdfh = (BBDDFachadaHorario) bdf
				.dameBBDDFachada(Constantes.FachadaHorario);
		return bdfh.horarioUtilizado(horario);
	}

	/**
	 * Dado un horario devuelve true si ya existe otro con el mismo nombre o
	 * contenido.
	 * 
	 * @param horario
	 * @return boolean
	 */
	public boolean horarioYaExiste(ObjetoBean horario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaHorario bdfh = (BBDDFachadaHorario) bdf
				.dameBBDDFachada(Constantes.FachadaHorario);
		return bdfh.horarioYaExiste(horario);
	}

	/**
	 * Nos devuelve una lista de horarios existentes
	 * 
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultaHorarios() {
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean cBean = new CreadorBean();
		Horario horario = (Horario) cBean.crear(8);
		ListaObjetoBean l = bdf.consultar(horario);
		return l;
	}

	/**
	 * Devuelve una lista de beans con todos los horarios fijados en el sistema
	 * 
	 * @return ListaObjetoBean
	 */
	public ListaObjetoBean consultaHorariosDisponibles() {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaHorario bdfh = (BBDDFachadaHorario) bdf
				.dameBBDDFachada(Constantes.FachadaHorario);
		ListaObjetoBean l = bdfh.dameHorariosDisponibles();
		return l;
	}

	/**
	 * Elimina el horario que le pasamos por parametro
	 * 
	 * @param horario
	 * @return boolean true o false dependiendo del resustado de la operacion
	 */
	public boolean eliminaHorario(ObjetoBean horario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaHorario bdfh = (BBDDFachadaHorario) bdf
				.dameBBDDFachada(Constantes.FachadaHorario);
		return bdfh.eliminar(horario);
	}

	/**
	 * Transforma el horario en una cadena de String
	 * 
	 * @param horario
	 * @return String
	 */
	public String convertirHorario(ObjetoBean horario) {
		String lunes = horario.dameValor(Constantes.HORARIO_LUNES);
		String martes = horario.dameValor(Constantes.HORARIO_MARTES);
		String miercoles = horario.dameValor(Constantes.HORARIO_MIERCOLES);
		String jueves = horario.dameValor(Constantes.HORARIO_JUEVES);
		String viernes = horario.dameValor(Constantes.HORARIO_VIERNES);
		String resul = "";
		if (lunes != null && !lunes.equals("null")) {
			resul = resul + "L";
			resul = resul + lunes;
			resul = resul + "-";
		}
		if (martes != null && !martes.equals("null")) {
			resul = resul + "M";
			resul = resul + martes;
			resul = resul + "-";
		}
		if (miercoles != null && !miercoles.equals("null")) {
			resul = resul + "X";
			resul = resul + miercoles;
			resul = resul + "-";
		}
		if (jueves != null && !jueves.equals("null")) {
			resul = resul + "J";
			resul = resul + jueves;
			resul = resul + "-";
		}
		if (viernes != null && !viernes.equals("null")) {
			resul = resul + "V";
			resul = resul + viernes;
			// resul=resul+"-";
		}
		return resul;
	}

	/**
	 * Devuelve la fecha del sistema
	 * 
	 * @return String
	 */
	public String dameFecha() {
		// cojo la fecha del sistema
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String cadenafecha = formato.format(fecha);
		return cadenafecha;
	}
}
