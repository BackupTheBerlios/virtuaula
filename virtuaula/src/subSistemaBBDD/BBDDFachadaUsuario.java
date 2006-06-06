package subSistemaBBDD;

import subSistemaBBDD.esquemaBBDD.EsquemaBBDD;
import subSistemaBBDD.listaObjeto.ListaObjetoBBDD;
import subSistemaBBDD.objetoBaseDatos.ObjetoBBDD;
import beans.listaObjetoBeans.*;
import subSistemaBBDD.objetoBaseDatos.CreadorObjetoBBDD;
import subSistemaBBDD.objetoCriterio.CreadorObjetoCriterio;
import subSistemaBBDD.objetoCriterio.ObjetoCriterio;
import subSistemaBBDD.utils.Constantes;
import beans.ObjetoBean;
/**
 * Fachada especializada para operaciones con la tabla usuario o
 * con las tablas que la relacionan con otras.
 * de la base de datos.
 * @author JORGE SANCHEZ
 *
 */
public class BBDDFachadaUsuario extends BBDDFachada{
	
	/**
	 * Creador protegido de la clase, solo lo utilizará su clase padre para crear una instancia de esta clase.
	 *
	 */
	protected BBDDFachadaUsuario(){
		
	}
	/**
	 * Devuelve una lista de usuarios segun el perfil especificado
	 * @return la lista mencionada.
	 */
	public ListaObjetoBean dameUsuariosPerfil(String perfil){
		CreadorObjetoBBDD creadorObjetoBBDD=this.creador.getCreadorObjetoBBDD();
		ObjetoBBDD usuario= creadorObjetoBBDD.crear(creadorObjetoBBDD.Isusuario);
		usuario.cambiaValor(Constantes.USUARIO_PERFIL,perfil);
		ObjetoCriterio critUsuario= this.crearObjetoCriterioAdecuado(usuario);
		EsquemaBBDD tablaUsuario =this.crearTablaAdecuada(usuario);
		ListaObjetoBBDD result= this.inicializaTabla(tablaUsuario).consultar(critUsuario);
		return ConversorBeanBBDD.convierteListaBBDD(result);
		
	}

	/**
	 * Nos sirve para saber si un usuario está ya dado de alta en el sistema.
	 * @param usuario del cual queremos saber si ya existe en el sistema.
	 * @return true si ya existe, false e.o.c
	 */
	public boolean usuarioYaExiste(ObjetoBean usuario){
		try{
			ObjetoBBDD isUsuario = ConversorBeanBBDD.convierteBeanABBDD(usuario);
			EsquemaBBDD tablaUsuarios = this.crearTablaAdecuada(isUsuario);
			CreadorObjetoCriterio creadorCriterio= this.creador.getCreadorObjetoCriterio();
			ObjetoCriterio criterioCurso = creadorCriterio.crear(creadorCriterio.ObjetoCriterioIscurso);
			criterioCurso.convertir(isUsuario);
			return (this.inicializaTabla(tablaUsuarios).consultar(criterioCurso).tamanio() !=0);
			
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}	
	}
	
	/**
	 * 
	 * Este método sirve para autentificar un usuario que se le pasa 
	 * como parámetro, si el dni del usuario y la contraseña coinciden
	 * con los datos de la base de datos para ese usuario, se devuelve cierto.
	 * @param usuario Debe ser un bean de tipo Usuario. El usuario a comprobar.
	 * 
	 * @return true si el usuario es válido en el sistema,es decir
	 * tiene un ID_ISUSUARIO_DNI y un USUARIO_CONTRASENIA válido  
	 */
	
	public boolean usuarioValido(ObjetoBean usuario){
		try{
			
			ObjetoBBDD entidadBBDD= ConversorBeanBBDD.convierteBeanABBDD(usuario);
			EsquemaBBDD tablaAdecuada= this.crearTablaAdecuada(entidadBBDD);
			ObjetoCriterio entidadCriterio= this.crearObjetoCriterioAdecuado(entidadBBDD);
			if(!entidadCriterio.dameValor(Constantes.ID_ISUSUARIO_DNI).equals("") && 
					!entidadCriterio.dameValor(Constantes.USUARIO_CONTRASENIA).equals("")) {
				ListaObjetoBBDD resultBBDD=(ListaObjetoBBDD) this.inicializaTabla(tablaAdecuada).consultar(entidadCriterio);
				if (!resultBBDD.esVacio())
					return true;
				else{
					System.out.println("Usuario o contraseña no válido");
					return false;
				}
					
			}
			else{
				System.out.println("debe introducir login y contraseñs");
				return false;
				
			}
		}
		catch (Exception e){
			e.printStackTrace();
				return false;
		}
	}
	
	/**
	 * Este método devuelve el perfil asociado a un usuario
	 * @param usuario el usuario del cual buscar el perfil
	 * @return el perfil del usuario si existe, si no la cadena vacía.
	 */
	
	public String damePerfilUsuario (ObjetoBean usuario){
		try{
			ObjetoBBDD entidadBBDD= ConversorBeanBBDD.convierteBeanABBDD(usuario);
			EsquemaBBDD tablaAdecuada= this.crearTablaAdecuada(entidadBBDD);
			ObjetoCriterio entidadCriterio= this.crearObjetoCriterioAdecuado(entidadBBDD);
			ListaObjetoBBDD resultConsulta =(ListaObjetoBBDD) this.inicializaTabla(tablaAdecuada).consultar(entidadCriterio);
			if(!resultConsulta.esVacio()){
				ObjetoBBDD usuarioBBDD= resultConsulta.dameObjeto(0);
				return usuarioBBDD.dameValor(Constantes.USUARIO_PERFIL);
			}
			else{
				return "";
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return "";
		}
			
	}


}
