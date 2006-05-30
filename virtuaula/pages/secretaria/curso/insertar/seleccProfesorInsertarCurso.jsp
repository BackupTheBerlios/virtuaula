<%@ page import="beans.*" %>
<%@ page import="beans.Error" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Seleccionar Profesor Para un Curso </title>
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Seleccionar profesor</b></font>                
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
    	  		<div class="botonesSubMenu">
    			    <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    		    	  <input type="hidden" name="evento">

    	  				  <a href="JavaScript:lanzaFormulario('menuPrincipalSec');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver al menú principal'; overlib('Pulse aquí si desea volver al menú principal'); return true;">Volver al menú principal</a>
                          <a href="JavaScript:lanzaFormulario('GES_CUR');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver a gestión de cursos'; overlib('Pulse aquí si desea volver a gestión de cursos'); return true;">Volver a gestión de cursos</a>
      					  <a href="JavaScript:lanzaFormulario('desconectar');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Salir'; overlib('Pulse aquí si desea salir de la aplicación'); return true;"><font color="#660000">Salir</font></a>
    				</form>
   				  </div>
    		  </div>
    		<div style="position:relative; top:-16px; z-index:-1;">
    			 <table width="983px" border="0" cellspacing="0" cellpadding="0">
    		         <tr>
    				    <td class="lineaSep"></td>
    		         </tr>
    			 </table>
    		</div>
		<div style="position:relative; left:10px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Seleccione un profesor para el curso (paso 5/6)</b></font>
    		</div>
    		<div style="position:relative; left:20px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E">
    			   Debe seleccionar un profesor de la lista de profesores disponibles en el horario y área elegidos
    			</font>
    		</div>
    		<div style="position:relative; top:10px; left:200; z-index:-1;">
    			<form method=post action="/virtuaula/ServletVisualizador">
        				
        				<%
	
                    HttpSession sesion=request.getSession();
                    ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("listaprofesor"));
                  	Profesor profesor;
		                if (listaObjetoBean != null && !listaObjetoBean.esVacio()){
        		            out.println(" <table border='0' cellspacing='0' cellpadding='10'>");		
        		            out.println("<tr>");
                        out.println("	<th class='FormLiteral'><b>Seleccion</th>");
        		            out.println("	<th class='FormLiteral'><b>DNI</th>");  					
        		            out.println("	<th class='FormLiteral'><b>Nombre</th>");
        		            out.println("	<th class='FormLiteral'><b>Primer Apellido</th>");
        		            out.println("	<th class='FormLiteral'><b>Segundo Apellido</th>");
        		            out.println("</tr>");	
	                        	                       	     
	                   	 for (int i=0; i<listaObjetoBean.tamanio();i++) {
			
                          profesor = (Profesor) listaObjetoBean.dameObjeto(i);
			                    out.println("<tr>");
			                    out.println("<td>");
			                    if (i==0){
   		         	             out.println("<input type='radio' class='FormTxt' value='"+i+"' name='posProf' checked>");
			                    }
			                    else{
   		         	               out.println("<input type='radio' class='FormTxt' value='"+i+"' name='posProf'>");
			                         }
	                   	    out.println("</td>");
	                  	    out.println("    <td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("ISUSUARIO_DNI"))+"</td>");
	                	      out.println("    <td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("NOMBRE"))+"</td>");
	                  	    out.println("    <td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("APELLIDO1"))+"</td>");
                          out.println("    <td class='FormLiteral' align='center'>"+String.valueOf(profesor.dameValor("APELLIDO2"))+"</td>");
	                        out.println("</tr>");
		                    }//fin for
		      
		                    out.println("<tr>");
		                    out.println("		         <td colspan='7' align='center'> ");
		                    out.println("			          <input type='hidden' name='evento' value='INSERTA_CURSO'>");
		                    out.println("			          <input type='hidden' name='idBean' value='listProf'>");
		                    out.println("   			        <button type='submit' class='botonSimple'>Seleccionar</button>");
		         
		                  
		              }
		              else{	
                         out.println("<font class='error'>No se ha encontrado ninguna entrada bajo estas condiciones.</font>");
			                   out.println(" <table border='0' cellspacing='0' cellpadding='10'>");		
			                   out.println("<tr>");			 
		      	             out.println("		         <td colspan='7' align='center'> ");
		      	             out.println("			          <input type='hidden' name='evento' value='INS_CUR_CON_PROF'>");
		      	             out.println("   			        <button type='submit' class='botonSimple'>Atrás</button>");

		
		                  } 
		          out.println("</td>");		                
		          out.println("</tr>");		                
		          out.println("</table>");		                
                %>   
					         
				        	
				        	
<table>
<%HttpSession sesion2=request.getSession();
ListaObjetoBean lista=(ListaObjetoBean)sesion2.getAttribute("error");%>
<% 
if (lista != null) 
{
int numeroElementos = lista.tamanio();
for (int i=0; i < numeroElementos; i++)
{
Error error = (Error) lista.dameObjeto(i);
%>
<tr class="error">
<td width="34%" align="left" height="18" bordercolor="#800000" bgcolor="#FFFFFF">  
<%= error.dameValor("CAUSA_ERROR")%>
</td>
</tr>
<%
}
}
%>        
        			</table>
          </form>
    		</div>
	  </div>
	      <div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:-100px; width:50px"></div>	 
   </body>
</html>
