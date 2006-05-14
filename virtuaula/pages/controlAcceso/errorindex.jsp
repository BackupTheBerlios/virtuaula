<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Menu principal control Acceso </title>
      <link href="../../styles/estilosBotones.css" rel="stylesheet" type="text/css">
      <link href="../../styles/application.css" rel="stylesheet" type="text/css"/>
</head>
   <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
         <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td width="3000" background="../../img/cabF.jpg"><img src="../../img/cabI.jpg"></td>
            <td><img src="../../img/cabD.jpg" width="537" height="78" border="0"></td>
         </tr>
      </table>
      <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td background="../../img/barF.gif"><img src="../../img/barF.gif" border="0"></td>
         </tr>
         <tr>
            <td background="../../img/ContenidoF.gif" height="40">&nbsp;</td>
         </tr>
      </table>
      <div id="lyComponentes" style="position:absolute; left:0px; top:75px; width:955px; z-index:1; overflow:inherit;">
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
 		<h3 align="center">FALLO AL ACCESO RESTINGIDO AL PORTAL</h3>
    <div style="position:relative; top:10px; left:360px; z-index:1; width : 329px; height : 117px;">
          <form name="inicioControlAcceso" method=post action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10">
        				<tr>
        					<td class="FormLiteral">Usuario</td>
        					<td><input type="text" class="FormTxt" maxlength="40" name="DNI"></td>
                </tr>
                <tr>
        					<td class="FormLiteral">Contraseña</td>
        					<td><input type="password" class="FormTxt" name="CONTRASENIA"></td>
        				</tr>
        				<tr>
					         <td colspan="7" align="center">
	 				          <input type="hidden" name="evento" value="LOGAR">
					         <input type="hidden" name="idBean" value="Usuario">
						        <button type="submit" class="botonSimple" name="boton" value="acceso">Aceptar</button>
					         </td>
				        </tr>	
              </table>
          </form>
	  </div>
   </body>
</html>
