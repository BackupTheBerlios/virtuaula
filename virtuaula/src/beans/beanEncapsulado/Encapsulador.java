package beans.beanEncapsulado;
import javax.servlet.http.HttpServletRequest;
/**
 * Abstracción de cualquier tipo de encapsulador
 * @author Fco Javier Pérez Escrivá
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
