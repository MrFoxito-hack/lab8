<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Actores</title>
</head>
<body>
<h1>Lista de Actores</h1>
<table border="1">
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Año de Nacimiento</th>
        <th>Premio Oscar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="actor" items="${actores}">
        <tr>
            <td>${actor.nombre}</td>
            <td>${actor.apellido}</td>
            <td>${actor.anoNacimiento}</td>
            <td><c:if test="${actor.premioOscar}">Sí</c:if><c:if test="${!actor.premioOscar}">No</c:if></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
