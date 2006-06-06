package subSistemaBBDD.objetoCriterio;




/**
 * Clase encargada de la creación de ObjetoCriterio formando parte del patrón
 * Prototype siendo su rol de client_Prototype
 * 
 * @author Fco Javier Pérez Escrivá
 * 
 */
 public class CreadorObjetoCriterio {


	 private ObjetoCriterioIsAlumno alumno;
	 private ObjetoCriterioIsArea area;
	 private ObjetoCriterioIsAula aula;
	 private ObjetoCriterioIsAvisos avisos;
	 private ObjetoCriterioIsAvisosHasIsUsuario avi_usu;
	 private ObjetoCriterioIsContrato contrato;
	 private ObjetoCriterioIsCurso curso;
	 private ObjetoCriterioIsCursoHasIsAlumno cur_al;
	 private ObjetoCriterioIsHorario horario;
	 private ObjetoCriterioIsHorarioHasIsAula hor_aul;
	 private ObjetoCriterioIsNomina nomina;
	 private ObjetoCriterioIsProfesor profesor;
	 private ObjetoCriterioIsUsuario usuario;
	 private ObjetoCriterioIsFicha ficha;

	/**
	 * tipo de implementación de la clase ObjetoCriterio que define un criterio
	 * para Isalumno
	 */
	final public int ObjetoCriterioIsalumno = 0;

	/**
	 * tipo de implementación de la clase ObjetoCriterio que define un criterio
	 * para Isarea
	 */
	final public int ObjetoCriterioIsarea = 1;

	/**
	 * tipo de implementación de la clase ObjetoCriterio que define un criterio
	 * para Isaula
	 */
	final public int ObjetoCriterioIsaula = 2;

	/**
	 * tipo de implementación de la clase ObjetoCriterio que define un criterio
	 * para Isavisos
	 */
	final public int ObjetoCriterioIsavisos = 3;

	/**
	 * tipo de implementación de la clase ObjetoCriterio que define un criterio
	 * para IsavisosHasIsuario
	 */
	final public int ObjetoCriterioIsavisosHasIsuario = 4;

	/**
	 * tipo de implementación de la clase ObjetoCriterio que define un criterio
	 * para Iscontrato
	 */
	final public int ObjetoCriterioIscontrato = 5;

	/**
	 * tipo de implementación de la clase ObjetoCriterio que define un criterio
	 * para Iscurso
	 */
	final public int ObjetoCriterioIscurso = 6;

	/**
	 * tipo de implementación de la clase ObjetoCriterio que define un criterio
	 * para IscursoHasIsalumno
	 */
	final public int ObjetoCriterioIscursoHasIsalumno = 7;

	/**
	 * tipo de implementación de la clase ObjetoCriterio que define un criterio
	 * para Ishorario
	 */
	final public int ObjetoCriterioIshorario = 8;

	/**
	 * tipo de implementación de la clase ObjetoCriterio que define un criterio
	 * para IshorarioHasIsaula
	 */
	final public int ObjetoCriterioIshorarioHasIsaula = 9;

	/**
	 * tipo de implementación de la clase ObjetoCriterio que define un criterio
	 * para Isnomina
	 */
	final public int ObjetoCriterioIsnomina = 10;

	/**
	 * tipo de implementación de la clase ObjetoCriterio que define un criterio
	 * para Isprofesor
	 */
	final public int ObjetoCriterioIsprofesor = 11;

	/**
	 * tipo de implementación de la clase ObjetoCriterio que define un criterio
	 * para Isusuario
	 */
	final public int ObjetoCriterioIsusuario = 12;

	/**
	 * tipo de implementación de la clase ObjetoCriterio que define un criterio
	 * para Isficha
	 */
	final public int ObjetoCriterioIsuficha = 13;

	/**
	 * Genera una copia prototípica del tipo de ObjetoCriterio concreto
	 * especificado
	 * 
	 * @param obj
	 *            tipo de ObjetoCriterio a "clonar" (realizar la copia)
	 * @return objeto de la implementación concreta de la interfaz
	 *         ObjetoCriterio especificada
	 */
	public ObjetoCriterio crear(int obj){
		ObjetoCriterio objeto=null;	 
		 switch (obj)
		 {
			 
		 	case 0:{return this.alumno.clonar();}
			 case 1: {return this.area.clonar();}
			 case 2:{return this.aula.clonar();}
			 case 3:{return this.avisos.clonar();}
			 case 4:{return this.avi_usu.clonar();}
			 case 5:{return this.contrato.clonar();}
			 case 6:{return this.curso.clonar();}
			 case 7:{return this.cur_al.clonar();}
			 case 8:{return this.horario.clonar();}
			 case 9:{return this.hor_aul.clonar();}
			 case 10:{return this.nomina.clonar();}
			 case 11:{return this.profesor.clonar();}
			 case 12:{return this.usuario.clonar();}
			 case 13:{return this.ficha.clonar();}
			 default: {return objeto;}
		 }
	}
	

	public CreadorObjetoCriterio(){
        if (alumno==null){alumno= new ObjetoCriterioIsAlumno();}
        if (area==null){area= new ObjetoCriterioIsArea();}
        if (aula==null){aula= new ObjetoCriterioIsAula();}
        if (avisos==null){avisos= new ObjetoCriterioIsAvisos();}
        if (avi_usu==null){avi_usu= new ObjetoCriterioIsAvisosHasIsUsuario();}
        if (contrato==null){contrato= new ObjetoCriterioIsContrato();}
        if (curso==null){curso= new ObjetoCriterioIsCurso();}
        if (cur_al==null){cur_al= new ObjetoCriterioIsCursoHasIsAlumno();}
        if (horario==null){horario= new ObjetoCriterioIsHorario();}
        if (hor_aul==null){hor_aul= new ObjetoCriterioIsHorarioHasIsAula();}
        if (nomina==null){nomina= new ObjetoCriterioIsNomina();}
        if (profesor==null){profesor= new ObjetoCriterioIsProfesor();}
        if (usuario==null){usuario= new ObjetoCriterioIsUsuario();}
        if (ficha==null){ficha= new ObjetoCriterioIsFicha();}
     }


}
