<%@ page import="beans.*" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Informacion Curso Consultar </title>
      <link href="../../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="../../../../styles/application.css" rel="stylesheet" type="text/css"/>
      
      <script language=JavaScript type="text/JavaScript">        
          function lanzaFormulario (evento) {
            document.formSubmenu.evento.value = evento;
            document.formSubmenu.submit();
          };      
      </script>
     
  </head>
   <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Información Curso</b></font>                
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
    		  <div align="right" style="position:relative; top:25px; z-index:-1;">
    		    <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    		      <input type="hidden" name="evento">
    	  			<div class="botonesSubMenu">
    	  			  <a href="JavaScript:lanzaFormulario('menuPrincipalSec');" onmouseout="window.status=''" onmouseover="window.status='Menu principal';return true ">Menu principal</a>
                <a href="JavaScript:lanzaFormulario('GES_CUR');" onmouseout="window.status=''" onmouseover="window.status='Menu curso';return true ">Menu curso</a>
      					<a href="JavaScript:lanzaFormulario('desconectar');" onmouseout="window.status=''" onmouseover="window.status='Desconectar';return true "><font color="#660000">Desconectar</font></a>
    				  </div>
    				</form>
    		  </div>
    		<div style="position:relative; top:4px; z-index:-1;">
    			 <table width="983px" border="0" cellspacing="0" cellpadding="0">
    		         <tr>
    				    <td class="lineaSep"></td>
    		         </tr>
    			 </table>
    		</div>
    		<div style="position:relative; top:20px; left:80px; z-index:-1;">
    			<form method=post action="/virtuaula/ServletVisualizador">
			  <B>DATOS DEL CURSO</B><BR>
              <table  width="90%" border="0" cellspacing="0" cellpadding="10" >
        				<tr bgcolor="#877fff">        					
        					<th class="FormLiteral"><b>Nombre Curso</th>
        					<th class="FormLiteral"><b>Número de plazas</th>
        					<th class="FormLiteral"><b>Estado</th>
        					<th class="FormLiteral"><b>Fecha Inicio</th>
        					<th class="FormLiteral"><b>Fecha Fin</th>	
        					<th class="FormLiteral"><b>Precio</th>
        					<th class="FormLiteral"><b>Área</th>
        				</tr>
        				
        				
        				
        			<%
                    HttpSession sesion=request.getSession();
                    ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("listacurso"));
                    Integer posicionLista =((Integer)sesion.getAttribute("posCurso"));
                  	Curso curso;	
                  	Area area = (Area) sesion.getAttribute("beanArea");
                  	
                  	if (listaObjetoBean != null && !listaObjetoBean.esVacio()){
                  	
                    	if (posicionLista != null) {
                    	
                        curso = (Curso) listaObjetoBean.dameObjeto(posicionLista.intValue());
    	                   %> <tr bgcolor="#dbecff">
    	                  <%
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("NOMBRE"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("NUMERO_PLAZAS"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("ESTADO"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("FECHA_INICIO"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("FECHA_FIN"))+"</td>");
                        out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("PRECIO"))+"</td>");
                         out.println("<td class='FormLiteral' align='center'>"+String.valueOf(area.dameValor("NOMBRE"))+"</td>");		 
    	                  out.println("</tr>");
  	                  
                      }
                    }

                %>  
                </table>
                <BR><BR>
                <B>DATOS DEL PROFESOR</B><BR>
                
                <table width="90%" border="0" cellspacing="0" cellpadding="10">
        				<tr bgcolor="#877fff">        					
        					<th class="FormLiteral"><b>DNI</th>        					
        					<th class="FormLiteral"><b>Nombre</th>
        					<th class="FormLiteral"><b>Primer Apellido</th>
        					<th class="FormLiteral"><b>Segundo Apellido</th>
        					<th class="FormLiteral"><b>Teléfono</th>
        					<th class="FormLiteral"><b>Correo electrónico</th>
        					<th class="FormLiteral"><b>Área</th>
        				</tr>
        				
        				
        			<%
                    	Profesor profesor = (Profesor) sesion.getAttribute("beanProfesor");

						%> <tr bgcolor="#dbecff">
    	                  <%
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("ISUSUARIO_DNI"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("NOMBRE"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("APELLIDO1"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("APELLIDO2"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("TELEFONO"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("EMAIL"))+"</td>");
                          out.println("<td class='FormLiteral' align='center'>"+String.valueOf(area.dameValor("NOMBRE"))+"</td>");	                    	                   	                    
    	                  
                          out.println("</tr>");
    	                  
  	                  
                %>
              
              	</table>
              	<BR><BR>
                <B>DATOS DEL AULA</B><BR>
              	<table width="90%" border="0" cellspacing="0" cellpadding="10">
        				<tr bgcolor="#877fff">        					
        					<th class="FormLiteral"><b>Nombre</th>        					
        					<th class="FormLiteral"><b>Capacidad</th>
        					<th class="FormLiteral"><b>Localización</th>
        				</tr>
        				
        				
        			<%
                    	Aula aula = (Aula) sesion.getAttribute("beanAula");

						%> <tr bgcolor="#dbecff">
    	                  <%
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(aula.dameValor("NOMBRE"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(aula.dameValor("CAPACIDAD"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(aula.dameValor("LOCALIZACION"))+"</td>");                   	                   	                    
    	                  
                          out.println("</tr>");
    	                  
  	                  
                %>
              
              	</table>
              	
              	              	<BR><BR>
                <B>HORARIO</B><BR>
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
                    	Horario horario = (Horario) sesion.getAttribute("beanHorario");

						  out.println("<tr>"); %>
    	                  <td bgcolor="#dbecff" class='FormLiteral' align='center'>Mañana</td>
    	                  <%
    	                  String color = "white";
    	                  if ((String.valueOf(horario.dameValor("L"))).equals("M")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");
    	                  color = "white";
    	                  if ((String.valueOf(horario.dameValor("M"))).equals("M")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");
    	                  color = "white";
    	                  if ((String.valueOf(horario.dameValor("X"))).equals("M")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");
    	                  color = "white";
    	                  if ((String.valueOf(horario.dameValor("J"))).equals("M")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");
    	                  color = "white";
    	                  if ((String.valueOf(horario.dameValor("V"))).equals("M")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");    	                      	                  
                          out.println("</tr>");
                          
                          out.println("<tr>"); %>
    	                  <td bgcolor="#dbecff" class='FormLiteral' align='center'>Tarde</td>
    	                  
    	                  <% 
    	                  
    	                  color = "white";
    	                  if ((String.valueOf(horario.dameValor("L"))).equals("T")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");
    	                  color = "white";
    	                  if ((String.valueOf(horario.dameValor("M"))).equals("T")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");
    	                  color = "white";
    	                  if ((String.valueOf(horario.dameValor("X"))).equals("T")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");
    	                  color = "white";
    	                  if ((String.valueOf(horario.dameValor("J"))).equals("T")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");
    	                  color = "white";
    	                  if ((String.valueOf(horario.dameValor("V"))).equals("T")){
    	                  	color = "ffff8d";
    	                  }
    	                  out.println("<td bgcolor='" + color + "' class='FormLiteral' align='center'></td>");    	                      	                  
                          out.println("</tr>");
    	                  
  	                  
                %>
              
              	</table>
             <BR>
                <table align="center">
              	<tr align="center">
					        <td align="center"> 
					          <input type="hidden" name="evento" value="menuPrincipalSec">
						        <button type="submit" class="botonSimple">Aceptar</button>
					         </td>
				        </tr>	                       				
        			</table>
          </form>
    		</div>
	  </div>
   </body>
</html>
