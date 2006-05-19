package subSistemaBBDD.objetoCriterio;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import subSistemaBBDD.objetoBaseDatos.*;
import subSistemaBBDD.utils.Constantes;



public class ObjetoCriterioIsAlumno extends ObjetoCriterio{
	
	/**
	 * Número de cmapos introducidos en el objeto criterio.
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
		i++;
		while(!s.equals(campo) && i<limite){
			s = (String) listaCampos.get(i);
			i++;
			
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
	 * (no quedan más campos)
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
	 * @return ObjetoCriterio resultante de la transformación
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
	
	public ObjetoCriterio test(String campoX, String valorX){
		listaCampos.add((String) campoX);
		listaValores.add((String) valorX);
		numCampos++;
		return this;
	}
	
	/**
	 * Devuelve una copia del ObjetoCriterio al que se le envia el mensaje
	 * Patrón Prototype
	 * @return copia solitada 
	 */
	public ObjetoCriterio clonar(){
		
		ObjetoCriterioIsAlumno x = new ObjetoCriterioIsAlumno();
		x.inicializar();
		return x;
	}
	
	/**
	 * Realiza una inicialización poniendo el número de campos a 0 y creando una estructura inicial vacia.
	 *
	 */
	public void inicializar(){
		numCampos = 0;
		listaCampos = Collections.synchronizedList(new LinkedList());
		listaValores = Collections.synchronizedList(new LinkedList());
		indiceActual = 0;
		Campos = new String[9];
		Campos[0] = Constantes.ID_ISALUMNO_ISUSUARIO_DNI;
		Campos[1] = Constantes.ALUMNO_NOMBRE;
		Campos[2] = Constantes.ALUMNO_APELLIDO1;
		Campos[3] = Constantes.ALUMNO_APELLIDO2;
		Campos[4] = Constantes.ALUMNO_TELEFONO;
		Campos[5] = Constantes.ALUMNO_EMAIL;
		Campos[6] = Constantes.ALUMNO_DIRECCION;
		Campos[7] = Constantes.ALUMNO_FECH_NACIMIENTO;
		Campos[8] = Constantes.ALUMNO_SEXO;
		
		listaString = new Vector ();		
		listaString.add(Constantes.ID_ISALUMNO_ISUSUARIO_DNI);
		listaString.add(Constantes.ALUMNO_NOMBRE);
		listaString.add(Constantes.ALUMNO_APELLIDO1);
		listaString.add(Constantes.ALUMNO_APELLIDO2);
		listaString.add(Constantes.ALUMNO_EMAIL);
		listaString.add(Constantes.ALUMNO_DIRECCION);
		listaString.add(Constantes.ALUMNO_FECH_NACIMIENTO);
		listaString.add(Constantes.ALUMNO_SEXO);
	}
	
	/**
	 * Número de campos introducidos en el objetoCriterio
	 * @return Número de campos introducidos en el objetoCriterio 
	 */
	public int dameNumCampos(){
		return numCampos;
	}

}
