<%@ page import="beans.*" %>
<%@ page import="beans.Error" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<%@ page import="beans.ObjetoBean" %>

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Eliminar un Horario </title>
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Eliminar un Horario</b></font>                
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
             </div>
    		  </b>
    		  <div align="right" style="position:relative; z-index:-1;">
    		    <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    		      <input type="hidden" name="evento">
    	  			<div class="botonesSubMenu">
    	  			  <a href="JavaScript:lanzaFormulario('menuPrincipalSec');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver al menú principal'; overlib('Pulse aquí si desea volver al menú principal'); return true;">Volver al menú principal</a>
                        <a href="JavaScript:lanzaFormulario('GES_HOR');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver a gestión de horarios'; overlib('Pulse aquí si desea volver a gestión de horarios'); return true;">Volver a gestión de horarios</a>
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
    		<div style="position:relative; left:10px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Verifique que es el horario a eliminar (paso 2/2)</b></font>                
    		</div>
    		<div style="position:relative; left:20px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E">
    			  Verifique que el horario seleccionado es el que desea eliminar<br>
    			  Pulse "Eliminar" para que el horario seleccionado desaparezca del conjunto de horarios predefinidos
    			</font>
    		</div>
    		<div style="position:relative; top:10px; left:80px; z-index:-1;">
    			<form name="buscarHorario" method=post action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10">
        				
                <% HttpSession sesion=request.getSession();
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
        					<th class="FormLiteral"><b>Miércoles</th>
        					<th class="FormLiteral"><b>Jueves</th>
        					<th class="FormLiteral"><b>Viernes</th>
        				</tr>
        				       				
                    	<% 

						  out.println("<tr>"); %>
    	                  <td bgcolor="#dbecff" class='FormLiteral' align='center'>Mañana</td>
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
					         	<input type="hidden" name="evento" value="ELIM_HOR_PAS3">
                    			<button type="submit" class="botonSimple">Eliminar</button>
					         </td>
				        </tr>	                       				
        			</table>
              	
          </form>
    		</div>
	  </div>	  	  
    <div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:-100px; width:50px"></div>	 
   </body>
</html>
