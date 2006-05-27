<%@ page import="beans.*" %>
<%@ page import="beans.Error" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Seleccionar Curso Matricular Alumno </title>
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Matricular Alumno</b></font>                
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
	    	  			<a href="JavaScript:lanzaFormulario('menuPrincipalSec');" onmouseout="window.status=''" onmouseover="window.status='Menu principal';return true ">Menu principal</a>
    			          <a href="JavaScript:lanzaFormulario('GES_ALUM');" onmouseout="window.status=''" onmouseover="window.status='Menu alumno';return true ">Menu alumno</a>
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
            Alumno alumno = (Alumno) sesion.getAttribute("beanAlumno");
            if (alumno == null) {alumno = new Alumno ();}
        %>
    		
    		<div style="position:relative; top:20px; left:40px; z-index:-1;">
    			<form name="insertarAlumno" method=post action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10">
        				<tr>
        					<td class="FormLiteral">DNI</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="9" name="ISUSUARIO_DNI" value="<%=alumno.dameValor("ISUSUARIO_DNI")%>"></td>
        					<td width="100"></td>
        					<td class="FormLiteral">Nombre</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="40" name="NOMBRE" value="<%=alumno.dameValor("NOMBRE")%>"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Primer Apellido</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="40" name="APELLIDO1" value="<%=alumno.dameValor("APELLIDO1")%>"></td>
        					<td></td>
        					<td class="FormLiteral">Segundo Apellido</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="40" name="APELLIDO2" value="<%=alumno.dameValor("APELLIDO2")%>"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Telefono</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="9" name="TELEFONO" value="<%=alumno.dameValor("TELEFONO")%>"></td>
        					<td></td>
        					<td class="FormLiteral">Correo electr�nico</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="50" name="EMAIL" value="<%=alumno.dameValor("EMAIL")%>"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Direcci�n</td>
        					<td><input type="text" class="FormTxt" disabled="true" maxlength="100" name="DIRECCION" value="<%=alumno.dameValor("DIRECCION")%>"></td>
        					<td></td>
        					<td class="FormLiteral">Fecha Nacimiento</td>
        					<td><input type="text" class="FormTxt" maxlength="10" readonly="true" name="FECH_NACIMIENTO" disabled="true" value="<%=alumno.dameValor("FECH_NACIMIENTO")%>"></td>
        				</tr>
        				<tr>        				
        					<td class="FormLiteral">Sexo</td>
                  <td><input type="text" class="FormTxt" disabled="true" maxlength="10" name="SEXO" value="<%=alumno.dameValor("SEXO")%>"></td>
        					<td></td>
        					<td class="FormLiteral">Curso</td>
        					<td>
                  <%
                        	ListaObjetoBean listaCursos = ((ListaObjetoBean)sesion.getAttribute("listacurso"));
                        	
                    	    if (listaCursos != null && !listaCursos.esVacio()) {
                    	    	Curso curso;	
                    	    	out.println("<select name='posCurso' class='FormTxt'>");
                    	    	out.println("<option value='-1'>Seleccione un curso</option>");    
                    	    	for (int i = 0; i < listaCursos.tamanio(); i++) {
                    	    		curso = (Curso) listaCursos.dameObjeto(i);                    	        
                    	    		out.println("<option value='"+i+"'>"+String.valueOf(curso.dameValor("NOMBRE"))+"</option>");
                    	    	}
                    	    
                    	    } else {
                    	    	out.println("<font class='FormLiteral'>No hay creada ning�n Curso.</font>");
                    	    }  
                  %>         					
        					
        					</td>
                                  
        				</tr>
              	<tr>
					         <td colspan="7" align="center">
					          <input type="hidden" name="idBean" value="listCurso">
					          <input type="hidden" name="evento" value="MAT_ALUM_CUR">					         
						        <button type="submit" class="botonSimple">Siguiente</button>
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
                           out.println(""+error.dameValor("CAUSA_ERROR")+"");
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
