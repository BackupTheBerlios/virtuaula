package subSistemaBBDD.objetoBaseDatos;
/**
 * Clase encargada de la creación de ObjetoBBDD
 * formando parte del patrón Prototype siendo su rol de client_Prototype
 * @author Fco Javier Pérez Escrivá & Alberto Macho
 *  
 */
public class CreadorObjetoBBDD{
	
	/**
	 * Estos metodos son estaticos porque usamos el patron prototype, entonces todos los objetos
	 * que creemos que hereden de ObjetoBBDD seran clones de estos.
	 */
	static private IsAlumno alumno;
	static private IsArea area;
	static private IsAula aula;
	static private IsAvisos avisos;
	static private IsAvisos_Has_IsUsuario avi_usu;
	static private IsContrato contrato;
	static private IsCurso curso;
	static private IsCurso_Has_IsAlumno cur_al;
	static private IsHorario horario;
	static private IsHorario_Has_IsAula hor_aul;
	static private IsNomina nomina;
	static private IsProfesor profesor;
	static private IsUsuario usuario;
	static private IsFicha ficha;
	
	/**
	 * tipo de implementación de la clase ObjetoBBDD que define una tupla Isalumno
	 */
	final public int Isalumno=0;
	/**
	 * tipo de implementación de la clase ObjetoBBDD que define una tupla Isarea
	 */
	final public int Isarea=1;
	/**
	 * tipo de implementación de la clase ObjetoBBDD que define una tupla Isaula
	 */
	final public int Isaula=2;
	/**
	 * tipo de implementación de la clase ObjetoBBDD que define una tupla Isavisos
	 */
	final public int Isavisos=3;
	/**
	 * tipo de implementación de la clase ObjetoBBDD que define una tupla IsavisosHasIsuario
	 */
	final public int IsavisosHasIsuario=4;
	/**
	 * tipo de implementación de la clase ObjetoBBDD que define una tupla Iscontrato
	 */
	final public int Iscontrato=5;
	/**
	 * tipo de implementación de la clase ObjetoBBDD que define una tupla Iscurso
	 */
	final public int Iscurso=6;
	/**
	 * tipo de implementación de la clase ObjetoBBDD que define una tupla IscursoHasIsalumno
	 */
	final public int IscursoHasIsalumno=7;
	/**
	 * tipo de implementación de la clase ObjetoBBDD que define una tupla Ishorario
	 */
	final public int Ishorario=8;
	/**
	 * tipo de implementación de la clase ObjetoBBDD que define una tupla IshorarioHasIsaula
	 */
	final public int IshorarioHasIsaula=9;
	/**
	 * tipo de implementación de la clase ObjetoBBDD que define una tupla Isnomina
	 */
	final public int Isnomina=10;
	/**
	 * tipo de implementación de la clase ObjetoBBDD que define una tupla Isprofesor
	 */
	final public int Isprofesor=11;
	/**
	 * tipo de implementación de la clase ObjetoBBDD que define una tupla Isusuario
	 */
	final public int Isusuario=12;
	/**
	 * tipo de implementación de la clase ObjetoBBDD que define una tupla IsFicha
	 */
	final public int IsFicha=13;
	
	
	/**
	 *  constructor de la clase. Como los atributos son static si ya estan creados
	 * no hago nada, pero si realizo la instancia.
	 *
	 */public CreadorObjetoBBDD(){}
	/**
	 * Genera una copia prototípica del tipo de ObjetoBBDD concreto especificado 
	 * @param obj tipo de ObjetoBBDD a "clonar" (realizar la copia). obj sera una de las constantes
	 * definidas en esta clase
	 * @return objeto de la implementación concreta de la interfaz ObjetoBBDD especificada
	 * Como los atributos son static si ya estan creados
	 * no hago nada, pero si realizo la instancia
	 */
	 public ObjetoBBDD crear (int obj)
	 {
		ObjetoBBDD objeto;	 
		 switch (obj)
		 {
			 
		 	case 0:{
		 			if (alumno==null)
		 			{	
		 				alumno=new IsAlumno();
		 			}
		 			objeto=alumno.clonar();break;
		 			}
			 case 1: 
			 		{
				 	if (area==null)
				 	{
				 		area=new IsArea();
				 	}
				 	objeto=area.clonar();break;
				 	}
			 case 2:{
				 	if (aula==null)
				 	{
				 		aula= new IsAula();
				 	}
				 	objeto=aula.clonar();break;
				 	}
			 case 3:{
				 	if (avisos==null)
				 	{
				 		avisos=new IsAvisos();
				 	}	
				 	objeto=avisos.clonar();break;
				 	}
			 case 4:{
				 	if (avi_usu==null)
				 	{
				 		avi_usu=new IsAvisos_Has_IsUsuario();
				 	}
				 	objeto=avi_usu.clonar();break;
				 	}
			 case 5:{
				 	if (contrato==null)
				 	{
				 		contrato=new IsContrato();
				 	}
				 	objeto=contrato.clonar();break;
				 	}
			 case 6:{
				 	if (curso==null)
				 	{
				 		curso=new IsCurso();
				 	}
				 	objeto=curso.clonar();break;
				 	}
			 case 7:{
				 	if (cur_al==null)
				 	{
				 		cur_al=new IsCurso_Has_IsAlumno();
				 	}
				 	objeto=cur_al.clonar();break;
				 	}
			 case 8:{
				 	if (horario==null)
				 			{horario=new IsHorario();
				 	}
				 	objeto=horario.clonar();break;
				 	}
			 case 9:{
				 	if (hor_aul==null)
				 	{hor_aul=new IsHorario_Has_IsAula();
				 	}
				 	objeto=hor_aul.clonar();break;
				 	}
			 case 10:{
				 	if (nomina==null)
			 		{
				 		nomina=new IsNomina();
			 		}
				 	objeto=nomina.clonar();break;
				 	}
			 case 11:{
				 	if (profesor==null)
				 	{
				 		profesor=new IsProfesor();
				 	}
				 	objeto=profesor.clonar();break;
				 	}
			 case 12:{
				 	if (usuario==null)
				 	{
				 		usuario=new IsUsuario();
				 	}
				 	objeto=usuario.clonar();break;
				 	}
			 case 13:{
				 	if (ficha==null)
				 	{
				 		ficha=new IsFicha();
				 	}
				 		objeto=ficha.clonar();break;
				 	}
			 default: {objeto=null;break;}
		 }
		 return objeto;
	 }
}
