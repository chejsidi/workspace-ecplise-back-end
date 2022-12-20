<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
							if(productoPulsado.equals(producto)) {
								if(session.getAttribute("sHistorial") != null) {
									historial = (HashMap<String, Integer>) session.getAttribute("sHistorial");
								}else {
									session.setAttribute("sHistorial", historial);
								} 
								if(historial.containsKey(producto)) {
									int cant = historial.get(producto);
									cant++;
									historial.put(producto, cant);
									session.setAttribute("sHistorial", historial);
									out.print("<td> "+cant+" unidades</td");
								}else {
									historial.put(producto, 1);
									session.setAttribute("sHistorial", historial);
									out.print("<td> 1 unidad</td");
								} 
							} 
						}
						out.print("<tr>");
					}
					
					
				}
			%>
			
		</table>
	</form>
</body>
</html>