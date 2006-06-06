package subSistemaBBDD.esquemaBBDD;


/**
 * Clase encargada de la creación de EsquemaBBDD
 * formando parte del patrón Prototype siendo su rol de client_Prototype 
 * @author Fco Javier Pérez Escrivá
 *
 */
public class CreadorEsquemaBBDD {	
	
	 private EsqIsAlumno alumno;
	 private EsqIsArea area;
	 private EsqIsAula aula;
	 private EsqIsAviso avisos;
	 private EsqIsAvisoHasIsUsuario avi_usu;
	 private EsqIsContrato contrato;
	 private EsqIsCurso curso;
	 private EsqIsCursoHasIsAlumno cur_al;
	 private EsqIsFicha ficha;
	 private EsqIsHorario horario;
	 private EsqIsHorarioHasIsAula hor_aul;
	 private EsqIsNomina nomina;
	 private EsqIsProfesor profesor;
	 private EsqIsUsuario usuario;
	
	
	/**
	 * tipo de implementación de la clase EsquemaBBDD que define los servicios para la tabla Isalumno
	 */
	final public int EsqIsalumno=0;
	/**
	 * tipo de implementación de la clase EsquemaBBDD que define los servicios para la tabla Isarea
	 */
	final public int EsqIsarea=1;
	/**
	 * tipo de implementación de la clase EsquemaBBDD que define los servicios para la tabla Isaula
	 */
	final public int EsqIsaula=2;
	/**
	 * tipo de implementación de la clase EsquemaBBDD que define los servicios para la tabla Isavisos
	 */
	final public int EsqIsavisos=3;
	/**
	 * tipo de implementación de la clase EsquemaBBDD que define los servicios para la tabla IsavisosHasIsuario
	 */
	final public int EsqIsavisosHasIsuario=4;
	/**
	 * tipo de implementación de la clase EsquemaBBDD que define los servicios para la tabla Iscontrato
	 */
	final public int EsqIscontrato=5;
	/**
	 * tipo de implementación de la clase EsquemaBBDD que define los servicios para la tabla Iscurso
	 */
	final public int EsqIscurso=6;
	/**
	 * tipo de implementación de la clase EsquemaBBDD que define los servicios para la tabla IscursoHasIsalumno
	 */
	final public int EsqIscursoHasIsalumno=7;
	/**
	 * tipo de implementación de la clase EsquemaBBDD que define los servicios para la tabla Ishorario
	 */
	final public int EsqIshorario=8;
	/**
	 * tipo de implementación de la clase EsquemaBBDD que define los servicios para la tabla IshorarioHasIsaula
	 */
	final public int EsqIshorarioHasIsaula=9;
	/**
	 * tipo de implementación de la clase EsquemaBBDD que define los servicios para la tablaIsnomina
	 */
	final public int EsqIsnomina=10;
	/**
	 * tipo de implementación de la clase EsquemaBBDD que define los servicios para la tablaIsprofesor
	 */
	final public int EsqIsprofesor=11;
	/**
	 * tipo de implementación de la clase EsquemaBBDD que define los servicios para la tablaIsusuario
	 */
	final public int EsqIsusuario=12;
	/**
	 * tipo de implementación de la clase EsquemaBBDD que define los servicios para la tablaIsficha
	 */
	final public int EsqIsficha = 13;
	
	/**
	 * Genera una copia prototípica del tipo de EsquemaBBDD concreto especificado 
	 * @param tipo tipo de EsquemaBBDD a "clonar" (realizar la copia)
	 * @return objeto de la implementación concreta de la interfaz EsquemaBBDD especificada
	 */

	public EsquemaBBDD crear(int tipo) {
		EsquemaBBDD obj = null;
		
		switch (tipo) {					 
		 	case 0:{obj= this.alumno.clonar(); break;}
			case 1: {obj= this.area.clonar(); break;}
			case 2:{obj= this.aula.clonar(); break;}
			case 3:{obj= this.avisos.clonar(); break;}
			case 4:{obj= this.avi_usu.clonar(); break;}
			case 5:{obj= this.contrato.clonar(); break;}
			case 6:{obj= this.curso.clonar(); break;}
			case 7:{obj= this.cur_al.clonar(); break;}
			case 8:{obj= this.horario.clonar(); break;}
			case 9:{obj= this.hor_aul.clonar(); break;}
			case 10:{obj= this.nomina.clonar(); break;}
			case 11:{obj= this.profesor.clonar(); break;}
			case 12:{obj= this.usuario.clonar(); break;}
			case 13:{obj= this.ficha.clonar(); break;}
			default: {obj= null;}
	 }
		 		
		return obj;
	}

	/**
	 * Constructor de la clase donde se realiza inicializaciones de las distintas tablas de la base de datos.
	 *
	 */
	public CreadorEsquemaBBDD() {

		if (this.alumno == null) { 
			this.alumno = new EsqIsAlumno ();
		}

		if (this.area == null) { 
			this.area = new EsqIsArea ();
		}
		
		if (this.aula == null) { 
			this.aula = new EsqIsAula ();
		}
		
		if (this.avisos == null) { 
			this.avisos = new EsqIsAviso ();
		}
		
		if (this.avi_usu == null) { 
			this.avi_usu = new EsqIsAvisoHasIsUsuario ();
		}
		
		if (this.contrato == null) { 
			this.contrato = new EsqIsContrato ();
		}
		
		if (this.curso == null) { 
			this.curso = new EsqIsCurso ();
		}
		
		if (this.cur_al == null) { 
			this.cur_al = new EsqIsCursoHasIsAlumno ();
		}
		
		if (this.ficha == null) { 
			this.ficha = new EsqIsFicha ();
		}
		
		if (this.horario == null) { 
			this.horario = new EsqIsHorario ();
		}

		if (this.hor_aul == null) { 
			this.hor_aul = new EsqIsHorarioHasIsAula ();
		}

		if (this.nomina == null) { 
			this.nomina = new EsqIsNomina ();
		}

		if (this.profesor == null) { 
			this.profesor = new EsqIsProfesor ();
		}
		
		if (this.usuario == null) { 
			this.usuario = new EsqIsUsuario ();
		}
			
	}
	
	
	
	
}
