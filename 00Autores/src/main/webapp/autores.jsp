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
    <c:if test="${verLibrosDe != null}">
     <p>aaaa</p>
     
    </c:if>
    <c:if test="${autores.size() > 0}"> 
        	<h3>LISTA DE AUTORES</h3>
        	<table>
        		<tr>
        			<th>Nombre</th>
        			<th>Fecha de Nacimiento</th>
        			<th>Nacionalidad</th>
        			<th>Ver libros</th>
        		</tr>
        	
        	<c:forEach items="${autores}" var="autor">
            <tr>
            	<td>${autor.nombre}</td>
            	<td>${autor.fechanac}</td>
            	<td>${autor.nacionalidad}</td>
            	<td><a href="ServletPrincipal?verLibrosDe=${autor.id}&nombreAutor=${autor.nombre}">Ver Libros</a></td>
            </tr>
        </c:forEach>
        </table>
    </c:if>
    
    <h3>AÑADIR AUTOR</h3>
    <form action="ServletPrincipal" method="post">
		Nombre: <input type="text" name="nombre"><br>
		Fecha de nacimiento: <input type="date" name="nacimiento"><br>
		Nacionalidad: <input type="text" name="nacionalidad"><br>
		<input type="submit" name="insertar" value="AÑADIR AUTOR">
    
    </form>
    <p>${errorinsercion}</p>
    <c:if test="${libros != null}">
	    <h3>LIBROS DE ${autorActivo}</h3>
	    <c:forEach items="${libros}" var="libro">
	    	<ul>
	    		<li><a href="ServletPrincipal?tituloLibro=${libro}">${libro}</a></li>
	    	</ul>
	    </c:forEach>
    </c:if>
</body>
</html>