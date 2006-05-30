<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="beans.Error" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Enviar Aviso </title>
      <link href="./../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="./../../../styles/application.css" rel="stylesheet" type="text/css"/>
      <script language="JavaScript" src="./../../../script/overlib_mini.js"></script>
      
      <script language=JavaScript type="text/JavaScript">        
          function lanzaFormulario (evento) {
            document.formSubmenu.evento.value = evento;
            document.formSubmenu.submit();
          };             
             
      </script>
            
  </head>
   <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
   <body background="./../../../img/fondo.jpg">
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td width="3000" background="./../../../img/cabF.jpg"><img src="./../../../img/cabI.jpg"></td>
            <td><img src="./../../../img/cabD.jpg" width="537px" height="78px" border="0"></td>
         </tr>
      </table>
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td background="./../../../img/barF.gif"><img src="./../../../img/barF.gif" border="0"></td>
         </tr>
         <tr>
            <td background="./../../../img/ContenidoF.gif" height="40px">&nbsp;</td>
         </tr>
      </table>
      <div id="lyComponentes" style="position:absolute; left:0px; top:75px; width:955px; z-index:1; overflow:inherit;">
		  	 <div align="left" style="position:relative; top:15px; left:15px">
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Enviar Aviso</b></font>                
    	   </div> 
         <div align="right" style="position:relative; top:-5px">               
    		  	 <font face="Verdana, Arial, Helvetica, sans-serif" color=#616D7E size=2>
                <script language=JavaScript type=text/JavaScript>
                <!--   // Array ofmonth Names
                var monthNames = new Array( "Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octuble","Noviembre","Diciembre");
                var now = new Date();
                thisYear = now.getYear();
                if(thisYear < 1900) {thisYear += 1900}; // corrections if Y2K display problem
                document.write(now.getDate() + " de " + monthNames[now.getMonth()] + " de " + thisYear);
                // -->
                </script>
              </font>
          </div>
    		  <div align="right" style="position:relative; z-index:-1; top:5px;">
    		    <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    		      <input type="hidden" name="evento">
    	  			<div class="botonesSubMenu">
						<a href="JavaScript:lanzaFormulario('menuPrincipalProf');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver al menú principal'; overlib('Pulse aquí si desea volver al menú principal'); return true;">Volver al menú principal</a>
      					<a href="JavaScript:lanzaFormulario('desconectar');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Salir'; overlib('Pulse aquí si desea salir de la aplicación'); return true;"><font color="#660000">Salir</font></a>
    				  </div>
    				</form>
    		  </div>
    		<div style="position:relative; top:-16px; z-index:-1;">
    			 <table width="983px" border="0" cellspacing="0" cellpadding="0">
    		         <tr>
    				    <td class="lineaSep"></td>
    		         </tr>
    			 </table>
    		</div>
    		<div id="lyComponentes" style="position:absolute; left:0px; top:75px; width:955px; z-index:1; overflow:inherit;">
		  	 <div align="left" style="position:relative; top:15px; left:15px">
    			<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Escriba el aviso (paso 2/2)</b></font>                
    		</div>
    		<div style="position:relative; left:20px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E">
    			   Rellene el asunto y el contenido del mensaje<br>
    			   Seleccione el grupo de destinatarios de la lista<br>
    			   Cuando haya terminado de escribir el aviso pulse "Enviar"<br>
    			</font>
    		</div>
    		<div style="position:relative; left:40px; z-index:-1;">
    			<form method=post action="/virtuaula/ServletVisualizador" name="formPrincipal">  			
            <table border='0' cellspacing='0' cellpadding='20'>  
        				<tr>
        					<td class="FormLiteral">Asunto</td>
        					<td><input size="50" type="text" class="FormTxt" name="ASUNTO" maxlength="255"></td>

  
        					<td></td>        					
        					
        					<td class="FormLiteral">Grupos</td>
        					<td>
                      <select name="claveaviso" class="FormTxt">
                         <option value="">Seleccione un grupo</option>
                          <%

                                HttpSession sesion=request.getSession();
                        		    HashMap gruposAvisos = (HashMap) sesion.getAttribute("listagrupos");
                                
                                
                             		if (gruposAvisos != null){ 

                                    for (Iterator it = gruposAvisos.keySet().iterator(); it.hasNext(); ) {
                                        String key = (String) it.next();
                                        out.println("<option value='"+key+"'>"+key+"</option>");
                                        
                                    }                          
                                }
                          %>
                      </select> 
                  </td>
        				</tr>
        		</table> 
        		<table border='0' cellspacing='0' cellpadding='10'>  		
                    <tr>
            					<td class="FormLiteral" width="100">Anotaciones</td>
            					<td><textarea name="TEXTO" rows="15" cols="95" class="FormTxtArea"></textarea></td>
            					<td></td>
            				</tr>
                  	<tr>
    					         <td colspan="3" align="center">
    						        <input type="hidden" name="evento" value="ENV_AVI_PROF">
    						        <input type="hidden" name="idBean" value="enviaaviso">
                        <button type="submit" class="botonSimple">Enviar</button>
    					         </td>
    				        </tr>	                             				
                              
            </table>     				  
              <%
              
                  HttpSession sesion2=request.getSession();
                  ListaObjetoBean lista=(ListaObjetoBean)sesion2.getAttribute("error");
               
                  if (lista != null) 
                  {
                      out.println("<table>");
                      int numeroElementos = lista.tamanio();
                      for (int i=0; i < numeroElementos; i++)
                      {
                          Error error = (Error) lista.dameObjeto(i);
                  
                          out.println("<tr class='error'>");            
                          out.println("     <td width='34%' align='left' height='18' bordercolor='#800000' bgcolor='#FFFFFF'>"+error.dameValor("CAUSA_ERROR")+" ");                  
                                  error.dameValor("CAUSA_ERROR");
                          out.println("     </td>");
                          out.println("</tr>");                                                
                        }
                        out.println("</table>");
                    }
              %> 
          </form>
    		</div>
	  </div>
	  	  	  <div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:-100px; width:50px"></div>
   </body>
</html>
