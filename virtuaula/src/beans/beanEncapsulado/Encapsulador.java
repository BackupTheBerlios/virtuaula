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
		public Encapsulador(String tipo,HttpServletRequest request){
			this.tipo=tipo;
			this.request=request;
		}
		abstract public void encapsular();
}
