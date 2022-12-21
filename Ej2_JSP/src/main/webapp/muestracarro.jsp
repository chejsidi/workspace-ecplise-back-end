<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %> 
<%
session = request.getSession();
if(session.getAttribute("sHistorial") != null) {
	out.print("<h1>TU CARRO</h1>"); 
	HashMap<String, Integer> historialCompra = (HashMap<String, Integer>) session.getAttribute("sHistorial");
	out.print("<ul>");  
	for (String producto: historialCompra.keySet()) {
		out.println("<li><strong>" +  producto + "</strong>: " + historialCompra.get(producto) + " unidades </li>");
	}
	out.print("</ul>"); 
}
%>