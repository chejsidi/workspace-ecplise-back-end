<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF8">
		<title>LOGIN</title>
		<link rel="stylesheet" type="text/css" href="css/estilos.css"/>
	</head>
	<body>
		<div id="header">
            <h1>APLICACIÓN ACTIVIDADES</h1>
        </div>
        <div id=menu>
        	<h2>ALUMNOS</h2>
        </div>
        <div id="container">
        	<!-- Introduce el contenido de la pantalla de Alumnos -->
        	<h3>SOCIO: <c:out value="${alumno.getNombre()} ${alumno.getApellidos()}"></c:out></h3>
        	<h3>ACTIVIDADES ASIGNADAS</h3>
			<table>
				<tr>
					<th>ACTIVIDAD</th>
					<th>PRECIO</th>
					<th>IMPARTIDOR</th> 
				</tr>
				<c:forEach items="${actParticipa}" var="actividad">
					<tr>
						<td><c:out value="${actividad.getNombre()}"></c:out></td>
						<td><c:out value="${actividad.getCoste_mensual()}"></c:out>&euro;</td>
						<td><c:out value="${actividad.getImpartidor().getNombre()} ${actividad.getImpartidor().getApellido()}"></c:out></td> 
					</tr>
				</c:forEach>
			</table>
			<h3>NUEVAS INSCRIPCIONES</h3>
			<table>
				<tr>
					<th>ACTIVIDAD</th>
					<th>IMPARTIDOR</th>
					<th>APUNTARSE</th> 
				</tr>
				<c:forEach items="${actNoParticipa}" var="actividad">
					<c:choose>
						<c:when test = "${actClicadas.contains(actividad.getId())}">
							<tr style="background-color:yellow;">
								<td><c:out value="${actividad.getNombre()}"></c:out></td>
								<td><c:out value="${actividad.getImpartidor().getNombre()} ${actividad.getImpartidor().getApellido()}"></c:out></td>
								<td><a href="ServletInscripcion?idActElim=${actividad.getId()}">ANULAR</a></td>
							</tr>
						</c:when>
						<c:otherwise>
				            <tr>
								<td><c:out value="${actividad.getNombre()}"></c:out></td>
								<td><c:out value="${actividad.getImpartidor().getNombre()} ${actividad.getImpartidor().getApellido()}"></c:out></td>
								<td><a href="ServletInscripcion?idAct=${actividad.getId()}">APUNTARSE</a></td>
							</tr>
				        </c:otherwise>
					</c:choose>
				</c:forEach>
				<c:remove var="actNoParticipa"/>
				<c:remove var="actParticipa"/>
			</table>
			<c:if test="${actClicadas != null && actClicadas.size() > 0}">
			<p style="color:blue;"><a href="ServletInscripcion?confirmado=true">GUARDAR LAS <c:out value="${actClicadas.size()}"></c:out> NUEVAS INSCRIPCIONES</a></p>
		</c:if>
		</div>
	</body>
</html>