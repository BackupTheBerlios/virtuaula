<%@ page import="beans.*" %>
<%@ page import="beans.Error" %>
<%@ page import="beans.listaObjetoBeans.*" %>

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Profesor Contratado </title>
      <link href="../../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="../../../../styles/application.css" rel="stylesheet" type="text/css"/>
      <script language="JavaScript" src="../../../../script/overlib_mini.js"></script>

      <script language=JavaScript type="text/JavaScript">        
          function lanzaFormulario (evento) {
            document.formSubmenu.evento.value = evento;
            document.formSubmenu.submit();
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Profesor Contratado</b></font>                
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
    	  			    <a href="JavaScript:lanzaFormulario('menuPrincipalRRHH');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver al menú principal'; overlib('Pulse aquí si desea volver al menú principal'); return true;">Volver al menú principal</a>
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
    			<font face="Trebuchet MS" color="#616D7E"><b>Profesor ha sido contratado (paso 2/2)</b></font>
    		</div>
    		<div style="position:relative; left:20px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E">
    			    Aquí tiene los datos del profesor contratado<br>
    			    Informe al profesor de su usuario y contraseña para acceder al sistema
    			</font>
    		</div>

    		
    	 <%
            HttpSession sesion=request.getSession();
            ObjetoBean profesor = (ObjetoBean) sesion.getAttribute("beanProfesor");
            ObjetoBean nomina = (ObjetoBean) sesion.getAttribute("beanNomina");
            ObjetoBean contrato = (ObjetoBean) sesion.getAttribute("beanContrato");
            if (profesor == null) {profesor = new Profesor ();}
            if (nomina == null) {nomina = new Nomina ();}
            if (contrato == null) {contrato = new Contrato ();}
        %>
    		
    		<div style="position:relative; top:20px; left:80px; z-index:-1;">
    			<form name="insertarProfesor" method=post action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10">
        				<tr>
        					<td class="FormLiteral">DNI</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="9" name="ISUSUARIO_DNI" value="<%=profesor.dameValor("ISUSUARIO_DNI")%>"></td>
        					<td width="100"></td>
        					<td class="FormLiteral">Nombre</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="40" name="NOMBRE" value="<%=profesor.dameValor("NOMBRE")%>"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Primer Apellido</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="40" name="APELLIDO1" value="<%=profesor.dameValor("APELLIDO1")%>"></td>
        					<td></td>
        					<td class="FormLiteral">Segundo Apellido</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="40" name="APELLIDO2" value="<%=profesor.dameValor("APELLIDO2")%>"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Telefono</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="9" name="TELEFONO" value="<%=profesor.dameValor("TELEFONO")%>"></td>
        					<td></td>
        					<td class="FormLiteral">Correo electrónico</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="50" name="EMAIL" value="<%=profesor.dameValor("EMAIL")%>"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Área</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="100" name="ISAREA_IDISAREA" value="<%=profesor.dameValor("ISAREA_IDISAREA")%>"></td>
        					<td></td>
        					<td class="FormLiteral">Tipo de contrato</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="100" value="<%=contrato.dameValor("TIPO")%>"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Número de cuenta</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="100" value="<%=nomina.dameValor("CUENTA_INGRESOS")%>"></td>
        					<td></td>
        					<td class="FormLiteral">Sueldo</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="100" value="<%=nomina.dameValor("CANTIDAD")%>"></td>
        				</tr>
        				<tr>        				
   				 <%
                    
                    Usuario usuario = (Usuario) sesion.getAttribute("usuario");
                    if (usuario != null) {
                      out.println("<tr>");
                      out.println("<td class='info'><b>Usuario</td>");
                      out.println("<td><input type='text' class='FormTxt' disabled='true' maxlength='9' name='DNI' value='"+usuario.dameValor("DNI")+"'></td>");
                      out.println("<td></td>");
                      out.println("<td class='info'><b>Pass</td>");
                      out.println("<td><input type='text' class='FormTxt' disabled='true' maxlength='20' name='CONTRASENIA' value='"+usuario.dameValor("CONTRASENIA")+"'></td>");
                      out.println("</td>");
                      out.println("</tr>");
                    }
                                                           
                %>
                
                                                     				
              	<tr>
					         <td colspan="7" align="center">
					          <input type="hidden" name="idBean" value="">
					          <input type="hidden" name="evento" value="CONTRATO">					         
						        <button type="submit" class="botonSimple">Aceptar</button>
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
                          out.println("     <td width='34%' align='left' height='18' bordercolor='#800000' bgcolor='#FFFFFF'>");                  
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
