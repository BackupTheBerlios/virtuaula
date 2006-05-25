package subSistemaBBDD;

import subSistemaBBDD.utils.Constantes;
import beans.CreadorBean;
import beans.ObjetoBean;

public class BBDDFachadaFicha extends BBDDFachada{
	protected BBDDFachadaFicha(){
		
	}
	/**
	 * Dado un alumno y un curso nos devuele la ficha correspondiente.
	 * @param alumno que guia la busqueda
	 * @param curso que guia la busqueda
	 * @return
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
	
}
