<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Menu principal</title>
      <link href="./styles/estilosBotones.css" rel="stylesheet" type="text/css">
      <link href="./styles/application.css" rel="stylesheet" type="text/css"/>
      
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
            <td width="3000" background="./img/cabF.jpg"><img src="./img/cabI.jpg"></td>
            <td><img src="./img/cabD.jpg" width="537" height="78" border="0"></td>
         </tr>
      </table>
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td background="./img/barF.gif"><img src="./img/barF.gif" border="0"></td>
         </tr>
         
         <tr>
            <td background="./img/ContenidoF.gif" height="40">&nbsp;</td>
         </tr>
      </table>
      <div id="lyComponentes" style="position:absolute; left:0px; top:75px; width:955px; z-index:1; overflow:inherit;">
      	  <div style="position:relative; top:12px;">
			   <div class="botones">
			     <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
			      <input type="hidden" name="idBean" value="Usuario">
			      <input type="hidden" name="DNI" value="anonimo">
			      <input type="hidden" name="CONTRASENIA" value="anonimo">
    	     <input type="hidden" name="evento">
  				    <a href="JavaScript:lanzaFormulario('OFERTA_FORMATIVA');" onmouseout="window.status=''" onmouseover="window.status='Oferta Formativa';return true ">Oferta Formativa</a>
  				    <a href="JavaScript:lanzaFormulario('ZONA_RESTRINGIDA');" onmouseout="window.status=''" onmouseover="window.status='Zona Restringida';return true ">Zona Restrigida</a>
  				  </form>
		  	 </div>	
		  <div align="right" style="position:relative; top:12px;">		  	 		  	              
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
 		</div>
 		<h3 align="center">PAGINA INICIAL (PRINCIPAL)</h3>
    <div style="position:relative; top:10px; left:360px; z-index:1; width : 329px; height : 117px;">
          <form name="inicioControlAcceso" method=post action="/virtuaula/pages/controlAcceso/index.jsp">
              <table border="0" cellspacing="0" cellpadding="10">

        				<tr>
					         <td colspan="7" align="center">
					         </td>
				        </tr>	
              </table>
          </form>
	  </div>
   </body>
</html>