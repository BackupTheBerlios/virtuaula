<%@ page import="beans.*" %>
<%@ page import="beans.Error" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Seleccionar Aviso Profesor </title>
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Seleccionar Aviso</b></font>                
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
						<a href="JavaScript:lanzaFormulario('menuPrincipalProf');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver al menú principal'; overlib('Pulse aquí si desea volver al menú principal'); return true;">Volver al menú principal</a>
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
    		<div style="position:relative; top:20px; left:80px; z-index:-1;">
    			<form method=post action="/virtuaula/ServletVisualizador" name="formPrincipal">
        				
        				<%
	
                    HttpSession sesion=request.getSession();
                    ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("listaaviso"));
                  	Avisos aviso;
		                if (listaObjetoBean != null && !listaObjetoBean.esVacio()){
		                %>
		                <div style="position:relative; left:-30px; top:-40px; z-index:-1;">
    		         	<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Seleccione un aviso y qué desea hacer con él (paso 1/2)</b><br>
    		         	 Puede leer un aviso, borrarlo o enviar un aviso a algún usuario<br>
    		         	 Pulse el botón correspondiente a la opción deseada   </font>            
    		          </div>
		                <%
        		            out.println(" <table border='0' cellspacing='0' cellpadding='10'>");		
        		            out.println("<tr>");
                        out.println("	<th class='FormLiteral'><b>Seleccion</th>");			
        		            out.println("	<th class='FormLiteral'><b>Identificador</th>");
        		            out.println("	<th class='FormLiteral'><b>Asunto</th>");
        		            out.println("	<th class='FormLiteral'><b>Fecha Aviso</th>");
        		            out.println("</tr>");	
	                        	                       	     
	                   	 for (int i=0; i<listaObjetoBean.tamanio();i++) {
			
                          aviso = (Avisos) listaObjetoBean.dameObjeto(i);
			                    out.println("<tr>");
			                    out.println("<td>");
			                    if (i==0){
   		         	             out.println("<input type='radio' class='FormTxt' value='"+i+"' name='posAviso' checked>");
			                    }
			                    else{
   		         	               out.println("<input type='radio' class='FormTxt' value='"+i+"' name='posAviso'>");
			                         }
			                    if (aviso.dameValor("ACTIVO").equals ("S")) {      			                    
	                   	    		out.println("</td>");
	                	      		out.println("    <td class='FormLiteral' align='center'><font face='Trebuchet MS' color='#2B3856' size='2'>"+String.valueOf(aviso.dameValor("IDISAVISOS"))+"<font></td>");
	                	      		out.println("    <td class='FormLiteral' align='center'><font face='Trebuchet MS' color='#2B3856' size='2'>"+String.valueOf(aviso.dameValor("ASUNTO"))+"<font></td>");
	                  	    		out.println("    <td class='FormLiteral' align='center'><font face='Trebuchet MS' color='#2B3856' size='2'>"+String.valueOf(aviso.dameValor("FECHA_AVISO"))+"<font></td>");
	                  	    	} else {
       	    	                   	  	out.println("</td>");
	                	                out.println("    <td class='FormLiteral' align='center'><font face='Trebuchet MS' color='#C0C0C0' size='2'>"+String.valueOf(aviso.dameValor("IDISAVISOS"))+"<font></td>");
          	                	      	out.println("    <td class='FormLiteral' align='center'><font face='Trebuchet MS' color='#C0C0C0' size='2'>"+String.valueOf(aviso.dameValor("ASUNTO"))+"<font></td>");
          	                  	    	out.println("    <td class='FormLiteral' align='center'><font face='Trebuchet MS' color='#C0C0C0' size='2'>"+String.valueOf(aviso.dameValor("FECHA_AVISO"))+"<font></td>");
                                } 

		                    }//fin for
		      
		                    out.println("<tr>");
		                    out.println("		         <td colspan='2' align='center'> ");
		                    out.println("			            <input type='hidden' name='evento'>");
		                    out.println("			            <input type='hidden' name='idBean' value='listAviso'>");
		                    out.println("   			        <button onClick=\"JavaScript:lanzaFormularioPrincipal('MOSTRAR_AVISOS_PROF');\" class='botonSimple'>Leer</button>");
		                    out.println("</td>");
		                    out.println("<td>");
		                    out.println("   			        <button onClick=\"JavaScript:lanzaFormularioPrincipal('BORRA_AVISO');\" class='botonSimple'>Borrar</button>");
		                    out.println("</td>");
		                    out.println("<td>");
		                    out.println("   			        <button onClick=\"JavaScript:lanzaFormularioPrincipal('INI_AVI_PROF');\" class='botonSimple'>Enviar</button>");
		         
		                  
		              }
		              else{	
		              %>
		              <div style="position:relative; left:-30px; top:-40px; z-index:-1;">
    		         	<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>No tiene ningún aviso</b><br>
    		         	 Pulse "Atrás" para volver a la página anterior</font>               
    		          </div>
		              <%
		              out.println("<font class='error'>No tiene ningún aviso</font>");
			                   out.println(" <table border='0' cellspacing='0' cellpadding='10'>");		
			                   out.println("<tr>");			 
		      	             out.println("		         <td colspan='7' align='center'> ");
		      	             out.println("			          <input type='hidden' name='evento' value='menuPrincipalProf'>");
		      	             out.println("   			        <button type='submit' class='botonSimple'>Atrás</button>");
		      	           out.println("<td>");
		      	           out.println("   			        <button onClick=\"JavaScript:lanzaFormularioPrincipal('INI_AVI_PROF');\" class='botonSimple'>Enviar</button>");
		
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
