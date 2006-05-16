<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Titulo </title>
      <link href="../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      
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
          </div>
    		  <div style="position:relative; top:25px; z-index:-1;">
     		    <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    		      <input type="hidden" name="evento">
      	  			<div class="botonesSubMenu">
                  <a href="#">Editar</a>
      					  <a href="JavaScript:lanzaFormulario('INI_CONS_PROF');" onmouseout="window.status=''" onmouseover="window.status='Consultar Profesor';return true ">Consultar</a>
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
    		<div style="position:relative; top:35px; z-index:-1;">
    			Esto keda para pintar en profesores
    		</div>
	  </div>
   </body>
</html>
