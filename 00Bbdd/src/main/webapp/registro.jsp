<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
</head>
<body>
<h1 style='background-color:yellow;text-align:center;color:red;'>REGISTRO</h1>
	<form action="ServletRegistro" method="post">
	<table style='margin:auto;border: 1px solid yellow;'>
	<tr>
		<td>Usuario</td>
		<td><input type="text" id="user" name="user" required="required"></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" id="contra" name="contra" required="required"></td>
	</tr>
	<tr>
		<td>Domicilio</td>
		<td><input type="text" id="dom" name="dom" required="required"></td>
	</tr>
	<tr>
		<td>Zip</td>
		<td><input type="number" id="zip" name="zip" maxlength="5" required="required"></td>
	</tr>
	<tr>
		<td>Telefono</td>
		<td><input type="number" id="num" name="num" required="required"></td>
	</tr>
	<tr>
		<td>E-mail</td>
		<td><input type="email" id="email" name="email" required="required"></td>
	</tr>
	</table>
	<div style='margin:auto; width: 14em;'>
		<input type="submit" name="registrarse" value="Registrarse">
		<input type="reset" name="reset" value="Reset"> 
	</div>
	</form>
	<c:if test="${userInvalido != null}">  
        <h3 style='text-align:center;width: 10em;margin: auto;color:red;'>No se pudo registrar el usuario</h3>
        <c:remove var="userInvalido"/>
   	</c:if> 
</body>
</html>