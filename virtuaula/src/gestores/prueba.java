package gestores;
import java.util.Random;
public class prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Random rnd = new Random();
		int x;
		int contrasenia=1;
		for (int i=0;i<6;i++)
		{
		x = (int)(rnd.nextDouble() * 10.0);
		contrasenia= contrasenia*10+x;
		}
		Integer p=new Integer(contrasenia);
		String password=p.toString();
		
		System.out.println(password);
	         
	    		

}
}
