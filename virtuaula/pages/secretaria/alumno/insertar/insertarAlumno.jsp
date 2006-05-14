<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Insertar Alumno </title>
      <link href="../../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="../../../../styles/application.css" rel="stylesheet" type="text/css"/>
      <script language="JavaScript" src="../../../../script/overlib_mini.js"></script>
      <script language="JavaScript" src="../../../../script/calendar.js"></script>

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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Insertar Alumno</b></font>                
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
    			<form name="insertarAlumno" method=post action="">
              <table border="0" cellspacing="0" cellpadding="10">
        				<tr>
        					<td class="FormLiteral">DNI</td>
        					<td><input type="text" class="FormTxt"></td>
        					<td width="100"></td>
        					<td class="FormLiteral">Nombre</td>
        					<td><input type="text" class="FormTxt"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Primer Apellido</td>
        					<td><input type="text" class="FormTxt"></td>
        					<td></td>
        					<td class="FormLiteral">Segundo Apellido</td>
        					<td><input type="text" class="FormTxt"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Telefono</td>
        					<td><input type="text" class="FormTxt"></td>
        					<td></td>
        					<td class="FormLiteral">Correo electrónico</td>
        					<td><input type="text" class="FormTxt"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Dirección</td>
        					<td><input type="text" class="FormTxt"></td>
        					<td></td>
        					<td class="FormLiteral">Fecha Nacimiento</td>
        					<td><input type="text" class="FormTxt" name="fNacimiento">&nbsp;&nbsp;<a href="javascript:ggPosX=740;ggPosY=200;show_calendar('insertarAlumno.fNacimiento');" onMouseOver="window.status='Seleccione una fecha';  overlib('Pulsa para elegir fecha del mes en el calendario emergente.'); return true;" onMouseOut="window.status=''; nd(); return true;"><img src="../../../../img/show-calendar.gif" width=24 height=22 border=0></a>    
                  </td>
        				</tr>
        				<tr>        				
        					<td class="FormLiteral">Sexo</td>
        					<td>
                      <select name="sexo" class="FormTxt">
                         <option value="vacio"></option>
	                       <option value="Masculino">Masculino</option>
	                       <option value="Femenino">Femenino</option>
                      </select>                                    
                  </td>
        				</tr>
              	<tr>
					         <td colspan="7" align="center">
						        <button type="submit" class="botonSimple">Insertar</button>
					         </td>
				        </tr>	                       				
        			</table>
          </form>
    		</div>
	  </div>	  	  
    <div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:-100px; width:50px"></div>	 
   </body>
</html>
