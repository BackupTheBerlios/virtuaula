package subSistemaBBDD.objetoCriterio;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import subSistemaBBDD.objetoBaseDatos.*;
import subSistemaBBDD.utils.Constantes;



public class ObjetoCriterioIsProfesor extends ObjetoCriterio{
	
	/**
	 * N�mero de cmapos introducidos en el objeto criterio.
	 */
	private int numCampos; 
	private List listaCampos;
	private List listaValores;
	private int indiceActual;
	private String [] Campos;
	private Vector listaString;
	
	/**
	 * Accesor el campo actual
	 * @return nombre del campo actual
	 */
	public String dameCampo(){
		return (String) listaCampos.get(indiceActual);
	}
	
	/**
	 * Accesor del valor del campo especificado
	 * @param campo campo a consultar
	 * @return valor del campo consultado
	 */
	public String dameValor(String campo){
		int i = 0;
		String sCampoSalida = "";
		
		String s = (String) listaCampos.get(i);
		int limite = listaCampos.size();
		while(!s.equals(campo) && i<limite){
			i++;
			s = (String) listaCampos.get(i);
		}
		if (s.equals(campo)){
			sCampoSalida = (String) listaValores.get(i);
		} 
		
		if (listaString.contains(campo)) {
			sCampoSalida = "'" + sCampoSalida +"'";
		}
		
		return sCampoSalida;
	}
	
	/**
	 * Pasa el campo actual al siguiente
	 * @return devuelve true si ha podido pasar al siguiete, false en caso contrario
	 * (no quedan m�s campos)
	 */
	public boolean camposig(){
		int limite = listaCampos.size();
		if (indiceActual < limite){
			indiceActual++;
		}
		return (indiceActual < limite);
	}
	
	/**
	 * Transforma un ObjetoBBDD en un ObjetoCriterio (eliminando los campos vacios)
	 * @param obj Objeto a transformar
	 * @return ObjetoCriterio resultante de la transformaci�n
	 */
	public ObjetoCriterio convertir (ObjetoBBDD obj){
		for(int i=0;i<Campos.length;i++){
			String s = obj.dameValor(Campos[i]);
			if (s!=null) {
				if (!s.equals("")){
					listaCampos.add((String) Campos[i]);
					listaValores.add((String)s);
					numCampos++;
				}
			}
		}
		return this;
	}
	
	/**
	 * Devuelve una copia del ObjetoCriterio al que se le envia el mensaje
	 * Patr�n Prototype
	 * @return copia solitada 
	 */
	public ObjetoCriterio clonar(){
		ObjetoCriterioIsProfesor x = new ObjetoCriterioIsProfesor();
		x.inicializar();
		return x;
	}
	
	/**
	 * Realiza una inicializaci�n poniendo el n�mero de campos a 0 y creando una estructura inicial vacia.
	 *
	 */
	public void inicializar(){
		numCampos = 0;
		listaCampos = Collections.synchronizedList(new LinkedList());
		listaValores = Collections.synchronizedList(new LinkedList());
		indiceActual = 0;
		Campos = new String[7];
		Campos[0] = Constantes.ID_ISPROFESOR_ISUSUARIO_DNI;
		Campos[1] = Constantes.PROFESOR_ISAREA_IDISAREA;
		Campos[2] = Constantes.PROFESOR_NOMBRE;
		Campos[3] = Constantes.PROFESOR_APELLIDO1;
		Campos[4] = Constantes.PROFESOR_APELLIDO2;
		Campos[5] = Constantes.PROFESOR_TELEFONO;
		Campos[6] = Constantes.PROFESOR_EMAIL;
		
		listaString = new Vector ();		
		listaString.add(Constantes.ID_ISPROFESOR_ISUSUARIO_DNI);
		listaString.add(Constantes.PROFESOR_NOMBRE);
		listaString.add(Constantes.PROFESOR_APELLIDO1);
		listaString.add(Constantes.PROFESOR_APELLIDO2);
		listaString.add(Constantes.PROFESOR_EMAIL);
	}
	
	/**
	 * N�mero de campos introducidos en el objetoCriterio
	 * @return N�mero de campos introducidos en el objetoCriterio 
	 */
	public int dameNumCampos(){
		return numCampos;
	}

}
