package subSistemaControlador.controlador;

import java.util.ArrayList;

import subSistemaControlador.controlador.ControladorSecretaria.controlMatricular.ControladorMatAlum;
import subSistemaControlador.controlador.ControladorSecretaria.controlMatricular.ControladorMatAlumCur;
import subSistemaControlador.controlador.ControladorSecretaria.controlMatricular.ControladorMatricula;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.BorraAviso;
import subSistemaControlador.controlador.ControladorUsuario.ConsulEliAvis.ControladorOp_Avis;

import subSistemaControlador.controlador.ControladorSecretaria.controlConsulCur.ControladorConsCur;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulCur.ControladorIniConsCur;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulCur.ControladorMostrarCur;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulHor.ControladorConsHor;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulHor.ControladorConsHorSel;

import subSistemaControlador.controlador.ControladorRecHumanos.controlInsertarProfesor.ControladorInsProf;

import subSistemaControlador.controlador.ControladorRecHumanos.controlInsertarProfesor.ControladorIniInsProf;
import subSistemaControlador.controlador.ControladorSecretaria.controlBajaCur.ControladorBajaConsCur;
import subSistemaControlador.controlador.ControladorSecretaria.controlBajaCur.ControladorBajaDefCurso;
import subSistemaControlador.controlador.ControladorSecretaria.controlBajaCur.ControladorBajaIniConsCur;
import subSistemaControlador.controlador.ControladorSecretaria.controlBajaCur.ControladorBajaMostrarCur;

import subSistemaControlador.controlador.ControladorProfesor.controlEditarFicha.ActualizarFichaAlumno;
import subSistemaControlador.controlador.ControladorProfesor.controlEditarFicha.ControladorMostrarCursoProf;
import subSistemaControlador.controlador.ControladorProfesor.controlEditarFicha.FichaAlumnoProf;
import subSistemaControlador.controlador.ControladorProfesor.controlEditarFicha.ListarAlumnosCurso;
import subSistemaControlador.controlador.ControladorProfesor.controlEditarFicha.PublicarNotas;

import subSistemaControlador.controlador.Contable.ControladorConContrato;
import subSistemaControlador.controlador.Contable.ControladorConNomina;
import subSistemaControlador.controlador.Contable.EnviarAvisoContable;
import subSistemaControlador.controlador.Contable.IniEnviarAvisoContable;
import subSistemaControlador.controlador.ControladorAlumnos.controlConsultaExpAlum.ControladorConExpAlum;
import subSistemaControlador.controlador.ControladorProfesor.controlEnviarAviso.EnviarAvisoProf;
import subSistemaControlador.controlador.ControladorProfesor.controlEnviarAviso.IniEnviarAvisoProf;
import subSistemaControlador.controlador.ControladorPublico.controlOfertaFormativa.ControladorOfertaFormativa;

import subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno.ControladorConsAlumno;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno.ControladorIniConsAlumno;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulAlumno.ControladorMostrarAlumno;


import subSistemaControlador.controlador.ControladorSecretaria.controlInsCur.*;
import subSistemaControlador.controlador.ControladorSecretaria.controlMatricular.ControladorInicioMatricula;
import subSistemaControlador.controlador.ControladorSecretaria.controlEnviarAviso.*;
import subSistemaControlador.controlador.ControladorSecretaria.controlConsulProf.*;

import subSistemaControlador.controlador.controlPasaPag.*;
import subSistemaControlador.controlador.controlConexiones.*;

/**
 * Proporciona un interfaz de creación de cualquier controlador
 * @author Fco Javier Pérez Escrivá
 *
 */
public class CreadorControlador {
	static final public int ControladorConExpAlum=0;
	static final public int ControladorConContrato=1;
	static final public int ControladorConNomina=2;
	static final public int EnviarAvisoContable=3;
	static final public int IniEnviarAvisoContable=4;
	static final public int ActualizarFichaAlumno=5;
	static final public int ControladorMostrarCursoProf=6;
	static final public int FichaAlumnoProf=7;
	static final public int ListarAlumnosCurso=8;
	static final public int PublicarNotas=9;
	static final public int EnviarAvisoProf=10;
	static final public int IniEnviarAvisoProf=11;
	static final public int ControladorOfertaFormativa=12;
	static final public int ControladorIniInsProf=13;
	static final public int ControladorInsProf=14;
	static final public int ControladorBajaConsCur=15;
	static final public int ControladorBajaDefCurso=16;
	static final public int ControladorBajaIniConsCur=17;
	static final public int ControladorBajaMostrarCur=18;
	static final public int ControladorConsAlumno=19;
	static final public int ControladorIniConsAlumno=20;
	static final public int ControladorConsCur=21;
	static final public int ControladorIniConsCur=22;
	static final public int ControladorMostrarCur=23;
	static final public int Cons_Prof=24;
	static final public int ControladorInsCurAula=25;
	static final public int ControladorMostrarProf=26;
	static final public int ControladorProfAreas=27;
	static final public int EnviarAvisoSec=28;
	static final public int IniEnviarAvisoSec=29;
	static final public int ControladorIniInsCur=30;
	static final public int ControladorInsCurArea=31;
	static final public int ControladorInsCurHor=32;
	static final public int ControladorInsCurProf=33;
	static final public int ControladorInsertaCurso=34;
	static final public int ControladorInicioMatricula=35;
	static final public int ControladorMatAlum=36;
	static final public int ControladorMatAlumCur=37;
	static final public int ControladorMatricula=38;
	static final public int BorraAviso=39;
	static final public int ControladorOp_Avis=40;
	static final public int ControladorConectar=41;
	static final public int ControladorDesconectar=42;
	static final public int ControladorLogin=43;
	static final public int ControladorPasaPag=44;
	static final public int ControladorMostrarAlumno=45;
	static final public int ControladorConsultarHorario=46;
	static final public int ControladorConsultarHorarioSel=47;
	
	
	
	private ArrayList tablaControladoresPrototipos;
	
	public CreadorControlador(){
		this.tablaControladoresPrototipos=new ArrayList();
		this.inicializar();
	}
	private void inicializar(){
		
		//introducimos todos los controladores
		tablaControladoresPrototipos.add(0,new ControladorConExpAlum());
		tablaControladoresPrototipos.add(1,new ControladorConContrato());
		tablaControladoresPrototipos.add(2,new ControladorConNomina());
		tablaControladoresPrototipos.add(3,new EnviarAvisoContable());
		tablaControladoresPrototipos.add(4,new IniEnviarAvisoContable());
		tablaControladoresPrototipos.add(5,new ActualizarFichaAlumno());
		tablaControladoresPrototipos.add(6,new ControladorMostrarCursoProf());
		tablaControladoresPrototipos.add(7,new FichaAlumnoProf());
		tablaControladoresPrototipos.add(8,new ListarAlumnosCurso());
		tablaControladoresPrototipos.add(9,new PublicarNotas());
		tablaControladoresPrototipos.add(10,new EnviarAvisoProf());
		tablaControladoresPrototipos.add(11,new IniEnviarAvisoProf());
		tablaControladoresPrototipos.add(12,new ControladorOfertaFormativa());
		tablaControladoresPrototipos.add(13,new ControladorIniInsProf());
		tablaControladoresPrototipos.add(14,new ControladorInsProf());
		tablaControladoresPrototipos.add(15,new ControladorBajaConsCur());
		tablaControladoresPrototipos.add(16,new ControladorBajaDefCurso());
		tablaControladoresPrototipos.add(17,new ControladorBajaIniConsCur());
		tablaControladoresPrototipos.add(18,new ControladorBajaMostrarCur());
		tablaControladoresPrototipos.add(19,new ControladorConsAlumno());
		tablaControladoresPrototipos.add(20,new ControladorIniConsAlumno());
		tablaControladoresPrototipos.add(21,new ControladorConsCur());
		tablaControladoresPrototipos.add(22,new ControladorIniConsCur());
		tablaControladoresPrototipos.add(23,new ControladorMostrarCur());
		tablaControladoresPrototipos.add(24,new Cons_Prof());
		tablaControladoresPrototipos.add(25,new ControladorInsCurAula());
		tablaControladoresPrototipos.add(26,new ControladorMostrarProf());
		tablaControladoresPrototipos.add(27,new ControladorProfAreas());
		tablaControladoresPrototipos.add(28,new EnviarAvisoSec());
		tablaControladoresPrototipos.add(29,new IniEnviarAvisoSec());
		tablaControladoresPrototipos.add(30,new ControladorIniInsCur());
		tablaControladoresPrototipos.add(31,new ControladorInsCurArea());
		tablaControladoresPrototipos.add(32,new ControladorInsCurHor());
		tablaControladoresPrototipos.add(33,new ControladorInsCurProf());
		tablaControladoresPrototipos.add(34,new ControladorInsertaCurso());
		tablaControladoresPrototipos.add(35,new ControladorInicioMatricula());
		tablaControladoresPrototipos.add(36,new ControladorMatAlum());
		tablaControladoresPrototipos.add(37,new ControladorMatAlumCur());
		tablaControladoresPrototipos.add(38,new ControladorMatricula());
		tablaControladoresPrototipos.add(39,new BorraAviso());
		tablaControladoresPrototipos.add(40,new ControladorOp_Avis());
		tablaControladoresPrototipos.add(41,new ControladorConectar());
		tablaControladoresPrototipos.add(42,new ControladorDesconectar());
		tablaControladoresPrototipos.add(43,new ControladorLogin());
		tablaControladoresPrototipos.add(44,new ControladorPasaPag());
		tablaControladoresPrototipos.add(45,new ControladorMostrarAlumno());
		tablaControladoresPrototipos.add(46,new ControladorConsHor());
		tablaControladoresPrototipos.add(47,new ControladorConsHorSel());
		
		
		
	}
	/**
	 * Crea el controlador especificado
	 * @param tipo constante q especifica el tipo a pasar
	 * @return Instanciacion del controlador solicitado
	 */
	public Controlador crear (int tipo){
		try{
			return ((Controlador)tablaControladoresPrototipos.get(tipo)).clonar();
		}
		catch (Exception e){
			System.out.println("Ha habido un problema en el creador de controladores");
			e.getStackTrace();
			return null;
		}
	}	
		
}