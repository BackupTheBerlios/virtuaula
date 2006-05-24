package controlador.controlConsultaNomina;
import gestores.GestorAlumnos;
import gestores.Profesorado;
import beans.CreadorBean;
import beans.ObjetoBean;
import beans.Usuario;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.utils.*;
import controlador.Controlador;
import controlador.controlConsultaContrato.ControladorConContrato;
public class ControladorConNomina extends Controlador{

	public void procesarEvento() {
		
		CreadorBean creador =new CreadorBean();
		ObjetoBean contrato = creador.crear(creador.Contrato);
		ObjetoBean nomina = creador.crear(creador.Nomina);
		ObjetoBean profesor;
		Profesorado GP = new Profesorado();
		ListaObjetoBean listaprof = GP.consultaProfesores();
		ListaObjetoBean listacont = GP.consultaContratos(contrato);
		ListaObjetoBean listanom = GP.consultaContratos(nomina);
		boolean encontrado;
		ListaObjetoBean listaprofresult = new ListaObjetoBean();
		ListaObjetoBean listanomresult = new ListaObjetoBean();
		
		for (int i =0; i< listacont.tamanio(); i++){
			encontrado = false;
			contrato = listacont.dameObjeto(i);
			int j = 0;
			while(!encontrado && j<listaprof.tamanio()){
				profesor = listaprof.dameObjeto(j);
				if(contrato.dameValor("ISUSUARIO_DNI").equals(profesor.dameValor("ISUSUARIO_DNI"))){				
					int z = 0;
					while(!encontrado && z<listanom.tamanio()){
						nomina = listanom.dameObjeto(z);
						if(contrato.dameValor("ISNOMINA_IDISNOMINA").equals(nomina.dameValor("IDISNOMINA"))){
							encontrado = true;
							listaprofresult.insertar(i,listaprof.dameObjeto(j));
							listanomresult.insertar(i,listanom.dameObjeto(z));
						}
						z++;
					}
				}
				j++;
			}
		} 
		
		if ((listaprofresult!=null) && (listanomresult!=null))
		{//no ha fallado la base de datos
			this.setResuladooperacion("OK");
			this.getSesion().removeAttribute("error");
			this.getSesion().setAttribute("listaprofesores",listaprofresult);
			this.getSesion().setAttribute("listanominas",listanomresult);
			System.out.println((listaprofresult.tamanio()));
			System.out.println((listanomresult.tamanio()));
		}
		else if ((listaprofresult==null) || (listanomresult==null))
		{
			this.setResuladooperacion("ERROR");
			ObjetoBean error= creador.crear(creador.Error);
		    error.cambiaValor(Constantes.CAUSA,"Fallo en la base de datos al consultar los expedientes");
		    CreadorListaObjetoBean creadorlista =new CreadorListaObjetoBean();
		    ListaObjetoBean listaerror = creadorlista.crear(); 
		    listaerror.insertar(0,error);
		    this.getSesion().setAttribute("error",listaerror);
			
		}
	}

	public Controlador clonar() {
		
		return new ControladorConContrato();
	}

}
