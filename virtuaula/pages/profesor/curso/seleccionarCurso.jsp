<%@ page import="beans.*" %>
<%@ page import="beans.Error" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Seleccionar Profesor Consultar </title>
      <link href="./../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="./../../../styles/application.css" rel="stylesheet" type="text/css"/>
      <script language="JavaScript" src="./../../../script/overlib_mini.js"></script>
      
      <script language=JavaScript type="text/JavaScript">        	      
          function lanzaFormulario (evento) {
            document.formSubmenu.evento.value = evento;
            document.formSubmenu.submit();
          };   
                    
        function lanzaFormularioPrincipal (evento) {
            document.formPrincipal.evento.value = evento;
            document.formPrincipal.submit();
          };   
      </script>
            
  </head>
   <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
   <body background="./../../../img/fondo.jpg">
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td width="3000" background="./../../../img/cabF.jpg"><img src="./../../../img/cabI.jpg"></td>
            <td><img src="./../../../img/cabD.jpg" width="537px" height="78px" border="0"></td>
         </tr>
      </table>
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td background="./../../../img/barF.gif"><img src="./../../../img/barF.gif" border="0"></td>
         </tr>
         <tr>
            <td background="./../../../img/ContenidoF.gif" height="40px">&nbsp;</td>
         </tr>
      </table>
      <div id="lyComponentes" style="position:absolute; left:0px; top:75px; width:955px; z-index:1; overflow:inherit;">
		  	 <div align="left" style="position:relative; top:15px; left:15px">
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Seleccionar Curso</b></font>                
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
    		  <div align="right" style="position:relative; z-index:-1; top:5px;">
    		    <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    		      <input type="hidden" name="evento">
    	  			<div class="botonesSubMenu">
						<a href="JavaScript:lanzaFormulario('menuPrincipalProf');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver al men� principal'; overlib('Pulse aqu� si desea volver al men� principal'); return true;">Volver al men� principal</a>
      					<a href="JavaScript:lanzaFormulario('desconectar');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Salir'; overlib('Pulse aqu� si desea salir de la aplicaci�n'); return true;"><font color="#660000">Salir</font></a>
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
    		<div style="position:relative; top:20px; left:150px; z-index:-1;">
    			<form method=post action="/virtuaula/ServletVisualizador" name="formPrincipal">
    			
        				<%
	
                    HttpSession sesion=request.getSession();
                    ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("listacurso"));
                  	Curso curso;
		                if (listaObjetoBean != null && !listaObjetoBean.esVacio()){
		                %>
		                <div style="position:relative; left:-100px; top:-50px; z-index:-1;">
    						<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Seleccione un curso y qu� desea hacer con �l (paso 1/3)</b><br>
    						Puede buscar y modificar las fichas de los alumnos o publicar las notas del curso<br>
    		         	    Pulse el bot�n correspondiente a la opci�n deseada   </font>       
    					</div>
    					<div style="position:relative; top:-20px; z-index:-1;">
		                <%
        		            out.println(" <table border='0' cellspacing='0' cellpadding='10'>");		
        		            out.println("<tr>");
                            out.println("	<th class='FormLiteral'><b>Seleccion</th>");			
        		            out.println("	<th class='FormLiteral'><b>Nombre</th>");
        		            out.println("	<th class='FormLiteral'><b>Fecha Inicio</th>");
        		            out.println("	<th class='FormLiteral'><b>Fecha Finalizaci�n</th>");
        		            out.println("</tr>");	
	                        	                       	     
	                   	 for (int i=0; i<listaObjetoBean.tamanio();i++) {
			
                          curso = (Curso) listaObjetoBean.dameObjeto(i);
			                    out.println("<tr>");
			                    out.println("<td>");
			                    if (i==0){
   		         	             out.println("<input type='radio' class='FormTxt' value='"+i+"' name='posCurso' checked>");
			                    }
			                    else{
   		         	               out.println("<input type='radio' class='FormTxt' value='"+i+"' name='posCurso'>");
			                         }
	                   	    out.println("</td>");
	                	      out.println("    <td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("NOMBRE"))+"</td>");
	                  	    out.println("    <td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("FECHA_INICIO"))+"</td>");
                          out.println("    <td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("FECHA_FIN"))+"</td>");
	                        out.println("</tr>");
		                    }//fin for
		      
		                    out.println("<tr>");
		                    out.println("		         <td colspan='2' align='center'> ");
		                    out.println("			          <input type='hidden' name='idBean' value='listCurso'>");
							out.println("			            <input type='hidden' name='evento'>");		                    
		                    out.println("   			        <button onClick=\"JavaScript:lanzaFormularioPrincipal('ListarAlumnosCurso');\" class='botonSimpleGrande'>Mostrar Alumnos</button>");
		                    out.println("</td>");
		                    out.println("<td>");
		                    out.println("   			        <button onClick=\"JavaScript:lanzaFormularioPrincipal('PUB_NOTAS');\" class='botonSimpleGrande'>Publicar Notas</button>");                        		                    		         
		                  %>
		                  </div>
		                  <%
		              }
		              else{	
		              %>
		              <div style="position:relative; left:-50px; top:-20px; z-index:-1;">
    		         	<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>No est� asociado a ning�n curso</b><br>
    		         	 Pulse "Atr�s" para volver a la p�gina anterior</font>               
    		          </div>
		              <%
			                   out.println(" <table border='0' cellspacing='0' cellpadding='10'>");		
			                   out.println("<tr>");			 
		      	             out.println("		         <td colspan='7' align='center'> ");
		      	             out.println("			          <input type='hidden' name='evento' value='menuPrincipalProf'>");
		      	             out.println("   			        <button type='submit' class='botonSimple'>Atr�s</button>");

		
		                  } 
                  out.println("</td>");
                  out.println("</tr>");
                  out.println("</table>");
                %>   
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
                                  error.dameValor("CAUSA_ERROR");
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
