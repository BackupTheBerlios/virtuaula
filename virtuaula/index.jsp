<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Menu principal</title>
      <link href="./styles/estilosBotones.css" rel="stylesheet" type="text/css">
      <link href="./styles/application.css" rel="stylesheet" type="text/css"/>
      <script language="JavaScript" src="../../../../script/overlib_mini.js"></script>
      
      <script language=JavaScript type="text/JavaScript">        
          function lanzaFormulario (evento) {
            document.formSubmenu.evento.value = evento;
            document.formSubmenu.submit();
          };      
      </script>      
      
</head>
   <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
   <body background="./img/fondo.jpg">
         <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td width="3000" background="./img/cabF.jpg">
            <img src="./img/cabI.jpg" width="392" height="78"></td>
            <td><img src="./img/cabD.jpg" width="537" height="78" border="0"></td>
         </tr>
      </table>
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td background="./img/barF.gif">
            <img src="./img/barF.gif" border="0" width="1" height="40"></td>
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
  				    <a href="JavaScript:lanzaFormulario('OFERTA_FORMATIVA');" onmouseout="window.status=''" onmouseover="window.status='Vea los cursos de la academia';return true ">Área de Conocimiento</a>
  				    <a href="JavaScript:lanzaFormulario('ZONA_RESTRINGIDA');" onmouseout="window.status=''" onmouseover="window.status='Entre en la Zona Restringida';return true ">Zona Restringida</a>
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
         </div>
         <div style="position:absolute; top:200px; left:150px; z-index:1; width : 329px; height : 117px;">
            <a href="JavaScript:lanzaFormulario('OFERTA_FORMATIVA');"" onmouseout="window.status=''" onmouseover="window.status='Pulse sobre la imagen para ver los cursos de la academia';return true ">
            <img border="0" src="img/platon.jpg" width="250" height="300" alt="Pulse sobre la imagen para ver los cursos de la academia"></p>
                <div style="position:relative; left:40px; top:15px; z-index:-1;">
    			    <font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Área de Conocimiento</b>                
    			    </font>
    		    </div>
            </a>
        </div>
        <div style="position:absolute; top:200px; left:600px; z-index:1; width : 329px; height : 117px;">
         	<a href="JavaScript:lanzaFormulario('ZONA_RESTRINGIDA');" onmouseout="window.status=''" onmouseover="window.status='Entre en la Zona Restringida';return true "</a>
            <img border="0" src="img/edificio.jpg" width="250" height="300" alt="Pulse sobre la imagen para acceder a la Zona Restringida"></p>
               <div style="position:relative; left:60px; top:15px; z-index:-1;">
    			    <font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Zona Restringida</b>                
    		   </div>
            </a>
        </div>
   </body>
</html>