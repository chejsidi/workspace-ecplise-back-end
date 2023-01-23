<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TIENDA</title>
</head>
<body>
<h1 style='background-color:yellow;text-align:center;color:red;'>LÁMINAS</h1>
<c:if test="${cantInvalida != null}">  
        <h3 style='text-align:center;width: 10em;margin: auto;color:red;'>Cantidad Invalida</h3>
        <c:remove var="cantInvalida"/>
</c:if> 
	<form action="ServletAgregarLineaPedido" method="post">
	<table style='margin:auto;border: 1px solid yellow;'>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Cantidad</th>
			<th>Añadir</th> 
		</tr>
		<c:forEach items="${items}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.nombre}</td>
				<td>${item.precio}</td>
				<td><input type="number" id="cant" name="cant" placeholder="0"></td>
				<td><button type="submit" value="${item.id}" name="anadir" >Añadir al Carro</button></td>
			
			</tr>
		</c:forEach>
	</table>
	<div style='margin:auto; width: 14em;'>
		<input type="submit" name="registrarse" value="Registrarse">
		<input type="reset" name="reset" value="Reset"> 
	</div>
	</form>
</body>
</html>