package sms;

import java.io.*;
import java.net.*;
/**
 * Esta clase utiliza el paquete java.net para implementar métodos de envio de mensajes cortos sms
 * a télefonos móviles. Para que funcione correctamente se debe abrir una cuenta en www.peoplecall.com
 * y rellenar los datos de usuario y contraseña en el método envia, si no no funcionará. 
 * @author JORGE SANCHEZ
 *
 */
public class SMS {
 /**
  * Establece una conexión por sockets con un servidor con soporte de envio sms
  * @param host el host que nos dará el servicio de envio de sms
  * @param puerto puerto de conexion al servidor
  * @param output petición que se le manda al servidor
  * 
  */
 private String socket_envia(String host, int puerto, String output) {

        Socket smtpSocket = null;  
        DataOutputStream os = null;
        BufferedReader is= null;
        String input = new String();

        try {
            smtpSocket = new Socket(host, puerto);
            os = new DataOutputStream(smtpSocket.getOutputStream());
            is = new BufferedReader(new InputStreamReader(smtpSocket.getInputStream()));

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: hostname");
        } catch (IOException e) {
            return(null);
        }

        if (smtpSocket != null && os != null && is != null) {
            try {


                os.writeBytes(output);

                String responseLine;
                while ((responseLine = is.readLine()) != null) {
                     input=input.concat(responseLine+"\r\n");
                }

                os.close();
                is.close();
                smtpSocket.close();  
            } catch (UnknownHostException e) {
                 return(null);
           } catch (IOException e) {
                 return(null);
           }
        
          return(input);
        }
    return(null);

    }          
/**
 * Envia un sms al numero de telefono numero.
 * @param numero al cual queremos mandar el sms
 * @param texto texto a enviar
 * @return 0 en caso de exito, -1 si no
 */
public int envia(String numero, String texto) {

  String peticion=new String();
  String respuesta;
  String user="";
  String password="";

  String post_data=new String("user="+user+"&pwd="+password+"&lang=es&fwd=home&p=");

  peticion=peticion.concat("POST /www/checklogin HTTP/1.0\r\n");
  peticion=peticion.concat("Host: secure2.peoplecall.com\r\n");
  peticion=peticion.concat("Content-Length: "+post_data.length()+"\r\n");
  peticion=peticion.concat("Content-type: application/x-www-form-urlencoded\r\n");
  peticion=peticion.concat("\r\n"); 
  peticion=peticion.concat(post_data);

  //System.out.println(peticion);

  respuesta=socket_envia("secure2.peoplecall.com",80,peticion);
  
  if (respuesta==null) return(-1);

//  System.out.println(respuesta);

   // Buscar la cookie
  int begin=respuesta.indexOf("JSESSIONID=");
  int end=respuesta.indexOf("; Path=/www");

  String cookie_str=respuesta.substring(begin,end);
  //System.out.println(cookie_str);

  texto=texto.replaceAll(" ","+");
  
  post_data=new String("body="+texto+"&destination_number=34"+numero);

  peticion=new String();
  peticion=peticion.concat("POST /www/statusmsend HTTP/1.0\r\n");
  peticion=peticion.concat("Host: secure2.peoplecall.com\r\n");
  peticion=peticion.concat("Content-Length: "+post_data.length()+"\r\n");
  peticion=peticion.concat("Content-type: application/x-www-form-urlencoded\r\n");
  peticion=peticion.concat("Cookie: "+cookie_str+"\r\n");
  peticion=peticion.concat("\r\n");
  peticion=peticion.concat(post_data);

  //System.out.println(peticion);
  respuesta=socket_envia("secure2.peoplecall.com",80,peticion);

  if (respuesta==null) return(-1);

  //System.out.println(respuesta);
  return(0);



}




}