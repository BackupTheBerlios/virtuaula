package subSistemaBBDD;

import subSistemaBBDD.esquemaBBDD.EsquemaBBDD;
import subSistemaBBDD.listaObjeto.ListaObjetoBBDD;
import subSistemaBBDD.objetoBaseDatos.ObjetoBBDD;
import subSistemaBBDD.objetoCriterio.ObjetoCriterio;
import subSistemaBBDD.utils.Constantes;
import beans.CreadorBean;
import beans.ObjetoBean;
/**
 * Fachada especializada para operaciones con la tabla ficha
 * de la base de datos.
 * @author JORGE SANCHEZ
 *
 */
public class BBDDFachadaFicha extends BBDDFachada{
	
	/**
	 * Creador protegido de la clase, solo lo utilizará su clase padre para crear una instancia de esta clase.
	 *
	 */
	protected BBDDFachadaFicha(){
		
	}
	/**
	 * Dado un alumno y un curso nos devuele la ficha correspondiente.
	 * @param alumno que guia la busqueda
	 * @param curso que guia la busqueda
	 * @return la ficha del alumno en cuestion.
	 */
	public ObjetoBean dameFichaAlumnoCurso(ObjetoBean alumno, ObjetoBean curso){
		CreadorBean creadorBean = new CreadorBean();
		ObjetoBean critCursoAlumno = creadorBean.crear(creadorBean.CursoHasAlumno);
		critCursoAlumno.cambiaValor(Constantes. ID_HAS_ISCURSO_IDISCURSO, curso.dameValor(Constantes.ID_ISCURSO_IDISCURSO));
		critCursoAlumno.cambiaValor(Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI, alumno.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
		ObjetoBean cursoAlumno= this.consultar(critCursoAlumno).dameObjeto(0);
		ObjetoBean critFicha= creadorBean.crear(creadorBean.Ficha);
		critFicha.cambiaValor(Constantes.ID_ISFICHA,cursoAlumno.dameValor(Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA));
		ObjetoBean ficha= this.consultar(critFicha).dameObjeto(0);
		return ficha;
		
	}
	
	
	
	/**
	 * Este metodo borra todas las fichas de un curso
	 * @param curso
	 * @return true si exito, false e.o.c
	 */
	public boolean borrarFichasCurso(ObjetoBean curso){
		try{
			ObjetoBBDD cursoAlumnoFicha = this.creador.getCreadorObjetoBBDD().crear(this.creador.getCreadorObjetoBBDD().IscursoHasIsalumno);
			cursoAlumnoFicha.cambiaValor(Constantes.ID_HAS_ISCURSO_IDISCURSO,curso.dameValor(Constantes.ID_ISCURSO_IDISCURSO));
			ObjetoCriterio critCursoAlumnoFicha= this.crearObjetoCriterioAdecuado(cursoAlumnoFicha);
			EsquemaBBDD tablaCursoAlumFicha=  this.inicializaTabla(this.crearTablaAdecuada(cursoAlumnoFicha));
			ListaObjetoBBDD fichasCursoAlumno=tablaCursoAlumFicha.consultar(critCursoAlumnoFicha);
			ObjetoBBDD ficha=this.creador.getCreadorObjetoBBDD().crear(this.creador.getCreadorObjetoBBDD().IsFicha);
			ObjetoCriterio critFicha;
			EsquemaBBDD tablaFicha = this.inicializaTabla(this.crearTablaAdecuada(ficha));
			ObjetoBBDD fichaCursAlumActual;
			ObjetoCriterio critFichAlumCur;
			for(int i=0;i<fichasCursoAlumno.tamanio();i++){
				fichaCursAlumActual= fichasCursoAlumno.dameObjeto(i);
				ficha.cambiaValor(Constantes.ID_ISFICHA, fichaCursAlumActual.dameValor(Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA));
				critFicha= this.crearObjetoCriterioAdecuado(ficha);
				//	Borramos cada ficha			
				tablaFicha.borrar(critFicha);
				
			//	Cambiamos el campo idficha de la tabla de relacion curso alumno al valor vacio.
				fichaCursAlumActual.cambiaValor(Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA,"null");
				critFichAlumCur= this.crearObjetoCriterioAdecuado(fichaCursAlumActual);
				tablaCursoAlumFicha.editar(critFichAlumCur);
				
			}
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	
	}
}
