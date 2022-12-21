<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>TEST</h1>
	<form method="post" action="/servlets/ProcesoPregunta">
	Nombre: <input type="text" name="nom"><br>
	¿Cuantas preguntas?: <input type="number" name="cantPreg"><br>
	Mostrar pistas: <input type="checkbox" name="mostrar"><br>
	<input type='submit' name='btn' value='COMENZAR'>
	</form>
	
	<%
	if(request.getParameter("btn") != null) {
		
	}
	%>
</body>
</html>