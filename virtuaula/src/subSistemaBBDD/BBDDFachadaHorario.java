package subSistemaBBDD;

import subSistemaBBDD.esquemaBBDD.CreadorEsquemaBBDD;
import subSistemaBBDD.esquemaBBDD.EsquemaBBDD;
import subSistemaBBDD.listaObjeto.CreadorListaObjetoBBDD;
import subSistemaBBDD.listaObjeto.ListaObjetoBBDD;
import subSistemaBBDD.objetoBaseDatos.CreadorObjetoBBDD;
import subSistemaBBDD.objetoBaseDatos.ObjetoBBDD;
import subSistemaBBDD.objetoCriterio.CreadorObjetoCriterio;
import subSistemaBBDD.objetoCriterio.ObjetoCriterio;
import subSistemaBBDD.utils.Constantes;
import beans.ObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;

public class BBDDFachadaHorario extends BBDDFachada{
	protected BBDDFachadaHorario(){
		
	} 
	/**
	 * Devuelve una lista de beans con todos los horarios fijados en el sistema
	 * @return la lista de beans mencionada
	 */
	public ListaObjetoBean dameHorariosDisponibles(){
		CreadorObjetoCriterio creadorCriterio=this.creador.getCreadorObjetoCriterio();
		ObjetoCriterio criterioHorario = creadorCriterio.crear(creadorCriterio.ObjetoCriterioIshorario);
		CreadorEsquemaBBDD creadorHorario = this.creador.getCreadorEsquema();
		EsquemaBBDD tablaHorario =creadorHorario.crear(creadorHorario.EsqIshorario);
		ListaObjetoBBDD result= this.inicializaTabla(tablaHorario).consultar(criterioHorario);
		return ConversorBeanBBDD.convierteListaBBDD(result);
	}
	
	/**
	 * Sirve para saber si dos horarios son compatibles, es decir si no tienen ninguna hora en comun.
	 * @param horario1
	 * @param horario2
	 * @return
	 */
	public boolean horariosCompatibles(ObjetoBean horario1,ObjetoBean horario2){
		String valor1= horario1.dameValor(Constantes.ID_ISHORARIO);
		String valor2= horario1.dameValor(Constantes.HORARIO_LUNES);
		String valor3= horario1.dameValor(Constantes.HORARIO_MARTES);
		String valor4= horario1.dameValor(Constantes.HORARIO_MIERCOLES);
		String valor5= horario1.dameValor(Constantes.HORARIO_JUEVES);
		String valor6= horario1.dameValor(Constantes.HORARIO_VIERNES);
						
		if( (valor1.equals(horario2.dameValor(Constantes.ID_ISHORARIO)) )
			||	((!(valor2==null)&&!valor2.equals("")&& !(horario2.dameValor("L")==null))&& valor2.equals(horario2.dameValor("L")))
			||  ((!(valor3==null)&& !valor3.equals("") && !(horario2.dameValor("M")==null))&& valor3.equals(horario2.dameValor("M")))
			||  ((!(valor4==null)&&!valor4.equals("")&& !(horario2.dameValor("X")==null))&& valor4.equals(horario2.dameValor("X")))
			||	((!(valor5==null)&&!valor5.equals("")&& !(horario2.dameValor("J")==null))&& valor5.equals(horario2.dameValor("J")))
			||	((!(valor6==null)&&!valor6.equals("")&& !(horario2.dameValor("V")==null))&& valor6.equals(horario2.dameValor("V"))))
		   	return false;
		else
			return true;
	}
	
	public ListaObjetoBean dameHorariosOcupadosAula(ObjetoBean aula){
		
		try{
			CreadorListaObjetoBBDD creadorListaBBDD = new CreadorListaObjetoBBDD();
			ListaObjetoBBDD idHorariosOcupadoAula;
			CreadorObjetoBBDD creadorOB= this.creador.getCreadorObjetoBBDD();
			ObjetoBBDD hor = creadorOB.crear(creadorOB.Ishorario);
			
			ObjetoBBDD horarioAula = creadorOB.crear(creadorOB.IshorarioHasIsaula);
			EsquemaBBDD esHorAula = this.crearTablaAdecuada(horarioAula);
			horarioAula.cambiaValor(Constantes.ID_HAS_ISAULA_IDISAULA,aula
																 .dameValor(Constantes.ID_ISAULA));
			ObjetoCriterio critHorAula = this.crearObjetoCriterioAdecuado(horarioAula);
			idHorariosOcupadoAula = this.inicializaTabla(esHorAula).consultar(critHorAula);
			//Obtengo todos los horarios en los cuales el aulasExistentes[i] está ocupada y lo meto en horariosOcupados
			ListaObjetoBBDD horariosOcupados= creadorListaBBDD.crear();
			for(int j=0;j<idHorariosOcupadoAula.tamanio();j++){
				hor.cambiaValor(Constantes.ID_ISHORARIO,idHorariosOcupadoAula.dameObjeto(j).dameValor(Constantes.ID_HAS_ISHORARIO_IDISHORARIO));
				ObjetoCriterio critHor = this.crearObjetoCriterioAdecuado(hor);
				horariosOcupados.insertar(horariosOcupados.tamanio(),this.inicializaTabla(this.crearTablaAdecuada(hor)).consultar(critHor).dameObjeto(0));
			}
			return ConversorBeanBBDD.convierteListaBBDD(horariosOcupados);
		}
		catch( Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
