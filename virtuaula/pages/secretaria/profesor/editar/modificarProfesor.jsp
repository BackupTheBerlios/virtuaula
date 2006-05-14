<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Titulo </title>
      <link href="../../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="../../../../styles/application.css" rel="stylesheet" type="text/css"/>
  </head>
   <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Editar Profesor</b></font>                
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
    		  <div align="right" style="position:relative; top:45px; z-index:-1;">
    	  			<div class="botonesSubMenu">
    	  			  <a href="#">Menu principal</a>
                <a href="#">Menu profesor</a>
      					<a href="#"><font color="#660000">Desconectar</font></a>
    				</div>
    		</div>
    		<div style="position:relative; top:43px; z-index:-1;">
    			 <table width="983px" border="0" cellspacing="0" cellpadding="0">
    		         <tr>
    				    <td class="lineaSep"></td>
    		         </tr>
    			 </table>
    		</div>
    		<div style="position:relative; top:55px; left:80px; z-index:-1;">
    			<form method=post action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10">
        				<tr>
        					<td class="FormLiteral">DNI</td>
        					<td><input type="text" class="FormTxt" maxlength="9" name="ISUSUARIODNI" value="12398752"></td>
        					<td width="100"></td>
        					<td class="FormLiteral">Nombre</td>
        					<td><input type="text" class="FormTxt" name="NOMBRE" value="nombre"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Primer Apellido</td>
        					<td><input type="text" class="FormTxt" maxlength="40" name="APELLIDO1" value="apellido1"></td>
        					<td></td>
        					<td class="FormLiteral">Segundo Apellido</td>
        					<td><input type="text" class="FormTxt" maxlength="40" name="APELLIDO2" value="apellido2"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Telefono</td>
        					<td><input type="text" class="FormTxt" maxlength="9" name="TELEFONO" value="123456789"></td>
        					<td></td>
        					<td class="FormLiteral">Correo electrónico</td>
        					<td><input type="text" class="FormTxt" maxlength="50" name="EMAIL" value="pp@virtuaula.com"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Area</td>
        					<td><input type="text" class="FormTxt" name="area" value="ISAREA_IDISAREA"></td>
        				</tr>
              	<tr>
					         <td colspan="7" align="center">
					          <input type="hidden" name="editar" value="modificarProfesor">
						        <button type="submit" class="botonSimple">Modificar</button>
					         </td>
				        </tr>	                       				
        			</table>
          </form>
    		</div>
	  </div>
   </body>
</html>
