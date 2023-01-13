<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${devoluciones == null}"> 
            <jsp:forward page="ServletDevolver"/>
   	</c:if>
   	<c:forEach items="${devoluciones}" var="devolucion">
   		<p>${devolucion.tituloLibro}, ${devolucion.fecha} <a href="devoluciones.jsp?idlibro=${devolucion.idLibro}">MARCAR DEVOLUCION</a></p>
           
    </c:forEach>
</body>
</html>