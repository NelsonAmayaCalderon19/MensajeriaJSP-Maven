<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recibe Datos</title>
    </head>
    <body>
        <%
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String website = request.getParameter("website");
        String message = request.getParameter("message");
        %>
        <h1>Tu Nombre es:</h1><h3><%= nombre%> </h3>
        <h1>Tu Email es:</h1><h3><%= email%> </h3>
        <h1>Yu Sitio Web es:</h1><h3><%= website%></h3>
        <h1>Cuerpo del Mensaje:</h1><h3><%= message%></h3><br>
        <a href="formulario.jsp">Volver</a>
    </body>
</html>
