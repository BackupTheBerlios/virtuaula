<%@ page import="beans.*" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Buscar Curso Consultar </title>
      <link href="../../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="../../../../styles/application.css" rel="stylesheet" type="text/css"/>
      <script language="JavaScript" src="../../../../script/overlib_mini.js"></script>
      <script language="JavaScript" src="../../../../script/calendar.js"></script>
      
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
    			<form method=post name= "consultarCurso" action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10">
        				<tr>
         					<td class="FormLiteral">Nombre Curso</td>
        					<td><input type="text" class="FormTxt" maxlength="40"  size="23" name="NOMBRE"></td>
         					<td class="FormLiteral">Número de plazas</td>
        					<td><input type="text" class="FormTxt" maxlength="40" size="23" name="NUMERO_PLAZAS"></td>
        					<td></td>
        				</tr>
        				<tr>
         					<td class="FormLiteral">Estado</td>
        					<td><input type="text" class="FormTxt" maxlength="40" size="23" name="ESTADO"></td>
 			                <td class="FormLiteral">Precio</td>
        					<td><input type="text" class="FormTxt" maxlength="40" size="23" name="PRECIO"></td>
						</tr>
        				<tr>
 							
        					        					<td class="FormLiteral">Horario</td>
        					<td>        					       					
              				<% HttpSession sesion=request.getSession();
              				    ListaObjetoBean listaHorarios =((ListaObjetoBean)sesion.getAttribute("listahorario"));
              
                          if (listaHorarios != null && !listaHorarios.esVacio()) {
                	            Horario horario;	
                	            out.println("<select name='ISHORARIO_IDISHORARIO' class='FormTxt'>");
                	            out.println("<option value=''>Seleccione un horario</option>");                	                            	            
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
                	            out.println("<option value=''>Seleccione un aula &#160;&#160;&#160;&#160;&#160;</option>");                	                            	            
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
        				</tr>
        				<tr>
        					<td class="FormLiteral">Area</td>
        					<td>        					       					
              				<%  
              				    ListaObjetoBean listaAreas =((ListaObjetoBean)sesion.getAttribute("listaarea"));
              
                          if (listaAreas != null && !listaAreas.esVacio()) {
                	            Area area;	
                	            out.println("<select name='ISAREA_IDISAREA' class='FormTxt'>");
                	            out.println("<option value=''>Seleccione un area &#160;&#160;&#160;</option>");                	                            	            
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
                  
                  <td class="FormLiteral">DNI del profesor</td>
        					
        						<td>        					       					
              				<%
              				    
                          ListaObjetoBean listaProfesores =((ListaObjetoBean)sesion.getAttribute("listaprofesor"));
              
                          if (listaProfesores != null && !listaProfesores.esVacio()) {
                	            Profesor profesor;	
                	            out.println("<select name='ISPROFESOR_IDISPROFESOR' class='FormTxt'>");
                	            out.println("<option value=''>Seleccione un DNI &#160;&#160;&#160;&#160;&#160;</option>");                	                            	            
                              for (int i = 0; i < listaProfesores.tamanio(); i++) {
                                  profesor = (Profesor) listaProfesores.dameObjeto(i);
                                  out.println("<option value='"+String.valueOf(profesor.dameValor("IDISPROFESOR"))+"'>"+String.valueOf(profesor.dameValor("ISUSUARIO_DNI"))+"</option>");
      			                  }
                              out.println("</select>");
                          } else 
                                {
                                out.println("<font class='FormLiteral'>No hay ningún profesor.</font>");                                
                                }
                      %>
                  </td>
        		
        		
        				</tr>  
        				<tr>
                 
                  <td class="FormLiteral">Fecha inicio</td>
        					<td><input type="text" class="FormTxt" maxlength="10" size="23" readonly="true" name="FECHA_INICIO">&nbsp;&nbsp;<a href="javascript:ggPosX=345;ggPosY=200;show_calendar('consultarCurso.FECHA_INICIO');" onMouseOver="window.status='Seleccione una fecha';  overlib('Pulsa para elegir fecha del mes en el calendario emergente.'); return true;" onMouseOut="window.status=''; nd(); return true;"><img src="../../../../img/show-calendar.gif" width=24 height=22 border=0></a>
                  </td>
        					<td class="FormLiteral">Fecha finalización</td>
        					<td><input type="text" class="FormTxt" maxlength="10" size="23" readonly="true" name="FECHA_FIN">&nbsp;&nbsp;<a href="javascript:ggPosX=752;ggPosY=200;show_calendar('consultarCurso.FECHA_FIN');" onMouseOver="window.status='Seleccione una fecha';  overlib('Pulsa para elegir fecha del mes en el calendario emergente.'); return true;" onMouseOut="window.status=''; nd(); return true;"><img src="../../../../img/show-calendar.gif" width=24 height=22 border=0></a>    
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
	  <div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:-100px; width:50px"></div>
   </body>
</html>
