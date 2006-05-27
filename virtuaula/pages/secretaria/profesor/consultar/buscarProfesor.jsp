<%@ page import="beans.*" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Buscar Profesor Consultar </title>
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Consultar Profesor</b></font>                
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
    		  <div align="right" style="position:relative; top:25px; z-index:-1;">
    		    <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    		      <input type="hidden" name="evento">
    	  			<div class="botonesSubMenu">
    	  			  <a href="JavaScript:lanzaFormulario('menuPrincipalSec');" onmouseout="window.status=''" onmouseover="window.status='Volver al menu principal';return true ">Volver al menu principal</a>
                <a href="JavaScript:lanzaFormulario('GES_PROF');" onmouseout="window.status=''" onmouseover="window.status='Volver al menu profesor';return true ">Volver al menu de profesor</a>
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
    		<div style="position:relative; left:10px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Rellene los campos conocidos del profesor (paso 1/3)</b>                
    		</div>
    		<div style="position:relative; top:40px; left:150px; z-index:-1;">
    			<form method=post action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10">
        				<tr>
        					<td class="FormLiteral">DNI</td>
        					<td><input type="text" class="FormTxt" maxlength="9" name="ISUSUARIO_DNI"></td>
        					<td width="100"></td>
        					<td class="FormLiteral">Nombre</td>
        					<td><input type="text" class="FormTxt" maxlength="40" name="NOMBRE"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Primer Apellido</td>
        					<td><input type="text" class="FormTxt" maxlength="40" name="APELLIDO1"></td>
        					<td></td>
        					<td class="FormLiteral">Segundo Apellido</td>
        					<td><input type="text" class="FormTxt" maxlength="40" name="APELLIDO2"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Telefono</td>
        					<td><input type="text" class="FormTxt" maxlength="9" name="TELEFONO"></td>
        					<td></td>
        					<td class="FormLiteral">Correo electrónico</td>
        					<td><input type="text" class="FormTxt" maxlength="50" name="EMAIL"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Area</td>
        					<td>        					       					
              				<%
              				    HttpSession sesion=request.getSession();
                          ListaObjetoBean listaAreas =((ListaObjetoBean)sesion.getAttribute("listaarea"));
              
                          if (listaAreas != null && !listaAreas.esVacio()) {
                	            Area area;	
                	            out.println("<select name='ISAREA_IDISAREA' class='FormTxt'>");
                	            out.println("<option value=''>Seleccione un area</option>");                	                            	            
                              for (int i = 0; i < listaAreas.tamanio(); i++) {
                                  area = (Area) listaAreas.dameObjeto(i);
                                  out.println("<option value='"+String.valueOf(area.dameValor("IDISAREA"))+"'>"+String.valueOf(area.dameValor("NOMBRE"))+"</option>");
      			                  }
                              out.println("</select>");
                          } else 
                                {
                                out.println("<font class='FormLiteral'>No hay creada ningún área.</font>");                                
                                }
                      %>
                  </td>
        				</tr>        				 
              	<tr>
					         <td colspan="7" align="center">
						        <input type="hidden" name="evento" value="CONS_PROF">
						        <input type="hidden" name="idBean" value="Profesor">
                    <button type="submit" class="botonSimple">Buscar</button>
					         </td>
				        </tr>	                       				
        			</table>
          </form>
    		</div>
	  </div>
   </body>
</html>
