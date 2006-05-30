<%@ page import="beans.*" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<script language=JavaScript type="text/JavaScript">
var i = 0;
</script>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Rellenar datos de Curso a buscar</title>
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Rellenar datos de curso</b></font>                
    	   </div> 
         <div align="right" style="position:relative; top:-5px"> 
         <b>              
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
              </b>
          </div>
    		  <div align="right" style="position:relative; z-index:-1;">
    		    <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    		      <input type="hidden" name="evento">
    	  			<div class="botonesSubMenu">
    	  			  <a href="JavaScript:lanzaFormulario('menuPrincipalSec');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver al menú principal'; overlib('Pulse aquí si desea volver al menú principal'); return true;">Volver al menú principal</a>
                        <a href="JavaScript:lanzaFormulario('GES_CUR');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver a gestión de cursos'; overlib('Pulse aquí si desea volver a gestión de cursos'); return true;">Volver a gestión de cursos</a>
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
    			<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Rellene los campos conocidos del curso (paso 1/3)</b></font>        
    		</div>
    		<div style="position:relative; left:20px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E">
    			   Debe rellenar los datos que conozca del curso que desea encontrar<br>
    			   En caso de no conocer ningún dato, pulse "Buscar" y se mostrarán todos los cursos impartidos en la academia
    			</font>
    		</div>
    		<div style="position:relative; top:20px; left:150px; z-index:-1;">
    			<form method=post name= "consultarCurso" action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10">
        				<tr>
         					<td class="FormLiteral">Nombre Curso</td>
        					<td><input type="text" class="FormTxt" maxlength="40"  size="31" name="NOMBRE"></td>
         					<td class="FormLiteral">Número de plazas</td>
        					<td><input type="text" class="FormTxt" maxlength="40" size="31" name="NUMERO_PLAZAS"></td>
        					<td></td>
        				</tr>
        				<tr>
         					<td class="FormLiteral">Estado</td>
        					<td><input type="text" class="FormTxt" maxlength="40" size="31" name="ESTADO"></td>
 			                <td class="FormLiteral">Precio</td>
        					<td><input type="text" class="FormTxt" maxlength="40" size="31" name="PRECIO"></td>
						</tr>
        				<tr>
 							
        					        					<td class="FormLiteral">Horario</td>
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
                	            out.println("<select name='posAula' class='FormTxt'>");
                	            out.println("<option value=''>Seleccione un aula &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;</option>");                	                            	            
                              for (int i = 0; i < listaAulas.tamanio(); i++) {
                                  aula = (Aula) listaAulas.dameObjeto(i);
                                  out.println("<option value='"+String.valueOf(i)+"'>"+String.valueOf(aula.dameValor("NOMBRE"))+"</option>");
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
                                  out.println("<option value='"+String.valueOf(area.dameValor("IDISAREA"))+"'>"
                                  +String.valueOf(area.dameValor("NOMBRE"))+"</option>");
      			                  }
                              out.println("</select>");
                          } else 
                                {
                                out.println("<font class='FormLiteral'>No hay creada ningún área.</font>");                                
                                }
                      %>
                  </td>
                  
                  <td class="FormLiteral">Nombre profesor</td>
        					
        						<td>        					       					
              				<%
              				    
                          ListaObjetoBean listaProfesores =((ListaObjetoBean)sesion.getAttribute("listaprofesor"));
              
                          if (listaProfesores != null && !listaProfesores.esVacio()) {
                	            Profesor profesor;	
                	            out.println("<select name='ISPROFESOR_ISUSUARIO_DNI' class='FormTxt'>");
                	            out.println("<option value=''>Seleccione un profesor &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;</option>");                	                            	            
                              for (int i = 0; i < listaProfesores.tamanio(); i++) {
                                  profesor = (Profesor) listaProfesores.dameObjeto(i);
                                  out.println("<option value='"+String.valueOf(profesor.dameValor("ISUSUARIO_DNI"))+"'>"+String.valueOf(profesor.dameValor("NOMBRE"))+ " " +String.valueOf(profesor.dameValor("APELLIDO1"))+"</option>");
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
        					<td><input type="text" class="FormTxt" maxlength="10" size="25" readonly="true" name="FECHA_INICIO">&nbsp;&nbsp;<a href="javascript:ggPosX=345;ggPosY=200;show_calendar('consultarCurso.FECHA_INICIO');" onMouseOver="window.status='Seleccione una fecha';  overlib('Pulsa para elegir fecha del mes en el calendario emergente.'); return true;" onMouseOut="window.status=''; nd(); return true;"><img src="../../../../img/show-calendar.gif" width=24 height=22 border=0></a>
                  </td>
        					<td class="FormLiteral">Fecha finalización</td>
        					<td><input type="text" class="FormTxt" maxlength="10" size="25" readonly="true" name="FECHA_FIN">&nbsp;&nbsp;<a href="javascript:ggPosX=752;ggPosY=200;show_calendar('consultarCurso.FECHA_FIN');" onMouseOver="window.status='Seleccione una fecha';  overlib('Pulsa para elegir fecha del mes en el calendario emergente.'); return true;" onMouseOut="window.status=''; nd(); return true;"><img src="../../../../img/show-calendar.gif" width=24 height=22 border=0></a>    
                  </td>
                     				 
              	<tr>
					         <td colspan="7" align="center">
						        <input type="hidden" name="evento" value="CONS_CUR">
						        <input type="hidden" name="idBean" value="consultaCurso">
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
