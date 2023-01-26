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
        	<h2>IMPARTIDORES</h2>
        </div>
        <div id="container">
        	<h3><c:out value="${impartidor.getNombre()} ${impartidor.getApellido()}"></c:out></h3>
				<!-- Introduce el contenido de la pantalla de Impartidores -->
			<table> 
				<c:forEach items="${actImpartidas}" var="actividad">
						<tr>
							<td><c:out value="${actividad.getNombre()}"></c:out></td>
		 					<td><a hreflang="">ASISTENCIA</a></td>
						</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>