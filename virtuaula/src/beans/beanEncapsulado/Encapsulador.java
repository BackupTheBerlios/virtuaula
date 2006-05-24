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
		public Encapsulador(String tipo,HttpServletRequest request){
			this.tipo=tipo;
			this.request=request;
		}
		abstract public void encapsular();
}
