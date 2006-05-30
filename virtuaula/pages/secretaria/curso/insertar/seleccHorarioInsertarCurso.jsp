<%@ page import="beans.*" %>
<%@ page import="beans.Error" %>
<%@ page import="beans.listaObjetoBeans.*" %>

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Seleccionar Horario para un Curso </title>
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
            <td width="3000" background="../../../../img/cabF.jpg">
            <img src="../../../../img/cabI.jpg" width="392" height="78"></td>
            <td>
            <img src="../../../../img/cabD.jpg" width="537" height="78" border="0"></td>
         </tr>
      </table>
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td background="../../../../img/barF.gif">
            <img src="../../../../img/barF.gif" border="0" width="1" height="40"></td>
         </tr>
         <tr>
            <td background="../../../../img/ContenidoF.gif" height="40px">&nbsp;</td>
         </tr>
      </table>
      <div id="lyComponentes" style="position:absolute; left:0px; top:75px; width:955px; z-index:1; overflow:inherit;">
		  	 <div align="left" style="position:relative; top:15px; left:15px">
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Seleccionar horario</b></font>                
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
    			<font face="Trebuchet MS" color="#616D7E"><b>Seleccione el horario del curso (paso 2/6)</b></font>
    		</div>
    		<div style="position:relative; left:20px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E">
    			   Debe seleccionar un horario de la lista<br>
    			   Estos horarios son libres, es decir, son horarios predefinidos que pueden asociarse a un curso
    			</font>
    		</div>
    		<div style="position:relative; top:40px; left:175; z-index:-1;">
    			<form name="insertarCurso" method=post action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10" width="635">
        				<tr>
        					<td class="FormLiteral" width="62">Nombre</td>
        					<td width="141">
                            <input type="text" class="FormTxt" maxlength="50" name="NOMBRE" disabled="true" value="<%=curso.dameValor("NOMBRE")%>" size="20"></td>
        					<td width="127"></td>
        					<td class="FormLiteral" width="95">Precio</td>
        					<td width="113">
                            <input type="text" class="FormTxt" name="PRECIO" disabled="true" value="<%=curso.dameValor("PRECIO")%>" size="20"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral" width="62">Fecha inicio</td>
        					<td width="141">
                            <input type="text" class="FormTxt" maxlength="10" readonly="true" name="FECHA_INICIO" disabled="true" value="<%=curso.dameValor("FECHA_INICIO")%>" size="20"></td>
        					<td width="127"></td>
        					<td class="FormLiteral" width="95">Fecha finalización</td>
        					<td width="113">
                            <input type="text" class="FormTxt" maxlength="10" readonly="true" name="FECHA_FIN" disabled="true" value="<%=curso.dameValor("FECHA_FIN")%>" size="20"></td>
        				</tr>
        				<tr>
        					<td class="error">Horario</td>
        					<td>      					       					
              				<%  sesion=request.getSession();
              				    ListaObjetoBean listaHorarios =((ListaObjetoBean)sesion.getAttribute("listahorario"));
              
                          if (listaHorarios != null && !listaHorarios.esVacio()) {
                	            Horario horario;	
                	            out.println("<select name='posHor' class='FormTxt'>");
                	            out.println("<option value='-1'>Seleccione un horario</option>");                	                            	            
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
        					<td width="127"></td>
        					<td class="FormLiteral" width="95">Area</td>
        					<td class="info" width="113">
Se rellena posteriormente
        				</td>
        				</tr>
        				<tr>
        					<td class="FormLiteral" width="62">Aula</td>
        					<td class="info" width="141">
Se rellena posteriormente
        				  </td>
        					<td width="127"></td>
        					<td class="FormLiteral" width="95">Profesor</td>
        					<td class="info" width="113">
Se rellena posteriormente      					
        				</td>

        				</tr>         				
              	<tr>
					         <td colspan="7" align="center" width="516">
					          <input type="hidden" name="idBean" value="listHor">
					          <input type="hidden" name="evento" value="INS_CUR_AREA">
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