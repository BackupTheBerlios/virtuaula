<%@ page import="beans.*" %>
<%@ page import="beans.Error" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Pagina principal Alumno </title>
      <link href="../../styles/estilosBotones.css" rel="stylesheet" type="text/css">
      <script language="JavaScript" src="../../script/overlib_mini.js"></script>
      
      <script language=JavaScript type="text/JavaScript">        
          function lanzaFormulario (evento) {
            document.formSubmenu.evento.value = evento;
            document.formSubmenu.submit();
          };      

          function lanzaFormularioD (evento) {
            document.formSubmenuD.evento.value = evento;
            document.formSubmenuD.submit();
          };   

      </script>      
      
</head>
   <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
    <body background="../../img/fondo.jpg">
         <table width="983px" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td width="3000" background="../../img/cabF.jpg"><img src="../../img/cabI.jpg"></td>
            <td><img src="../../img/cabD.jpg" width="537" height="78" border="0" usemap="#Map"></td>
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
		  <div style="position:relative; top:12px;">
			   <div class="botones">
			     <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    	     <input type="hidden" name="evento">
  				    <a href="JavaScript:lanzaFormulario('CONS_EXP_ALUM');" onmouseout="window.status=''" onmouseover="window.status='Menu Expediente';return true ">Consulta Expediente</a>
  				    <a href="JavaScript:lanzaFormulario('AVIS_ALUM');" onmouseout="window.status=''" onmouseover="window.status='Menu avisos';return true ">Leer Avisos</a>
  				  </form>
		  	 </div>		  	 		  	
		  	 <div align="right" style="position:relative; top:-35px">               
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
	  <div align="right" style="position:relative; z-index:-1; top:-10px;">    		
    	  	<div class="botonesSubMenu">
					<form method=post action="/virtuaula/ServletVisualizador" name="formSubmenuD">    	  			
					<input type="hidden" name="evento">
      					<a href="JavaScript:lanzaFormularioD('desconectar');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Salir'; overlib('Pulse aqu� si desea salir de la aplicaci�n'); return true;"><font color="#660000">Salir</font></a>    				  
    				</form>
			</div>    				
    	</div>
	  </div>
	  <div style="position:relative; left:50px; top:50px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E" point-size="5">
    			  Desde esta pagina puede elegir qu� desea hacer:<br><br>
    			  - Consultar el expediente acad�mico, compuesto por cursos en los que est� matriculado actualmente y cursos<br> realizados con anterioridad<br>
    			  - Leer o borrar avisos enviados por otros usuarios
    			</font>
     </div>
	  <div style="position:relative; left:350px; top:100px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E" point-size="5">               
    		
		<%
		HttpSession sesion=request.getSession();
		Integer numAvisos= (Integer) (sesion.getAttribute("numAvisos"));
		int numeroAvisos= numAvisos.intValue();
		out.println("<b>Tiene "+ numeroAvisos+ " mensajes nuevos.</b>");
	  	%>
	  </div>
      <map name="map">
        <area shape="rect" coords="450,0,510,50" href="./index.html">
      </map>
      <div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:100px; width:50px"></div>	    
   </body>
</html>


