<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Detalles de la Película</title>
</head>
<body>
<h1>Detalles de la Película</h1>
<p><strong>Título:</strong> ${pelicula.titulo}</p>
<p><strong>Director:</strong> ${pelicula.director}</p>
<p><strong>Año de Publicación:</strong> ${pelicula.anoPublicacion}</p>
<p><strong>Rating:</strong> ${pelicula.rating}</p>
<p><strong>Box Office:</strong> ${pelicula.boxOffice}</p>
<p><strong>Género:</strong> ${pelicula.idGenero}</p>
<a href="peliculas">Volver a la Lista de Películas</a>
</body>
</html>
