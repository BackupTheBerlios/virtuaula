package beans;




/**
 * 
 * @author Alberto Macho
 * Esta clase nos va a permitir crear objetos de tipo ObjetoBean
 * Es la unica con la que vamos a crear ObjetosBean
 * Los atributos son estaticos debido a que es un prototipo y solo existira uno
 * que nos servira para clonar todos los demas.
 * 
 */
public class CreadorBean{

	static private Alumno alumno;
	static private Area area;
	static private Aula aula;
	static private Avisos avisos;
	static private Avisos_Has_Usuario avi_usu;
	static private Contrato contrato;
	static private Curso curso;
	static private Curso_Has_Alumno cur_al;
	static private Horario horario;
	static private Horario_Has_Aula hor_aul;
	static private Nomina nomina;
	static private Profesor profesor;
	static private Usuario usuario;
	static private Ficha ficha;
	static private Error error;
	
	/**
	 * tipo de implementación de la clase ObjetoBean que define una tupla Isalumno
	 */
	final public int Alumno=0;
	/**
	 * tipo de implementación de la clase ObjetoBean que define una tupla Isarea
	 */
	final public int Area=1;
	/**
	 * tipo de implementación de la clase ObjetoBean que define una tupla Isaula
	 */
	final public int Aula=2;
	/**
	 * tipo de implementación de la clase ObjetoBean que define una tupla Isavisos
	 */
	final public int Avisos=3;
	/**
	 * tipo de implementación de la clase ObjetoBean que define una tupla IsavisosHasIsuario
	 */
	final public int AvisosHasUario=4;
	/**
	 * tipo de implementación de la clase ObjetoBean que define una tupla Iscontrato
	 */
	final public int Contrato=5;
	/**
	 * tipo de implementación de la clase ObjetoBean que define una tupla Iscurso
	 */
	final public int Curso=6;
	/**
	 * tipo de implementación de la clase ObjetoBean que define una tupla IscursoHasIsalumno
	 */
	final public int CursoHasAlumno=7;
	/**
	 * tipo de implementación de la clase ObjetoBean que define una tupla Ishorario
	 */
	final public int Horario=8;
	/**
	 * tipo de implementación de la clase ObjetoBean que define una tupla IshorarioHasIsaula
	 */
	final public int HorarioHasAula=9;
	/**
	 * tipo de implementación de la clase ObjetoBean que define una tupla Isnomina
	 */
	final public int Nomina=10;
	/**
	 * tipo de implementación de la clase ObjetoBean que define una tupla Isprofesor
	 */
	final public int Profesor=11;
	/**
	 * tipo de implementación de la clase ObjetoBean que define una tupla Isusuario
	 */
	final public int Usuario=12;
	/**
	 * tipo de implementación de la clase ObjetoBean que define una tupla IsFicha
	 */
	final public int Ficha=13;
	/**
	 * tipo de implementación de la clase ObjetoBean que define una tupla Error
	 */
	final public int Error=14;
	
	public CreadorBean()
	{}
	
	
	
	/**
	 * Genera una copia prototípica del tipo de ObjetoBean concreto especificado 
	 * @param obj tipo de ObjetoBean a "clonar" (realizar la copia)
	 * @return objeto de la implementación concreta de la interfaz ObjetoBean especificada
	 */
	public ObjetoBean crear(int obj)
	 {
		
		ObjetoBean objeto;	 
		 switch (obj)
		 {
			 
		 	case 0:{
		 		if (alumno==null)
		 		{
		 			alumno=new Alumno();
		 		}
		 		objeto=alumno.clonar();break;
		 		}
			 case 1:{
				 	if (area==null)
				 	{
				 		area=new Area();
				 	}
				 	objeto=area.clonar();break;
				 	}
			 case 2:{
				 if (aula ==null)
				 {
					 aula=new Aula();
				 }
				 objeto=aula.clonar();break;
				 }
			 case 3:{
				 if (avisos==null)
				 {
					 avisos=new Avisos();
				 }
				 	objeto=avisos.clonar();break;
				 	}
			 case 4:{
				 	if (avi_usu==null)
				 	{
				 		avi_usu=new Avisos_Has_Usuario();
				 	}
				 
				 	objeto=avi_usu.clonar();break;
				 	}
			 case 5:{
				 	if (contrato==null)
				 	{
				 		contrato=new Contrato();
				 	}
				 
				 	objeto=contrato.clonar();break;
				 	}
			 case 6:{
				 	if (curso==null)
				 	{
				 		curso=new Curso();
				 	}
				 	objeto=curso.clonar();break;
				 	}
			 case 7:{
				 	if (cur_al==null)
				 	{
				 		cur_al=new Curso_Has_Alumno();
				 	}
				 	 objeto=cur_al.clonar();break;
				 	}
			 case 8:{
				 	if (horario==null)
				 	{
				 		horario=new Horario();
				 	}
				 objeto=horario.clonar();break;
				 }
			 case 9:{
				 	if (hor_aul==null)
				 	{
				 		hor_aul=new Horario_Has_Aula();
				 	}
				 objeto=hor_aul.clonar();break;
				 }
			 case 10:{
				 	if (nomina==null)
				 	{
				 		nomina=new Nomina();
				 	}
				 objeto=nomina.clonar();break;
				 }
			 case 11:{
				 	if (profesor==null)
				 	{
				 		profesor=new Profesor();
				 	}
				 objeto=profesor.clonar();break;
				 }
			 case 12:{
				 	if (usuario==null)
				 	{
				 		usuario=new Usuario();
				 	}
				 	objeto=usuario.clonar();break;
				 	}
			 case 13:{
				 	if (ficha==null)
				 	{
				 		ficha=new Ficha();
				 	}
				 objeto=ficha.clonar();break;
				 }
			 case 14:{
				 	if (error==null)
				 	{
				 		error=new Error();
				 	}
				 objeto=error.clonar();break;
				 }
			 default: {objeto=null;break;}
		 }
		 return objeto;
		
		
	 }
}
