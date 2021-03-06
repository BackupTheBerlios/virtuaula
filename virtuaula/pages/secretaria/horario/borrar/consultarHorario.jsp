<%@ page import="beans.*" %>
<%@ page import="beans.Error" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<%@ page import="beans.ObjetoBean" %>

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Consultar datos de un Horario a Eliminar</title>
      <link href="../../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="../../../../styles/application.css" rel="stylesheet" type="text/css"/>
      <script language="JavaScript" src="../../../../script/overlib_mini.js"></script>

      <script language=JavaScript type="text/JavaScript">        
          function lanzaFormulario (evento) {
            document.buscarHorario.evento.value = evento;
            document.buscarHorario.submit();
          };      
      </script> 

  </head>
   <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
   <body background="../../../../img/fondo.jpg"> 
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
      	 
         <tr>
            <td width="3000" background="../../../../img/cabF.jpg"><img src="../../../../img/cabI.jpg"></td>
            <td><img src="../../../../img/cabD.jpg" width="537px" height="78px" border="0"></td>
         </tr>
      </table>
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td background="../../../../img/barF.gif"><img src="../../../../img/barF.gif" border="0"></td>
         </tr>
         <tr>
            <td background="../../../../img/ContenidoF.gif" height="40px">&nbsp;</td>
         </tr>
      </table>
      <div id="lyComponentes" style="position:absolute; left:0px; top:75px; width:955px; z-index:1; overflow:inherit;">
		  	 <div align="left" style="position:relative; top:15px; left:15px">
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Consulta de un Horario a Eliminar</b></font>                
    	   </div>                   			  	 
         <div align="right" style="position:relative; top:-5px">               
    		  	<b>       
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
              </b>
             </div>
    		  <div align="right" style="position:relative; z-index:-1; top:5px;">
    		    <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    		      <input type="hidden" name="evento">
    	  			<div class="botonesSubMenu">
    	  			  <a href="JavaScript:lanzaFormulario('menuPrincipalSec');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver al men� principal'; overlib('Pulse aqu� si desea volver al men� principal'); return true;">Volver al men� principal</a>
                        <a href="JavaScript:lanzaFormulario('GES_HOR');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver a gesti�n de horarios'; overlib('Pulse aqu� si desea volver a gesti�n de horarios'); return true;">Volver a gesti�n de horarios</a>
      					<a href="JavaScript:lanzaFormulario('desconectar');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Salir'; overlib('Pulse aqu� si desea salir de la aplicaci�n'); return true;"><font color="#660000">Salir</font></a>
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
    		<div style="position:relative; left:10px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Seleccione el horario (paso 1/2)</b></font>                
    		</div>
    		<div style="position:relative; left:20px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E">
    			  Seleccione un horario de la lista de horarios predefinidos existentes en la academia<br>
    			  Pulse "Consultar" para ver la disposici�n del horario seleccionado en el cuadro semanal
    			</font>
    		</div>
    		<div style="position:relative; top:10px; left:80px; z-index:-1;">
    			<form name="buscarHorario" method=post action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10">
        				<tr>
        					<td class="FormLiteral">Horarios Disponibles</td>
        					<td>        					       					
              				<% HttpSession sesion=request.getSession();
              				    ListaObjetoBean listaHorarios =((ListaObjetoBean)sesion.getAttribute("listahorario"));
              
                          if (listaHorarios != null && !listaHorarios.esVacio()) {
                	            Horario horario;	
                	            out.println("<select name='posHor' class='FormTxt'>");
                	            out.println("<option value=''>Seleccione un horario &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;</option>");                	                            	            
                              for (int i = 0; i < listaHorarios.tamanio(); i++) {
                                  horario = (Horario) listaHorarios.dameObjeto(i);
                                  out.println("<option value='"+String.valueOf(i)+ "'>"); 
								  if (!(String.valueOf(horario.dameValor("L"))).equals("null")){
								  out.println("L" + String.valueOf(horario.dameValor("L")) + " " );
								  }
								  if (!(String.valueOf(horario.dameValor("M"))).equals("null")){
								  out.println("M" + String.valueOf(horario.dameValor("M")) + " " );
								  }
								  if (!(String.valueOf(horario.dameValor("X"))).equals("null")){
								  out.println("X" + String.valueOf(horario.dameValor("X")) + " " );
								  }
								  if (!(String.valueOf(horario.dameValor("J"))).equals("null")){
								  out.println("J" + String.valueOf(horario.dameValor("J")) + " " );
								  }
								  if (!(String.valueOf(horario.dameValor("V"))).equals("null")){
								  out.println("V" + String.valueOf(horario.dameValor("V")) );
								  }
								  out.println("</option>");
      			                  }
                              out.println("</select>");
                          } else 
                                {
                                out.println("<font class='FormLiteral'>No hay creado ning�n horario.</font>");                                
                                }
                      %>
                  </td>
                  </tr>	
                 </table>
                 </table>
              	
              	              	<BR><BR>
                <% 
                Horario horario = (Horario)sesion.getAttribute("beanHorario");
                out.println("<B>HORARIO");
                if (horario!= null){
                  if (!(String.valueOf(horario.dameValor("L"))).equals("null")){
				  out.println("L" + String.valueOf(horario.dameValor("L")) + " " );
				  }
				  if (!(String.valueOf(horario.dameValor("M"))).equals("null")){
				  out.println("M" + String.valueOf(horario.dameValor("M")) + " " );
				  }
				  if (!(String.valueOf(horario.dameValor("X"))).equals("null")){
				  out.println("X" + String.valueOf(horario.dameValor("X")) + " " );
				  }
				  if (!(String.valueOf(horario.dameValor("J"))).equals("null")){
				  out.println("J" + String.valueOf(horario.dameValor("J")) + " " );
				  }
				  if (!(String.valueOf(horario.dameValor("V"))).equals("null")){
				  out.println("V" + String.valueOf(horario.dameValor("V")) );
				  }
				}
                out.println("</B><BR>");
                %> 
              	
              	<table  width="90%" 
              	style= "border-right: 2px solid #dbecff; border-bottom: 2px solid #dbecff; border-left: hidden; border-top: hidden"
              	 cellspacing="0" cellpadding="10">
        				<tr bgcolor="#877fff">        					
        					<th class="FormLiteral"><b>Turno</th> 
        					<th class="FormLiteral"><b>Lunes</th>        					
        					<th class="FormLiteral"><b>Martes</th>
        					<th class="FormLiteral"><b>Mi�rcoles</th>
        					<th class="FormLiteral"><b>Jueves</th>
        					<th class="FormLiteral"><b>Viernes</th>
        				</tr>
        				       				
                    	<% 

						  out.println("<tr>"); %>
    	                  <td bgcolor="#dbecff" class='FormLiteral' align='center'>Ma�ana</td>
    	                  <%
    	                  String color = "white";
    	                  if ((horario!= null) && (String.valueOf(horario.dameValor("L"))).equals("M") ){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");
    	                  color = "white";
    	                  if ((horario!= null) && (String.valueOf(horario.dameValor("M"))).equals("M")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");
    	                  color = "white";
    	                  if ((horario!= null) && (String.valueOf(horario.dameValor("X"))).equals("M")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");
    	                  color = "white";
    	                  if ((horario!= null) && (String.valueOf(horario.dameValor("J"))).equals("M")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");
    	                  color = "white";
    	                  if ((horario!= null) && (String.valueOf(horario.dameValor("V"))).equals("M")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");    	                      	                  
                          out.println("</tr>");
                          
                          out.println("<tr>"); %>
    	                  <td bgcolor="#dbecff" class='FormLiteral' align='center'>Tarde</td>
    	                  
    	                  <% 
    	                  
    	                  color = "white";
    	                  if ((horario!= null) && (String.valueOf(horario.dameValor("L"))).equals("T")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");
    	                  color = "white";
    	                  if ((horario!= null) && (String.valueOf(horario.dameValor("M"))).equals("T")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");
    	                  color = "white";
    	                  if ((horario!= null) && (String.valueOf(horario.dameValor("X"))).equals("T")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");
    	                  color = "white";
    	                  if ((horario!= null) && (String.valueOf(horario.dameValor("J"))).equals("T")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");
    	                  color = "white";
    	                  if ((horario!= null) && (String.valueOf(horario.dameValor("V"))).equals("T")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");    	                      	                  
                          out.println("</tr>");
    	                  
  	                  
                %>
               
              
              	</table>
              	<br>
              	<br>
              	<table align="center">
              	<tr align="center">
					         <td >
					         	<input type="hidden" name="idBean" value="listHor">
						        <input type="hidden" name="evento" value="ELIM_HOR_PAS2">
                    			<button type="submit" class="botonSimple">Consultar</button>
					         </td>
				        </tr>	                       				
        			</table>
        			
 <table>
<%HttpSession sesion2=request.getSession();
ListaObjetoBean lista=(ListaObjetoBean)sesion2.getAttribute("error");%>
<% 
if (lista != null) 
{
int numeroElementos = lista.tamanio();
for (int i=0; i < numeroElementos; i++)
{
Error error = (Error) lista.dameObjeto(i);
%>
<tr class="error">
<td width="34%" align="left" height="18" bordercolor="#800000" bgcolor="#FFFFFF">  
<%= error.dameValor("CAUSA_ERROR")%>
</td>
</tr>
<%
}
}
%>        
		
        			</table>             	
          </form>
    		</div>
	  </div>	  	  
    <div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:-100px; width:50px"></div>	 
   </body>
</html>
