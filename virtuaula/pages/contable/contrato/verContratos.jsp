<%@ page import="beans.*" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Contratos </title>
      <link href="../../../styles/estilosBotones.css" rel="stylesheet" type="text/css">
      
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
            <td><img src="../../../img/cabD.jpg" width="537" height="78" border="0" usemap="#Map"></td>
         </tr>
      </table>
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td background="../../../img/barF.gif"><img src="../../../img/barF.gif" border="0"></td>
         </tr>
         <tr>
            <td background="../../../img/ContenidoF.gif" height="40">&nbsp;</td>
         </tr>
      </table>
      <div id="lyComponentes" style="position:absolute; left:0px; top:75px; width:955px; z-index:1; overflow:inherit;">
		  <div style="position:relative; top:12px;">
			     	 		  	
		  	 <div align="right" style="position:relative; top:0px">               
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
		 </div>
    		  <div align="right" style="position:relative; top:25px; z-index:-1;">
    		    <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    		      <input type="hidden" name="evento">
    	  			<div class="botonesSubMenu">
    	  			  <a href="JavaScript:lanzaFormulario('menuPrincipalCont');" onmouseout="window.status=''" onmouseover="window.status='Volver al menu principal';return true ">Volver al menu principal</a>
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
              	<font face="Trebuchet MS" color="#616D7E" point-size="5">
			  <B>Información sobre contratos de profesores</B><BR>
				<p>
              <table  width="90%" border="0" cellspacing="0" cellpadding="10" >
        				<tr bgcolor="#062e6d">        					
        					<th class="FormLiteral"><font face="Trebuchet MS" color="#d6ffff" point-size="5"><b>DNI Profesor</b></font></th>
        					<th class="FormLiteral"><font face="Trebuchet MS" color="#d6ffff" point-size="5"><b>Nombre</b></font></th>
        					<th class="FormLiteral"><font face="Trebuchet MS" color="#d6ffff" point-size="5"><b>Primer Apellido</b></font></th>
        					<th class="FormLiteral"><font face="Trebuchet MS" color="#d6ffff" point-size="5"><b>Segundo Apellido</b></font></th>	
        					<th class="FormLiteral"><font face="Trebuchet MS" color="#d6ffff" point-size="5"><b>Tipo Contrato</b></font></th>
        				</tr>	
        			<%
                    HttpSession sesion=request.getSession();
                    ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("listaprofesores"));
                    ListaObjetoBean listaObjetoBean2 =((ListaObjetoBean)sesion.getAttribute("listacontratos"));
                    ObjetoBean profesor;	
                    ObjetoBean contrato;	
                  	for(int i=0;i<listaObjetoBean.tamanio();i++){
                  	profesor = (ObjetoBean) listaObjetoBean.dameObjeto(i);
                  	contrato = (ObjetoBean) listaObjetoBean2.dameObjeto(i);
                  	if (listaObjetoBean != null && !listaObjetoBean.esVacio()){
                  	%> <tr bgcolor="#dbecff">
    	                  <%
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("ISUSUARIO_DNI"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("NOMBRE"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("APELLIDO1"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("APELLIDO2"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(contrato.dameValor("TIPO"))+"</td>");
    	                  out.println("</tr>");
                      }
                      }
                %>  
                </table>
                <BR><BR>
              <table border="0" align="center" cellspacing="0" cellpadding="5">                 	                      				                      				
              	<tr >
					         <td>
                      <input type="hidden" name="evento" value="menuPrincipalCont">
                      <button type="submit" class="botonSimple">Aceptar</button>
					         </td>
				        </tr>	                       				
        			</table>
          </form>
    		</div>
	  </div>

      <map name="map">
        <area shape="rect" coords="450,0,510,50" href="./index.html">
      </map>
   </body>
</html>
