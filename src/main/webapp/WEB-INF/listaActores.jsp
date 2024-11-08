<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Actores</title>
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
    </style>
</head>
<body>
<div class="container">
    <h1 class="mb-3">Lista de Actores</h1>

    <table class="table table-bordered">
        <tr>
            <th>idActor</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Año Nacimiento</th>
            <th>Ganador Premio Oscar</th>
        </tr>
        <c:forEach var="actor" items="${actores}">
            <tr>
                <td>${actor.idActor}</td>
                <td>${actor.nombre}</td>
                <td>${actor.apellido}</td>
                <td>${actor.anoNacimiento}</td>
                <td>${actor.premioOscar ? "Sí" : "No"}</td>
            </tr>
        </c:forEach>
    </table>

    <form action="crearActor" method="get">
        <button type="submit" class="btn btn-primary">Crear Actor</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
