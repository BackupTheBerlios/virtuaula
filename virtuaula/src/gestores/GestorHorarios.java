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
 * @author AL
 */
public class GestorHorarios {

	public GestorHorarios() {
		super();
	}

	public boolean insertarHorario(ObjetoBean horario){
		horario.cambiaValor(Constantes.ID_ISHORARIO,"1");
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaHorario bdfh= (BBDDFachadaHorario)bdf.dameBBDDFachada(Constantes.FachadaHorario);
		return bdfh.insertar(horario);
	}
	
	
	
	/**
	 * Nos dice si algun curso utiliza el horario pasado como parámetro
	 * @param horario
	 * @return
	 */	
	public boolean horarioUtilizado(ObjetoBean horario){
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaHorario bdfh= (BBDDFachadaHorario)bdf.dameBBDDFachada(Constantes.FachadaHorario);
		return bdfh.horarioUtilizado(horario);
	}
	/**
	 * Dado un horario devuelve true si ya existe otro con el mismo nombre o contenido.
	 * @param horario
	 * @return
	 */
	public boolean horarioYaExiste(ObjetoBean horario){
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaHorario bdfh= (BBDDFachadaHorario)bdf.dameBBDDFachada(Constantes.FachadaHorario);
		return bdfh.horarioYaExiste(horario);
	}
	/**
	 * Nos devuelve una lista de horarios existentes
	 * @return
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
	 * @return la lista de beans mencionada
	 */
	public ListaObjetoBean consultaHorariosDisponibles() {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaHorario bdfh= (BBDDFachadaHorario) bdf.dameBBDDFachada(Constantes.FachadaHorario);
		ListaObjetoBean l = bdfh.dameHorariosDisponibles();
		return l;
	}
	/**
	 * elimina el horario que le pasamos por parametro
	 * @param horario
	 * @return cierto o falso dependiendo del resustado de la op
	 */
	public boolean eliminaHorario(ObjetoBean horario) {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaHorario bdfh= (BBDDFachadaHorario) bdf.dameBBDDFachada(Constantes.FachadaHorario);
		return  bdfh.eliminar(horario);
	}
	
	/**
	 * Me transforma el horario en una cadena de String
	 * 
	 * @param horario
	 * @return
	 */
	public String convertirHorario(ObjetoBean horario)
	{
		String lunes = horario.dameValor(Constantes.HORARIO_LUNES);
		String martes = horario.dameValor(Constantes.HORARIO_MARTES);
		String miercoles = horario.dameValor(Constantes.HORARIO_MIERCOLES);
		String jueves = horario.dameValor(Constantes.HORARIO_JUEVES);
		String viernes = horario.dameValor(Constantes.HORARIO_VIERNES);
		String resul="";
		if (lunes!=null)
		{
			resul=resul+"L";
			resul=resul+lunes;
			resul=resul+"-";
		}
		if (martes!=null)
		{
			resul=resul+"M";
			resul=resul+martes;
			resul=resul+"-";
		}
		if (miercoles!=null)
		{
			resul=resul+"X";
			resul=resul+miercoles;
			resul=resul+"-";
		}
		if (jueves!=null)
		{
			resul=resul+"J";
			resul=resul+jueves;
			resul=resul+"-";
		}
		if (viernes!=null)
		{
			resul=resul+"V";
			resul=resul+viernes;
			//resul=resul+"-";
		}
		return resul;
	}
	/**
	 * Te devuelve la fecha del sistema
	 * @return
	 */
	public String dameFecha()
	{
		//cojo la fecha del sistema
		Date fecha = new Date();
		SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
		String cadenafecha = formato.format(fecha);
		return cadenafecha;
	}
}
