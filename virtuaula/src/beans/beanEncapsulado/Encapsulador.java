package beans.beanEncapsulado;
import javax.servlet.http.HttpServletRequest;
/**
 * Abstracci�n de cualquier tipo de encapsulador
 * @author Fco Javier P�rez Escriv�
 *
 */
abstract public class Encapsulador {
		protected HttpServletRequest request;
		
		protected String tipo;
		/**
		 * Constructor
		 * @param tipo clase de encapsulador
		 * @param request informacion de la pagina web anterior
		 */
		public Encapsulador(String tipo,HttpServletRequest request){
			this.tipo=tipo;
			this.request=request;
		}
		/**
		 * 
		 *Realiza la accion de encapsular
		 */
		abstract public void encapsular();
}
