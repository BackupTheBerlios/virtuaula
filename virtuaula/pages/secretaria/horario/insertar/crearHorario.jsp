<%@ page import="beans.*" %>
<%@ page import="beans.Error" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<%@ page import="beans.ObjetoBean" %>

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Crear un nuevo Horario </title>
      <link href="../../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="../../../../styles/application.css" rel="stylesheet" type="text/css"/>
      <script language="JavaScript" src="../../../../script/overlib_mini.js"></script>

      <script language=JavaScript type="text/JavaScript">   
      	
      	         
          function lanzaFormulario (evento) {
            document.crearHorario.evento.value = evento;
            document.crearHorario.submit();
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Crear un nuevo Horario</b></font>                
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
             </div>
             </b>
    		  <div align="right" style="position:relative; z-index:-1;">
    		    <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    		      <input type="hidden" name="evento">
    	  			<div class="botonesSubMenu">
    	  			  <a href="JavaScript:lanzaFormulario('menuPrincipalSec');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver al men� principal'; overlib('Pulse aqu� si desea volver al men� principal'); return true;">Volver al men� principal</a>
                        <a href="JavaScript:lanzaFormulario('GES_HOR');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver a gesti�n de horarios'; overlib('Pulse aqu� si desea volver a gesti�n de horarios'); return true;">Volver a gesti�n de horarios</a>
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
    		<div style="position:relative; left:10px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E" point-size="5"><b></b></font>                
    		</div>
    		<div style="position:relative; left:20px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E">
    			  </font>
    		</div>
    		<div style="position:relative; top:10px; left:80px; z-index:-1;">
    			<form name="crearHorario" method=post action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10">
        				
                <% 
                HttpSession sesion=request.getSession();
                out.println("<B>HORARIO");
                out.println("</B><BR>");
                %> 
              	
              	<table  width="90%" 
              	style= "border-right: 2px hidden #dbecff; border-bottom: 2px hidden #dbecff; border-left: hidden; border-top: hidden"
              	 cellspacing="0" cellpadding="10">
        		<tr>
        					<td class="FormLiteral">Lunes</td>
        					<td><select class="FormTxt"  maxlength="9" name="L" value="">
        					<option value=null>Seleccione un turno</option>
        					<option value='M'>Turno de Ma�ana</option>
        					<option value='T'>Turno de Tarde</option>
        					</td>
        					<td class="FormLiteral">Martes</td>
        					<td><select class="FormTxt"  maxlength="9" name="M" value="">
        					<option value=null>Seleccione un turno</option>
        					<option value='M'>Turno de Ma�ana</option>
        					<option value='T'>Turno de Tarde</option>
        					</td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Mi�rcoles</td>
        					<td><select class="FormTxt"  maxlength="9" name="X" value="">
        					<option value=null>Seleccione un turno</option>
        					<option value='M'>Turno de Ma�ana</option>
        					<option value='T'>Turno de Tarde</option>
        					</td>
        					<td class="FormLiteral">Jueves</td>
        					<td><select class="FormTxt"  maxlength="9" name="J" value="">
        					<option value=null>Seleccione un turno</option>
        					<option value='M'>Turno de Ma�ana</option>
        					<option value='T'>Turno de Tarde</option>
        					</td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Viernes</td>
        					<td><select class="FormTxt"  maxlength="9" name="V" value="">
        					<option value=null>Seleccione un turno</option>
        					<option value='M'>Turno de Ma�ana</option>
        					<option value='T'>Turno de Tarde</option>
        					</td>
        					<td></td>
        				</tr>		
  				
              	</table >  
              	<br>
  				<br>
              	<table align="center">  
              	    	<tr align="center">
					         <td colspan="7" align="center">     
					          <input type="hidden" name="idBean" value="Horario">
						  		 <input type="hidden" name="evento" value="INS_HOR2">					         
						        <button type="submit" class="botonSimple">Crear</button>
						      
					         </td>
				        </tr>	                       				
        			</table>
        			<table>
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