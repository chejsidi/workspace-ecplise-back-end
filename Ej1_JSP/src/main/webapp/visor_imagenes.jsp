
<%@page import="java.io.IOException"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Path"%>
<%@page import="beans.Imagen"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%! private final static String nomCap = "img";
	public ArrayList<Imagen> imagenesDeCarpeta(String nomCap) throws IOException {
		String archivo = getServletContext().getRealPath(nomCap);
		File directorio = new File(archivo); 
		File[] list = directorio.listFiles(); 
		ArrayList<Imagen> imagenes = new ArrayList<Imagen>();
		String nombre, rutaImg, tamano, aux; 
		Path ruta;
		for (int i = 0; i < list.length; i++){
			if(!list[i].isDirectory()){
				try {
					rutaImg = list[i].getPath(); 
					nombre = list[i].getName();  
					Imagen img = new Imagen(rutaImg, nombre);
					tamano = img.tamanioDesglosado(rutaImg); 
					img.setTamano(tamano);
					imagenes.add(img);
				}
				finally{
					
				}
				
			}
		}
		return imagenes; 
	}
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css" media="screen">
      /*CSS*/
     <%@ include file="estilo.css" %>
</style>
<title>Insert title here</title>
</head>
<body>
	<form action="#" method="post">
		<table>
			<tr>
				<td>
					<label for="imagen">Imagen:</label> 
		    		<select name="imagen" id="imagen">
		    		<%  
		    	    	try {
		    	    		response.setContentType("text/html;ISO-8859-1");
			    			ArrayList<Imagen> imagenes = imagenesDeCarpeta(nomCap); 
			    			for (Imagen img: imagenes) {
			    				out.print("<option value=\"" + img.getNombre() + ";" + img.getTamano() + "\">" + img.getNombre().substring(0, img.getNombre().lastIndexOf('.')) + "</option>");
			    			} 
			    			//imagenes.forEach((n) -> out.println("<option value=\"" + n.getNombre() + "\">" + n.getNombre() + "</option>"));
			    	    } catch (Exception ex) {
			    	        System.out.println("No furrula muy bn. " + ex.getMessage());
			    	    }
			    		
		    		%> 
		    		</select>
	    		</td>
	    		<td>
	    			<label>Tamaño:</label>
	    			<input type="radio" name="tamano" value="300">
					<label for="tamano">300 px</label>
					<input type="radio" name="tamano" value="400">
					<label for="tamano">400 px</label>
					<input type="radio" name="tamano" value="500">
					<label for="tamano">500 px</label>
	    		</td>
	    		<td>
	    		<input type='submit' name='btn' value='VER IMAGEN'>
	    		</td> 
			</tr>
		</table>
	</form>
	
	<%
		if(request.getParameter("btn") != null) {
			if(request.getParameter("tamano") == null) {
				out.print("<p class=\"error centrar\"> SELECCIONE UN TAMAÑO PARA VISUALIZAR LA IMAGEN");
			}else {
				String tamano = (String) request.getParameter("tamano");
				String nomYtam = (String) request.getParameter("imagen"); 
				String partes[] = nomYtam.split(";");
				String nomImg = partes[0];
				String tamDesglosado = partes[1]; 
				out.print("<p class=\"centrar\"><strong>Tamaño</strong> "+ tamDesglosado +"<p>");
				out.println("<img class=\"centrar\" src=\""+nomCap+"/"+nomImg+"  \" width=\""+tamano+"\" />");
			}
		}
		
		
	%>
</body>
</html>