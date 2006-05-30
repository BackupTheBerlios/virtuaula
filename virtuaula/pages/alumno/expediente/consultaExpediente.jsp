<%@ page import="beans.*" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Expediente </title>
      <link href="./../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="./../../../styles/application.css" rel="stylesheet" type="text/css"/>
      <script language="JavaScript" src="./../../../script/overlib_mini.js"></script>
      
      <script language=JavaScript type="text/JavaScript">        
          function lanzaFormulario (evento) {
            document.formSubmenu.evento.value = evento;
            document.formSubmenu.submit();
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Expediente</b></font>                
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
    	  			  <a href="JavaScript:lanzaFormulario('menuPrincipalAlum');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver al menú principal'; overlib('Pulse aquí si desea volver al menú principal'); return true;">Volver al menú principal</a>
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
    		<div style="position:relative; left:10px; top:-15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Expediente del alumno</b></font>                
    		</div>
    		<div style="position:relative; left:20px; top:-15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E">
    			   A continuación se le muestran los datos de sus cursos, tanto los cursos actuales como los pasados <br>
    			   Pulse "Aceptar" en el botón del fondo de la página
    			</font>
    		</div>
    		<div style="position:relative; top:-20px; left:80px; z-index:-1;">
    			<form method=post action="/virtuaula/ServletVisualizador">
              	<font face="Trebuchet MS" color="#616D7E" point-size="5">
              	

			  <B>Datos del Alumno</B><BR>
				<p>					       					
        					
        			<%
	                    HttpSession sesion=request.getSession();
	                    ObjetoBean alumno = ((ObjetoBean)sesion.getAttribute("beanAlumno"));;	
						
						if (alumno != null) {
		                	out.println("<table  width='90%' border='0' cellspacing='0' cellpadding='10'>");
		                	out.println("<tr bgcolor='#877fff'>");
		                  	out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>DNI</b></font></th>");
		                  	out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Nombre</b></font></th>");
		                  	out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Primer Apellido</b></font></th>");
		                  	out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Segundo Apellido</b></font></th>");
		                  	out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Teléfono</b></font></th>");
		                  	out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Email</b></font></th>");
		                  	out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Dirección</b></font></th>");
		                  	out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Fecha Nacimiento</b></font></th>");
		                  	out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Sexo</b></font></th>");		                  	
		                  	out.println("</tr>"); 
	    	                out.println("<tr bgcolor='#dbecff'>");	
			    	        out.println("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("ISUSUARIO_DNI"))+"</td>");
			    	        out.println("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("NOMBRE"))+"</td>");
			    	        out.println("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("APELLIDO1"))+"</td>");
			    	        out.println("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("APELLIDO2"))+"</td>");
			    	        out.println("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("TELEFONO"))+"</td>");
			    	        out.println("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("EMAIL"))+"</td>");
			    	        out.println("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("DIRECCION"))+"</td>");
			    	        out.println("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("FECH_NACIMIENTO"))+"</td>");
			    	        out.println("<td class='FormLiteral' align='center'>"+String.valueOf(alumno.dameValor("SEXO"))+"</td>");			    	        			    	        
			    	        out.println("</tr>");
			    	        out.println("</table>");		                  	
		                  	
						}

                %>  

              	
                <p></p> 
                <B>Cursos Activos</B><BR>
				<p></p> 
              				       					        					
        			<%
	                    ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("listaexpedientealumno"));
	                    ObjetoBean expediente;	
	                    boolean hayCursosActivos = false;
	                    int cabeceraCursosActivos = 0;
	                    
	                    if (listaObjetoBean != null && !listaObjetoBean.esVacio()){
	                    	for(int i=0;i<listaObjetoBean.tamanio();i++){
	                  			expediente = (ObjetoBean) listaObjetoBean.dameObjeto(i);
	                  			if (expediente.dameValor("ESTADO").equals("activo"))
	                  			{
	                  						                  					
	                  					if (cabeceraCursosActivos == 0) {
		                  					out.println("<table  width='90%' border='0' cellspacing='0' cellpadding='10'>");
		                  					out.println("<tr bgcolor='#877fff'>");
		                  					out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Curso</b></font></th>");
		                  					out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Fecha Inicio</b></font></th>");
		                  					out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Fecha Fin</b></font></th>");
		                  					out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Nota</b></font></th>");
		                  					out.println("</tr>");   
											cabeceraCursosActivos ++;              				
		                  					
										}	                  				
	                  				    
	                  				    hayCursosActivos = true;
	                  				     					
	    	                  			
	    	                  			String Nota=String.valueOf(expediente.dameValor("NOTAFINAL"));
	    	                  			if ((String.valueOf(expediente.dameValor("NOTAFINAL")).equals("null")) || (String.valueOf(expediente.dameValor("NOTAFINAL")).equals("-1")))
	    	                  			{
	    	                	  			Nota = "No presentado";
	    	                  			}
	    	                  			if (String.valueOf(expediente.dameValor("NOTAFINAL")).equals("-2"))
	    	                  			{
	    	                	  			Nota = "Curso Cancelado";
	    	                  			}
	    	                  		  out.println("<tr bgcolor='#dbecff'>");	
			    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("NOMBRE"))+"</td>");
			    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("FECHA_INICIO"))+"</td>");
			    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("FECHA_FIN"))+"</td>");
			    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(Nota)+"</td>");
			    	                  out.println("</tr>");
			    	                  			    	                   			    	                  
	                      			}
	                      		}
	                      		if (cabeceraCursosActivos != 0) {out.println("</table>");}
                    	}
                    	
                    	if (!hayCursosActivos) {out.println("No está matriculado actualmente en ningún curso.");} 
                %>  
                
                <p></p> 
                <B>Cursos Acabados</B><BR>
				<p></p>              								       					
        					
        			<%
					
					boolean hayCursosAcabados = false;
					int cabeceraCursosAcabados = 0;
					
					if (listaObjetoBean != null && !listaObjetoBean.esVacio()){
					
	                    for(int i=0;i<listaObjetoBean.tamanio();i++){
	                  		expediente = (ObjetoBean) listaObjetoBean.dameObjeto(i);
	                  		if (expediente.dameValor("ESTADO").equals("inactivo"))
	                  		{	
	                  			
	                  			  if (cabeceraCursosAcabados == 0) {	
	                  				    	                  	  
			    	                  out.println("<table  width='90%' border='0' cellspacing='0' cellpadding='10' >");
			    	                  out.println("<tr bgcolor='#877fff'>");
			    	                  out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Curso</b></font></th>");
			    	                  out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Fecha Inicio</b></font></th>");
			    	                  out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Fecha Fin</b></font></th>");
			    	                  out.println("<th class='FormLiteral'><font face='Trebuchet MS' color='#616D7E' point-size='5'><b>Nota</b></font></th>");
			    	                  out.println("</tr>");
									  cabeceraCursosAcabados ++;
								  }
								  
								  
	    	                  	  hayCursosAcabados = true;		    	                  
		    	                  String Nota=String.valueOf(expediente.dameValor("NOTAFINAL"));
		    	                  if ((String.valueOf(expediente.dameValor("NOTAFINAL")).equals("null")) || (String.valueOf(expediente.dameValor("NOTAFINAL")).equals("-1")))
		    	                  {
		    	                	  Nota = "No presentado";
		    	                  }
		    	                  if (String.valueOf(expediente.dameValor("NOTAFINAL")).equals("-2"))
		    	                  {
		    	                	  Nota = "Curso Cancelado";
		    	                  }
		    	                  out.println("<tr bgcolor='#dbecff'>");
		    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("NOMBRE"))+"</td>");
		    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("FECHA_INICIO"))+"</td>");
		    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(expediente.dameValor("FECHA_FIN"))+"</td>");
		    	                  out.println("<td class='FormLiteral' align='center'>"+String.valueOf(Nota)+"</td>");
		    	                  out.println("</tr>");
	                      		
	                      	} 
                    	}
                    	if (cabeceraCursosAcabados != 0) {out.println("</table>");}
                    }
                    if (!hayCursosAcabados) {out.println("No ha cursado ningún curso anteriormente.");} 
                %>  
                
                <BR><BR>
              <table border="0" align="center" cellspacing="0" cellpadding="5">                 	                      				                      				
              	<tr>
					 <td>
                      <input type="hidden" name="evento" value="menuPrincipalAlum">
                      <button type="submit" class="botonSimple">Aceptar</button>
					  </td>
				</tr>	                       				
        	  </table>
          </form>
    		</div>
	  </div>
	  <div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:100px; width:50px"></div>	    
   </body>
</html>
