<%@ page import="beans.*" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Seleccionar Curso</title>
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
    		  <div align="right" style="position:relative; z-index:1; top:5px">
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
    		<div style="position:relative;  left:175px; z-index:-1;">
    			<form method=post action="/virtuaula/ServletVisualizador">
        				
        				<%
                    		HttpSession sesion=request.getSession();
                    
                    ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("listacurso"));
                  	Curso curso;
		                if (listaObjetoBean != null && !listaObjetoBean.esVacio()){
		                %>
		                <div style="position:relative; left:-155px; top:-15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Seleccione el curso que desea buscar (paso 2/3)</b></font>                
    		</div>
    		<div style="position:relative; left:-120px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E">
    			   Estos son los cursos encontrados con los datos que introdujo<br>
    			   Seleccione el curso deseado y pulse "Seleccionar" en el botón del fondo de la página
    			</font>
    		</div>
		                <%
		                
        		            out.println(" <table border='0' cellspacing='0' cellpadding='10'>");		
        		            out.println("<tr>");
                        out.println("	<th class='FormLiteral'><b>Seleccion</th>");
        		             					
        		            out.println("	<th class='FormLiteral'><b>Nombre Curso</th>");
        		            out.println("	<th class='FormLiteral'><b>Número de plazas</th>");
        		            out.println("	<th class='FormLiteral'><b>Estado</th>");
        		            out.println("	<th class='FormLiteral'><b>Precio</th>"); 
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
	                  	    out.println("    <td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("NUMERO_PLAZAS"))+"</td>");
                          out.println("    <td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("ESTADO"))+"</td>");
                          out.println("    <td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("PRECIO"))+"</td>");
                       
	                        out.println("</tr>");
		                    }//fin for
		      
		                    out.println("<tr>");
		                    out.println("		         <td colspan='7' align='center'> ");
		                    out.println("			          <input type='hidden' name='evento' value='MOSTRAR_CUR'>");
		                    out.println("			          <input type='hidden' name='idBean' value='listCurso'>");
		                    out.println("   			        <button type='submit' class='botonSimple'>Seleccionar</button>");
		         
		                  
		              }
		              else{	
		              %>
		              <div style="position:relative; left:-155px; top:-15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>No se ha encontrado ningún curso con los criterios que introdujo</b></font>        
    		</div>
    		<div style="position:relative; left:-120px; top:-15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E">
    			   Pulse "Atrás" para volver a introducir un criterio de búsqueda
    			</font>
    		</div>
		              <%
			                   out.println(" <table border='0' cellspacing='0' cellpadding='10'>");		
			                   out.println("<tr>");			 
		      	             out.println("		         <td colspan='7' align='center'> ");
		      	             out.println("			          <input type='hidden' name='evento' value='INI_CONS_CUR'>");
		      	             out.println("   			        <button type='submit' class='botonSimple'>Atrás</button>");

		                  } 
				          out.println("</td>");		                
				          out.println("</tr>");		    
				          out.println("</table>");	
                %>   
          </form>
    		</div>
	  </div>
 	  <div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:-100px; width:50px"></div>
   </body>
</html>
