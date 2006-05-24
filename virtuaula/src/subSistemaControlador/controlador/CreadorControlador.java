package subSistemaControlador.controlador;


/*import controlConsulAlum.ControlConsulAlum;
import controlConsulCur.ControlConsulCur;
import controlConsulProf.ControlConsulProf;
import controlEdiAlum.ControlEdiAlum;
import controlEdiCur.ControlEdiCur;
import controlEdiProf.ControlEdiProf;
import controlInserAlum.ControlInserAlum;
import controlInserCur.ControlInserCur;
import controlSecretaria.ControlSecretaria;*/
/**
 * Proporciona un interfaz de creación de cualquier controlador
 * @author Fco Javier Pérez Escrivá
 *
 */
public class CreadorControlador {
	final public int ControlAcceso=0;
	final public int ControlConsulAlum=1;
	final public int ControlConsulCur=2;
	final public int ControlConsulProf=3;
	final public int ControlEdiAlum=4;
	final public int ControlEdiCur=5;
	final public int ControlEdiProf=6;
	final public int ControlInserAlum=7;
	final public int ControlInserCur=8;
	final public int ControlSecretaria=9;
/*	
	static  private ControlAcceso controlAcceso;
	static  private ControlConsulAlum controlConsulAlum;
	static  private ControlConsulCur controlConsulCur;
	static  private ControlConsulProf controlConsulProf;
	static  private ControlEdiAlum controlEdiAlum;
	static  private ControlEdiCur controlEdiCur;
	static  private ControlEdiProf controlEdiProf;
	static  private ControlInserAlum controlInserAlum;
	static  private ControlInserCur controlInserCur;
	static  private ControlSecretaria controlSecretaria;
	
	public Controlador crear (int tipo){
		Controlador resultado=null;
		switch (tipo){
		
			case 0: {
				if (this.controlAcceso==null){
					controlAcceso=new ControlAcceso();
					
				}	
				resultado=controlAcceso.clonar();
				break;
			}
			case 1:{
				if (this.controlConsulAlum==null){
					controlConsulAlum= new ControlConsulAlum();
				}
				resultado=this.controlConsulAlum.clonar();
				break;
			}
			case 2:{
				if (this.controlConsulCur==null){
					controlConsulCur= new ControlConsulCur();
				}
				resultado=this.controlConsulCur.clonar();
				break;
			}
			case 3:{
				if (this.controlConsulProf==null){
					controlConsulProf=new ControlConsulProf();
				}
				resultado=this.controlConsulProf.clonar();
				break;
				
			}
			case 4:{
				if (this.controlEdiAlum==null){
					controlEdiAlum=new ControlEdiAlum();
				}	
				resultado=this.controlEdiAlum.clonar();
				break;
			}
			
			case 5:{
				if (this.controlEdiCur==null){
					controlEdiCur=new ControlEdiCur();
				}
				resultado=this.controlEdiCur.clonar();
				break;
			}
			case 6:{
				if (this.controlEdiProf==null){
					controlEdiProf=new ControlEdiProf();
				}
				resultado=this.controlEdiProf.clonar();
				break;
			}
			case 7:{
				if (this.controlInserAlum==null){
					controlInserAlum= new ControlInserAlum();
				}
				resultado=this.controlInserAlum.clonar();
				break;
			}
			case 8:{
				if (this.controlInserCur==null){
					controlInserCur= new ControlInserCur();
				}
				resultado=this.controlInserCur.clonar();
				break;
			}	
			case 9:{
				if (this.controlSecretaria==null){
					controlSecretaria= new ControlSecretaria();
				}
				resultado=this.controlSecretaria.clonar();
				break;
			}
			}//fin switch
		return resultado;
	}	
	*/	
}