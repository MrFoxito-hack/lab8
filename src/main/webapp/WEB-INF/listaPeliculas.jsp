<%@ page import="com.example.lab8.beans.Pelicula" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%
    ArrayList<Pelicula> peliculas = (ArrayList<Pelicula>) request.getAttribute("peliculas");
%>
<html>
<head>
    <title>Lista de películas</title>
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
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        a {
            color: blue;
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="mb-3">Lista de películas</h1>
    <form action="peliculas" method="get" class="mb-4">
        <input type="text" name="search" placeholder="Buscar película..." />
        <button type="submit">Buscar</button>
    </form>

    <table class="table table-bordered">
        <tr>
            <th>Título</th>
            <th>Director</th>
            <th>Año Publicación</th>
            <th>Rating</th>
            <th>BoxOffice</th>
            <th>Género</th>
            <th>Actores</th>
            <th>Accionable</th>
        </tr>
        <% for (Pelicula pelicula : peliculas) { %>
        <tr>
            <!-- Haz que el título sea un enlace azul que redirige a DetallesServlet -->
            <td>
                <a href="detalles?id=<%= pelicula.getIdPelicula() %>" style="color: blue; text-decoration: underline;">
                    <%= pelicula.getTitulo() %>
                </a>
            </td>
            <td><%= pelicula.getDirector() %></td>
            <td><%= pelicula.getAnoPublicacion() %></td>
            <td><%= pelicula.getRating() %>/10</td>
            <td>$ <%= String.format("%,d", (int) pelicula.getBoxOffice()) %></td>
            <td><%= pelicula.getGenero() %></td>
            <td><a href="#" style="color: blue; text-decoration: underline;">Ver actores</a></td>
            <!-- Cambia el enlace de eliminación por un formulario POST -->
            <td>
                <form action="peliculas" method="post" style="display: inline;">
                    <input type="hidden" name="id" value="<%= pelicula.getIdPelicula() %>">
                    <button type="submit" style="background: none; border: none; color: blue; text-decoration: underline; cursor: pointer;">Eliminar</button>
                </form>
            </td>
        </tr>
        <% } %>
    </table>
</div>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
