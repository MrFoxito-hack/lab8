<%@ page import="com.example.lab8.beans.Pelicula" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
%>
<html>
<head>
    <title>Detalles de la Película</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          integrity="sha384-rbsA2VBKQb3jIYfc4fMpm4MSU7F19Pja8qFBztfALJp/hAFAw2UrtopHkzE6x2Ed" crossorigin="anonymous">
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="mb-3">Película Número <%= pelicula.getIdPelicula() %></h1>
    <button class="btn btn-secondary mb-3">Guardar Película</button>

    <table class="table table-bordered">
        <tr>
            <th>Título</th>
            <td><%= pelicula.getTitulo() %></td>
        </tr>
        <tr>
            <th>Director</th>
            <td><%= pelicula.getDirector() %></td>
        </tr>
        <tr>
            <th>Año Publicación</th>
            <td><%= pelicula.getAnoPublicacion() %></td>
        </tr>
        <tr>
            <th>Rating</th>
            <td><%= pelicula.getRating() %>/10</td>
        </tr>
        <tr>
            <th>BoxOffice</th>
            <td>$ <%= String.format("%,d", (int) pelicula.getBoxOffice()) %></td>
        </tr>
        <tr>
            <th>Actores</th>
            <td><a href="#" style="color: blue; text-decoration: underline;">Ver Actores</a></td>
        </tr>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
