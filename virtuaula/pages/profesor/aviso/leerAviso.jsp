<%@ page import="beans.*" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Leer Aviso </title>
      <link href="./../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="./../../../styles/application.css" rel="stylesheet" type="text/css"/>
      
      <script language=JavaScript type="text/JavaScript">        
          function lanzaFormulario (evento) {
            document.formSubmenu.evento.value = evento;
            document.formSubmenu.submit();
          };             
             
      </script>
            
  </head>
   <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Leer Aviso</b></font>                
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
    	  			  <a href="JavaScript:lanzaFormulario('menuPrincipalProf');" onmouseout="window.status=''" onmouseover="window.status='Menu principal';return true ">Menu principal</a>
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
    		<div style="position:relative; top:20px; left:40px; z-index:-1;">
    			<form method=post action="/virtuaula/ServletVisualizador" name="formPrincipal">
  				<%

              HttpSession sesion=request.getSession();
              ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("listaaviso"));
              Integer posicionAviso = ((Integer)sesion.getAttribute("posAviso"));
            	Avisos aviso;
            	
              if (listaObjetoBean != null && !listaObjetoBean.esVacio() && posicionAviso != null){
              	if (posicionAviso.intValue() <= listaObjetoBean.tamanio()) {
              		aviso = (Avisos) listaObjetoBean.dameObjeto(posicionAviso.intValue());      		
              	}
              }                        
              
              if (aviso == null) {aviso = new Avisos ();}
              
          %>    			
            <table border='0' cellspacing='0' cellpadding='10'>  
        				<tr>
        					<td class="FormLiteral">Asunto</td>
        					<td><input type="text" class="FormTxt" name="ASUNTO" disabled="true" value="<%=aviso.dameValor("ASUNTO")%>"></td>

        					<td></td>
        					<td class="FormLiteral">Fecha Aviso</td>
        					<td><input type="text" class="FormTxt" name="FECHA_AVISO" disabled="true" value="<%=aviso.dameValor("FECHA_AVISO")%>"></td>
        					<td></td>
        					<td class="FormLiteral">Caducidad</td>
        					<td><input type="text" class="FormTxt" name="FECHA_CADUCIDAD" disabled="true" value="<%=aviso.dameValor("FECHA_CADUCIDAD")%>"></td>


        				</tr>
        		</table> 
        		<table border='0' cellspacing='0' cellpadding='10'>  		
                    <tr>
            					<td class="FormLiteral" width="100">Anotaciones</td>
            					<td><textarea name="TEXTO" rows="15" cols="95" disabled="true" class="FormTxtArea" value="<%=aviso.dameValor("TEXTO")%>"></textarea></td>
            					<td></td>
            				</tr>
                  	<tr>
    					         <td colspan="5" align="center">
    						        <input type="hidden" name="evento" value="VOLVER_ANTERIOR">
                        <button type="submit" class="botonSimple">Aceptar</button>
    					         </td>
    				        </tr>	                             				
                              
            </table>     				  
          </form>
    		</div>
	  </div>
   </body>
</html>
