<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Pagina Principal Gestion de Alumnos </title>
      <link href="../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <script language="JavaScript" src="../../../script/overlib_mini.js"></script>

      <script language=JavaScript type="text/JavaScript">        
          function lanzaFormulario (evento) {
            document.formSubmenu.evento.value = evento;
            document.formSubmenu.submit();
          };      
      </script>  

      <script language=JavaScript type="text/JavaScript">        
          function lanzaFormularioD (evento) {
            document.formSubmenuD.evento.value = evento;
            document.formSubmenuD.submit();
          };      
      </script>  
      
  </head>
   <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
   <body background="../../../img/fondo.jpg">
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td width="3000" background="../../../img/cabF.jpg"><img src="../../../img/cabI.jpg"></td>
            <td><img src="../../../img/cabD.jpg" width="537px" height="78px" border="0"></td>
         </tr>
      </table>
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td background="../../../img/barF.gif"><img src="../../../img/barF.gif" border="0"></td>
         </tr>
         <tr>
            <td background="../../../img/ContenidoF.gif" height="40px">&nbsp;</td>
         </tr>
      </table>
      <div id="lyComponentes" style="position:absolute; left:0px; top:75px; width:955px; z-index:1; overflow:inherit;">
		  	 
         <div align="right" style="position:relative; top:15px">               
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
            <div align="right" style="position:relative; top:12px;">
            	<div class="botonesSubMenu">
            		<form method=post action="/virtuaula/ServletVisualizador" name="formSubmenuD">
    		      		<input type="hidden" name="evento">    	  			
    	  			     <a href="JavaScript:lanzaFormularioD('menuPrincipalSec');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver al menú principal'; overlib('Pulse aquí si desea volver al menú principal'); return true;">Menú principal</a>
      					<a href="JavaScript:lanzaFormularioD('desconectar');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Salir'; overlib('Pulse aquí si desea salir de la aplicación'); return true;"><font color="#660000">Salir</font></a>
    				</form>
    			 </div>
    		  </div>
          </div>
    	  <div style="position:relative; top:-14px; z-index:-1;">
    	  	 <div class="botonesSubMenu">
    			 <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    				     <input type="hidden" name="evento">
    					<a href="JavaScript:lanzaFormulario('MAT_ALUM_DOS');" onmouseout="window.status=''" onmouseover="window.status='Matricular alumno';return true ">Matricular alumno</a>
							<a href="JavaScript:lanzaFormulario('EDITAR_ALUM_INI');" onmouseout="window.status=''" onmouseover="window.status='Buscar alumno';return true ">Modificar datos de alumno</a>
        					<a href="JavaScript:lanzaFormulario('CONS_ALUM');" onmouseout="window.status=''" onmouseover="window.status='Buscar alumno';return true ">Buscar alumno</a>
        			</form>
    			</div>
    		</div>
    		<div style="position:relative; top:-35px; z-index:-1;">
    			 <table width="983px" border="0" cellspacing="0" cellpadding="0">
    		         <tr>
    				    <td class="lineaSep"></td>
    		         </tr>
    			 </table>
    		</div>
    		<div style="position:relative; top:90px; left:50px; z-index:-1;">
    		</div>
	  </div>
	   <div style="position:relative; left:50px; top:50px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E" point-size="5">
    			  Desde esta página puede elegir qué desea hacer:<br><br>
    			  - Matricular un alumno en un curso impartido por la academia<br>
    			  - Modificar los datos de un alumno matriculado en la academia<br>
    			  - Buscar un alumno de entre todos los matriculados
    			</font>
     	</div>
	  	  <map name="map">
        <area shape="rect" coords="450,0,510,50" href="JavaScript:lanzaFormulario('desconectar');"onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Salir'; overlib('Pulse aquí si desea salir de la aplicación'); return true;"/>
      </map>
	  <div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:-100px; width:50px"></div>
   </body>
</html>