<%@ page import="beans.*" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Buscar Profesor Consultar </title>
      <link href="../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="../../../styles/application.css" rel="stylesheet" type="text/css"/>
      
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
		  	 <div align="left" style="position:relative; top:15px; left:15px">
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Ficha Alumno</b></font>                
    	   </div> 
         <div align="right" style="position:relative; top:-5px">               
    		  	 <font face="Verdana, Arial, Helvetica, sans-serif" color=#616D7E size=2>
                <script language=JavaScript type="text/JavaScript">
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
                <a href="JavaScript:lanzaFormulario('menuPrincipalProf');" onmouseout="window.status=''" onmouseover="window.status='Menu profesor';return true ">Menu principal</a>
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
    		<div style="position:relative; top:20px; left:80px; z-index:-1;">
    			<form method=post action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10">
                <%
                    HttpSession sesion=request.getSession();
                    ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("listaalumno"));
                    Integer posicionAlumno = (Integer) sesion.getAttribute("posAlumno"); 
                    
                    if ((listaObjetoBean != null) && (posicionAlumno != null)) {
                    	if (listaObjetoBean.tamanio() >= posicionAlumno.intValue() ) {
                    		Alumno alumno = (Alumno) listaObjetoBean.dameObjeto(posicionAlumno.intValue());
                    		ObjetoBean ficha =(ObjetoBean) sesion.getAttribute("beanFicha");
                    		if (alumno == null) {alumno = new Alumno ();}    
                    			out.println("<input type='hidden' name='IDISFICHA' value='"+ficha.dameValor("IDISFICHA")+"'>");
                    			out.println("<tr>");
                    			out.println("<td class='FormLiteral'>DNI</td>");
                    			out.println("<td><input type='text' class='FormTxt' maxlength='9' name='ISUSUARIODNI' disabled='true' value="+alumno.dameValor("ISUSUARIO_DNI")+"'></td>");
                    			out.println("<td width='100'></td>");
                    			out.println("<td class='FormLiteral'>Nombre</td>");
                    			out.println("<td><input type='text' class='FormTxt' maxlength='40' name='NOMBRE' disabled='true' value="+alumno.dameValor("NOMBRE")+"'></td>");
                    			out.println("</tr>");
                    			out.println("<tr>");
                    			out.println("<td class='FormLiteral'>Primer Apellido</td>");
                    			out.println("<td><input type='text' class='FormTxt' maxlength='40' name='APELLIDO1' disabled='true' value="+alumno.dameValor("APELLIDO1")+"'></td>");
                    			out.println("<td></td>");
                    			out.println("<td class='FormLiteral'>Segundo Apellido</td>");
                    			out.println("<td><input type='text' class='FormTxt' maxlength='40' name='APELLIDO2' disabled='true' value="+alumno.dameValor("APELLIDO2")+"'></td>");
                    			out.println("</tr>");
                    			out.println("<tr>");
                    			out.println("<td class='FormLiteral'>Telefono</td>");
                    			out.println("<td><input type='text' class='FormTxt' maxlength='9' name='TELEFONO' disabled='true' value="+alumno.dameValor("TELEFONO")+"'></td>");
                    			out.println("<td></td>");
                    			out.println("<td class='FormLiteral'>Correo electrónico</td>");
                    			out.println("<td><input type='text' class='FormTxt' maxlength='50' name='EMAIL' disabled='true' value="+alumno.dameValor("EMAIL")+"'></td>");
                    			out.println("</tr>");
                    			out.println("<tr>");
                    			out.println("<td class='FormLiteral'>Dirección</td>");
                    			out.println("<td><input type='text' class='FormTxt' maxlength='100' name='DIRECCION' disabled='true' value="+alumno.dameValor("DIRECCION")+"'></td>");
                    			out.println("<td></td>");
                    			out.println("<td class='FormLiteral'>Fecha Nacimiento</td>");
                    			out.println("<td><input type='text' class='FormTxt' maxlength='10' disabled='true' name='FECHNACIMIENTO' value="+alumno.dameValor("FECH_NACIMIENTO")+"'></td>");
                    			out.println("</tr>");
                    			out.println("<tr>");
                    			out.println("<td class='FormLiteral'>Sexo</td>");
                    			out.println("<td><input type='text' class='FormTxt' maxlength='10' disabled='true' name='SEXO' value="+alumno.dameValor("SEXO")+"'></td>");
                    			out.println("<td></td>");
                    			out.println("<td class='FormLiteral'>Notas Ejercicios</td>");
                    			out.println("<td>");
                    			out.println("<select name='NOTAS_EJERCICIOS' class='FormTxt'>");
                    			out.println("<option value='-1'>No presentado</option>");
                    			out.println("<option value='0'>0</option>");
                    			out.println("<option value='1'>1</option>");
                    			out.println("<option value='2'>2</option>");
                    			out.println("<option value='3'>3</option>");
                    			out.println("<option value='4'>4</option>");
                    			out.println("<option value='5'>5</option>");
                    			out.println("<option value='6'>6</option>");
                    			out.println("<option value='7'>7</option>");
                    			out.println("<option value='8'>8</option>");
                    			out.println("<option value='9'>9</option>");
                    			out.println("<option value='10'>10</option>");
                    			out.println("</select>");
                    			out.println("</td>");
                    			out.println("</tr>");
                    			out.println("<tr>");
                    			out.println("<td colspan='5'>");
                    			out.println("<table border='0' cellspacing='0' cellpadding='0'>");
                    			out.println("<tr>");
                    			out.println("<td class='FormLiteral' width='100'>Notas</td>");
                    			out.println("<td><textarea name='NOTAS' rows='5' cols='103'  class='FormTxtArea' >"+ficha.dameValor("NOTAS")+"</textarea></td>");
                    			out.println("<td></td>");
                    			out.println("</tr>");
                    			out.println("</table>");
                    			out.println("</td>");
                    			out.println("</tr>");
                    			out.println("<tr>");
                    			out.println("<td colspan='5'>");
                    			out.println("<table border='0' cellspacing='0' cellpadding='0'>");
                    			out.println("<tr>");
                    			out.println("<td class='FormLiteral' width='100'>Anotaciones</td>");
                    			out.println("<td><textarea name='ANOTACIONES' rows='5' cols='103'  class='FormTxtArea' >"+ficha.dameValor("ANOTACIONES")+"</textarea></td>");
                    			out.println("<td></td>");
                    			out.println("</tr>");
                    			out.println("</table>");
                    			out.println("</td>");
                    			out.println("</tr>");
                    			out.println("<tr>");
                    			out.println("<td colspan='5' align='center'>");
                    			out.println("<input type='hidden' name='evento' value='ActualizarFichaAlumno'>");
                    			out.println("<input type='hidden' name='idBean' value='Ficha'>");
                    			out.println("<button type='submit' class='botonSimple'>Modificar</button>");
                    			out.println("</td>");
                    			out.println("</tr>");        			        		      		        	
                    	}
                    } 
                %>                       				
        			</table>
          </form>
    		</div>
	  </div>
   </body>
</html>
