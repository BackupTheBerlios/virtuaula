<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Pagina Principal Gestion de Horarios </title>
      <link href="../../../styles/estilosBotones.css" rel="stylesheet" type="text/css">
      
      <script language="JavaScript" src="../../../script/overlib_mini.js"></script>
      
      <script language=JavaScript type="text/JavaScript">        
          function lanzaFormulario (evento) {
            document.formSubmenu.evento.value = evento;
            document.formSubmenu.submit();
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
		<div align="left" style="position:relative; top:15px; left:15px">
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Gesti�n de horarios</b></font>                
    	   </div>   	 
         <div align="right">               
           <b>
    		  	 <font face="Verdana, Arial, Helvetica, sans-serif" color=#616D7E size=2>
                <script language=JavaScript type=text/JavaScript>
	   function lanzaFormulario (evento) {
	            document.formSubmenu.evento.value = evento;
	            document.formSubmenu.submit();
	          };     
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
            <div align="right" style="position:relative; top:16px;style="position:relative; z-index:-1;">
    		      <input type="hidden" name="evento">
    	  			<div class="botonesSubMenu">
	    	  			<a href="JavaScript:lanzaFormulario('menuPrincipalSec');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver al men� principal'; overlib('Pulse aqu� si desea volver al men� principal'); return true;">Volver al men� principal</a>
      					<a href="JavaScript:lanzaFormulario('desconectar');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Salir'; overlib('Pulse aqu� si desea salir de la aplicaci�n'); return true;"><font color="#660000">Salir</font></a>
    				  </div>
    				</form>
    		  </div>
          </div>
    		  <div style="position:relative; top:-18px; z-index:-1;">
    	  			<div class="botonesSubMenu">
    				 <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    				     <input type="hidden" name="evento">
    												<a href="JavaScript:lanzaFormulario('INS_HOR');" onmouseout="window.status=''" onmouseover="window.status='Crear Horario';return true ">Crear Horario</a>        					
        					<a href="JavaScript:lanzaFormulario('CONS_HOR');" onmouseout="window.status=''" onmouseover="window.status='Consultar Horario';return true ">Consultar Horario</a>
        					<a href="JavaScript:lanzaFormulario('ELIM_HOR_PAS1');" onmouseout="window.status=''" onmouseover="window.status='Crear Horario';return true ">Borrar Horario</a>
        					</div>
    		</div>
    		<div style="position:relative; top:43px; z-index:-1;">
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
    			  Desde esta p�gina puede elegir qu� desea hacer:<br><br>
    			  - Crear un nuevo horario predefinido<br>
    			  - Consultar un horario predefinido de entre todos los existentes<br>
    			  - Borrar uno de los horarios predefinidos
    			</font>
     </div>
	  <map name="map">
        <area shape="rect" coords="450,0,510,50" href="JavaScript:lanzaFormulario('desconectar');"onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Salir'; overlib('Pulse aqu� si desea salir de la aplicaci�n'); return true;"></a>
      </map>
      <div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:100px; width:50px"></div>	    
   </body>
</html>
