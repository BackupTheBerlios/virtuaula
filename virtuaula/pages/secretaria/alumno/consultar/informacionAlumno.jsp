<%@ page import="beans.*" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Consultar Informacion Alumno  </title>
      <link href="../../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="../../../../styles/application.css" rel="stylesheet" type="text/css"/>
      <script type="text/javascript" language="JavaScript" src="../../../../script/overlib_mini.js"></script>
      
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Información Alumno</b></font>                
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
    	  			  <a href="JavaScript:lanzaFormulario('menuPrincipalSec');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver al menú principal'; overlib('Pulse aquí si desea volver al menú principal'); return true;">Volver al menú principal</a>
                        <a href="JavaScript:lanzaFormulario('GES_ALUM');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver a gestión de alumnos'; overlib('Pulse aquí si desea volver a gestión de alumnos'); return true;">Volver a gestión de alumnos</a>
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
    			<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Datos del alumno seleccionado (paso 3/3)</b></font>                
    		</div>
    		<div style="position:relative; left:20px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E">
    			   A continuación se le muestran los datos del alumno seleccionado<br>
    			   Pulse "Aceptar" en el botón del fondo de la página
    			</font>
    		</div>
    		<div style="position:relative; top:20px; left:80px; z-index:-1;">
    			<form method=post action="/virtuaula/ServletVisualizador">
    		<font face="Trebuchet MS" color="#616D7E" point-size="5">
			  <B>DATOS DEL ALUMNO</B><BR></font>
              <table  width="90%" border="0" cellspacing="0" cellpadding="10" >
       				
        				
        			<%
        						
                    HttpSession sesion=request.getSession();
                  
out.println("          <table border='0' cellspacing='0' cellpadding='10'>");
out.println("             <tr bgcolor='#877fff'>");
out.println("               <td><h4>Identificador</h4></td>");
out.println("               <td><h4>Nombre</h4></td>");
out.println("               <td><h4>Apellido1</h4></td>");
out.println("               <td><h4>Apellido2</h4></td>");
out.println("               <td><h4>Telefono</h4></td>");
out.println("               <td><h4>Correo elcectronico</h4></td>");
out.println("               <td><h4>Direccion</h4></td>");
out.print("              </tr>   ");
                    
                  	   ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("listaalumno"));
                    	 Integer posicionLista =((Integer)sesion.getAttribute("posAlumno"));	
                    	 if (listaObjetoBean != null && !listaObjetoBean.esVacio()){
                  	
                    			if (posicionLista != null) {
                    	
                        	Alumno alumno = (Alumno) listaObjetoBean.dameObjeto(posicionLista.intValue());
                        	  %> <tr bgcolor="#dbecff">
    	                  <%
                  	  	
                  	  	
    	                  
    	                  out.print("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("ISUSUARIO_DNI"))+"</td>");
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
              <font face="Trebuchet MS" color="#616D7E" point-size="5">
			  <B>NOTAS DEL ALUMNO</B><BR></font>
       <%  //ListaObjetoBean listaCursos =((ListaObjetoBean)sesion.getAttribute("listacurso"));
           //Curso curso;	
           ListaObjetoBean listaexp =((ListaObjetoBean)sesion.getAttribute("listaexp"));
           ObjetoBean expediente;	
           if (listaexp != null && !listaexp.esVacio()){
           
out.println("          <table border='0' cellspacing='0' cellpadding='10'>");
out.println("             <tr bgcolor='#877fff'>");
out.println("               <td><h4>Nombre</h4></td>");
out.println("               <td><h4>N&uacute;mero de plazas</h4></td>");
out.println("               <td><h4>Estado</h4></td>");
out.println("               <td><h4>Fecha Inicio</h4></td>");
out.println("               <td><h4>Fecha Finalizaci&oacute;n</h4></td>");
out.println("               <td><h4>Precio</h4></td>");
out.println("               <td><h4>Nota actual</h4></td>");
out.println("              </tr>   ");
        	//		<%
             //       ListaObjetoBean listaCursos =((ListaObjetoBean)sesion.getAttribute("listacurso"));
             //     	Curso curso;	

           //       	if (listaCursos != null && !listaCursos.esVacio()){
                  	
                  	   for (int i=0; i<listaexp.tamanio();i++) {
                    	
                        expediente = (ObjetoBean) listaexp.dameObjeto(i);
    	                  out.println("<tr bgcolor='#dbecff'>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("NOMBRE"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("NUMERO_PLAZAS"))+"</td>");
    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("ESTADO"))+"</td>");    	                  
    	                  	
			String fechaInicio= expediente.dameValor("FECHA_INICIO");
			String fechaFin=expediente.dameValor("FECHA_FIN");
			if(fechaInicio!=null){
				out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("FECHA_INICIO"))+"</td>");
	     }
	     else{
    	                  out.println("<td class='FormLiteral' align='center'>Sin especificar</td>");
    	                  }	
      if(fechaFin!=null){
			out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("FECHA_FIN"))+"</td>");
			}
		
			else{
    	                  out.println("<td class='FormLiteral' align='center'>Sin especificar</td>");
    	}
			
                        

		out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("PRECIO"))+"</td>");	                    	                   	                    
		if(expediente.dameValor("ESTADO").equals("activo") && expediente.dameValor("NOTAFINAL")==null)
	 out.println("<td class='FormLiteral' align='center'>"+String.valueOf("Sin evaluar")+"</td>");    	                    
	 else if(expediente.dameValor("NOTAFINAL")==null){
	 	out.println("<td class='FormLiteral' align='center'>"+String.valueOf("No presentado")+"</td>");    	                    
	 }
	 
		else {out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("NOTAFINAL"))+"</td>");    	                    
   }
    	                  out.println("</tr>");
  	               
                        }
                    
                    }
                    
			else{
			 out.println("<p><p>Este alumno no cursa ningún curso actualmente<p><p><p>");
			}
			out.println("</tr>");
			out.println("<td colspan='7' align='center'>");
			out.println("<input type='hidden' name='evento' value='menuPrincipalSec'>");
			out.println("<button type='submit' class='botonSimple'>Aceptar</button>");
			out.println(" </td>");						
			out.println("</tr>");
			out.println("</table>");
                %>                               
			        	                       				
        			
          </form>
    		</div>
	  </div>
    <div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:-100px; width:50px"></div>	 	  
   </body>
</html>