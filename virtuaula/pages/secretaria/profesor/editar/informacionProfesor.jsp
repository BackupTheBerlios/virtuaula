<%@ page import="beans.*" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Informacion Profesor Modificado </title>
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Información Profesor</b></font>                
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
    		  <div align="right" style="position:relative; z-index:-1; top:5px;">
    		    <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    		      <input type="hidden" name="evento">
    	  			<div class="botonesSubMenu">
    	  			  <a href="JavaScript:lanzaFormulario('menuPrincipalSec');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver al menú principal'; overlib('Pulse aquí si desea volver al menú principal'); return true;">Volver al menú principal</a>
                        <a href="JavaScript:lanzaFormulario('GES_PROF');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver a gestión de profesores'; overlib('Pulse aquí si desea volver a gestión de profesores'); return true;">Volver a gestión de profesores</a>
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
    			<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Datos del profesor modificado (paso 4/4)</b></font>                
    		</div>
    		<div style="position:relative; left:20px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E">
    			   A continuación se le muestran los datos del profesor modificado<br>
    			   Pulse "Aceptar" en el botón del fondo de la página
    			</font>
    		</div>
    		<div style="position:relative; top:20px; left:80px; z-index:-1;">
    			<form method=post action="/virtuaula/ServletVisualizador">
              <font face="Trebuchet MS" color="#616D7E" point-size="5">
			  <B>DATOS DEL PROFESOR</B><BR>
              <table  width="90%" border="0" cellspacing="0" cellpadding="10" >
        				<tr bgcolor="#877fff">        					
        					<th class="FormLiteral"><b>DNI</b></th>        					
        					<th class="FormLiteral"><b>Nombre</b></th>
        					<th class="FormLiteral"><b>Primer Apellido</b></th>
        					<th class="FormLiteral"><b>Segundo Apellido</b></th>
        					<th class="FormLiteral"><b>Teléfono</b></th>
        					<th class="FormLiteral"><b>Correo electrónico</b></th>
        					<th class="FormLiteral"><b>Área</b></th>
        				</tr>
        				
        				
        				
        			<%
                    HttpSession sesion=request.getSession();
                    ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("RdoControlador"));
                    Integer posicionLista =((Integer)sesion.getAttribute("posProf"));
                  	ObjetoBean profesor= (ObjetoBean)sesion.getAttribute("beanProfesor");	
                  	Area area = (Area) sesion.getAttribute("beanArea");

                  	if (listaObjetoBean != null && !listaObjetoBean.esVacio() && area != null){
                  	
                    	if (posicionLista != null) {
                    	
                        
                        %> <tr bgcolor="#dbecff">
    	                  <%
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("ISUSUARIO_DNI"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("NOMBRE"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("APELLIDO1"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("APELLIDO2"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("TELEFONO"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("EMAIL"))+"</td>");
                          out.println("<td class='FormLiteral' align='center'>"+String.valueOf(area.dameValor("NOMBRE"))+"</td>");	                    	                   	                    
                          out.println("</tr>");
  	                  
                      }
                    }

                %>
              
              </table>
              <p><p>
              <font face="Trebuchet MS" color="#616D7E" point-size="5"></font>
			  <B>DATOS DEL CURSO</B><BR>
              
        				        					
        					
        					
        					
        					
        						
        					
        					
       <%  ListaObjetoBean listaCursos =((ListaObjetoBean)sesion.getAttribute("listacurso"));
           Curso curso;	
           if (listaCursos != null && !listaCursos.esVacio()){
           

        	//		<%
             //       ListaObjetoBean listaCursos =((ListaObjetoBean)sesion.getAttribute("listacurso"));
             //     	Curso curso;	

           //       	if (listaCursos != null && !listaCursos.esVacio()){
                  	
                  		out.println("<table  width='90%' border='0' cellspacing='0' cellpadding='10' >");
                  		out.println("<tr bgcolor='#877fff'>");
                  		out.println("<th class='FormLiteral'><b>Nombre Curso</th>");
                  		out.println("<th class='FormLiteral'><b>Número de plazas</th>");
                  		out.println("<th class='FormLiteral'><b>Estado</th>");
                  		out.println("<th class='FormLiteral'><b>Fecha Inicio</th>");
                  		out.println("<th class='FormLiteral'><b>Fecha Fin</th>");
                  		out.println("<th class='FormLiteral'><b>Precio</th>");
                  		out.println("<th class='FormLiteral'><b>Área</th>");
                  		out.println("</tr>");
                  	   for (int i=0; i<listaCursos.tamanio();i++) {
                    	
                        curso = (Curso) listaCursos.dameObjeto(i);
    	                  out.println("<tr bgcolor='dbecff'>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("IDISCURSO"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("NOMBRE"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("NUMERO_PLAZAS"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("ESTADO"))+"</td>");    	                  
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("FECHA_INICIO"))+"</td>");
                        out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("FECHA_FIN"))+"</td>");
                        out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("PRECIO"))+"</td>");	                    	                   	                    
    	                  out.println("</tr>");
  	                  
                        }
                    }
                    
        			else{
        				 out.println("<p><p><p><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Este profesor no imparte ningún curso actualmente</b></font><p><p>");
        				}
        			out.println("</table>");           
        	                %>  
        	                <table  width="90%" border="0" cellspacing="0" cellpadding="10" >                           
        	              	<tr>
        						         <td colspan="2" align="center">
        						          <input type="hidden" name="evento" value="menuPrincipalSec">
        							        <button type="submit" class="botonSimple">Aceptar</button>
        						         </td>
        					        </tr>	                       				
        	        			</table>
          </form>
    		</div>
	  </div>
	  <div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:-100px; width:50px"></div>
   </body>
</html>