 <%@ page import="beans.*" %>
<%@ page import="beans.Error" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Seleccionar Profesor Consultar </title>
      <link href="./../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="./../../../styles/application.css" rel="stylesheet" type="text/css"/>
      
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
   <body background="../../img/fondo.jpg">
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td width="3000" background="../../img/cabF.jpg"><img src="../../img/cabI.jpg"></td>
            <td><img src="../../img/cabD.jpg" width="537px" height="78px" border="0"></td>
         </tr>
      </table>
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td background="../../img/barF.gif"><img src="../../img/barF.gif" border="0"></td>
         </tr>
         <tr>
            <td background="../../img/ContenidoF.gif" height="40px">&nbsp;</td>
         </tr>
      </table>
      <div id="lyComponentes" style="position:absolute; left:0px; top:75px; width:955px; z-index:1; overflow:inherit;">
		  	 <div align="left" style="position:relative; top:15px; left:15px">
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>�rea de Conocimiento</b></font>                
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
    		  
    		<div style="position:relative; top:4px; z-index:-1;">
    			 <table width="983px" border="0" cellspacing="0" cellpadding="0">
    		         <tr>
    				    <td class="lineaSep"></td>
    		         </tr>
    			 </table>
    		</div>

    		<div style="position:relative; top:20px; left:180px; z-index:-1;">
    		<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Si desea usted matricularse en algunos de los cursos abajo ofertados,</b></font>
    		<br/>
    		<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>debe descargarse el formulario y traerlo relleno a:</b></font>
    		<br/>
    		<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>C\Friki n� 13</b></font>

			<p></p>
    		
				<table border="0" cellspacing="0" cellpadding="0">
					<tr>											
						<td>
							<a style="text-decoration: none;" class="botonesSubMenu" href="/virtuaula/documents/Formulario_Inscripcion.doc" onmouseout="window.status=''; return true;" onmouseover="window.status='Obtener formulario de inscripci�n'; return true;">              
	              				<img height="20px" width="20px" src="/virtuaula/img/msword_logo.gif" alt="Obtener formulario de inscripci�n" border="0" align="middle"/>
	              				<font face="Trebuchet MS" color="#006699" point-size="5"><b>Pulse aqu� para obtener el formulario de inscripci�n</b></font>
              				</a>       			
              			</td>
              		</tr>
              </table>
			</div>    		
    		<div style="position:relative; top:20px; left:180px; z-index:-1;">
    			<form method=post action="/virtuaula/ServletVisualizador" name="formPrincipal">
        				
        				<%
	
                    HttpSession sesion=request.getSession();
                    ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("listacurso"));
                  	Curso curso;
		                if (listaObjetoBean != null && !listaObjetoBean.esVacio()){
        		            out.println(" <table border='8' cellspacing='25' cellpadding='10'>");		
        		            out.println("<tr>");
        		            out.println("	<th class='FormLiteral'><b>Nombre</th>");
        		            out.println("	<th class='FormLiteral'><b>Fecha Inicio</th>");
        		            out.println("	<th class='FormLiteral'><b>Fecha Finalizaci�n</th>");
        		            out.println("</tr>");	
	                        	                       	     
	                   	 for (int i=0; i<listaObjetoBean.tamanio();i++) {
			
                          curso = (Curso) listaObjetoBean.dameObjeto(i);
			                    out.println("<tr>");
	                	      out.println("    <td class='FormLiteral' align='left'>"+String.valueOf(curso.dameValor("NOMBRE"))+"</td>");
	                	      if ((String.valueOf(curso.dameValor("FECHA_INICIO")).equals("null"))||(String.valueOf(curso.dameValor("FECHA_INICIO")).equals(""))){
		                	    	out.println("    <td class='FormLiteral' align='center'>Sin especf.</td>");  
	                	      	}
	    	              	    else{
   		                	    out.println("    <td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("FECHA_INICIO"))+"</td>");  
	        	          	    }
	        	          	  
	        	          	  
	        	          	  if ((String.valueOf(curso.dameValor("FECHA_FIN")).equals("null"))||(String.valueOf(curso.dameValor("FECHA_FIN")).equals(""))){
		                	  	  out.println("    <td class='FormLiteral' align='center'>Sin especf.</td>");  
	                	      	}
	    	              	    else{
   		                	    	out.println("    <td class='FormLiteral' align='center'>"+String.valueOf(curso.dameValor("FECHA_FIN"))+"</td>");  
	        	          	    }
	        	          	
	                        out.println("</tr>");
		                    }//fin for
		      
		                    out.println("<tr>");
		                    out.println("		         <td colspan='3' align='center'> ");
		                    out.println("			          <input type='hidden' name='idBean' value='Usuario'>");
		                    out.println("					   <input type='hidden' name='DNI' value='anonimo'>");
							out.println("				      <input type='hidden' name='CONTRASENIA' value='anonimo'>");
							out.println("			            <input type='hidden' name='evento'>");		                    
		                    out.println("   			        <button onClick=\"JavaScript:lanzaFormularioPrincipal('PRINCIPAL_PUBLICO');\" class='botonSimpleGrande'>Pagina Principal</button>");
		                    out.println("</td>");
		                    out.println("<td>");
		                  
		              }
		              else{	out.println("<font class='error'>No se ha encontrado ninguna entrada bajo estas condiciones.</font>");
			                   out.println(" <table border='0' cellspacing='0' cellpadding='10'>");		
			                   out.println("<tr>");			 
		      	             out.println("		         <td colspan='7' align='center'> ");
	                    out.println("			          <input type='hidden' name='idBean' value='Usuario'>");
		                    out.println("					   <input type='hidden' name='DNI' value='anonimo'>");
							out.println("				      <input type='hidden' name='CONTRASENIA' value='anonimo'>");
							out.println("			            <input type='hidden' name='evento'>");		      	             
                         out.println("   			        <button onClick=\"JavaScript:lanzaFormularioPrincipal('PRINCIPAL_PUBLICO');\" class='botonSimple'>Atr�s</button>"); 
		
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
   </body>
</html>
