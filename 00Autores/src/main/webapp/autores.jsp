<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AUTORES</title>
</head>
<body>
	<c:if test="${autores == null}"> 
            <jsp:forward page="ServletPrincipal"/>
    </c:if>
    <c:if test="${autores.size() > 0}"> 
        	<h3>Lista de Autores</h3>
    </c:if>
    
    <h3>AÑADIR AUTOR</h3>
    <form action="ServletPrincipal" method="post">
		Nombre: <input type="text" name="nombre"><br>
		Fecha de nacimiento: <input type="date" name="nacimiento"><br>
		Nacionalidad: <input type="text" name="nacionalidad"><br>
		<input type="submit" name="insertar" value="AÑADIR AUTOR">
    
    </form>
</body>
</html>