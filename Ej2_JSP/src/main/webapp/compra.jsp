<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EJ2 JSP</title>
</head>
<body>
	<form action="compra.jsp" method="post">
		<table>
			<tr>
				<th>PRODUCTO</th>
				<th>PEDIR</th>
			</tr>
			<%
				session = request.getSession();
				HashMap<String, ArrayList<String>> mapa = (HashMap<String, ArrayList<String>>) session.getAttribute("sMapa");
				HashMap<String, Integer> historial = new HashMap<String, Integer>(); 
				for (String categoria: mapa.keySet()) {
					ArrayList<String> arrL = mapa.get(categoria);
					for (String producto : arrL) { 
						out.print("<tr>");
						out.print("<td>"+producto+"</td>");
						out.print("<td><button type='submit' name='btn' value='"+producto+"'>Adquirir unidad</button></td>"); 
						if(request.getParameter("btn") != null) {
							String productoPulsado = request.getParameter("btn");
							if(session.getAttribute("sHistorial") != null) {
								historial = (HashMap<String, Integer>) session.getAttribute("sHistorial");
							}else {
								session.setAttribute("sHistorial", historial);
							} 
							if(productoPulsado.equals(producto)) { 
								if(historial.containsKey(producto)) {
									int cant = historial.get(producto);
									cant++;
									historial.put(producto, cant);
									session.setAttribute("sHistorial", historial); 
								}else {
									historial.put(producto, 1);
									session.setAttribute("sHistorial", historial); 
								} 
							}
							if(historial.containsKey(producto)) {
								int cant = historial.get(producto);
								out.print("<td> "+cant+" unidades</td");
							}
						}
						out.print("<tr>");
					}
					
					
				}
			%>
			
		</table>
	</form>
	<%@include file="muestracarro.jsp"%>
</body>
</html>