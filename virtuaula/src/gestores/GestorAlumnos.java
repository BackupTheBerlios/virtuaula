package gestores;

import java.util.Random;

import beans.Avisos;
import beans.Avisos_Has_Usuario;
import beans.CreadorBean;
import beans.Error;
import beans.ObjetoBean;
import beans.listaObjetoBeans.CreadorListaObjetoBean;
import beans.listaObjetoBeans.ListaObjetoBean;
import subSistemaBBDD.BBDDFachada;
import subSistemaBBDD.utils.Constantes;

/**
 * 
 * @author Alberto Macho
 * Se encarga de realizar todas las operaciones necesarias para gestionar los alumnos
 * Se ayudara de otros gestores para realizar dichas operaciones. Tambien se encarga de comprobar
 * que los datos de un alumno esten bien introducidos.
 *
 */
public class GestorAlumnos {
	
	public ListaObjetoBean consultaCursosActivos()
	{
		GestorCursos GC = new GestorCursos();
		return 	GC.dameCursosActivos();
	}
	
/*	public ObjetoBean consultaClaseCurso(ObjetoBean Curso)
	{
		return null;
	}*/
	public ObjetoBean consultaProfesorCurso(ObjetoBean Curso)
	{
		GestorCursos GC = new GestorCursos();
		return GC.consultaProfesorDeCurso(Curso);
		
	}
	public ObjetoBean consultaAulaCurso(ObjetoBean Curso)
	{
		GestorCursos GC = new GestorCursos();
		return GC.consultaAulaDeCurso(Curso);
	
	}
	public ObjetoBean consultaHorarioCurso(ObjetoBean Curso)
	{	
		GestorCursos GC = new GestorCursos();
		return GC.consultaHorarioDeCurso(Curso);
		
	}
	/*public ObjetoBean consultaCurso()
	{
		return null;
	}*/
	public boolean existeAlumno(ObjetoBean Alumno)
	{
		BBDDFachada bd = BBDDFachada.getInstance(); 
		ListaObjetoBean l=bd.consultar(Alumno);
		if (!l.esVacio())
		{
			return true;
		}
		else return false;
	}
	/**
	 * Le meto un beanUsuario y me devolvera un beanUsuario unico, ya que consulto
	 * por el DNI 
	 * @param Usuario
	 * @return
	 */
	public ObjetoBean consultaUsuario(ObjetoBean Usuario)
	{
		BBDDFachada bd = BBDDFachada.getInstance(); 
		ListaObjetoBean l=bd.consultar(Usuario);
		return l.dameObjeto(0);
	
	}
	/**
	 * Me comprueba que los datos introducidos son correctos, es decir, que los
	 * campos obligatorios estan rellenos y si hay alguno numerico que no 
	 * contenga letras
	 * @param bean
	 * @return
	 */
	private ListaObjetoBean comprobar(ObjetoBean bean)
	{
		CreadorListaObjetoBean c = new CreadorListaObjetoBean();
		CreadorBean cBean = new CreadorBean();
		ListaObjetoBean l = c.crear();
		String mensaje = "";
		int i = 0;
		
		//Compruebo que el DNI no se haya dejado vacio
		if (bean.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI).equals("")) {
			mensaje = "El campo DNI no ha sido rellenado,por favor introduzca uno";
			ObjetoBean error = cBean.crear(cBean.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			l.insertar(i, error);
			i++;
		}
//		Compruebo que el DNI sea un numero valido
		try {
			int numerico = Integer.parseInt(bean
					.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
			if (numerico < 0) {
				mensaje = "El campo DNI tiene un valor incorrecto";
				ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				l.insertar(i, error);
				i++;
			}
		} catch (Exception e) {
			// No es número
			mensaje = "El campo DNI debe ser numérico";
			ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			l.insertar(i, error);
			i++;
		}
		//Compruebo que el Nombre no se haya dejado vacío
		if (bean.dameValor(Constantes.ALUMNO_NOMBRE).equals("")) {
			mensaje = "El campo Nombre no ha sido rellenado,por favor introduzca uno";
			ObjetoBean error = cBean.crear(cBean.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			l.insertar(i, error);
			i++;
		}
		//Compruebo que el campo Apellido1 no se haya dejado en blanco
		if (bean.dameValor(Constantes.ALUMNO_APELLIDO1).equals("")) {
			mensaje = "El campo Apellido1 no ha sido rellenado,por favor introduzca uno";
			ObjetoBean error = cBean.crear(cBean.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			l.insertar(i, error);
			i++;
		}
		//Compruebo que el campo Apellido2 no se haya dejado en blanco
		if (bean.dameValor(Constantes.ALUMNO_APELLIDO2).equals("")) {
			mensaje = "El campo Apellido2 no ha sido rellenado,por favor introduzca uno";
			ObjetoBean error = cBean.crear(cBean.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			l.insertar(i, error);
			i++;
		}
		//Compruebo que el telefono no se deja sin rellenar
		if (bean.dameValor(Constantes.ALUMNO_TELEFONO).equals("")) {
			mensaje = "El campo Telefono no ha sido rellenado,por favor introduzca uno";
			ObjetoBean error = cBean.crear(cBean.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			l.insertar(i, error);
			i++;
		}
//		Compruebo que el telefono sea un numero valido
		try {
			int numerico = Integer.parseInt(bean
					.dameValor(Constantes.ALUMNO_TELEFONO));
			if (numerico < 0) {
				mensaje = "El campo Telefono tiene un valor incorrecto";
				ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
				error.cambiaValor("CAUSA_ERROR", mensaje);
				l.insertar(i, error);
				i++;
			}
		} catch (Exception e) {
			// No es número
			mensaje = "El campo Telefono debe ser numérico";
			ObjetoBean error = (ObjetoBean) cBean.crear(cBean.Error);
			error.cambiaValor("CAUSA_ERROR", mensaje);
			l.insertar(i, error);
			i++;
		}
		//compruebo que el campo email no se deja sin rellenar
		if (bean.dameValor(Constantes.ALUMNO_EMAIL).equals("")) {
			mensaje = "El campo Email no ha sido rellenado,por favor introduzca uno";
			ObjetoBean error = cBean.crear(cBean.Error);
			error.cambiaValor(Constantes.CAUSA, mensaje);
			l.insertar(i, error);
			i++;
		}
		
		
		
		
		
		
		return l;
	}
	/**
	 * Me devuelve una lista de beans del tipo beanexpedienteAlumno
	 * @param alumno
	 * @return
	 */
	public ListaObjetoBean creaExpedienteAlumno(ObjetoBean alumno)
	{
		BBDDFachada bdf = BBDDFachada.getInstance();
		return bdf.creaExpedienteAlumno(alumno);
		
	}
	/**
	 * genere una contraseña aleatoria
	 * @return
	 */
	public int generaContrasenia()
	{
		Random rnd = new Random();
		int x;
		int contrasenia=1;
		for (int i=0;i<5;i++)
		{
		x = (int)(rnd.nextDouble() * 10.0);
		contrasenia= contrasenia*10+x;
		}
		return contrasenia;
	}
	public ListaObjetoBean marticularAlumno(ObjetoBean Alumno,ObjetoBean Curso,ObjetoBean usuario)
	{
		ListaObjetoBean liserror=this.comprobar(Alumno);
		System.out.println(liserror.tamanio());
		String numplazas= (Curso.dameValor(Constantes.CURSO_NUMERO_PLAZAS));
		int numeroplazas = Integer.parseInt(numplazas);
		
		//comprobamos que hay plazas en el curso
		if (numeroplazas==0)
		{
			//no hay plazas en el curso
			CreadorBean creador=new CreadorBean();
			ObjetoBean error = creador.crear(creador.Error);
			error.cambiaValor(Constantes.CAUSA,"No hay plazas para este curso");
			int tamanio=liserror.tamanio();
			liserror.insertar(tamanio,error);
			return liserror;
		}
		
		else if (numeroplazas>0)
		//si hay plazas en el curso
		{
		CreadorBean creador = new CreadorBean();
		BBDDFachada bdf = BBDDFachada.getInstance();
		//no hay datos incorrectos
		if (liserror.esVacio())
		{	ObjetoBean us =creador.crear(creador.Usuario);
			us.cambiaValor(Constantes.ID_ISUSUARIO_DNI,Alumno.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
			
			if (bdf.consultar(Alumno).esVacio())
			{
				//generamos la contraeña
				//int pass=this.generaContrasenia();
				//Integer p=new Integer(pass);
				//String password =p.toString();
				//creamos un usuario con su DNI y la contraseña que hemos generado
				//ObjetoBean usuario = creador.crear(creador.Usuario);
				//usuario.cambiaValor(Constantes.ID_ISUSUARIO_DNI,Alumno.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
				//usuario.cambiaValor(Constantes.USUARIO_CONTRASENIA,password);
				//usuario.cambiaValor(Constantes.USUARIO_PERFIL,"alumno");
				if (!bdf.insertar(usuario))
				{//genero un error
					ObjetoBean error = creador.crear(creador.Error);
					error.cambiaValor(Constantes.CAUSA,"El usuario ya existe");
					int tamanio=liserror.tamanio();
					liserror.insertar(tamanio,error);
					return liserror;
				}
				else
				{//inserto un alumno
					if (!bdf.insertar(Alumno))
					{
						ObjetoBean error = creador.crear(creador.Error);
						error.cambiaValor(Constantes.CAUSA,"El alumno ya existe");
						int tamanio=liserror.tamanio();
						liserror.insertar(tamanio,error);
						return liserror;
					}
					else
					{//se ha insertado todo correctamente. Genero el aviso con el usuario
					//y contraseña
					GestorAvisos GA =new GestorAvisos();
					GA.passAlumno(Alumno,usuario);
						
					}
				}
			}
				
				//primero crear la ficha
				ObjetoBean ficha =  creador.crear(creador.Ficha);
				ficha.cambiaValor(Constantes.ID_ISFICHA,"1");
				ficha.cambiaValor(Constantes.FICHA_ANOTACIONES,"creadanuevafichaalumno");
				ficha.cambiaValor(Constantes.FICHA_NOTAS," ");
				ficha.cambiaValor(Constantes.FICHA_NOTAS_EJERCICIOS,"-1");
				GestorFichas GF = new GestorFichas();
				if (GF.insertarFicha(ficha))
				{
					ficha.cambiaValor(Constantes.ID_ISFICHA,"");
					ListaObjetoBean listaficha=GF.consultarFicha(ficha);
					//como solo voy a obtener una ficha
					ObjetoBean ficha2=listaficha.dameObjeto(0);
					ficha2.cambiaValor(Constantes.FICHA_ANOTACIONES," ");
					GF.cambiaFicha(ficha2);
					
					
					//luego inserto la relacion cursohasalumno
					ObjetoBean relacion = creador.crear(creador.CursoHasAlumno);
					relacion.cambiaValor(Constantes.ISCURSO_HAS_ISALUMNO_ISFICHA_IDISFICHA,ficha2.dameValor(Constantes.ID_ISFICHA));
					relacion.cambiaValor(Constantes.ID_HAS_ISALUMNO_ISUSUARIO_DNI,Alumno.dameValor(Constantes.ID_ISALUMNO_ISUSUARIO_DNI));
					relacion.cambiaValor(Constantes.ID_HAS_ISCURSO_IDISCURSO,Curso.dameValor(Constantes.ID_ISCURSO_IDISCURSO));
					relacion.cambiaValor(Constantes.ISCURSO_HAS_ISALUMNO_NOTA_FINAL,"-1");
					
					
					if(bdf.insertar(relacion))
							{
								
								//mando un aviso al usuario correspondiente
						GestorAvisos GA = new GestorAvisos();
						ListaObjetoBean ListaError=GA.alumnoSinPass(Alumno,Curso);
						
						if (!ListaError.esVacio())
						{//se ha producido un error al enviar el aviso.
							return ListaError;
						}
						//decremento el numero de plazas del curso
						String num = Curso.dameValor(Constantes.CURSO_NUMERO_PLAZAS);
						int plazas = Integer.parseInt(num);
						plazas = plazas-1;
						Integer numerop=new Integer(plazas);
						String numeplazas=numerop.toString();
						Curso.cambiaValor(Constantes.CURSO_NUMERO_PLAZAS,numeplazas);
						GestorCursos GC = new GestorCursos();
						GC.editaCurso(Curso);
					}
					else					
					{	//creo un error de base de datos
						String mensaje = "El alumno ya esta matriculado de este curso";
						//eliminamos la ficha creada antes
						GF.eliminarFicha(ficha2);
						ObjetoBean error = (ObjetoBean) creador.crear(creador.Error);
						error.cambiaValor("CAUSA_ERROR", mensaje);
						int tamano=liserror.tamanio();
						liserror.insertar(tamano,error);
						return liserror;
					}				
				}
				else
				{
					ObjetoBean error = creador.crear(creador.Error);
					error.cambiaValor(Constantes.CAUSA,"El alumno ya tiene ficha de este curso");
					int tamanio=liserror.tamanio();
					liserror.insertar(tamanio,error);
					return liserror;
				}
					
		}
		}
		return liserror;
		
	}
	
}
