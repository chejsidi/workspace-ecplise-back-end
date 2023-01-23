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
   	<table>
   	
   	<c:forEach items="${devoluciones}" var="devolucion">
   	<c:choose>
	  <c:when test="${marcados != null}">
	  <c:choose>
	  	<c:when test="${ marcados.contains(devolucion.idPrestamo) }">
		    <tr>
		   		<td>${devolucion.tituloLibro}, ${devolucion.dias} días de prestado</td>
		   		<td><a href="ServletDevolver?idRevertir=${devolucion.idPrestamo}">REVERTIR DEVOLUCION</a></td>
		    </tr>
	    </c:when>
	    <c:otherwise>
		    <tr>
		   		<td>${devolucion.tituloLibro}, ${devolucion.dias} días de prestado</td>
		   		<td><a href="ServletDevolver?idDevolucion=${devolucion.idPrestamo}">MARCAR DEVOLUCION</a></td>
		    </tr>
	     </c:otherwise>
	    </c:choose>
	  </c:when> 
	  <c:otherwise>
	   	<tr>
	   		<td>${devolucion.tituloLibro}, ${devolucion.dias} días de prestado</td>
	   		<td><a href="ServletDevolver?idDevolucion=${devolucion.idPrestamo}">MARCAR DEVOLUCION</a></td>
	    </tr>
	  </c:otherwise>
	</c:choose>

    </c:forEach>
    </table>
    <c:if test="${contDev != null && contDev != 0}"> 
            <p><strong><a href="ServletDevolver?grabarDev=true">GRABAR DEVOLUCIONES (${contDev} libros)</a></strong></p>
   	</c:if> 
</body>
</html>