<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Películas</title>
</head>
<body>
<h1>Lista de Películas</h1>
<table border="1">
    <thead>
    <tr>
        <th>Título</th>
        <th>Director</th>
        <th>Año de Publicación</th>
        <th>Rating</th>
        <th>Box Office</th>
        <th>Género</th>
        <th>Detalles</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="pelicula" items="${peliculas}">
        <tr>
            <td>${pelicula.titulo}</td>
            <td>${pelicula.director}</td>
            <td>${pelicula.anoPublicacion}</td>
            <td>${pelicula.rating}</td>
            <td>${pelicula.boxOffice}</td>
            <td>${pelicula.idGenero}</td>
            <td><a href="detalles?id=${pelicula.idPelicula}">Ver Detalles</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
