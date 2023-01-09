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
    <c:if test="${autores != null}"> 
        	<h3>Lista de Autores</h3>
    </c:if>
</body>
</html>