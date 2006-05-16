<%@ page import="beans.*" %>
<%@ page import="beans.listaObjetoBeans.*" %>

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Insertar Curso </title>
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Insertar Curso</b></font>                
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

        <%
            HttpSession sesion=request.getSession();
            Curso curso = (Curso) request.getAttribute("beanCurso");
            if (curso == null) {curso = new Curso ();}
        %>
    		
    		<div style="position:relative; top:20px; left:80px; z-index:-1;">
    			<form name="insertarCurso" method=post action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10">
        				<tr>
        					<td class="FormLiteral">Identificador</td>
        					<td><input type="text" class="FormTxt" maxlength="40" name="IDISCURSO" value="autorrellena" disabled="true"></td>
        					<td width="100"></td>
        					<td class="FormLiteral">Area</td>
                  <td>
                  <%
                      ListaObjetoBean listaAreas =((ListaObjetoBean)sesion.getAttribute("listaarea"));
                      Integer posicionLista =((Integer)sesion.getAttribute("posArea"));
                      Area area;
                      
                    	if (listaAreas != null && !listaAreas.esVacio()){
                        	
                      	if (posicionLista != null) {
                      	
                          area = (Area) listaAreas.dameObjeto(posicionLista.intValue());  
                          out.println("<input type='text' class='FormTxt' name='area' disabled='true' value='"+area.dameValor("NOMBRE")+"'>");                        
                        }
                      }
                  %>        					        					
        					
                  </td>        					
        				</tr>
        				<tr>
        					<td class="FormLiteral">Nombre</td>
        					<td><input type="text" class="FormTxt" maxlength="50" name="NOMBRE" disabled="true" value="<%=curso.dameValor("NOMBRE")%>"></td>
        					<td></td>
        					<td class="FormLiteral">Numero Plazas</td>
        					<td><input type="text" class="FormTxt" name="NUMERO_PLAZAS" disabled="true" value="<%=curso.dameValor("NUMERO_PLAZAS")%>"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Estado</td>
        					<td><input type="text" class="FormTxt" maxlength="20" name="ESTADO" disabled="true" value="<%=curso.dameValor("ESTADO")%>"></td>
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
                      Integer posicionListaHorario =((Integer)sesion.getAttribute("posHor"));
                      Horario horario;
                      
                    	if (listaHorarios != null && !listaHorarios.esVacio()){
                        	
                      	if (posicionListaHorario != null) {
                      	
                          horario = (Horario) listaHorarios.dameObjeto(posicionListaHorario.intValue());                          
                          out.println("<input type='text' class='FormTxt' name='horario' disabled='true' value='"+horario.dameValor("L")+"'>");
                        }
                      }
                  %>        					        					
        					
                  </td>
        					<td></td>
        					<td class="error">Aula</td>
        					<td>
                  <%
                        	ListaObjetoBean listaAulas = ((ListaObjetoBean)sesion.getAttribute("listaarea"));
                        	
                    	    if (listaAulas != null && !listaAulas.esVacio()) {
                    	    	Aula aula;	
                    	    	out.println("<select name='IDISAULA' class='FormTxt'>");
                    	    	out.println("<option value='-1'>Seleccione un aula</option>");    
                    	    	for (int i = 0; i < listaAulas.tamanio(); i++) {
                    	    		aula = (Aula) listaAulas.dameObjeto(i);
                    	    		out.println("<option name='posAula' value='"+i+"'>"+String.valueOf(aula.dameValor("NOMBRE"))+"</option>");
                    	    	}
                    	    
                    	    } else {
                    	    	out.println("<font class='FormLiteral'>No hay creada ningún Aula.</font>");
                    	    }  
                  %>         					
        					
        					</td>
        				</tr>
                <tr>
        					<td class="FormLiteral">Profesor</td>
        					<td class="info">
Se rellena posteriormente      					
        				</td>
        				</tr>        				
              	<tr>
					         <td colspan="7" align="center">
					          <input type="hidden" name="idBean" value="Aula">
					          <input type="hidden" name="evento" value="INS_CUR_PROF">
						        <button type="submit" class="botonSimple">Seleccionar</button>
					         </td>
				        </tr>	                       				
        			</table>
          </form>
    		</div>
	  </div>	  	  
    <div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:-100px; width:50px"></div>	 
   </body>  
</html>
