<%@ page import="beans.*" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Informacion Profesor Consultar </title>
      <link href="../../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="../../../../styles/application.css" rel="stylesheet" type="text/css"/>
      
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
    		  <div align="right" style="position:relative; top:25px; z-index:-1;">
    		    <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    		      <input type="hidden" name="evento">
    	  			<div class="botonesSubMenu">
    	  			  <a href="JavaScript:lanzaFormulario('menuPrincipalSec');" onmouseout="window.status=''" onmouseover="window.status='Volver al menu principal';return true ">Volver al menu principal</a>
                <a href="JavaScript:lanzaFormulario('GES_ALUM');" onmouseout="window.status=''" onmouseover="window.status='Volver al menu de profesor';return true ">Volver al menu de alumno</a>
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
    			<form method=post action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10">
        				<tr>        					
        					<th class="FormLiteral"><b>DNI</th>        					
        					<th class="FormLiteral"><b>Nombre</th>
        					<th class="FormLiteral"><b>Primer Apellido</th>
        					<th class="FormLiteral"><b>Segundo Apellido</th>
        					<th class="FormLiteral"><b>Teléfono</th>
        					<th class="FormLiteral"><b>Correo electrónico</th>
        					<th class="FormLiteral"><b>Dirección</th>
        				</tr>
        				
        				
        			<%
                    HttpSession sesion=request.getSession();
                    
                    
                  	   ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("listaalumno"));
                    	 Integer posicionLista =((Integer)sesion.getAttribute("posAlumno"));	
                    	 if (listaObjetoBean != null && !listaObjetoBean.esVacio()){
                  	
                    			if (posicionLista != null) {
                    	
                        	Alumno alumno = (Alumno) listaObjetoBean.dameObjeto(posicionLista.intValue());
                        	  %> <tr bgcolor="#dbecff">
    	                  <%
                  	  	out.println("<tr>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("ISUSUARIO_DNI"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("NOMBRE"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("APELLIDO1"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("APELLIDO2"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("TELEFONO"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("EMAIL"))+"</td>");
                          out.println("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("DIRECCION"))+"</td>");
    	                  out.println("</tr>");
  	                  }
  	                 	}
                    

                %>
              
              </table>
              <p><p>
              
       <%  ListaObjetoBean listaCursos =((ListaObjetoBean)sesion.getAttribute("listacurso"));
           Curso curso;	
           if (listaCursos != null && !listaCursos.esVacio()){
           
out.println("          <table border='0' cellspacing='0' cellpadding='10'>");
out.println("            <tr bgcolor='#3366CC'>");
out.println("               <td colspan='7' align='center'><h3><font color='#FFFFFF'>Cursos en los cuales está matriculado el alumno</font></h3></td>");
out.println("             </tr>");
out.println("             <tr bgcolor='#3399FF'>");
out.println("               <td><h4>Identificador</h4></td>");
out.println("               <td><h4>Nombre</h4></td>");
out.println("               <td><h4>N&uacute;mero de plazas</h4></td>");
out.println("               <td><h4>Estado</h4></td>");
out.println("               <td><h4>Fecha Inicio</h4></td>");
out.println("               <td><h4>Fecha Finalizaci&oacute;n</h4></td>");
out.println("               <td><h4>Precio</h4></td>");
out.println("              </tr>   ");
        	//		<%
             //       ListaObjetoBean listaCursos =((ListaObjetoBean)sesion.getAttribute("listacurso"));
             //     	Curso curso;	

           //       	if (listaCursos != null && !listaCursos.esVacio()){
                  	
                  	   for (int i=0; i<listaCursos.tamanio();i++) {
                    	
                        curso = (Curso) listaCursos.dameObjeto(i);
    	                  out.println("<tr bgcolor='#99CCFF'>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("IDISCURSO"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("NOMBRE"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("NUMERO_PLAZAS"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("ESTADO"))+"</td>");    	                  
    	                  	
			String fechaInicio= curso.dameValor("FECHA_INICIO");
			String fechaFin=curso.dameValor("FECHA_FIN");
			if(fechaInicio!=null){
				out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("FECHA_INICIO"))+"</td>");
	     }
	     else{
    	                  out.println("<td class='FormLiteral' align='center'>Sin especificar</td>");
    	                  }	
      if(fechaFin!=null){
			out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("FECHA_FIN"))+"</td>");
			}
		
			else{
    	                  out.println("<td class='FormLiteral' align='center'>Sin especificar</td>");
    	}
			
                        

		out.println("<td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("PRECIO"))+"</td>");	                    	                   	                    
    	                  out.println("</tr>");
  	                  
                        }
                    }
                    
			else{
			 out.println("<p><p>Este alumno no cursa ningún curso actualmente<p><p><p>");
			}
                %>                               
              	<tr>
					         <td colspan="7" align="center">
					          <input type="hidden" name="evento" value="menuPrincipalSec">
						        <button type="submit" class="botonSimple">Aceptar</button>
					         </td>
				        </tr>	                       				
        			</table>
          </form>
    		</div>
	  </div>
   </body>
</html>