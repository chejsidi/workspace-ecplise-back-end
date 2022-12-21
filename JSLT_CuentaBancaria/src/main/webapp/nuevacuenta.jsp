<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>nuevacuenta</title>
</head>
<body> 
	<%
		if() {
			
		}
	%>
	<form action="${pageContext.request.contextPath}/ServletNuevaCuenta" method="get"> 
		Titular:<input type="text" name="titular" required="required" /><br/> 
		Saldo inicial:<input type="number" name="saldoIni" required="required" /><br/> 
		<input type="submit" name="btn" value="Crear Cuenta Corriente"/> 
	</form>
</body>
</html>