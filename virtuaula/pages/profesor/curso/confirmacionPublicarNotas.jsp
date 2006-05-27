<%@ page import="beans.*" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<%@ page import="beans.BeanExpedienteCurso" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Buscar Profesor Consultar </title>
      <link href="../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="../../../styles/application.css" rel="stylesheet" type="text/css"/>
      
      <script language=JavaScript type="text/JavaScript">        
          function lanzaFormulario (evento) {
            document.formSubmenu.evento.value = evento;
            document.formSubmenu.submit();
          };      
      </script>    
  </head>
   <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
   <body background="../../../img/fondo.jpg">
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td width="3000" background="../../../img/cabF.jpg"><img src="../../../img/cabI.jpg"></td>
            <td><img src="../../../img/cabD.jpg" width="537px" height="78px" border="0"></td>
         </tr>
      </table>
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td background="../../../img/barF.gif"><img src="../../../img/barF.gif" border="0"></td>
         </tr>
         <tr>
            <td background="../../../img/ContenidoF.gif" height="40px">&nbsp;</td>
         </tr>
      </table>
      <div id="lyComponentes" style="position:absolute; left:0px; top:75px; width:955px; z-index:1; overflow:inherit;">
		  	 <div align="left" style="position:relative; top:15px; left:15px">
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Publicar Notas</b></font>                
    	   </div> 
         <div align="right" style="position:relative; top:-5px">               
    		  	 <font face="Verdana, Arial, Helvetica, sans-serif" color=#616D7E size=2>
                <script language=JavaScript type="text/JavaScript">
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
    		  <div align="right" style="position:relative; z-index:-1;">
    		    <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    		      <input type="hidden" name="evento">
    	  			<div class="botonesSubMenu">
                <a href="JavaScript:lanzaFormulario('menuPrincipalProf');" onmouseout="window.status=''" onmouseover="window.status='Volver al menu profesor';return true ">Volver al menu profesor</a>
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
    		<div style="position:relative; top:30px; left:80px; z-index:-1;">
    		<font face="Trebuchet MS" color="#616D7E" point-size="5">
    			<form method=post action="/virtuaula/ServletVisualizador">
              			  <B>Ha publicado las notas del curso</B><BR>
              <div style="position:relative; top:30px; left:30px; z-index:-1;">
              <table width="90%" border="0" cellspacing="0" cellpadding="10" >
        				<tr bgcolor="#877fff">        					
        					<th class="FormLiteral"><b>DNI</b></th>	
        					<th class="FormLiteral"><b>Nombre</b></th>
        					<th class="FormLiteral"><b>Primer Aplellido</b></th>
        					<th class="FormLiteral"><b>Segundo Apellido</b></th>
        					<th class="FormLiteral"><b>Nota Final</b></th>	
        				</tr>	
        			<%
                    HttpSession sesion=request.getSession();
                    ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("listaexpedientealumno"));
                    ObjetoBean expediente;	
                  	for(int i=0;i<listaObjetoBean.tamanio();i++){
                  	expediente = (ObjetoBean) listaObjetoBean.dameObjeto(i);
                  	if (listaObjetoBean != null && !listaObjetoBean.esVacio()){
                  	%> <tr bgcolor="#dbecff">
    	                  <%
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("ISUSUARIO_DNI"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("NOMBRE"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("APELLIDO1"))+"</td>");	
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("APELLIDO2"))+"</td>");	
    	                  if ((String.valueOf(expediente.dameValor("NOTAFINAL"))).equals("-1")){
    	                  	out.println("<td class='FormLiteral' align='center'>No presentado</td>");	
    	                  }
    	                  else{
    	                  	out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("NOTAFINAL"))+"</td>");	
    	                  }
    	                  out.println("</tr>");
                      }
                      }
                %>  
                </table>
                </div>
                <BR><BR>
              <table border="0" align="center" cellspacing="0" cellpadding="5">                 	                      				                      				
              	<tr >
					         <td>
                      <input type="hidden" name="evento" value="menuPrincipalProf">
                      <button type="submit" class="botonSimple">Aceptar</button>
					         </td>
				        </tr>	                       				
        			</table>
          </form>
    		</div>
	  </div>
   </body>
</html>
