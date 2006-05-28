<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Editar Curso </title>
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Editar Alumno</b></font>                
    	   </div>                   			  	 
         <div align="right" style="position:relative; top:-5px">               
    		  	 <font face="Verdana, Arial, Helvetica, sans-serif" color=#616D7E size=2>
                <script language="JavaScript" type="text/JavaScript">
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
   	  			  <a href="#">Atras</a>
              <a href="#">Menu alumno</a>
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
    			<form name="seleccionarCurso" method=post action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10">
              
         				<tr>
        					<th class="FormLiteral"><b>Seleccion</th>         				
        					<th class="FormLiteral"><b>DNI</th>
        					<th class="FormLiteral"><b>Nombre</th>
                  <th class="FormLiteral"><b>Primer Apellido</th>
                  <th class="FormLiteral"><b>Segundo Apellido</th>        					
        				</tr>

              
                <!-- Bucle for -->
                <tr>
        				  <td><input type="radio" class="FormTxt" value="1" name="posicionArray"></td>
        					<td class="FormLiteral" align="center">123456789</td>
        					<td class="FormLiteral" align="center">Pepe</td>
                  <td class="FormLiteral" align="center">San Jose</td>
                  <td class="FormLiteral" align="center">gasg</td>        					
        				</tr>
                <tr>
        				  <td><input type="radio" class="FormTxt" value="2" name="posicionArray"></td>
        					<td class="FormLiteral" align="center">9876554321</td>
        					<td class="FormLiteral" align="center">Juan</td> 
                  <td class="FormLiteral" align="center">abcd</td>
                  <td class="FormLiteral" align="center">eerf</td>       					
        				</tr>
                <tr>
        				  <td><input type="radio" class="FormTxt" value="3" name="posicionArray"></td>
        					<td class="FormLiteral" align="center">159753654</td>
        					<td class="FormLiteral" align="center">María</td>
                  <td class="FormLiteral" align="center">Perez</td>
                  <td class="FormLiteral" align="center">de todos los Santos</td>        					
        				</tr>
        				<!-- Fin Bucle for -->
        				
              	<tr>
					         <td colspan="7" align="center">
					          <input type="hidden" name="editar" value="seleccionarCurso">
						        <button type="submit" class="botonSimple">Buscar</button>
					         </td>
				        </tr>	            
                           				
        			</table>
          </form>
    		</div>
	  </div>	  	  
    <div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:-100px; width:50px"></div>	 
   </body>  
</html>
