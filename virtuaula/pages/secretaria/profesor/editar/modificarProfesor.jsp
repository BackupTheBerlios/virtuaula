<%@ page import="beans.*" %>
<%@ page import="beans.listaObjetoBeans.*" %>
<%@ page import="beans.Error" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <title> Modificar Datos Profesor </title>
      <link href="../../../../styles/estilosBotones.css" rel="stylesheet" type="text/css"/>
      <link href="../../../../styles/application.css" rel="stylesheet" type="text/css"/>
      <script language="JavaScript" src="../../../../script/overlib_mini.js"></script>
      
      <script language=JavaScript type="text/JavaScript">        
          function lanzaFormulario (evento) {
            document.formSubmenu.evento.value = evento;
            document.formSubmenu.submit();
          };      
      </script> 
      
  </head>
   <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
   <body background="../../../../img/fondo.jpg">
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
          <font face="Trebuchet MS" color="#006699" point-size="5"><b>Modificar datos de profesor</b></font>                
    	   </div> 
         <div align="right" style="position:relative; top:-5px">               
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
    		  <div align="right" style="position:relative; z-index:-1; top:5px;">
    		    <form method=post action="/virtuaula/ServletVisualizador" name="formSubmenu">
    		      <input type="hidden" name="evento">
    	  			<div class="botonesSubMenu">
    	  			  <a href="JavaScript:lanzaFormulario('menuPrincipalSec');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver al men� principal'; overlib('Pulse aqu� si desea volver al men� principal'); return true;">Volver al men� principal</a>
                        <a href="JavaScript:lanzaFormulario('GES_PROF');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Volver a gesti�n de profesor'; overlib('Pulse aqu� si desea volver a gesti�n de profesores'); return true;">Volver a gesti�n de profesores</a>
      					<a href="JavaScript:lanzaFormulario('desconectar');" onmouseout="window.status=''; nd(); return true;" onmouseover="window.status='Salir'; overlib('Pulse aqu� si desea salir de la aplicaci�n'); return true;"><font color="#660000">Salir</font></a>
    				  </div>
    				</form>
    		  </div>
    		<div style="position:relative; top:-16px; z-index:-1;">
    			 <table width="983px" border="0" cellspacing="0" cellpadding="0">
    		         <tr>
    				    <td class="lineaSep"></td>
    		         </tr>
    			 </table>
    		</div>
    		<div style="position:relative; left:10px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E" point-size="5"><b>Modifique los campos del profesor (paso 3/4)</b></font>                
    		</div>
    		<div style="position:relative; left:20px; top:15px; z-index:-1;">
    			<font face="Trebuchet MS" color="#616D7E">
    			   Cambie los datos que desee del profesor que quiere modificar<br>
    			   Aseg�rese que el tel�fono es un dato num�rico<br>
    			   Pulse el bot�n "Modificar" para que los cambios queden registrados
    			</font>
    		</div>
    		<div style="position:relative; top:40px; left:150px; z-index:-1;">
    			<form method=post action="/virtuaula/ServletVisualizador">
              <table border="0" cellspacing="0" cellpadding="10">
              	<%
                    HttpSession sesion=request.getSession();
                    ListaObjetoBean listaObjetoBean =((ListaObjetoBean)sesion.getAttribute("RdoControlador"));
                    Integer posicionLista =((Integer)sesion.getAttribute("posProf"));
                    int posi=posicionLista.intValue();
                  	ObjetoBean profesor=listaObjetoBean.dameObjeto(posi);	

                  %>                  		
        				<tr>        					        					
        					<td class="FormLiteral">Nombre</td>
        					<td><input type="text" class="FormTxt" name="NOMBRE" value="<%=profesor.dameValor("NOMBRE")%>"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Primer Apellido</td>
        					<td><input type="text" class="FormTxt" maxlength="40" name="APELLIDO1" value="<%=profesor.dameValor("APELLIDO1")%>"></td>
        					<td></td>
        					<td class="FormLiteral">Segundo Apellido</td>
        					<td><input type="text" class="FormTxt" maxlength="40" name="APELLIDO2" value="<%=profesor.dameValor("APELLIDO2")%>"></td>
        				</tr>
        				<tr>
        					<td class="FormLiteral">Telefono</td>
        					<td><input type="text" class="FormTxt" maxlength="9" name="TELEFONO" value="<%=profesor.dameValor("TELEFONO")%>"></td>
        					<td></td>
        					<td class="FormLiteral">Correo electr�nico</td>
        					<td><input type="text" class="FormTxt" maxlength="50" name="EMAIL" value="<%=profesor.dameValor("EMAIL")%>"></td>
        				</tr>
        				<tr>
        				</tr>
              			<tr>
					         <td colspan="7" align="center">
					          <input type="hidden" name="idBean" value="Profesor">
					          <input type="hidden" name="evento" value="EDITA_PROF">
					             <button type="submit" class="botonSimple">Modificar</button>
					         </td>
				        </tr>	                       				
        			</table>
        			<table>
        			<%HttpSession sesion2=request.getSession();
ListaObjetoBean lista=(ListaObjetoBean)sesion2.getAttribute("error");%>
<% 
if (lista != null) 
{
int numeroElementos = lista.tamanio();
for (int i=0; i < numeroElementos; i++)
{
Error error = (Error) lista.dameObjeto(i);
%>
<tr class="error">
<td width="34%" align="left" height="18" bordercolor="#800000" bgcolor="#FFFFFF">  
<%= error.dameValor("CAUSA_ERROR")%>
</td>
</tr>
<%
}
}
%>        
	</table>
					<input type="hidden"  class="FormTxt"  maxlength="9" name="ISUSUARIO_DNI" value="<%=profesor.dameValor("ISUSUARIO_DNI")%>">
          </form>
    		</div>
	  </div>
	  <div id="overDiv" style="position:relative; visibility:hidden; z-index:1000; top:-100px; width:50px"></div>	    
   </body>
</html>
