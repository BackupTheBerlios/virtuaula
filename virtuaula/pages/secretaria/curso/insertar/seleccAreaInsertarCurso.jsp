<%@ page import="beans.*" %>
<%@ page import="beans.Error" %>
<%@ page import="beans.listaObjetoBeans.*" %>

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Seleccionar Area para un Curso </title>
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Seleccionar area</b></font>                
    	   </div>                   			  	 
         <div align="right" style="position:relative; top:-5px">               
    		  	 <b/>
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

        <%
            HttpSession sesion=request.getSession();
            Curso curso = (Curso) sesion.getAttribute("beanCurso");
            if (curso == null) {curso = new Curso ();}
        %>
    		
			<div style="position:relative; left:10px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Seleccione el area del curso (paso 3/6)</b></font>
    		</div>
    		<div style="position:relative; left:20px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E">
    			   Debe seleccionar un area de la lista<br>
    			   Un área es un campo de conocimiento en el que se engloban varios cursos con características comunes
    			</font>
    		</div>
    		<div style="position:relative; top:40px; left:175; z-index:-1;">
    			<form name="insertarCurso" method=post action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10">
        				<tr>
        					<td class="FormLiteral">Nombre</td>
        					<td><input type="text" class="FormTxt" maxlength="50" name="NOMBRE" disabled="true" value="<%=curso.dameValor("NOMBRE")%>"></td>
        					<td></td>
        					<td class="FormLiteral">Precio</td>
        					<td><input type="text" class="FormTxt" name="PRECIO" disabled="true" value="<%=curso.dameValor("PRECIO")%>"></td>
        				</tr> 
        				<tr>
        					<td class="FormLiteral">Fecha inicio</td>
        					<td><input type="text" class="FormTxt" maxlength="10" readonly="true" name="FECHA_INICIO" disabled="true" value="<%=curso.dameValor("FECHA_INICIO")%>"></td>
        					<td></td>
        					<td class="FormLiteral">Fecha finalización</td>
        					<td><input type="text" class="FormTxt" maxlength="10" readonly="true" name="FECHA_FIN" disabled="true" value="<%=curso.dameValor("FECHA_FIN")%>"></td>
        				</tr>                            
        				<tr>
        					<td class="FormLiteral">Horario</td>
        					<td>
                  <%
                      ListaObjetoBean listaHorarios =((ListaObjetoBean)sesion.getAttribute("listahorario"));
                      Integer posicionLista =((Integer)sesion.getAttribute("posHor"));
                      Horario horario;
                      
                    	if (listaHorarios != null && !listaHorarios.esVacio()){
                        	
                      	if (posicionLista != null) {
                      	
                          horario = (Horario) listaHorarios.dameObjeto(posicionLista.intValue());                          
                          out.println("<input type='text' class='FormTxt' name='horario' disabled='true' value='"+horario.dameValor("L")+"'>");
                        }
                      }
                  %>        					        					
        					
                  </td>
        					<td width="100"></td>
        					<td class="error">Area</td>
        					<td>
                  <%
                        	ListaObjetoBean listaAreas = ((ListaObjetoBean)sesion.getAttribute("listaarea"));
                        	
                    	    if (listaAreas != null && !listaAreas.esVacio()) {
                    	    	Area area;	
                    	    	out.println("<select name='posArea' class='FormTxt'>");
                    	    	out.println("<option value='-1'>Seleccione un area</option>");    
                    	    	for (int i = 0; i < listaAreas.tamanio(); i++) {
                    	    		area = (Area) listaAreas.dameObjeto(i);
                    	                            	    		
                    	    		out.println("<option value='"+i+"'>"+String.valueOf(area.dameValor("NOMBRE"))+"</option>");
                    	    	}
                    	    
                    	    } else {
                    	    	out.println("<font class='FormLiteral'>No hay creada ningún Área.</font>");
                    	    }  
                  %>         					
        					
        					</td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Aula</td>
        					<td class="info">
Se rellena posteriormente
        				  </td>
        					<td></td>
        					<td class="FormLiteral">Profesor</td>
        					<td class="info">
Se rellena posteriormente      					
        				</td>

        				</tr>        				
              	<tr>
					         <td colspan="7" align="center">
					          <input type="hidden" name="idBean" value="listArea">
					          <input type="hidden" name="evento" value="INS_CUR_AULA">
						        <button type="submit" class="botonSimple">Siguiente</button>
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
