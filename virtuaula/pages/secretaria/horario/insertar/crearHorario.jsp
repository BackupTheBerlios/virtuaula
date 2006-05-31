<%@ page import="beans.Error" %>
<%@ page import="beans.listaObjetoBeans.*" %>

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Crear un nuevo Horario </title>
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
			</b>
         </div>
             
    		  <div align="right" style="position:relative; z-index:-1; top:5px;">
    	  		<div class="botonesSubMenu">
    		    	<form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    			      	<input type="hidden" name="evento">

    	  			  <a href="JavaScript:lanzaFormulario('menuPrincipalSec');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver al menú principal'; overlib('Pulse aquí si desea volver al menú principal'); return true;">Volver al menú principal</a>
                        <a href="JavaScript:lanzaFormulario('GES_HOR');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver a gestión de horarios'; overlib('Pulse aquí si desea volver a gestión de horarios'); return true;">Volver a gestión de horarios</a>
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

    		<div style="position:relative; top:10px; left:80px; z-index:-1;">
    			<form name="crearHorario" method=post action="/virtuaula/ServletVisualizador">
              	<B>HORARIO
                </B><BR>

        				
              	<table  width="90%" 
              	
              	 cellspacing="0" cellpadding="10">
        		<tr>
        					<td class="FormLiteral">Lunes</td>
        					<td><select class="FormTxt"  maxlength="9" name="L" value="">
        					<option value=null>Seleccione un turno</option>
        					<option value='M'>Turno de Mañana</option>
        					<option value='T'>Turno de Tarde</option>
        					</select>
        					</td>
        					<td class="FormLiteral">Martes</td>
        					<td><select class="FormTxt"  maxlength="9" name="M" value="">
        					<option value=null>Seleccione un turno</option>
        					<option value='M'>Turno de Mañana</option>
        					<option value='T'>Turno de Tarde</option>
        					</select>
        					</td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Miércoles</td>
        					<td><select class="FormTxt"  maxlength="9" name="X" value="">
        					<option value=null>Seleccione un turno</option>
        					<option value='M'>Turno de Mañana</option>
        					<option value='T'>Turno de Tarde</option>
        					</select>
        					</td>
        					<td class="FormLiteral">Jueves</td>
        					<td><select class="FormTxt"  maxlength="9" name="J" value="">
        					<option value=null>Seleccione un turno</option>
        					<option value='M'>Turno de Mañana</option>
        					<option value='T'>Turno de Tarde</option>
        					</select>
        					</td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Viernes</td>
        					<td><select class="FormTxt"  maxlength="9" name="V" value="">
        					<option value=null>Seleccione un turno</option>
        					<option value='M'>Turno de Mañana</option>
        					<option value='T'>Turno de Tarde</option>
        					</select>
        					</td>
        					<td></td>
        				</tr>		  				
              	</table>  

              	<table align="center">  
              	    	<tr align="center">
					         <td colspan="7" align="center">     
					          <input type="hidden" name="idBean" value="Horario">
						  		 <input type="hidden" name="evento" value="INS_HOR2">					         
						        <button type="submit" class="botonSimple">Crear</button>
						      
					         </td>
				        </tr>	                       				
        			</table>
		        			      	
       	</form>     

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
       	          
	  </div>	  	  
   </div>
	<div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:-100px; width:50px"></div>	 	  

   </body>
</html>
