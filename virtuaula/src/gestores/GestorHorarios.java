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

public class GestorHorarios {

	public GestorHorarios() {
		super();
	}

	
	
	
	public boolean horarioUtilizado(ObjetoBean horario){
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaHorario bdfh= (BBDDFachadaHorario)bdf.dameBBDDFachada(Constantes.FachadaHorario);
		return bdfh.horarioUtilizado(horario);
	}
	
	
	public ListaObjetoBean consultaHorarios() {
		BBDDFachada bdf = BBDDFachada.getInstance();
		CreadorBean cBean = new CreadorBean();
		Horario horario = (Horario) cBean.crear(8);
		ListaObjetoBean l = bdf.consultar(horario);
		return l;
	}
	
	public ListaObjetoBean consultaHorariosDisponibles() {
		BBDDFachada bdf = BBDDFachada.getInstance();
		BBDDFachadaHorario bdfh= (BBDDFachadaHorario) bdf.dameBBDDFachada(Constantes.FachadaHorario);
		ListaObjetoBean l = bdfh.dameHorariosDisponibles();
		return l;
	}
	
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
	public String dameFecha()
	{
		//cojo la fecha del sistema
		Date fecha = new Date();
		SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
		String cadenafecha = formato.format(fecha);
		return cadenafecha;
	}
}
