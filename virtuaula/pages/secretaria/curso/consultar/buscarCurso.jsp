<%@ page import="beans.*" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Buscar Curso Consultar </title>
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Consultar Curso</b></font>                
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
              <table border="0" cellspacing="0" cellpadding="10">
        				<tr>
        					<td class="FormLiteral">DNI del profesor</td>
        					<td><input type="text" class="FormTxt" maxlength="9" name="ISPROFESOR_ISUSUARIO_DNI"></td>
        					<td width="100"></td>
        					<td class="FormLiteral">Nombre Curso</td>
        					<td><input type="text" class="FormTxt" maxlength="40" name="NOMBRE"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Número de plazas</td>
        					<td><input type="text" class="FormTxt" maxlength="40" name="NUMERO_PLAZAS"></td>
        					<td></td>
        					<td class="FormLiteral">Estado</td>
        					<td><input type="text" class="FormTxt" maxlength="40" name="ESTADO"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Fecha Inicio</td>
        					<td><input type="text" class="FormTxt" maxlength="40" name="FECHA_INICIO"></td>
        					<td></td>
        					<td class="FormLiteral">Fecha Fin</td>
        					<td><input type="text" class="FormTxt" maxlength="40" name="FECHA_FIN"></td>
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
                	            out.println("<option value=''></option>");                	                            	            
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
                  <td class="FormLiteral">Precio</td>
        		<td><input type="text" class="FormTxt" maxlength="50" name="PRECIO"></td>
        				</tr>  
        				<tr>
        					<td class="FormLiteral">Horario</td>
        					<td>        					       					
              				<%
              				    ListaObjetoBean listaHorarios =((ListaObjetoBean)sesion.getAttribute("listahorario"));
              
                          if (listaHorarios != null && !listaHorarios.esVacio()) {
                	            Horario horario;	
                	            out.println("<select name='ISHORARIO_IDISHORARIO' class='FormTxt'>");
                	            out.println("<option value=''></option>");                	                            	            
                              for (int i = 0; i < listaHorarios.tamanio(); i++) {
                                  horario = (Horario) listaHorarios.dameObjeto(i);
                                  out.println("<option value='"+String.valueOf(horario.dameValor("IDISHORARIO"))+"'>"+String.valueOf(horario.dameValor("IDISHORARIO"))+"</option>");
      			                  }
                              out.println("</select>");
                          } else 
                                {
                                out.println("<font class='FormLiteral'>No hay creado ningún horario.</font>");                                
                                }
                      %>
                  </td>
        					<td class="FormLiteral">Aula</td>
        					<td>        					       					
              				<%
              				    ListaObjetoBean listaAulas =((ListaObjetoBean)sesion.getAttribute("listaaula"));
              
                          if (listaAulas != null && !listaAulas.esVacio()) {
                	            Aula aula;	
                	            out.println("<select name='ISAULA_IDISAULA' class='FormTxt'>");
                	            out.println("<option value=''></option>");                	                            	            
                              for (int i = 0; i < listaAulas.tamanio(); i++) {
                                  aula = (Aula) listaAulas.dameObjeto(i);
                                  out.println("<option value='"+String.valueOf(aula.dameValor("IDISAULA"))+"'>"+String.valueOf(aula.dameValor("NOMBRE"))+"</option>");
      			                  }
                              out.println("</select>");
                          } else 
                                {
                                out.println("<font class='FormLiteral'>No hay creada ningún aula.</font>");                                
                                }
                      %>
                  </td>      				 
              	<tr>
					         <td colspan="7" align="center">
						        <input type="hidden" name="evento" value="CONS_CUR">
						        <input type="hidden" name="idBean" value="Curso">
                    <button type="submit" class="botonSimple">Buscar</button>
					         </td>
				        </tr>	                       				
        			</table>
          </form>
    		</div>
	  </div>
   </body>
</html>
