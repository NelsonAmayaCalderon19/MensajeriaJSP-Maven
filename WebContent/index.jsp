<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Primer JSP</title>
</head>
<body>
<%!
int tabla = 5;
String nombre = "Nelson";%>
Primer Mensaje : <%= nombre %>
<% tabla = tabla + 5;
out.println("El Resultado es: " + tabla);%>
<br>
<a href="formulario.jsp">Ir al Formulario</a>

</body>
</html>