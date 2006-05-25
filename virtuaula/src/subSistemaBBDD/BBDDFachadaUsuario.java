package subSistemaBBDD;

import subSistemaBBDD.esquemaBBDD.EsquemaBBDD;
import subSistemaBBDD.listaObjeto.ListaObjetoBBDD;
import subSistemaBBDD.objetoBaseDatos.ObjetoBBDD;
import subSistemaBBDD.objetoCriterio.CreadorObjetoCriterio;
import subSistemaBBDD.objetoCriterio.ObjetoCriterio;
import subSistemaBBDD.utils.Constantes;
import beans.ObjetoBean;

public class BBDDFachadaUsuario extends BBDDFachada{
	protected BBDDFachadaUsuario(){
		
	}

	
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
	 * Este m�todo sirve para autentificar un usuario que se le pasa 
	 * como par�metro, si el dni del usuario y la contrase�a coinciden
	 * con los datos de la base de datos para ese usuario, se devuelve cierto.
	 * @param usuario Debe ser un bean de tipo Usuario. El usuario a comprobar.
	 * 
	 * @return true si el usuario es v�lido en el sistema,es decir
	 * tiene un ID_ISUSUARIO_DNI y un USUARIO_CONTRASENIA v�lido  
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
					System.out.println("Usuario o contrase�a no v�lido");
					return false;
				}
					
			}
			else{
				System.out.println("debe introducir login y contrase�s");
				return false;
				
			}
		}
		catch (Exception e){
			e.printStackTrace();
				return false;
		}
	}
	
	/**
	 * Este m�todo devuelve el perfil asociado a un usuario
	 * @param usuario, el usuario del cual buscar el perfil
	 * @return el perfil del usuario si existe, si no la cadena vac�a.
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
				System.out.println("El usuario no existe");
				return "";
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return "";
		}
			
	}

}