<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SUPER LARGO</title>
</head>
<body>
	<h1 style='background-color:yellow;text-align:center;'>LOGIN</h1>
	<form action="ServletLogin" method="post">
	<table style='margin:auto;border: 1px solid yellow;'>
	<tr>
		<td>Usuario</td>
		<td><input type="text" id="user" name="user"></td>
	</tr>
	<tr>
		<td>Contraseña</td>
		<td><input type="password" id="contra" name="contra"></td>
	</tr>
	</table>
	<div style='margin:auto; width: 14em;'>
		<input type="submit" name="login" value="Login">
		<input type="reset" name="reset" value="Reset">
		<a href="registro.jsp" >REGISTRARSE</a>
	</div>
	</form>
	<c:if test="${userInvalido != null}"> 
		<script type="text/javascript">
			alert("Login Incorrecto");
		</script>
        <h3 style='text-align:center;width: 3em;margin: auto;color:red;'>INCORRECTO</h3>
        <c:remove var="userInvalido"/>
   	</c:if> 
   	<c:if test="${userValido != null}"> 
	   	<h3 style='text-align:center;width: 3.5em;margin: auto;color:green;'>Cliente registrado</h3>
	   	<c:remove var="userValido"/>
   	</c:if> 
</body>
</html>